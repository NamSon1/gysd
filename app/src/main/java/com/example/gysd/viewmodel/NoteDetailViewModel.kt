package com.example.gysd.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gysd.database.NoteDao
import com.example.gysd.database.NoteEntity
import kotlinx.coroutines.launch
import javax.inject.Inject


class NoteViewModel @Inject constructor(
    private val noteDao : NoteDao,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var noteText by mutableStateOf("")
    var titleText by mutableStateOf("")
    var noteId: Int? = savedStateHandle.get<Int>("noteId")

    init {
        if (noteId != null) {
            // Fetch existing note details from the database
            viewModelScope.launch {
                val note = noteDao.getNoteById(noteId!!)
                noteText = note.content
                titleText = note.title
            }
        }
    }

    fun saveNote() {
        viewModelScope.launch {
            if (noteId == null) {
                // Insert new note
                noteDao.insertNote(NoteEntity(title = titleText, content = noteText))
            } else {
                // Update existing note
                noteDao.updateNote(NoteEntity(id = noteId!!, title = titleText, content = noteText))
            }
        }
    }
}
