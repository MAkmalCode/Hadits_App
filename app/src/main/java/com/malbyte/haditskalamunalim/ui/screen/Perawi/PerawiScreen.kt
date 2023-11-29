package com.malbyte.haditskalamunalim.ui.screen.Perawi

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.malbyte.haditskalamunalim.HaditsComposeApplicatiom
import com.malbyte.haditskalamunalim.data.factory.ViewModelFactory
import com.malbyte.haditskalamunalim.ui.components.PerawiItem
import com.malbyte.haditskalamunalim.ui.screen.Perawi.state.PerawiState
import com.malbyte.haditskalamunalim.ui.screen.destinations.HaditsScreenDestination
import com.malbyte.haditskalamunalim.ui.screen.hadits.HaditsListScreenNavArgs
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@OptIn(ExperimentalMaterial3Api::class)
@RootNavGraph(start = true)
@Destination
@Composable
fun PerawiScreen(
    navigator: DestinationsNavigator,
    viewModel: PerawiViewModel = viewModel(
        factory = ViewModelFactory {
            PerawiViewModel(HaditsComposeApplicatiom.repository)
        }
    )
) {
    viewModel.getList()
    val perawiState by viewModel.getPerawi.collectAsStateWithLifecycle()
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Perawi", fontSize = 32.sp) })
        }
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        when (val state = perawiState) {
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
                            items(state.list) {
                                PerawiItem(perawi = it.name, jumlahHadits = it.total) {
                                    navigator.navigate(
                                        HaditsScreenDestination(
                                            navArgs = HaditsListScreenNavArgs(it.slug)
                                        )
                                    )
                                }
                            }
                        })
                }
            }

            null -> {

            }
        }
    }
}
