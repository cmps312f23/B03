package com.cmps312.vmtutorial.repo

import com.cmps312.vmtutorial.model.Student

object StudentRepo {
    private val students = listOf(
        Student("John", 20, "Male"),
        Student("Jane", 21, "Female"),
        Student("Jack", 22, "Male")
    )

    fun getStudents() = students
}