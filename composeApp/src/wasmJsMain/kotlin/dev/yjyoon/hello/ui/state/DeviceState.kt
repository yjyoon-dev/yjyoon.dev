package dev.yjyoon.hello.ui.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import dev.yjyoon.hello.ui.LocalScreenSize
import dev.yjyoon.hello.ui.model.Device

typealias DeviceState = State<Device>

@Composable
fun rememberDeviceState(): DeviceState {
    val screenWidthInDp = with(LocalDensity.current) { LocalScreenSize.current.width.toDp() }
    return remember(screenWidthInDp) { derivedStateOf { Device.fromWidth(screenWidthInDp) } }
}

val DeviceState.isMobile
    get() = value == Device.Mobile
val DeviceState.isPc
    get() = value == Device.Pc
