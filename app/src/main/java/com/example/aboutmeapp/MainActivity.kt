package com.example.aboutmeapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_layout)
        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickName(it)
        }
    }
    private fun addNickName(view: View){
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val nickNameTextView = findViewById<TextView>(R.id.done_text)

        nickNameTextView.text=editText.text
        editText.visibility=View.GONE
        view.visibility=View.GONE
        nickNameTextView.visibility=View.VISIBLE
        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}