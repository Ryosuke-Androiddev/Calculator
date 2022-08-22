package com.example.calculator.feature.presentation.component.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import com.example.calculator.databinding.DeletePopUpDialogFragmentBinding
import com.example.calculator.feature.domain.model.CalculationInfo
import com.example.calculator.feature.presentation.component.dialog.parent.CustomDialogFragmentParent
import com.example.calculator.feature.presentation.ui.list.viewmodel.ListViewModel

class DeletePopUpDialogFragment(
    private val calculationInfo: CalculationInfo
) : CustomDialogFragmentParent() {

    private var _binding : DeletePopUpDialogFragmentBinding? = null
    private val binding get() = _binding!!

    private val builder by lazy { AlertDialog.Builder(requireActivity()) }
    private val dialog by lazy { builder.create() }
    private lateinit var listener: DeletePopUpDialogListener

    interface DeletePopUpDialogListener {
        fun setOnDeleteClick(dialog: DeletePopUpDialogFragment, calculationInfo: CalculationInfo)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        _binding = DeletePopUpDialogFragmentBinding.inflate(LayoutInflater.from(context))
        builder.setView(binding.root)

        super.onCreateDialog(savedInstanceState)

        binding.deleteTextButton.setOnClickListener {
            listener.setOnDeleteClick(this, calculationInfo = calculationInfo)
        }

        binding.deleteDialogCancelTextButton.setOnClickListener {
            dismiss()
        }

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)

        return dialog
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            // 呼び出し元を親Fragmentから取得する
            listener = parentFragment as DeletePopUpDialogListener
        } catch (e : ClassCastException) {
            throw ClassCastException(context.toString() + "must Implement Interface")
        }
    }

    override fun onStart() {
        super.onStart()

        setWidthPercent(90)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}