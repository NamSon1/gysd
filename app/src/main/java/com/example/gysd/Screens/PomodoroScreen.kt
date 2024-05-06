package com.example.gysd.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gysd.TaskList


@Preview(showBackground = true)
@Composable
fun PomodoroScreen() {

    Column(
        modifier = Modifier
            .padding(25.dp),
            //horizontalAlignment = Alignment.End,
            //verticalArrangement = Arrangement.Bottom

    ) {

        TaskList()

    }


}