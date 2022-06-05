package ru.kheynov.feature_stories.stories_progress

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun StoriesProgressBar(
    modifier: Modifier = Modifier,
    size: Int = 5,
    state: Int,
) {
    val progress: List<Boolean> = List(size) { index -> index < state }
    LazyRow(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        items(progress.size) { state ->
            StoryProgressElement(isChecked = progress[state])
        }
    }
}