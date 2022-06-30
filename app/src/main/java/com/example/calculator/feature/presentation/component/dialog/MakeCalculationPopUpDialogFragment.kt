package com.example.calculator.feature.presentation.component.dialog

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.res.Resources
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.calculator.databinding.MakeCalculationPopUpDialogBinding

class MakeCalculationPopUpDialogFragment(
    // TODO UseCaseの呼び出し
): DialogFragment() {

    private var _binding: MakeCalculationPopUpDialogBinding? = null
    private val binding get() = _binding!!

    private val builder by lazy { AlertDialog.Builder(requireActivity()) }
    private val dialog by lazy { builder.create() }

    @SuppressLint("UseGetLayoutInflater")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        _binding = MakeCalculationPopUpDialogBinding.inflate(LayoutInflater.from(requireContext()))

        builder.setView(binding.root)

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
    }
}