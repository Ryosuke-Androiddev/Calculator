package com.example.calculator.feature.presentation.component.motionlayout

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.util.Log
import android.view.GestureDetector
import android.view.MotionEvent
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
    private var touchStarted = false;
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

            // Transition が始まった時点で呼び出される
            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {
                // Event の追加をするリスナーなので，具体的な処理はここで記述しない
            }

            // 指の位置? が移動したときに呼び出される
            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
                // Event の追加をするリスナーなので，具体的な処理はここで記述しない
            }

            // MotionLayout が完了した時点で呼び出される処理
            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                // Event の追加をするリスナーなので，具体的な処理はここで記述しない
            }

            // MotionLayoutが呼び出されるときに呼ばれる処理
            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {
                // Event の追加をするリスナーなので，具体的な処理はここで記述しない
            }

        })

        // MotionLayout のイベントが，通知されるリスナーをここで追加する
        // イベントをセットするためにリスナーをここで追加する
        // super である必要がないので，このままにしておくか
        setTransitionListener(object : MotionLayout.TransitionListener {

            override fun onTransitionStarted(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int
            ) {
            }

            override fun onTransitionChange(
                motionLayout: MotionLayout?,
                startId: Int,
                endId: Int,
                progress: Float
            ) {
                transitionListenerList.filterNotNull()
                    .forEach { transitionListener ->
                        transitionListener.onTransitionChange(motionLayout, startId, endId, progress)
                    }
            }

            // 処理が完了したときに呼び出される
            override fun onTransitionCompleted(motionLayout: MotionLayout?, currentId: Int) {
                transitionListenerList.filterNotNull()
                    .forEach { transitionListener ->
                        transitionListener.onTransitionCompleted(motionLayout, currentId)
                    }
            }

            override fun onTransitionTrigger(
                motionLayout: MotionLayout?,
                triggerId: Int,
                positive: Boolean,
                progress: Float
            ) {
            }

        })
    }

    // こっちは，下の処理に，listener を渡すだけだから大きな変更がないから，superで呼び出してんのかな?
    // こいつの実装は，配列にリスナーをぶち込むことだったから，ここでの処理は，下のメソッドに引数を渡すこと
    override fun setTransitionListener(listener: TransitionListener?) {
        addTransitionListener(listener)
    }

    // 実質，こっちの処理の方法を変えているってことなのかな
    // List にイベントを追加することで，オーバーライドしてるんかな
    override fun addTransitionListener(listener: TransitionListener?) {
        transitionListenerList += listener;
    }

    // listener のinterface → object に変換する処理(引数)は、interface だと不要な処理まで記述が必要になる
    // それを避けるためにここではクラスをインスタンス化している
    private val gestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {

        override fun onScroll(
            e1: MotionEvent?,
            e2: MotionEvent?,
            distanceX: Float,
            distanceY: Float
        ): Boolean {
            // この処理をどうするのか
            // y軸のスクロール量として，distanceY が計算を行ってくれる
            if (distanceY < 0) {
                transitionToStart()
            } else {
                transitionToEnd()
            }

            // false を返す理由とは??
            // それぞれ別のメソッドを呼び出しているから??
            return false;
        }
    })

    // onTouch で処理を決めてもいいが、GestureDetector で、処理をまとめてからそれを呼び出す
    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {

        // ここでEvent を渡すことでここで細かい処理を記述する必要がなくなる
        gestureDetector.onTouchEvent(event)

        // null の可能性を秘めているのでその処理を忘れない
        when (event?.actionMasked) {
            MotionEvent.ACTION_UP, MotionEvent.ACTION_CANCEL -> {
                // これは指が離れたり処理がキャンセルされたときに行われる処理
                touchStarted = false
                return super.onTouchEvent(event)
            }
            else -> {
                Log.d("MotionEvent", "MotionEvent is ${event == null}")
            }
        }
        if (!touchStarted) {

            // このままだと全画面が操作の対象になってしまう
            viewToDetectedTouch.getHitRect(viewRect)
            if (event != null) {
                touchStarted = viewRect.contains(event.x.toInt(), event.y.toInt())
            }
        }

        return touchStarted && super.onTouchEvent(event)
    }
}