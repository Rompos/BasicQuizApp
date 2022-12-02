package com.rompos.basicquizapp

//Here i store the user name , the amount of questions , the correct answer ect..

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTION : String = "total_questions"
    const val CORRECT_ANSWER : String = "correct_answers"

    // i can always get the questions from xml file or a json file or another resource
    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,//internally will be threaded as an integer
            "Belgium",
            "Greece",
            "Romania",
            "Germany",
            1,
        )
        questionsList.add(que1)

        val que2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_australia,//internally will be threaded as an integer
            "New Zealand",
            "Denmark",
            "Kuwait",
            "Australia",
            4,
            )
        questionsList.add(que2)

        val que3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,//internally will be threaded as an integer
            "India",
            "Denmark",
            "Kuwait",
            "Australia",
            2,
        )
        questionsList.add(que3)

        val que4 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,//internally will be threaded as an integer
            "Brazil",
            "Argentina",
            "Fiji",
            "Greece",
            3,
        )
        questionsList.add(que4)

        val que5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,//internally will be threaded as an integer
            "Poland",
            "Germany",
            "Australia",
            "New Zealand",
            4,
        )
        questionsList.add(que5)

        val que6 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,//internally will be threaded as an integer
            "France",
            "Italy",
            "Spain",
            "Kuwait",
            4,
        )
        questionsList.add(que6)

        val que7 = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_india,//internally will be threaded as an integer
            "India",
            "Belgium",
            "Argentina",
            "New Zealand",
            1,
        )
        questionsList.add(que7)

        val que8 = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_germany,//internally will be threaded as an integer
            "Greece",
            "Germany",
            "India",
            "Belgium",
            2,
        )
        questionsList.add(que8)

        val que9 = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,//internally will be threaded as an integer
            "Tokyo",
            "England",
            "Brazil",
            "USA",
            3,
        )
        questionsList.add(que9)

        return questionsList
    }

}