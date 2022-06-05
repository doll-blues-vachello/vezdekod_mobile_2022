package ru.kheynov.feature_stories.stories_progress

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import ru.kheynov.feature_stories.R.drawable.ic_story_progress_element_bold
import ru.kheynov.feature_stories.R.drawable.ic_story_progress_element_empty

@Composable
fun StoryProgressElement(
    isChecked: Boolean = false,
) {
    Image(
        imageVector = ImageVector.vectorResource(
            id = if (isChecked) ic_story_progress_element_bold
            else ic_story_progress_element_empty
        ),
        contentDescription = "Story progress element",
    )
}