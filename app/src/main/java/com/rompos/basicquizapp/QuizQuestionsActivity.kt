package com.rompos.basicquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity() , View.OnClickListener{

    private var myCurrentPosition : Int = 1
    private var myQuestionList : ArrayList<Question>? = null
    private var mySelectedOptionPosition : Int = 0

    private var myUserName : String? = null
    private var myCorrectAnswers : Int = 0

    private var progressBar : ProgressBar? = null
    private var tvProgress : TextView? = null
    private var tvQuestion : TextView? = null
    private var ivImage : ImageView? = null

    private var tvOptionOne : TextView? = null
    private var tvOptionTwo : TextView? = null
    private var tvOptionThree : TextView? = null
    private var tvOptionFour : TextView? = null
    private var btnSubmit : Button? = null
    private var answered : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        myUserName = intent.getStringExtra(Constants.USER_NAME)//i get the information from mainActivity

        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)

        tvOptionOne = findViewById(R.id.tvOptionOne)
        tvOptionTwo = findViewById(R.id.tvOptionTwo)
        tvOptionThree = findViewById(R.id.tvOptionThree)
        tvOptionFour = findViewById(R.id.tvOptionFour)
        btnSubmit = findViewById(R.id.btnSubmit)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)


        myQuestionList = Constants.getQuestions()
        setQuestion()

    }

    private fun setQuestion() {
        defaultOptionView()
        answered= false
        val question: Question = myQuestionList!![myCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = myCurrentPosition
        tvProgress?.text = "$myCurrentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour
        if(myCurrentPosition == myQuestionList!!.size){
            btnSubmit?.text = "FINISH"
        }else{
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun defaultOptionView(){
        val options = ArrayList<TextView>()
        tvOptionOne?.let{
            options.add(0,it)
        }
        tvOptionTwo?.let{
            options.add(1,it)
        }
        tvOptionThree?.let{
            options.add(2,it)
        }
        tvOptionFour?.let{
            options.add(3,it)
        }

        for (option in options){
            //option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.corner2)
        }
    }

    //highlight the selected option that we choose and at the same time it will change the selection option number
    private fun selectedOptionView(tv : TextView, selectedOptionNum : Int){
        if(answered) {
            return
        }else{
            defaultOptionView()
            mySelectedOptionPosition = selectedOptionNum
            //tv.setTextColor(Color.parseColor("#363A43"))
            tv.background = ContextCompat.getDrawable(this, R.drawable.corner3)
            tv.setTypeface(tv.typeface, Typeface.BOLD)
        }
    }

    override fun onClick(view: View?) {

        when(view?.id){

                R.id.tvOptionOne -> {
                    tvOptionOne?.let {
                        selectedOptionView(it, 1)
                    }
                }
                R.id.tvOptionTwo -> {
                    tvOptionTwo?.let {
                        selectedOptionView(it, 2)
                    }
                }
                R.id.tvOptionThree -> {
                    tvOptionThree?.let {
                        selectedOptionView(it, 3)
                    }
                }
                R.id.tvOptionFour -> {
                    tvOptionFour?.let {
                        selectedOptionView(it, 4)
                    }
                }

            R.id.btnSubmit ->{
                if(mySelectedOptionPosition == 0){
                    myCurrentPosition++

                    when{
                        myCurrentPosition <= myQuestionList!!.size ->{
                            setQuestion()
                        }
                        else ->{
                            //Toast.makeText(this,"You made it to the end!!",Toast.LENGTH_LONG).show()
                            val intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME,myUserName)
                            intent.putExtra(Constants.CORRECT_ANSWER,myCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTION,myQuestionList?.size)
                            startActivity(intent)
                            finish()//in order to prevent the player from going back to the questions screen when clicking the back button
                        }
                    }
                }else{
                    val question = myQuestionList?.get(myCurrentPosition - 1)
                    if (question!!.correctAnswer != mySelectedOptionPosition) {
                        //if it is the wrong choice
                        answerView(mySelectedOptionPosition, R.drawable.wrong)
                    } else {
                        //if it is the correct choice
                        myCorrectAnswers++//counter for correct answers
                    }
                    //the correct answer will always be shown
                    answerView(question.correctAnswer, R.drawable.correct)

                    if (myCurrentPosition == myQuestionList!!.size) {
                        btnSubmit?.text = "Finish"
                    } else {
                        btnSubmit?.text = "GO TO NEXT QUESTION"
                    }
                    answered = true//Lock the question until next one
                    mySelectedOptionPosition = 0
                }
            }

        }
    }

    private fun answerView(answer : Int, drawableView : Int){
        when(answer){
            1 -> {
                tvOptionOne?.background = ContextCompat.getDrawable(this@QuizQuestionsActivity,drawableView)
            }
            2 -> {
                tvOptionTwo?.background = ContextCompat.getDrawable(this@QuizQuestionsActivity,drawableView)
            }
            3 -> {
                tvOptionThree?.background = ContextCompat.getDrawable(this@QuizQuestionsActivity,drawableView)
            }
            4 -> {
                tvOptionFour?.background = ContextCompat.getDrawable(this@QuizQuestionsActivity,drawableView)
            }
        }
    }
}