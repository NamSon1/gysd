package com.example.gysd.Screens

import android.annotation.SuppressLint
import android.widget.TextClock
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun CalendarScreen(navController: NavHostController) {
    Box(modifier = Modifier
        .fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Statistics Screen",
                fontFamily = FontFamily.Serif,
                fontSize = 22.sp
            )
            displayTxtClock()
        }


    }
}


@Composable
fun displayTxtClock() {
    // on below line we are creating
    // a column on below sides.
    Column(
        // on below line we are adding padding
        // padding for our column and filling the max size.
        Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth(),
        // on below line we are adding
        // horizontal alignment for our column
        horizontalAlignment = Alignment.CenterHorizontally,
        // on below line we are adding
        // vertical arrangement for our column
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            // on below line we are specifying text
            // to display in top app bar.
            text = "Text Clock in Android",

            // on below line we are specifying
            // modifier to fill max width.
            modifier = Modifier.fillMaxWidth(),

            // on below line we are
            // specifying text alignment.
            textAlign = TextAlign.Center,

            // on below line we are
            // specifying color for our text.
            color = Color.Green,

            // on below line we are
            // updating font size.
            fontSize = 25.sp,
        )

        // on below line we are creating a spacer.
        Spacer(modifier = Modifier.height(20.dp))

        // on below line we are creating a text clock.
        AndroidView(
            // on below line we are initializing our text clock.
            factory = { context ->
                TextClock(context).apply {
                    // on below line we are setting 12 hour format.
                    format12Hour?.let { this.format12Hour = "hh:mm:ss a" }
                    // on below line we are setting time zone.
                    timeZone?.let { this.timeZone = it }
                    // on below line we are setting text size.
                    textSize.let { this.textSize = 30f }
                }
            },
            // on below line we are adding padding.
            modifier = Modifier.padding(5.dp),
        )
    }
}
