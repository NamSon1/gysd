package com.example.gysd.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.gysd.database.AppDatabase
import com.example.gysd.database.NoteRepository
import com.example.gysd.subScreens.NotizSchreibenScreen
import com.example.gysd.viewmodel.NoteViewModel
import com.example.gysd.viewmodel.NoteViewModelFactory


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController : NavHostController = rememberNavController()

    // Initialize NoteViewModel
    val context = LocalContext.current
    val noteViewModel: NoteViewModel = viewModel(
        factory = NoteViewModelFactory(
            NoteRepository(context)
        )
    )

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
                                          // Save backstack state. This will ensure restoration of
                                          // nested navigation screen when the user comes back to the destination.
                                          saveState = true
                                      }
                                      // prevent duplicate destinations when the navigation is clicked multiple times
                                      launchSingleTop = true

                                      // restore state if previously saved
                                      restoreState = true
                                  }
                        },
                        icon = {
                               Icon(
                                   imageVector = navItem.icon,
                                   contentDescription = null,
                               )
                        },
                        label = {
                            Text(text = navItem.label)
                        }
                    )
                }
            }
        },

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
                wird aus der Enumeration der "Screens.kt" übernommen. Dies ist lediglich der Name / ein Identifier der Composables.
            */

            composable(route = Screens.PomodoroScreen.name) {
                com.example.gysd.Screens.PomodoroScreen(navController)
            }
            composable(route = Screens.ToDoScreen.name) {
                com.example.gysd.Screens.ToDoScreen(noteViewModel, navController)
            }
            composable(route = Screens.CalendarScreen.name) {
                com.example.gysd.Screens.CalendarScreen(navController)
            }
            composable(route = Screens.StatisticsScreen.name) {
                com.example.gysd.Screens.StatisticsScreen(navController)
            }
            composable(route = Screens.SettingsScreen.name) {
                com.example.gysd.Screens.SettingsScreen(navController)
            }

            composable(route = Screens.NotizSchreibenScreen.name) {
                NotizSchreibenScreen(noteViewModel, navController) // Pass NoteViewModel if needed
            }
        }
    }
}


