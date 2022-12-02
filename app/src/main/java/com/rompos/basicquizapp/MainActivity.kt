package com.rompos.basicquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {

    private var etName : AppCompatEditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnStart : Button = findViewById(R.id.btnStart)
        etName  = findViewById(R.id.etName)

        btnStart.setOnClickListener {
            if (etName?.text.isNullOrBlank()) {
                Toast.makeText(this,"Please enter your name to continue",Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this,QuizQuestionsActivity::class.java) //we create the intent to travel to the next page
                intent.putExtra(Constants.USER_NAME,etName?.text.toString())
                startActivity(intent)//we execute the intent activity which takes us to the next page
                finish()//we are closing the first page so that is not open in the memory in which case we exit the app
            }
        }
    }
}