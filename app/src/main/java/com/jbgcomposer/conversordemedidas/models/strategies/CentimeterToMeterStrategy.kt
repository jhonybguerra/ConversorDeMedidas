package com.jbgcomposer.conversordemedidas.models.strategies

class CentimeterToMeterStrategy : CalculationStrategy {
    override fun calculate(value: Double): Double = value / 100

    override fun getResultLabel(isPlural: Boolean): String = if(isPlural) "metros" else "metro"
}