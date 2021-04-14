package com.example.aboutmeapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import com.example.aboutmeapp.databinding.ActivityMainLayoutBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainLayoutBinding
    private val myName:MyName= MyName(name = "cagdas")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main_layout)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main_layout)
        binding.myName=myName
       /* findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickName(it)
        }*/
        binding.doneButton.setOnClickListener {
            addNickName(it)
        }
    }
    private fun addNickName(view: View){
       // val editText = findViewById<EditText>(R.id.editTextTextPersonName)
      //  val nickNameTextView = findViewById<TextView>(R.id.done_text)
binding.apply {
    invalidateAll()
    doneText.text=binding.editTextTextPersonName.text
    myName?.nickname=editTextTextPersonName.text.toString()
    editTextTextPersonName.visibility=View.GONE
    view.visibility=View.GONE
    doneText.visibility=View.VISIBLE
}

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}