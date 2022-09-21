package com.bignerdranch.android.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity :
    AppCompatActivity(),
    StartFragment.ICallbacks,
    NotesListFragment.ICallbacks,
    NoteViewFragment.ICallbacks
{

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onPause() {
        super.onPause()
        lifecycleScope
            .launch(Dispatchers.Default){
                viewModel.appModel.saveToDatabase()
            }
    }

    override fun onStartScreenEnd() {
        showALoadFragment()
        this.lifecycleScope
            .launch(Dispatchers.Default) {
                viewModel.appModel.loadFromDatabase()
                showNotesListFragment()
            }

    }

    private fun showALoadFragment(){
        var loadFragment = LoadFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.activityMain_fragmentContainerView,
                loadFragment)
            .commit()
    }

    private fun showNotesListFragment(){
        var notesListFragment = NotesListFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.activityMain_fragmentContainerView,
                notesListFragment)
            .commit()
    }

    private fun showNoteViewFragment(noteId: Int){
        var noteViewFragment = NoteViewFragment.newInstance(noteId)
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.activityMain_fragmentContainerView,
                noteViewFragment)
            .commit()
    }

    override fun onNoteOpen(noteid: Int) {
        showNoteViewFragment(noteid)
    }

    override fun onNoteViewFragmentExit() {
        showNotesListFragment()
    }
}