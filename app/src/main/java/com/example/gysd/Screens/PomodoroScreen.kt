package com.example.gysd.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.gysd.R
import com.example.gysd.navigation.AppNavigation
import com.example.gysd.ui.theme.backGroundgrey
import com.example.gysd.ui.theme.black


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun PomodoroScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                //modifier = Modifier.border(width = Dp.Hairline, color = Color.Black, shape = RectangleShape),

                /*
                modifier = Modifier.drawBehind {
                    drawRoundRect(
                        color = Color.Black,
                        cornerRadius = CornerRadius(0.dp.toPx(), 0.dp.toPx()),
                        alpha = 1F
                    )
                },
                 */

                modifier = Modifier.drawBehind {
                    val strokeWidth = 100 * density
                    val y = size.height - strokeWidth / 2

                    drawLine(
                        Color.LightGray,
                        Offset(0f, y),
                        Offset(size.width, y),
                        strokeWidth
                    )
                },

                title = {
                    Text("GYSD!")
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = backGroundgrey,
                    titleContentColor = black,
                ),


            )
        }

    ){ innerPaddingValues ->
        Column(
            Modifier.fillMaxSize().background(backGroundgrey),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Divider (
                color = Color.Black,
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
            )
            Text(text = "Werbung 1")
            Text(text = "Werbung 2")
            Text(text = "Werbung 3")

            Button(onClick = { /*TODO*/ }) {

            }

        }




    }
}


/*
Column {
        Row {
            TaskSkipButtonLeft()
            Text(text = "Jamba")
            Spacer(modifier = Modifier.width(50.dp))
            TaskSkipButtonRight()
            CounterButton()
        }
    }
 */



/* Rechteck-Ersteller
@Preview(showBackground = true)
@Composable
fun ExampleBox(){
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasQuadrantSize = size / 2F
        drawRect(
            color = Color.Magenta,
            size = canvasQuadrantSize
        )
    }
}
*/

@Preview(showBackground = true)
@Composable
fun TaskSkipButtonLeft() {
    IconButton(
        onClick = { /*TODO*/ }
    ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.taskskipbuttonleft),
                contentDescription = null
            )
    }
}


@Preview(showBackground = true)
@Composable
fun TaskSkipButtonRight() {
    IconButton(
        onClick = { /*TODO*/ }
    ) {
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.taskskipbuttonright),
                contentDescription = null
            )
    }
}

@Preview(showBackground = true)
@Composable
fun CounterButton() {
    var counter by remember { mutableStateOf(0) }
    Button(onClick = { counter++ }) {
        Text("Counter: $counter")
    }
}




