package dev.yjyoon.hello

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.ComposeViewport
import dev.yjyoon.hello.ui.App
import kotlinx.browser.document
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.preloadFont
import org.jetbrains.compose.resources.preloadImageBitmap
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.img_graphic_dark
import yjyoondev.composeapp.generated.resources.img_graphic_dark_large
import yjyoondev.composeapp.generated.resources.img_graphic_light
import yjyoondev.composeapp.generated.resources.img_graphic_light_large
import yjyoondev.composeapp.generated.resources.pretendard_black
import yjyoondev.composeapp.generated.resources.pretendard_bold
import yjyoondev.composeapp.generated.resources.pretendard_extrabold
import yjyoondev.composeapp.generated.resources.pretendard_extralight
import yjyoondev.composeapp.generated.resources.pretendard_light
import yjyoondev.composeapp.generated.resources.pretendard_medium
import yjyoondev.composeapp.generated.resources.pretendard_regular
import yjyoondev.composeapp.generated.resources.pretendard_semibold
import yjyoondev.composeapp.generated.resources.pretendard_thin

@OptIn(ExperimentalComposeUiApi::class, ExperimentalResourceApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        val fontStates = listOf(
            preloadFont(Res.font.pretendard_black),
            preloadFont(Res.font.pretendard_bold),
            preloadFont(Res.font.pretendard_extrabold),
            preloadFont(Res.font.pretendard_extralight),
            preloadFont(Res.font.pretendard_light),
            preloadFont(Res.font.pretendard_medium),
            preloadFont(Res.font.pretendard_regular),
            preloadFont(Res.font.pretendard_semibold),
            preloadFont(Res.font.pretendard_thin),
            preloadImageBitmap(Res.drawable.img_graphic_light),
            preloadImageBitmap(Res.drawable.img_graphic_dark),
            preloadImageBitmap(Res.drawable.img_graphic_light_large),
            preloadImageBitmap(Res.drawable.img_graphic_dark_large)
        )
        if (fontStates.all { it.value != null }) {
            App()
        } else {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
    }
}
