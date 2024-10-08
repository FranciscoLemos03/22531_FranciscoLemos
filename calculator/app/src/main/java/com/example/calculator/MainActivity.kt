package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                CalculateShape(0.0)
            }
        }
    }
}

val buttonOpList = listOf(
    "MRC","M-","M+","ON/C",
    "√","%","+/-","CE",
    "7","8","9","÷",
    "4","5","6","x",
    "1","2","3","-",
    "0","•","=","+",
)

@Composable
fun CalculatorBtn(icon: String){
    Row (modifier = Modifier.padding(3.dp)){
        ElevatedButton(onClick = { },
            colors = ButtonDefaults.buttonColors(
                containerColor = btnColor(icon)
            ), modifier = Modifier.weight(1f)) {
            Text(text = icon)
        }
    }
}

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


@Composable
fun CalculateShape(number: Double) {

    Column(
        modifier = Modifier
        .fillMaxWidth()
        .background(Color.LightGray)
        .wrapContentSize(Alignment.Center)
    ) {
        Row ( modifier = Modifier.fillMaxWidth() .wrapContentSize(Alignment.Center)) {
            Text(
                text = "$number",
                fontSize = 25.sp,
                modifier = Modifier.padding(3.dp),
                textAlign = TextAlign.Center
            )
        }
        LazyVerticalGrid(columns = GridCells.Fixed(4)) {
            items(buttonOpList){
                CalculatorBtn(icon = it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculateShape(0.0)
}