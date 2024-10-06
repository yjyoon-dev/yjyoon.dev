package dev.yjyoon.hello.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

val lightColorTheme = lightColorScheme(
    primary = KotlinBlue,
    onPrimary = KotlinWhite,
    primaryContainer = KotlinWhite,
    onPrimaryContainer = KotlinDarkGray,
    surfaceVariant = KotlinWhite,
    secondary = KotlinRed,
    onSecondary = KotlinWhite,
    background = KotlinWhite,
    onBackground = KotlinDarkGray,
    surface = KotlinWhite,
    onSurface = KotlinDarkGray
)

val darkColorTheme = darkColorScheme(
    primary = KotlinPurple,
    onPrimary = KotlinWhite,
    primaryContainer = KotlinDarkGray,
    onPrimaryContainer = KotlinWhite,
    surfaceVariant = KotlinGray,
    secondary = KotlinRed,
    onSecondary = KotlinWhite,
    background = KotlinDarkGray,
    onBackground = KotlinWhite,
    surface = KotlinGray,
    onSurface = KotlinWhite
)

@Composable
fun KotlinTheme(
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (isDarkTheme) darkColorTheme else lightColorTheme,
        typography = PretendardTypography(),
        content = content
    )
}
