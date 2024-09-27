package com.bignerdranch.android.geoquiz

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var questionTextView: TextView
    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))
    private var isAnswer = BooleanArray(questionBank.size) { false }

    private var currentIndex = 0
    private var count = 0
    private var right = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate(Bundle?) called")
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.question_text_view)


        trueButton.setOnClickListener {
            if(!isAnswer[currentIndex]) {
                isAnswer[currentIndex]=true
                checkAnswer(true)
                trueButton.isEnabled=false
                falseButton.isEnabled=false
            }


        }
        falseButton.setOnClickListener {
            if(!isAnswer[currentIndex]) {
                isAnswer[currentIndex]=true
                checkAnswer(false)
                trueButton.isEnabled=false
                falseButton.isEnabled=false
            }

        }
        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            if(isAnswer[currentIndex]) {
                trueButton.isEnabled=false
                falseButton.isEnabled=false
            }
            else{
                trueButton.isEnabled=true
                falseButton.isEnabled=true
            }
            updateQuestion()
        }
        updateQuestion()
    }
    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }
    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer
        count++
        var messageResId = 0
        if (userAnswer == correctAnswer) {
            messageResId=R.string.correct_toast
            right++
        } else {
            messageResId=R.string.incorrect_toast
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
            .show()
        if(count==questionBank.size){
            val percentage = (right.toDouble() / count * 100).toInt()  // 计算正确率，转换为整数
            val resultMessage = "You got $right out of $count questions correct ($percentage%)."
            // 显示正确率结果
            Toast.makeText(this, resultMessage, Toast.LENGTH_LONG).show()
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }
    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }
    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }
    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }

}