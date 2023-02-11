package com.jbgcomposer.conversordemedidas.models.strategies

interface CalculationStrategy {

    fun calculate(value : Double): Double

    fun getResultLabel(isPlural: Boolean) : String
}