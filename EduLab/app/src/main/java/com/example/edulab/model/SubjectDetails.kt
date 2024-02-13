package com.example.edulab.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class SubjectDetails (
   @StringRes val subjectResourceId : Int,
    @DrawableRes val imageResourceId : Int,
    val courseNumber: Int
)