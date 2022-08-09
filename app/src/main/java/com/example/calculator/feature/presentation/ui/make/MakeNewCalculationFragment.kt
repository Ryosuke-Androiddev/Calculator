package com.example.calculator.feature.presentation.ui.make

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
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

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMakeNewCalculationBinding.inflate(inflater, container, false)

        Log.d("AddFragment", "AddFragment View Created")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        binding.motionBase.setTransitionListener(object : MotionLayout.TransitionListener {

            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
                if (startId == R.id.end) {
                    binding.calculationFormulaRecyclerview.scrollToPosition(DummyData.contentList.size - 1)
                } else if (startId == R.id.start) {
                    // 繰り返し呼ばれるからバグが発生してる
                    binding.calculationFormulaRecyclerview.scrollToPosition(DummyData.contentList.size - 1)
                }
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {
            }

        })
    }

    private fun setupRecyclerView() {

        binding.calculationFormulaRecyclerview.adapter = adapter
        binding.calculationFormulaRecyclerview.layoutManager = LinearLayoutManager(context)
        // これで一番最後から表示する
        binding.calculationFormulaRecyclerview.scrollToPosition(DummyData.contentList.size - 1)
        // scroll を分けてくれるけど，単体でscrollできなくなる
        // これを直接XMLで分けることができればいいんだけど
        // start では，false end では，true
        // binding.calculationFormulaRecyclerview.isNestedScrollingEnabled = true
        adapter.submitList(DummyData.contentList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}