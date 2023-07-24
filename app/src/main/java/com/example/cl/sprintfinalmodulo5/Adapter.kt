package com.example.cl.sprintfinalmodulo5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cl.sprintfinalmodulo5.databinding.ItemBinding

class Adapter: RecyclerView.Adapter <Adapter.ViewHolder>() {
    var zapatos = mutableListOf<zapato>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        var binding =ItemBinding.inflate(LayoutInflater.from(parent.context),parent , false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        val item = zapatos[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return zapatos.size
    }

    fun setData(listazapatos: List<zapato>){
        zapatos = listazapatos.toMutableList()
    }

    inner class ViewHolder (val binding: ItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(item:zapato){

          binding.txtNombre.text = item.nombre
          binding.txtPrecio.text = item.precio.toString()
          binding.imgZapato.load(item.url)
            val bundle = Bundle()
            bundle.putString("nombre",item.nombre)
            bundle.putString("precio", item.precio.toString())
            bundle.putString("url",item.url)
          binding.cardview.setOnClickListener({
              Navigation.findNavController(binding.root).navigate(R.id.action_nav_shopping_carr_to_detalle,bundle)
          })
        }
    }
}