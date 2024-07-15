package com.example.gysd.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gysd.AppBars.BottomAppBar
import com.example.gysd.ui.theme.backGroundgrey
import com.example.gysd.ui.theme.black
import com.example.gysd.uiState.ToDoEntry
import com.example.gysd.uiState.ToDoEntryState
import com.example.gysd.viewmodel.NoteViewModel


////////////////////////////////////////////////////////////////////////////////////////////////////

data class Task (
    val titel : String,
    val id : Int,
    var content : String,
)

// nicht nullable Liste mit vorgefertigten Listeneinträgen
val listOfTasks : List<Task> = mutableListOf(
    Task(
        titel = "Hund füttern",
        id = 0,
        content = "abcde"
    ),
    Task(
        titel = "Einkaufen",
        id = 1,
        content = "abcde"
    ),
    Task(
        titel = "Müll rausbringen",
        id = 2,
        content = "abcde"
    ),
    Task(
        titel = "Auto tanken",
        id = 3,
        content = "abcde"
    ),
    Task(
        titel = "Steuern machen",
        id = 4,
        content = "abcde"
    ),
    Task(
        titel = "Pflanzen gießen",
        id = 5,
        content = "abcde"
    ),
    Task(
        titel = "Tonne reinbringen",
        id = 6,
        content = "abcde"
    ),
)

// nullable Liste
val listOfTasks2: MutableList<Task>? = mutableListOf()

////////////////////////////////////////////////////////////////////////////////////////////////////


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoScreen(noteViewModel: NoteViewModel, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = backGroundgrey,
                    titleContentColor = black,
                ),
                title = {
                    Text(
                        text = "To Do",
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth(),
                        //color = Color.Black
                    )
                }
            )
        },
        bottomBar = { BottomAppBar(navController) }
    ){
        Column(
            Modifier
                .fillMaxSize()
                .background(backGroundgrey)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            //TopBar = 56.dp

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                //- Box dient zum Angleichen der Liste an den Screen, da die TopBar den ersten Eintrag der Liste verdecken würde
                Box(modifier = Modifier.size(45.dp))
                NoteEntryList()
            }
        }
    }
}


/*
    - Taskliste mit einer Liste mit vorgefertigten Einträgen
    - die Liste kann nicht null sein
*/
@Composable
fun TaskList() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        /*
            - für jeden Eintrag der Liste "listOfTask" soll ein Card-Element
              mithilfe der TaskCard-Funktion erstellt werden
        */
        items(listOfTasks){
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                //TaskCard(titel = it.titel)
            }
        }
    }
}


/*
    - Taskliste mit einer Liste die auch leer sein kann
    - für jeden Listeneintrag wird ein Card-Composable mithilfe der TaskCArd-Funktion erstellt
*/
@Composable
fun TaskList2() {
    LazyVerticalGrid(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalArrangement = Arrangement.Center,
        columns = GridCells.Adaptive(128.dp),

        contentPadding = PaddingValues(
            start = 12.dp,
            top = 13.dp,
            end = 12.dp,
            bottom = 13.dp
        )
    ) {
        /*
            - für jeden Eintrag der Liste "listOfTask2" soll ein Card-Element
              mithilfe der TaskCard-Funktion erstellt werden
        */

        /*
        listOfTasks2?.let { tasks ->
            items(tasks) { task ->
                TaskCard(titel = task.titel)
            }
        }

         */
    }
}


/*
    - Card-Element mit eigenem State wird erstellt
    - soll eine Vorschau mit Titel und Inhalt des Notizeintrages darstellen
*/
@Composable
fun TaskCard(NoteEntry : ToDoEntry, onItemClicked: (NoteEntry : ToDoEntry) -> Unit) {
    // State to handle click event
    var showSubTask by remember { mutableStateOf(false) }


        OutlinedCard(
            shape = CardDefaults.outlinedShape,
            modifier = Modifier
                .size(height = 150.dp, width = 450.dp)
                .padding(10.dp)
                .clickable {
                    //showSubTask = true
                    onItemClicked(NoteEntry)
                },
            border = BorderStroke(1.dp, color = Color.Black),
        ) {
            Text(
                text = NoteEntry.title,
                modifier = Modifier.padding(10.dp)
            )
            Text(
                text = NoteEntry.body,
                modifier = Modifier.padding(10.dp)
            )
        }
}


// derzeitiges verwendetes Composable zur Darstellung von Einträgen einer Liste auf dem To-Do-Screen
@Composable
fun NoteEntryList() {
    LazyColumn {
        val ToDoList :List<ToDoEntry> = listOf(
            ToDoEntry("Airedale", "Has 0 Sub Breeds", 1),
            ToDoEntry("Biredale", "Has 10 Sub Breeds", 2),
            ToDoEntry("Ciredale", "Has 20 Sub Breeds", 3),
            ToDoEntry("Diredale", "Has 30 Sub Breeds", 4),
            ToDoEntry("Eiredale", "Has 40 Sub Breeds", 5),
        )
        items(ToDoList) {
            TaskCard(NoteEntry = it, onItemClicked = {})
        }

    }
}


