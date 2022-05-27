package com.example.android.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.navigation.databinding.FragmentTitleBinding


class TitleFragment : Fragment(R.layout.fragment_title) {

    private lateinit var binding : FragmentTitleBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentTitleBinding.bind(view)
    }


}