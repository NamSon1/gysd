package com.example.gysd.AppBars

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.gysd.R
import com.example.gysd.navigation.Screens
import com.example.gysd.subScreens.NotizSchreibenScreen


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun BottomAppBar(navController: NavController) {
    val context = LocalContext.current

            androidx.compose.material3.BottomAppBar(
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Check, contentDescription = null)
                    }

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(Icons.Filled.Edit, contentDescription = null)
                    }

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.mic_nonemicrophone), contentDescription = null)
                    }

                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = ImageVector.vectorResource(id = R.drawable.photoimage), contentDescription = null)
                    }
                },

                floatingActionButton = {
                    FloatingActionButton(
                        onClick = {
                            navController.navigate(Screens.NotizSchreibenScreen.name)
                        },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = null)
                    }
                }
            )
}






