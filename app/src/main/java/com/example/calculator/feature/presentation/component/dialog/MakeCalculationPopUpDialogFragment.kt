package com.example.calculator.feature.presentation.component.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import com.example.calculator.databinding.MakeCalculationPopUpDialogBinding
import com.example.calculator.feature.domain.model.CalculationInfo
import com.example.calculator.feature.presentation.component.dialog.parent.CustomDialogFragmentParent
import com.example.calculator.feature.presentation.ui.list.viewmodel.ListViewModel
import java.util.*

class MakeCalculationPopUpDialogFragment: CustomDialogFragmentParent() {

    private var _binding: MakeCalculationPopUpDialogBinding? = null
    private val binding get() = _binding!!

    private val builder by lazy { AlertDialog.Builder(requireActivity()) }
    private val dialog by lazy { builder.create() }

    private val viewModel: ListViewModel by viewModels()
    private lateinit var listener : MakeCalculationPopUpDialogListener

    interface MakeCalculationPopUpDialogListener {
        fun onMakeNewCalculationSaveButtonClick(calculationInfo: CalculationInfo)
    }

    @SuppressLint("UseGetLayoutInflater")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        _binding = MakeCalculationPopUpDialogBinding.inflate(LayoutInflater.from(requireContext()))

        builder.setView(binding.root)

        binding.saveTextButton.setOnClickListener {
            val calculationTitle = binding.calculationTitleTextview.text.toString()
            if (calculationTitle.isBlank() || calculationTitle.isEmpty()) {
                Toast.makeText(requireContext(), "Please input 0 more characters", Toast.LENGTH_SHORT).show()
            } else {
                 // Object を渡してUseCaseの呼び出しと画面遷移
                val calculationInfo = CalculationInfo(
                    calculationId = 1L,
                    title = calculationTitle,
                    date = Date()
                )
//                viewModel.insertCalculationInfoUseCase(calculationInfo = calculationInfo)
                listener.onMakeNewCalculationSaveButtonClick(calculationInfo = calculationInfo)
            }
        }

        binding.cancelTextButton.setOnClickListener {
            dismiss()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)

        return dialog
    }

    // Interface が実装されてないと例外が投げられる
    // これActivityにやってるかを確認してる、Fragmentでやられているかを確認する必要がある
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            // 呼び出し元を親Fragmentから取得する
            listener = parentFragment as MakeCalculationPopUpDialogListener
        } catch (e : ClassCastException) {
            throw ClassCastException(context.toString() + "must Implement Interface")
        }
    }

    override fun onStart() {
        super.onStart()
        setWidthPercent(80)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}