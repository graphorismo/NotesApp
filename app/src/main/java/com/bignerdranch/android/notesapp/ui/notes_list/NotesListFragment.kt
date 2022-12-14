package com.bignerdranch.android.notesapp.ui.notes_list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.bignerdranch.android.notesapp.databinding.FragmentNotesListBinding
import com.bignerdranch.android.notesapp.ui.MainViewModel


class NotesListFragment :
    Fragment(),
    NotesListAdapter.ICallbacks
{

    interface ICallbacks{
        fun onNoteOpen(noteid: Int)
    }

    lateinit var recyclerViewAdapter: NotesListAdapter

    private var _binding: FragmentNotesListBinding? = null
    // This property is only valid between onCreateView and
// onDestroyView.
    private val binding get() = _binding!!

    val activityViewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotesListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewAdapter = NotesListAdapter(this, activityViewModel.appModel)
        binding.recyclerView.adapter = recyclerViewAdapter
        binding.recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.button.setOnClickListener(){
            activityViewModel.appModel.addNewBlankNote()
            (activity as ICallbacks)
                .onNoteOpen(activityViewModel.appModel.getNotesAmount()-1)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(itemId: Int) {
        (activity as ICallbacks).onNoteOpen(itemId)
    }

}