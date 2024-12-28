package dev.yjyoon.hello.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import dev.yjyoon.hello.ui.LocalThemeMode
import dev.yjyoon.hello.ui.ThemeMode
import dev.yjyoon.hello.ui.screen.PC_CONTENT_WIDTH
import org.jetbrains.compose.resources.painterResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.img_logo_black
import yjyoondev.composeapp.generated.resources.img_logo_black_large
import yjyoondev.composeapp.generated.resources.img_logo_white
import yjyoondev.composeapp.generated.resources.img_logo_white_large


@Composable
fun LogoImage(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val isLarge = with(density) { PC_CONTENT_WIDTH.dp.toPx() >= 1920f }
    val logoRes = when (LocalThemeMode.current) {
        ThemeMode.Light -> if (isLarge) {
            Res.drawable.img_logo_black_large
        } else {
            Res.drawable.img_logo_black
        }

        ThemeMode.Dark -> if (isLarge) {
            Res.drawable.img_logo_white_large
        } else {
            Res.drawable.img_logo_white
        }
    }

    TextButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(logoRes),
            contentDescription = null,
            modifier = Modifier.fillMaxHeight()
        )
    }
}
