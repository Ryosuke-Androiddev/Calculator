package com.example.calculator.feature.presentation.ui.add

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
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

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMakeNewCalculationBinding.inflate(inflater, container, false)

        Log.d("AddFragment", "AddFragment View Created")

        //setupRecyclerView()

        binding.calculationButtonConstraintLayout.setOnTouchListener(
            View.OnTouchListener { view, event ->

                val displayMetrics = resources.displayMetrics
                val viewHeight = binding.calculationButtonConstraintLayout.height

                when (event.action) {

                    MotionEvent.ACTION_UP -> {

                        var currentY = binding.calculationButtonConstraintLayout.y
                        binding.calculationButtonConstraintLayout.animate()
                            .x(50F)
                            .setDuration(150)
                            .setListener(
                                object : AnimatorListenerAdapter() {
                                    override fun onAnimationEnd(animation: Animator?) {
                                        super.onAnimationEnd(animation)
                                    }
                                }
                            )
                            .start()
                    }

                    MotionEvent.ACTION_MOVE -> {

                        // 高さを取得する
                        val newY = event.rawY

                        // newY を半分から動かしたとして、下に動かしたときに多分これが成り立つから
                        // ここの0を変えてみる
                        if (newY - viewHeight < 0) {
                            binding.calculationButtonConstraintLayout.animate()
                                .x(
                                    Math.min(0F, newY - (viewHeight / 2))
                                )
                                .setDuration(0)
                                .start()

                            // 250を変えてみる
                            if (binding.calculationButtonConstraintLayout.y < 250) {
                                binding.calculationButtonConstraintLayout.isVisible = false
                            } else {
                                binding.calculationButtonConstraintLayout.isVisible = true
                            }
                        }
                    }
                }


                view.performClick()
                return@OnTouchListener true
            }
        )

        return binding.root
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