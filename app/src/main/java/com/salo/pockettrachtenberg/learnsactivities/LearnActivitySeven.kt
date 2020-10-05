package com.salo.pockettrachtenberg.learnsactivities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.salo.pockettrachtenberg.R

class LearnActivitySeven : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_learn_seven)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}