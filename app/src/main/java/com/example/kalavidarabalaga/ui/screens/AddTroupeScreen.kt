package com.example.kalavidarabalaga.ui.screens

import android.net.Uri

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import coil.compose.AsyncImage

import com.example.kalavidarabalaga.data.TroupeEntity

@Composable
fun AddTroupeScreen(

    viewModel: TroupeViewModel,

    onBack: () -> Unit
) {

    var troupeName by remember {

        mutableStateOf("")
    }

    var artForm by remember {

        mutableStateOf("")
    }

    var district by remember {

        mutableStateOf("")
    }

    var leaderName by remember {

        mutableStateOf("")
    }

    var contact by remember {

        mutableStateOf("")
    }

    var about by remember {

        mutableStateOf("")
    }

    var selectedImageUri by remember {

        mutableStateOf<Uri?>(null)
    }

    val imagePickerLauncher =
        rememberLauncherForActivityResult(

            contract =
                ActivityResultContracts.GetContent()

        ) { uri ->

            selectedImageUri = uri
        }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8F0))
            .verticalScroll(rememberScrollState())
            .imePadding()
            .padding(16.dp),

        horizontalAlignment =
            Alignment.CenterHorizontally,

        verticalArrangement =
            Arrangement.Top
    ) {

        Text(

            text = "Add New Troupe",

            fontSize = 28.sp,

            color = Color(0xFFB23A1B)
        )

        Spacer(
            modifier =
                Modifier.height(20.dp)
        )

        Card(

            modifier =
                Modifier.fillMaxWidth(),

            shape =
                RoundedCornerShape(20.dp)
        ) {

            Column(

                modifier =
                    Modifier.padding(20.dp)
            ) {

                Button(

                    onClick = {

                        imagePickerLauncher.launch(
                            "image/*"
                        )
                    }

                ) {

                    Text(
                        text = "Select Image"
                    )
                }

                Spacer(
                    modifier =
                        Modifier.height(12.dp)
                )

                if (selectedImageUri != null) {

                    AsyncImage(

                        model = selectedImageUri,

                        contentDescription = null,

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                            .clip(
                                RoundedCornerShape(16.dp)
                            ),

                        contentScale =
                            ContentScale.Crop
                    )

                    Spacer(
                        modifier =
                            Modifier.height(16.dp)
                    )
                }

                OutlinedTextField(

                    value = troupeName,

                    onValueChange = {

                        troupeName = it
                    },

                    label = {
                        Text("Troupe Name")
                    },

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier =
                        Modifier.height(12.dp)
                )

                OutlinedTextField(

                    value = artForm,

                    onValueChange = {

                        artForm = it
                    },

                    label = {
                        Text("Art Form")
                    },

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier =
                        Modifier.height(12.dp)
                )

                OutlinedTextField(

                    value = district,

                    onValueChange = {

                        district = it
                    },

                    label = {
                        Text("District")
                    },

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier =
                        Modifier.height(12.dp)
                )

                OutlinedTextField(

                    value = leaderName,

                    onValueChange = {

                        leaderName = it
                    },

                    label = {
                        Text("Leader Name")
                    },

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier =
                        Modifier.height(12.dp)
                )

                OutlinedTextField(

                    value = contact,

                    onValueChange = {

                        contact = it
                    },

                    label = {
                        Text("Contact")
                    },

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier =
                        Modifier.height(12.dp)
                )

                OutlinedTextField(

                    value = about,

                    onValueChange = {

                        about = it
                    },

                    label = {
                        Text("About")
                    },

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier =
                        Modifier.height(20.dp)
                )

                Button(

                    onClick = {

                        if (

                            troupeName.isNotEmpty()
                            &&
                            artForm.isNotEmpty()
                            &&
                            district.isNotEmpty()
                            &&
                            leaderName.isNotEmpty()
                            &&
                            contact.isNotEmpty()
                            &&
                            about.isNotEmpty()
                            &&
                            selectedImageUri != null
                        ) {

                            viewModel.insertTroupe(

                                TroupeEntity(

                                    name = troupeName,

                                    artForm = artForm,

                                    district = district,

                                    imageUri =
                                        selectedImageUri.toString(),

                                    leaderName = leaderName,

                                    contact = contact,

                                    about = about
                                )
                            )

                            onBack()
                        }
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
                        text = "Submit"
                    )
                }
            }
        }
    }
}