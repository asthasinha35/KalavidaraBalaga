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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.lifecycle.viewmodel.compose.viewModel

import com.example.kalavidarabalaga.data.TroupeEntity

@Composable
fun TroupesScreen() {

    val troupeViewModel: TroupeViewModel =
        viewModel()

    val roomTroupes by troupeViewModel
        .troupeList
        .collectAsState(initial = emptyList())
    val defaultTroupes = listOf(

        TroupeEntity(
            name = "Sahyadri Dollu Troupe",
            artForm = "Dollu Kunitha",
            district = "Mysuru",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/dollu_kunitha",
            leaderName = "Sudeep",
            contact = "9108727807",
            about = "Traditional Dollu Kunitha artists."
        ),

        TroupeEntity(
            name = "Yakshagana Mela",
            artForm = "Yakshagana",
            district = "Udupi",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/yakshagana",
            leaderName = "Rahul",
            contact = "9876543210",
            about = "Yakshagana performers."
        ),

        TroupeEntity(
            name = "Kolata Kala Team",
            artForm = "Kolata",
            district = "Mandya",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/kolata",
            leaderName = "Kiran",
            contact = "9988776655",
            about = "Kolata dance troupe."
        ),

        TroupeEntity(
            name = "Veeragase Balaga",
            artForm = "Veeragase",
            district = "Belagavi",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/veeragase",
            leaderName = "Puneeth",
            contact = "9663322114",
            about = "Veeragase artists."
        ),

        TroupeEntity(
            name = "Drama Artists",
            artForm = "Drama",
            district = "Bengaluru",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/drama",
            leaderName = "Tarun",
            contact = "8660346894",
            about = "Drama troupe."
        ),

        TroupeEntity(
            name = "Gamaka Sangha",
            artForm = "Gamaka",
            district = "Tumakuru",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/gamaka",
            leaderName = "Ramesh",
            contact = "9988112233",
            about = "Gamaka artists."
        ),

        TroupeEntity(
            name = "Nadaswara Balaga",
            artForm = "Nadaswara",
            district = "Mandya",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/nadaswara",
            leaderName = "Mahesh",
            contact = "9001122334",
            about = "Traditional Nadaswara artists."
        ),

        TroupeEntity(
            name = "Chitrakala Academy",
            artForm = "Chitrakala",
            district = "Davangere",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/chitrakala",
            leaderName = "Arun",
            contact = "9112233445",
            about = "Painting artists."
        ),

        TroupeEntity(
            name = "Janapada Team",
            artForm = "Janapada",
            district = "Hassan",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/janapada_songs",
            leaderName = "Naveen",
            contact = "9223344556",
            about = "Janapada singers."
        ),

        TroupeEntity(
            name = "Dance Crew Karnataka",
            artForm = "Dance",
            district = "Hubballi",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/dance_group",
            leaderName = "Akhil",
            contact = "9889900112",
            about = "Dance performers."
        ),

        TroupeEntity(
            name = "Bharatanatya Kala Sangha",
            artForm = "Bharatanatyam",
            district = "Bengaluru",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/bharatanatya",
            leaderName = "Ananya",
            contact = "9444556677",
            about = "Classical Bharatanatyam dancers."
        ),

        TroupeEntity(
            name = "Bhavageethe Balaga",
            artForm = "Bhavageethe",
            district = "Shivamogga",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/bhavageethe",
            leaderName = "Kavya",
            contact = "9556677889",
            about = "Bhavageethe singers."
        ),

        TroupeEntity(
            name = "Classical Music Team",
            artForm = "Classical Music",
            district = "Mangaluru",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/classical_music",
            leaderName = "Harish",
            contact = "9667788990",
            about = "Carnatic classical performers."
        ),

        TroupeEntity(
            name = "Harikathe Kala Vrunda",
            artForm = "Harikathe",
            district = "Kolar",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/harikathe",
            leaderName = "Raghu",
            contact = "9778899001",
            about = "Traditional Harikathe artists."
        ),

        TroupeEntity(
            name = "Kamsale Artists",
            artForm = "Kamsale",
            district = "Ramanagara",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/kamsale",
            leaderName = "Shivu",
            contact = "9333333333",
            about = "Kamsale performers."
        ),

        TroupeEntity(
            name = "Orchestra Friends",
            artForm = "Orchestra",
            district = "Ballari",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/orchestra",
            leaderName = "Manoj",
            contact = "9445566778",
            about = "Live orchestra music performers."
        ),

        TroupeEntity(
            name = "Pauranika Nataka Team",
            artForm = "Pauranika Nataka",
            district = "Vijayapura",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/pauranika_nataka",
            leaderName = "Rakesh",
            contact = "9557788991",
            about = "Mythological drama artists."
        ),

        TroupeEntity(
            name = "Sugama Sangeetha Group",
            artForm = "Sugama Sangeetha",
            district = "Dharwad",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/sugama_sangeetha",
            leaderName = "Sneha",
            contact = "9668899002",
            about = "Sugama Sangeetha singers."
        ),

        TroupeEntity(
            name = "Tabla Beats Team",
            artForm = "Tabla",
            district = "Bidar",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/tabla",
            leaderName = "Faizal",
            contact = "9779900113",
            about = "Tabla instrumental artists."
        ),

        TroupeEntity(
            name = "Folk Singing Group",
            artForm = "Folk Singing",
            district = "Chamarajanagar",
            imageUri = "android.resource://com.example.kalavidarabalaga/drawable/folk_singing",
            leaderName = "Manju",
            contact = "9222222222",
            about = "Traditional folk singers."
        )
    )

    val troupeList =
        defaultTroupes + roomTroupes

    val selectedTroupe =
        remember {

            mutableStateOf<TroupeEntity?>(null)
        }

    if (selectedTroupe.value != null) {

        TroupeDetailScreen(

            troupe = selectedTroupe.value!!,

            onBack = {

                selectedTroupe.value = null
            }
        )

        return
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8F0))
            .padding(12.dp)
    ) {

        Text(

            text = "All Troupes",

            fontSize = 32.sp,

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
                Arrangement.spacedBy(16.dp),

            contentPadding =
                PaddingValues(bottom = 100.dp)
        ) {

            items(troupeList) { troupe ->

                Card(

                    modifier =
                        Modifier.fillMaxWidth(),

                    shape =
                        RoundedCornerShape(20.dp)
                ) {

                    Column(

                        modifier =
                            Modifier.padding(18.dp)
                    ) {

                        Text(

                            text = troupe.name,

                            fontSize = 24.sp,

                            fontWeight =
                                FontWeight.Bold
                        )

                        Spacer(
                            modifier =
                                Modifier.height(8.dp)
                        )

                        Text(
                            text =
                                "Art Form: ${troupe.artForm}",

                            fontSize = 18.sp
                        )

                        Text(
                            text =
                                "District: ${troupe.district}",

                            fontSize = 18.sp
                        )

                        Text(
                            text =
                                "Leader: ${troupe.leaderName}",

                            fontSize = 18.sp
                        )

                        Spacer(
                            modifier =
                                Modifier.height(16.dp)
                        )

                        Button(

                            onClick = {

                                selectedTroupe.value =
                                    troupe
                            },

                            modifier =
                                Modifier.fillMaxWidth(),

                            colors =
                                ButtonDefaults.buttonColors(
                                    containerColor =
                                        Color(0xFFCC3300)
                                )
                        ) {

                            Text(

                                text = "View Details",

                                color = Color.White,

                                fontSize = 18.sp
                            )
                        }
                    }
                }
            }
        }
    }
}