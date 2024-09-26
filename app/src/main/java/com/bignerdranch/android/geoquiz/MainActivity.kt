package com.bignerdranch.android.geoquiz

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        trueButton.setOnClickListener { view: View ->

            val snackbar = Snackbar.make(view, R.string.correct_toast, Snackbar.LENGTH_SHORT)
            val snackbarView = snackbar.view
            val params = snackbarView.layoutParams as CoordinatorLayout.LayoutParams
            params.gravity = Gravity.TOP // 设置为顶部
            snackbarView.layoutParams = params
            snackbar.show()
        }
        falseButton.setOnClickListener { view: View ->
            val snackbar = Snackbar.make(view, R.string.correct_toast, Snackbar.LENGTH_SHORT)
            val snackbarView = snackbar.view
            val params = snackbarView.layoutParams as CoordinatorLayout.LayoutParams
            params.gravity = Gravity.TOP // 设置为顶部
            snackbarView.layoutParams = params
            snackbar.show()

        }

    }

}