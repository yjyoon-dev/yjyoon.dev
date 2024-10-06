package dev.yjyoon.hello.ui.screen.pc.section

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yjyoon.hello.ui.LocalThemeMode
import dev.yjyoon.hello.ui.ThemeMode
import dev.yjyoon.hello.ui.component.CenteredImage
import dev.yjyoon.hello.ui.model.Skill
import dev.yjyoon.hello.ui.screen.pc.CONTENT_HORIZONTAL_PADDING
import dev.yjyoon.hello.ui.screen.pc.CONTENT_WIDTH
import dev.yjyoon.hello.ui.theme.KotlinDarkGray
import dev.yjyoon.hello.ui.theme.KotlinLightGray
import dev.yjyoon.hello.ui.theme.KotlinTheme
import org.jetbrains.compose.resources.stringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.about_me
import yjyoondev.composeapp.generated.resources.favorites
import yjyoondev.composeapp.generated.resources.section_about

@Composable
fun AboutSection(modifier: Modifier = Modifier) {
    val themeMode = LocalThemeMode.current

    KotlinTheme(
        isDarkTheme = themeMode != ThemeMode.Dark
    ) {
        Box(
            modifier = modifier.then(
                Modifier
                    .background(color = MaterialTheme.colorScheme.background)
                    .fillMaxWidth()
            ),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .width(CONTENT_WIDTH.dp)
                    .padding(
                        horizontal = CONTENT_HORIZONTAL_PADDING.dp,
                        vertical = 72.dp
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    stringResource(Res.string.section_about),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 36.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(36.dp))
                Text(
                    stringResource(Res.string.about_me),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 28.sp,
                    modifier = Modifier.padding(horizontal = (CONTENT_HORIZONTAL_PADDING / 2).dp)
                )
                Spacer(Modifier.height(72.dp))
                Text(
                    stringResource(Res.string.favorites),
                    color = MaterialTheme.colorScheme.onBackground,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(36.dp))
                LazyVerticalGrid(
                    columns = GridCells.Fixed(4),
                    contentPadding = PaddingValues(4.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.size(width = 720.dp, height = 480.dp)

                ) {
                    items(Skill.entries) {
                        SkillCard(it)
                    }
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

    OutlinedCard(
        onClick = { uriHandler.openUri(skill.url) },
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (themeMode == ThemeMode.Light) 2.dp else 0.dp
        ),
        colors = CardDefaults.outlinedCardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        border = BorderStroke(
            width = if (themeMode == ThemeMode.Light) 0.dp else Dp.Hairline,
            color = if (themeMode == ThemeMode.Light) KotlinDarkGray else KotlinLightGray
        ),
        modifier = modifier.then(Modifier.aspectRatio(1f))
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            CenteredImage(
                resource = skill.logo,
                modifier = Modifier.size(48.dp)
            )
            Spacer(Modifier.height(16.dp))
            Text(
                stringResource(skill.title),
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                lineHeight = 18.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}
