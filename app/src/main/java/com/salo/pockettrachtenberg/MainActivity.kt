package com.salo.pockettrachtenberg

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationCompat.VISIBILITY_PUBLIC
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("CAST_NEVER_SUCCEEDS")
class MainActivity : AppCompatActivity() {

    private var win: Int
        get() { return data.getInt("WIN", 0) }
        set(value) {
            editData.putInt("WIN", value)
            editData.apply()
        }

    private var lose: Int
        get() { return data.getInt("LOSE", 0) }
        set(value) {
            editData.putInt("LOSE", value)
            editData.apply()
        }

    private var digit = 2
    private var number = random(digit)
    private var multiplier = 0
    private var multiNumber = number?.toInt()?.times(multiplier)
    private var channelID = "notification"
    private val practiceNotificationID = 3
    lateinit var data: SharedPreferences
    lateinit var editData: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        createNotificationChanell()
        setContentView(R.layout.activity_main)
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        setSupportActionBar(findViewById(R.id.toolbar))
        digitsButtons()
        data = getSharedPreferences("SP_INFO", Context.MODE_PRIVATE)
        editData = data.edit()
        //                                                int is to small for this app
        id_win_textview.text = win.toString()
        id_lose_textview.text = lose.toString()

//        createNotification()

        id_multiply11_switch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                id_num_textview.text = number
                multiplier = 11

                id_multiply12_switch.isEnabled = false
                id_multiply6_switch.isEnabled = false

                checkButton()
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

                checkButton()
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

                checkButton()
            }
            else {
                id_check_button.isEnabled = false
                id_multiply11_switch.isEnabled = true
                id_multiply12_switch.isEnabled = true

                id_num_textview.text = ""
            }
        }

    }

    private fun createNotification() {

        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)

        val builderNotification = NotificationCompat.Builder(this, channelID)
            .setSmallIcon(R.mipmap.app_icon)
            .setContentTitle("Trachtenberg in your pocket")
            .setContentText("Let's practise")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setVisibility(VISIBILITY_PUBLIC)

        with (NotificationManagerCompat.from(this)) {
            notify(practiceNotificationID, builderNotification.build())
        }
    }

    private fun createNotificationChanell() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val name = "notificationChanell"
            val descriptionText = "Chanell for notifications"
            val importance = NotificationManager.IMPORTANCE_HIGH
            val chanell = NotificationChannel(channelID, name, importance).apply {
                description = descriptionText
            }

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(chanell)
        }
    }

    private fun checkButton () {

        id_check_button.isEnabled = true

        id_check_button.setOnClickListener {

            val view = R.id.main_constraint_layout

            val answerString = id_check_answer_edittext.text.toString()
            digit = id_number_digit_textview.text.toString().toInt()

            if (answerString.isEmpty()) {
                val warningSnackbar = Snackbar.make(findViewById(R.id.main_constraint_layout), "Please enter your answer", Snackbar.LENGTH_LONG)
                warningSnackbar.view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrettyRed))
                warningSnackbar.show()
            }
            else {

                val answerInt = answerString.toInt()
                multiNumber = number?.toInt()?.times(multiplier)

                if (answerInt == multiNumber) {

                    win++

                    val winSnackbar = Snackbar.make(findViewById(R.id.main_constraint_layout), "Yeeepy", Snackbar.LENGTH_SHORT)
                    winSnackbar.view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorBestGreen))
                    winSnackbar.show()
                }
                else if (answerInt != multiNumber) {

                    lose++

                    val loseSnackbar = Snackbar.make(findViewById(R.id.main_constraint_layout), "Upsi-dupsi. Answer is: $multiNumber", Snackbar.LENGTH_LONG)
                    loseSnackbar.view.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrettyRed))
                    loseSnackbar.show()
                }

                number = random(digit)
                id_num_textview.text = number
                id_check_answer_edittext.text.clear()

                id_win_textview.text = win.toString()
                id_lose_textview.text = lose.toString()
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
