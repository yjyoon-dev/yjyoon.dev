package dev.yjyoon.hello.ui.screen.pc.section

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yjyoon.hello.ui.LocalThemeMode
import dev.yjyoon.hello.ui.component.AppButton
import dev.yjyoon.hello.ui.component.LogoButton
import dev.yjyoon.hello.ui.component.SectionColumn
import dev.yjyoon.hello.ui.model.Awards
import dev.yjyoon.hello.ui.model.Certificate
import dev.yjyoon.hello.ui.model.Club
import dev.yjyoon.hello.ui.model.Experience
import dev.yjyoon.hello.ui.model.Global
import dev.yjyoon.hello.ui.model.Mentor
import dev.yjyoon.hello.ui.model.SideProject
import dev.yjyoon.hello.ui.screen.pc.CONTENT_WIDTH
import org.jetbrains.compose.resources.stringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.club_year
import yjyoondev.composeapp.generated.resources.experience_awards
import yjyoondev.composeapp.generated.resources.experience_certificates
import yjyoondev.composeapp.generated.resources.experience_development
import yjyoondev.composeapp.generated.resources.experience_for
import yjyoondev.composeapp.generated.resources.experience_global
import yjyoondev.composeapp.generated.resources.experience_mentor
import yjyoondev.composeapp.generated.resources.side_project_lover

@Composable
fun ExperienceSection(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()

    LaunchedEffect(Unit) {
        while (true) {
            listState.animateScrollBy(
                1f, animationSpec = tween(
                    durationMillis = 10,
                    delayMillis = 0,
                    easing = LinearEasing
                )
            )
        }
    }

    SectionColumn(
        modifier = modifier,
        reverseTheme = true,
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                stringResource(Res.string.experience_for),
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp,
                textAlign = TextAlign.Center
            )
        }
        Spacer(Modifier.height(36.dp))
        Text(
            stringResource(Res.string.experience_development),
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(16.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.height(172.dp),
            horizontalArrangement = Arrangement.Center,
            verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically)
        ) {
            items(Club.entries) {
                ClubListItem(club = it, modifier = Modifier.weight(1f))
                Spacer(Modifier.height(12.dp))
            }
        }
        Spacer(Modifier.height(32.dp))
        Text(
            stringResource(Res.string.experience_awards),
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(12.dp))
        Awards.entries.forEach { awards ->
            ExperienceText(awards)
            Spacer(Modifier.height(4.dp))
        }
        Spacer(Modifier.height(32.dp))
        Text(
            stringResource(Res.string.experience_mentor),
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(12.dp))
        Mentor.entries.forEach { mentor ->
            ExperienceText(mentor)
            Spacer(Modifier.height(4.dp))
        }
        Spacer(Modifier.height(32.dp))
        Text(
            stringResource(Res.string.experience_global),
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(12.dp))
        Global.entries.forEach { global ->
            ExperienceText(global)
            Spacer(Modifier.height(4.dp))
        }

        Spacer(Modifier.height(32.dp))
        Text(
            stringResource(Res.string.experience_certificates),
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )
        Spacer(Modifier.height(12.dp))
        Certificate.entries.forEach { certificate ->
            ExperienceText(certificate)
            Spacer(Modifier.height(4.dp))
        }
    }
    SectionColumn(
        modifier = Modifier.height(CONTENT_WIDTH.dp / 21 * 9),
        horizontalAlignment = Alignment.Start
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                stringResource(Res.string.side_project_lover),
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp,
                textAlign = TextAlign.Center
            )
        }
        Spacer(Modifier.height(36.dp))
        LazyRow(
            state = listState,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(List(100) { SideProject.entries }.flatten()) { sideProject ->
                AppButton(
                    sideProject = sideProject,
                    size = 92.dp
                )
            }
        }
    }
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
            theme = LocalThemeMode.current.toggle(),
            contentPadding = PaddingValues(0.dp),
            cornerRadius = 12.dp
        )
        Spacer(Modifier.width(12.dp))
        Column {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = stringResource(club.titleRes),
                    color = MaterialTheme.colorScheme.onBackground.copy(0.9f),
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp
                )
                Spacer(Modifier.width(4.dp))
                Text(
                    text = stringResource(Res.string.club_year, club.year),
                    color = MaterialTheme.colorScheme.onBackground.copy(0.8f),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp
                )
            }
            Text(
                text = stringResource(club.positionRes),
                color = MaterialTheme.colorScheme.onBackground.copy(0.5f),
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            )
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
                color = MaterialTheme.colorScheme.onBackground.copy(0.8f)
            )
        ) {
            if (experience !is Awards) {
                withStyle(
                    SpanStyle(
                        color = MaterialTheme.colorScheme.onBackground.copy(0.25f)
                    )
                ) {
                    append(" • ")
                }
            } else {
                withStyle(
                    SpanStyle(
                        color = MaterialTheme.colorScheme.onBackground.copy(0.5f),
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
                        color = MaterialTheme.colorScheme.onBackground.copy(0.67f)
                    )
                ) {
                    append(stringResource(experience.levelRes))
                }
            }
            if (experience is Mentor || experience is Global) {
                withStyle(
                    SpanStyle(
                        color = MaterialTheme.colorScheme.onBackground.copy(0.5f),
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
