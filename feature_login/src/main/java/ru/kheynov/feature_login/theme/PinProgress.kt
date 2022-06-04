package ru.kheynov.feature_login.theme

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.kheynov.feature_login.pin_progress.PinDot

@Composable
fun PinProgress(
    modifier: Modifier = Modifier,
    state: List<Boolean>,
) {
    LazyRow(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        items(state) { state ->
            PinDot(isChecked = state)
        }
    }
}
