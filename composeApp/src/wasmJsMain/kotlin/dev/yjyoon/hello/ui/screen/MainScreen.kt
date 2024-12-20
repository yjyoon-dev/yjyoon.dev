package dev.yjyoon.hello.ui.screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.yjyoon.hello.ui.LocalScreenSize
import dev.yjyoon.hello.ui.ThemeMode
import dev.yjyoon.hello.ui.screen.mobile.MobileScreen
import dev.yjyoon.hello.ui.screen.pc.PcScreen


@Composable
fun MainScreen(
    onThemeChanged: (ThemeMode) -> Unit,
    modifier: Modifier = Modifier
) {
    val screenSize = LocalScreenSize.current
    if (screenSize.width <= MOBILE_SCREEN_WIDTH_THRESHOLD) {
        MobileScreen(
            onThemeChanged = onThemeChanged,
            modifier = modifier
        )
    } else {
        PcScreen(
            onThemeChanged = onThemeChanged,
            modifier = modifier
        )
    }
}

private const val MOBILE_SCREEN_WIDTH_THRESHOLD = 617
