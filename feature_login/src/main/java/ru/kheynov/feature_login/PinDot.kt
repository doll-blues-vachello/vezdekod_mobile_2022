package ru.kheynov.feature_login

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

@Composable
fun PinDot(
    isChecked: Boolean = false,
) {
    Image(
        imageVector = ImageVector.vectorResource(
            id = if (isChecked) R.drawable.ic_circle_bold
            else R.drawable.ic_circle_empty
        ),
        contentDescription = "Pin dot",
    )
}