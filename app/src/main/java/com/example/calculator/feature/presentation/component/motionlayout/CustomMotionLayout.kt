package com.example.calculator.feature.presentation.component.motionlayout

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import com.example.calculator.R

class CustomMotionLayout(
    context: Context,
    attributeSet: AttributeSet? = null
): MotionLayout(context, attributeSet) {

    // attributes → XMLから，必要なAttributesを取得することができる
    // MotionLayout を行いたい領域をインフレートする
    // ConstraintLayout or NestedScrollView → MotionLayout を適用できるのは前者
    private val viewToDetectedTouch by lazy {
        // <View> 型として定義する
        findViewById<View>(R.id.formula_input_container)
    }

    // 全画面を対象にするための処理
    private val viewRect = Rect()
    // 画面をタッチしたのかそうでないのかを考慮するトリガーキー
    private var hasTouchStarted = false;
    // MotionLayoutのリスナーをここでリストとして管理する
    private val transitionListenerList = mutableListOf<TransitionListener?>()

    // 初期化処理を行う
    init {
        // MotionLayoutのListenerをここで追加する
        // Interface を実装した，クラスとメソッドをオーバーライドすることで独自の変更を実装できる
        addTransitionListener(object : MotionLayout.TransitionListener {

        })

        super.setTransitionListener(object : MotionLayout.TransitionListener {

        })
    }
}