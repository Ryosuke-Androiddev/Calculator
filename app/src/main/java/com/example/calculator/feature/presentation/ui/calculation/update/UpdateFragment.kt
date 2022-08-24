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
import com.example.calculator.feature.domain.model.CalculationContent
import com.example.calculator.feature.presentation.component.adapter.formula_item.CalculationFormulaItemAdapter
import com.example.calculator.feature.presentation.ui.calculation.make.MakeNewCalculationFragment
import com.example.calculator.feature.presentation.ui.calculation.viewmodel.CalculationViewModel
import com.example.calculator.feature.presentation.util.DummyData
import dagger.hilt.android.AndroidEntryPoint
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

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

        // Calculation Sign

        binding.updateFormulaInputDotButton.setOnClickListener {
            binding.updateFormulaTextview.text = addInputTextToFormulaTextView(".")
        }

        binding.updateDivisionFormulaInputButton.setOnClickListener {
            binding.updateFormulaTextview.text = addInputTextToFormulaTextView("÷")
        }

        binding.updateMultiplyFormulaInputButton.setOnClickListener {
            binding.updateFormulaTextview.text = addInputTextToFormulaTextView("×")
        }

        binding.updateMinusFormulaInputButton.setOnClickListener {
            binding.updateFormulaTextview.text = addInputTextToFormulaTextView("-")
        }

        binding.updatePlusFormulaInputButton.setOnClickListener {
            binding.updateFormulaTextview.text = addInputTextToFormulaTextView("+")
        }

        binding.updateEqualFormulaInputButton.setOnClickListener {
            // show answer and insert calculation
            showCalculationResult()
            // TODO call UseCase Insert Logic here
            viewModel.insertCalculationContentUseCase(
                CalculationContent(
                    contentId = 0,
                    answer = binding.updateFormulaAnswerTextView.text.toString(),
                    formulaProcess = binding.updateFormulaTextview.text.toString(),
                    calculationInfoId = args.calculationItem.calculationId
                )
            )

            // 計算結果をクリアする
            binding.updateFormulaTextview.text = ""
            binding.updateFormulaAnswerTextView.text = ""
        }

        setupRecyclerView()

        // TODO すべての処理が終わったタイミングで購読を始める
        viewModel.getAllCalculationContent.observe(viewLifecycleOwner) { calculationContentList ->
            adapter.submitList(calculationContentList)
            binding.updateCalculationFormulaRecyclerview.smoothScrollToPosition(calculationContentList.size - 1)
        }

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
                    viewModel.getAllCalculationContent.observe(viewLifecycleOwner) { calculationList ->
                        binding.updateCalculationFormulaRecyclerview.scrollToPosition(calculationList.size - 1)
                    }
                } else if (startId == R.id.start) {
                    viewModel.getAllCalculationContent.observe(viewLifecycleOwner) { calculationList ->
                        binding.updateCalculationFormulaRecyclerview.scrollToPosition(calculationList.size - 1)
                    }
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

    // 掛け算と割り算の記号を入れ替える
    private fun getInputExpression() : String {
        var expression = binding.updateFormulaTextview.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showCalculationResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                binding.updateFormulaAnswerTextView.text = UPDATE_ERROR_MESSAGE
            } else {
                binding.updateFormulaAnswerTextView.text = DecimalFormat("0.######").format(result).toString()
            }
        } catch (e: Exception) {
            binding.updateFormulaAnswerTextView.text = UPDATE_ERROR_MESSAGE
        }
    }

    private fun setupRecyclerView() {

        binding.updateCalculationFormulaRecyclerview.adapter = adapter
        binding.updateCalculationFormulaRecyclerview.layoutManager = LinearLayoutManager(context)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val UPDATE_ERROR_MESSAGE = "Error"
    }
}