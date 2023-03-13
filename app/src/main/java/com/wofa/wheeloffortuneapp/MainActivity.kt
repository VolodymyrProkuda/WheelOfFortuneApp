package com.wofa.wheeloffortuneapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.wofa.wheeloffortuneapp.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var rnd1 : Long = 0


        binding.spinThatWheel.setOnClickListener {
            rnd1 = Random.nextLong(0, 7)
            binding.wheelOfFort.animate().apply {
                duration = 2000
                rotationBy(1800f)
            }.withEndAction {
                binding.wheelOfFort.animate().apply {
                    duration = rnd1 * 400
                    rotationBy(rnd1 * 45f)
                }.start()
            }
        }

    }
}