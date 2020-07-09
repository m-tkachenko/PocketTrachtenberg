package com.salo.pockettrachtenberg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_multiply.*
import kotlinx.android.synthetic.main.bottom_sheet.*

class MultiplyActivity : AppCompatActivity() {

    private lateinit var sheetBehavior: BottomSheetBehavior<ConstraintLayout>
    public var mNumberForLearnOrPracticeActivity = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_multiply)
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)

        sheetBehavior = BottomSheetBehavior.from(bottom_sheet)
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)

        buttonsNumbers()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }

    private fun buttonsNumbers() {
        id_multiply11_button.setOnClickListener {
            mNumberForLearnOrPracticeActivity = 11
            if(sheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
            else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)
            }
        }

        id_multiply12_button.setOnClickListener {
            mNumberForLearnOrPracticeActivity = 12
            if(sheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
            else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)
            }
        }

        id_multiply6_button.setOnClickListener {
            mNumberForLearnOrPracticeActivity = 6
            if(sheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
            else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)
            }
        }

        id_multiply7_button.setOnClickListener {
            mNumberForLearnOrPracticeActivity = 7
            if(sheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
            else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)
            }
        }

        id_multiply5_button.setOnClickListener {
            mNumberForLearnOrPracticeActivity = 5
            if(sheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
            else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)
            }
        }

        id_multiply9_button.setOnClickListener {
            mNumberForLearnOrPracticeActivity = 9
            if(sheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
            else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)
            }
        }

        id_multiply8_button.setOnClickListener {
            mNumberForLearnOrPracticeActivity = 8
            if(sheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
            else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)
            }
        }

        id_multiply4_button.setOnClickListener {
            mNumberForLearnOrPracticeActivity = 4
            if(sheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
            else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)
            }
        }

        id_multiply3_button.setOnClickListener {
            mNumberForLearnOrPracticeActivity = 3
            if(sheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
            else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)
            }
        }

        id_multiply2_button.setOnClickListener {
            mNumberForLearnOrPracticeActivity = 2
            if(sheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
            else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)
            }
        }

        id_multiply1_button.setOnClickListener {
            mNumberForLearnOrPracticeActivity = 1
            if(sheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED)
            }
            else {
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN)
            }
        }
    }
}