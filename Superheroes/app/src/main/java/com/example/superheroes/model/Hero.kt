package com.example.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class Hero (
     @StringRes val heroName : Int,
     @StringRes val heroDescription : Int,
     @DrawableRes val heroImage : Int,
 )