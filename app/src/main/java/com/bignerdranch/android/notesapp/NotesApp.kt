package com.bignerdranch.android.notesapp

import android.app.Application
import com.bignerdranch.android.notesapp.data.NotesRepository

class NotesApp(): Application() {
    override fun onCreate() {
        super.onCreate()
        NotesRepository.initialize(applicationContext)
    }

}