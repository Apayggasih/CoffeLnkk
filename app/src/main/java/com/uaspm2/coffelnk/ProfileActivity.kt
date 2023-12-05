package com.uaspm2.coffelnk

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.uaspm2.coffelnk.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

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