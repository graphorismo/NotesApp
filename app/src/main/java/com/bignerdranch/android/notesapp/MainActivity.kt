package com.bignerdranch.android.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels

class MainActivity :
    AppCompatActivity(),
    StartFragment.ICallbacks
{

    val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStartScreenEnd() {
        var loadFragment = LoadFragment()
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.activityMain_fragmentContainerView,
                loadFragment)
            .commit()
    }
}