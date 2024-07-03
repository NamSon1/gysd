package com.example.gysd.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.gysd.Screens.listOfTasks
import com.example.gysd.database.NoteDao
import com.example.gysd.database.NoteEntity
import com.example.gysd.database.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


class NoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var noteText by mutableStateOf("")
    var titleText by mutableStateOf("")
    var noteId: Int? = savedStateHandle.get<Int>("noteId")

    init {
        if (noteId != null) {
            viewModelScope.launch {
                val note = noteRepository.getNoteById(noteId!!) // Use repository
                noteText = note.content
                titleText = note.title
            }
        }
    }

    fun saveNote() {
        viewModelScope.launch {
            val note = NoteEntity(id = noteId ?: 0, title = titleText, content = noteText)
            if (noteId == null) {
                noteRepository.insertNote(note) // Use repository
            } else {
                noteRepository.updateNote(note) // Use repository
            }
        }
    }

    //val allTasks: Flow<List<NoteEntity>> = noteRepository.getAllNotes()

    val allTasks: Flow<List<NoteEntity>> = flowOf(listOfTasks.map {
        NoteEntity(title = it.titel, content = "") // Map Task to NoteEntity
    }).flatMapLatest { initialTasks ->
        noteRepository.getAllNotes().map { dbTasks ->
            initialTasks + dbTasks // Combine initial and database tasks
        }
    }

}


class NoteViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(repository, SavedStateHandle()) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}



