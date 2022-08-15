package com.example.calculator.feature.presentation.component.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import com.example.calculator.databinding.DeletePopUpDialogFragmentBinding
import com.example.calculator.feature.presentation.component.dialog.parent.CustomDialogFragmentParent

class DeletePopUpDialogFragment : CustomDialogFragmentParent() {

    private var _binding : DeletePopUpDialogFragmentBinding? = null
    private val binding get() = _binding!!

    private val builder by lazy { AlertDialog.Builder(requireActivity()) }
    private val dialog by lazy { builder.create() }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        _binding = DeletePopUpDialogFragmentBinding.inflate(LayoutInflater.from(context))
        builder.setView(binding.root)

        super.onCreateDialog(savedInstanceState)

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)

        return dialog
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