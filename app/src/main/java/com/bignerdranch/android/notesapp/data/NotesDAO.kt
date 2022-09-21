package com.bignerdranch.android.notesapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.bignerdranch.android.notesapp.model.NoteModel

@Dao
interface NotesDAO {
    @Query("SELECT * FROM NoteModel")
    suspend fun getAllNotes(): List<NoteModel>

    @Insert
    suspend fun insertNote(noteModel: NoteModel)

    @Query("DELETE FROM NoteModel")
    suspend fun removeAll()
}