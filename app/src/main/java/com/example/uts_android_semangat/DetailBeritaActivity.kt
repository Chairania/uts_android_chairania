package com.example.uts_android_semangat

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailBeritaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_berita)

        val newsDetailImageView = findViewById<ImageView>(R.id.newsDetailImageView)
        val newsDetailTitleTextView = findViewById<TextView>(R.id.newsDetailTitleTextView)
        val newsDetailDescriptionTextView = findViewById<TextView>(R.id.newsDetailDescriptionTextView)

        // Get data from intent
        val imageResId = intent.getIntExtra("imageResId", R.drawable.ic_launcher_background)
        val title = intent.getStringExtra("title") ?: "News Title"
        val description = intent.getStringExtra("description") ?: "News Description"

        // Set data to views
        newsDetailImageView.setImageResource(imageResId)
        newsDetailTitleTextView.text = title
        newsDetailDescriptionTextView.text = description
    }
}

