package dev.yjyoon.hello.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import org.jetbrains.compose.resources.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.pretendard_black
import yjyoondev.composeapp.generated.resources.pretendard_bold
import yjyoondev.composeapp.generated.resources.pretendard_extrabold
import yjyoondev.composeapp.generated.resources.pretendard_extralight
import yjyoondev.composeapp.generated.resources.pretendard_light
import yjyoondev.composeapp.generated.resources.pretendard_medium
import yjyoondev.composeapp.generated.resources.pretendard_regular
import yjyoondev.composeapp.generated.resources.pretendard_semibold
import yjyoondev.composeapp.generated.resources.pretendard_thin

@Composable
fun PretendardFontFamily() = FontFamily(
    Font(Res.font.pretendard_black, weight = FontWeight.Black),
    Font(Res.font.pretendard_extrabold, weight = FontWeight.ExtraBold),
    Font(Res.font.pretendard_bold, weight = FontWeight.Bold),
    Font(Res.font.pretendard_semibold, weight = FontWeight.SemiBold),
    Font(Res.font.pretendard_medium, weight = FontWeight.Medium),
    Font(Res.font.pretendard_regular, weight = FontWeight.Normal),
    Font(Res.font.pretendard_light, weight = FontWeight.Light),
    Font(Res.font.pretendard_extralight, weight = FontWeight.ExtraLight),
    Font(Res.font.pretendard_thin, weight = FontWeight.Thin),
)

@Composable
fun PretendardTypography() = Typography().run {
    val fontFamily = PretendardFontFamily()
    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily =  fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}
