package com.example.kalavidarabalaga.ui.screens

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import coil.compose.AsyncImage

import com.example.kalavidarabalaga.data.ProfileData

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ProfileScreen(

    onAddTroupeClick: () -> Unit
) {

    var profileImage by remember {

        mutableStateOf(ProfileData.profileImage)
    }

    var galleryImages by remember {

        mutableStateOf(ProfileData.galleryImages)
    }

    var name by remember {

        mutableStateOf(ProfileData.name)
    }

    var district by remember {

        mutableStateOf(ProfileData.district)
    }

    var experience by remember {

        mutableStateOf(ProfileData.experience)
    }

    var specialization by remember {

        mutableStateOf(ProfileData.specialization)
    }

    var about by remember {

        mutableStateOf(ProfileData.about)
    }

    var showProfile by remember {

        mutableStateOf(ProfileData.isProfileSaved)
    }

    val profilePicker =
        rememberLauncherForActivityResult(

            contract =
                ActivityResultContracts.GetContent()

        ) { uri ->

            profileImage = uri
        }

    val galleryPicker =
        rememberLauncherForActivityResult(

            contract =
                ActivityResultContracts.GetMultipleContents()

        ) { uris ->

            galleryImages = uris
        }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8F0))
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Card(

            modifier = Modifier.fillMaxWidth(),

            shape = RoundedCornerShape(28.dp)
        ) {

            Column(

                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFFE9E6EE))
                    .padding(20.dp)
            ) {

                Box(

                    modifier = Modifier.fillMaxWidth(),

                    contentAlignment = Alignment.Center
                ) {

                    if (profileImage != null) {

                        AsyncImage(

                            model = profileImage,

                            contentDescription = null,

                            modifier = Modifier
                                .size(110.dp)
                                .clip(CircleShape),

                            contentScale = ContentScale.Crop
                        )
                    }

                    else {

                        Box(

                            modifier = Modifier
                                .size(110.dp)
                                .clip(CircleShape)
                                .background(Color.LightGray),

                            contentAlignment = Alignment.Center
                        ) {

                            Icon(

                                imageVector = Icons.Default.Add,

                                contentDescription = null,

                                tint = Color.White,

                                modifier = Modifier.size(40.dp)
                            )
                        }
                    }

                    Box(

                        modifier = Modifier
                            .padding(top = 80.dp, start = 80.dp)
                            .size(36.dp)
                            .clip(CircleShape)
                            .background(Color(0xFFB23A1B))
                            .clickable {

                                profilePicker.launch("image/*")
                            },

                        contentAlignment = Alignment.Center
                    ) {

                        Icon(

                            imageVector = Icons.Default.Add,

                            contentDescription = null,

                            tint = Color.White
                        )
                    }
                }

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                if (!showProfile) {

                    OutlinedTextField(

                        value = name,

                        onValueChange = {

                            name = it
                        },

                        label = {

                            Text("Full Name")
                        },

                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    OutlinedTextField(

                        value = district,

                        onValueChange = {

                            district = it
                        },

                        label = {

                            Text("District")
                        },

                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    OutlinedTextField(

                        value = experience,

                        onValueChange = {

                            experience = it
                        },

                        label = {

                            Text("Experience")
                        },

                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    OutlinedTextField(

                        value = specialization,

                        onValueChange = {

                            specialization = it
                        },

                        label = {

                            Text("Specialization")
                        },

                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(
                        modifier = Modifier.height(12.dp)
                    )

                    OutlinedTextField(

                        value = about,

                        onValueChange = {

                            about = it
                        },

                        label = {

                            Text("About Me")
                        },

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                    )

                    Spacer(
                        modifier = Modifier.height(20.dp)
                    )

                    Button(

                        onClick = {

                            ProfileData.profileImage =
                                profileImage

                            ProfileData.galleryImages =
                                galleryImages

                            ProfileData.name =
                                name

                            ProfileData.district =
                                district

                            ProfileData.experience =
                                experience

                            ProfileData.specialization =
                                specialization

                            ProfileData.about =
                                about

                            ProfileData.isProfileSaved =
                                true

                            showProfile = true
                        },

                        modifier = Modifier.fillMaxWidth(),

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

                else {

                    Text(

                        text = name,

                        fontSize = 30.sp,

                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                    Text(

                        text = "District",

                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = district
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    Text(

                        text = "Experience",

                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "$experience Years"
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    Text(

                        text = "Specialization",

                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = specialization
                    )

                    Spacer(
                        modifier = Modifier.height(22.dp)
                    )

                    Text(

                        text = "About Me",

                        fontSize = 28.sp,

                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(10.dp)
                    )

                    Text(
                        text = about
                    )

                    Spacer(
                        modifier = Modifier.height(28.dp)
                    )

                    Text(

                        text = "Gallery",

                        fontSize = 28.sp,

                        fontWeight = FontWeight.Bold
                    )

                    Spacer(
                        modifier = Modifier.height(14.dp)
                    )

                    Button(

                        onClick = {

                            galleryPicker.launch("image/*")
                        },

                        colors =
                            ButtonDefaults.buttonColors(
                                containerColor =
                                    Color(0xFF6A4BC3)
                            )
                    ) {

                        Text(
                            text = "Upload Gallery Images"
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(18.dp)
                    )

                    FlowRow(

                        horizontalArrangement =
                            Arrangement.spacedBy(10.dp),

                        verticalArrangement =
                            Arrangement.spacedBy(10.dp)
                    ) {

                        galleryImages.forEach { image ->

                            AsyncImage(

                                model = image,

                                contentDescription = null,

                                modifier = Modifier
                                    .size(110.dp)
                                    .clip(RoundedCornerShape(14.dp)),

                                contentScale = ContentScale.Crop
                            )
                        }
                    }

                    Spacer(
                        modifier = Modifier.height(28.dp)
                    )

                    Button(

                        onClick = {

                            onAddTroupeClick()
                        },

                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp),

                        shape = RoundedCornerShape(50.dp),

                        colors =
                            ButtonDefaults.buttonColors(
                                containerColor =
                                    Color(0xFFB23A1B)
                            )
                    ) {

                        Text(

                            text = "ADD TROUPE",

                            fontSize = 18.sp
                        )
                    }
                }
            }
        }

        Spacer(
            modifier = Modifier.height(120.dp)
        )
    }
}