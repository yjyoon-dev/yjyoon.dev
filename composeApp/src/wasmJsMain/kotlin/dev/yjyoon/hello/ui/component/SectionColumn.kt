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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.yjyoon.hello.ui.LocalThemeMode
import dev.yjyoon.hello.ui.ThemeMode
import dev.yjyoon.hello.ui.screen.MOBILE_CONTENT_HORIZONTAL_PADDING
import dev.yjyoon.hello.ui.screen.MOBILE_CONTENT_VERTICAL_PADDING
import dev.yjyoon.hello.ui.screen.PC_CONTENT_HORIZONTAL_PADDING
import dev.yjyoon.hello.ui.screen.PC_CONTENT_VERTICAL_PADDING
import dev.yjyoon.hello.ui.screen.PC_CONTENT_WIDTH
import dev.yjyoon.hello.ui.theme.KotlinTheme
import dev.yjyoon.hello.ui.util.DeviceUtil

@Composable
fun SectionColumn(
    modifier: Modifier = Modifier,
    isMobile: Boolean = DeviceUtil.isMobile(),
    backgroundColor: Color = MaterialTheme.colorScheme.primaryContainer,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    contentPadding: PaddingValues = if (isMobile) {
        mobileSectionPaddingValues
    } else {
        pcSectionPaddingValues
    },
    mobileContent: (@Composable ColumnScope.() -> Unit)? = null,
    content: (@Composable ColumnScope.() -> Unit)? = null
) {
    KotlinTheme(
        isDarkTheme = LocalThemeMode.current == ThemeMode.Dark
    ) {
        Box(
            modifier = modifier.then(
                Modifier
                    .background(color = backgroundColor)
                    .fillMaxWidth()
            ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .padding(contentPadding)
                    .then(if (isMobile) Modifier else Modifier.width(PC_CONTENT_WIDTH.dp)),
                horizontalAlignment = horizontalAlignment,
                content = mobileContent?.takeIf { isMobile } ?: content ?: {}
            )
        }
    }
}

private val pcSectionPaddingValues = PaddingValues(
    horizontal = PC_CONTENT_HORIZONTAL_PADDING.dp,
    vertical = PC_CONTENT_VERTICAL_PADDING.dp
)

private val mobileSectionPaddingValues = PaddingValues(
    horizontal = MOBILE_CONTENT_HORIZONTAL_PADDING.dp,
    vertical = MOBILE_CONTENT_VERTICAL_PADDING.dp
)
