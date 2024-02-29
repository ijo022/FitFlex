package com.example.fitflex.data


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.fitflex.R



/**
 * Strength data class
 */
data class Strength(
    @DrawableRes val strengthicon: Int,
    @StringRes val name: Int,
    @StringRes val set: Int,
    var isToggled: Boolean = false


)

val strengths = listOf(
    Strength(R.drawable.benchpress, R.string.strength_name_1, R.string.Set_1),
    Strength(R.drawable.shoulder, R.string.strength_name_2, R.string.Set_2),
    Strength(R.drawable.squats, R.string.strength_name_3, R.string.Set_3),
    Strength(R.drawable.lunges, R.string.strength_name_4, R.string.Set_4),
)

