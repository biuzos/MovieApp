package br.com.movieapp.movie_popular_feature.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import br.com.movieapp.core.domain.model.Movie
import br.com.movieapp.core.presentation.components.common.ErrorScreen
import br.com.movieapp.core.presentation.components.common.LoadingItem

@Composable
fun MovieContent(
    modifier: Modifier = Modifier,
    pagingMovies: LazyPagingItems<Movie>,
    paddingValues: PaddingValues,
    onClick: (movieId: Int) -> Unit
) {
    Box(
        modifier = modifier
            .background(Color.Black)
    ) {
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            contentPadding = paddingValues,
            horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            items(pagingMovies.itemCount) { index ->
                val movies = pagingMovies[index]
                movies?.let {
                    MovieItem(
                        modifier = Modifier,
                        voteAverage = it.voteAverage,
                        imageUrl = it.imageUrl,
                        id = it.id,
                        onClick = { movieId ->
                            onClick(movieId)
                        }
                    )
                }
            }
            pagingMovies.apply {
                when {
                    loadState.refresh is LoadState.Loading -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            LoadingItem()
                        }
                    }

                    loadState.append is LoadState.Loading -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            LoadingItem()
                        }
                    }

                    loadState.refresh is LoadState.Error -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            ErrorScreen(message = "verifique sua conexão com a internet",
                                retry = {
                                    retry()
                                })
                        }
                    }

                    loadState.append is LoadState.Loading -> {
                        item(
                            span = {
                                GridItemSpan(maxLineSpan)
                            }
                        ) {
                            ErrorScreen(
                                message = "",
                                retry = {
                                    retry()
                                })
                        }
                    }
                }
            }
////                    loadState.refresh is androidx.paging.LoadState.Error -> {
////                        val e = pagingMovies.loadState.refresh as androidx.paging.LoadState.Error
////                        item {
////                            ErrorItem(
////                                message = e.error.localizedMessage ?: "Unknown error",
////                                modifier = Modifier.fillMaxSize(),
////                                onClickRetry = { retry() }
////                            )
////                        }
////                    }
////                    loadState.append is androidx.paging.LoadState.Error -> {
////                        val e = pagingMovies.loadState.append as androidx.paging.LoadState.Error
////                        item {
////                            ErrorItem(
////                                message = e.error.localizedMessage ?: "Unknown error",
////                                modifier = Modifier.fillMaxSize(),
////                                onClickRetry = { retry() }
////                            )
////                        }
////                    }
////                }
//            }
        }
    }
}

//@Preview
//@Composable
//fun MovieContentPreview() {
//    MovieContent(pagingMovies = )
//}