package com.malbyte.haditskalamunalim

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.malbyte.haditskalamunalim.ui.Perawi.PerawiScreen
import com.malbyte.haditskalamunalim.ui.hadits.HaditsScreen
import com.malbyte.haditskalamunalim.ui.theme.HaditsKalamunAlimTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HaditsKalamunAlimTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HaditsScreen()
                }
            }
        }
    }
}