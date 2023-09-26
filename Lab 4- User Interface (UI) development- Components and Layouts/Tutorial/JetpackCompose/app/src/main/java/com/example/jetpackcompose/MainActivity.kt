package com.example.jetpackcompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcompose.ui.theme.JetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTheme {
                MyApp(Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun MyApp(modifier: Modifier = Modifier) {

    var names = (1..20).map { "Name $it" }
    var showOnboarding by rememberSaveable { mutableStateOf(true) }


    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
//        if (showOnboarding)
//             OnboardingScreen(){
//                 showOnboarding = !showOnboarding
//             }
//        else
        LazyColumn {
            items(names) {
                Greeting(it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreen(modifier: Modifier = Modifier, changeShowOnBoard: (Boolean) -> Unit = {}) {
    Card {
        Column(
            modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Welcome to Jetpack Compose", modifier = modifier)
            ElevatedButton(onClick = { changeShowOnBoard(false) }) {
                Text(text = "Continue")
            }
        }

    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Surface(
        color = MaterialTheme.colorScheme.background,
    ) {
        Card(
            modifier = modifier
                .padding(vertical = 4.dp, horizontal = 8.dp)
                .fillMaxWidth().animateContentSize()
        ) {
            Row {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.person),
                        contentDescription = "Person Image",
                        modifier
                            .size(100.dp)
                            .clip(CircleShape)
                            .border(1.5.dp , MaterialTheme.colorScheme.background, shape = CircleShape)
                    )
                    Text(
                        text = "Hello Mr. $name!",
                        modifier = modifier.padding(bottom = 10.dp)
                    )
                    if (expanded)
                        Text(text = "Bio : This person was born in the year of bla bla bla and he gradualted from bla blu bla",
                            )
                }
                Button(onClick = {
                    expanded = !expanded
                    Log.d("ButtonInfo", "I am clicked from : $name , value of expanded = $expanded")
                }, modifier = modifier.padding(24.dp)
                    .align(Alignment.CenterVertically)) {
                    Text(text = if (expanded) "Show Less" else "Show More")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppPreview() {
    JetpackComposeTheme {
        MyApp()
    }
}