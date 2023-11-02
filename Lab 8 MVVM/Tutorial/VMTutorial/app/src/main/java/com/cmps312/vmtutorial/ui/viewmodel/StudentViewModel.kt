package com.cmps312.vmtutorial.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.cmps312.vmtutorial.model.Student
import com.cmps312.vmtutorial.repo.StudentRepo

class StudentViewModel : ViewModel() {
    private val _students = StudentRepo.getStudents().toMutableStateList()
    val students: List<Student> = _students

    fun addStudent(student: Student) {
        _students.add(student)
    }
}
