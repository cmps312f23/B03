package com.cmps312.litquest.ui.screen

import android.widget.Toast
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.cmps312.litquest.model.Book
import com.cmps312.litquest.repo.BookRepo
import com.cmps312.litquest.ui.theme.LitQuestTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateBookForm(
    book: Book,
    onUpdateBook: (Book) -> Unit
) {
    TODO()
}

@Preview
@Composable
fun UpdateBookForm() {
    val context = LocalContext.current
    val book = BookRepo.getBooks(context)[0]
    LitQuestTheme {
        UpdateBookForm(book) {
            Toast.makeText(context, "Display the book details", Toast.LENGTH_SHORT).show()
        }
    }
}
