package com.salo.pockettrachtenberg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_multiply_learn.*
import kotlinx.android.synthetic.main.bottom_sheet.*

class MultiplyLearnActivity : AppCompatActivity() {

    private lateinit var sheetBehavior: BottomSheetBehavior<ConstraintLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiply_learn)

        sheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)

        id_multiply6_button.setOnClickListener {
            if(sheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
            else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)
            }
        }
    }
}