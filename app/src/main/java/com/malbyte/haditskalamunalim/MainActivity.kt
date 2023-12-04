package com.malbyte.haditskalamunalim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.malbyte.haditskalamunalim.ui.screen.NavGraphs
import com.malbyte.haditskalamunalim.ui.theme.HaditsKalamunAlimTheme
import com.ramcosta.composedestinations.DestinationsNavHost

class MainActivity : ComponentActivity() {
//    private val perawiVM: PerawiViewModel =  PerawiViewModel(HaditsComposeApplication.repository)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    installSplashScreen()
    setContent {
            HaditsKalamunAlimTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DestinationsNavHost(
                        navGraph = NavGraphs.root
                    )
                }
            }
        }
    }
}