package br.com.lucasmorinigo.calculaflex.extensions

fun Double.format(digits: Int) = String.format("%.${digits}f", this)