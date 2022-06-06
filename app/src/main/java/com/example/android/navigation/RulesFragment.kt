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
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.android.navigation.databinding.FragmentRulesBinding
import com.example.android.navigation.databinding.FragmentTitleBinding
import com.example.android.navigation.RulesFragmentDirections

class RulesFragment : Fragment(R.layout.fragment_rules) {

    private lateinit var binding: FragmentRulesBinding



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentRulesBinding.bind(view)

        binding.rulesPlayButton.setOnClickListener {
            val action = RulesFragmentDirections.actionRulesFragmentToGameFragment()
            findNavController().navigate(action)
        }


    }
}
