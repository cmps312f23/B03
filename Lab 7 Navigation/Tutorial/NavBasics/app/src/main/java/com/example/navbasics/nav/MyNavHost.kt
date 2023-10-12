package com.example.navbasics.nav

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.navbasics.screen.CartScreen
import com.example.navbasics.screen.FirstScreen
import com.example.navbasics.screen.Screen
import com.example.navbasics.screen.SecondScreen

@Composable
fun MyNavHost(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController = navController,
        startDestination = Screen.FirstScreen.route
    ) {
        composable(route = Screen.FirstScreen.route) {
            FirstScreen()
        }
        composable(route = Screen.SecondScreen.route) {
            SecondScreen()
        }
        composable(route = Screen.CartScreen.route) {
            CartScreen()
        }



    }
        Button(onClick = {
            navController.navigate("first-screen")}) {

        }
}