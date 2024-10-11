package com.example.calculator

import android.util.Log
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

    private val lastTwoButtons = mutableListOf<String>()

    fun onButtonClick(btn: String) {

        updateLastTwoButtons(btn)

        when (btn) {
            "ON/C" -> {
                //Ligar e resetar os valores
                _ResultText.value = "0.0"
                currentNumber = null
                previousNumber = null
                operator = null
                isCalculatorOn = true
                Log.i("ON/C antes / atual", previousNumber.toString() + " / " + currentNumber.toString())
                return
            }

            "M+" -> {
                // Verifica se a calculadora está ligada
                if (isCalculatorOn) {
                    val currentTextValue = _ResultText.value?.toDoubleOrNull() ?: 0.0
                    previousNumber = (previousNumber ?: 0.0) + currentTextValue
                    _ResultText.value = previousNumber.toString()
                }
                Log.i("M+ antes / atual", previousNumber.toString() + " / " + currentNumber.toString())
                return
            }

            "M-" -> {
                // Verifica se a calculadora está ligada
                if (isCalculatorOn) {
                    val currentTextValue = _ResultText.value?.toDoubleOrNull() ?: 0.0
                    previousNumber = (previousNumber ?: 0.0) - currentTextValue
                    _ResultText.value = previousNumber.toString()
                }
                Log.i("M- antes / atual", previousNumber.toString() + " / " + currentNumber.toString())
                return
            }

            "MRC" -> {

                if (isCalculatorOn) {
                    if (lastTwoButtons.count { it == "MRC" } == 2) {
                        // Se os dois últimos botões foram "MRC", reseta os valores
                        currentNumber = null
                        previousNumber = null
                        _ResultText.value = "0"
                    } else {
                        currentNumber = previousNumber
                        previousNumber = null
                        _ResultText.value = currentNumber?.toString() ?: "0"
                    }
                }
                Log.i("MRC antes / atual", previousNumber.toString() + " / " + currentNumber.toString())
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
                Log.i("+ antes / atual", previousNumber.toString() + " / " + currentNumber.toString())
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
                Log.i("- antes / atual", previousNumber.toString() + " / " + currentNumber.toString())
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
                Log.i("x antes / atual", previousNumber.toString() + " / " + currentNumber.toString())
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
                Log.i("dividir antes / atual", previousNumber.toString() + " / " + currentNumber.toString())
                return
            }

            "√" -> {
                currentNumber = _ResultText.value?.toDoubleOrNull()
                if (isCalculatorOn) {
                    _ResultText.value?.let {
                        currentNumber = it.toDoubleOrNull()?.let { num -> sqrt(num) }
                        previousNumber = _ResultText.value?.toDoubleOrNull()
                        _ResultText.value = currentNumber.toString()
                    }
                }

                Log.i("raiz antes / atual", previousNumber.toString() + " / " + currentNumber.toString())
                return
            }

            "CE" -> {
                if (isCalculatorOn) {

                    _ResultText.value = _ResultText.value?.dropLast(1)?.ifEmpty { "0.0" }

                    if(_ResultText.value?.endsWith(".") == true){
                        _ResultText.value += "0"
                    }
                }
                Log.i("CE antes / atual", previousNumber.toString() + " / " + currentNumber.toString())
                return
            }

            "+/-" -> {
                if (isCalculatorOn) {
                    currentNumber = _ResultText.value?.toDoubleOrNull()
                    if (currentNumber != null && currentNumber != 0.0) {
                        previousNumber = _ResultText.value?.toDoubleOrNull()
                        _ResultText.value = (-previousNumber!!).toString()
                        currentNumber = _ResultText.value?.toDoubleOrNull()
                    } else if (currentNumber == 0.0) {
                        _ResultText.value = currentNumber.toString()
                    }
                }
                Log.i("+/- antes / atual", previousNumber.toString() + " / " + currentNumber.toString())
                return
            }

            "%" -> {
                if (isCalculatorOn) {
                    currentNumber = _ResultText.value?.toDoubleOrNull()
                    if (currentNumber != null) {
                        previousNumber = _ResultText.value?.toDoubleOrNull()
                        currentNumber =  previousNumber!! / 100
                        _ResultText.value = currentNumber.toString()
                    }
                }
                Log.i("% antes / atual", previousNumber.toString() + " / " + currentNumber.toString())
                return
            }

            "=" -> {
                if (isCalculatorOn) {
                    currentNumber = _ResultText.value?.toDoubleOrNull()
                    if (previousNumber != null && currentNumber != null && operator != null) {
                        currentNumber = performOperation(previousNumber!!, currentNumber!!, operator!!)
                        previousNumber = _ResultText.value?.toDoubleOrNull()
                        _ResultText.value = currentNumber.toString()
                        operator = null // Reseta o operador após a operação
                    }
                }
                Log.i("= antes / atual", previousNumber.toString() + " / " + currentNumber.toString())
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
                Log.i("decimal antes / atual", previousNumber.toString() + " / " + currentNumber.toString())
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
            Log.i("Number -> ", previousNumber.toString() + " / " + currentNumber.toString())
        }
    }

    private fun updateLastTwoButtons(btn: String) {
        // armazenar os ultimos 2 botões clicados
        if (lastTwoButtons.size >= 2) {
            lastTwoButtons.removeAt(0)
        }
        lastTwoButtons.add(btn)
        Log.i("Last two Buttons", "$lastTwoButtons -> $btn")
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
            else -> num1
        }
    }
}
