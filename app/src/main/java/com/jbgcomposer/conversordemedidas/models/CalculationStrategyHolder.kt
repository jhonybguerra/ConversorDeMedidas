package com.jbgcomposer.conversordemedidas.models

import com.jbgcomposer.conversordemedidas.models.strategies.CalculationStrategy

class CalculationStrategyHolder(
    val name: String,
    val calculationStrategy: CalculationStrategy
)