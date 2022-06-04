package ru.kheynov.feature_login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.kheynov.feature_login.pin_pad.PinPad
import ru.kheynov.feature_login.pin_progress.PinProgress
import ru.kheynov.feature_login.theme.LoginScreenTheme

@Composable
fun LoginScreen() {
    LoginScreenTheme {
        Surface(modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background) {
            Column {
                Spacer(modifier = Modifier.height(100.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(R.drawable.ic_mail_logo),
                        contentDescription = "mail_ru_logo",
                    )
                }
                Spacer(modifier = Modifier.height(32.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Text(text = "Введите пин-код", fontSize = 20.sp,
                        color = Color.White)
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                    PinProgress(modifier = Modifier.width(127.dp), state = 3)
                }
                Spacer(modifier = Modifier.height(52.dp))
                Row(modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center) {
                    PinPad(
                        modifier = Modifier.padding(horizontal = 54.dp),
                        onClick = { idx ->
                            Log.i("LoginScreen", "Button $idx pressed ")
                        })
                }
            }
        }
    }
}
