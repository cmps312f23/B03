package com.example.navbasics.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ScreenShare
import androidx.compose.material.icons.filled.Security
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object FirstScreen : Screen("first-screen", "First Screen", Icons.Default.ScreenShare)
    object SecondScreen : Screen("second-screen", "Second Screen", Icons.Default.Security)
    object CartScreen : Screen("cart-screen", "Cart Screen", Icons.Default.ShoppingCart)
}
