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
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


//  Model
class CounterRepository2 {
    private val _counter = MutableStateFlow(0)

    // Public state flow
    val counter: Flow<Int> get() = _counter

    // Function to increment the counter
    fun incrementCounter() {
        _counter.value += 1
    }
}


//  ViewModel
class CounterViewModel2(private val repository: CounterRepository2) : ViewModel() {
    // Expose the counter state from the repository
    val counter: StateFlow<Int> get() = repository.counter

    // Function to increment the counter
    fun incrementCounter() {
        viewModelScope.launch {
            repository.incrementCounter()
        }
    }
}


//  ViewModel Factory
class CounterViewModelFactory2(private val repository: CounterRepository2) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CounterViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return CounterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}


//  View
@Composable
fun CounterScreen2(counterViewModel: CounterViewModel = viewModel(factory = CounterViewModelFactory2(CounterRepository2()))) {
    // Collect the counter state
    val counter = counterViewModel.counter.collectAsState()

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Counter: ${counter.value}")

        Button(
            onClick = { counterViewModel.incrementCounter() },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text(text = "Increment")
        }
    }
}

