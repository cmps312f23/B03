package com.cmps312.vmtutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
//class CounterViewModel : ViewModel() {
//    var counter by mutableStateOf(0)
//        private set
//
//    fun incrementCounter() {
//        counter++
//    }
//}

data class Student(val name: String, val age: Int, val gender: String)
object StudentRepo {
    private val students = listOf(
        Student("John", 20, "Male"),
        Student("Jane", 21, "Female"),
        Student("Jack", 22, "Male")
    )

    fun getStudents() = students
}

class StudentViewModel : ViewModel() {
    private val _students = StudentRepo.getStudents().toMutableStateList()
    val students: List<Student> = _students

    fun addStudent(student: Student) {
        _students.add(student)
    }
}

@Composable
fun StudentList(viewModel: StudentViewModel) {
    LazyColumn {
        items(viewModel.students) {
            Text(
                text = it.name, fontSize = 20.sp,
                modifier = Modifier.padding(16.dp).height(20.dp)
            )
        }
    }
}

@Composable
fun VMBasics(name: String, modifier: Modifier = Modifier) {
    val studentViewModel : StudentViewModel = viewModel()
    StudentList(studentViewModel)
//    we need a state
//    var counter by rememberSaveable { mutableStateOf(0) }
//create an instance of the view model [inject] dependency graidle
//    val counterVM: CounterViewModel = viewModel()
//    Text(
//        text = "Number of times clicked = ${counterVM.counter.value}",
//        modifier = modifier.clickable {
//            counterVM.incrementCounter()
//        }
//    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VMTutorialTheme {
        VMBasics("Android")
    }
}