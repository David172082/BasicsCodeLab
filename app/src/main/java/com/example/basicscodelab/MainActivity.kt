package com.example.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    val itemsList = List(1000) { "Elemento #$it" }
    LazyColumn {
        items(itemsList) { item ->
            Text(text = item)
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