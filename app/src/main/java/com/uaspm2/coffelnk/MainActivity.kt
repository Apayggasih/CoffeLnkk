package com.uaspm2.coffelnk

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.RecyclerView
import com.uaspm2.coffelnk.adapters.ImageAdapter
import com.uaspm2.coffelnk.databinding.ActivityMainBinding
import com.uaspm2.coffelnk.models.ImageItem
import java.util.UUID

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val imageRV = findViewById<RecyclerView>(R.id.imageRV)

        val imageList = arrayListOf(
            ImageItem(
                UUID.randomUUID().toString(),
                "https://dikemas.com/uploads/2020/09/Ini-Dia-Beberapa-Jenis-Minuman-Kopi-Yang-Perlu-Kamu-Ketahui-720x442.jpg"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://assets.unileversolutions.com/v1/63465882.png"
            ),
            ImageItem(
                UUID.randomUUID().toString(),
                "https://assets.unileversolutions.com/v1/63465882.png"
            )
        )

        val imageAdapter = ImageAdapter()
        imageRV.adapter = imageAdapter
        imageAdapter.submitList(imageList)

        Handler().postDelayed({
            // Do something if needed
        }, 3000)

        binding.bottomnavigation.selectedItemId = R.id.bottom_home
        binding.bottomnavigation.setOnItemSelectedListener { it ->
            when (it.itemId) {
                R.id.bottom_home -> true
                R.id.bottom_catalog -> {
                    startActivity(Intent(applicationContext, CatalogActivity::class.java))
                    finish()
                    true
                }

                R.id.bottom_profile -> {
                    startActivity(Intent(applicationContext, ProfileActivity::class.java))
                    finish()
                    true
                }

                else -> false
            }
        }
    }
}