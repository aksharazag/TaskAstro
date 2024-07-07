package com.example.taskastro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.taskastro.ui.ProductFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        if (savedInstanceState == null) {
//            // Launch the Fragment when activity is first created
//            val fragment = ProductFragment()
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.fragmentContainerView, fragment)
//                .commit()
//        }
    }
}