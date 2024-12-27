package dev.yjyoon.hello.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val lightColorTheme = lightColorScheme(
    primary = YjyoonBlue,
    onPrimary = YjyoonWhite,
    primaryContainer = YjyoonWhite,
    onPrimaryContainer = YjyoonDarkGray,
    secondaryContainer = YjyoonDarkGray,
    onSecondaryContainer = YjyoonWhite,
    surfaceVariant = YjyoonWhite,
    secondary = YjyoonRed,
    onSecondary = YjyoonWhite,
    background = YjyoonWhite,
    onBackground = YjyoonDarkGray,
    surface = YjyoonGray,
    onSurface = YjyoonWhite
)

val darkColorTheme = darkColorScheme(
    primary = YjyoonPurple,
    onPrimary = YjyoonWhite,
    primaryContainer = YjyoonDarkGray,
    onPrimaryContainer = YjyoonWhite,
    secondaryContainer = YjyoonGray,
    onSecondaryContainer = YjyoonWhite,
    surfaceVariant = YjyoonGray,
    secondary = YjyoonRed,
    onSecondary = YjyoonWhite,
    background = YjyoonDarkGray,
    onBackground = YjyoonWhite,
    surface = YjyoonDarkGray,
    onSurface = YjyoonWhite
)

@Composable
fun YjyoonTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (isDarkTheme) darkColorTheme else lightColorTheme,
        typography = PretendardTypography(),
        content = content
    )
}
