@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.kalavidarabalaga.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.lifecycle.viewmodel.compose.viewModel

import coil.compose.AsyncImage

import com.example.kalavidarabalaga.data.TroupeEntity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues


@Composable
fun HomeScreen() {

    val troupeViewModel: TroupeViewModel =
        viewModel()

    var showAddScreen by remember {
        mutableStateOf(false)
    }

    var selectedDistrict by remember {
        mutableStateOf("")
    }

    var selectedArtType by remember {
        mutableStateOf("")
    }

    var districtExpanded by remember {
        mutableStateOf(false)
    }

    var artExpanded by remember {
        mutableStateOf(false)
    }

    val troupeList by troupeViewModel
        .troupeList
        .collectAsState(
            initial = emptyList()
        )

    val districtList = listOf(
        "All",
        "Mysuru",
        "Udupi",
        "Mandya",
        "Bengaluru",
        "Tumakuru",
        "Raichur",
        "Belagavi"
    )

    val artTypeList = listOf(
        "All",
        "Dollu Kunitha",
        "Yakshagana",
        "Drama",
        "Kolata",
        "Veeragase",
        "Gamaka",
        "Nadaswara",
        "Janapada",
        "Dance",
        "Theatre"
    )

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

    val allTroupes =
        defaultTroupes + troupeList

    val filteredList = allTroupes.filter {

        (selectedDistrict.isEmpty()
                ||
                it.district.contains(
                    selectedDistrict,
                    ignoreCase = true
                ))

                &&

                (selectedArtType.isEmpty()
                        ||
                        it.artForm.contains(
                            selectedArtType,
                            ignoreCase = true
                        ))
    }

    if (showAddScreen) {

        AddTroupeScreen(

            viewModel = troupeViewModel,

            onBack = {

                showAddScreen = false
            }
        )

        return
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8F0))

    ) {

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFB23A1B))
                .padding(16.dp),

            horizontalArrangement =
                Arrangement.SpaceBetween
        ) {

            Text(

                text = "Kalavidara Balaga",

                color = Color.White,

                fontSize = 24.sp
            )

            Button(

                onClick = {

                    showAddScreen = true
                }
            ) {

                Text(
                    text = "Add Troupe"
                )
            }
        }

        Spacer(
            modifier =
                Modifier.height(12.dp)
        )

        Row(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),

            horizontalArrangement =
                Arrangement.spacedBy(10.dp)
        ) {

            Box(
                modifier = Modifier.weight(1f)
            ) {

                ExposedDropdownMenuBox(

                    expanded = districtExpanded,

                    onExpandedChange = {

                        districtExpanded =
                            !districtExpanded
                    }
                ) {

                    OutlinedTextField(

                        value =
                            if (selectedDistrict.isEmpty())
                                "All"
                            else selectedDistrict,

                        onValueChange = {},

                        readOnly = true,

                        singleLine = true,

                        label = {
                            Text("District")
                        },

                        trailingIcon = {

                            ExposedDropdownMenuDefaults
                                .TrailingIcon(
                                    expanded =
                                        districtExpanded
                                )
                        },

                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth()
                    )

                    DropdownMenu(

                        expanded = districtExpanded,

                        onDismissRequest = {

                            districtExpanded = false
                        }
                    ) {

                        districtList.forEach {

                            DropdownMenuItem(

                                text = {

                                    Text(it)
                                },

                                onClick = {

                                    selectedDistrict =
                                        if (it == "All")
                                            ""
                                        else it

                                    districtExpanded = false
                                }
                            )
                        }
                    }
                }
            }

            Box(
                modifier = Modifier.weight(1f)
            ) {

                ExposedDropdownMenuBox(

                    expanded = artExpanded,

                    onExpandedChange = {

                        artExpanded =
                            !artExpanded
                    }
                ) {

                    OutlinedTextField(

                        value =
                            if (selectedArtType.isEmpty())
                                "All"
                            else selectedArtType,

                        onValueChange = {},

                        readOnly = true,

                        singleLine = true,

                        label = {
                            Text("Art Type")
                        },

                        trailingIcon = {

                            ExposedDropdownMenuDefaults
                                .TrailingIcon(
                                    expanded =
                                        artExpanded
                                )
                        },

                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth()
                    )

                    DropdownMenu(

                        expanded = artExpanded,

                        onDismissRequest = {

                            artExpanded = false
                        }
                    ) {

                        artTypeList.forEach {

                            DropdownMenuItem(

                                text = {

                                    Text(it)
                                },

                                onClick = {

                                    selectedArtType =
                                        if (it == "All")
                                            ""
                                        else it

                                    artExpanded = false
                                }
                            )
                        }
                    }
                }
            }
        }

        Spacer(
            modifier =
                Modifier.height(12.dp)
        )

        LazyVerticalGrid(

            columns = GridCells.Fixed(2),

            modifier =
                Modifier.padding(12.dp),

            contentPadding =
                PaddingValues(bottom = 100.dp),

            verticalArrangement =
                Arrangement.spacedBy(12.dp),

            horizontalArrangement =
                Arrangement.spacedBy(12.dp)
        ) {

            items(filteredList) { troupe ->

                Card(

                    shape = RoundedCornerShape(16.dp),

                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column {

                        AsyncImage(

                            model = troupe.imageUri,

                            contentDescription = null,

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(140.dp),

                            contentScale = ContentScale.Crop
                        )

                        Column(

                            modifier =
                                Modifier.padding(12.dp)
                        ) {

                            Row(

                                modifier = Modifier.fillMaxWidth(),

                                horizontalArrangement =
                                    Arrangement.SpaceBetween
                            ) {

                                Text(
                                    text = troupe.name,
                                    fontSize = 16.sp,
                                    color = Color.Black
                                )

                                if (troupe.id != 0) {

                                    Button(

                                        onClick = {

                                            troupeViewModel
                                                .deleteTroupe(troupe)
                                        },

                                        colors =
                                            ButtonDefaults.buttonColors(
                                                containerColor =
                                                    Color.Red
                                            ),

                                        shape =
                                            RoundedCornerShape(8.dp)
                                    ) {

                                        Text(
                                            text = "Delete",
                                            color = Color.White
                                        )
                                    }
                                }
                            }

                            Spacer(
                                modifier =
                                    Modifier.height(6.dp)
                            )

                            Text(
                                text = troupe.artForm
                            )

                            Text(
                                text = troupe.district
                            )

                            Text(
                                text =
                                    "Leader: ${troupe.leaderName}"
                            )
                        }
                    }
                }
            }
        }
    }
    }