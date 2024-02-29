package com.example.fitflex.data


import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.fitflex.R


/**
 * Endurance data class
 */
data class Endurance(
    @DrawableRes val enduranceicon: Int,
    @StringRes val name: Int,
    @StringRes val set: Int,
    var isToggled: Boolean = false
)

val endurances = listOf(
    Endurance(R.drawable.run, R.string.endurance_name_1, R.string.Set_1),
    Endurance(R.drawable.rowing, R.string.endurance_name_2, R.string.Set_2),
    Endurance(R.drawable.interval, R.string.endurance_name_3, R.string.Set_3),
    Endurance(R.drawable.hiking, R.string.endurance_name_4, R.string.Set_4),
)


