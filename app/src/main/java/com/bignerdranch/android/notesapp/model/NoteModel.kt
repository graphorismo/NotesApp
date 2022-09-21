package com.bignerdranch.android.notesapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class NoteModel(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    var title: String = "Title",
    var description: String = "Description",
    var checked: Boolean = false
) {
}