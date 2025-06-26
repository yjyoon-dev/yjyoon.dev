package dev.yjyoon.hello.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import dev.yjyoon.hello.ui.theme.DefaultAnimDelay

@Composable
fun AnimatedContent(
    modifier: Modifier = Modifier,
    delayMillis: Int = 0,
    orientation: Orientation = Orientation.Vertical,
    inverseSlide: Boolean = false,
    content: @Composable () -> Unit
) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }
    
    AnimatedVisibility(
        visibleState = visibleState,
        enter = defaultEnterAnim(
            delayMillis = delayMillis,
            orientation = orientation,
            inverseSlide = inverseSlide
        ),
        modifier = modifier
    ) {
        content()
    }
}

@Composable
fun AnimatedContentWithDelay(
    modifier: Modifier = Modifier,
    delayIndex: Int = 0,
    baseDelay: Int = 0,
    orientation: Orientation = Orientation.Vertical,
    inverseSlide: Boolean = false,
    content: @Composable () -> Unit
) {
    AnimatedContent(
        modifier = modifier,
        delayMillis = baseDelay + (delayIndex * DefaultAnimDelay),
        orientation = orientation,
        inverseSlide = inverseSlide,
        content = content
    )
} 