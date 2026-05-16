package com.example.kalavidarabalaga.navigation

import androidx.compose.material3.*

import androidx.compose.runtime.Composable

import androidx.compose.ui.graphics.Color

@Composable
fun BottomNavigationBar(

    currentRoute: String,

    onItemClick: (String) -> Unit
) {

    val items = listOf(

        BottomNavItem.Home,

        BottomNavItem.Troupes,

        BottomNavItem.Bookings,

        BottomNavItem.Profile
    )

    NavigationBar(

        containerColor =
            Color(0xFFB23A1B)

    ) {

        items.forEach { item ->

            NavigationBarItem(

                selected =
                    currentRoute == item.route,

                onClick = {

                    onItemClick(item.route)
                },

                icon = {

                    Icon(
                        imageVector = item.icon,

                        contentDescription =
                            item.title
                    )
                },

                label = {

                    Text(item.title)
                }
            )
        }
    }
}