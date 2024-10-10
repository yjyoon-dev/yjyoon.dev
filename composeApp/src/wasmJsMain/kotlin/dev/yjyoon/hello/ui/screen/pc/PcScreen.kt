package dev.yjyoon.hello.ui.screen.pc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.yjyoon.hello.ui.ThemeMode
import dev.yjyoon.hello.ui.screen.pc.section.AboutSection
import dev.yjyoon.hello.ui.screen.pc.section.CareerSection
import dev.yjyoon.hello.ui.screen.pc.section.HomeSection

@Composable
fun PcScreen(
    onThemeChanged: (ThemeMode) -> Unit,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()
    Column(
        modifier = modifier.then(
            Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .verticalScroll(scrollState)
                .fillMaxSize()
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        PcHeader(
            onThemeChanged = onThemeChanged
        )
        HomeSection()
        AboutSection()
        CareerSection()
    }
}

const val CONTENT_HORIZONTAL_PADDING = 128
const val CONTENT_WIDTH = 1280