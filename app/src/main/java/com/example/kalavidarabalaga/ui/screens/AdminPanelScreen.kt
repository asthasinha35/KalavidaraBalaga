package com.example.kalavidarabalaga.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text

import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class AdminTroupeData(

    val troupeName: String,

    val artForm: String,

    val district: String,

    val leaderName: String,

    var status: String
)

@Composable
fun AdminPanelScreen() {

    var troupeList by remember {

        mutableStateOf(

            listOf(

                AdminTroupeData(
                    troupeName = "Sahyadri Dollu Troupe",
                    artForm = "Dollu Kunitha",
                    district = "Mysuru",
                    leaderName = "Sudeep",
                    status = "Pending"
                ),

                AdminTroupeData(
                    troupeName = "Yakshagana Mela",
                    artForm = "Yakshagana",
                    district = "Udupi",
                    leaderName = "Rahul",
                    status = "Pending"
                ),

                AdminTroupeData(
                    troupeName = "Kolata Kala Team",
                    artForm = "Kolata",
                    district = "Mandya",
                    leaderName = "Kiran",
                    status = "Pending"
                ),

                AdminTroupeData(
                    troupeName = "Drama Artists",
                    artForm = "Drama",
                    district = "Bengaluru",
                    leaderName = "Tarun",
                    status = "Approved"
                )
            )
        )
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8F0))
            .padding(12.dp)
    ) {

        Text(

            text = "Admin Panel",

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

            itemsIndexed(troupeList) { index, troupe ->

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

                        Text(
                            text =
                                "Leader: ${troupe.leaderName}"
                        )

                        Spacer(
                            modifier =
                                Modifier.height(10.dp)
                        )

                        Text(

                            text =
                                "Status: ${troupe.status}",

                            fontWeight =
                                FontWeight.Bold,

                            color =
                                if (troupe.status == "Approved")
                                    Color(0xFF2E7D32)
                                else
                                    Color.Red
                        )

                        Spacer(
                            modifier =
                                Modifier.height(14.dp)
                        )

                        Row(

                            horizontalArrangement =
                                Arrangement.spacedBy(10.dp)
                        ) {

                            Button(

                                onClick = {

                                    val updated =
                                        troupeList.toMutableList()

                                    updated[index] =
                                        updated[index].copy(
                                            status = "Approved"
                                        )

                                    troupeList = updated
                                },

                                modifier =
                                    Modifier.weight(1f),

                                colors =
                                    ButtonDefaults.buttonColors(
                                        containerColor =
                                            Color(0xFF2E7D32)
                                    )
                            ) {

                                Text(
                                    text = "Approve"
                                )
                            }

                            Button(

                                onClick = {

                                    val updated =
                                        troupeList.toMutableList()

                                    updated[index] =
                                        updated[index].copy(
                                            status = "Rejected"
                                        )

                                    troupeList = updated
                                },

                                modifier =
                                    Modifier.weight(1f),

                                colors =
                                    ButtonDefaults.buttonColors(
                                        containerColor =
                                            Color.Red
                                    )
                            ) {

                                Text(
                                    text = "Reject"
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}