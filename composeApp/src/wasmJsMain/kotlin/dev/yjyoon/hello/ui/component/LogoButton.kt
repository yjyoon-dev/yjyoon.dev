package dev.yjyoon.hello.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.yjyoon.hello.ui.LocalThemeMode
import dev.yjyoon.hello.ui.ThemeMode
import dev.yjyoon.hello.ui.theme.lightShadow
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun LogoButton(
    logoRes: DrawableResource,
    url: String,
    size: Dp,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 32.dp,
    contentPadding: PaddingValues = PaddingValues(12.dp),
    forceDarkTheme: Boolean = false
) {
    val themeMode = LocalThemeMode.current
    val uriHandler = LocalUriHandler.current
    val useLightTheme = themeMode == ThemeMode.Light && forceDarkTheme.not()

    if (useLightTheme) {
        Surface(
            shape = RoundedCornerShape(cornerRadius),
            color = MaterialTheme.colorScheme.primaryContainer,
            modifier = modifier.then(
                Modifier
                    .size(size)
                    .lightShadow(cornerRadius)
            ),
        ) {
            LogoContent(
                logoRes = logoRes,
                contentPadding = contentPadding,
                modifier = Modifier
                    .background(color = MaterialTheme.colorScheme.primaryContainer)
                    .clip(RoundedCornerShape(cornerRadius))
                    .clickable { uriHandler.openUri(url) }
            )
        }
    } else {
        Card(
            onClick = { uriHandler.openUri(url) },
            shape = RoundedCornerShape(cornerRadius),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            colors = CardDefaults.outlinedCardColors(
                containerColor = MaterialTheme.colorScheme.secondaryContainer,
                contentColor = MaterialTheme.colorScheme.onSecondaryContainer
            ),
            modifier = modifier.then(Modifier.size(size))
        ) {
            LogoContent(logoRes = logoRes, contentPadding = contentPadding)
        }
    }
}

@Composable
private fun LogoContent(
    logoRes: DrawableResource,
    contentPadding: PaddingValues,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(logoRes),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier.padding(contentPadding)
        )
    }
}
