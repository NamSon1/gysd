package com.example.gysd.activitys

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gysd.activitys.ui.theme.GysdTheme
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.gysd.BottomAppBar
import com.example.gysd.R
import com.example.gysd.database.AppDatabase
import com.example.gysd.navigation.AppNavigation
import com.example.gysd.ui.theme.backGroundgrey
import com.example.gysd.ui.theme.black
import com.example.gysd.viewmodel.NoteViewModel

class NotizSchreiben : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GysdTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    NoteScreen()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun NoteScreen() {
    val noteViewModel: NoteViewModel = viewModel()



    Scaffold(
        topBar = { TopBarDetail() },
        bottomBar = { BottomAppBar() },
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            /*  - Box dient zum Angleichen der Liste an den Screen, da die TopBar
                  den ersten Eintrag der Liste verdecken würde
            */
            Box(modifier = Modifier.size(60.dp).weight(0.4f))

            //var noteText by remember { mutableStateOf("") }
            OutlinedTextField(
                value = noteViewModel.titleText,
                onValueChange = { noteViewModel.titleText = it },
                label = { Text("Titel") },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f),
                maxLines = Int.MAX_VALUE // Allow unlimited lines
            )

            // Textfeld für den Titel
            var titelText by remember { mutableStateOf("") }
            BasicTextField(
                value = noteViewModel.noteText,
                onValueChange = { noteViewModel.noteText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                minLines = 1,
                maxLines = 1,
                textStyle = TextStyle(fontSize = 50.sp)

            )

            Spacer(modifier = Modifier.weight(2f)) // Push content upwards
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopBarDetail() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backGroundgrey,
            titleContentColor = black,
        ),

        navigationIcon = {
            val context = LocalContext.current
            var finishActivity by remember { mutableStateOf(false) }

            if (finishActivity) {
                LaunchedEffect(Unit) { // Trigger the side effect when finishActivity is true
                    (context as? Activity)?.finish()
                }
            }

            IconButton(
                onClick = {
                    finishActivity = true
                    /*TODO*/
                }
            ) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.arrow_backarrow_back), contentDescription = null)
            }
        },

        title = {
            Text(
                text = "DetailScreen",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(end = 40.dp),
                color = Color.Black,
            )
        },


    )
}

