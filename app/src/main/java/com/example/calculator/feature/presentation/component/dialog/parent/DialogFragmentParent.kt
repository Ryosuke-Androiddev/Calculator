package com.example.calculator.feature.presentation.component.dialog.parent

import android.content.res.Resources
import android.graphics.Rect
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

open class DialogFragmentParent: DialogFragment() {

    open fun DialogFragment.setWidthPercent(percentage: Int) {
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
}