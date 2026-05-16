package com.example.kalavidarabalaga.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart

import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(

    val route: String,

    val title: String,

    val icon: ImageVector
) {

    object Home : BottomNavItem(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )

    object Troupes : BottomNavItem(
        route = "troupes",
        title = "Troupes",
        icon = Icons.Default.List
    )

    object Bookings : BottomNavItem(
        route = "bookings",
        title = "Bookings",
        icon = Icons.Default.ShoppingCart
    )

    object Profile : BottomNavItem(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}