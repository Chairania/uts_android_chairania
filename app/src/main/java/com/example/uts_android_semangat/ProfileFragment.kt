package com.example.uts_android_semangat

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)

        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvNim = view.findViewById<TextView>(R.id.tvNim)
        val tvKelas = view.findViewById<TextView>(R.id.tvKelas)
        val tvEmail = view.findViewById<TextView>(R.id.tvEmail)
        val btnLogout = view.findViewById<Button>(R.id.btnLogout)

        val sharedPreferences = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "N/A")
        val nim = sharedPreferences.getString("nim", "N/A")
        val kelas = sharedPreferences.getString("kelas", "N/A")
        val email = sharedPreferences.getString("email", "N/A")

        tvName.text = "Name: $name"
        tvNim.text = "NIM: $nim"
        tvKelas.text = "Kelas: $kelas"
        tvEmail.text = "Email: $email"

        btnLogout.setOnClickListener {
            // Clear SharedPreferences
            sharedPreferences.edit().clear().apply()

            // Navigate to LoginActivity
            val intent = Intent(activity, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        return view
    }
}
