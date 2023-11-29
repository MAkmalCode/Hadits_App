package com.malbyte.haditskalamunalim.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerawiItem(perawi: String, jumlahHadits: Int, goToHadits: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(4.dp),
        onClick = { goToHadits() }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            Color.Blue,
                            Color.Green
                        )
                    ),
                    RoundedCornerShape(5.dp)
                )
                .padding(16.dp)
        ) {
            Text(
                text = perawi,
                fontSize = 24.sp,
                color = Color.White,
            )
            Text(
                text = jumlahHadits.toString(),
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun IPerawiPrev() {
    PerawiItem("Bukhari", 4409) {}
}