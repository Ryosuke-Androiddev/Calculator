package com.example.calculator.feature.presentation.ui.add

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculator.R
import com.example.calculator.databinding.FragmentMakeNewCalculationBinding
import com.example.calculator.feature.presentation.component.adapter.formula_item.CalculationFormulaItemAdapter
import com.example.calculator.feature.presentation.util.DummyData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MakeNewCalculationFragment : Fragment(R.layout.fragment_make_new_calculation) {

    private var _binding: FragmentMakeNewCalculationBinding? = null
    private val binding get() = _binding!!

    private val adapter by lazy { CalculationFormulaItemAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMakeNewCalculationBinding.inflate(inflater, container, false)

        Log.d("AddFragment", "AddFragment View Created")

        //setupRecyclerView()

//        val point = binding.calculationButtonConstraintLayout.getLocationPointInWindow()
//
//        // TODO 半分以上、以下の場合でViewの表示方法を変化させる
//        binding.calculationButtonConstraintLayout.isVisible = point.x / 3 <= point.x

        return binding.root
    }

    private fun View.setMotionLayoutVisibility(visibility: Int) {
        val motionLayout = parent as MotionLayout
        motionLayout.constraintSetIds.forEach {
            val constraintSet = motionLayout.getConstraintSet(it) ?: return@forEach
            constraintSet.setVisibility(this.id, visibility)
            constraintSet.applyTo(motionLayout)
        }
    }

    private fun setupRecyclerView() {

        binding.calculationFormulaRecyclerview.adapter = adapter
        binding.calculationFormulaRecyclerview.layoutManager = LinearLayoutManager(context)
        adapter.submitList(DummyData.contentList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}