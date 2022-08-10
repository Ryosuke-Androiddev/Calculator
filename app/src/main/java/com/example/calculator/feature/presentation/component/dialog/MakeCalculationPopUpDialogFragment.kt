package com.example.calculator.feature.presentation.component.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.calculator.databinding.MakeCalculationPopUpDialogBinding
import com.example.calculator.feature.domain.model.CalculationInfo
import com.example.calculator.feature.presentation.component.dialog.parent.CustomDialogFragmentParent

class MakeCalculationPopUpDialogFragment(
    // TODO UseCaseの呼び出し
): CustomDialogFragmentParent() {

    private var _binding: MakeCalculationPopUpDialogBinding? = null
    private val binding get() = _binding!!

    private val builder by lazy { AlertDialog.Builder(requireActivity()) }
    private val dialog by lazy { builder.create() }

    @SuppressLint("UseGetLayoutInflater")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        _binding = MakeCalculationPopUpDialogBinding.inflate(LayoutInflater.from(requireContext()))

        builder.setView(binding.root)

        binding.saveTextButton.setOnClickListener {
            // ここの内容を画面遷移したときに表示する??
            // DBのテーブル結語で乗りきれいないよね??
            // SafeArgs or Bundleで渡してあげる必要がある
            val title = binding.calculationTitleTextview.text
            if (title.isNullOrEmpty()) {
                // ここの内容を差し替えて、UseCaseに渡す
                Toast.makeText(requireContext(), "Hello world", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Please input 0 more characters", Toast.LENGTH_SHORT).show()
            }
        }

        binding.cancelTextButton.setOnClickListener {
            dismiss()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)

        return dialog
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