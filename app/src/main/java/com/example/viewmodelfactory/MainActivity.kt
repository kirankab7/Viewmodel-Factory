package com.example.viewmodelfactory

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var myViewModel: MyViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Reference to the TextView and Button from the layout
        val textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button)

        // Create the ViewModel using the factory
        val factory = MyViewModelFactory("Initial text")
        myViewModel = ViewModelProvider(this, factory).get(MyViewModel::class.java)

        // Set the initial text from ViewModel
        textView.text = myViewModel.getText()

        // Set an onClickListener to the button to update the ViewModel
        button.setOnClickListener {
            // Update the text in the ViewModel
            myViewModel.setText("Hello, ViewModel with Factory!")
            // Reflect the updated text in the TextView
            textView.text = myViewModel.getText()
        }
    }
}