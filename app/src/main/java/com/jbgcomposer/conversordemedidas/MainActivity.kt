package com.jbgcomposer.conversordemedidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jbgcomposer.conversordemedidas.databinding.ActivityMainBinding
import com.jbgcomposer.conversordemedidas.models.Calculator
import com.jbgcomposer.conversordemedidas.models.strategies.KilometerToMeterStrategy

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}