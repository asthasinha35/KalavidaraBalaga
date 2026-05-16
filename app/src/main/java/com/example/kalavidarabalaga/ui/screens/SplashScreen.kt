package com.example.kalavidarabalaga.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kalavidarabalaga.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(

    onSplashFinished: () -> Unit
) {

    LaunchedEffect(Unit) {

        delay(4000)

        onSplashFinished()
    }

    Box(

        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF9C2B12))
    ) {

        Image(

            painter =
                painterResource(id = R.drawable.splash_bg_png),

            contentDescription = null,

            modifier = Modifier.fillMaxSize(),

            contentScale = ContentScale.FillBounds
        )

        Column(

            modifier = Modifier.fillMaxSize(),

            verticalArrangement =
                Arrangement.Center,

            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {





            Spacer(
                modifier = Modifier.weight(1f)
            )

            CircularProgressIndicator(

                color = Color.White
            )

            Spacer(
                modifier = Modifier.height(14.dp)
            )



            Spacer(
                modifier = Modifier.height(40.dp)
            )


        }
    }
}