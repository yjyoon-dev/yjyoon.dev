package dev.yjyoon.hello.ui.screen.pc.section

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yjyoon.hello.ui.LocalScreenSize
import dev.yjyoon.hello.ui.LocalThemeMode
import dev.yjyoon.hello.ui.ThemeMode
import dev.yjyoon.hello.ui.component.defaultEnterAnim
import dev.yjyoon.hello.ui.screen.pc.CONTENT_HORIZONTAL_PADDING
import dev.yjyoon.hello.ui.screen.pc.CONTENT_WIDTH
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.follow_github
import yjyoondev.composeapp.generated.resources.hi
import yjyoondev.composeapp.generated.resources.i_am
import yjyoondev.composeapp.generated.resources.ic_github
import yjyoondev.composeapp.generated.resources.ic_open_in_new
import yjyoondev.composeapp.generated.resources.img_graphic_dark
import yjyoondev.composeapp.generated.resources.img_graphic_dark_large
import yjyoondev.composeapp.generated.resources.img_graphic_light
import yjyoondev.composeapp.generated.resources.img_graphic_light_large
import yjyoondev.composeapp.generated.resources.intro
import yjyoondev.composeapp.generated.resources.visit_blog
import yjyoondev.composeapp.generated.resources.yjyoon

@Composable
fun HomeSection(
    modifier: Modifier = Modifier
) {
    val themeMode = LocalThemeMode.current
    val uriHandler = LocalUriHandler.current
    val screenSize = LocalScreenSize.current

    val defaultTextColor = MaterialTheme.colorScheme.onBackground
    val greetingString = buildAnnotatedString {
        withStyle(
            SpanStyle(
                fontSize = 72.sp,
                fontWeight = FontWeight.Black,
            )
        ) {
            withStyle(SpanStyle(color = defaultTextColor)) {
                append(stringResource(Res.string.hi))
            }
            withStyle(SpanStyle(color = defaultTextColor.copy(alpha = 0.2f))) {
                append(",\n")
            }
            withStyle(SpanStyle(color = defaultTextColor)) {
                append(stringResource(Res.string.i_am))
            }
            append("\n")
            withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append(stringResource(Res.string.yjyoon))
            }
        }
    }

    val visibleState = rememberSaveable {
        MutableTransitionState(false).apply {
            targetState = true
        }
    }

    val introTextAnimatedAlpha = animateFloatAsState(
        if (screenSize.width >= SHOW_INTRO_TEXT_WIDTH_THRESHOLD) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    Box(
        modifier = modifier.then(
            Modifier
                .background(color = MaterialTheme.colorScheme.background)
                .padding(
                    start = CONTENT_HORIZONTAL_PADDING.dp,
                    end = CONTENT_HORIZONTAL_PADDING.dp / 2
                )
                .width(CONTENT_WIDTH.dp)
        )
    ) {
        AnimatedVisibility(
            visibleState = visibleState,
            enter = defaultEnterAnim(orientation = Orientation.Horizontal),
            modifier = Modifier
                .align(Alignment.BottomEnd)
        ) {
            GraphicImage(
                themeMode = themeMode,
                modifier = Modifier.height(CONTENT_WIDTH.dp / 2.5f)
            )
        }
        Column(
            modifier = Modifier
                .width((CONTENT_WIDTH * 2 / 3).dp)
                .align(Alignment.BottomStart)
                .padding(vertical = 36.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            AnimatedVisibility(
                visibleState = visibleState,
                enter = defaultEnterAnim(delayMillis = 500, inverseSlide = true),
                modifier = Modifier.padding(bottom = 12.dp)
            ) {
                Text(greetingString, lineHeight = 92.sp)
            }
            AnimatedVisibility(
                visibleState = visibleState,
                enter = defaultEnterAnim(delayMillis = 500),
                modifier = Modifier.padding(bottom = 36.dp)
            ) {
                Text(
                    text = stringResource(Res.string.intro),
                    color = defaultTextColor.copy(alpha = 0.5f),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    modifier = Modifier.alpha(introTextAnimatedAlpha.value)
                )
            }
            AnimatedVisibility(
                visibleState = visibleState,
                enter = defaultEnterAnim(
                    orientation = Orientation.Horizontal,
                    inverseSlide = true,
                    delayMillis = 500
                ),
            ) {
                Row {
                    Button(
                        onClick = { uriHandler.openUri("https://github.com/yjyoon-dev") },
                        modifier = Modifier.height(56.dp),
                        contentPadding = PaddingValues(vertical = 12.dp, horizontal = 24.dp)
                    ) {
                        Text(
                            text = stringResource(Res.string.follow_github),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                        Spacer(Modifier.width(8.dp))
                        Icon(
                            painterResource(Res.drawable.ic_github),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                    Spacer(Modifier.width(8.dp))
                    OutlinedButton(
                        onClick = { uriHandler.openUri("http://blog.yjyoon.dev") },
                        modifier = Modifier.height(56.dp),
                        colors = ButtonDefaults.outlinedButtonColors(
                            containerColor = MaterialTheme.colorScheme.background,
                            contentColor = MaterialTheme.colorScheme.onBackground
                        ),
                        contentPadding = PaddingValues(vertical = 12.dp, horizontal = 24.dp)
                    ) {
                        Text(
                            text = stringResource(Res.string.visit_blog),
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                        Spacer(Modifier.width(8.dp))
                        Icon(
                            painterResource(Res.drawable.ic_open_in_new),
                            contentDescription = null,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun GraphicImage(
    themeMode: ThemeMode,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val isLarge = with(density) { CONTENT_WIDTH.dp.toPx() >= 1920f }
    val graphicRes = when (themeMode) {
        ThemeMode.Light -> if (isLarge) {
            Res.drawable.img_graphic_light_large
        } else {
            Res.drawable.img_graphic_light
        }

        ThemeMode.Dark -> if (isLarge) {
            Res.drawable.img_graphic_dark_large
        } else {
            Res.drawable.img_graphic_dark
        }
    }
    Image(
        painter = painterResource(graphicRes),
        contentDescription = null,
        contentScale = ContentScale.FillHeight,
        modifier = modifier
    )
}

private const val SHOW_INTRO_TEXT_WIDTH_THRESHOLD = 1330
