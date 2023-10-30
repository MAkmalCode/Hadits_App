package com.malbyte.haditskalamunalim.ui.Perawi

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.malbyte.haditskalamunalim.data.factory.ViewModelFactory
import com.malbyte.haditskalamunalim.ui.Perawi.state.PerawiState
import com.malbyte.haditskalamunalim.ui.components.PerawiItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerawiScreen(
    perawiViewModel: PerawiViewModel = viewModel(factory = ViewModelFactory.getInstance())
) {
    val getPerawiState by perawiViewModel.getPerawi.collectAsState()
    perawiViewModel.getList()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Perawi", fontSize = 32.sp) })
        }
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        when (val state = getPerawiState) {
            is PerawiState.Error -> {
                Box(
                    modifier = Modifier.padding(it),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = state.message)
                }
            }

            is PerawiState.Loading -> {
                Box(
                    modifier = Modifier.padding(it),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }

            is PerawiState.Success -> {
                Column(modifier = Modifier.padding(it)) {
                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        content = {
                            items(state.list){
                                PerawiItem(perawi = it.name, jumlahHadits = it.total)
                            }
                        })
                }
            }

            null -> {

            }
        }
    }
}

@Preview
@Composable
fun PerawiPrev() {
    PerawiScreen()
}