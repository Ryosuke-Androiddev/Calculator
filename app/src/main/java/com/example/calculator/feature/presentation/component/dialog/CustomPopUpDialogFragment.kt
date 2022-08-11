package com.example.calculator.feature.presentation.component.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.Toast
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

    private lateinit var listener : CustomPopUpDialogListener

    interface CustomPopUpDialogListener {
        fun onCustomPopUpDialogSaveButtonClick(newTitle : String, dialog : CustomPopUpDialogFragment)
    }

    @SuppressLint("UseGetLayoutInflater")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        _binding = CustomPopUpDialogBinding.inflate(LayoutInflater.from(context))

        builder.setView(binding.root)

        binding.saveButton.setOnClickListener {
            // UPDATE UseCaseをここで呼び出す
            // 1つdata class で呼び出すから(DIする)
            // 引数あるような変更の時にこれって弱くない?
            // 普通にここで処理が完結するように書けばええんか

            val newTitle = binding.contentEditTextview.text.toString()
            if (newTitle.isEmpty() || newTitle.isBlank()) {
                // 0文字以上の指定をここで
                Toast.makeText(requireContext(), "Please input 0 more characters", Toast.LENGTH_SHORT).show()
            } else {
                listener.onCustomPopUpDialogSaveButtonClick(newTitle = newTitle, this)
            }
        }

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

    // Interface が実装されてないと例外が投げられる
    // これActivityにやってるかを確認してる、Fragmentでやられているかを確認する必要がある
    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            // 呼び出し元を親Fragmentから取得する
            listener = parentFragment as CustomPopUpDialogListener
        } catch (e : ClassCastException) {
            throw ClassCastException(context.toString() + "must Implement Interface")
        }
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