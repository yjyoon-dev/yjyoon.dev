package dev.yjyoon.hello.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import dev.yjyoon.hello.ui.ThemeMode
import dev.yjyoon.hello.ui.component.ModalDrawerContent
import dev.yjyoon.hello.ui.component.TopHeader
import dev.yjyoon.hello.ui.component.TopMenuBar
import dev.yjyoon.hello.ui.model.Section
import dev.yjyoon.hello.ui.section.AboutSection
import dev.yjyoon.hello.ui.section.CareerSection
import dev.yjyoon.hello.ui.section.ExperienceSection
import dev.yjyoon.hello.ui.section.FooterSection
import dev.yjyoon.hello.ui.section.HomeSection
import dev.yjyoon.hello.ui.section.SideProjectSection
import dev.yjyoon.hello.ui.state.isMobile
import dev.yjyoon.hello.ui.state.rememberDeviceState
import kotlinx.coroutines.launch


@Composable
fun MainScreen(
    onThemeChanged: (ThemeMode) -> Unit,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val deviceState = rememberDeviceState()
    val listState = rememberLazyListState()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
        ModalNavigationDrawer(
            drawerContent = {
                CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                    ModalDrawerContent(
                        onClickItem = {
                            scope.launch {
                                drawerState.close()
                                listState.animateScrollToItem(it.ordinal)
                            }
                        },
                        onDismissRequest = {
                            scope.launch {
                                drawerState.close()
                            }
                        }
                    )
                }
            },
            drawerState = drawerState
        ) {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Ltr) {
                Scaffold(
                    topBar = {
                        Box {
                            TopHeader(
                                onThemeChanged = onThemeChanged,
                                onSectionClicked = {
                                    scope.launch {
                                        listState.animateScrollToItem(it.ordinal)
                                    }
                                },
                                modifier = Modifier.then(
                                    if (deviceState.isMobile) {
                                        Modifier.height(1.dp)
                                    } else {
                                        Modifier
                                    }
                                )
                            )
                            if (deviceState.isMobile) {
                                TopMenuBar(
                                    onTitleClick = {
                                        scope.launch {
                                            listState.animateScrollToItem(Section.Home.ordinal)
                                        }
                                    },
                                    onMenuClick = {
                                        scope.launch {
                                            drawerState.open()
                                        }
                                    },
                                    onThemeChanged = onThemeChanged
                                )
                            }
                        }
                    }
                ) { innerPadding ->
                    LazyColumn(
                        state = listState,
                        modifier = modifier.then(
                            Modifier
                                .padding(innerPadding)
                                .background(color = MaterialTheme.colorScheme.primaryContainer)
                                .fillMaxSize()
                        ),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        item { HomeSection() }
                        item { AboutSection() }
                        item { CareerSection() }
                        item { ExperienceSection() }
                        item { SideProjectSection() }
                        item { FooterSection() }
                    }
                }
            }
        }
    }
}

const val PC_CONTENT_HORIZONTAL_PADDING = 128
const val PC_CONTENT_VERTICAL_PADDING = 72
const val PC_CONTENT_WIDTH = 1280

const val MOBILE_CONTENT_HORIZONTAL_PADDING = 24
const val MOBILE_CONTENT_VERTICAL_PADDING = 48
