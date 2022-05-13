package com.furkanakcakaya.taskcouncil.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.furkanakcakaya.taskcouncil.R
import com.furkanakcakaya.taskcouncil.databinding.FragmentTaskDetailsBinding
import com.furkanakcakaya.taskcouncil.viewmodel.HomepageFragmentViewModelFactory
import com.furkanakcakaya.taskcouncil.viewmodel.TaskDetailsFragmentViewModel
import com.furkanakcakaya.taskcouncil.viewmodel.TaskDetailsFragmentViewModelFactory

class TaskDetailsFragment : Fragment() {
    private lateinit var binding: FragmentTaskDetailsBinding
    private lateinit var viewModel: TaskDetailsFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?,
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_task_details,container, false)
        binding.taskDetailsFragment = this
        binding.tbTaskDetailsTitle = getString(R.string.task_details)
        binding.taskObject = TaskDetailsFragmentArgs.fromBundle(requireArguments()).task

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tVM: TaskDetailsFragmentViewModel by viewModels() {
            TaskDetailsFragmentViewModelFactory(requireActivity().application)
        }
            viewModel = tVM
    }

    fun buttonUpdateClicked(task_id:Int, task_name:String) {
        viewModel.updateTask(task_id, task_name)

    }
}