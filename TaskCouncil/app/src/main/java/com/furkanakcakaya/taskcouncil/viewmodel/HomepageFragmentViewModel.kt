package com.furkanakcakaya.taskcouncil.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.furkanakcakaya.taskcouncil.entity.Task
import com.furkanakcakaya.taskcouncil.repository.TaskRepository

class HomepageFragmentViewModel (application: Application) : AndroidViewModel(application){
    private val taskRepository = TaskRepository(application)
    var taskList : LiveData<List<Task>>

    init {
        loadTasks()
        taskList = getTasks()
    }

    private fun getTasks() = taskRepository.getTasks()

    fun loadTasks(){
        taskRepository.loadTasks()
    }

    fun deleteTask(taskId: Int) {
        taskRepository.deleteTask(taskId)
    }

    fun searchTask(query: String) {
        taskRepository.searchTask(query)
    }
}