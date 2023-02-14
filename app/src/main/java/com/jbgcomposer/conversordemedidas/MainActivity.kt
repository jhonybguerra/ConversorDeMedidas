package com.jbgcomposer.conversordemedidas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import com.jbgcomposer.conversordemedidas.databinding.ActivityMainBinding
import com.jbgcomposer.conversordemedidas.models.CalculationStrategyHolder
import com.jbgcomposer.conversordemedidas.models.Calculator
import com.jbgcomposer.conversordemedidas.models.strategies.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val supportedCalculationStrategies = arrayOf(
        CalculationStrategyHolder("Centímetros para metros", CentimeterToMeterStrategy()),
        CalculationStrategyHolder("Centímetros para quilômetros", CentimeterToKilometerStrategy()),
        CalculationStrategyHolder("Metros para centímetros", MeterToCentimeterStrategy()),
        CalculationStrategyHolder("Metros para quilômetros", MeterToKilometerStrategy()),
        CalculationStrategyHolder("Quilômetros para centímetros", KilometerToCentimeterStrategy()),
        CalculationStrategyHolder("Quilômetros para metros", KilometerToMeterStrategy())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initSpinner()
        setActions()

    }

    private fun setActions() {
        binding.btnConvert.setOnClickListener {
            try {
                val value = binding.edtValue.text.toString().toDouble()
                val calculationStrategy = supportedCalculationStrategies[binding.spConversions.selectedItemPosition].calculationStrategy
                Calculator.setCalculationStrategy(calculationStrategy)
                Calculator.calculate(value)

            } catch(e: NumberFormatException) {
                binding.edtValue.error = "Insira um valor!"
            }
        }

    }

    private fun initSpinner() {
        getSpinnerData()
        val spAdapter = ArrayAdapter(this, R.layout.res_spinner_item, getSpinnerData())
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spConversions.adapter = spAdapter
    }

    private fun getSpinnerData(): MutableList<String> {
        val spinnerData = mutableListOf<String>()
        supportedCalculationStrategies.forEach {
            spinnerData.add(it.name)
        }
        return spinnerData
    }
}