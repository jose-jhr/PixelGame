package com.ingenieriajhr.pixelgame.fragments

import android.os.Bundle
import android.view.Display.Mode
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import com.ingenieriajhr.pixelgame.R
import com.ingenieriajhr.pixelgame.adapters.GridAdapterMain
import com.ingenieriajhr.pixelgame.model.ModelMain

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainSelectFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainSelectFragment : Fragment() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private val arrayMain = ArrayList<ModelMain>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_main_select, container, false)
        //init dataLevels
        arrayMain.add(ModelMain("Salta y gana",R.drawable.ic_launcher_background))
        arrayMain.add(ModelMain("Dispara con los dedos",R.drawable.ic_launcher_background))
        arrayMain.add(ModelMain("Come frutas",R.drawable.ic_launcher_background))
        arrayMain.add(ModelMain("Laberinto",R.drawable.ic_launcher_background))
        arrayMain.add(ModelMain("Boxeo",R.drawable.ic_launcher_background))
        arrayMain.add(ModelMain("Cabecitas",R.drawable.ic_launcher_background))
        arrayMain.add(ModelMain("Golpea extremos",R.drawable.ic_launcher_background))



        //init grid main
        val gridMain = root.findViewById<GridView>(R.id.gridMain)
        //init adapter
        val adapterMain = GridAdapterMain(requireContext(),arrayMain)
        //set adapter
        gridMain.adapter = adapterMain

        return root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainSelectFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainSelectFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}