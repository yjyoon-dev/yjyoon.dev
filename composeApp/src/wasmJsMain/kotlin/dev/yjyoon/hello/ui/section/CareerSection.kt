package dev.yjyoon.hello.ui.section

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yjyoon.hello.ui.component.AnimatedContent
import dev.yjyoon.hello.ui.component.AnimatedContentWithDelay
import dev.yjyoon.hello.ui.component.LogoButton
import dev.yjyoon.hello.ui.component.SectionColumn
import dev.yjyoon.hello.ui.component.Stepper
import dev.yjyoon.hello.ui.component.TagText
import dev.yjyoon.hello.ui.model.Career
import dev.yjyoon.hello.ui.state.DeviceState
import dev.yjyoon.hello.ui.state.isMobile
import dev.yjyoon.hello.ui.state.isPc
import dev.yjyoon.hello.ui.state.rememberDeviceState
import dev.yjyoon.hello.ui.theme.ItemSpacing
import dev.yjyoon.hello.ui.theme.PcContentWidth
import org.jetbrains.compose.resources.stringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.section_career

@Composable
fun CareerSection(modifier: Modifier = Modifier) {
    val deviceState = rememberDeviceState()

    SectionColumn(
        modifier = modifier,
        deviceState = deviceState
    ) {
        AnimatedContent(
            orientation = Orientation.Horizontal,
            inverseSlide = true,
            modifier = Modifier.padding(bottom = 48.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                Text(
                    stringResource(Res.string.section_career),
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 36.sp
                )
            }
        }
        Column(modifier = Modifier.width((PcContentWidth.value / 2).dp)) {
            Career.entries.forEachIndexed { index, career ->
                AnimatedContentWithDelay(
                    delayIndex = index + 1,
                    baseDelay = 300
                ) {
                    CareerStep(
                        career = career,
                        isFirst = index == 0,
                        isLast = index == Career.entries.lastIndex,
                        deviceState = deviceState
                    )
                }
            }
        }
    }
}

@Composable
private fun CareerStep(
    career: Career,
    isFirst: Boolean,
    isLast: Boolean,
    deviceState: DeviceState,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.Top
    ) {
        if (deviceState.isPc) {
            TagText(
                text = career.startDate,
                textColor = MaterialTheme.colorScheme.onPrimary,
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp,
                height = TAG_TEXT_HEIGHT,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(top = (CAREER_LOGO_SIZE - CAREER_DOT_SIZE) / 2)
            )
            Spacer(Modifier.width(24.dp))
        }
        Stepper(
            dotSize = CAREER_DOT_SIZE,
            frontHeight = (TAG_TEXT_HEIGHT - CAREER_DOT_SIZE) / 2 + (CAREER_LOGO_SIZE - CAREER_DOT_SIZE) / 2 - 8.dp,
            rearHeight = if (isLast) 192.dp else 224.dp,
            isHead = isFirst
        )
        Spacer(Modifier.width(24.dp))
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                LogoButton(
                    logoRes = career.logoRes,
                    url = career.url,
                    size = CAREER_LOGO_SIZE
                )
                if (deviceState.isMobile) {
                    Spacer(Modifier.width(24.dp))
                    TagText(
                        text = career.startDate,
                        textColor = MaterialTheme.colorScheme.onPrimary,
                        fontWeight = FontWeight.Medium,
                        fontSize = 13.sp,
                        height = TAG_TEXT_HEIGHT,
                        color = MaterialTheme.colorScheme.primary,
                        inverse = true
                    )
                }
            }
            Spacer(Modifier.height(ItemSpacing))
            Text(
                text = stringResource(career.positionRes),
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(0.75f),
                fontWeight = FontWeight.Medium,
                fontSize = 20.sp
            )
            Spacer(Modifier.height(4.dp))
            Text(
                text = stringResource(career.teamRes),
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(0.8f),
                fontWeight = FontWeight.Medium,
                fontSize = 15.sp
            )
            Text(
                text = stringResource(career.descriptionRes),
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(0.8f),
                fontWeight = FontWeight.Normal,
                fontSize = 15.sp
            )
        }
    }
}

private val TAG_TEXT_HEIGHT = 28.dp
private val CAREER_DOT_SIZE = 24.dp
private val CAREER_LOGO_SIZE = 128.dp
