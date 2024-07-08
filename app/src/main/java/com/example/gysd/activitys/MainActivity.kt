package com.example.gysd.activitys

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.gysd.ui.theme.GysdTheme
import androidx.compose.ui.unit.dp
import androidx.lifecycle.lifecycleScope
import com.example.gysd.database.AppDatabase
import com.example.gysd.database.NoteEntity
import com.example.gysd.database.NoteRepository
import com.example.gysd.navigation.AppNavigation
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = this

        lifecycleScope.launch {
            val debugTag = "roomDB"

            // Get an instance of the database
            val db = AppDatabase.getDatabase(context)

            // Create an instance of your repository (assuming you have a NoteRepository class)
            val repository = NoteRepository(db.noteDao())

            // Insert the initial data (if needed)
            val tableData = NoteEntity(
                id = 1,
                title = "Wäsche",
                content = "waschen und falten"
            )
            repository.insertNote(tableData)

            // Now you can use the repository to interact with the database
            // For example, to fetch all notes:
            val allNotes = repository.getAllNotes()
            // ... use the allNotes Flow to observe and display data in your UI
        }



        setContent {
            GysdTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Michael")
                    AppNavigation()
                }
            }
        }
    }
}




