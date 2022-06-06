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


import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Se inicializa el drawer layout
        drawerLayout = binding.drawerLayout
        // Se añade a un avariable el navController del NavHostFragment
        val navController = this.findNavController(R.id.myNavHostFragment)

        /*La NavigationUIbiblioteca del controlador de navegación se integra con la barra de la aplicación
         para permitir que el usuario toque el botón Arriba en la barra de la aplicación para volver a la
          pantalla de inicio de la aplicación desde cualquier lugar de la aplicación.*/
        //Para vincular el controlador de navegación a la barra de aplicaciones:
        //Para agregar el up button en el app bar, y el navigation drawer
        NavigationUI.setupActionBarWithNavController(this,navController, drawerLayout)

        //Para mostrar el Navigation drawer
        NavigationUI.setupWithNavController(binding.navView, navController)

    }
    // Para añadir un menú en el app bar de toda la app
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Se infla el menú en el app bar
        menuInflater.inflate(R.menu.options_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //Se da funcionalidad al icono android del menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.android){
            Toast.makeText(this, "Welcome to Android Trivia", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
        }

    //Para agregar el up button en el ap bar
    //Se anula el método onSupportNavigateUp() para llamar navigateUp() del controlador de navegación:
    // se adiciona el navigation drawer
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.myNavHostFragment)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

}
