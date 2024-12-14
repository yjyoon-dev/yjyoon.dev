package dev.yjyoon.hello.ui.model

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.android_developer
import yjyoondev.composeapp.generated.resources.club_dpm
import yjyoondev.composeapp.generated.resources.club_nexters
import yjyoondev.composeapp.generated.resources.club_swm
import yjyoondev.composeapp.generated.resources.club_yapp
import yjyoondev.composeapp.generated.resources.flutter_developer
import yjyoondev.composeapp.generated.resources.ic_exp_dpm
import yjyoondev.composeapp.generated.resources.ic_exp_nexters
import yjyoondev.composeapp.generated.resources.ic_exp_swm
import yjyoondev.composeapp.generated.resources.ic_exp_yapp

enum class Club(
    val logoRes: DrawableResource,
    val titleRes: StringResource,
    val positionRes: StringResource,
    val year: Int,
    val url: String
) {
    SWMaestro(
        logoRes = Res.drawable.ic_exp_swm,
        titleRes = Res.string.club_swm,
        positionRes = Res.string.flutter_developer,
        year = 12,
        url = "https://swmaestro.org/"
    ),
    Yapp(
        logoRes = Res.drawable.ic_exp_yapp,
        titleRes = Res.string.club_yapp,
        positionRes = Res.string.android_developer,
        year = 20,
        url = "https://www.yapp.co.kr/"
    ),
    Depromeet(
        logoRes = Res.drawable.ic_exp_dpm,
        titleRes = Res.string.club_dpm,
        positionRes = Res.string.android_developer,
        year = 13,
        url = "https://www.depromeet.com/"
    ),
    Nexters(
        logoRes = Res.drawable.ic_exp_nexters,
        titleRes = Res.string.club_nexters,
        positionRes = Res.string.android_developer,
        year = 22,
        url = "https://www.nexters.co.kr/"
    )
}
