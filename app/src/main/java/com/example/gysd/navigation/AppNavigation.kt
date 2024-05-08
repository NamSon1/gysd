package com.example.gysd.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gysd.R
import com.example.gysd.Screens.CalendarScreen
import com.example.gysd.Screens.PomodoroScreen
import com.example.gysd.Screens.SettingsScreen
import com.example.gysd.Screens.StatisticsScreen
import com.example.gysd.Screens.ToDoScreen



@Preview(showBackground = true)
@Composable
fun AppNavigation() {
    //Erstellen des NavControllers
    val navController : NavHostController = rememberNavController()

    Scaffold (
        bottomBar = {
            NavigationBar {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentDestination : NavDestination? = navBackStackEntry?.destination

                /*
                    Für jedes NavItem aus der Liste "listOfNavItems" wird ein NavigationBarItem erstellt.
                    Das Icon und das Label für das NavigationBarItem wird von den Eigenschaften des NavItems genommen.

                 */
                listOfNavItems.forEach {navItem ->
                    NavigationBarItem(
                        selected = currentDestination?.hierarchy?.any {it.route == navItem.route} == true,
                        onClick = {
                                  navController.navigate(navItem.route) {
                                      popUpTo(navController.graph.findStartDestination().id) {
                                          saveState = true
                                      }
                                      launchSingleTop = true
                                      restoreState = true
                                  }
                        },
                        icon = {
                               Icon(
                                   imageVector = navItem.icon,
                                   contentDescription = null,
                                   //Modifier.paint(painterResource(id = R.drawable.clock_png))
                               )
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }

        }
    ){ paddingValues ->

        // Der NavHost enthält alle Destinations und den NavController.
        NavHost(
            navController = navController,
            startDestination = Screens.PomodoroScreen.name,
            modifier = Modifier
                .padding(paddingValues)
        ) {

            /*
                Die Composables hier bilden die Destinations ab. Beim Erstellen wird die Route angegeben,
                bei der sich die Screens befinden. Die Route, die dem Composable übergeben wird (route = ...),
                wird aus der Enumeration der "Screens.kt" übernommen. Dies ist lediglich der Name der Composables.
             */

            composable(route = Screens.PomodoroScreen.name) {
                com.example.gysd.Screens.PomodoroScreen()
            }
            composable(route = Screens.ToDoScreen.name) {
                com.example.gysd.Screens.ToDoScreen()
            }
            composable(route = Screens.CalendarScreen.name) {
                com.example.gysd.Screens.CalendarScreen()
            }
            composable(route = Screens.StatisticsScreen.name) {
                com.example.gysd.Screens.StatisticsScreen()
            }
            composable(route = Screens.SettingsScreen.name) {
                com.example.gysd.Screens.SettingsScreen()
            }
        }
    }
}