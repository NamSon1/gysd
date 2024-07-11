package com.example.gysd.uiState


data class ToDoEntryState(
    //val isDone: Boolean = false,
    val newsItems: List<ToDoEntry> = listOf()
)

data class ToDoEntry(
    val title: String,
    val body: String,
    val id: Int
)
