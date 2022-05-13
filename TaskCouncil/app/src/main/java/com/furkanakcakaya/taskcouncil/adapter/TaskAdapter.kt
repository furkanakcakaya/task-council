package com.furkanakcakaya.taskcouncil.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.RecyclerView
import com.furkanakcakaya.taskcouncil.R
import com.furkanakcakaya.taskcouncil.databinding.TaskItemBinding
import com.furkanakcakaya.taskcouncil.entity.Task
import com.furkanakcakaya.taskcouncil.fragment.HomepageFragmentDirections
import com.furkanakcakaya.taskcouncil.viewmodel.HomepageFragmentViewModel
import com.google.android.material.snackbar.Snackbar

class TaskAdapter(
    private val mContext: Context,
    private val tasks: List<Task>,
    val viewModel: HomepageFragmentViewModel
)  : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    private val TAG = "TaskAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val binding: TaskItemBinding = DataBindingUtil
            .inflate(layoutInflater, R.layout.task_item ,parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        val b = holder.binding
        b.taskObject = task

        b.cvTask.setOnClickListener {
            val action = HomepageFragmentDirections.actionHomepageFragmentToTaskDetailsFragment(task)
            Navigation.findNavController(it).navigate(action)
        }

        b.imageView.setOnClickListener {
            Snackbar.make(b.root, "${task.task_name} silinsin mi?", Snackbar.LENGTH_LONG).setAction(
                "Evet"
            ) {
                viewModel.deleteTask(task.task_id)
            }.show()
        }
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    inner class TaskViewHolder(var binding :TaskItemBinding): RecyclerView.ViewHolder(binding.root)
}