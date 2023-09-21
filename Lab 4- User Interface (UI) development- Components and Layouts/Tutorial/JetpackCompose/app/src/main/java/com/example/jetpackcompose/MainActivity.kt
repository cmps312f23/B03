package com.example.jetpackcompose

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
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
import androidx.compose.ui.Modifier
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

    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = modifier
    ) {
        LazyColumn {
            items(names) {
                Greeting(it)
            }
        }
//       Column {
//           names.forEach {
//               Greeting(it)
//           }
//       }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var expanded by rememberSaveable { mutableStateOf(false) }

    Surface(
        color = MaterialTheme.colorScheme.primary,
        modifier = modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .fillMaxWidth()
    ) {
        Row {
            Column(modifier = Modifier
                .weight(1f)
                .padding(10.dp)) {
                Text(
                    text = "Hello Mr. $name!",
                    modifier = modifier.padding(bottom = 10.dp)
                )
                Text(text = "Bio : This person was born in the year of bla bla bla and he gradualted from bla blu bla")
            }
            ElevatedButton(onClick = {
                expanded = !expanded
                Log.d("ButtonInfo", "I am clicked from : $name , value of expanded = $expanded")
            }, modifier = modifier.padding(24.dp)) {
                Text(text = if (expanded) "Show Less" else "Show More")
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