package dev.yjyoon.hello.ui.screen.pc

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yjyoon.hello.ui.LocalThemeMode
import dev.yjyoon.hello.ui.ThemeMode
import dev.yjyoon.hello.ui.model.Section
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.img_logo_black
import yjyoondev.composeapp.generated.resources.img_logo_white

@Composable
fun PcHeader(
    onThemeChanged: (ThemeMode) -> Unit,
    onSectionClicked: (Section) -> Unit,
    modifier: Modifier = Modifier
) {
    val themeMode = LocalThemeMode.current
    Row(
        modifier = modifier.then(
            Modifier.fillMaxWidth().padding(horizontal = 32.dp)
        ),
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .width(CONTENT_WIDTH.dp)
                .height(HEADER_HEIGHT.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            LogoImage(
                onClick = { onSectionClicked(Section.Home) },
                themeMode = themeMode
            )
            Spacer(Modifier.weight(1f))
            Row(
                horizontalArrangement = Arrangement.spacedBy(48.dp)
            ) {
                Section.entries.forEach {
                    TextButton(
                        onClick = { onSectionClicked(it) }
                    ) {
                        Text(
                            text = stringResource(it.title),
                            color = MaterialTheme.colorScheme.onBackground,
                            fontSize = 15.sp
                        )
                    }
                }
            }
            Spacer(Modifier.weight(1f))
            IconButton(onClick = { onThemeChanged(themeMode.toggle()) }) {
                Icon(
                    painterResource(themeMode.iconRes),
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.primary,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
private fun LogoImage(
    themeMode: ThemeMode,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val logoRes = when (themeMode) {
        ThemeMode.Light -> Res.drawable.img_logo_black
        ThemeMode.Dark -> Res.drawable.img_logo_white
    }
    TextButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(logoRes),
            contentDescription = null,
            modifier = Modifier.height(24.dp)
        )
    }
}

private const val HEADER_HEIGHT = 72
