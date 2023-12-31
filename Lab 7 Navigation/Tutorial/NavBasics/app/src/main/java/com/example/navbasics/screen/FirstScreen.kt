package com.example.navbasics.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.navbasics.ui.theme.NavBasicsTheme

@Composable
fun FirstScreen(modifier: Modifier = Modifier) {
    Box(
        Modifier.background(MaterialTheme.colorScheme.primary).fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            "First Screen",
            fontSize = 35.sp,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun FirstScreenPreview() {
    NavBasicsTheme {
        FirstScreen()
    }
}