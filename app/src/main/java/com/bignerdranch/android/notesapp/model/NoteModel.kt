package com.bignerdranch.android.notesapp.model

import java.util.*

data class NoteModel(
    val id: UUID = UUID.randomUUID(),
    var title: String = "Title",
    var description: String = "Description",
    var checked: Boolean = false
) {
}