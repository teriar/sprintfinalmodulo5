package com.example.cl.sprintfinalmodulo5

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import coil.load
import com.example.cl.sprintfinalmodulo5.databinding.FragmentDetalleBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "nombre"
private const val ARG_PARAM2 = "precio"
private const val ARG_PARAM3 = "url"

/**
 * A simple [Fragment] subclass.
 * Use the [detalle.newInstance] factory method to
 * create an instance of this fragment.
 */
class detalle : Fragment(),IviewPresenter {
    private lateinit var binging:FragmentDetalleBinding
    private lateinit var mSharedPreferences:SharedPreferences
    private lateinit var gson: Gson
    private lateinit var  zapatoslista: MutableList<zapato>
    val bundle = Bundle()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var param3: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
            param3 = it.getString(ARG_PARAM3)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binging = FragmentDetalleBinding.inflate(layoutInflater)
        initListener()
        return binging.root
    }

    private fun initListener() {

        binging.img.load(param3)
        binging.txtName.text =param1
        binging.txtAmount.text = "$$param2"
        mSharedPreferences =requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
        gson = Gson()

        zapatoslista = getList()

        binging.imgCarrito.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_detalle_to_carrito,bundle)
        }

        SaveData()

    }

    private fun SaveData() {
        val preferences = this.requireActivity().getSharedPreferences("pref", MODE_PRIVATE)
        binging.btnComprar.setOnClickListener{


            var nombre = param1.toString()
            var precio = param2.toString().toDouble()
            var img = param3.toString()
            val zp = zapato(nombre,img,precio)

            zapatoslista.add(zp)

            guardarData(zapatoslista)


            mSharedPreferences =requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
            gson = Gson()

            val jsonString = gson.toJson(zapatoslista)
            mSharedPreferences.edit().putString("mi lista", jsonString).apply()

            Toast.makeText(requireContext(), "Añadido al carro", Toast.LENGTH_SHORT).show()

        }
    }
    fun getList(): MutableList<zapato> {
        val jsonString = mSharedPreferences.getString("mi lista", null)
        val listType = object : TypeToken<MutableList<zapato>>() {}.type
        return gson.fromJson(jsonString, listType) ?: mutableListOf()
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment detalle.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            detalle().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun guardarData(data: MutableList<zapato>) {
       zapatoslista = data
    }


}