package com.malbyte.haditskalamunalim.ui.hadits

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.malbyte.haditskalamunalim.ui.components.HaditsItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HaditsScreen() {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Hadits", fontSize = 32.sp) })
        }
    ) {
        Column(modifier = Modifier.padding(it)) {
            Text(text = "Perawi: Bukhari", modifier = Modifier.padding(start = 16.dp), fontSize = 24.sp)
            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(content = {
                items(10) {
                    HaditsItem(
                        noHadits = 1,
                        hadits = "Lorem ipsum dolor sit amet, consectetur adipiscing " +
                                "elit. Cras scelerisque justo vitae nisi pretium accumsan. " +
                                "Aliquam vitae ex metus. Phasellus non tortor vel orci " +
                                "pulvinar finibus a eu ligula. In bibendum pretium " +
                                "ullamcorper. Suspendisse potenti. Sed ex nibh, ultrices eget " +
                                "condimentum vitae, convallis a nibh.",
                        translate = "Lorem ipsum dolor sit amet, consectetur adipiscing " +
                                "elit. Cras scelerisque justo vitae nisi pretium accumsan. " +
                                "Aliquam vitae ex metus. Phasellus non tortor vel orci " +
                                "pulvinar finibus a eu ligula. In bibendum pretium " +
                                "ullamcorper. Suspendisse potenti. Sed ex nibh, ultrices eget " +
                                "condimentum vitae, convallis a nibh."
                    )
                }
            })
        }
    }
}

@Preview
@Composable
fun HaditsPreview() {
    HaditsScreen()
}