package com.furkanakcakaya.taskcouncil.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.furkanakcakaya.taskcouncil.entity.Task
import com.furkanakcakaya.taskcouncil.repository.TaskRepository

class TaskDetailsFragmentViewModel (application: Application): AndroidViewModel(application) {
    private val taskRepository: TaskRepository = TaskRepository(application)

    fun updateTask(task_id: Int, task_name: String) {
        taskRepository.updateTask(task_id, task_name)
    }

}