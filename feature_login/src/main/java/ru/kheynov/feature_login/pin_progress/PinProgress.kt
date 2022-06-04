package ru.kheynov.feature_login.pin_progress

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PinProgress(
    modifier: Modifier = Modifier,
    size: Int = 4,
    state: Int,
) {
    val progress: List<Boolean> = List(size) { index -> index < state }
    LazyRow(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        items(progress.size) { state ->
            PinDot(isChecked = progress[state])
        }
    }
}
