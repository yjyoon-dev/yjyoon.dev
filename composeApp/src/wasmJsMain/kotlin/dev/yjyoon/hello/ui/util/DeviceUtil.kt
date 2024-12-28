package dev.yjyoon.hello.ui.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import dev.yjyoon.hello.ui.LocalScreenSize

object DeviceUtil {

    private const val MOBILE_SCREEN_WIDTH_THRESHOLD = 840

    @Composable
    fun isMobile(): Boolean {
        val density = LocalDensity.current
        val screenWidthInDp = with(density) { LocalScreenSize.current.width.toDp() }
        return screenWidthInDp <= MOBILE_SCREEN_WIDTH_THRESHOLD.dp
    }
}
