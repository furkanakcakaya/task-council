package com.furkanakcakaya.taskcouncil.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.furkanakcakaya.taskcouncil.entity.Task
import com.furkanakcakaya.taskcouncil.repository.TaskRepository

class TaskSaveFragmentViewModel (application: Application): AndroidViewModel(application) {
    private val taskRepository = TaskRepository(application)

    fun saveTask(task: String) {
        taskRepository.saveTask(task)
    }

}