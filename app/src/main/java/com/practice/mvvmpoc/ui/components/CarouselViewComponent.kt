package com.practice.mvvmpoc.ui.components

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.widget.ImageView

class CarouselViewComponent @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr) {

    var defaultColor=Color.GREEN

}