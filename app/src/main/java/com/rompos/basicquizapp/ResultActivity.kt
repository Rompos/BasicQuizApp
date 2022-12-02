package com.rompos.basicquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    private var tvName : TextView? = null
    private var tvScore : TextView? = null
    private var btnFinish : Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        tvName = findViewById(R.id.tvName)
        tvScore = findViewById(R.id.tvScore)
        btnFinish = findViewById(R.id.btnFinish)

        tvName?.text = intent?.getStringExtra(Constants.USER_NAME)

        //because it is getIntExtra we need a default value
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTION,0)
        ////the same as above but if we have misspelled the String total_questions the app will crush
        //val totalQuestions = intent.getIntExtra("total_questions",0)

        //because it is getIntExtra we need a default value
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWER,0)
        ////the same as above but if we have misspelled the String correct_answers the app will crush
        //val correctAnswers = intent.getIntExtra("correct_answers",0)

        tvScore?.text = "Your Score is $correctAnswers out of $totalQuestions "

        btnFinish?.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }


    }
}