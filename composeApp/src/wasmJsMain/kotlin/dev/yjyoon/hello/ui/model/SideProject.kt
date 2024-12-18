package dev.yjyoon.hello.ui.model

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.ic_side_alreadyme
import yjyoondev.composeapp.generated.resources.ic_side_coverist
import yjyoondev.composeapp.generated.resources.ic_side_droidknights
import yjyoondev.composeapp.generated.resources.ic_side_enphago
import yjyoondev.composeapp.generated.resources.ic_side_goorlemap
import yjyoondev.composeapp.generated.resources.ic_side_jsgame
import yjyoondev.composeapp.generated.resources.ic_side_knowlly
import yjyoondev.composeapp.generated.resources.ic_side_kwdorm
import yjyoondev.composeapp.generated.resources.ic_side_kwnoti
import yjyoondev.composeapp.generated.resources.ic_side_kwpass
import yjyoondev.composeapp.generated.resources.ic_side_loco
import yjyoondev.composeapp.generated.resources.ic_side_mbtmi
import yjyoondev.composeapp.generated.resources.ic_side_missing
import yjyoondev.composeapp.generated.resources.ic_side_moime
import yjyoondev.composeapp.generated.resources.ic_side_neuro
import yjyoondev.composeapp.generated.resources.ic_side_pimo
import yjyoondev.composeapp.generated.resources.ic_side_ssoda
import yjyoondev.composeapp.generated.resources.ic_side_whatnow
import yjyoondev.composeapp.generated.resources.ic_side_yjyoon_dev
import yjyoondev.composeapp.generated.resources.side_alreadyme
import yjyoondev.composeapp.generated.resources.side_coverist
import yjyoondev.composeapp.generated.resources.side_droidknights2023
import yjyoondev.composeapp.generated.resources.side_enphago
import yjyoondev.composeapp.generated.resources.side_goorlemap
import yjyoondev.composeapp.generated.resources.side_jsgame
import yjyoondev.composeapp.generated.resources.side_knowlly
import yjyoondev.composeapp.generated.resources.side_kwdorm
import yjyoondev.composeapp.generated.resources.side_kwnoti
import yjyoondev.composeapp.generated.resources.side_kwpass
import yjyoondev.composeapp.generated.resources.side_loco
import yjyoondev.composeapp.generated.resources.side_mbtmi
import yjyoondev.composeapp.generated.resources.side_missing
import yjyoondev.composeapp.generated.resources.side_moime
import yjyoondev.composeapp.generated.resources.side_neuro
import yjyoondev.composeapp.generated.resources.side_pimo
import yjyoondev.composeapp.generated.resources.side_ssoda
import yjyoondev.composeapp.generated.resources.side_whatnow
import yjyoondev.composeapp.generated.resources.side_yjyoon_dev

enum class SideProject(
    val titleRes: StringResource,
    val logoRes: DrawableResource,
    val url: String?
) {
    Alreadyme(
        titleRes = Res.string.side_alreadyme,
        logoRes = Res.drawable.ic_side_alreadyme,
        url = "https://github.com/readme-generator/alreadyme-desktop"
    ),
    Coverist(
        titleRes = Res.string.side_coverist,
        logoRes = Res.drawable.ic_side_coverist,
        url = "https://github.com/coverist"
    ),
    Droidknights(
        titleRes = Res.string.side_droidknights2023,
        logoRes = Res.drawable.ic_side_droidknights,
        url = "https://github.com/yjyoon-dev/DroidKnights2023_App"
    ),
    Enphago(
        titleRes = Res.string.side_enphago,
        logoRes = Res.drawable.ic_side_enphago,
        url = "https://github.com/yjyoon-dev/enphago-android"
    ),
    GoorleMap(
        titleRes = Res.string.side_goorlemap,
        logoRes = Res.drawable.ic_side_goorlemap,
        url = null
    ),
    JsGame(
        titleRes = Res.string.side_jsgame,
        logoRes = Res.drawable.ic_side_jsgame,
        url = "https://github.com/yjyoon-dev/javascript-mini-game"
    ),
    Knowlly(
        titleRes = Res.string.side_knowlly,
        logoRes = Res.drawable.ic_side_knowlly,
        url = "https://github.com/yjyoon-dev/knowlly-android"
    ),
    KwDorm(
        titleRes = Res.string.side_kwdorm,
        logoRes = Res.drawable.ic_side_kwdorm,
        url = "https://github.com/kw-dormitory/kw-dormitory-mobile"
    ),
    KwNoti(
        titleRes = Res.string.side_kwnoti,
        logoRes = Res.drawable.ic_side_kwnoti,
        url = "https://github.com/kw-service/kw-notice-android-v2"
    ),
    KwPass(
        titleRes = Res.string.side_kwpass,
        logoRes = Res.drawable.ic_side_kwpass,
        url = "https://github.com/kw-service/kw-pass-wearos"
    ),
    Loco(
        titleRes = Res.string.side_loco,
        logoRes = Res.drawable.ic_side_loco,
        url = "https://github.com/love-compass/loco-android"
    ),
    Mbtmi(
        titleRes = Res.string.side_mbtmi,
        logoRes = Res.drawable.ic_side_mbtmi,
        url = "https://github.com/sw-hackathon-2022/mbtmi-flutter"
    ),
    Missing(
        titleRes = Res.string.side_missing,
        logoRes = Res.drawable.ic_side_missing,
        url = "https://github.com/oss-talkative/missing-mobile"
    ),
    Moime(
        titleRes = Res.string.side_moime,
        logoRes = Res.drawable.ic_side_moime,
        url = "https://github.com/team-capybara/moime-mobile"
    ),
    Neuro(
        titleRes = Res.string.side_neuro,
        logoRes = Res.drawable.ic_side_neuro,
        url = "https://github.com/neurosky-internship/zonetrainer-android"
    ),
    Pimo(
        titleRes = Res.string.side_pimo,
        logoRes = Res.drawable.ic_side_pimo,
        url = "https://github.com/Nexters-PIMO/PIMO_Android"
    ),
    Ssoda(
        titleRes = Res.string.side_ssoda,
        logoRes = Res.drawable.ic_side_ssoda,
        url = "https://github.com/yjyoon-dev/ssoda"
    ),
    Whatnow(
        titleRes = Res.string.side_whatnow,
        logoRes = Res.drawable.ic_side_whatnow,
        url = "https://github.com/yjyoon-dev/whatnow-android"
    ),
    YjyoonDev(
        titleRes = Res.string.side_yjyoon_dev,
        logoRes = Res.drawable.ic_side_yjyoon_dev,
        url = "https://github.com/yjyoon-dev/yjyoon.dev"
    )
}
