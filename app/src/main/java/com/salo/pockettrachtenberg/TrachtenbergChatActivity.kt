package com.salo.pockettrachtenberg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import kotlinx.android.synthetic.main.activity_trachtenberg.*

class TrachtenbergChatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trachtenberg)
        id_trachtenberg_chat_button_exit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

            overridePendingTransition(R.anim.slide_out_down, R.anim.slide_in_down)
        }
    }
}