package com.example.kalavidarabalaga

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.kalavidarabalaga.navigation.BottomNavigationBar
import com.example.kalavidarabalaga.ui.screens.BookingsScreen
import com.example.kalavidarabalaga.ui.screens.HomeScreen
import com.example.kalavidarabalaga.ui.screens.LoginScreen
import com.example.kalavidarabalaga.ui.screens.ProfileScreen
import com.example.kalavidarabalaga.ui.screens.SignUpScreen
import com.example.kalavidarabalaga.ui.screens.SplashScreen
import com.example.kalavidarabalaga.ui.screens.TroupesScreen
import com.example.kalavidarabalaga.ui.screens.AddTroupeScreen
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContent {

            MainScreen()
        }
    }
}


@Composable
fun MainScreen() {

    var currentRoute by remember {

        mutableStateOf("splash")
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {

        when (currentRoute) {

            "splash" -> {

                SplashScreen(

                    onSplashFinished = {

                        currentRoute = "login"
                    }
                )
            }

            "login" -> {

                LoginScreen(

                    onLoginSuccess = {

                        currentRoute = "home"
                    },

                    onSignUpClick = {

                        currentRoute = "signup"
                    }
                )
            }

            "signup" -> {

                SignUpScreen(

                    onBackToLogin = {

                        currentRoute = "login"
                    },

                    onSignUpClick = {
                            name: String,
                            email: String,
                            phone: String,
                            password: String ->

                        currentRoute = "login"
                    }
                )
            }

            "home" -> {

                HomeScreen()
            }

            "troupes" -> {

                TroupesScreen()
            }

            "bookings" -> {

                BookingsScreen()
            }

            "profile" -> {

                ProfileScreen(

                    onAddTroupeClick = {

                        currentRoute = "addtroupe"
                    }
                )
            }
            "addtroupe" -> {

                AddTroupeScreen(

                    viewModel = androidx.lifecycle.viewmodel.compose.viewModel(),

                    onBack = {

                        currentRoute = "profile"
                    }
                )
            }
        }

        if (
            currentRoute != "login" &&
            currentRoute != "signup" &&
            currentRoute != "splash"
        ) {

            Column(

                modifier = Modifier.fillMaxSize(),

                verticalArrangement = Arrangement.Bottom
            ) {

                BottomNavigationBar(

                    currentRoute = currentRoute,

                    onItemClick = { route ->

                        currentRoute = route
                    }
                )
            }
        }
    }
}