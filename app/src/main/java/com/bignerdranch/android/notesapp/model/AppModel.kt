package com.bignerdranch.android.notesapp.model

class AppModel {
    private var notes = mutableListOf<NoteModel>();

    fun fillWithDummyData(){
        repeat(35){
            notes.add(NoteModel())
        }
    }

    fun getNotes(): List<NoteModel>{
        return notes.toList()
    }
}