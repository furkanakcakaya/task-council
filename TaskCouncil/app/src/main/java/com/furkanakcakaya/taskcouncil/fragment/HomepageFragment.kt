package com.furkanakcakaya.taskcouncil.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.furkanakcakaya.taskcouncil.R
import com.furkanakcakaya.taskcouncil.adapter.TaskAdapter
import com.furkanakcakaya.taskcouncil.databinding.FragmentHomepageBinding
import com.furkanakcakaya.taskcouncil.viewmodel.HomepageFragmentViewModel
import com.furkanakcakaya.taskcouncil.viewmodel.HomepageFragmentViewModelFactory

class HomepageFragment : Fragment(), SearchView.OnQueryTextListener{
    private lateinit var binding: FragmentHomepageBinding
    private lateinit var viewModel: HomepageFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_homepage, container, false)
        binding.tbHomepageTitle = "Tasks"
        binding.homepageFragment = this

        //Bunu taşıyamıyoruz.
        (activity as AppCompatActivity).setSupportActionBar(binding.tbHomepage)

        viewModel.taskList.observe(viewLifecycleOwner,) {
            binding.adapter = TaskAdapter(requireContext(), it, viewModel)
        }

        return binding.root
    }

    fun fabClick(v: View){
        Navigation.findNavController(v).navigate(R.id.action_homepageFragment_to_taskSaveFragment)
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadTasks()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        val tVM: HomepageFragmentViewModel by viewModels() {
            HomepageFragmentViewModelFactory(requireActivity().application)
        }
        viewModel = tVM
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.homepage_search, menu)
        val item = menu.findItem(R.id.actionSearch)
        val searchView = item.actionView as SearchView
        searchView.setOnQueryTextListener(this)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.searchTask(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.searchTask(newText)
        return true
    }
}