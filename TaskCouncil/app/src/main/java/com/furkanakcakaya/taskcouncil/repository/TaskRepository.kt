package com.furkanakcakaya.taskcouncil.repository

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.furkanakcakaya.taskcouncil.entity.Task
import com.furkanakcakaya.taskcouncil.room.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskRepository(application: Application) {
    private var TAG = "TaskRepository"
    private var tasks: MutableLiveData<List<Task>> = MutableLiveData<List<Task>>()
    private var db = AppDatabase.getInstance(application)

    fun getTasks():LiveData<List<Task>>{
        return tasks
    }

    fun loadTasks() {
        val job = CoroutineScope(Dispatchers.Main).launch {
            tasks.value = db.taskDao().getAllTasks()
        }
    }

    fun saveTask(taskName: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            val task = Task(0,taskName)
            db.taskDao().insertTask(task)
        }
    }

    fun updateTask(taskId: Int, taskName: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            db.taskDao().updateTask(taskId,taskName)
        }
    }

    fun deleteTask(taskId: Int) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            db.taskDao().deleteTask(taskId)
            loadTasks()
        }
    }

    fun searchTask(query: String) {
        val job = CoroutineScope(Dispatchers.Main).launch {
            tasks.value = db.taskDao().searchTask(query)
        }
    }
}