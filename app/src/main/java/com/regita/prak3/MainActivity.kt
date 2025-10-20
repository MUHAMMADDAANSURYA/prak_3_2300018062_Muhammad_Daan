// File: MainActivity.kt

package com.regita.prak3 // Sesuaikan dengan nama package Anda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    // Kunci (Keys) untuk Intent
    companion object {
        const val EXTRA_NIM = "extra_nim"
        const val EXTRA_USERNAME = "extra_username"
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_GENDER = "extra_gender"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. Inisialisasi Views
        val etNim = findViewById<TextInputEditText>(R.id.etNim)
        val etUsername = findViewById<TextInputEditText>(R.id.etUsername)
        val etAge = findViewById<TextInputEditText>(R.id.etAge)
        val etEmail = findViewById<TextInputEditText>(R.id.etEmail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)
        val etConfirmPassword = findViewById<TextInputEditText>(R.id.etConfirmPassword)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        // 2. Set Listener untuk tombol Submit
        btnSubmit.setOnClickListener {

            val nim = etNim.text.toString().trim()
            val username = etUsername.text.toString().trim()
            val age = etAge.text.toString().trim()
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            // 3. Validasi Dasar
            if (nim.isEmpty() || username.isEmpty() || age.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Semua field harus diisi!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (password != confirmPassword) {
                Toast.makeText(this, "Konfirmasi Password tidak cocok!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 4. Ambil Nilai Radio Button (Jenis Kelamin)
            val selectedId = rgGender.checkedRadioButtonId
            val genderText = if (selectedId != -1) {
                findViewById<RadioButton>(selectedId).text.toString()
            } else {
                // Jika belum memilih, anggap saja tidak valid (walaupun seharusnya sudah di cek di atas)
                Toast.makeText(this, "Pilih Jenis Kelamin!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // 5. Kirim data ke HasilActivity
            val intent = Intent(this@MainActivity, HasilActivity::class.java).apply {
                putExtra(EXTRA_NIM, nim)
                putExtra(EXTRA_USERNAME, username)
                putExtra(EXTRA_AGE, age)
                putExtra(EXTRA_EMAIL, email)
                putExtra(EXTRA_GENDER, genderText)
                // Password tidak perlu dikirim untuk keamanan (hanya perlu diverifikasi di sini)
            }
            startActivity(intent)
        }
    }
}