package com.example.uts_android_semangat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment

class BeritaFragment : Fragment() {

    private lateinit var newsListView: ListView
    private lateinit var newsAdapter: NewsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_berita, container, false)

        newsListView = view.findViewById(R.id.newsListView)

        // Dummy data
        val newsList = listOf(
            NewsData(R.drawable.ic_launcher_background, "Dialog Jurusan", "KTM yang tidak jadi-jadi"),
            NewsData(R.drawable.ic_launcher_background, "Naura anak padang", "Naura dari TI4B yang berasa dari padang"),
            NewsData(R.drawable.ic_launcher_background, "Sunjae Imsol", "Perjuangan Imsol menyelamatkan Sunjae"),
            NewsData(R.drawable.ic_launcher_background, "TDS 3 IN JAKARTA", "tidak bisa nonton konser karena uts"),
            NewsData(R.drawable.ic_launcher_background, "Semangat UTS", "Meskipun stress uts selesai"),
            NewsData(R.drawable.ic_launcher_background, "Mangga enak", "Jus mangga di kantin sangatlah enak"),
            NewsData(R.drawable.ic_launcher_background, "Barnaby", "Barnaby menjual popmie juga loh!!"),
            NewsData(R.drawable.ic_launcher_background, "Merch Barnaby", "Merch sedang tahap pembuatan comming soon!!"),
            NewsData(R.drawable.ic_launcher_background, "Renjun come back", "Renjun kembali konser setelah hiatus"),
            NewsData(R.drawable.ic_launcher_background, "Aespa Supernova", "Dikabarkan supernova memiliki konsep unik")
        )

        newsAdapter = NewsAdapter(requireContext(), newsList)
        newsListView.adapter = newsAdapter

        return view
    }
}
