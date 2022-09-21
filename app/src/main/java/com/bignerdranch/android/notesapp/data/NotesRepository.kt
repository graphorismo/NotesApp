package com.bignerdranch.android.notesapp.data

import android.content.Context
import androidx.room.Room
import com.bignerdranch.android.notesapp.model.NoteModel

class NotesRepository private constructor(context: Context) {

    private val database: NotesDatabase = Room
        .databaseBuilder(
            context.applicationContext,
            NotesDatabase::class.java,
            "notes_database"
        )
        .build()

    suspend fun saveNotes(notes: MutableList<NoteModel>) {
        var dao = database.notesDAO()
        notes.forEach() {
            dao.insertNote(it)
        }
    }

    suspend fun loadNotes(): List<NoteModel> {
        var dao = database.notesDAO()
        var notes = dao.getAllNotes()
        dao.removeAll()
        return notes
    }

    companion object {

        private var INSTANCE: NotesRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = NotesRepository(context)
            }
        }

        fun get(): NotesRepository {
            return INSTANCE ?:
                throw IllegalStateException("CrimeRepository must be initialized")
        }

    }
}