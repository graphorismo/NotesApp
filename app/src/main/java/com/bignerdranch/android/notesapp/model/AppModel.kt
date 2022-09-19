package com.bignerdranch.android.notesapp.model

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

    fun removeNoteUnderId(itemId: Int) {
        notes.removeAt(itemId)
    }

    fun getNotesAmount(): Int {
        return notes.size
    }
}