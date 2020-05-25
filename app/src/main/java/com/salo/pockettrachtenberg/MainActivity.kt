package com.salo.pockettrachtenberg

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // int is to small for this app

        var win = 0
        var lose = 0
        var digit = id_digits_textview.text.toString().toInt()
        var number = random(digit)
        var multiNumber = number?.toInt()?.times(12)

        id_num_textview.text = number

        var answerString: String
        var answerInt: Int

        id_check_button.setOnClickListener {

            answerString = id_check_answer_edittext.text.toString()
            digit = id_digits_textview.text.toString().toInt()

            if (answerString.isEmpty()) {

                Toast.makeText(this, "Please enter the answer", Toast.LENGTH_SHORT).show()
            }
            else {

                answerInt = answerString.toInt()
                multiNumber = number?.toInt()?.times(12)

                if (answerInt == multiNumber) {

                    win++
                    id_win_textview.text = win.toString()
                    Toast.makeText(this, "Yeeepy", Toast.LENGTH_SHORT).show()
                }
                else if (answerInt != multiNumber) {

                    lose++
                    id_lose_textview.text = lose.toString()
                    Toast.makeText(this, "Upsi-dupsi. Answer is: $multiNumber", Toast.LENGTH_SHORT).show()
                }

                number = random(digit)
                id_num_textview.text = number
                id_check_answer_edittext.text.clear()
            }
        }

        id_minus_digit_button.setOnClickListener {
            digit--
            id_digits_textview.text = digit.toString()
        }
        id_plus_digit_button.setOnClickListener {
            digit++
            id_digits_textview.text = digit.toString()
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
}
