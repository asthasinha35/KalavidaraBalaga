package com.example.kalavidarabalaga.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kalavidarabalaga.R
import com.example.kalavidarabalaga.data.TroupeEntity
import android.widget.Toast

@Composable
fun TroupeDetailScreen(
    troupe: TroupeEntity,
    onBack: () -> Unit
) {

    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF8F3EA))
            .verticalScroll(rememberScrollState())
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        listOf(
                            Color(0xFFB23A1B),
                            Color(0xFFD3542B)
                        )
                    )
                )
                .padding(
                    top = 45.dp,
                    start = 12.dp,
                    end = 12.dp,
                    bottom = 14.dp
                ),

            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(
                onClick = {
                    onBack()
                }
            ) {

                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )
            }

            Text(
                text = "Troupe Detail",
                color = Color.White,
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),

            shape = RoundedCornerShape(22.dp)
        ) {

            Column {

                Image(
                    painter = painterResource(
                        id = getDrawableImage(troupe.imageUri)
                    ),

                    contentDescription = null,

                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp),

                    contentScale = ContentScale.Crop
                )

                Column(
                    modifier = Modifier.padding(16.dp)
                ) {

                    Text(
                        text = troupe.name,
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF222222)
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Art Form",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .background(
                                    Color(0xFFF7D9A8),
                                    RoundedCornerShape(50)
                                )
                                .padding(
                                    horizontal = 14.dp,
                                    vertical = 6.dp
                                )
                        )

                        Text(
                            text = troupe.artForm,
                            modifier = Modifier.padding(start = 14.dp),
                            fontSize = 18.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "District",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .background(
                                    Color(0xFFF7D9A8),
                                    RoundedCornerShape(50)
                                )
                                .padding(
                                    horizontal = 14.dp,
                                    vertical = 6.dp
                                )
                        )

                        Text(
                            text = troupe.district,
                            modifier = Modifier.padding(start = 14.dp),
                            fontSize = 18.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(22.dp))

                    Text(
                        text = "About Us",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = troupe.about,
                        fontSize = 17.sp,
                        lineHeight = 26.sp,
                        color = Color.DarkGray
                    )

                    Spacer(modifier = Modifier.height(22.dp))

                    Text(
                        text = "Our Equipment",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "10 drums, full sound system",
                        fontSize = 17.sp,
                        color = Color.DarkGray
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = "Contact Lead",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = troupe.contact,
                        fontSize = 17.sp,
                        color = Color.DarkGray
                    )

                    Spacer(modifier = Modifier.height(28.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {

                        Button(

                            onClick = {

                                val intent = Intent(
                                    Intent.ACTION_DIAL,
                                    Uri.parse("tel:${troupe.contact}")
                                )

                                context.startActivity(intent)
                            },

                            modifier = Modifier
                                .weight(1f)
                                .height(58.dp),

                            shape = RoundedCornerShape(50),

                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFB23A1B)
                            )
                        ) {

                            Icon(
                                imageVector = Icons.Default.Call,
                                contentDescription = null,
                                tint = Color.White
                            )

                            Spacer(modifier = Modifier.width(8.dp))

                            Text(
                                text = "Call Now",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Button(

                            onClick = {

                                BookingManager.bookings.add(
                                    BookingItem(troupe)
                                )

                                Toast.makeText(
                                    context,
                                    "Booking Confirmed!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            },

                            modifier = Modifier
                                .weight(1f)
                                .height(58.dp),

                            shape = RoundedCornerShape(50),

                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFE29B27)
                            )
                        ) {

                            Text(
                                text = "Book Troupe",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(120.dp))
                }
            }
        }
    }
}

fun getDrawableImage(imageUri: String): Int {

    return when {

        imageUri.contains("dollu_kunitha") ->
            R.drawable.dollu_kunitha

        imageUri.contains("yakshagana") ->
            R.drawable.yakshagana

        imageUri.contains("kolata") ->
            R.drawable.kolata

        imageUri.contains("veeragase") ->
            R.drawable.veeragase

        imageUri.contains("drama") ->
            R.drawable.drama

        imageUri.contains("gamaka") ->
            R.drawable.gamaka

        imageUri.contains("nadaswara") ->
            R.drawable.nadaswara

        imageUri.contains("dance_group") ->
            R.drawable.dance_group

        imageUri.contains("folk_singing") ->
            R.drawable.folk_singing

        imageUri.contains("bharatanatya") ->
            R.drawable.bharatanatya

        imageUri.contains("bhavageethe") ->
            R.drawable.bhavageethe

        imageUri.contains("classical_music") ->
            R.drawable.classical_music

        imageUri.contains("harikathe") ->
            R.drawable.harikathe

        imageUri.contains("kamsale") ->
            R.drawable.kamsale

        imageUri.contains("orchestra") ->
            R.drawable.orchestra

        imageUri.contains("pauranika_nataka") ->
            R.drawable.pauranika_nataka

        imageUri.contains("sugama_sangeetha") ->
            R.drawable.sugama_sangeetha

        imageUri.contains("tabla") ->
            R.drawable.tabla

        imageUri.contains("janapada_songs") ->
            R.drawable.janapada_songs

        imageUri.contains("chitrakala") ->
            R.drawable.chitrakala

        else ->
            R.drawable.dollu_kunitha
    }
}