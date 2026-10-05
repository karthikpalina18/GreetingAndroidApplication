package com.example.greetingapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.greetingapp.ui.theme.GreetingAppTheme
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GreetingAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingApp()
                }
            }
        }
    }
}
@Composable
fun GreetingApp() {
    var name by remember { mutableStateOf("") }
    var showGreeting by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(text = "Enter your name:")

        TextField(
            value = name,
            onValueChange = { name = it }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { showGreeting = true }
        ) {
            Text("Say Hello")
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (showGreeting && name.isNotEmpty()) {
            Text(text = "Hello $name 👋")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GreetingAppTheme {
        GreetingApp()
    }
}