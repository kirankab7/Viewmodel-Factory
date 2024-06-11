package com.example.viewmodelfactory

import androidx.lifecycle.ViewModel

class MyViewModel(private val initialText: String) : ViewModel() {
    private var _text: String = initialText

    fun getText(): String {
        return _text
    }

    fun setText(newText: String) {
        _text = newText
    }
}