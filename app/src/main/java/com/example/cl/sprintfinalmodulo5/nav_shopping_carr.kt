package com.example.cl.sprintfinalmodulo5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import com.example.cl.sprintfinalmodulo5.databinding.FragmentNavShoppingCarrBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [nav_shopping_carr.newInstance] factory method to
 * create an instance of this fragment.
 */
class nav_shopping_carr : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binging:FragmentNavShoppingCarrBinding
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
        // Inflate the layout for this fragment

        binging = FragmentNavShoppingCarrBinding.inflate(layoutInflater)
        initListener()
        return binging.root
    }

    private fun initListener() {

        binging.imgCarrito.setOnClickListener(View.OnClickListener {
            findNavController(requireView()).navigate(
                R.id.action_nav_shopping_carr_to_carrito
            )
        })
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment nav_shopping_carr.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            nav_shopping_carr().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}