package com.example.eventsdemo.core

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.eventsdemo.R


abstract class BaseActivity<T : ViewDataBinding>  : AppCompatActivity() {

    lateinit var dialog: Dialog
    lateinit var binding: T



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getLayout())
        initView()
    }

    abstract fun getLayout(): Int
    abstract fun  initView()


    fun showDialog(isShown: Boolean) {
        if (!this::dialog.isInitialized) {
            val builder = android.app.AlertDialog.Builder(this)
            builder.setView(R.layout.progress)
            dialog = builder.create()
            dialog.setCancelable(false)
            if (isShown) dialog.show() else dialog.dismiss()
        } else {
            if (isShown) dialog.show() else dialog.dismiss()
        }


    }


}