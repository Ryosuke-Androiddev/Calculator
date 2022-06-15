package com.example.calculator.feature.presentation.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculator.R
import com.example.calculator.databinding.FragmentListBinding
import com.example.calculator.feature.domain.model.CalculationInfoItem
import com.example.calculator.feature.presentation.adapter.list.CalculationInfoItemAdapter
import com.example.calculator.feature.presentation.list.viewmodel.ListViewModel
import com.example.calculator.feature.presentation.util.DummyData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListViewModel by viewModels()
    private val adapter by lazy { CalculationInfoItemAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListBinding.inflate(inflater, container, false)

        Log.d("UpdateFragment", "UpdateFragment View Created")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.getAllCalculation.observe(viewLifecycleOwner, {

        })
    }

    private fun setupRecyclerView() {

        binding.listRecyclerView.adapter = adapter
        binding.listRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter.submitList(DummyData.list)

        adapter.setOnCalculationClickListener(
            object : CalculationInfoItemAdapter.OnCalculationItemClickListener {
                override fun onItemClick(calculationInfoItem: CalculationInfoItem) {
                    val action = ListFragmentDirections.actionListFragmentToUpdateFragment(calculationItem = calculationInfoItem)
                    findNavController().navigate(action)
                }
            }
        )
    }
}