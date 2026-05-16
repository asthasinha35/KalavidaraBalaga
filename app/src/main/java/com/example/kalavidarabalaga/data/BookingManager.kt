package com.example.kalavidarabalaga.data

object BookingManager {

    val bookingList = mutableListOf<BookingItem>()
}

data class BookingItem(

    val troupeName: String,

    val userName: String,

    val phoneNumber: String,

    val location: String,

    val bookingDate: String,

    val eventDetails: String
)