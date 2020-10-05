package com.salo.pockettrachtenberg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SquaringLearnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_squaring_learn)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}