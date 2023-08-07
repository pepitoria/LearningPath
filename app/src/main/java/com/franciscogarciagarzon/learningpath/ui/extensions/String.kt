package com.franciscogarciagarzon.learningpath.ui.extensions

import java.util.Locale

fun String.capitalizeLP() =
    replaceFirstChar { if (it.isLowerCase()) it.titlecase(locale = Locale.getDefault()) else it.toString() }