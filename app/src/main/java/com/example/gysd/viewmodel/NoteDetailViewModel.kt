package com.example.gysd.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class NoteViewModel : ViewModel() {
    var noteText by mutableStateOf("")
    var titleText by mutableStateOf("")

    // You can add functions here to handle saving/loading data,
    // performing network requests, etc.

    fun saveNote() {
        // Use a repository or data source to save the noteText and titleText
    }
}