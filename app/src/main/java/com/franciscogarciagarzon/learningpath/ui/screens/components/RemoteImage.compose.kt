package com.franciscogarciagarzon.learningpath.ui.screens.components

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size

@Composable
fun RemoteImage(
    modifier: Modifier = Modifier,
    imageUrl: String,
    @DrawableRes placeholderResource: Int,
    @DrawableRes errorResource: Int,
    contentDescription: String
) {
    // AsyncImage in its simplest form (just feeding it url + content description) didn't keep the images size when scrolling back and forth
    // this way we find the sizes don't change for our current tasks

    // you might want to research "Compose, State, and Recomposition"

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(
                imageUrl.ifEmpty { placeholderResource }
            )
            .crossfade(true)
            .placeholder(placeholderResource)
            .error(errorResource)
            .size(Size.ORIGINAL)
            .build()
    )
    val state = painter.state
    when (state) {
        is AsyncImagePainter.State.Loading -> {
            Log.d("RemoteImage", "loading: ${state.painter}   ")
            CircularProgressIndicator()
        }

        is AsyncImagePainter.State.Error -> {

            Log.w("RemoteImage", "error loading: ${state.result.throwable.message}")
        }

        AsyncImagePainter.State.Empty -> {
            Log.d("RemoteImage", "empty: ${state.painter}  ${imageUrl} ")
        }

        is AsyncImagePainter.State.Success -> {
            Log.i("RemoteImage", "success: ${state.result}")
        }
    }

    Image(
        painter = painter,
        contentDescription = contentDescription,
        contentScale = ContentScale.FillHeight,
        modifier = Modifier
//            .fillMaxHeight(0.8f)
            .aspectRatio(1f)
            .width(IntrinsicSize.Min)

    )
}