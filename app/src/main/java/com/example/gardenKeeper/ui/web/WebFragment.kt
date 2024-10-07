package com.example.gardenkeeper.ui.web

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.SearchView
import androidx.fragment.app.Fragment
import com.example.gardenkeeper.R

class WebFragment : Fragment() {

    private lateinit var webView: WebView
    private lateinit var searchView: SearchView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_web, container, false)

        // Inicializa el WebView y SearchView
        webView = view.findViewById(R.id.webView)
        searchView = view.findViewById(R.id.searchView)

        // Configura el SearchView
        setupSearchView()

        return view
    }

    private fun setupSearchView() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                loadUrl(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                // Aquí puedes manejar los cambios en la búsqueda si es necesario
                return false
            }
        })
    }

    private fun loadUrl(query: String?) {
        val url = if (!query.isNullOrEmpty()) {
            if (!query.startsWith("http://") && !query.startsWith("https://")) {
                "https://$query" // Cambia http a https
            } else {
                query
            }
        } else {
            null
        }

        // Cargar la URL en el WebView solo si no es nula
        url?.let {
            webView.loadUrl(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Limpiar el WebView al destruir la vista
        webView.loadUrl("about:blank")
    }
}


