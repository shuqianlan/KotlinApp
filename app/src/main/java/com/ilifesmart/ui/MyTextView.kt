package com.ilifesmart.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

class MyTextView: View {
    val TAG = "MyTextView"

    lateinit var textPaint:TextPaint

    constructor(context: Context?) : this(context, null)

    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initialize()
    }

    fun initialize() {
        textPaint = TextPaint(Paint.ANTI_ALIAS_FLAG)
        textPaint.color = Color.BLACK
        textPaint.textSize = 48f
        textPaint.textAlign = Paint.Align.CENTER
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (canvas != null) {
            canvas.drawText(TAG, width/2f, height/2f, textPaint)
        }
    }
}