package com.example.gysd.database

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.Update
import kotlinx.coroutines.flow.Flow



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

    abstract fun getDao(): NoteDao

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


