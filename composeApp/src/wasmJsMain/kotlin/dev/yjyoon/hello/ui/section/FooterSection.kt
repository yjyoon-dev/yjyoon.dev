package dev.yjyoon.hello.ui.section

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
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
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yjyoon.hello.ui.component.defaultEnterAnim
import dev.yjyoon.hello.ui.model.Contact
import dev.yjyoon.hello.ui.screen.MOBILE_CONTENT_HORIZONTAL_PADDING
import dev.yjyoon.hello.ui.screen.MOBILE_CONTENT_VERTICAL_PADDING
import dev.yjyoon.hello.ui.screen.PC_CONTENT_WIDTH
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
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }

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
                .width(PC_CONTENT_WIDTH.dp)
                .padding(
                    horizontal = MOBILE_CONTENT_HORIZONTAL_PADDING.dp,
                    vertical = MOBILE_CONTENT_VERTICAL_PADDING.dp
                ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedVisibility(
                visibleState = visibleState,
                enter = defaultEnterAnim(),
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                Text(
                    stringResource(Res.string.section_contact),
                    color = YjyoonWhite.copy(0.4f),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            AnimatedVisibility(
                visibleState = visibleState,
                enter = defaultEnterAnim(delayMillis = 300),
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
            AnimatedVisibility(
                visibleState = visibleState,
                enter = defaultEnterAnim(delayMillis = 600)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        stringResource(Res.string.copyright),
                        color = YjyoonWhite.copy(0.2f),
                        fontSize = 16.sp
                    )
                    Text(
                        stringResource(Res.string.email),
                        color = YjyoonWhite.copy(0.2f),
                        fontSize = 16.sp
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
