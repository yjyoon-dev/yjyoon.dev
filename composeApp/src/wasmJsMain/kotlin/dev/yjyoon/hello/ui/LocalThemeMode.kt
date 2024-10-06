package dev.yjyoon.hello.ui

import androidx.compose.runtime.compositionLocalOf
import org.jetbrains.compose.resources.DrawableResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.ic_dark_mode
import yjyoondev.composeapp.generated.resources.ic_light_mode

enum class ThemeMode(
    val iconRes: DrawableResource
) {
    Light(Res.drawable.ic_light_mode),
    Dark(Res.drawable.ic_dark_mode);

    fun toggle(): ThemeMode = when (this) {
        Light -> Dark
        Dark -> Light
    }
}

val LocalThemeMode = compositionLocalOf { ThemeMode.Light }
