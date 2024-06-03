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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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

    //Speichern der Zeiteinheiten als State
    var hour by remember { mutableStateOf("0") }
    var minute by remember { mutableStateOf("0") }
    var second by remember { mutableStateOf("0") }
    var amOrPm by remember { mutableStateOf("0") }

    //Logik für die Anzeige der Zeit für das Composable "DigitalClockComponent"
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

    //Hauptstruktur für den Screen
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
        //Main-Struktur
        Column(
            Modifier
                .fillMaxSize()
                .background(backGroundgrey)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,

        ){

            currentTaskGroup()
            TimerSettings()

            Spacer(modifier = Modifier.size(10.dp))

            Column(
                modifier = Modifier
                    .padding(30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                SessionLabel()
                DigitalClockComponent(hour = hour, minute = minute, amOrPm = amOrPm)
                estimatedTimeLabel()
            }


            //Task-Skipbuttons + Button zum Wechsel der Modi
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                TaskSkipButtonLeft()
                Spacer(modifier = Modifier.weight(1f))
                ModusButton()
                Spacer(modifier = Modifier.weight(1f))
                TaskSkipButtonRight()
            }

            Spacer(modifier = Modifier.size(100.dp))

            // Timer-Button + Reset-Button
            TimerButtonGroup()
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
        style = MaterialTheme.typography.titleLarge,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold
    )

    Text(
        text = "Berlin, Germany",
        // zwei Styles werden vereinigt mit ".merge"
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


@Composable
fun ModusButton(){
    Button(
        //Beim Button-Click soll der Modus gewechselt werden. Es gibt zwei verschiedene Modien: "Focus" und "Break"
        modifier = Modifier.size(width = 89.dp, height = 35.dp),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(Color.Black)
    ){
        Text(text = "Focus", fontSize = 15.sp)
    }
}

data class ToggleableInfo(
    val isChecked : Boolean,
    val text : String
)

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


@Composable
fun SessionLabel(){
    Text(
        text = "Session 3/4",
        style = MaterialTheme.typography.labelSmall,
        color = Color.Gray
    )
}

@Composable
fun estimatedTimeLabel(){
    Text(
        text = "FINNISHED AT 11:35 AM",
        style = MaterialTheme.typography.labelSmall,
        color = Color.Gray
    )
}

@Composable
fun currentTaskGroup(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        //Lable mit Text "Current Task"
        Text(
            text = "Current Task",
            style = MaterialTheme.typography.labelSmall,
            color = Color.Gray
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Making UI design for an app",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )

            IconButton(
                onClick = { /*TODO*/ }
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.editicon),
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun TimerButtonGroup(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Button(
            modifier = Modifier.size(width = 210.dp, height = 50.dp),
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(Color.Black),
            shape = RoundedCornerShape(12.dp)
        ){
            Text(
                text = "Start",
                fontSize = 25.sp,
            )
        }

        TextButton(
            onClick = { /*TODO*/ }
        ){
            Text(
                text = "Reset",
                color = Color.Gray
            )
        }
    }
}

@Composable
fun TimerButton(){
    Button(
        modifier = Modifier.size(width = 210.dp, height = 50.dp),
        onClick = { /*TODO*/ },
        colors = ButtonDefaults.buttonColors(Color.Black),
        shape = RoundedCornerShape(12.dp)
    ){
        Text(
            text = "Start",
            fontSize = 25.sp,
        )
    }
}
@Composable
fun ResetButton(){
    TextButton(
        onClick = { /*TODO*/ }
    ){
        Text(
            text = "Reset",
            color = Color.Gray
            )
    }
}
@Preview(showBackground = true)
@Composable
fun TimerSettings(){

    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "TIMER SETTINGS",
            fontWeight = FontWeight.SemiBold,
            fontSize = 15.sp
        )

        IconButton(
            onClick = { /*TODO*/ }

        ){
            Icon(
                imageVector = ImageVector.vectorResource(id = R.drawable.timersettingsbuttonicon),
                contentDescription = null
            )
        }
    }


}

