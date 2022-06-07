package com.example.calculator.feature.presentation.util

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.motion.widget.MotionLayout
import com.google.android.material.appbar.AppBarLayout

class CollapsibleToolbar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : MotionLayout(context, attrs, defStyleAttr), AppBarLayout.OnOffsetChangedListener {

    // オフセットの変更をここで行う
    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        progress = -verticalOffset / appBarLayout?.totalScrollRange?.toFloat()!!
    }

    // AppBar を親ビューにしてオフセットの変更リスナーをこいつに指定するのか
    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        (parent as? AppBarLayout)?.addOnOffsetChangedListener(this)
    }
}