package ru.kheynov.feature_login.pin_pad

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import ru.kheynov.feature_login.R

@Composable
fun PinPad(
    modifier: Modifier = Modifier,
    onClick: (digit: Int) -> Unit,
) {
    Column(modifier = modifier) {
        LazyRow(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            items((1..3).toList()) { idx ->
                PinDigitPad(index = idx, onClick = { onClick(idx) })
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        LazyRow(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            items((4..6).toList()) { idx ->
                PinDigitPad(index = idx, onClick = { onClick(idx) })
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        LazyRow(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            items((7..9).toList()) { idx ->
                PinDigitPad(index = idx, onClick = { onClick(idx) })
            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Box(modifier = Modifier.size(75.dp).clickable {
                onClick(-1)
            }, contentAlignment = Alignment.Center) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_help_button),
                    contentDescription = "help button")
            }

            PinDigitPad(index = 0, onClick = { onClick(0) })

            Box(modifier = Modifier.size(75.dp).clickable {
                                                          onClick(-2)
            }, contentAlignment = Alignment.Center) {
                Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_erase_button),
                    contentDescription = "erase button")
            }
        }
    }
}