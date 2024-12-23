package dev.yjyoon.hello.ui.component

import androidx.compose.foundation.Image
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import dev.yjyoon.hello.ui.LocalThemeMode
import dev.yjyoon.hello.ui.ThemeMode
import org.jetbrains.compose.resources.painterResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.img_logo_black
import yjyoondev.composeapp.generated.resources.img_logo_white


@Composable
fun LogoImage(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val logoRes = when (LocalThemeMode.current) {
        ThemeMode.Light -> Res.drawable.img_logo_black
        ThemeMode.Dark -> Res.drawable.img_logo_white
    }

    TextButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Image(
            painter = painterResource(logoRes),
            contentDescription = null
        )
    }
}
