package com.bignerdranch.android.notesapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.bignerdranch.android.notesapp.databinding.FragmentNoteViewBinding
import com.bignerdranch.android.notesapp.databinding.FragmentNotesListBinding
import com.bignerdranch.android.notesapp.model.NoteModel
import java.lang.Exception

private const val ARG_NOTE_ID = "ARG_NOTE_ID"


class NoteViewFragment : Fragment() {

    private var noteId: Int? = null
    private var noteModel: NoteModel? = null

    val activityViewModel: MainViewModel by activityViewModels()

    private var _binding: FragmentNoteViewBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            noteId = it.getInt(ARG_NOTE_ID)
            if(noteId != null){
                noteModel = activityViewModel.appModel.getNoteUnderId(noteId!!)
            }
            else throw Exception("Should not start a NoteViewFragment without correct noteId param")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNoteViewBinding.inflate(inflater, container, false)
        val view = binding.root
        binding.editTextTextPersonName.setText(noteModel!!.title)
        binding.editTextTextMultiLine.setText(noteModel!!.description)
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        fun newInstance(noteIdParam: Int) =
            NoteViewFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_NOTE_ID, noteIdParam)
                }
            }
    }
}