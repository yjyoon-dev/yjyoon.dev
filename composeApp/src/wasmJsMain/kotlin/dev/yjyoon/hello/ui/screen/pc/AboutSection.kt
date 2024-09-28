package dev.yjyoon.hello.ui.screen.pc

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AboutSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.then(
            Modifier
                .fillMaxWidth()
                .aspectRatio(21 / 9f)
                .background(color = MaterialTheme.colorScheme.onBackground)
                .padding(horizontal = CONTENT_HORIZONTAL_PADDING.dp)
        )
    ) { }
}
