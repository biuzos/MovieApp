package br.com.movieapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.movieapp.ui.R.drawable.ic_error_image
import br.com.movieapp.ui.R.drawable.ic_placeholder
import br.com.movieapp.ui.components.AsyncImageUrl
import coil.compose.AsyncImage
import coil.request.ImageRequest

@Composable
fun MovieDetailsBackdropImage(
    backdropImageUrl: String,
    modifier: Modifier,
) {
    Box(modifier = modifier) {
        AsyncImageUrl(
            imageUrl = backdropImageUrl,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
    }
}


@Preview
@Composable
fun MovieDetailsBackdropImagePreview() {
    MovieDetailsBackdropImage(
        backdropImageUrl = "",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    )
}