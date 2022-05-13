package com.furkanakcakaya.taskcouncil.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HomepageFragmentViewModelFactory(var application: Application) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomepageFragmentViewModel(application) as T
    }
}