package com.example.calculator.feature.presentation.ui.list

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
import com.example.calculator.feature.domain.model.CalculationInfo
import com.example.calculator.feature.presentation.component.adapter.list_item.CalculationInfoItemAdapter
import com.example.calculator.feature.presentation.component.dialog.CustomPopUpDialogFragment
import com.example.calculator.feature.presentation.ui.list.viewmodel.ListViewModel
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

        Log.d("UpdateFragment", "ListFragment View Created")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        viewModel.getAllCalculation.observe(viewLifecycleOwner, {

        })

        childFragmentManager.setFragmentResultListener("update_navigation", viewLifecycleOwner) { requestKey: String, bundle: Bundle ->
            val result = bundle["result"] as CalculationInfo
            Log.d("Result", "${findNavController().currentDestination}")
            Log.d("Result","${result.equals(CalculationInfo(1, "Java", 20220614L, 1L))}")
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment(result)
            findNavController().navigate(action)
        }

        binding.DashBorderButton.setOnClickListener {
            navigateToCreateNewItemFragment()
        }
    }

    private fun setupRecyclerView() {

        binding.listRecyclerView.adapter = adapter
        binding.listRecyclerView.layoutManager = LinearLayoutManager(context)
        adapter.submitList(DummyData.list)

        adapter.setOnCalculationClickListener(
            object : CalculationInfoItemAdapter.OnCalculationItemClickListener {

                override fun onCalculationItemInfoOnClick(calculationInfo: CalculationInfo) {
                    navigateToUpdateFragment(calculationInfo = calculationInfo)
                }

                override fun showPopUpWindow(calculationInfo: CalculationInfo) {
                    Log.d("CurrentNav", "${findNavController().currentDestination}")
                    // pass Dialog Fragment Manager (childFragment Manager)
                    CustomPopUpDialogFragment(calculationInfoItem = calculationInfo).show(childFragmentManager, "Custom Pop Up")
                }
            }
        )
    }

    private fun navigateToUpdateFragment(calculationInfo: CalculationInfo) {
        val action = ListFragmentDirections.actionListFragmentToUpdateFragment(calculationItem = calculationInfo)
        findNavController().navigate(action)
    }

    private fun navigateToCreateNewItemFragment() {
        val action = ListFragmentDirections.actionListFragmentToCreateNewItemFragment()
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}