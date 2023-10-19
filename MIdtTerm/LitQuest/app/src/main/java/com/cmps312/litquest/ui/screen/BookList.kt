package com.cmps312.litquest.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmps312.litquest.model.Book
import com.cmps312.litquest.repo.BookRepo
import com.cmps312.litquest.ui.theme.LitQuestTheme


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BookList(
    contentPaddingValues: PaddingValues,
    books: List<Book>,
    updateBook: (Book) -> Unit,
) {
    TODO()
}

@Composable
fun BookCard(book: Book, onUpdateBook: (Book) -> Unit) {
    TODO()
}

@Preview(showBackground = true)
@Composable
fun BookListPreview() {
    val books = BookRepo.getBooks(LocalContext.current)
    LitQuestTheme {
        BookList(
            contentPaddingValues = PaddingValues(10.dp),
            books = books,
            updateBook = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BookCardPreview() {
    val book = BookRepo.getBooks(LocalContext.current)[0]
    LitQuestTheme {
        BookCard(
            book = book,
            onUpdateBook = {}
        )
    }
}
