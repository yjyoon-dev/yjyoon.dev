package dev.yjyoon.hello.ui.model

import org.jetbrains.compose.resources.StringResource
import yjyoondev.composeapp.generated.resources.Res
import yjyoondev.composeapp.generated.resources.section_about
import yjyoondev.composeapp.generated.resources.section_career
import yjyoondev.composeapp.generated.resources.section_contact
import yjyoondev.composeapp.generated.resources.section_experience
import yjyoondev.composeapp.generated.resources.section_home

enum class Section(
    val title: StringResource
) {
    Home(Res.string.section_home),
    AboutMe(Res.string.section_about),
    Career(Res.string.section_career),
    Experience(Res.string.section_experience),
    Contact(Res.string.section_contact)
}
