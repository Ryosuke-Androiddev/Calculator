package com.example.calculator.feature.presentation.ui.calculation.make

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
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculator.R
import com.example.calculator.databinding.FragmentMakeNewCalculationBinding
import com.example.calculator.feature.presentation.component.adapter.formula_item.CalculationFormulaItemAdapter
import com.example.calculator.feature.presentation.ui.calculation.viewmodel.CalculationViewModel
import com.example.calculator.feature.presentation.util.DummyData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MakeNewCalculationFragment : Fragment(R.layout.fragment_make_new_calculation) {

    private var _binding: FragmentMakeNewCalculationBinding? = null
    private val binding get() = _binding!!

    private val args: MakeNewCalculationFragmentArgs by navArgs()
    private val adapter by lazy { CalculationFormulaItemAdapter() }
    private val viewModel: CalculationViewModel by viewModels()

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

        binding.makeNewCalculationTitleTextView.text = args.newCalculationInfo.title

        // ACボタンで入力を全削除
        binding.acButton.setOnClickListener {
            binding.formulaTextview.text = ""
            binding.formulaAnswerTextView.text = ""
        }

        // backSpace で、1文字削除
        binding.deleteFormulaInputButton.setOnClickListener {
            val length = binding.formulaTextview.text.length

            if (length > 0) {
                // 入力された文字をラストインデックスのラストを削除してあげる
                binding.formulaTextview.text = binding.formulaTextview.text.subSequence(0, length - 1)
            }
        }

        binding.formulaTextview.setOnClickListener {
            binding.formulaTextview.text = addInputTextToFormulaTextView("0")
        }

        binding.formulaInput1Button.setOnClickListener {
            binding.formulaTextview.text = addInputTextToFormulaTextView("1")
        }

        binding.formulaInput2Button.setOnClickListener {
            binding.formulaTextview.text = addInputTextToFormulaTextView("2")
        }

        binding.formulaInput3Button.setOnClickListener {
            binding.formulaTextview.text = addInputTextToFormulaTextView("3")
        }

        binding.formulaInput4Button.setOnClickListener {
            binding.formulaTextview.text = addInputTextToFormulaTextView("4")
        }

        binding.formulaInput5Button.setOnClickListener {
            binding.formulaTextview.text = addInputTextToFormulaTextView("5")
        }

        binding.formulaInput6Button.setOnClickListener {
            binding.formulaTextview.text = addInputTextToFormulaTextView("6")
        }

        binding.formulaInput7Button.setOnClickListener {
            binding.formulaTextview.text = addInputTextToFormulaTextView("7")
        }

        binding.formulaInput8Button.setOnClickListener {
            binding.formulaTextview.text = addInputTextToFormulaTextView("8")
        }

        binding.formulaInput9Button.setOnClickListener {
            binding.formulaTextview.text = addInputTextToFormulaTextView("9")
        }

        // Calculation Sign

        binding.formulaInputDotButton.setOnClickListener {
            binding.formulaTextview.text = addInputTextToFormulaTextView(".")
        }

        binding.divisionFormulaInputButton.setOnClickListener {
            binding.formulaTextview.text = addInputTextToFormulaTextView("÷")
        }

        binding.multiplyFormulaInputButton.setOnClickListener {
            binding.formulaTextview.text = addInputTextToFormulaTextView("×")
        }

        binding.minusFormulaInputButton.setOnClickListener {
            binding.formulaTextview.text = addInputTextToFormulaTextView("-")
        }

        binding.plusFormulaInputButton.setOnClickListener {
            binding.formulaTextview.text = addInputTextToFormulaTextView("+")
        }

        binding.equalFormulaInputButton.setOnClickListener {
            // show answer and insert calculation
            // TODO call UseCase Insert Logic here
        }

        setupRecyclerView()

        // TODO すべての処理が終わったタイミングで購読を始める
//        viewModel.getAllCalculationContent.observe(viewLifecycleOwner) { calculationContentList ->
//            adapter.submitList(calculationContentList)
//        }

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

    private fun addInputTextToFormulaTextView(buttonText: String) : String {
        // 連結していくイメージ
        return "${binding.formulaTextview.text}$buttonText"
    }

    private fun setupRecyclerView() {

        binding.calculationFormulaRecyclerview.adapter = adapter
        binding.calculationFormulaRecyclerview.layoutManager = LinearLayoutManager(context)

        // TODO すべての実装が終わったら、以下の2行は削除する
        binding.calculationFormulaRecyclerview.scrollToPosition(DummyData.contentList.size - 1)
        adapter.submitList(DummyData.contentList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}