package dev.yjyoon.hello.ui.section


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
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.yjyoon.hello.ui.LocalScreenSize
import dev.yjyoon.hello.ui.LocalThemeMode
import dev.yjyoon.hello.ui.ThemeMode
import dev.yjyoon.hello.ui.component.AnimatedContent
import dev.yjyoon.hello.ui.component.AnimatedContentWithDelay
import dev.yjyoon.hello.ui.component.SectionColumn
import dev.yjyoon.hello.ui.model.Device
import dev.yjyoon.hello.ui.theme.ButtonHeight
import dev.yjyoon.hello.ui.theme.ItemSpacing
import dev.yjyoon.hello.ui.theme.MobileContentHorizontalPadding
import dev.yjyoon.hello.ui.theme.MobileContentVerticalPadding
import dev.yjyoon.hello.ui.theme.PcContentHorizontalPadding
import dev.yjyoon.hello.ui.theme.PcContentWidth
import dev.yjyoon.hello.ui.theme.SectionSpacing
import dev.yjyoon.hello.ui.state.DeviceState
import dev.yjyoon.hello.ui.state.isMobile
import dev.yjyoon.hello.ui.state.rememberDeviceState
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
    val deviceState = rememberDeviceState()
    val themeMode = LocalThemeMode.current
    val defaultTextColor = MaterialTheme.colorScheme.onPrimaryContainer
    val greetingString = buildAnnotatedString {
        withStyle(
            SpanStyle(
                fontSize = when (deviceState.value) {
                    Device.Pc -> 72.sp
                    Device.Mobile -> 48.sp
                },
                fontWeight = FontWeight.Black
            )
        ) {
            withStyle(SpanStyle(color = defaultTextColor)) {
                append(stringResource(Res.string.hi))
            }
            withStyle(SpanStyle(color = defaultTextColor.copy(alpha = 0.2f))) {
                append(", ")
            }
            withStyle(SpanStyle(color = defaultTextColor)) {
                append(stringResource(Res.string.i_am) + "\n")
            }
            withStyle(SpanStyle(color = MaterialTheme.colorScheme.primary)) {
                append(stringResource(Res.string.yjyoon))
            }
        }
    }

    Box {
        HomePcSection(
            themeMode = themeMode,
            greetingString = greetingString,
            modifier = modifier.then(
                if (deviceState.isMobile) {
                    Modifier.height(1.dp)
                } else {
                    Modifier
                }
            )
        )
        if (deviceState.isMobile) {
            HomeMobileSection(
                themeMode = themeMode,
                greetingString = greetingString,
                deviceState = deviceState,
                modifier = modifier
            )
        }
    }
}

@Composable
private fun HomeMobileSection(
    themeMode: ThemeMode,
    greetingString: AnnotatedString,
    deviceState: DeviceState,
    modifier: Modifier = Modifier
) {
    SectionColumn(
        modifier = modifier,
        deviceState = deviceState,
        contentPadding = PaddingValues(bottom = 24.dp),
        content = null,
        mobileContent = {
            AnimatedContent(
                delayMillis = 500,
                orientation = Orientation.Horizontal,
                inverseSlide = true,
                modifier = Modifier.padding(bottom = ItemSpacing)
            ) {
                Column(
                    modifier = Modifier
                        .padding(top = MobileContentVerticalPadding)
                        .padding(horizontal = MobileContentHorizontalPadding)
                ) {
                    Text(
                        greetingString, lineHeight = when (deviceState.value) {
                            Device.Pc -> 92.sp
                            Device.Mobile -> 76.sp
                        }
                    )
                }
            }
            AnimatedContent {
                GraphicImage(
                    themeMode = themeMode,
                    contentScale = ContentScale.FillWidth,
                    modifier = Modifier.fillMaxWidth()
                )
            }
            AnimatedContent(
                delayMillis = 500,
                inverseSlide = true
            ) {
                Column(
                    modifier = Modifier.padding(
                        horizontal = MobileContentHorizontalPadding
                    ),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    GithubButton(modifier = Modifier.fillMaxWidth())
                    BlogButton(modifier = Modifier.fillMaxWidth())
                }
            }
        }
    )
}

