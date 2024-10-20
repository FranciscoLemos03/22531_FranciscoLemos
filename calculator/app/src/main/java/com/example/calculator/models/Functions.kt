package com.example.calculator.models

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
    private var mModeOn: Boolean = false
    private var mNumber: Double? = null

    private val lastTwoButtons = mutableListOf<String>()

    fun onButtonClick(btn: String) {

        updateLastTwoButtons(btn)

        when (btn) {
            "ON/C" -> {
                _ResultText.value = "0.0"
                currentNumber = null
                previousNumber = null
                operator = null
                isCalculatorOn = true
                mModeOn = false
                mNumber = null
            }

            "M+" -> {
                if (isCalculatorOn) {
                    currentNumber = _ResultText.value?.toDoubleOrNull()
                    if (previousNumber != null && currentNumber != null && operator != null) {
                        previousNumber = performOperation(previousNumber!!, currentNumber!!, operator!!)
                        _ResultText.value = previousNumber.toString()
                    } else {
                        previousNumber = currentNumber
                    }

                    mNumber = (mNumber ?: 0.0) + (previousNumber ?: 0.0)
                    _ResultText.value = "0.0"
                    operator = null
                }
                return
            }

            "M-" -> {
                if (isCalculatorOn) {
                    currentNumber = _ResultText.value?.toDoubleOrNull()

                    if (previousNumber != null && currentNumber != null && operator != null) {
                        previousNumber = performOperation(previousNumber!!, currentNumber!!, operator!!)
                        _ResultText.value = previousNumber.toString()
                    } else {
                        previousNumber = currentNumber
                    }

                    if(mNumber == null){
                        mNumber = previousNumber
                    } else if (previousNumber != null) {
                        mNumber = (mNumber ?: 0.0) - previousNumber!!
                    }


                    _ResultText.value = "0.0"
                    operator = null
                }
                return
            }



            "MRC" -> {

                if (isCalculatorOn) {
                    if (lastTwoButtons.count { it == "MRC" } == 2) {
                        mNumber = null
                        _ResultText.value = "0"
                    } else {
                        _ResultText.value = mNumber?.toString() ?: "0"
                    }
                }
                return
            }

            "+" -> {
                if (isCalculatorOn) {
                    currentNumber = _ResultText.value?.toDoubleOrNull()
                    if (previousNumber != null && currentNumber != null && operator != null) {
                        previousNumber = performOperation(previousNumber!!, currentNumber!!, operator!!)
                        _ResultText.value = previousNumber.toString()
                    } else {
                        previousNumber = currentNumber
                    }
                    operator = btn
                    currentNumber = null
                    _ResultText.value = "0.0"
                }
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
                    currentNumber = null
                    _ResultText.value = "0.0"
                }
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
                    currentNumber = null
                    _ResultText.value = "0.0"
                }
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
                    currentNumber = null
                    _ResultText.value = "0.0"
                }
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

            }

            "CE" -> {
                if (isCalculatorOn) {

                    if(_ResultText.value?.endsWith(".") == true && _ResultText.value?.startsWith("0") == true){
                        _ResultText.value += "0"
                    } else {
                        _ResultText.value = _ResultText.value?.dropLast(1)?.ifEmpty { "0.0" }
                    }

                    if (_ResultText.value?.endsWith(".") == true){
                        _ResultText.value = _ResultText.value?.dropLast(1)?.ifEmpty { "0.0" }
                    }
                }
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
            }

            "=" -> {
                if (isCalculatorOn) {
                    currentNumber = _ResultText.value?.toDoubleOrNull()
                    if (previousNumber != null && currentNumber != null && operator != null) {
                        currentNumber = performOperation(previousNumber!!, currentNumber!!, operator!!)
                        previousNumber = _ResultText.value?.toDoubleOrNull()
                        _ResultText.value = currentNumber.toString()
                        operator = null
                    }
                }
            }

            "•" -> {
                if (isCalculatorOn) {
                    // Adiciona . se não existir um .
                    if (!_ResultText.value?.contains(".")!!) {
                        // Se o resultado atual for "0.0", substitui por "0."
                        if (_ResultText.value == "0.0") {
                            _ResultText.value = "0."
                        } else {
                            _ResultText.value += "."
                        }
                    }
                }
            }
        }

        if (isCalculatorOn) {
            // Verificar se o botão pressionado é um número ou um ponto decimal antes de atualizar o display
            if (btn.matches(Regex("[0-9•]"))) {
                if (_ResultText.value == "0.0") {
                    _ResultText.value = btn
                } else {
                    _ResultText.value += btn
                }
            }
        }

    }

    private fun updateLastTwoButtons(btn: String) {
        // armazenar os ultimos 2 botões clicados
        if (lastTwoButtons.size >= 2) {
            lastTwoButtons.removeAt(0)
        }
        lastTwoButtons.add(btn)
    }

    private fun performOperation(num1: Double, num2: Double, op: String): Double {
        return when (op) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "x" -> num1 * num2
            "÷" -> if (num2 == 0.0) {
                throw ArithmeticException("Cannot divide by zero")
            } else {
                num1 / num2
            }
            else -> num1
        }
    }
}
