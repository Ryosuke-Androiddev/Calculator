package com.example.calculator.feature.presentation.component.gesture

import android.annotation.SuppressLint
import android.view.MotionEvent
import android.view.View

class FingerGestureListener(
    private val listener: Listener
): View.OnTouchListener {

    private var startX: Float = 0f
    private var startY: Float = 0f
    private var endX: Float = 0f
    private var endY: Float = 0f

    interface Listener {
        fun onTouchScreen()
        fun onFlickToTop()
        fun onFlickToBottom()
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouch(view: View?, event: MotionEvent?): Boolean {

        when (event?.action) {
            MotionEvent.ACTION_DOWN -> touchDown(event)
            MotionEvent.ACTION_UP -> touchOff(event)
        }
        return true
    }

    private fun touchDown(event: MotionEvent) {
        startX = event.x
        startY = event.y
        listener.onTouchScreen()
    }

    private fun touchOff(event: MotionEvent) {
        endX = event.x
        endY = event.y
        when {
            upScope() -> listener.onFlickToTop()
            downScope() -> listener.onFlickToBottom()
        }
    }

    private fun upScope(): Boolean = endY < startY
    private fun downScope(): Boolean = startY < endY
}