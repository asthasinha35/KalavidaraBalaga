package com.example.kalavidarabalaga.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.*

import androidx.compose.runtime.*

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.kalavidarabalaga.data.UserSession
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@Composable
fun SignUpScreen(

    onBackToLogin: () -> Unit,

    onSignUpClick: (
        String,
        String,
        String,
        String
    ) -> Unit
) {

    var name by remember {

        mutableStateOf("")
    }

    var email by remember {

        mutableStateOf("")
    }

    var phone by remember {

        mutableStateOf("")
    }

    var password by remember {

        mutableStateOf("")
    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFB23A1B))
            .verticalScroll(rememberScrollState())
            .imePadding()
            .padding(16.dp),

        verticalArrangement =
            Arrangement.Center,

        horizontalAlignment =
            Alignment.CenterHorizontally
    ) {

        Text(

            text = "Register",

            fontSize = 32.sp,

            fontWeight = FontWeight.Bold,

            color = Color( 0xFFFFF8F0)
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Card(
            shape = RoundedCornerShape(20.dp)
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                OutlinedTextField(

                    value = name,

                    onValueChange = {

                        name = it
                    },

                    label = {

                        Text("Name")
                    },

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                OutlinedTextField(

                    value = email,

                    onValueChange = {

                        email = it
                    },

                    label = {

                        Text("Email")
                    },

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                OutlinedTextField(

                    value = phone,

                    onValueChange = {

                        phone = it
                    },

                    label = {

                        Text("Phone")
                    },

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(12.dp)
                )

                OutlinedTextField(

                    value = password,

                    onValueChange = {

                        password = it
                    },

                    label = {

                        Text("Password")
                    },

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier = Modifier.height(24.dp)
                )

                Button(

                    onClick = {

                        UserSession.userName = name
                        UserSession.userEmail = email
                        UserSession.userPhone = phone
                        UserSession.userPassword = password

                        onSignUpClick(
                            name,
                            email,
                            phone,
                            password
                        )

                        onBackToLogin()
                    },

                    modifier =
                        Modifier.fillMaxWidth(),

                    colors =
                        ButtonDefaults.buttonColors(
                            containerColor =
                                Color(0xFFCC3300)
                        )
                ) {

                    Text("Register")
                }
            }
        }
    }
}