package com.cmps312.vmtutorial.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import com.cmps312.vmtutorial.model.Student
import com.cmps312.vmtutorial.repo.StudentRepo

class StudentViewModel : ViewModel() {
    private val _students = StudentRepo.getStudents().toMutableStateList()
    val students: List<Student> = _students

    var selectedStudent by mutableStateOf(_students[0])

    fun addStudent(student: Student) {
        _students.add(student)
    }
}
