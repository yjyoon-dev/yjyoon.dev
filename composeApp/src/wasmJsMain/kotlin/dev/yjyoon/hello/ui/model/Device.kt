package dev.yjyoon.hello.ui.model

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class Device {
    Mobile,
    Pc;

    companion object {

        fun fromWidth(width: Dp): Device {
            return if (width < MOBILE_SCREEN_WIDTH_THRESHOLD.dp) Mobile else Pc
        }

        private const val MOBILE_SCREEN_WIDTH_THRESHOLD = 840
    }
}
