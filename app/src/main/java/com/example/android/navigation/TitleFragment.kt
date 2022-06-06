package com.example.android.navigation

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
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

        binding.playButton.setOnClickListener {
            val action = TitleFragmentDirections.actionTitleFragmentToGameFragment()
            findNavController().navigate(action)
        }
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
