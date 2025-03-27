package com.example.basiccalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basiccalculator.ui.theme.BasicCalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorApp()
        }
    }
}

@Composable
fun CalculatorApp() {
    var num1 by remember { mutableStateOf(TextFieldValue("")) }
    var num2 by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Aplikasi Kalkulator Sederhana",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("Masukkan angka pertama") }
        )
        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("Masukkan angka kedua") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Button(onClick = {
                result = calculate(num1.text, num2.text, "+")
            }) { Text("add") }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                result = calculate(num1.text, num2.text, "-")
            }) { Text("sub") }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                result = calculate(num1.text, num2.text, "*")
            }) { Text("mul") }

            Spacer(modifier = Modifier.width(8.dp))

            Button(onClick = {
                result = calculate(num1.text, num2.text, "/")
            }) { Text("div") }
        }

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Hasil: $result", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(30.dp))
        Text("👨🏻‍💻 by : ")
        Spacer(modifier = Modifier.height(16.dp))
        Text("Arfi Raushani Fikra (5025211084) - PPB G 2025")
    }
}

fun calculate(n1: String, n2: String, operator: String): String {
    val num1 = n1.toDoubleOrNull()
    val num2 = n2.toDoubleOrNull()

    if (num1 == null || num2 == null) {
        return "Masukkan angka yang valid!"
    }

    return when (operator) {
        "+" -> (num1 + num2).toString()
        "-" -> (num1 - num2).toString()
        "*" -> (num1 * num2).toString()
        "/" -> if (num2 != 0.0) (num1 / num2).toString() else "Tidak bisa bagi 0"
        else -> "Operasi tidak valid"
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorApp()
}