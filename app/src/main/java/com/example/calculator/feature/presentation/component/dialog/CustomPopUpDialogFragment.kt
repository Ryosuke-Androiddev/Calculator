package com.example.calculator.feature.presentation.component.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.example.calculator.databinding.CustomPopUpDialogBinding
import com.example.calculator.feature.domain.model.CalculationInfo
import com.example.calculator.feature.presentation.component.dialog.parent.CustomDialogFragmentParent

class CustomPopUpDialogFragment(
    private val calculationInfo: CalculationInfo
): CustomDialogFragmentParent() {

    private var _binding: CustomPopUpDialogBinding? = null
    private val binding get() = _binding!!

    private val builder by lazy { AlertDialog.Builder(requireActivity()) }
    private val dialog by lazy { builder.create() }

    @SuppressLint("UseGetLayoutInflater")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        _binding = CustomPopUpDialogBinding.inflate(LayoutInflater.from(context))

        builder.setView(binding.root)

        binding.cancelButton.setOnClickListener {
            dismiss()
        }

        binding.contentEditTextview.setText(calculationInfo.title)

        binding.navigationTextView.setOnClickListener {
            setFragmentResult("update_navigation", bundleOf("result" to calculationInfo))
            dismiss()
            Log.d("Argument", "$calculationInfo")
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)

        return dialog
    }

    override fun onStart() {
        super.onStart()
        // 実装メソッドを継承してオーバーライドしなければ以下のように呼び出せる
        setWidthPercent(80)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d("PopUpWindow", "PopUpWindow destroyed")
    }
}