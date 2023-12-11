package com.uaspm2.coffelnk

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.uaspm2.coffelnk.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val user = FirebaseAuth.getInstance().currentUser!!

        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.username.text = user.displayName
        Glide.with(this)
            .load(user.photoUrl)
            .into(binding.gambar)

        binding.logoutButton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .build()
            GoogleSignIn.getClient(this, gso).signOut()
            startActivity(Intent(this, LoginActivity::class.java)) // Assuming LoginActivity is your login screen
            finish()
        }

        binding.bottomnavigation.selectedItemId = R.id.bottom_profile
        binding.bottomnavigation.setOnItemSelectedListener { it ->
            when (it.itemId) {
                R.id.bottom_home -> {
                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    finish()
                    true
                }
                R.id.bottom_catalog -> {
                    startActivity(Intent(applicationContext, CatalogActivity::class.java))
                    finish()
                    true
                }
                R.id.bottom_profile -> true

                else -> false
            }
        }
    }
}