package dev.yjyoon.hello.ui.section


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yjyoon.hello.ui.component.AnimatedContent
import dev.yjyoon.hello.ui.component.AnimatedContentWithDelay
import dev.yjyoon.hello.ui.model.Contact
import dev.yjyoon.hello.ui.theme.MobileContentHorizontalPadding
import dev.yjyoon.hello.ui.theme.MobileContentVerticalPadding
import dev.yjyoon.hello.ui.theme.PcContentWidth
import dev.yjyoon.hello.ui.theme.YjyoonGray
import dev.yjyoon.hello.ui.theme.YjyoonWhite
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.copyright
import yjyoondev.composeapp.generated.resources.email
import yjyoondev.composeapp.generated.resources.section_contact

@Composable
fun FooterSection(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.then(
            Modifier
                .background(color = YjyoonGray)
                .fillMaxWidth()
        ),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .width(PcContentWidth)
                .padding(
                    horizontal = MobileContentHorizontalPadding,
                    vertical = MobileContentVerticalPadding
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedContent(
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(
                    stringResource(Res.string.section_contact),
                    color = YjyoonWhite.copy(0.4f),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            AnimatedContentWithDelay(
                delayIndex = 1,
                baseDelay = 300,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Contact.entries.forEach {
                        ContactButton(it)
                    }
                }
            }
            AnimatedContentWithDelay(
                delayIndex = 2,
                baseDelay = 300
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        stringResource(Res.string.copyright),
                        color = YjyoonWhite.copy(0.2f),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                    Text(
                        stringResource(Res.string.email),
                        color = YjyoonWhite.copy(0.2f),
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
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
            tint = YjyoonWhite.copy(0.3f),
            modifier = Modifier.size(36.dp)
        )
    }
}
