package dev.yjyoon.hello.ui.section


import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yjyoon.hello.ui.component.LogoButton
import dev.yjyoon.hello.ui.component.SectionColumn
import dev.yjyoon.hello.ui.model.Awards
import dev.yjyoon.hello.ui.model.Certificate
import dev.yjyoon.hello.ui.model.Club
import dev.yjyoon.hello.ui.model.Device
import dev.yjyoon.hello.ui.model.Experience
import dev.yjyoon.hello.ui.model.Global
import dev.yjyoon.hello.ui.model.Mentor
import dev.yjyoon.hello.ui.model.Sharing
import dev.yjyoon.hello.ui.component.AnimatedContent
import dev.yjyoon.hello.ui.component.AnimatedContentWithDelay
import dev.yjyoon.hello.ui.theme.MobileContentVerticalPadding
import dev.yjyoon.hello.ui.theme.PcContentHorizontalPadding
import dev.yjyoon.hello.ui.theme.CardRadius
import dev.yjyoon.hello.ui.theme.ItemSpacing
import dev.yjyoon.hello.ui.theme.SectionSpacing
import dev.yjyoon.hello.ui.state.rememberDeviceState
import org.jetbrains.compose.resources.stringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.club_year
import yjyoondev.composeapp.generated.resources.experience_awards
import yjyoondev.composeapp.generated.resources.experience_sharing
import yjyoondev.composeapp.generated.resources.experience_certificates
import yjyoondev.composeapp.generated.resources.experience_development
import yjyoondev.composeapp.generated.resources.experience_for
import yjyoondev.composeapp.generated.resources.experience_global
import yjyoondev.composeapp.generated.resources.experience_mentor

@Composable
fun ExperienceSection(modifier: Modifier = Modifier) {
    val deviceState = rememberDeviceState()

    SectionColumn(
        deviceState = deviceState,
        modifier = modifier,
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        horizontalAlignment = Alignment.Start
    ) {
        AnimatedContent(
            modifier = Modifier.padding(bottom = SectionSpacing)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    stringResource(Res.string.experience_for),
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 36.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
        AnimatedContent(
            delayMillis = 200,
            orientation = Orientation.Horizontal,
            inverseSlide = true,
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(
                stringResource(Res.string.experience_development),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
        AnimatedContent(
            delayMillis = 400,
            modifier = Modifier.padding(bottom = 32.dp)
        ) {
            val (gridColumns, gridHeight) = when (deviceState.value) {
                Device.Mobile -> 1 to 344.dp
                Device.Pc -> 2 to 172.dp
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(gridColumns),
                modifier = Modifier.height(gridHeight),
                horizontalArrangement = Arrangement.Center,
                verticalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterVertically)
            ) {
                items(Club.entries) {
                    ClubListItem(club = it, modifier = Modifier.weight(1f))
                    Spacer(Modifier.height(ItemSpacing))
                }
            }
        }
        ExperienceCategoryTitle(Res.string.experience_sharing, delayIndex = 3)
        ExperienceList(Sharing.entries, delayIndex = 4)
        ExperienceCategoryTitle(Res.string.experience_mentor, delayIndex = 5)
        ExperienceList(Mentor.entries, delayIndex = 6)
        ExperienceCategoryTitle(Res.string.experience_awards, delayIndex = 7)
        ExperienceList(Awards.entries, delayIndex = 8)
        ExperienceCategoryTitle(Res.string.experience_global, delayIndex = 9)
        ExperienceList(Global.entries, delayIndex = 10)
        ExperienceCategoryTitle(Res.string.experience_certificates, delayIndex = 11)
        ExperienceList(Certificate.entries, delayIndex = 12, bottomPadding = false)
    }
    SectionColumn(
        deviceState = deviceState,
        modifier = modifier.then(
            Modifier.height(
                when (deviceState.value) {
                    Device.Mobile -> MobileContentVerticalPadding
                    Device.Pc -> PcContentHorizontalPadding
                }
            )
        ),
        content = null
    )
}

@Composable
private fun ClubListItem(
    club: Club,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LogoButton(
            logoRes = club.logoRes,
            url = club.url,
            size = 72.dp,
            contentPadding = PaddingValues(0.dp),
            cornerRadius = CardRadius,
            forceDarkTheme = true
        )
                    Spacer(Modifier.width(ItemSpacing))
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(club.titleRes),
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(0.9f),
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = stringResource(Res.string.club_year, club.year),
                    color = MaterialTheme.colorScheme.onSecondaryContainer.copy(0.8f),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
            Text(
                text = stringResource(club.positionRes),
                color = MaterialTheme.colorScheme.onSecondaryContainer.copy(0.5f),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
        }
    }
}

@Composable
private fun ExperienceCategoryTitle(
    titleRes: org.jetbrains.compose.resources.StringResource,
    delayIndex: Int,
    modifier: Modifier = Modifier
) {
    AnimatedContentWithDelay(
        delayIndex = delayIndex,
        baseDelay = 200,
        orientation = Orientation.Horizontal,
        inverseSlide = true,
        modifier = modifier.padding(bottom = ItemSpacing)
    ) {
        Text(
            stringResource(titleRes),
            color = MaterialTheme.colorScheme.onSecondaryContainer,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun <T : Experience> ExperienceList(
    items: List<T>,
    delayIndex: Int,
    modifier: Modifier = Modifier,
    bottomPadding: Boolean = true
) {
    AnimatedContentWithDelay(
        delayIndex = delayIndex,
        baseDelay = 200,
        modifier = if (bottomPadding) modifier.padding(bottom = 32.dp) else modifier
    ) {
        Column {
            items.forEach { item ->
                ExperienceText(item)
                Spacer(Modifier.height(4.dp))
            }
        }
    }
}

@Composable
private fun ExperienceText(
    experience: Experience,
    modifier: Modifier = Modifier
) {
    val text = buildAnnotatedString {
        withStyle(
            SpanStyle(
                fontSize = 16.sp,
                color = MaterialTheme.colorScheme.onSecondaryContainer.copy(0.8f)
            )
        ) {
            if (experience !is Awards) {
                withStyle(
                    SpanStyle(
                        color = MaterialTheme.colorScheme.onSecondaryContainer.copy(0.25f)
                    )
                ) {
                    append(" • ")
                }
            } else {
                withStyle(
                    SpanStyle(
                        color = MaterialTheme.colorScheme.onSecondaryContainer.copy(0.5f),
                        fontSize = 12.sp
                    )
                ) {
                    append(stringResource(experience.dateRes))
                }
                append(" ")
            }
            append(stringResource(experience.titleRes))
            append(" ")
            if (experience is Awards) {
                withStyle(
                    SpanStyle(
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(stringResource(experience.prizeRes))
                }
                append(" ")
            }
            if (experience is Certificate) {
                append("- ")
                withStyle(
                    SpanStyle(
                        color = MaterialTheme.colorScheme.onSecondaryContainer.copy(0.67f)
                    )
                ) {
                    append(stringResource(experience.levelRes))
                }
            }
            if (experience is Mentor || experience is Global || experience is Sharing) {
                withStyle(
                    SpanStyle(
                        color = MaterialTheme.colorScheme.onSecondaryContainer.copy(0.5f),
                        fontSize = 12.sp
                    )
                ) {
                    append(stringResource(experience.dateRes))
                }
            }
        }
    }
    Text(text = text, modifier = modifier)
}
