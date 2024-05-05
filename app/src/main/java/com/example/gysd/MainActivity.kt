package com.example.gysd

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gysd.ui.theme.GysdTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

data class BottomNavigationItem(
    val title : String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews : Boolean,
    val badgeCount : Int? = null
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GysdTheme {
                val items = listOf(
                    BottomNavigationItem(
                        title = "Pomodoro",
                        selectedIcon = Icons.Filled.pomodoro,
                        unselectedIcon =  Icon.Outlined.pomodoro,
                        hasNews = false,
                    ),

                    BottomNavigationItem(
                        title = "ToDo",
                        selectedIcon = Icons.Filled.ToDo,
                        unselectedIcon =  Icon.Outlined.ToDo,
                        hasNews = false,
                    ),

                    BottomNavigationItem(
                        title = "Calendar",
                        selectedIcon = Icons.Filled.Calendar,
                        unselectedIcon =  Icon.Outlined.Calendar,
                        hasNews = false,
                    ),

                    BottomNavigationItem(
                        title = "Statistic",
                        selectedIcon = Icons.Filled.Statistic,
                        unselectedIcon =  Icon.Outlined.Statistic,
                        hasNews = false,
                    ),

                    BottomNavigationItem(
                        title = "Settings",
                        selectedIcon = Icons.Filled.Settings,
                        unselectedIcon =  Icon.Outlined.Settings,
                        hasNews = false,
                    ),
                )

                var selectedItemIndex by rememberSaveable {
                    mutableStateOf(0)
                }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = {
                            NavigationBar{
                                items.forEachIndexed { index, item ->
                                    NavigationBarItem(
                                        selected = selectedItemIndex == index,
                                        onClick = {
                                                  selectedItemIndex = index
                                                  //navController.navigate(item.title)
                                        },
                                        icon = {})
                                }
                            }

                        }
                    ) {

                    }


                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GysdTheme {
        Greeting("Android")
    }
}


@Preview(showBackground = true)
@Composable
fun TaskList() {
    LazyColumn (
        contentPadding = PaddingValues(horizontal = 150.dp, vertical = 80.dp),
    ){

        // Add a single item
        item {
            Text(text = "First item")
        }

        // Add 5 items
        items(5) { index ->
            Text(text = "Item: $index")
        }

        // Add another single item
        item {
            Text(text = "Last item")
        }
    }
}

fun Padding() {
    

}

fun MainStructure() {


}
