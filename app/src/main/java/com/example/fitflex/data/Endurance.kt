package com.example.fitflex.data


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.fitflex.R

/**
 * A data class to represent the information presented in the Endurance card
 */
data class Endurance(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    val age: Int,
    @StringRes val hobbies: Int
)

val endurances = listOf(
    Endurance(R.drawable.koda, R.string.endurance_name_1, 2, R.string.endurance_description_1),
    Endurance(R.drawable.lola, R.string.endurance_name_2, 16, R.string.endurance_description_2),
    Endurance(R.drawable.frankie, R.string.endurance_name_3, 2, R.string.endurance_description_3),
    Endurance(R.drawable.nox, R.string.endurance_name_4, 8, R.string.endurance_description_4),

)

