package com.example.myapplicationcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.widget.AutoCompleteTextView
import android.widget.TextView

class MainActivity() : AppCompatActivity(), Parcelable {

    private lateinit var resultTextView: TextView
    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.resultTextView)

    }

    fun numberClick(clickedView: View) {
        if (clickedView is TextView) {
            var result = resultTextView.text.toString()
            var number = clickedView.text.toString()

            resultTextView.text = result + number

        }
        fun operationClick() {
            if (clickedView is TextView) {
                var result = resultTextView.text.toString()
                if (result.isNotEmpty()) {
                    operand = result.toDouble()
                }
                operation = clickedView.text.toString()
                resultTextView.text = ""
            }
        }

        fun equalsClick(clickedView: View) {
            val sec0operandText = resultTextView.text.toString()
            var sec0operand: Double = 0.0
            if (sec0operandText.isNotEmpty())
                sec0operand = sec0operandText.toDouble()
            when (operation) {
                "+" -> resultTextView.text = (operand + sec0operand).toString()
                "-" -> resultTextView.text = (operand - sec0operand).toString()
                "*" -> resultTextView.text = (operand * sec0operand).toString()
                "/" -> resultTextView.text = (operand / sec0operand).toString()

            }
        }
    }
}

