package com.example.kalavidarabalaga.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class SearchTroupeData(

    val troupeName: String,

    val artForm: String,

    val district: String
)

@Composable
fun SearchScreen() {

    var searchText by remember {

        mutableStateOf("")
    }

    val troupeList = listOf(

        SearchTroupeData(
            troupeName = "Sahyadri Dollu Troupe",
            artForm = "Dollu Kunitha",
            district = "Mysuru"
        ),

        SearchTroupeData(
            troupeName = "Yakshagana Mela",
            artForm = "Yakshagana",
            district = "Udupi"
        ),

        SearchTroupeData(
            troupeName = "Kolata Kala Team",
            artForm = "Kolata",
            district = "Mandya"
        ),

        SearchTroupeData(
            troupeName = "Drama Artists",
            artForm = "Drama",
            district = "Bengaluru"
        ),

        SearchTroupeData(
            troupeName = "Veeragase Balaga",
            artForm = "Veeragase",
            district = "Belagavi"
        )
    )

    val filteredList = troupeList.filter {

        it.troupeName.contains(
            searchText,
            ignoreCase = true
        )
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8F0))
            .padding(12.dp)
    ) {

        Text(

            text = "Search Troupes",

            fontSize = 30.sp,

            fontWeight =
                FontWeight.Bold,

            color = Color(0xFFB23A1B)
        )

        Spacer(
            modifier =
                Modifier.height(16.dp)
        )

        OutlinedTextField(

            value = searchText,

            onValueChange = {

                searchText = it
            },

            label = {

                Text("Search by troupe name")
            },

            modifier =
                Modifier.fillMaxWidth()
        )

        Spacer(
            modifier =
                Modifier.height(16.dp)
        )

        LazyColumn(

            verticalArrangement =
                Arrangement.spacedBy(12.dp),

            contentPadding =
                PaddingValues(bottom = 100.dp)
        ) {

            items(filteredList) { troupe ->

                Card(

                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {

                        },

                    shape =
                        RoundedCornerShape(16.dp)
                ) {

                    Column(

                        modifier =
                            Modifier.padding(18.dp)
                    ) {

                        Text(

                            text =
                                troupe.troupeName,

                            fontSize = 22.sp,

                            fontWeight =
                                FontWeight.Bold
                        )

                        Spacer(
                            modifier =
                                Modifier.height(8.dp)
                        )

                        Text(
                            text =
                                "Art Form: ${troupe.artForm}"
                        )

                        Text(
                            text =
                                "District: ${troupe.district}"
                        )
                    }
                }
            }
        }
    }
}