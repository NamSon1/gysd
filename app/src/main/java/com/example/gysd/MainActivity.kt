package com.example.gysd

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.gysd.Screens.listOfTasks2
import com.example.gysd.ui.theme.GysdTheme
import com.example.gysd.database.AppDatabase
import com.example.gysd.database.NoteEntity
import com.example.gysd.database.NoteRepository
import com.example.gysd.navigation.AppNavigation
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    //private lateinit var database: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //database = AppDatabase.getDatabase(this)
        /*
        database = AppDatabase.getDatabase(this)

        val context = this

        lifecycleScope.launch {
            val debugTag = "roomDB"
            val repository = NoteRepository(context)
            val testData = NoteEntity(
                id = 1,
                title = "Kalender",
                content = "01.01.1990"
            )

            Log.d(debugTag, "Database created")
            repository.insertNote(testData)
        }

         */



        setContent {
            GysdTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}



