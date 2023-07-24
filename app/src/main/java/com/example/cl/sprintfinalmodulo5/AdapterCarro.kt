package com.example.cl.sprintfinalmodulo5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cl.sprintfinalmodulo5.databinding.FragmentCarritoBinding
import com.example.cl.sprintfinalmodulo5.databinding.ItemBinding
import com.example.cl.sprintfinalmodulo5.databinding.ItemCarritoBinding

class AdapterCarro:RecyclerView.Adapter <AdapterCarro.ViewHolder>() {
    var zapatos = mutableListOf<zapato>()
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

            }

        }


    }




}