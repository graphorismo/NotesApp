package com.bignerdranch.android.notesapp.model

import com.bignerdranch.android.notesapp.data.NotesRepository
import kotlinx.coroutines.delay

class AppModel {
    private var notes = mutableListOf<NoteModel>();

    suspend fun fillWithDummyData(){
        delay(2000L)
        repeat(35){
            notes.add(NoteModel(title = it.toString()))
        }
    }

    fun getNotes(): List<NoteModel>{
        return notes.toList()
    }

    fun getNoteUnderId(itemId: Int): NoteModel {
        return notes[itemId]
    }

    fun getSize(): Int{
        return notes.size
    }

    fun removeNoteUnderId(itemId: Int) {
        notes.removeAt(itemId)
    }

    fun getNotesAmount(): Int {
        return notes.size
    }

    fun addNewBlankNote() {
        notes.add(NoteModel())
    }

    suspend fun saveToDatabase() {
        NotesRepository.get().saveNotes(notes)
    }

    suspend fun loadFromDatabase() {
        notes = NotesRepository.get().loadNotes().toMutableList()
    }
}