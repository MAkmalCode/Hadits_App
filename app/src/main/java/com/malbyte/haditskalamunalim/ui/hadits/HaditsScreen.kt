package com.malbyte.haditskalamunalim.ui.hadits

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.malbyte.haditskalamunalim.ui.components.HaditsItem
import com.malbyte.haditskalamunalim.ui.hadits.state.HaditsState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HaditsScreen(
    haditsViewModel: HaditsViewModel = viewModel(factory = ViewModelFactory.getInstance())
) {
    val haditsState by haditsViewModel.getHaditsState.collectAsState()
    haditsViewModel.getHadits("abu-dawud", 1)
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Hadits", fontSize = 32.sp) })
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Text(text = "Perawi: Bukhari", modifier = Modifier.padding(start = 16.dp), fontSize = 24.sp)
            Spacer(modifier = Modifier.height(20.dp))

            when(val state = haditsState){
                is HaditsState.Error -> {
                    Box(
                        modifier = Modifier.padding(it),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = state.message)
                    }
                }
                is HaditsState.Loading -> {
                    Box(
                        modifier = Modifier.padding(it),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }
                is HaditsState.Success -> {
                    LazyColumn(content = {
                        items(state.list.items){
                            HaditsItem(noHadits = it.number, hadits = it.arab, translate = it.id)
                        }
                    })
                }
                null -> {

                }
            }
        }
    }
}

@Preview
@Composable
fun HaditsPreview() {
    HaditsScreen()
}