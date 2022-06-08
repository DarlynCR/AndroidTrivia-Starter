package com.example.android.navigation

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding


class TitleFragment : Fragment(R.layout.fragment_title) {

    private lateinit var binding : FragmentTitleBinding



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Para agregar un menú a solo un fragmento
        //Este método Indica que el fragmento tiene elementos de menu para contribuir
        setHasOptionsMenu(true)
        binding = FragmentTitleBinding.bind(view)
        Log.i("TitleFragment", "onViewCreated called")
        binding.playButton.setOnClickListener {
            val action = TitleFragmentDirections.actionTitleFragmentToGameFragment()
            findNavController().navigate(action)
        }

        binding.btnRules.setOnClickListener {
            val action = TitleFragmentDirections.actionTitleFragmentToRulesFragment()
            findNavController().navigate(action)
        }

        binding.btnAbout.setOnClickListener {
            val action = TitleFragmentDirections.actionTitleFragmentToAboutFragment()
            findNavController().navigate(action)
        }
    }

    //Llamadas a los métodos del ciclo de vida del fragment
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.i("TitleFragment", "onAttach called")
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("TitleFragment", "onCreate called")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i("TitleFragment", "onCreateView called")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onStart() {
        super.onStart()
        Log.i("TitleFragment", "onStart called")
    }
    override fun onResume() {
        super.onResume()
        Log.i("TitleFragment", "onResume called")
    }
    override fun onPause() {
        super.onPause()
        Log.i("TitleFragment", "onPause called")
    }
    override fun onStop() {
        super.onStop()
        Log.i("TitleFragment", "onStop called")
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Log.i("TitleFragment", "onDestroyView called")
    }
    override fun onDetach() {
        super.onDetach()
        Log.i("TitleFragment", "onDetach called")
    }

    //Para llamar a este método primero se debe llamar el método setHasOptionsMenu(true)
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        //menu: menu de opciones en el que coloca sus artículos.
        //Se agrega el menú de opciones e infla el archivo de recursos del menú.
        inflater.inflate(R.menu.title_menu, menu)
    }

    //Se le da funcionalidad al menú inflado para el fragment
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item,requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }


}
