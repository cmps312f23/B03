package com.cmps312.vmtutorial.ui.screen.student

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.cmps312.vmtutorial.ui.viewmodel.StudentViewModel

@Composable
fun DetailScreen(viewModel: StudentViewModel){
    Column {
        Text(text = viewModel.selectedStudent.name)
        Text(text = viewModel.selectedStudent.age.toString())
        Text(text = viewModel.selectedStudent.gender)
    }
}