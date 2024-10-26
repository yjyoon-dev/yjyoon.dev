package dev.yjyoon.hello.ui.model

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.android_developer
import yjyoondev.composeapp.generated.resources.android_developer_intern
import yjyoondev.composeapp.generated.resources.career_kakaobrain_desc
import yjyoondev.composeapp.generated.resources.career_kakaobrain_team
import yjyoondev.composeapp.generated.resources.career_naver_desc
import yjyoondev.composeapp.generated.resources.career_naver_team
import yjyoondev.composeapp.generated.resources.career_neurosky_desc
import yjyoondev.composeapp.generated.resources.career_neurosky_team
import yjyoondev.composeapp.generated.resources.img_kakaobrain
import yjyoondev.composeapp.generated.resources.img_naver
import yjyoondev.composeapp.generated.resources.img_neurosky

enum class Career(
    val logoRes: DrawableResource,
    val startDate: String,
    val positionRes: StringResource,
    val teamRes: StringResource,
    val descriptionRes: StringResource,
    val url: String
) {
    Naver(
        logoRes = Res.drawable.img_naver,
        startDate = "2023.12",
        positionRes = Res.string.android_developer,
        teamRes = Res.string.career_naver_team,
        descriptionRes = Res.string.career_naver_desc,
        url = "https://navercorp.com"
    ),
    KakaoBrain(
        logoRes = Res.drawable.img_kakaobrain,
        startDate = "2023.06",
        positionRes = Res.string.android_developer_intern,
        teamRes = Res.string.career_kakaobrain_team,
        descriptionRes = Res.string.career_kakaobrain_desc,
        url = "https://kakaobrain.com"
    ),
    Neurosky(
        logoRes = Res.drawable.img_neurosky,
        startDate = "2022.08",
        positionRes = Res.string.android_developer_intern,
        teamRes = Res.string.career_neurosky_team,
        descriptionRes = Res.string.career_neurosky_desc,
        url = "https://neurosky.com"
    )
}
