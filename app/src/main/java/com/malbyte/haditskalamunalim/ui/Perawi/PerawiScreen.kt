package com.malbyte.haditskalamunalim.ui.Perawi

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.malbyte.haditskalamunalim.ui.components.PerawiItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerawiScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Perawi", fontSize = 32.sp) })
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Spacer(modifier = Modifier.height(20.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                content = {
                    items(10) {
                        PerawiItem(perawi = "Bukhari", jumlahHadits = 4000)
                    }
                })
        }
    }
}

@Preview
@Composable
fun PerawiPrev() {
    PerawiScreen()
}