package com.salo.pockettrachtenberg.practiceactivities

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.salo.pockettrachtenberg.R
import kotlinx.android.synthetic.main.activity_practice_seven.*
import kotlinx.android.synthetic.main.activity_practice_seven.id_num_textview
import kotlinx.android.synthetic.main.activity_practice_seven.id_number_digit_textview

class PracticeActivitySeven : AppCompatActivity() {

    private var digit = 2
    private var number = random(digit)
    private var multiplier = 7
    private var multiNumber = number?.toInt()?.times(multiplier)

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practice_seven)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

        id_num_textview.text = random(digit)

        checkButton()
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    private fun checkButton () {

        id_check_button.setOnClickListener {

            val view = R.id.activity_practice_seven_constraint_layout

            val answerString = id_check_answer_edittext.text.toString()
            digit = id_number_digit_textview.text.toString().toInt()

            if (answerString.isEmpty()) {
                val warningSnackbar = Snackbar.make(findViewById(view), "Please enter your answer", Snackbar.LENGTH_LONG)
                warningSnackbar.setTextColor(Color.WHITE)
                warningSnackbar.view.background = resources.getDrawable(R.drawable.round_corner_snackbar)
                warningSnackbar.show()
            }
            else {

                val answerInt = answerString.toInt()
                multiNumber = number?.toInt()?.times(multiplier)
                if (answerInt != multiNumber) {

                    val loseSnackbar = Snackbar.make(findViewById(view), "Upsi-dupsi. Answer is: $multiNumber", Snackbar.LENGTH_LONG)
                    loseSnackbar.view.background = resources.getDrawable(R.drawable.round_corner_snackbar)
                    loseSnackbar.show()
                }
                else if (answerInt == multiNumber) {

                }

                number = random(digit)
                id_num_textview.text = number
                id_check_answer_edittext.text.clear()
            }
        }
    }

    private fun random(digits: Int): String? {
        val min = 0
        val max = 10
        val randomizeNumber = StringBuilder()
        val digitArray = IntArray(digits)

        for (counter in 0 until digits) {

            if (counter == 0) {

                digitArray[counter] = (min + 1 until max).random()
            }
            else {

                digitArray[counter] = (min until max).random()
            }
        }

        for (i in 0 until digits) { randomizeNumber.append(digitArray[i]) }

        return randomizeNumber.toString()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}