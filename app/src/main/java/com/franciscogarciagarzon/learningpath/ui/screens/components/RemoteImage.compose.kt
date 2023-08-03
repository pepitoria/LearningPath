package com.franciscogarciagarzon.learningpath.ui.screens.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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

    val painter = remember {
        mutableStateOf<AsyncImagePainter?>(null)
    }

    painter.value = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(
                imageUrl.ifEmpty { errorResource }
            )
            .crossfade(true)
            .placeholder(placeholderResource)
            .size(Size.ORIGINAL)
            .build()
    )

    Image(
        painter = painter.value as AsyncImagePainter,
        contentDescription = contentDescription,
        contentScale = ContentScale.FillHeight,
        modifier = Modifier
//            .fillMaxHeight(0.8f)
            .aspectRatio(1f)
            .width(IntrinsicSize.Min)

    )
}