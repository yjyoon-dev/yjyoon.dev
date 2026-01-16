package dev.yjyoon.hello.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// PC Layout
val PcContentHorizontalPadding = 128.dp
val PcContentVerticalPadding = 72.dp
val PcContentWidth = 1280.dp

// Mobile Layout  
val MobileContentHorizontalPadding = 24.dp
val MobileContentVerticalPadding = 48.dp

// Common
val SectionSpacing = 36.dp
val ItemSpacing = 12.dp
val ButtonHeight = 56.dp
val CardRadius = 12.dp

// Animation
const val DefaultAnimDuration = 500
const val DefaultAnimDelay = 400

// Modifier Extensions
fun Modifier.lightShadow(
    cornerRadius: Dp = 16.dp,
    shape: Shape = RoundedCornerShape(cornerRadius)
): Modifier = shadow(
    elevation = 24.dp,
    shape = shape,
    clip = false,
    ambientColor = YjyoonLightGray.copy(0.01f),
    spotColor = YjyoonLightGray.copy(0.01f)
)