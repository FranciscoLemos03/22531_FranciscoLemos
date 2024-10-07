package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.IntegerRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                    CalculateShape(7.10)
            }
        }
    }
}


@Composable
fun CalculateShape(number: Double, modifier: Modifier = Modifier) {

    Column {
        Text(
            text = "$number",
            modifier = modifier
        )
        Row {
            ElevatedButton(onClick = { }) {
                Text("MRC")
            }
            ElevatedButton(onClick = { }) {
                Text("M-")
            }
            ElevatedButton(onClick = { }) {
                Text("M+")
            }
            ElevatedButton(onClick = { }) {
                Text("ON/C")
            }
        }
        Row {
            ElevatedButton(onClick = { }) {
                Text("√")
            }
            ElevatedButton(onClick = { }) {
                Text("%")
            }
            ElevatedButton(onClick = { }) {
                Text("+/-")
            }
            ElevatedButton(onClick = { }) {
                Text("CE")
            }
        }
        Row {
            ElevatedButton(onClick = { }) {
                Text("7")
            }
            ElevatedButton(onClick = { }) {
                Text("8")
            }
            ElevatedButton(onClick = { }) {
                Text("9")
            }
            ElevatedButton(onClick = { }) {
                Text("÷")
            }
        }
        Row {
            ElevatedButton(onClick = { }) {
                Text("4")
            }
            ElevatedButton(onClick = { }) {
                Text("5")
            }
            ElevatedButton(onClick = { }) {
                Text("6")
            }
            ElevatedButton(onClick = { }) {
                Text("x")
            }
        }
        Row {
            ElevatedButton(onClick = { }) {
                Text("1")
            }
            ElevatedButton(onClick = { }) {
                Text("2")
            }
            ElevatedButton(onClick = { }) {
                Text("3")
            }
            ElevatedButton(onClick = { }) {
                Text("-")
            }
        }
        Row {
            ElevatedButton(onClick = { }) {
                Text("0")
            }
            ElevatedButton(onClick = { }) {
                Text("•")
            }
            ElevatedButton(onClick = { }) {
                Text("=")
            }
            ElevatedButton(onClick = { }) {
                Text("+")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculateShape(7.10)
}