package com.cmps312.filmfusion.ui.view.movie

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cmps312.filmfusion.entity.Movie
import com.cmps312.filmfusion.repository.FilmFusionRepo
import com.cmps312.filmfusion.ui.theme.FilmFusionTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateMovieForm(
    movieToUpdate: Movie,
    onSubmitMovie: (Movie) -> Unit
) {
    val context = LocalContext.current
    val litQuestRepo = FilmFusionRepo(context)

    var title by remember { mutableStateOf(TextFieldValue(movieToUpdate.title)) }
    var director by remember { mutableStateOf(TextFieldValue(movieToUpdate.director)) }
    var image by remember { mutableStateOf(TextFieldValue(movieToUpdate.poster)) }
    var releaseDate by remember { mutableStateOf(TextFieldValue(movieToUpdate.releaseDate)) }
    var genre by remember { mutableStateOf(litQuestRepo.getGenre(movieToUpdate.genreId)) }
    var rating by remember { mutableDoubleStateOf(movieToUpdate.rating) }


    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(10.dp, 5.dp, 10.dp, 10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Movie Details",
                letterSpacing = 3.sp,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleMedium
            )

            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                label = { Text("Title") }
            )

            OutlinedTextField(
                value = director,
                onValueChange = { director = it },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                label = { Text("Director") }
            )

            GenreDropDown(
                selectedGenre = genre,
                onSelectedGenreChange = {
                    genre = it
                })

            OutlinedTextField(
                value = image,
                onValueChange = { image = it },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                label = { Text("Poster Name") }
            )

            OutlinedTextField(
                value = releaseDate,
                onValueChange = { releaseDate = it },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                label = { Text("Release Date") }
            )
            OutlinedTextField(
                value = rating.toString(),
                onValueChange = { rating = it.toDouble() },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth(),
                textStyle = TextStyle(color = Color.Black),
                label = { Text("Rating") }
            )

            Button(
                onClick = {
                    val movie = Movie(
                        title = title.text,
                        director = director.text,
                        releaseDate = releaseDate.text,
                        poster = image.text,
                        rating = movieToUpdate.rating,
                        genreId = genre.id,
                        id = movieToUpdate.id,
                    )
                    onSubmitMovie(movie)
                },
                modifier = Modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            ) {
                Text("Submit Movie")
            }
        }
    }
}

//
@Preview
@Composable
fun UpdateMovieForm() {
    val context = LocalContext.current
    val movie = FilmFusionRepo(context).getMovies()[0]
    FilmFusionTheme {
        UpdateMovieForm(movie) {
            Toast.makeText(context, it.director, Toast.LENGTH_SHORT).show()
        }
    }
}
