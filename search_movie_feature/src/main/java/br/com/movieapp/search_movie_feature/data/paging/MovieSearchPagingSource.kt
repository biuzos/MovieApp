package br.com.movieapp.search_movie_feature.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import br.com.movieapp.search_movie_feature.data.model.MovieSearch
import br.com.movieapp.search_movie_feature.domain.source.MovieSearchRemoteDataSource


class MovieSearchPagingSource(
    private val query: String,
    private val movieSearchRemoteDataSource: MovieSearchRemoteDataSource
) : PagingSource<Int, MovieSearch>() {

    override fun getRefreshKey(state: PagingState<Int, MovieSearch>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(MovieSearchPagingSource.LIMIT) ?: anchorPage?.nextKey?.minus(
                MovieSearchPagingSource.LIMIT
            )
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, MovieSearch> {
        return try {
            val pageNumber = params.key ?: 1

            val response =
                movieSearchRemoteDataSource.getSearchMovies(query = query, page = pageNumber)
            val movies = response.movies
            val totalPages = response.totalPages

            LoadResult.Page(
                data = movies,
                prevKey = if (pageNumber == 1) null else pageNumber - 1,
                nextKey = if (pageNumber == totalPages) null else pageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object {
        private const val LIMIT = 20
    }
}