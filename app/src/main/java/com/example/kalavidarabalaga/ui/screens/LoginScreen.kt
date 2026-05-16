package com.example.kalavidarabalaga.ui.screens

import android.widget.Toast

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.kalavidarabalaga.data.UserSession

@Composable
fun LoginScreen(

    onLoginSuccess: () -> Unit,

    onSignUpClick: () -> Unit
) {

    val context = LocalContext.current

    var email by remember {

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

            text = "Kalavidara Balaga",

            fontSize = 34.sp,

            fontWeight = FontWeight.Bold,

            color = Color(0xFFFFF8F0)
        )

        Spacer(
            modifier =
                Modifier.height(30.dp)
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

                OutlinedTextField(

                    value = email,

                    onValueChange = {

                        email = it
                    },

                    label = {

                        Text("Email")
                    },

                    singleLine = true,

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier =
                        Modifier.height(16.dp)
                )

                OutlinedTextField(

                    value = password,

                    onValueChange = {

                        password = it
                    },

                    label = {

                        Text("Password")
                    },

                    visualTransformation =
                        PasswordVisualTransformation(),

                    singleLine = true,

                    modifier =
                        Modifier.fillMaxWidth()
                )

                Spacer(
                    modifier =
                        Modifier.height(24.dp)
                )

                Button(

                    onClick = {

                        if (
                            email.isEmpty()
                            ||
                            password.isEmpty()
                        ) {

                            Toast.makeText(
                                context,
                                "Enter Email and Password",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                        else if (
                            email == UserSession.userEmail
                            &&
                            password == UserSession.userPassword
                        ) {

                            Toast.makeText(
                                context,
                                "Login Successful",
                                Toast.LENGTH_SHORT
                            ).show()

                            onLoginSuccess()
                        }

                        else {

                            Toast.makeText(
                                context,
                                "Invalid Email or Password",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
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

                        text = "Login",

                        color = Color.White
                    )
                }

                Spacer(
                    modifier =
                        Modifier.height(12.dp)
                )

                Button(

                    onClick = {

                        onSignUpClick()
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

                        text = "Register",

                        color = Color.White
                    )
                }
            }
        }
    }
}