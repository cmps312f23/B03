package com.cmps312.litquest.repo

import android.content.Context
import com.cmps312.litquest.model.Book

object BookRepo {
    var books = mutableListOf<Book>()

    fun getBooks(context: Context): List<Book> {
        TODO()
    }

    fun updateBook(context: Context, updatedBook: Book) {
        TODO()
    }

    fun getBooksByCategory(context: Context, category: String): List<Book> =TODO()

}