package com.example.gysd

import android.annotation.SuppressLint
import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.gysd.activitys.NotizSchreiben
import com.google.android.material.bottomappbar.BottomAppBar
import android.content.Context
import androidx.compose.ui.platform.LocalContext


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun BottomAppBar() {
    val context = LocalContext.current

    Scaffold(
        bottomBar = {
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
                            val intent = Intent(context, NotizSchreiben::class.java)
                            context.startActivity(intent)
                        },
                        containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                        elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation()
                    ) {
                        Icon(Icons.Filled.Add, contentDescription = null)
                    }
                }
            )
        }
    ) {

    }
}






