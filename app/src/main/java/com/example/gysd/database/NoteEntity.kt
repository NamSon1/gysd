package com.example.gysd.database

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


// NoteEntity.kt
@Entity
data class NoteEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val title : String,
    val content : String,
)


// NoteDao.kt
@Dao
interface NoteDao {
    @Insert
    suspend fun insertNote(note : NoteEntity)

    @Update
    suspend fun update(note: NoteEntity)

    @Delete
    suspend fun delete(note: NoteEntity)

    // für die Darstellung der Notizliste im To Do-Screen
    @Query("SELECT * FROM NoteEntity")
    fun getAllNotes(): Flow<List<NoteEntity>>

    @Query("SELECT * FROM NoteEntity WHERE id = :id")
    suspend fun getNoteById(id: Int): NoteEntity

    @Update
    suspend fun updateNote(note: NoteEntity)
}


// AppDatabase.kt
@Database(entities = [NoteEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao

    // Companion Object -- nur eine Instanz der Database kann erstellt werden
    companion object {
        @Volatile

        // stellt sicher, dass nicht zwei Instanzen derselben Datenbank angelegt werden
        private var Instance : AppDatabase? = null

        fun getDatabase(context : Context) : AppDatabase {
            val temp = Instance
            if (temp != null) return temp
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "AppDatabase 01"
                ).build()
                Instance = instance
                return instance
            }
        }
    }
}


// Database Repository
class NoteRepository (context: Context) {
    private val noteDao = AppDatabase.getDatabase(context).noteDao()

    fun getAllNotes(): Flow<List<NoteEntity>> {
        return noteDao.getAllNotes()
    }

    suspend fun getNoteById(id: Int): NoteEntity {
        return noteDao.getNoteById(id)
    }

    suspend fun insertNote(note: NoteEntity) {
        noteDao.insertNote(note)
    }

    suspend fun updateNote(note: NoteEntity) {
        noteDao.updateNote(note)
    }
}

