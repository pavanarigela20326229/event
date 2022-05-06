package com.example.eventsdemo.customclass

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.eventsdemo.R
import com.example.eventsdemo.utils.gone
import com.example.eventsdemo.utils.visible


class CustomToolbar(context: Context, attrs: AttributeSet) :
    ConstraintLayout(context, attrs) {
    init {
        init(context, attrs)

    }

    private fun init(context: Context, attrs: AttributeSet) {
        val view: View = LayoutInflater.from(context).inflate(R.layout.common_toolbar, this, true)
        val ivBackIcon: ImageView = view.findViewById(R.id.ivBack)
        val tvTitle: AppCompatTextView = view.findViewById(R.id.tvTitle)
        val typeArray = context.obtainStyledAttributes(attrs, R.styleable.toolbar)
        val isShowBackButton = typeArray.getBoolean(R.styleable.toolbar_showBackbutton, false)
        val isShowTitle = typeArray.getBoolean(R.styleable.toolbar_showTitle, true)
        val title = typeArray.getString(R.styleable.toolbar_title)
        if (isShowBackButton) {
            ivBackIcon.visible()
        } else {
            ivBackIcon.gone()
        }
        if (isShowTitle) {
            tvTitle.visible()
        } else {
            tvTitle.gone()
        }

        tvTitle.text = title


    }
}