package com.example.fitflex.data


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.fitflex.R


data class Endurance(
    @DrawableRes val imageResourceId: Int,
    @StringRes val name: Int,
    @StringRes val description: Int,
    var isToggled: Boolean = false
)

val endurances = listOf(
    Endurance(R.drawable.run, R.string.endurance_name_1, R.string.endurance_description_1),
    Endurance(R.drawable.rowing, R.string.endurance_name_2, R.string.endurance_description_2),
    Endurance(R.drawable.interval, R.string.endurance_name_3, R.string.endurance_description_3),
    Endurance(R.drawable.hiking, R.string.endurance_name_4, R.string.endurance_description_4)
)