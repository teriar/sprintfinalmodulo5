package com.example.cl.sprintfinalmodulo5

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cl.sprintfinalmodulo5.databinding.FragmentCarritoBinding
import com.example.cl.sprintfinalmodulo5.databinding.ItemBinding
import com.example.cl.sprintfinalmodulo5.databinding.ItemCarritoBinding
import com.google.gson.Gson

class AdapterCarro(val eliminar:Eliminar):RecyclerView.Adapter <AdapterCarro.ViewHolder>() {
    var zapatos = mutableListOf<zapato>()

    private lateinit var mSharedPreferences: SharedPreferences
    private lateinit var gson: Gson
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCarro.ViewHolder {

        var binding =ItemCarritoBinding.inflate(LayoutInflater.from(parent.context),parent , false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val item = zapatos[position]
        holder.bind(item)
    }


    override fun getItemCount(): Int {
        return zapatos.size
    }

    fun setData(listazapatos: List<zapato>){
        zapatos = listazapatos.toMutableList()
    }
    inner class ViewHolder ( val binding: ItemCarritoBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:zapato){

            binding.txtNombreItem.text=item.nombre
            binding.txtPrecioItem.text = item.precio.toString()
            binding.imgzapatoItem.load(item.url)

            binding.btnBorrarSeleccionado.setOnClickListener {
                 zapatos.remove(item)

                notifyDataSetChanged()

                eliminar.eliminar(item)
                Log.d("esto", "dsa")



            }


        }


    }




}