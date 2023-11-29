package com.malbyte.haditskalamunalim.ui.screen.hadits

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import com.malbyte.haditskalamunalim.HaditsComposeApplicatiom
import com.malbyte.haditskalamunalim.data.factory.ViewModelFactory
import com.malbyte.haditskalamunalim.ui.components.HaditsItem
import com.ramcosta.composedestinations.annotation.Destination

data class HaditsListScreenNavArgs(
    val perawi: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Destination(
    navArgsDelegate = HaditsListScreenNavArgs::class
)
@Composable
fun HaditsScreen(
    viewModel: HaditsViewModel = viewModel(
        factory = ViewModelFactory { handle ->
            HaditsViewModel(HaditsComposeApplicatiom.repository, handle)
        }
    )
) {
    val haditsList = viewModel.getHadits.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Hadits", fontSize = 32.sp) })
        }
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Column(modifier = Modifier.padding(it)) {

            Text(
                text = "Perawi: ${viewModel.perawiName}",
                modifier = Modifier.padding(start = 16.dp),
                fontSize = 24.sp
            )
            Spacer(modifier = Modifier.height(20.dp))
            LazyColumn(content = {
                items(
                    haditsList.itemCount,
                    key = { haditsList[it]?.number!! },
                    contentType = haditsList.itemContentType { "haditsListPaging" }
                ) { index ->
                    val haditsItem = haditsList[index]

                    HaditsItem(
                        noHadits = haditsItem!!.number,
                        hadits = haditsItem.arab,
                        translate = haditsItem.id,
                        perawiName = viewModel.perawiName
                    )
                }

                when (haditsList.loadState.refresh) {
                    is LoadState.Error -> item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Error fetching data")
                            Button(onClick = { haditsList.refresh() }) {
                                Text(text = "Refresh")
                            }
                        }
                    }

                    is LoadState.Loading -> item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }

                    else -> {

                    }
                }

                when (haditsList.loadState.append) {
                    is LoadState.Error -> item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(text = "Error fetching data")
                            Button(onClick = { haditsList.refresh() }) {
                                Text(text = "Refresh")
                            }
                        }
                    }

                    is LoadState.Loading -> item {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator()
                        }
                    }

                    else -> {

                    }
                }
            })
        }
    }
}