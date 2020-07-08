package com.salo.pockettrachtenberg

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_methods.*

class MethodsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_methods)

        id_cardview_material_plus.setOnClickListener{
            startActivity(Intent(this, PlusLearnActivity::class.java))
        }

        id_cardview_material_multiply.setOnClickListener {
            startActivity(Intent(this, MultiplyLearnActivity::class.java))
        }

        id_cardview_material_devide.setOnClickListener {
            startActivity(Intent(this, DevideLearnActivity::class.java))
        }

        id_cardview_material_squaring.setOnClickListener {
            startActivity(Intent(this, SquaringLearnActivity::class.java))
        }
    }
}