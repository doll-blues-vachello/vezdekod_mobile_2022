package ru.kheynov.vezdekodmobile2022

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.ui.platform.LocalContext
import ru.kheynov.feature_login.LoginScreen

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            LoginScreen(onResult = {
                    Toast.makeText(context, "ABOBA,  $it", Toast.LENGTH_SHORT).show()
                })
        }
    }
}
