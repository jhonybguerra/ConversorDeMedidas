package com.jbgcomposer.conversordemedidas.models.strategies

class KilometerToCentimeterStrategy : CalculationStrategy {
    override fun calculate(value: Double): Double {
        return value * 100_000
    }

    override fun getResultLabel(isPlural: Boolean): String {
         return if(isPlural) {
            "centímetros"
        } else {
            "centímetro"
        }
    }
}