package com.example.calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlin.math.sqrt

class Functions : ViewModel() {

    private val _ResultText = MutableLiveData("")
    val resultText: LiveData<String> = _ResultText

    private var currentNumber: Double? = null
    private var previousNumber: Double? = null
    private var operator: String? = null
    private var isCalculatorOn: Boolean = false

    fun onButtonClick(btn: String) {
        when (btn) {
            "ON/C" -> {
                //Ligar e resetar os valores
                _ResultText.value = "0.0"
                currentNumber = null
                previousNumber = null
                operator = null
                isCalculatorOn = true
                return
            }

            "+" -> {
                // Só faz algo se a calculadora estiver ligada
                if (isCalculatorOn) {
                    currentNumber = _ResultText.value?.toDoubleOrNull()
                    if (previousNumber != null && currentNumber != null && operator != null) {
                        previousNumber = performOperation(previousNumber!!, currentNumber!!, operator!!)
                        _ResultText.value = previousNumber.toString()
                    } else {
                        previousNumber = currentNumber
                    }
                    operator = btn
                    currentNumber = null // Limpa o currentNumber para o próximo número
                    _ResultText.value = "0.0" //Prepara para o próximo número
                }
                return
            }

            "-" -> {
                if (isCalculatorOn) {
                    currentNumber = _ResultText.value?.toDoubleOrNull()
                    if (previousNumber != null && currentNumber != null && operator != null) {
                        previousNumber = performOperation(previousNumber!!, currentNumber!!, operator!!)
                        _ResultText.value = previousNumber.toString()
                    } else {
                        previousNumber = currentNumber
                    }
                    operator = btn
                    currentNumber = null // Limpa o currentNumber para o próximo número
                    _ResultText.value = "0.0" // Prepara para o próximo número
                }
                return
            }

            "x" -> {
                if (isCalculatorOn) {
                    currentNumber = _ResultText.value?.toDoubleOrNull()
                    if (previousNumber != null && currentNumber != null && operator != null) {
                        previousNumber = performOperation(previousNumber!!, currentNumber!!, operator!!)
                        _ResultText.value = previousNumber.toString()
                    } else {
                        previousNumber = currentNumber
                    }
                    operator = btn
                    currentNumber = null // Limpa o currentNumber para o próximo número
                    _ResultText.value = "0.0" // Prepara para o próximo número
                }
                return
            }

            "÷" -> {
                if (isCalculatorOn) {
                    currentNumber = _ResultText.value?.toDoubleOrNull()
                    if (previousNumber != null && currentNumber != null && operator != null) {
                        previousNumber = performOperation(previousNumber!!, currentNumber!!, operator!!)
                        _ResultText.value = previousNumber.toString()
                    } else {
                        previousNumber = currentNumber
                    }
                    operator = btn
                    currentNumber = null // Limpa o currentNumber para o próximo número
                    _ResultText.value = "0.0" // Prepara para o próximo número
                }
                return
            }

            "√" -> {
                if (isCalculatorOn) {
                    _ResultText.value?.let {
                        val result = it.toDoubleOrNull()?.let { num -> sqrt(num) }
                        _ResultText.value = result?.toString() ?: "Error"
                    }
                }
                return
            }

            "CE" -> {
                if (isCalculatorOn) {
                    _ResultText.value = _ResultText.value?.dropLast(1)?.ifEmpty { "0.0" }
                }
                return
            }

            "+/-" -> {
                if (isCalculatorOn) {
                    currentNumber = _ResultText.value?.toDoubleOrNull()
                    if (currentNumber != null && currentNumber != 0.0) {
                        previousNumber = currentNumber
                        _ResultText.value = (-currentNumber!!).toString()
                    } else if (currentNumber == 0.0) {
                        _ResultText.value = currentNumber.toString()
                    }
                }
                return
            }

            "%" -> {
                if (isCalculatorOn) {
                    currentNumber = _ResultText.value?.toDoubleOrNull()
                    if (currentNumber != null) {
                        previousNumber = currentNumber
                        val result = currentNumber!! / 100
                        _ResultText.value = result.toString()
                    }
                }
                return
            }

            "=" -> {
                if (isCalculatorOn) {
                    currentNumber = _ResultText.value?.toDoubleOrNull()
                    if (previousNumber != null && currentNumber != null && operator != null) {
                        previousNumber = performOperation(previousNumber!!, currentNumber!!, operator!!)
                        _ResultText.value = previousNumber.toString()
                        operator = null // Reseta o operador após a operação
                    }
                }
                return
            }

            "•" -> {
                if (isCalculatorOn) {
                    // Adiciona um ponto decimal se não existir um
                    if (!_ResultText.value?.contains(".")!!) {
                        // Se o resultado atual for "0.0", substitui por "0."
                        if (_ResultText.value == "0.0") {
                            _ResultText.value = "0."
                        } else {
                            _ResultText.value += "."
                        }
                    }
                }
                return
            }
        }

        if (isCalculatorOn) {
            // Concatenar números
            if (_ResultText.value == "0.0") {
                _ResultText.value = btn
            } else {
                _ResultText.value += btn
            }
        }
    }

    private fun performOperation(num1: Double, num2: Double, op: String): Double {
        return when (op) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "x" -> num1 * num2
            "÷" -> if (num2 == 0.0) {
                // Tratar a divisão por zero
                throw ArithmeticException("Cannot divide by zero")
            } else {
                num1 / num2
            }
            else -> num1 // Retorna o primeiro número se a operação não for reconhecida
        }
    }
}
