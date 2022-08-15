package com.example.calculator.feature.presentation.component.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import com.example.calculator.feature.presentation.component.dialog.parent.CustomDialogFragmentParent

class DeletePopUpDialogFragment : CustomDialogFragmentParent() {

    private val builder by lazy { AlertDialog.Builder(requireActivity()) }
    private val dialog by lazy { builder.create() }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        super.onCreateDialog(savedInstanceState)

        builder.setPositiveButton("Yes") { _, _ ->

        }
        builder.setNegativeButton("No") { _, _ ->

        }
        builder.setTitle("Delete Calculation")
        builder.setMessage("Do you want to delete Calculation??")

        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.GRAY))
        dialog.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)

        return dialog
    }
}