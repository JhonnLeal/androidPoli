package com.example.gardenkeeper.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gardenKeeper.ui.gallery.GalleryAdapter
import com.example.gardenkeeper.R
import com.example.gardenkeeper.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {
    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        galleryViewModel = ViewModelProvider(this).get(GalleryViewModel::class.java)
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Lista de imágenes (puedes añadir tantas como desees)
        val images = listOf(
            R.drawable.add, R.drawable.add, R.drawable.add,
            R.drawable.add, R.drawable.add, R.drawable.add,
            R.drawable.add, R.drawable.add, R.drawable.add,
            R.drawable.add, R.drawable.add, R.drawable.add
        )

        // Configuración del RecyclerView con GridLayoutManager
        val gridLayoutManager = GridLayoutManager(context, 3) // 3 columnas
        binding.galleryRecyclerView.layoutManager = gridLayoutManager
        binding.galleryRecyclerView.adapter = GalleryAdapter(images)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
