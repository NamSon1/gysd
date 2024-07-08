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
import com.example.gysd.navigation.AppNavigation
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val context = this

        /*
        lifecycleScope.launch{
            val debugTag = "roomDB"
            //val repository =
            val tableData = AppDatabase(
                id = 1,
                title = "Wäsche",
                content = "waschen und falten"
            )

            /*
                - Initialisieren und die Database-Repository bauen (PDF des Workshops schauen)
             */
        }

         */

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




