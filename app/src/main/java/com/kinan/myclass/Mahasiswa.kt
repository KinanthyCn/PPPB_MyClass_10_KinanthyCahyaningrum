package com.kinan.myclass

import androidx.annotation.DrawableRes

data class Mahasiswa(
    val name: String = "",
    val nim : String = "",
    val ipk : Double = 1.1,
    @DrawableRes val imageResId: Int = R.drawable.kinanthy

)
