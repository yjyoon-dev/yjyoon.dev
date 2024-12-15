package dev.yjyoon.hello.ui.screen.pc.section

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yjyoon.hello.ui.model.Contact
import dev.yjyoon.hello.ui.screen.pc.CONTENT_HORIZONTAL_PADDING
import dev.yjyoon.hello.ui.screen.pc.CONTENT_WIDTH
import dev.yjyoon.hello.ui.theme.KotlinGray
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.copyright
import yjyoondev.composeapp.generated.resources.section_contact

@Composable
fun FooterSection(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.then(
            Modifier
                .background(color = KotlinGray)
                .fillMaxWidth()
        ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .width(CONTENT_WIDTH.dp)
                .padding(
                    horizontal = CONTENT_HORIZONTAL_PADDING.dp,
                    vertical = 48.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                stringResource(Res.string.section_contact),
                color = Color.White.copy(0.4f),
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
            Spacer(Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Contact.entries.forEach {
                    ContactButton(it)
                }
            }
            Spacer(Modifier.height(16.dp))
            Text(
                stringResource(Res.string.copyright),
                color = Color.White.copy(0.2f),
                fontSize = 16.sp
            )
        }
    }
}

@Composable
private fun ContactButton(
    contact: Contact,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current

    TextButton(
        onClick = { uriHandler.openUri(contact.url) },
        modifier = modifier
    ) {
        Icon(
            painterResource(contact.iconRes),
            contentDescription = contact.name,
            tint = Color.White.copy(0.3f),
            modifier = Modifier.size(36.dp)
        )
    }
}
