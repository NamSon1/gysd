package com.example.gysd.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gysd.navigation.NavItem
import com.example.gysd.ui.theme.backGroundgrey
import com.example.gysd.ui.theme.black


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
                CenterAlignedTopAppBar(
                    title = {
                        Text(
                            "ToDo",
                            style = MaterialTheme.typography.titleLarge,
                            fontSize = 25.sp,
                            fontWeight = FontWeight.Bold,
                        )
                    },

                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = backGroundgrey,
                        titleContentColor = black,
                    ),
                )
            }
        ){
            Column(
                Modifier
                    .fillMaxSize()
                    .background(backGroundgrey)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                TaskCard()
                FloatingActionButton()
            }

        }
    }
}



@Composable
fun TaskList() {
    LazyColumn(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        listOfTasks


    }
}



@Composable
fun CompletedTaskList() {
    Surface(
        onClick = { /*TODO*/ }
    ){
        
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////

data class Task (
    val titel : String,
    val id : Int,
    var progress : Boolean,
)

val listOfTasks : List<Task> = listOf(
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
)

////////////////////////////////////////////////////////////////////////////////////////////////////


@Preview(showBackground = true)
@Composable
fun TaskCard() {
    OutlinedCard(
        shape = CardDefaults.outlinedShape,
        modifier = Modifier
            .size(height = 300.dp, width = 300.dp)
            .padding(10.dp),
        border = BorderStroke(1.dp, color = Color.Black),
    ){
        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Hallo", )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Checkbox()
                Text(text = "kacken")
            }
            NotizScreen()
        }



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



