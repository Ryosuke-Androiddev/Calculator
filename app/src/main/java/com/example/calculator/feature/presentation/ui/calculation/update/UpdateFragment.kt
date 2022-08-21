package com.example.calculator.feature.presentation.ui.calculation.update

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calculator.R
import com.example.calculator.databinding.FragmentUpdateBinding
import com.example.calculator.feature.presentation.component.adapter.formula_item.CalculationFormulaItemAdapter
import com.example.calculator.feature.presentation.ui.calculation.viewmodel.CalculationViewModel
import com.example.calculator.feature.presentation.util.DummyData
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UpdateFragment : Fragment(R.layout.fragment_update) {

    private var _binding: FragmentUpdateBinding? = null
    private val binding get() = _binding!!

    private val args: UpdateFragmentArgs by navArgs()
    private val adapter by lazy { CalculationFormulaItemAdapter() }
    private val viewModel: CalculationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUpdateBinding.inflate(inflater, container, false)

        Log.d("UpdateFragment", "UpdateFragment View Created")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ACボタンで入力を全削除
        binding.updateAcButton.setOnClickListener {
            binding.updateFormulaTextview.text = ""
            binding.updateFormulaAnswerTextView.text = ""
        }

        // backSpace で、1文字削除
        binding.updateDeleteFormulaInputButton.setOnClickListener {
            val length = binding.updateFormulaTextview.text.length

            if (length > 0) {
                // 入力された文字をラストインデックスのラストを削除してあげる
                binding.updateFormulaTextview.text = binding.updateFormulaTextview.text.subSequence(0, length - 1)
            }
        }

        binding.updateFormulaInput0Button.setOnClickListener {
            binding.updateFormulaTextview.text = addInputTextToFormulaTextView("0")
        }

        binding.updateFormulaInput1Button.setOnClickListener {
            binding.updateFormulaTextview.text = addInputTextToFormulaTextView("1")
        }

        binding.updateFormulaInput2Button.setOnClickListener {
            binding.updateFormulaTextview.text = addInputTextToFormulaTextView("2")
        }

        binding.updateFormulaInput3Button.setOnClickListener {
            binding.updateFormulaTextview.text = addInputTextToFormulaTextView("3")
        }

        binding.updateFormulaInput4Button.setOnClickListener {
            binding.updateFormulaTextview.text = addInputTextToFormulaTextView("4")
        }

        binding.updateFormulaInput5Button.setOnClickListener {
            binding.updateFormulaTextview.text = addInputTextToFormulaTextView("5")
        }

        binding.updateFormulaInput6Button.setOnClickListener {
            binding.updateFormulaTextview.text = addInputTextToFormulaTextView("6")
        }

        binding.updateFormulaInput7Button.setOnClickListener {
            binding.updateFormulaTextview.text = addInputTextToFormulaTextView("7")
        }

        binding.updateFormulaInput8Button.setOnClickListener {
            binding.updateFormulaTextview.text = addInputTextToFormulaTextView("8")
        }

        binding.updateFormulaInput9Button.setOnClickListener {
            binding.updateFormulaTextview.text = addInputTextToFormulaTextView("9")
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
                    binding.updateCalculationFormulaRecyclerview.scrollToPosition(DummyData.contentList.size - 1)
                } else if (startId == R.id.start) {
                    // 繰り返し呼ばれるからバグが発生してる
                    binding.updateCalculationFormulaRecyclerview.scrollToPosition(DummyData.contentList.size - 1)
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

        // navigation 時に、正しく遷移ができているかを確認する
        binding.updateCalculationTitleTextView.text = args.calculationItem.title
    }

    private fun addInputTextToFormulaTextView(buttonText: String) : String {
        // 連結していくイメージ
        return "${binding.updateFormulaTextview.text}$buttonText"
    }

    private fun setupRecyclerView() {

        binding.updateCalculationFormulaRecyclerview.adapter = adapter
        binding.updateCalculationFormulaRecyclerview.layoutManager = LinearLayoutManager(context)

        // TODO すべての実装が終わったら、以下の2行は削除する
        binding.updateCalculationFormulaRecyclerview.scrollToPosition(DummyData.contentList.size - 1)
        adapter.submitList(DummyData.contentList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}