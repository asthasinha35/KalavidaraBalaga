package com.example.kalavidarabalaga.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class BookingItem(
    val troupe: com.example.kalavidarabalaga.data.TroupeEntity,
    var cancelled: Boolean = false
)

object BookingManager {

    val bookings =
        mutableStateListOf<BookingItem>()
}

@Composable
fun BookingsScreen() {

    var selectedTab by remember {
        mutableIntStateOf(0)
    }

    val tabs = listOf(
        "Confirmed",
        "Pending",
        "Cancelled"
    )

    val filteredBookings = when (selectedTab) {

        0 -> BookingManager.bookings.filter {
            !it.cancelled
        }

        2 -> BookingManager.bookings.filter {
            it.cancelled
        }

        else -> emptyList()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F3EE))
    ) {

        Column(
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
                    bottom = 18.dp
                ),

            horizontalAlignment =
                Alignment.CenterHorizontally
        ) {

            Text(
                text = "Bookings",
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
        }

        TabRow(
            selectedTabIndex = selectedTab,
            containerColor = Color.White
        ) {

            tabs.forEachIndexed { index, title ->

                Tab(
                    selected = selectedTab == index,

                    onClick = {
                        selectedTab = index
                    },

                    text = {

                        Text(
                            text = title,
                            fontSize = 13.sp
                        )
                    }
                )
            }
        }

        LazyColumn(

            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),

            verticalArrangement =
                Arrangement.spacedBy(12.dp)

        ) {

            items(filteredBookings) { booking ->

                val troupe = booking.troupe

                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                ) {

                    Column {

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),

                            verticalAlignment =
                                Alignment.CenterVertically
                        ) {

                            Image(
                                painter = painterResource(
                                    id = getDrawableImage(
                                        troupe.imageUri
                                    )
                                ),

                                contentDescription = null,

                                modifier = Modifier
                                    .size(72.dp)
                                    .clip(
                                        RoundedCornerShape(12.dp)
                                    ),

                                contentScale = ContentScale.Crop
                            )

                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 12.dp)
                            ) {

                                Text(
                                    text = troupe.name,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 16.sp
                                )

                                Spacer(
                                    modifier = Modifier.height(4.dp)
                                )

                                Text(
                                    text = troupe.district,
                                    color = Color.Gray,
                                    fontSize = 13.sp
                                )

                                Spacer(
                                    modifier = Modifier.height(4.dp)
                                )

                                Text(
                                    text = "25 May 2025",
                                    fontSize = 12.sp,
                                    color = Color.DarkGray
                                )

                                Spacer(
                                    modifier = Modifier.height(6.dp)
                                )

                                Text(
                                    text =
                                        if (booking.cancelled)
                                            "Cancelled"
                                        else
                                            "Confirmed",

                                    color =
                                        if (booking.cancelled)
                                            Color.Red
                                        else
                                            Color(0xFF2E7D32),

                                    fontWeight =
                                        FontWeight.SemiBold,

                                    fontSize = 13.sp
                                )
                            }

                            Icon(
                                imageVector =
                                    Icons.Default.KeyboardArrowRight,

                                contentDescription = null,

                                tint = Color(0xFFB23A1B)
                            )
                        }

                        if (!booking.cancelled) {

                            Button(

                                onClick = {

                                    booking.cancelled = true
                                },

                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(
                                        start = 12.dp,
                                        end = 12.dp,
                                        bottom = 12.dp
                                    ),

                                colors =
                                    ButtonDefaults.buttonColors(
                                        containerColor = Color.Red
                                    )
                            ) {

                                Text(
                                    text = "Cancel Booking"
                                )
                            }
                        }
                    }
                }
            }

            item {

                Spacer(
                    modifier = Modifier.height(100.dp)
                )
            }
        }
    }
}