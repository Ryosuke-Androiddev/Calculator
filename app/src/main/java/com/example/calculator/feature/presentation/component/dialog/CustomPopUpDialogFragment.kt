package com.example.calculator.feature.presentation.component.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.setFragmentResult
import com.example.calculator.R
import com.example.calculator.databinding.CustomPopUpDialogBinding
import com.example.calculator.feature.domain.model.CalculationInfo

class CustomPopUpDialogFragment(
    private val calculationInfo: CalculationInfo
): DialogFragment(R.layout.custom_pop_up_dialog) {

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
        setWidthPercent(80)
    }

    private fun DialogFragment.setWidthPercent(percentage: Int) {
        // percentage に変換する
        val percent = percentage.toFloat() / 100
        // 表示するリソースの取得
        val dm = Resources.getSystem().displayMetrics
        // ここでFragment の大きさを指定してる
        // widthPixels, heightPixels この2つのパラメータ
        // 上記の2つのパラメータをいじると、Fragmentのサイズが変更される
        // left, top で、画面左上の座標にプロットされ、
        // widthPixels, heightPixelsで、表示するFragmentの範囲を決定している
        // この場合画面いっぱいに広げている
        val rect = dm.run { Rect(0, 0, widthPixels, heightPixels) }
        // これで横幅をしてしてるんか
        val percentWidth = rect.width() * percent
        // で、PopUpWindowのサイズを、ここで定義しているだけ
        dialog?.window?.setLayout(percentWidth.toInt(), ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d("PopUpWindow", "PopUpWindow destroyed")
    }
}