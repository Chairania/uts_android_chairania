package com.example.uts_android_semangat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView
import androidx.fragment.app.Fragment

class BeritaFragment : Fragment() {

    private lateinit var newsListView: ListView
    private lateinit var newsAdapter: NewsAdapter
    private lateinit var newsList: List<NewsData>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_berita, container, false)

        newsListView = view.findViewById(R.id.newsListView)

        // Dummy data with full descriptions
        newsList = listOf(
            NewsData(R.drawable.ic_launcher_background, "Dialog Jurusan", "17 Mei diadakan dialog jurusan", "17 Mei diadakan dialog jurusan, mahasiswa dengan keluhan terhadap fasilitas dan kenyamanan kampus dapat ditanyakan dan dibahas di sini"),
            NewsData(R.drawable.ic_launcher_background, "Fakta Kpop", "Do dan Baekhyun telah jadi CEO", "Do dan Baekhyun telah jadi CEO. Kabar ini sudah di publis sejak awal januari, yang membuat para fans terkejut awalnya, namun tetap mendukung"),
            NewsData(R.drawable.ic_launcher_background, "Sunjae Imsol", "Perjuangan imsol menyelamatkan Sunjae", "Perjuangan Imsol menyelamatkan Sunjae dalam drakor Lovely Runner, drakor ini menarik banyak peminat terutama di kalangan anak muda, keseruan dan plot twist yang tidak terduga yang membuat film ini seru"),
            NewsData(R.drawable.ic_launcher_background, "TDS 3 IN JAKARTA", "18 Mei NCT DREAM konser di jakarta", "18 Mei NCT DREAM konser di jakarta, seluruh fans indonesia antusian terhadap konser ini, konser yang menghasilkan memori indah tak akan terlupakan"),
            NewsData(R.drawable.ic_launcher_background, "Semangat UTS", "TI 4B sedang melaksanakan uts", "TI 4B sedang melaksanakan uts. Tidak hanya anak TI4B namun seluruh warga pnj sedang uts, namun karena saya anak TI4B jadi yang disorot hanya 1 kelas ini, SEMANGAT UTS"),
            NewsData(R.drawable.ic_launcher_background, "Jus Mangga Kantin", "Jus Mangga di kantin bener-bener enak", "jus mangga merupakan jus favorit saya, jadi setiap saya ke kantin saya sering memesan jus ini"),
            NewsData(R.drawable.ic_launcher_background, "Barnaby", "Barnaby jualan POPMIE", "Barnaby jualan popmie lohhh!! tinggal seduh sediri langsung dapat menikmati popmie secara cepat dan murah"),
            NewsData(R.drawable.ic_launcher_background, "Merch Barnaby", "Merch TIK COMING SOON", "Merch ini sedang dalam tahap pembuatan, ada kaos, lanyard, stiker, dan ganci yang lucu dan unik. STAY TUNE"),
            NewsData(R.drawable.ic_launcher_background, "Renjun come back", "Renjun kembali konser setelah hiatus", "sudah sebulan sejak renjun hiatus, comebacknya renjun ditunggu-tunggu oleh semua fans, semua mendoakan yang terbaik"),
            NewsData(R.drawable.ic_launcher_background, "Aespa Supernova", "Come Back yang waw", "comeback aespa kali ini bener-bener waw dengan konsep yang unik, kecantikan yang unreal, dan cerita yang seru")
        )

        newsAdapter = NewsAdapter(requireContext(), newsList)
        newsListView.adapter = newsAdapter

        // Set click listener for ListView items
        newsListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedItem = newsList[position]
            val intent = Intent(activity, DetailBeritaActivity::class.java).apply {
                putExtra("imageResId", selectedItem.imageResId)
                putExtra("title", selectedItem.title)
                putExtra("description", selectedItem.fullDescription)
            }
            startActivity(intent)
        }

        return view
    }
}
