package com.example.calculator.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


//Lista dos botões
val buttonOpList = listOf(
    "MRC","M-","M+","ON/C",
    "√","%","+/-","CE",
    "7","8","9","÷",
    "4","5","6","x",
    "1","2","3","-",
    "0","•","=","+",
)

//Função Reutilizavel para o design dos botões
@Composable
fun CalculatorBtn(icon: String, onClick : ()-> Unit){
    Row (modifier = Modifier.padding(3.dp)){
        ElevatedButton(onClick = onClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = btnColor(icon)
            ), modifier = Modifier.weight(1f)) {
            Text(text = icon)
        }
    }
}

//Função para mudar corretamente a cor dos botões
fun btnColor(btn: String) : Color {

    // forma mais simples de fazer um if/elseif
    return when (btn) {
        "ON/C", "CE" -> {
            Color(0xFFe24e70)
        }
        "MRC", "M-", "M+", "√", "%", "+/-", "÷", "x", "-", "+" -> {
            Color.Black
        }
        else -> {
            Color(0xFF777779)
        }
    }

}