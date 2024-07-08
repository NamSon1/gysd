package com.example.gysd.subScreens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.gysd.AppBars.BottomAppBar
import com.example.gysd.AppBars.TopBarDetail
import com.example.gysd.viewmodel.NoteViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotizSchreibenScreen(noteViewModel: NoteViewModel, navController: NavHostController) {
    val noteViewModel: NoteViewModel = viewModel()

    Scaffold(
        topBar = { TopBarDetail(navController) },
        bottomBar = { BottomAppBar(navController) },
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


