package com.example.gysd.Screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ToDoScreen() {
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(
            text = "Hier könnten ihre ToDo's stehen. " +
                    "Aber da sie keine Aufgaben derzeitig aufgelistet haben, steht hier dementsprechend nichts.",
            fontFamily = FontFamily.Serif,
            fontSize = 22.sp,
            modifier = Modifier.padding(20.dp)
        )
    }
}