package com.example.calculator.feature.presentation.component.motionlayout

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.MotionScene
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
    // このCustom MotionLayout 自身が，Listenerとなり，
    init {
        // MotionLayoutのListenerをここで追加する
        // Interface を実装した，クラスとメソッドをオーバーライドすることで独自の変更を実装できる
        // MotionLayout がトリガーされたときに，イベントを追加するためのリスナーをここで追加する
        // イベントが呼ばれたときに，イベントの通知を追加するためのリスナー
        addTransitionListener(object : MotionLayout.TransitionListener {

        })

        // MotionLayout のイベントが，通知されるリスナーをここで追加する
        // イベントをセットするためにリスナーをここで追加する
        // super である必要がないので，このままにしておくか
        setTransitionListener(object : MotionLayout.TransitionListener {

        })
    }

    // こっちは，下の処理に，listener を渡すだけだから大きな変更がないから，superで呼び出してんのかな?
    // こいつの実装は，配列にリスナーをぶち込むことだったから，ここでの処理は，下のメソッドに引数を渡すこと
    override fun setTransitionListener(listener: TransitionListener?) {

    }

    // 実質，こっちの処理の方法を変えているってことなのかな
    // List にイベントを追加することで，オーバーライドしてるんかな
    override fun addTransitionListener(listener: TransitionListener?) {

    }
}