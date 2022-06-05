package ru.kheynov.vezdekodmobile2022

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import ru.kheynov.feature_stories.StoriesScreen

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MainScreen()
            StoriesScreen()
        }
    }
}
