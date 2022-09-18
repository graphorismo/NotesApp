package com.bignerdranch.android.notesapp

import androidx.lifecycle.ViewModel
import com.bignerdranch.android.notesapp.model.AppModel

class MainViewModel: ViewModel() {
    var appModel: AppModel = AppModel()
}