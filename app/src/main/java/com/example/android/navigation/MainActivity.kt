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

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.ActivityMainBinding
import com.example.android.navigation.databinding.FragmentGameWonBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNUSED_VARIABLE")

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Para agregar el up button en el app bar
        NavigationUI.setupActionBarWithNavController(this,this.findNavController(R.id.myNavHostFragment))

/*        binding.toolbar.inflateMenu(R.menu.options_menu)*/

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

    //Para agregar el up button en eel ap bar
    override fun onSupportNavigateUp(): Boolean {
        return this.findNavController(R.id.myNavHostFragment).navigateUp()
    }

}
