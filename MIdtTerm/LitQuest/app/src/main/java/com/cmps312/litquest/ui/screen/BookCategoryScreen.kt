package com.cmps312.litquest.ui.screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cmps312.litquest.ui.theme.LitQuestTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CategoryListScreen(selectedCategory: (String) -> Unit) {
    val bookCategories = listOf("Java", "Software Engineering", "Internet" , "Web Development")
    TODO()
}

@Composable
fun CategoryCard(category: String, onCategorySelected: () -> Unit) {
    TODO()
}




@Preview
@Composable
fun CategoryScreenPreview() {
    LitQuestTheme {
        CategoryListScreen {

        }
    }
}
@Preview
@Composable
fun CategoryCardScreenPreview() {
    LitQuestTheme {
        CategoryCard("Java"){

        }
    }
}

