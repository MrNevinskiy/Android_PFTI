package com.example.android_pfti.view.list_fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android_pfti.R
import com.example.android_pfti.databinding.FragmentListBinding
import com.example.android_pfti.model.AppData
import com.example.android_pfti.model.repo.LocationList
import com.example.android_pfti.view.adapter.ListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListFragment : Fragment(R.layout.fragment_list) {

    private val viewModel: ListViewModel by viewModel()
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: FragmentListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        viewModel.subscribe().observe(viewLifecycleOwner,{
            renderData(it)
        })
        init(view)
    }

    private fun init(view: View) {
        recyclerView = view.findViewById(R.id.rv_list)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.getListOfMarker()
    }

    private fun renderData(data: AppData) {
        when(data){
            is AppData.Success<*> -> {
                when(data.data){
                    is LocationList -> {
                        recyclerView.adapter = ListAdapter(data.data)
                    }
                }

            }
            else -> {
                Toast.makeText(context,"ErrorData", Toast.LENGTH_LONG).show()
            }
        }
    }
} 