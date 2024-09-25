package com.example.gardenkeeper.ui.plantprofile

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gardenKepper.ui.plantprofile.PlantProfileViewModel
import com.example.gardenkeeper.R

class Plantprofilefragment : Fragment() {

    companion object {
        fun newInstance() = Plantprofilefragment()
    }

    private val viewModel: PlantProfileViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_plant_profile, container, false)
    }
}
