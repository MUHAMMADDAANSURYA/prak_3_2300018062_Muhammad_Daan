package com.regita.prak3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HasilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

        // 1. Inisialisasi Views sesuai ID di activity_hasil.xml
        val tvNim = findViewById<TextView>(R.id.tvTampilNim)
        val tvUsername = findViewById<TextView>(R.id.tvTampilUsername)
        val tvAge = findViewById<TextView>(R.id.tvTampilAge)
        val tvEmail = findViewById<TextView>(R.id.tvTampilEmail)
        val tvGender = findViewById<TextView>(R.id.tvTampilJenisKelamin)


        // 2. Ambil data dari Intent
        val nim = intent.getStringExtra(MainActivity.EXTRA_NIM)
        val username = intent.getStringExtra(MainActivity.EXTRA_USERNAME)
        val age = intent.getStringExtra(MainActivity.EXTRA_AGE)
        val email = intent.getStringExtra(MainActivity.EXTRA_EMAIL)
        val gender = intent.getStringExtra(MainActivity.EXTRA_GENDER)

        // 3. Tampilkan data ke TextView
        tvNim.text = nim ?: "-"
        tvUsername.text = username ?: "-"
        tvAge.text = age ?: "-"
        tvEmail.text = email ?: "-"
        tvGender.text = gender ?: "-"

    }
}
