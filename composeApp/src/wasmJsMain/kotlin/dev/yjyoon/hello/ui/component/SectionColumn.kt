package dev.yjyoon.hello.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.yjyoon.hello.ui.LocalThemeMode
import dev.yjyoon.hello.ui.ThemeMode
import dev.yjyoon.hello.ui.screen.pc.CONTENT_HORIZONTAL_PADDING
import dev.yjyoon.hello.ui.screen.pc.CONTENT_WIDTH
import dev.yjyoon.hello.ui.theme.KotlinTheme

@Composable
fun SectionColumn(
    modifier: Modifier = Modifier,
    inverseTheme: Boolean = false,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    contentPadding: PaddingValues = PaddingValues(
        horizontal = CONTENT_HORIZONTAL_PADDING.dp,
        vertical = 72.dp
    ),
    content: @Composable ColumnScope.() -> Unit
) {
    val themeMode = LocalThemeMode.current

    KotlinTheme(
        isDarkTheme = if (inverseTheme) themeMode != ThemeMode.Dark else themeMode == ThemeMode.Dark
    ) {
        Box(
            modifier = modifier.then(
                Modifier
                    .background(color = MaterialTheme.colorScheme.background)
                    .fillMaxWidth()
            ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .width(CONTENT_WIDTH.dp)
                    .padding(contentPadding),
                horizontalAlignment = horizontalAlignment,
                content = content
            )
        }
    }
}
