package com.example.cl.sprintfinalmodulo5

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.ContentProviderCompat.requireContext

class Model {
    private lateinit var zapatos:MutableList<zapato>
    private lateinit var mSharedPreferences: SharedPreferences
    fun guardarData (zapato: zapato):MutableList<zapato>{
        zapatos.add(zapato)
        return zapatos
    }

}