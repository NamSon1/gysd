package com.example.gysd.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.ui.graphics.vector.ImageVector

data class NavItem (
    val label : String,
    val icon : ImageVector,
    val route : String
)

val listOfNavItems : List<NavItem> = listOf(
    NavItem(
        label = "Pomodoro",
        icon = Icons.Default.Home,
        route = Screens.HomeScreen.name
    )
)