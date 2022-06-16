package com.example.calculator.feature.presentation.list

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculator.R
import com.example.calculator.databinding.CustomPopUpWindowBinding
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

    private lateinit var parent: ConstraintLayout

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

                override fun onCalculationItemInfoOnClick(calculationInfoItem: CalculationInfoItem) {
                    navigateToUpdateFragment(calculationInfoItem = calculationInfoItem)
                }

                override fun showPopUpWindow(calculationInfoItem: CalculationInfoItem) {
                    // このイベントが発生するときにこの処理が走る→ビューの生成のタイミングと破棄のタイミングを考える
                    val customPopUpWindowBinding = CustomPopUpWindowBinding.inflate(layoutInflater)

                    Log.d("PopUpImageButton", "View Created")

                    val width = ConstraintLayout.LayoutParams.WRAP_CONTENT
                    val height = ConstraintLayout.LayoutParams.WRAP_CONTENT
                    val popUpWindow = PopupWindow(customPopUpWindowBinding.root, width, height, false)

                    // 表示したい場所を第一引数で渡す
                    popUpWindow.showAtLocation(binding.root ,Gravity.CENTER, 0, 0)

                    customPopUpWindowBinding.textView3.setOnClickListener {
                        popUpWindow.dismiss()
                    }
                }
            }
        )
    }

    private fun navigateToUpdateFragment(calculationInfoItem: CalculationInfoItem) {
        val action = ListFragmentDirections.actionListFragmentToUpdateFragment(calculationItem = calculationInfoItem)
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