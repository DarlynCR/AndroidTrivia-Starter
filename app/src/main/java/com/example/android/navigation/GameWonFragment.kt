/*
 * Copyright 2018, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigation

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.navigation.databinding.FragmentGameBinding
import com.example.android.navigation.databinding.FragmentGameWonBinding


class GameWonFragment : Fragment(R.layout.fragment_game_won) {

    private lateinit var binding: FragmentGameWonBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentGameWonBinding.bind(view)
        //
        setHasOptionsMenu(true)

        binding.nextMatchButton.setOnClickListener {
            findNavController().navigate(GameWonFragmentDirections.actionGameWonFragmentToGameFragment())
        }

        // Se extraen los argumentos del objeto Bundle que vienen del GameFragment
        val args = GameWonFragmentArgs.fromBundle(requireArguments())
        Toast.makeText(context, "NumCorrect: ${args.numCorrect}, NumQuestions: ${args.numQuestions}", Toast.LENGTH_LONG).show()
    }

    //Se crea el menú de opciones
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        //Se infla el menú en el fragmento
        inflater.inflate(R.menu.winner_menu, menu)
        //Con el packageManager se verifica que exista alguna app en el dispositvo que resuelva el intent
        if(getShareIntent().resolveActivity(requireActivity().packageManager)==null){
            //Si no se encuentra una app, se oculta el icono de compartir
            menu.findItem(R.id.share).isVisible = false
        }
    }
        // Se da funcionalidad al cl hacer click en el icono de compartir
        override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.share -> shareSuccess()
        }
        return super.onOptionsItemSelected(item)
    }

    //Se define el intent
    private fun getShareIntent() : Intent {
        val args = GameWonFragmentArgs.fromBundle(requireArguments())
  /*      //Se construye la el INTENT o intención de enviar el mensaje que el usuario quiere
        val shareIntent = Intent(Intent.ACTION_SEND)
        shareIntent.setType("text/plain") //Tipo de dato a compartir
            .putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text, args.numCorrect, args.numQuestions))
        //Los datos que se entregaran se especifican en el archivo EXTRA_TEXT
        return shareIntent*/

        return Intent(Intent.ACTION_SEND).apply {
            setType("text/plain")
            putExtra(Intent.EXTRA_TEXT, getString(R.string.share_success_text, args.numCorrect, args.numQuestions))
        }

    }

    //Se llama al metodo que construye el Intent y se pasa como parametro al starActivity para comenzar la actividad
    private fun shareSuccess() {
        startActivity(getShareIntent())
    }
}
