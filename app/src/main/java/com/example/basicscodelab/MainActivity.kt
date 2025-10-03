package com.example.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.basicscodelab.ui.theme.BasicsCodeLabTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodeLabTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    var expanded by remember { mutableStateOf(false) }
    ExpandableItem(expanded = expanded, onExpandChange = { expanded = it })
}

@Composable
fun ExpandableItem(expanded: Boolean, onExpandChange: (Boolean) -> Unit) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = { onExpandChange(!expanded) }) {
                Text(if (expanded) "Mostrar menos" else "Mostrar más")
            }
            if (expanded) {
                Text("Contenido expandido...")
            }
        }
    }
}

@Preview
@Composable
fun PreviewMyApp() {
    BasicsCodeLabTheme {
        MyApp()
    }
}