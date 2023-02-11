package com.jbgcomposer.conversordemedidas.models.strategies

class CentimeterToKilometerStrategy : CalculationStrategy {
    override fun calculate(value: Double): Double = value * 100_000

    override fun getResultLabel(isPlural: Boolean): String = if(isPlural) "metros" else "metro"
}