package dev.yjyoon.hello.ui.model

import org.jetbrains.compose.resources.DrawableResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.ic_email
import yjyoondev.composeapp.generated.resources.ic_github
import yjyoondev.composeapp.generated.resources.ic_instagram
import yjyoondev.composeapp.generated.resources.ic_linkedin

enum class Contact(
    val iconRes: DrawableResource,
    val url: String
) {
    Github(
        iconRes = Res.drawable.ic_github,
        url = "https://github.com/yjyoon-dev"
    ),
    LinkedIn(
        iconRes = Res.drawable.ic_linkedin,
        url = "https://www.linkedin.com/in/yjyoon-dev/"
    ),
    Instagram(
        iconRes = Res.drawable.ic_instagram,
        url = "https://www.instagram.com/yjyo_on"
    ),
    Email(
        iconRes = Res.drawable.ic_email,
        url = "mailto:me@yjyoon.dev"
    )
}
