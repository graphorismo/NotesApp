package com.bignerdranch.android.notesapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bignerdranch.android.notesapp.model.NoteModel

@Database(entities = [ NoteModel::class ], version=1)
abstract class NotesDatabase : RoomDatabase() {
    abstract fun notesDAO(): NotesDAO
}