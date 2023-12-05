package com.uaspm2.coffelnk

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.uaspm2.coffelnk.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/Nuha-Dev
=======
>>>>>>> 9f8cd27 (Perubahan dari fragment ke activity)

//        binding.bottomNavigation.setOnItemSelectedListener {
//            when(it.itemId) {
//                R.id.bottom_home -> replaceFragment(HomeFragment())
//                R.id.bottom_catalog -> replaceFragment(CatalogFragment())
//                R.id.bottom_profile -> replaceFragment(ProfileFragment())
//                else -> {
//                    // Do something if needed
//                }
//            }
//            true
//        }
//    }
//
//    private fun replaceFragment(fragment: Fragment){
//        val fragmentManager = supportFragmentManager
//        val fragmentTransaction = fragmentManager.beginTransaction()
//        fragmentTransaction.replace(R.id.frame_container, fragment)
//        fragmentTransaction.commit()
//    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> origin/main
=======
>>>>>>> origin/Nuha-Dev
=======
>>>>>>> 9f8cd27 (Perubahan dari fragment ke activity)
