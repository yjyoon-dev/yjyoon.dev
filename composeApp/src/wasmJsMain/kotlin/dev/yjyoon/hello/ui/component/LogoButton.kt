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
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.yjyoon.hello.ui.ThemeMode
import dev.yjyoon.hello.ui.theme.KotlinLightGray
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun LogoButton(
    logoRes: DrawableResource,
    url: String,
    size: Dp,
    theme: ThemeMode,
    modifier: Modifier = Modifier,
    cornerRadius: Dp = 32.dp,
    contentPadding: PaddingValues = PaddingValues(12.dp)
) {
    val uriHandler = LocalUriHandler.current

    if (theme == ThemeMode.Light) {
        Surface(
            shape = RoundedCornerShape(cornerRadius),
            color = MaterialTheme.colorScheme.background,
            modifier = modifier.then(
                Modifier
                    .size(size)
                    .shadow(
                        elevation = 24.dp,
                        shape = RoundedCornerShape(cornerRadius),
                        clip = false,
                        ambientColor = KotlinLightGray.copy(0.01f),
                        spotColor = KotlinLightGray.copy(0.01f)
                    )
            ),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.background)
                    .clip(RoundedCornerShape(cornerRadius))
                    .clickable { uriHandler.openUri(url) },
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
    } else {
        Card(
            onClick = { uriHandler.openUri(url) },
            shape = RoundedCornerShape(cornerRadius),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            colors = CardDefaults.outlinedCardColors(
                containerColor = MaterialTheme.colorScheme.surface,
                contentColor = MaterialTheme.colorScheme.onSurface
            ),
            modifier = modifier.then(Modifier.size(size))
        ) {
            Box(
                modifier = Modifier.fillMaxSize(),
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
    }
}
