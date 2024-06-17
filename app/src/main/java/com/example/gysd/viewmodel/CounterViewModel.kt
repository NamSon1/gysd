package com.example.gysd.viewmodel

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


//  MVVM-Beispiel ohne Model

//ViewModel
class CounterViewModel : ViewModel() {
    // Private mutable state flow
    private val _counter = MutableStateFlow(0)

    // Public state flow
    val counter: StateFlow<Int> get() = _counter

    // Function to increment the counter
    fun incrementCounter() {
        viewModelScope.launch {
            _counter.value += 1
        }
    }
}


//View
@Composable
fun CounterScreen(counterViewModel: CounterViewModel = viewModel()) {
    // Collect the counter state
    val counter = counterViewModel.counter.collectAsState()

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Counter: ${counter.value}")

        Button(
            onClick = { counterViewModel.incrementCounter() },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Increment")
        }
    }
}