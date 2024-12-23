package dev.yjyoon.hello.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.yjyoon.hello.ui.model.Section
import org.jetbrains.compose.resources.stringResource

@Composable
fun ModalDrawerContent(
    onClickItem: (Section) -> Unit,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    ModalDrawerSheet(
        modifier = modifier,
        drawerShape = RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp),
        drawerContainerColor = MaterialTheme.colorScheme.primaryContainer,
        drawerContentColor = MaterialTheme.colorScheme.onPrimaryContainer
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .verticalScroll(rememberScrollState())
        ) {
            IconButton(onClick = onDismissRequest) {
                Icon(
                    Icons.Default.Close,
                    contentDescription = null
                )
            }
            Section.entries.forEach {
                NavigationDrawerItem(
                    label = { Text(stringResource(it.title)) },
                    selected = false,
                    onClick = { onClickItem(it) }
                )
            }
        }
    }
}
