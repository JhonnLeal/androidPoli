package com.example.gardenkeeper.ui.video

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.VideoView
import android.widget.MediaController
import androidx.fragment.app.Fragment
import com.example.gardenkeeper.R

class VideoFragment : Fragment() {

    private lateinit var videoView: VideoView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Infla el diseño del fragmento
        val view = inflater.inflate(R.layout.fragment_video, container, false)

        // Inicializa el VideoView
        videoView = view.findViewById(R.id.videoView)

        // Configura el video
        val videoUri: Uri = Uri.parse("android.resource://${requireActivity().packageName}/${R.raw.plantas}") // Reemplaza "tu_video" con el nombre de tu archivo de video
        videoView.setVideoURI(videoUri)

        // Agrega los controles de media
        val mediaController = MediaController(requireContext())
        mediaController.setAnchorView(videoView)
        videoView.setMediaController(mediaController)

        // Inicia la reproducción del video
        videoView.setOnPreparedListener { mediaPlayer: MediaPlayer ->
            mediaPlayer.isLooping = true // Hacer que el video se repita
            videoView.start() // Comienza a reproducir el video
        }

        return view
    }

    override fun onPause() {
        super.onPause()
        videoView.pause() // Pausa el video cuando el fragmento está pausado
    }

    override fun onResume() {
        super.onResume()
        videoView.start() // Reanuda la reproducción cuando el fragmento es visible nuevamente
    }

    override fun onDestroyView() {
        super.onDestroyView()
        videoView.stopPlayback() // Detiene la reproducción del video al destruir la vista
    }
}

