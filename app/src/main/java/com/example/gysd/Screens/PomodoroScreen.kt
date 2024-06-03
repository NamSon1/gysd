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
import androidx.compose.material3.Switch
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
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.gysd.R
import com.example.gysd.navigation.AppNavigation
import com.example.gysd.ui.theme.backGroundgrey
import com.example.gysd.ui.theme.black
import kotlinx.coroutines.delay
import java.util.Calendar
import kotlin.math.min


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun PomodoroScreen() {
    var hour by remember { mutableStateOf("0") }
    var minute by remember { mutableStateOf("0") }
    var second by remember { mutableStateOf("0") }
    var amOrPm by remember { mutableStateOf("0") }

    LaunchedEffect(Unit) {
        while (true) {
            val cal = Calendar.getInstance()
            hour = cal.get(Calendar.HOUR).run {
                if (this.toString().length == 1) "0$this" else "$this"
            }
            minute = cal.get(Calendar.MINUTE).run {
                if (this.toString().length == 1) "0$this" else "$this"
            }
            second = cal.get(Calendar.SECOND).run {
                if (this.toString().length == 1) "0$this" else "$this"
            }
            amOrPm = cal.get(Calendar.AM_PM).run {
                if (this.toString().length == 1) "AM" else "PM"
            }

            delay(1000)
        }
    }

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

    ){
        Column(
            Modifier
                .fillMaxSize()
                .background(backGroundgrey),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            DigitalClockComponent(hour = hour, minute = minute, amOrPm = amOrPm)
            Row() {
                TaskSkipButtonLeft()
                Spacer(modifier = Modifier.weight(1f))
                ModusButton()
                Spacer(modifier = Modifier.weight(1f))
                TaskSkipButtonRight()
            }


            TimerButton()
        }
    }
}



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

//erstellt schwarze Linie
Divider (
                color = Color.Black,
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
            )

*/

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

@Composable
fun DigitalClockComponent(hour : String, minute : String, amOrPm : String) {
    Text(
        text = "$hour:$minute $amOrPm",
        style = MaterialTheme.typography.titleLarge
    )

    Text(
        text = "Berlin, Germany",
        style = MaterialTheme.typography.titleMedium.merge(
            TextStyle(
                color = MaterialTheme.colorScheme.onBackground.copy(
                    alpha = 0.6f
                )
            )
        )
    )
}

@Composable
fun AnalogClockComponent(hour : Int, minute : Int, second : Int) {
    Box(modifier = Modifier.fillMaxSize(fraction = 0.6f)) {
        androidx.compose.foundation.Canvas(modifier = Modifier.fillMaxSize()) {
            val diameter = min(size.width, size.height) * 0.9f
            val radius = diameter / 2

            val start = center - Offset(0f, radius)
            val end = start + Offset(0f, radius / 40f)
            drawLine(
                color = Color.White,
                start = start,
                end = end,
                strokeWidth = 5.dp.toPx(),
                cap = StrokeCap.Round
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ModusButton(){
    Button(
        onClick = { /*TODO*/ },

    ){
        Text(text = "Focus")
    }
}

data class ToggleableInfo(
    val isChecked : Boolean,
    val text : String
)

@Composable
fun TimerButton(){
    Button(
        onClick = { /*TODO*/ }
    ){
        Text(text = "Start")
    }
}

@Composable
private fun MySwitch(){
    var switch by remember {
        mutableStateOf(ToggleableInfo(
            isChecked = false,
            text = ""
        ))
    }

    Switch(
        checked = switch.isChecked,
        onCheckedChange = {isChecked ->
            switch = switch.copy(isChecked = isChecked)
        }
    )
}

@Preview(showBackground = true)
@Composable
fun SessionLabel(){
    Text(text = "Session 3/4")
}

@Preview(showBackground = true)
@Composable
fun CurrentTaskLabel(){
    Text(text = "Current Task")
}

@Preview(showBackground = true)
@Composable
fun TaskTextField(){
    Text(text = "Making UI design for an app")
}



