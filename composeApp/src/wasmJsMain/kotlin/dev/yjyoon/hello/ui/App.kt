package dev.yjyoon.hello.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import dev.yjyoon.hello.ui.model.ThemeMode
import dev.yjyoon.hello.ui.screen.MainScreen
import dev.yjyoon.hello.ui.theme.KotlinTheme

@Composable
fun App() {
    var screenSize by remember { mutableStateOf(ScreenSize()) }
    val isSystemInDarkTheme = isSystemInDarkTheme()
    var themeMode by remember { mutableStateOf(if (isSystemInDarkTheme) ThemeMode.Dark else ThemeMode.Light) }

    Layout(
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                CompositionLocalProvider(LocalScreenSize provides screenSize) {
                    KotlinTheme(isDarkTheme = themeMode == ThemeMode.Dark) {
                        MainScreen(
                            themeMode = themeMode,
                            onThemeChanged = { themeMode = it }
                        )
                    }
                }
            }
        },
        measurePolicy = { measurables, constraints ->
            val width = constraints.maxWidth
            val height = constraints.maxHeight

            screenSize = ScreenSize(width, height)

            val placeables = measurables.map { measurable ->
                measurable.measure(constraints)
            }

            layout(width, height) {
                var yPosition = 0
                placeables.forEach { placeable ->
                    placeable.placeRelative(x = 0, y = yPosition)
                    yPosition += placeable.height
                }
            }
        }
    )
}
