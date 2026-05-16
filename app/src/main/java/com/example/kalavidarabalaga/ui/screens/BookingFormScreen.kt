package com.example.kalavidarabalaga.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BookingFormScreen(

    troupeName: String,

    onBookingDone: () -> Unit
) {

    var userName by remember {

        mutableStateOf("")
    }

    var phoneNumber by remember {

        mutableStateOf("")
    }

    var eventLocation by remember {

        mutableStateOf("")
    }

    var bookingDate by remember {

        mutableStateOf("")
    }

    var eventDetails by remember {

        mutableStateOf("")
    }

    var successMessage by remember {

        mutableStateOf(false)
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFF8F0))
            .verticalScroll(
                rememberScrollState()
            )
            .padding(20.dp),

        horizontalAlignment =
            Alignment.CenterHorizontally,

        verticalArrangement =
            Arrangement.Top
    ) {

        Text(

            text = "Book Troupe",

            fontSize = 30.sp,

            fontWeight =
                FontWeight.Bold,

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

                Text(

                    text =
                        "Selected Troupe: $troupeName",

                    fontSize = 20.sp,

                    fontWeight =
                        FontWeight.Bold
                )

                Spacer(
                    modifier =
                        Modifier.height(20.dp)
                )

                OutlinedTextField(

                    value = userName,

                    onValueChange = {

                        userName = it
                    },

                    label = {

                        Text("Your Name")
                    },

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier =
                        Modifier.height(12.dp)
                )

                OutlinedTextField(

                    value = phoneNumber,

                    onValueChange = {

                        phoneNumber = it
                    },

                    label = {

                        Text("Phone Number")
                    },

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier =
                        Modifier.height(12.dp)
                )

                OutlinedTextField(

                    value = eventLocation,

                    onValueChange = {

                        eventLocation = it
                    },

                    label = {

                        Text("Event Location")
                    },

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier =
                        Modifier.height(12.dp)
                )

                OutlinedTextField(

                    value = bookingDate,

                    onValueChange = {

                        bookingDate = it
                    },

                    label = {

                        Text("Booking Date")
                    },

                    placeholder = {

                        Text("DD/MM/YYYY")
                    },

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier =
                        Modifier.height(12.dp)
                )

                OutlinedTextField(

                    value = eventDetails,

                    onValueChange = {

                        eventDetails = it
                    },

                    label = {

                        Text("Event Details")
                    },

                    modifier =
                        Modifier.fillMaxWidth(),

                    minLines = 4
                )

                Spacer(
                    modifier =
                        Modifier.height(20.dp)
                )

                Button(

                    onClick = {

                        successMessage = true
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
                        text = "Confirm Booking"
                    )
                }

                if (successMessage) {

                    Spacer(
                        modifier =
                            Modifier.height(20.dp)
                    )

                    Text(

                        text =
                            "Booking Submitted Successfully!",

                        color = Color.Green,

                        fontWeight =
                            FontWeight.Bold
                    )

                    Spacer(
                        modifier =
                            Modifier.height(16.dp)
                    )

                    Button(

                        onClick = {

                            onBookingDone()
                        },

                        modifier =
                            Modifier.fillMaxWidth(),

                        colors =
                            ButtonDefaults.buttonColors(
                                containerColor =
                                    Color.Gray
                            )
                    ) {

                        Text(
                            text = "Back"
                        )
                    }
                }
            }
        }
    }
}