@Composable
private fun HomePcSection(
    themeMode: ThemeMode,
    greetingString: AnnotatedString,
    modifier: Modifier = Modifier
) {
    val screenSize = LocalScreenSize.current
    val introTextAnimatedAlpha = animateFloatAsState(
        if (screenSize.width >= SHOW_INTRO_TEXT_WIDTH_THRESHOLD) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    Box(
        modifier = modifier.then(
            Modifier
                .background(color = MaterialTheme.colorScheme.primaryContainer)
                .padding(
                    start = PcContentHorizontalPadding,
                    end = PcContentHorizontalPadding / 2
                )
                .width(PcContentWidth)
        )
    ) {
        AnimatedContent(
            orientation = Orientation.Horizontal,
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            GraphicImage(
                themeMode = themeMode,
                modifier = Modifier.height(PcContentWidth / 2.5f)
            )
        }
        Column(
            modifier = Modifier
                .width((PcContentWidth.value * 2 / 3).dp)
                .align(Alignment.BottomStart)
                .padding(vertical = SectionSpacing),
            verticalArrangement = Arrangement.Bottom
        ) {
            AnimatedContent(
                delayMillis = 500,
                inverseSlide = true,
                modifier = Modifier.padding(bottom = ItemSpacing)
            ) {
                Text(greetingString, lineHeight = 92.sp)
            }
            AnimatedContent(
                delayMillis = 500,
                modifier = Modifier.padding(bottom = SectionSpacing)
            ) {
                Text(
                    text = stringResource(Res.string.intro),
                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.5f),
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    modifier = Modifier.alpha(introTextAnimatedAlpha.value)
                )
            }
            AnimatedContent(
                orientation = Orientation.Horizontal,
                inverseSlide = true,
                delayMillis = 500
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    GithubButton()
                    BlogButton()
                }
            }
        }
    }
}

@Composable
private fun GraphicImage(
    themeMode: ThemeMode,
    contentScale: ContentScale = ContentScale.FillHeight,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val isLarge = with(density) { PcContentWidth.toPx() >= 1920f }
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
        contentScale = contentScale,
        modifier = modifier
    )
}

@Composable
private fun LinkButton(
    labelRes: org.jetbrains.compose.resources.StringResource,
    iconRes: org.jetbrains.compose.resources.DrawableResource,
    url: String,
    isOutlined: Boolean = false,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current
    val buttonContent: @Composable () -> Unit = {
        Text(
            text = stringResource(labelRes),
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
        Spacer(Modifier.width(8.dp))
        Icon(
            painterResource(iconRes),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
    }

    if (isOutlined) {
        OutlinedButton(
            onClick = { uriHandler.openUri(url) },
            modifier = modifier.then(Modifier.height(ButtonHeight)),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            ),
            contentPadding = PaddingValues(vertical = 12.dp, horizontal = 24.dp),
            content = { buttonContent() }
        )
    } else {
        Button(
            onClick = { uriHandler.openUri(url) },
            modifier = modifier.then(Modifier.height(ButtonHeight)),
            contentPadding = PaddingValues(vertical = 12.dp, horizontal = 24.dp),
            content = { buttonContent() }
        )
    }
}

@Composable
private fun GithubButton(modifier: Modifier = Modifier) {
    LinkButton(
        labelRes = Res.string.follow_github,
        iconRes = Res.drawable.ic_github,
        url = "https://github.com/yjyoon-dev",
        modifier = modifier
    )
}

@Composable
private fun BlogButton(modifier: Modifier = Modifier) {
    LinkButton(
        labelRes = Res.string.visit_blog,
        iconRes = Res.drawable.ic_open_in_new,
        url = "http://blog.yjyoon.dev",
        isOutlined = true,
        modifier = modifier
    )
}

private const val SHOW_INTRO_TEXT_WIDTH_THRESHOLD = 1330
