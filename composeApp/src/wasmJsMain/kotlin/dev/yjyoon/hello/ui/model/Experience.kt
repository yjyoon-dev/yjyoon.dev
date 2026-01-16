package dev.yjyoon.hello.ui.model

import org.jetbrains.compose.resources.StringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.sharing_super_init_6
import yjyoondev.composeapp.generated.resources.sharing_super_init_6_date
import yjyoondev.composeapp.generated.resources.sharing_naver_engineering_day_2025
import yjyoondev.composeapp.generated.resources.sharing_naver_engineering_day_2025_date
import yjyoondev.composeapp.generated.resources.awards_cau_campus_town
import yjyoondev.composeapp.generated.resources.awards_cau_campus_town_prize
import yjyoondev.composeapp.generated.resources.awards_cau_campus_town_year
import yjyoondev.composeapp.generated.resources.awards_kw_univ_ai
import yjyoondev.composeapp.generated.resources.awards_kw_univ_ai_prize
import yjyoondev.composeapp.generated.resources.awards_kw_univ_ai_year
import yjyoondev.composeapp.generated.resources.awards_oss_contest
import yjyoondev.composeapp.generated.resources.awards_oss_contest_prize
import yjyoondev.composeapp.generated.resources.awards_oss_contest_year
import yjyoondev.composeapp.generated.resources.awards_sw_univ_hackathon
import yjyoondev.composeapp.generated.resources.awards_sw_univ_hackathon_prize
import yjyoondev.composeapp.generated.resources.awards_sw_univ_hackathon_year
import yjyoondev.composeapp.generated.resources.awards_swm_hackathon
import yjyoondev.composeapp.generated.resources.awards_swm_hackathon_prize
import yjyoondev.composeapp.generated.resources.awards_swm_hackathon_year
import yjyoondev.composeapp.generated.resources.certificates_aws_csa
import yjyoondev.composeapp.generated.resources.certificates_aws_csa_level
import yjyoondev.composeapp.generated.resources.certificates_aws_csa_year
import yjyoondev.composeapp.generated.resources.certificates_topcit
import yjyoondev.composeapp.generated.resources.certificates_topcit_level
import yjyoondev.composeapp.generated.resources.certificates_topcit_year
import yjyoondev.composeapp.generated.resources.global_neurosky
import yjyoondev.composeapp.generated.resources.global_neurosky_date
import yjyoondev.composeapp.generated.resources.global_san_jose_univ
import yjyoondev.composeapp.generated.resources.global_san_jose_univ_date
import yjyoondev.composeapp.generated.resources.mentor_kusitms
import yjyoondev.composeapp.generated.resources.mentor_kusitms_date
import yjyoondev.composeapp.generated.resources.mentor_sw_meister_high_school
import yjyoondev.composeapp.generated.resources.mentor_sw_meister_high_school_date
import yjyoondev.composeapp.generated.resources.mentor_woongjin_game_challenge
import yjyoondev.composeapp.generated.resources.mentor_woongjin_game_challenge_date
import yjyoondev.composeapp.generated.resources.sharing_kugs_kmp_meetup_2025
import yjyoondev.composeapp.generated.resources.sharing_kugs_kmp_meetup_2025_date

sealed interface Experience {
    val titleRes: StringResource
    val dateRes: StringResource
}

enum class Sharing(
    override val titleRes: StringResource,
    override val dateRes: StringResource
) : Experience {
    KmpMeetup2025(
      titleRes = Res.string.sharing_kugs_kmp_meetup_2025,
      dateRes = Res.string.sharing_kugs_kmp_meetup_2025_date
    ),
    NaverEngineeringDay2025(
        titleRes = Res.string.sharing_naver_engineering_day_2025,
        dateRes = Res.string.sharing_naver_engineering_day_2025_date
    ),
    SuperInit6(
        titleRes = Res.string.sharing_super_init_6,
        dateRes = Res.string.sharing_super_init_6_date
    )
}

enum class Mentor(
    override val titleRes: StringResource,
    override val dateRes: StringResource
) : Experience {
    Kusitms(
        titleRes = Res.string.mentor_kusitms,
        dateRes = Res.string.mentor_kusitms_date
    ),
    SwMeisterHighSchool(
        titleRes = Res.string.mentor_sw_meister_high_school,
        dateRes = Res.string.mentor_sw_meister_high_school_date
    ),
    WoongjinGameChallenge(
        titleRes = Res.string.mentor_woongjin_game_challenge,
        dateRes = Res.string.mentor_woongjin_game_challenge_date
    )
}

enum class Global(
    override val titleRes: StringResource,
    override val dateRes: StringResource
) : Experience {
    Neurosky(
        titleRes = Res.string.global_neurosky,
        dateRes = Res.string.global_neurosky_date
    ),
    SanJoseUniv(
        titleRes = Res.string.global_san_jose_univ,
        dateRes = Res.string.global_san_jose_univ_date
    )
}

enum class Awards(
    override val titleRes: StringResource,
    val prizeRes: StringResource,
    override val dateRes: StringResource
) : Experience {
    OssContest(
        titleRes = Res.string.awards_oss_contest,
        prizeRes = Res.string.awards_oss_contest_prize,
        dateRes = Res.string.awards_oss_contest_year
    ),
    SwUnivHackathon(
        titleRes = Res.string.awards_sw_univ_hackathon,
        prizeRes = Res.string.awards_sw_univ_hackathon_prize,
        dateRes = Res.string.awards_sw_univ_hackathon_year
    ),
    CauCampusTown(
        titleRes = Res.string.awards_cau_campus_town,
        prizeRes = Res.string.awards_cau_campus_town_prize,
        dateRes = Res.string.awards_cau_campus_town_year
    ),
    SwmHackathon(
        titleRes = Res.string.awards_swm_hackathon,
        prizeRes = Res.string.awards_swm_hackathon_prize,
        dateRes = Res.string.awards_swm_hackathon_year
    ),
    KwUnivAi(
        titleRes = Res.string.awards_kw_univ_ai,
        prizeRes = Res.string.awards_kw_univ_ai_prize,
        dateRes = Res.string.awards_kw_univ_ai_year
    )
}

enum class Certificate(
    override val titleRes: StringResource,
    val levelRes: StringResource,
    override val dateRes: StringResource
) : Experience {
    Topcit(
        titleRes = Res.string.certificates_topcit,
        levelRes = Res.string.certificates_topcit_level,
        dateRes = Res.string.certificates_topcit_year
    ),
    AwsCsa(
        titleRes = Res.string.certificates_aws_csa,
        levelRes = Res.string.certificates_aws_csa_level,
        dateRes = Res.string.certificates_aws_csa_year
    )
}
