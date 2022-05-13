package com.furkanakcakaya.taskcouncil.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.furkanakcakaya.taskcouncil.R
import com.furkanakcakaya.taskcouncil.databinding.FragmentTaskSaveBinding
import com.furkanakcakaya.taskcouncil.viewmodel.TaskSaveFragmentViewModel
import com.furkanakcakaya.taskcouncil.viewmodel.TaskSaveFragmentViewModelFactory

class TaskSaveFragment : Fragment() {
    private lateinit var binding: FragmentTaskSaveBinding;
    private lateinit var viewModel: TaskSaveFragmentViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_task_save, container, false)
        binding.taskSaveFragment = this
        binding.tbTaskSaveTitle = "New Task"
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tmp : TaskSaveFragmentViewModel by viewModels(){
            TaskSaveFragmentViewModelFactory(requireActivity().application)
        }
        viewModel = tmp
    }

    fun onSaveClicked(taskName: String) {
        viewModel.saveTask(taskName)
    }
}