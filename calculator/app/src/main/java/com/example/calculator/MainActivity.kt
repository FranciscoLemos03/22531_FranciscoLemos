package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import com.example.calculator.models.Functions
import com.example.calculator.ui.CalculateShape
import com.example.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val btnFunctions = ViewModelProvider(owner = this)[Functions::class.java]
        enableEdgeToEdge()
        setContent {
            CalculatorTheme {
                CalculateShape(btnFunctions)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val previewViewModel = Functions()
    CalculateShape(previewViewModel)
}

