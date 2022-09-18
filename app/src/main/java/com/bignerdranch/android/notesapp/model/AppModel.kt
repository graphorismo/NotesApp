package com.bignerdranch.android.notesapp.model

import kotlinx.coroutines.delay

class AppModel {
    private var notes = mutableListOf<NoteModel>();

    suspend fun fillWithDummyData(){
        delay(2000L)
        repeat(35){
            notes.add(NoteModel())
        }
    }

    fun getNotes(): List<NoteModel>{
        return notes.toList()
    }
}