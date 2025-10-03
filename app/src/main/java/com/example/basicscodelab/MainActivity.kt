package com.example.basicscodelab

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
    var expanded by rememberSaveable { mutableStateOf(false) }
    val itemsList = List(20) { "Elemento #$it" }
    val extraPadding by animateDpAsState(
        if (expanded) 48.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    LazyColumn(modifier = Modifier.padding(bottom = extraPadding)) {
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