package ru.kheynov.feature_login.pin_pad

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.sp
import ru.kheynov.feature_login.R

@Composable
fun PinDigitPad(
    index: Int,
    onClick: (index: Int) -> Unit,
) {
    Box(contentAlignment = Alignment.Center) {
        Image(
            modifier = Modifier.clickable(onClick = { onClick(index) }),
            imageVector = ImageVector.vectorResource(id = R.drawable
                .ic_password_digit_pad),
            contentDescription = "password digit")
        Text(text = index.toString(), fontSize = 36.sp, color = Color.White)
    }
}
