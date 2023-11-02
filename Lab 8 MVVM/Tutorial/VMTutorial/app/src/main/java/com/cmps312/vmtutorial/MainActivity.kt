package com.cmps312.vmtutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cmps312.vmtutorial.ui.screen.student.DetailScreen
import com.cmps312.vmtutorial.ui.screen.student.StudentList
import com.cmps312.vmtutorial.ui.theme.VMTutorialTheme
import com.cmps312.vmtutorial.ui.viewmodel.StudentViewModel

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

@Composable
fun VMBasics(name: String, modifier: Modifier = Modifier) {
    val studentViewModel: StudentViewModel = viewModel()
    Column {
        StudentList(studentViewModel)
        DetailScreen(viewModel = studentViewModel)
    }
}

@Preview(showBackground = true)
@Composable
fun VMBasicsPreview() {
    VMTutorialTheme {
        VMBasics("Android")
    }
}