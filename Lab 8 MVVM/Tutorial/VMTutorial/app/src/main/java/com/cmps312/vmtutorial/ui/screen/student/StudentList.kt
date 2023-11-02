package com.cmps312.vmtutorial.ui.screen.student

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmps312.vmtutorial.model.Student
import com.cmps312.vmtutorial.ui.viewmodel.StudentViewModel
import kotlin.random.Random

@Composable
fun StudentList(viewModel: StudentViewModel) {
    LazyColumn {
        items(viewModel.students) {student->
            Text(
                text = student.name, fontSize = 20.sp,
                modifier = Modifier
                    .padding(16.dp)
                    .height(40.dp)
                    .clickable {
                        viewModel.selectedStudent = student
                    }
            )
            Divider(Modifier.background(Color.Gray).height(3.dp))
        }
    }
}
