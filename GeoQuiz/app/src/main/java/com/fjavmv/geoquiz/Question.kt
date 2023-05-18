package com.fjavmv.geoquiz

import androidx.annotation.StringRes

//https://developer.android.com/reference/android/support/annotation/StringRes.html
data class Question(@StringRes val textResId: Int, val answer: Boolean)