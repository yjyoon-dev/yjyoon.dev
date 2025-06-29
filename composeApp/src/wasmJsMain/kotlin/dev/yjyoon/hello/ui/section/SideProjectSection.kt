package dev.yjyoon.hello.ui.section

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.gestures.animateScrollBy
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yjyoon.hello.ui.component.AnimatedContent
import dev.yjyoon.hello.ui.component.AppButton
import dev.yjyoon.hello.ui.component.SectionColumn
import dev.yjyoon.hello.ui.model.SideProject
import dev.yjyoon.hello.ui.theme.ItemSpacing
import dev.yjyoon.hello.ui.theme.MobileContentHorizontalPadding
import dev.yjyoon.hello.ui.theme.PcContentHorizontalPadding
import dev.yjyoon.hello.ui.state.isMobile
import dev.yjyoon.hello.ui.state.rememberDeviceState
import org.jetbrains.compose.resources.stringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.side_project_lover

@Composable
fun SideProjectSection(modifier: Modifier = Modifier) {
    val deviceState = rememberDeviceState()
    val listState = rememberLazyListState()
    val sideProjectListAnimatedBottomPadding by animateDpAsState(
        targetValue = 64.dp,
        animationSpec = tween(durationMillis = 1000)
    )

    LaunchedEffect(Unit) {
        while (true) {
            listState.animateScrollBy(
                value = if(deviceState.isMobile) 3f else 1f,
                animationSpec = tween(
                    durationMillis = 10,
                    delayMillis = 0,
                    easing = LinearEasing
                )
            )
        }
    }

    SectionColumn(
        deviceState = deviceState,
        modifier = modifier.then(
            Modifier.height(PcContentHorizontalPadding * 2)
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        AnimatedContent(
            delayMillis = 500,
            inverseSlide = true,
            modifier = Modifier.padding(bottom = 92.dp)
        ) {
            Text(
                stringResource(Res.string.side_project_lover),
                color = MaterialTheme.colorScheme.onPrimaryContainer,
                fontWeight = FontWeight.Bold,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                lineHeight = 42.sp,
                modifier = Modifier.padding(horizontal = MobileContentHorizontalPadding)
            )
        }
    }
    AnimatedContent(
        delayMillis = 1000
    ) {
        LazyRow(
            state = listState,
            horizontalArrangement = Arrangement.spacedBy(ItemSpacing),
            modifier = Modifier.padding(bottom = sideProjectListAnimatedBottomPadding),
            userScrollEnabled = false
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
