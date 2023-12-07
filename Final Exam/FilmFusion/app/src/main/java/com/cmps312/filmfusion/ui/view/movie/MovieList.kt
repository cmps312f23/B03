package com.cmps312.filmfusion.ui.view.movie

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cmps312.filmfusion.entity.Movie
import com.cmps312.filmfusion.repository.FilmFusionRepo
import com.cmps312.filmfusion.ui.theme.FilmFusionTheme


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun MovieList(
    contentPaddingValues: PaddingValues,
    movies: List<Movie>,
    onUpdateMovie: (Movie) -> Unit,
    onAddMovie: (Movie) -> Unit,
    showMovieDetail: (Movie) -> Unit
) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "")
        }
    }) { contentPaddingValues ->
        LazyColumn(
            modifier = Modifier.padding(contentPaddingValues)
        ) {
            items(movies) {
                MovieCard(
                    movie = it,
                    onEditMovie = { movie ->
                        onUpdateMovie(movie)
                    },
                    onShowDetail = { movie ->
                        showMovieDetail(movie)
                    }
                )
            }
        }
    }
}


@Composable
fun MovieCard(movie: Movie, onEditMovie: (Movie) -> Unit, onShowDetail: (Movie) -> Unit) {
    val litQuestRepo = FilmFusionRepo(LocalContext.current)
    val genreName = litQuestRepo.getGenre(movie.genreId).name


    ElevatedCard(
        modifier = Modifier
            .padding(10.dp, 5.dp, 10.dp, 10.dp)
            .clickable {
                onShowDetail(movie)
            }
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp, 5.dp, 10.dp, 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            //    get image using a name from resource folder
            val imageId = LocalContext.current.resources.getIdentifier(
                movie.poster,
                "drawable",
                LocalContext.current.packageName
            )


            Image(
                painter = painterResource(imageId),
                contentDescription = null, // decorative
                contentScale = ContentScale.FillHeight,
                modifier = Modifier
                    .heightIn(max = 150.dp)
                    .fillMaxHeight()
            )
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
//                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(text = "Director : ${movie.director}", fontStyle = FontStyle.Italic)
                Text(text = "Movie Rating : ${movie.rating}/10", fontWeight = FontWeight.ExtraBold)
                Text(text = "Genre : $genreName", fontWeight = FontWeight.ExtraBold)
                Icon(
                    imageVector = Icons.Filled.Edit, contentDescription = "Edit",
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.End)
                        .clickable {
                            onEditMovie(movie)
                        },
                    tint = Color.Red
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun MovieListPreview() {
    val movies = FilmFusionRepo(LocalContext.current).getMovies()
    FilmFusionTheme {
        MovieList(
            contentPaddingValues = PaddingValues(10.dp),
            movies = movies,
            onUpdateMovie = {},
            onAddMovie = {},
            showMovieDetail = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MovieCardPreview() {
    val movie = FilmFusionRepo(LocalContext.current).getMovies()[0]
    FilmFusionTheme {
        MovieCard(
            movie = movie,
            onEditMovie = {},
            onShowDetail = {}
        )
    }
}
