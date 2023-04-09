package com.example.trabalho1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.trabalho1.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportActionBar?.hide()

        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonEnter.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}