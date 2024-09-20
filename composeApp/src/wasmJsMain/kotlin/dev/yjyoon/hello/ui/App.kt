package dev.yjyoon.hello.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout
import dev.yjyoon.hello.ui.screen.MobileScreen
import dev.yjyoon.hello.ui.screen.PcScreen
import dev.yjyoon.hello.ui.theme.KotlinTheme

@Composable
fun App() {
    var screenSize by remember { mutableStateOf(ScreenSize()) }

    Layout(
        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                KotlinTheme {
                    if (screenSize.width <= MOBILE_SCREEN_WIDTH_THRESHOLD) {
                        MobileScreen()
                    } else {
                        PcScreen()
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

data class ScreenSize(val width: Int = 0, val height: Int = 0)

private const val MOBILE_SCREEN_WIDTH_THRESHOLD = 617
