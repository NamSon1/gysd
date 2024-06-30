package com.example.gysd.activitys

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.gysd.activitys.ui.theme.GysdTheme
import androidx.compose.ui.platform.LocalContext
import com.example.gysd.ui.theme.backGroundgrey

class NotizSchreiben : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GysdTheme {
                NoteScreen()
            }
        }
    }
}

@Composable
fun NoteScreen() {
    var noteText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        /*
        OutlinedTextField(
            value = noteText,
            onValueChange = { noteText = it },
            label = { Text("Enter your notes") },
            modifier = Modifier.fillMaxWidth(),
            maxLines = Int.MAX_VALUE // Allow unlimited lines
        )
         */

        var text1 by remember { mutableStateOf("") }
        BasicTextField(
            value = text1,
            onValueChange = { text1 = it },
            modifier = Modifier
                .fillMaxSize()
                .background(backGroundgrey),
            )
    }
}

