package com.example.cl.sprintfinalmodulo5

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cl.sprintfinalmodulo5.databinding.FragmentCarritoBinding
import androidx.navigation.Navigation
import com.example.cl.sprintfinalmodulo5.databinding.ItemCarritoBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "lista"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [carrito.newInstance] factory method to
 * create an instance of this fragment.
 */
interface Eliminar{
    fun eliminar(shoe: zapato)
}
class Carrito : Fragment(), Eliminar {
    private lateinit var mSharedPreferences: SharedPreferences
    private lateinit var gson: Gson
    private lateinit var binging: FragmentCarritoBinding
    private lateinit var bingingAdapterCarrito: ItemCarritoBinding

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binging = FragmentCarritoBinding.inflate(layoutInflater)
        bingingAdapterCarrito = ItemCarritoBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        initListener()
        return (binging.root)

    }

    private fun initListener() {

        mSharedPreferences =requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
        gson = Gson()
        var lista =getList()
        val adapter = AdapterCarro(this)

        adapter.setData(lista)
        binging.recyclerViewCarro.adapter=adapter





        binging.btnBorrarLista.setOnClickListener {
            mSharedPreferences.edit().clear().apply()
            Navigation.findNavController(requireView())
                .navigate(R.id.action_carrito_to_nav_shopping_carr)
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
         * @return A new instance of fragment carrito.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Carrito().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun eliminar(shoe: zapato) {
        val zapatoslista = getList()
        zapatoslista.remove(shoe)


        mSharedPreferences =requireContext().getSharedPreferences("data", Context.MODE_PRIVATE)
        gson = Gson()

        val jsonString = gson.toJson(zapatoslista)
        mSharedPreferences.edit().putString("mi lista", jsonString).apply()
    }
}