package com.example.kalavidarabalaga.ui.screens

import androidx.compose.foundation.background
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

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ArtistData(

    val artistName: String,

    val artType: String,

    val district: String,

    val experience: String,

    val phone: String,

    val about: String
)

@Composable
fun ArtistScreen() {

    val artistList = listOf(

        ArtistData(
            artistName = "Sudeep",
            artType = "Dollu Kunitha",
            district = "Mysuru",
            experience = "12 Years",
            phone = "9108727807",
            about = "Traditional Dollu Kunitha Artist"
        ),

        ArtistData(
            artistName = "Rahul",
            artType = "Yakshagana",
            district = "Udupi",
            experience = "10 Years",
            phone = "9876543210",
            about = "Yakshagana Performer"
        ),

        ArtistData(
            artistName = "Kiran",
            artType = "Kolata",
            district = "Mandya",
            experience = "8 Years",
            phone = "9988776655",
            about = "Kolata Dance Artist"
        ),

        ArtistData(
            artistName = "Puneeth",
            artType = "Veeragase",
            district = "Belagavi",
            experience = "15 Years",
            phone = "9663322114",
            about = "Veeragase Performer"
        ),

        ArtistData(
            artistName = "Tarun",
            artType = "Drama",
            district = "Bengaluru",
            experience = "6 Years",
            phone = "8660346894",
            about = "Drama Artist"
        )
    )

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8F0))
            .padding(12.dp)
    ) {

        Text(

            text = "Artists",

            fontSize = 30.sp,

            fontWeight =
                FontWeight.Bold,

            color = Color(0xFFB23A1B)
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

            items(artistList) { artist ->

                Card(

                    modifier =
                        Modifier.fillMaxWidth(),

                    shape =
                        RoundedCornerShape(18.dp)
                ) {

                    Column(

                        modifier =
                            Modifier.padding(18.dp)
                    ) {

                        Text(

                            text =
                                artist.artistName,

                            fontSize = 24.sp,

                            fontWeight =
                                FontWeight.Bold
                        )

                        Spacer(
                            modifier =
                                Modifier.height(10.dp)
                        )

                        Text(
                            text =
                                "Art Type: ${artist.artType}"
                        )

                        Text(
                            text =
                                "District: ${artist.district}"
                        )

                        Text(
                            text =
                                "Experience: ${artist.experience}"
                        )

                        Text(
                            text =
                                "Phone: ${artist.phone}"
                        )

                        Spacer(
                            modifier =
                                Modifier.height(10.dp)
                        )

                        Text(
                            text =
                                artist.about
                        )

                        Spacer(
                            modifier =
                                Modifier.height(14.dp)
                        )

                        Button(

                            onClick = {

                            },

                            modifier =
                                Modifier.fillMaxWidth(),

                            colors =
                                ButtonDefaults.buttonColors(
                                    containerColor =
                                        Color(0xFFB23A1B)
                                )
                        ) {

                            Text(
                                text = "Contact Artist"
                            )
                        }
                    }
                }
            }
        }
    }
}