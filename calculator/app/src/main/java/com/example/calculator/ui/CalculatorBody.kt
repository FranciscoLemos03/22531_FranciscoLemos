package com.example.calculator.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.models.Functions

@Composable
fun CalculateShape(viewModel: Functions) {

    val resultText = viewModel.resultText.observeAsState()

    Column(
        modifier = Modifier
            .fillMaxSize() // Ocupar a tela inteira
            .background(Color(0xFF8f8e8a))
            .wrapContentSize(Alignment.Center),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center)
        ) {
            Text(
                text = resultText.value ?: "",
                fontSize = 25.sp,
                modifier = Modifier.padding(3.dp),
                textAlign = TextAlign.Center
            )
        }
        LazyVerticalGrid(
            columns = GridCells.Fixed(4),
            modifier = Modifier.padding(16.dp) // Margem para centrar
        ) {
            items(buttonOpList) {
                CalculatorBtn(icon = it, onClick = {
                    viewModel.onButtonClick(it)
                })
            }
        }
    }
}