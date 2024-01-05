package br.com.movieapp.search_movie_feature.domain.source

import br.com.movieapp.core.data.remote.response.MoviesResponse
import br.com.movieapp.core.data.remote.response.SearchResponse
import br.com.movieapp.core.paging.MovieSearchPagingSource

interface MovieSearchRemoteDataSource {

    fun getSearchMoviesPagingSource(query: String): MovieSearchPagingSource

    suspend fun getSearchMovies(query: String, page: Int): SearchResponse
}