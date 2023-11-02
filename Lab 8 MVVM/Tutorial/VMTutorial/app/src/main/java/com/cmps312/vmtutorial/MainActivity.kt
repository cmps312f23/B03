package com.cmps312.vmtutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cmps312.vmtutorial.ui.theme.VMTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VMTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    VMBasics("Android")
                }
            }
        }
    }
}

//they survive configuration changes
//share amound the different composable
class CounterViewModel : ViewModel() {
    var counter = mutableStateOf(0)
        private set

    fun incrementCounter() {
        counter++
    }
}

@Composable
fun VMBasics(name: String, modifier: Modifier = Modifier) {
//    we need a state
//    var counter by rememberSaveable { mutableStateOf(0) }
//create an instance of the view model [inject] dependency graidle
    val counterVM: CounterViewModel = viewModel()
    Text(
        text = "Number of times clicked = ${counterVM.counter}",
        modifier = modifier.clickable {
            counterVM.incrementCounter()
            counterVM.counter.value = 100
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VMTutorialTheme {
        VMBasics("Android")
    }
}