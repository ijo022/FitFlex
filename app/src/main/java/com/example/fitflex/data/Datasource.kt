package com.example.fitflex.data

import com.example.fitflex.R



class Datasource() {
    fun loadSets(): List<Int> {
        return listOf(
            R.string.Set_1,
            R.string.Set_2,
            R.string.Set_3,
            R.string.Set_4
        )
    }
}