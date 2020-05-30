package com.salo.pockettrachtenberg

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("CAST_NEVER_SUCCEEDS")
class MainActivity : AppCompatActivity() {

    private var win = 0
    private var lose = 0
    private var digit = 2
    private var number = random(digit)
    private var multiplier = 0
    private var multiNumber = number?.toInt()?.times(multiplier)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        digitsButtons()
        val data = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
        val editData = data.edit()
        //                                                int is to small for this app
        id_win_textview.text = data.getString("WIN", "")
        id_lose_textview.text = data.getString("LOSE","")

        id_multiply11_switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                id_num_textview.text = number
                multiplier = 11

                id_multiply12_switch.isEnabled = false
                id_multiply6_switch.isEnabled = false

                checkButton(data, editData)
            }
            else {
                id_check_button.isEnabled = false
                id_multiply12_switch.isEnabled = true
                id_multiply6_switch.isEnabled = true

                id_num_textview.text = ""
            }
        }

        id_multiply12_switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                id_num_textview.text = number
                multiplier = 12

                id_multiply11_switch.isEnabled = false
                id_multiply6_switch.isEnabled = false

                checkButton(data, editData)
            }
            else {
                id_check_button.isEnabled = false
                id_multiply11_switch.isEnabled = true
                id_multiply6_switch.isEnabled = true

                id_num_textview.text = ""
            }
        }

        id_multiply6_switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                id_num_textview.text = number
                multiplier = 6

                id_multiply11_switch.isEnabled = false
                id_multiply12_switch.isEnabled = false

                checkButton(data, editData)
            }
            else {
                id_check_button.isEnabled = false
                id_multiply11_switch.isEnabled = true
                id_multiply12_switch.isEnabled = true

                id_num_textview.text = ""
            }
        }
    }

    private fun checkButton (data: SharedPreferences, editData: SharedPreferences.Editor) {

        id_check_button.isEnabled = true

        win = (data.getString("WIN", "")?.toInt() ?: "") as Int
        lose = (data.getString("LOSE", "")?.toInt() ?: "") as Int

        id_check_button.setOnClickListener {

            val answerString = id_check_answer_edittext.text.toString()
            digit = id_number_digit_textview.text.toString().toInt()

            if (answerString.isEmpty()) {

                Toast.makeText(this, "Please enter the answer", Toast.LENGTH_SHORT).show()
            }
            else {

                val answerInt = answerString.toInt()
                multiNumber = number?.toInt()?.times(multiplier)

                if (answerInt == multiNumber) {

                    win++
                    editData.putString("WIN", win.toString())
                    editData.apply()

                    id_win_textview.text = data.getString("WIN", "")
                    Toast.makeText(this, "Yeeepy", Toast.LENGTH_SHORT).show()
                }
                else if (answerInt != multiNumber) {

                    lose++
                    editData.putString("LOSE", lose.toString())
                    editData.apply()

                    id_lose_textview.text = data.getString("LOSE","")
                    Toast.makeText(this, "Upsi-dupsi. Answer is: $multiNumber", Toast.LENGTH_SHORT).show()
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

    private fun digitsButtons() {
        id_minus_digit_button.setOnClickListener {
            digit--
            id_number_digit_textview.text = digit.toString()
        }
        id_plus_digit_button.setOnClickListener {
            digit++
            id_number_digit_textview.text = digit.toString()
        }
    }
}
