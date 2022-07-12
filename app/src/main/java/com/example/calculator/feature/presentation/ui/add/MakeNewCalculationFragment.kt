package com.example.calculator.feature.presentation.ui.add

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.annotation.SuppressLint
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Rect
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculator.R
import com.example.calculator.databinding.FragmentMakeNewCalculationBinding
import com.example.calculator.feature.presentation.component.adapter.formula_item.CalculationFormulaItemAdapter
import com.example.calculator.feature.presentation.component.gesture.FingerGestureListener
import com.example.calculator.feature.presentation.util.DummyData
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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

        binding.calculationFormulaRecyclerview.setOnTouchListener(FingerGestureListener(flickListener))

        // 計算ボタンでジェスチャーを検出しても，何も操作を行わない
        binding.calculationButtonConstraintLayout.setOnTouchListener(
            View.OnTouchListener{ view, event ->
                when(event.action) {
                    MotionEvent.ACTION_DOWN -> {
                    }
                }
                return@OnTouchListener true
            }
        )

        return binding.root
    }

    private val flickListener = object : FingerGestureListener.Listener {

        override fun onTouchScreen() {

        }

        override fun onFlickToTop() {
            toggleVisible()
        }

        override fun onFlickToBottom() {
            toggleInVisible()
        }

    }

    @SuppressLint("ResourceAsColor")
    private fun toggleVisible() {
        binding.makeNewCalculationTitleTextView.visibility = View.VISIBLE
        binding.calculationButtonDivider.visibility = View.VISIBLE
        binding.calculationButtonConstraintLayout.visibility = View.VISIBLE
    }

    @SuppressLint("ResourceAsColor")
    private fun toggleInVisible() {
        binding.makeNewCalculationTitleTextView.visibility = View.INVISIBLE
        binding.calculationButtonDivider.visibility = View.INVISIBLE
        binding.calculationButtonConstraintLayout.visibility = View.INVISIBLE
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