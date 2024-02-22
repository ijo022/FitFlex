package com.example.fitflex.data


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.fitflex.R

/**
 * A data class to represent the information presented in the Strength card
 */
data class Strength(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int
)

val strengths = listOf(
    Strength(R.drawable.koda, R.string.strength_name_1, 2, R.string.strength_description_1),
    Strength(R.drawable.lola, R.string.strength_name_2, 16, R.string.strength_description_2),
    Strength(R.drawable.frankie, R.string.strength_name_3, 2, R.string.strength_description_3),
    Strength(R.drawable.nox, R.string.strength_name_4, 8, R.string.strength_description_4),
 
)

