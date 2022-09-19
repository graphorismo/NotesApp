package com.bignerdranch.android.notesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.notesapp.databinding.NotesListItemLayoutBinding
import com.bignerdranch.android.notesapp.model.NoteModel

class NotesListAdapter: RecyclerView.Adapter<NotesListAdapter.NotesListViewHolder>() {

    class NotesListViewHolder(val itemBinding: NotesListItemLayoutBinding):
        RecyclerView.ViewHolder(itemBinding.root){
        fun bindItem(note: NoteModel){
            itemBinding.notesListItemTextViewTitle.text = note.title
            itemBinding.notesListItemTextViewDescription.text = note.description
            itemBinding.notesListItemCheckBoxDone.isChecked = note.checked
        }
    }

    var notes = mutableListOf<NoteModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesListViewHolder {
        return NotesListViewHolder(
                    NotesListItemLayoutBinding.inflate(
                        LayoutInflater.from(parent.context), parent,false
                    )
               )
    }

    override fun onBindViewHolder(holder: NotesListViewHolder, position: Int) {
        val task = notes[position]
        holder.bindItem(task)
    }

    override fun getItemCount(): Int {
        return notes.size
    }

    public fun setItems(items: List<NoteModel>){
        notes = items.toMutableList()
    }

}