package dev.yjyoon.hello.ui.screen.pc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.yjyoon.hello.ui.ThemeMode
import dev.yjyoon.hello.ui.screen.pc.section.AboutSection
import dev.yjyoon.hello.ui.screen.pc.section.CareerSection
import dev.yjyoon.hello.ui.screen.pc.section.ExperienceSection
import dev.yjyoon.hello.ui.screen.pc.section.HomeSection
import kotlinx.coroutines.launch

@Composable
fun PcScreen(
    onThemeChanged: (ThemeMode) -> Unit,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    Scaffold(
        topBar = {
            PcTopBar(
                onThemeChanged = onThemeChanged,
                onSectionClicked = {
                    scope.launch {
                        listState.animateScrollToItem(it.ordinal)
                    }
                }
            )
        }
    ) { innerPadding ->
        LazyColumn(
            state = listState,
            modifier = modifier.then(
                Modifier
                    .padding(innerPadding)
                    .background(color = MaterialTheme.colorScheme.background)
                    .fillMaxSize()
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item { HomeSection() }
            item { AboutSection() }
            item { CareerSection() }
            item { ExperienceSection() }
        }
    }
}

const val CONTENT_HORIZONTAL_PADDING = 128
const val CONTENT_WIDTH = 1280