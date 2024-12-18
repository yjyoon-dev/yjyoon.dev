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
    secondaryContainer = KotlinDarkGray,
    onSecondaryContainer = KotlinWhite,
    surfaceVariant = KotlinWhite,
    secondary = KotlinRed,
    onSecondary = KotlinWhite,
    background = KotlinWhite,
    onBackground = KotlinDarkGray,
    surface = KotlinGray,
    onSurface = KotlinWhite
)

val darkColorTheme = darkColorScheme(
    primary = KotlinPurple,
    onPrimary = KotlinWhite,
    primaryContainer = KotlinDarkGray,
    onPrimaryContainer = KotlinWhite,
    secondaryContainer = KotlinGray,
    onSecondaryContainer = KotlinWhite,
    surfaceVariant = KotlinGray,
    secondary = KotlinRed,
    onSecondary = KotlinWhite,
    background = KotlinDarkGray,
    onBackground = KotlinWhite,
    surface = KotlinDarkGray,
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
