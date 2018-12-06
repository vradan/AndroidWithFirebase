package br.com.lucasmorinigo.calculaflex.extensions

import android.widget.EditText

fun EditText.getValue() = this.text.toString()

fun EditText.getDouble() = this.getValue().toDouble()