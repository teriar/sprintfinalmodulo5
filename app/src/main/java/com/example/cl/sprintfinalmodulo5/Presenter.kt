package com.example.cl.sprintfinalmodulo5

import android.content.SharedPreferences

class Presenter(private val view: IviewPresenter, private val view2: Eliminar) {
private  var modelo:Model = Model()

fun guardarData(
 nombre:String,
 img:String,
 precio:Double
){


    val zapato = zapato(nombre,img,precio)
    val zapatos =modelo.guardarData(zapato)

    view.guardarData(zapatos)
}

    fun eliminarData(zapato: zapato){
        val zapatos = modelo.eliminarData(zapato)
        view2.eliminar(zapato)

    }



}