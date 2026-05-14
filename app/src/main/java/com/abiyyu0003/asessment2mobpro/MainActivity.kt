package com.abiyyu0003.mobpro1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.abiyyu0003.asessment2mobpro.ui.theme.Asessment2MobproTheme
import com.abiyyu0003.mobpro1.ui.screen.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Asessment2MobproTheme() {
                MainScreen()
            }
        }
    }
}