package com.example.gysd.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gysd.BottomAppBar
import com.example.gysd.navigation.NavItem
import com.example.gysd.ui.theme.backGroundgrey
import com.example.gysd.ui.theme.black


////////////////////////////////////////////////////////////////////////////////////////////////////

var id_counter : Int = 3

data class Task (
    val titel : String,
    val id : Int,
    var progress : Boolean,
)

// nicht nullable Liste mit vorgefertigten Listeneinträgen
val listOfTasks : List<Task> = mutableListOf(
    Task(
        titel = "Hund füttern",
        id = 0,
        progress = false
    ),
    Task(
        titel = "Einkaufen",
        id = 1,
        progress = false
    ),
    Task(
        titel = "Müll rausbringen",
        id = 2,
        progress = false
    ),
    Task(
        titel = "Auto tanken",
        id = 3,
        progress = false
    ),
    Task(
        titel = "Steuern machen",
        id = 4,
        progress = false
    ),
    Task(
        titel = "Pflanzen gießen",
        id = 5,
        progress = false
    ),
    Task(
        titel = "Tonne reinbringen",
        id = 6,
        progress = false
    ),
)

// nullable Liste
val listOfTasks2: MutableList<Task>? = mutableListOf()

////////////////////////////////////////////////////////////////////////////////////////////////////


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ToDoScreen() {
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
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

            bottomBar = { BottomAppBar() }
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

                    /*  - Box dient zum Angleichen der Liste an den Screen, da die TopBar
                          den ersten Eintrag der Liste verdecken würde
                    */
                    Box(modifier = Modifier.size(45.dp))
                    TaskList2()
                }
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
        items(listOfTasks){
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                TaskCard(titel = it.titel)
            }
        }
    }
}


/*
    - Taskliste mit einer Liste die auch leer sein kann
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
        listOfTasks2?.let { tasks ->
            items(tasks) { task ->
                TaskCard(titel = task.titel)
            }
        }
    }
}



@Composable
fun CompletedTaskList() {
    Surface(
        onClick = { /*TODO*/ }
    ){
        
    }
}


@Composable
fun TaskCard(titel: String) {
    // State to handle click event
    var showSubTask by remember { mutableStateOf(false) }

    if (showSubTask) {
        subTaskCard()
    } else {
        OutlinedCard(
            shape = CardDefaults.outlinedShape,
            modifier = Modifier
                .size(height = 100.dp, width = 150.dp)
                .padding(10.dp)
                .clickable {
                    showSubTask = true
                },
            border = BorderStroke(1.dp, color = Color.Black),
        ) {
            Text(
                text = titel,
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}


@Composable
fun subTaskCard(){
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Blue)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,

        ){
        Text(
            text = "Statistics Screen",
            fontFamily = FontFamily.Serif,
            fontSize = 22.sp
        )
    }
}



@Composable
fun Checkbox() {
    var switch by remember {
        mutableStateOf(ToggleableInfo(
            isChecked = false,
            text = ""
        ))
    }

    androidx.compose.material3.Checkbox(checked = switch.isChecked, onCheckedChange = { isChecked ->
        switch = switch.copy(isChecked = isChecked)
    })
}

@Composable
fun FloatingActionButton(){
    androidx.compose.material3.FloatingActionButton(
        onClick = { /*TODO*/ }
    ) {
        Icon(imageVector = Icons.Filled.Add, contentDescription = "Fügt Task hinzu")
    }
}


@Composable
fun BasicTextFieldDemo() {
    var textState by remember { mutableStateOf(TextFieldValue("Hello World")) }
    Column {
        BasicTextField(value = textState, onValueChange = {
            textState = it
        })
        Text("The textfield has this text: " + textState.text)
    }
}


@Composable
fun NotizScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backGroundgrey),

    ){
        var text1 by remember {
            mutableStateOf("")
        }
        var text2 by remember {
            mutableStateOf("")
        }

        val modifier = Modifier
            .fillMaxWidth()
            .background(backGroundgrey)
            .padding(16.dp)

        /*
            - Textfeld so groß wie der Screen
            - Screen-Größe -> MaxLines / minLines von BasicTextField
            - https://www.youtube.com/watch?v=srp2d3_ofRU
        */
        BasicTextField(value = text1, onValueChange = { text1 = it }, modifier = modifier,)
        //BasicTextField(value = text2, onValueChange = { text2 = it }, modifier = modifier)
    }
}


