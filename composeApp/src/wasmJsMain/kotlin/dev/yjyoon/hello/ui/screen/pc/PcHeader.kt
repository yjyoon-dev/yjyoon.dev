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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
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
import dev.yjyoon.hello.ui.model.Section
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.ic_light_mode
import yjyoondev.composeapp.generated.resources.img_logo_black

@Composable
fun PcHeader(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.then(
            Modifier
                .fillMaxWidth()
                .height(HEADER_HEIGHT.dp)
                .padding(horizontal = CONTENT_HORIZONTAL_PADDING.dp)
        ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(Res.drawable.img_logo_black),
            contentDescription = null,
            modifier = Modifier.height(24.dp)
        )
        Spacer(Modifier.weight(1f))
        Row(
            horizontalArrangement = Arrangement.spacedBy(48.dp)
        ) {
            Section.entries.forEach {
                TextButton(
                    onClick = {}
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
        IconButton(onClick = {}) {
            Icon(
                painterResource(Res.drawable.ic_light_mode),
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(Modifier.width(24.dp))
        IconButton(onClick = {}) {
            Icon(
                Icons.Default.Share,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

private const val HEADER_HEIGHT = 72