package dev.yjyoon.hello.ui.section

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yjyoon.hello.ui.LocalThemeMode
import dev.yjyoon.hello.ui.ThemeMode
import dev.yjyoon.hello.ui.component.CenteredImage
import dev.yjyoon.hello.ui.component.SectionColumn
import dev.yjyoon.hello.ui.component.defaultEnterAnim
import dev.yjyoon.hello.ui.model.Device
import dev.yjyoon.hello.ui.model.Skill
import dev.yjyoon.hello.ui.screen.PC_CONTENT_HORIZONTAL_PADDING
import dev.yjyoon.hello.ui.state.isMobile
import dev.yjyoon.hello.ui.state.rememberDeviceState
import org.jetbrains.compose.resources.stringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.about_me
import yjyoondev.composeapp.generated.resources.favorites
import yjyoondev.composeapp.generated.resources.section_about

@Composable
fun AboutSection(modifier: Modifier = Modifier) {
    val deviceState = rememberDeviceState()
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }

    SectionColumn(
        modifier = modifier,
        deviceState = deviceState,
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
    ) {
        AnimatedVisibility(
            visibleState = visibleState,
            enter = defaultEnterAnim(),
            modifier = Modifier.padding(bottom = 36.dp)
        ) {
            Text(
                stringResource(Res.string.section_about),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 36.sp,
                textAlign = TextAlign.Center
            )
        }
        AnimatedVisibility(
            visibleState = visibleState,
            enter = defaultEnterAnim(delayMillis = 400),
            modifier = Modifier.padding(bottom = 72.dp)
        ) {
            val horizontalPadding = when (deviceState.value) {
                Device.Mobile -> 0.dp
                Device.Pc -> (PC_CONTENT_HORIZONTAL_PADDING / 2).dp
            }
            Text(
                stringResource(Res.string.about_me),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                lineHeight = 28.sp,
                modifier = Modifier.padding(horizontal = horizontalPadding)
            )
        }
        AnimatedVisibility(
            visibleState = visibleState,
            enter = defaultEnterAnim(delayMillis = 800),
            modifier = Modifier.padding(bottom = 36.dp)
        ) {
            Text(
                stringResource(Res.string.favorites),
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
        AnimatedVisibility(
            visibleState = visibleState,
            enter = defaultEnterAnim(delayMillis = 1200)
        ) {
            val (gridColumns, gridModifier, gridSpacing) = when (deviceState.value) {
                Device.Mobile -> {
                    Triple(2, Modifier.fillMaxWidth().aspectRatio(2 / 3f), 12.dp)
                }

                Device.Pc -> {
                    Triple(4, Modifier.width(720.dp).aspectRatio(2 / 1f), 12.dp)
                }
            }

            LazyVerticalGrid(
                columns = GridCells.Fixed(gridColumns),
                contentPadding = PaddingValues(4.dp),
                horizontalArrangement = Arrangement.spacedBy(gridSpacing),
                verticalArrangement = Arrangement.spacedBy(gridSpacing),
                modifier = gridModifier

            ) {
                items(Skill.entries.dropLast(if (deviceState.isMobile()) 2 else 0)) {
                    SkillCard(it, modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun SkillCard(
    skill: Skill,
    modifier: Modifier = Modifier
) {
    val themeMode = LocalThemeMode.current
    val uriHandler = LocalUriHandler.current

    Card(
        onClick = { uriHandler.openUri(skill.url) },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (themeMode == ThemeMode.Light) 2.dp else 0.dp
        ),
        colors = CardDefaults.outlinedCardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        modifier = modifier.then(Modifier.aspectRatio(1f))
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(top = 36.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CenteredImage(
                resource = skill.logo,
                modifier = Modifier.size(48.dp)
            )
            Spacer(Modifier.height(12.dp))
            Box(
                modifier = Modifier.height(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    stringResource(skill.title),
                    fontWeight = FontWeight.Medium,
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}
