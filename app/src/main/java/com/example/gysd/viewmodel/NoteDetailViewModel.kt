package com.example.gysd.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
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


/*
    - Viewmodel für d
 */
class NoteViewModel (
    private val noteRepository: NoteRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var noteText by mutableStateOf("")
    var titleText by mutableStateOf("")
    private var noteId: Int? = savedStateHandle.get<Int>("noteId")

    /*
        - Initialisierung der State-Variablen "noteText" und "titleText", wenn eine "noteID" vorhanden ist
    */
    init {
        // prüft ob eine noteID dem ViewModel übergeben wurde
        if (noteId != null) {
            // Starten einer Coroutine
            viewModelScope.launch {
                // Datenbankeintrag mit derselben "noteId" wird von der Datenbank genommen
                val note = noteRepository.getNoteById(noteId!!) // Use repository
                noteText = note.content
                titleText = note.title
            }
        }
    }

    /*
        - Funktion, die eine Coroutine erstellt, zum Abgleich von Listeneinträgen mit der Datenbank
        - wird noch nicht verwendet und ist noch nicht fertig definiert worden
     */
    fun saveNote() {
        viewModelScope.launch {
            val note = NoteEntity(id = noteId ?: 0, title = titleText, content = noteText)
            if (noteId == null) {
                noteRepository.insertNote(note)
            } else {
                noteRepository.updateNote(note)
            }
        }
    }

    //val allTasks: Flow<List<NoteEntity>> = noteRepository.getAllNotes()

    // -
    val allTasks: Flow<List<NoteEntity>> = flowOf(listOfTasks.map {
        // Map Task to NoteEntity - Umwandlung der Listeneinträge zu Datenbankeinträgen
        NoteEntity(title = it.titel, content = "")
    }).flatMapLatest { initialTasks ->
        // Aufrufen aller Datenbankeinträge mittels des Datenbankrepository,
        // Hinzufügen der neuen Einträge
        noteRepository.getAllNotes().map { dbTasks ->
            // Combine initial and database tasks
            initialTasks + dbTasks
        }
    }
}


// Erstellung einer Instanz des Viewmodels
class NoteViewModelFactory(private val repository: NoteRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>, extras: CreationExtras): T {
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            val savedStateHandle = extras.createSavedStateHandle()
            @Suppress("UNCHECKED_CAST")
            return NoteViewModel(repository, savedStateHandle) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}



