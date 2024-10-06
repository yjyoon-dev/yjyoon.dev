package dev.yjyoon.hello.ui.model

import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.android
import yjyoondev.composeapp.generated.resources.aws
import yjyoondev.composeapp.generated.resources.compose
import yjyoondev.composeapp.generated.resources.flutter
import yjyoondev.composeapp.generated.resources.ic_android
import yjyoondev.composeapp.generated.resources.ic_aws
import yjyoondev.composeapp.generated.resources.ic_compose
import yjyoondev.composeapp.generated.resources.ic_flutter
import yjyoondev.composeapp.generated.resources.ic_java
import yjyoondev.composeapp.generated.resources.ic_kotlin
import yjyoondev.composeapp.generated.resources.ic_ktor
import yjyoondev.composeapp.generated.resources.ic_supabase
import yjyoondev.composeapp.generated.resources.java
import yjyoondev.composeapp.generated.resources.kotlin
import yjyoondev.composeapp.generated.resources.ktor
import yjyoondev.composeapp.generated.resources.supabase

enum class Skill(
    val title: StringResource,
    val logo: DrawableResource,
    val url: String
) {
    Kotlin(
        title = Res.string.kotlin,
        logo = Res.drawable.ic_kotlin,
        url = "https://kotlinlang.org/"
    ),
    Java(
        title = Res.string.java,
        logo = Res.drawable.ic_java,
        url = "https://java.com/"
    ),
    Android(
        title = Res.string.android,
        logo = Res.drawable.ic_android,
        url = "https://developer.android.com/"
    ),
    Compose(
        title = Res.string.compose,
        logo = Res.drawable.ic_compose,
        url = "https://www.jetbrains.com/ko-kr/compose-multiplatform/"
    ),
    Flutter(
        title = Res.string.flutter,
        logo = Res.drawable.ic_flutter,
        url = "https://flutter.dev/"
    ),
    Ktor(
        title = Res.string.ktor,
        logo = Res.drawable.ic_ktor,
        url = "https://ktor.io/"
    ),
    Supabase(
        title = Res.string.supabase,
        logo = Res.drawable.ic_supabase,
        url = "https://supabase.com/"
    ),
    AWS(
        title = Res.string.aws,
        logo = Res.drawable.ic_aws,
        url = "https://aws.amazon.com/"
    )
}
