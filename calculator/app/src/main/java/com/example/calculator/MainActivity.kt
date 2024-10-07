package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.IntegerRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
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


@Composable
fun CalculateShape(number: Double, modifier: Modifier = Modifier) {

    Column {
        Row ( modifier = Modifier.fillMaxWidth() .wrapContentSize(Alignment.Center)) {
            Text(
                text = "$number",
                fontSize = 25.sp,
                modifier = Modifier.padding(3.dp),
                textAlign = TextAlign.Center
            )
        }
        Row ( modifier = Modifier.fillMaxWidth()) {

            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                modifier = Modifier.weight(1f)) {
                    Text("MRC")
                }
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                modifier = Modifier.weight(1f)) {
                    Text("M-")
                }

            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                modifier = Modifier.weight(1f)) {
                    Text("M+")
                }

            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                ),
                modifier = Modifier.weight(1f)) {
                Text("ON/C")
            }
        }
        Row ( modifier = Modifier.fillMaxWidth()) {
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                modifier = Modifier.weight(1f)) {
                Text("√")
            }
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                modifier = Modifier.weight(1f)) {
                Text("%")
            }
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                modifier = Modifier.weight(1f)) {
                Text("+/-")
            }
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Red
                ),
                modifier = Modifier.weight(1f)) {
                Text("CE")
            }
        }
        Row ( modifier = Modifier.fillMaxWidth()) {
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                ),
                modifier = Modifier.weight(1f)) {
                Text("7")
            }
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                ),
                modifier = Modifier.weight(1f)) {
                Text("8")
            }
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                ),
                modifier = Modifier.weight(1f)) {
                Text("9")
            }
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                modifier = Modifier.weight(1f)) {
                Text("÷")
            }
        }
        Row ( modifier = Modifier.fillMaxWidth()) {
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                ),
                modifier = Modifier.weight(1f)) {
                Text("4")
            }
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                ),
                modifier = Modifier.weight(1f)) {
                Text("5")
            }
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                ),
                modifier = Modifier.weight(1f)) {
                Text("6")
            }
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                modifier = Modifier.weight(1f)) {
                Text("x")
            }
        }
        Row ( modifier = Modifier.fillMaxWidth()) {
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                ),
                modifier = Modifier.weight(1f)) {
                Text("1")
            }
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                ),
                modifier = Modifier.weight(1f)) {
                Text("2")
            }
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                ),
                modifier = Modifier.weight(1f)) {
                Text("3")
            }
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                modifier = Modifier.weight(1f)) {
                Text("-")
            }
        }
        Row ( modifier = Modifier.fillMaxWidth()) {
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                ),
                modifier = Modifier.weight(1f)) {
                Text("0")
            }
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                ),
                modifier = Modifier.weight(1f)) {
                Text("•")
            }
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Gray
                ),
                modifier = Modifier.weight(1f)) {
                Text("=")
            }
            ElevatedButton(onClick = { },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black
                ),
                modifier = Modifier.weight(1f)) {
                Text("+")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculateShape(0.0)
}