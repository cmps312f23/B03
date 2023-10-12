package com.example.navbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.navbasics.nav.MyNavHost
import com.example.navbasics.screen.FirstScreen
import com.example.navbasics.screen.Screen
import com.example.navbasics.screen.SecondScreen
import com.example.navbasics.ui.theme.NavBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    var screenNo by remember {
        mutableIntStateOf(1)
    }

    val screens = listOf(
        Screen.FirstScreen,
        Screen.SecondScreen,
        Screen.CartScreen
    )
    Scaffold(
        bottomBar = {
            NavigationBar {

                screens.forEach {
                    NavigationBarItem(
                        selected = false,
                        onClick = {
                            navController.navigate(it.route)
                        },
                        icon = {
                            Icon(
                                imageVector = it.icon,
                                contentDescription = it.title
                            )
                        },
                        label = { Text("Label") }
                    )
                }
            }
        }
    ) {
        MyNavHost(
            navController = navController,
            modifier = modifier.padding(it)
        )

    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MyAppPreview() {
    NavBasicsTheme {
        MyApp()
    }
}