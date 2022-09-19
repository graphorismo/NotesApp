package com.bignerdranch.android.notesapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bignerdranch.android.notesapp.databinding.NotesListItemLayoutBinding
import com.bignerdranch.android.notesapp.model.AppModel
import com.bignerdranch.android.notesapp.model.NoteModel

class NotesListAdapter(
    var callbacks: NotesListAdapter.ICallbacks,
    var model: AppModel
):
    RecyclerView.Adapter<NotesListAdapter.NotesListViewHolder>()
{
    interface ICallbacks{
        fun onItemClick(itemId: Int)
        fun onDeleteClick(itemId: Int)
        fun onCheckBoxClick(itemId: Int, newState: Boolean)
    }

    private lateinit var binding: NotesListItemLayoutBinding

    class NotesListViewHolder(val view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesListViewHolder {
        binding = NotesListItemLayoutBinding
            .inflate(LayoutInflater.from(parent.context), parent,false)
        return NotesListViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: NotesListViewHolder, position: Int) {
        holder.setIsRecyclable(false)
        val note = model.getNotes()[position]
        binding.notesListItemTextViewTitle.text = note.title
        binding.notesListItemTextViewDescription.text = note.description
        binding.notesListItemCheckBoxDone.isChecked = note.checked
        binding.notesListItemConstraintLayout.setOnClickListener(){
            callbacks.onItemClick(position)
        }
        binding.notesListItemImageButtonDelete.setOnClickListener(){
            model.removeNoteUnderId(position)
            notifyDataSetChanged()
        }
        binding.notesListItemCheckBoxDone.setOnClickListener(){
            val note = model.getNotes()[position]
        }
    }

    override fun getItemCount(): Int {
        return model.getNotesAmount()
    }

}