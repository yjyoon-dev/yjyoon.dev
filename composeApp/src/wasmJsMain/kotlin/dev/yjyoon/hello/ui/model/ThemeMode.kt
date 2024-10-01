package dev.yjyoon.hello.ui.model

import dev.yjyoon.hello.ui.model.ThemeMode.Dark
import dev.yjyoon.hello.ui.model.ThemeMode.Light
import org.jetbrains.compose.resources.DrawableResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.ic_dark_mode
import yjyoondev.composeapp.generated.resources.ic_light_mode

enum class ThemeMode(
    val iconRes: DrawableResource
) {
    Light(Res.drawable.ic_light_mode),
    Dark(Res.drawable.ic_dark_mode)
    ;
}

fun ThemeMode.toggle(): ThemeMode {
    return when (this) {
        Light -> Dark
        Dark -> Light
    }
}
