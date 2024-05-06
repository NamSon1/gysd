package com.example.gysd.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

data class NavItem (
    val label : String,
    val icon : ImageVector,
    val route : String
)

val listOfNavItems : List<NavItem> = listOf(
    NavItem(
        label = "Pomodoro",
        icon = Icons.Default.Home,
        route = Screens.PomodoroScreen.name
    ),
    NavItem(
        label = "ToDo",
        icon = Icons.Default.List,
        route = Screens.ToDoScreen.name
    ),
    NavItem(
        label = "Calendar",
        icon = Icons.Default.DateRange,
        route = Screens.CalendarScreen.name
    ),
    NavItem(
        label = "Statistics",
        icon = Icons.Default.Share,
        route = Screens.StatisticsScreen.name
    ),
    NavItem(
        label = "Settings",
        icon = Icons.Default.Settings,
        route = Screens.SettingsScreen.name
    ),
)