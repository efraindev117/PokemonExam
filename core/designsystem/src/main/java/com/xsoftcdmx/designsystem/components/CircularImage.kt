package com.xsoftcdmx.designsystem.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import coil.transform.CircleCropTransformation

@Composable
fun CircularImage(
    modifier: Modifier = Modifier.size(64.dp),
    imageUrl: String?,
    text: String?,
    placeholder: @Composable () -> Unit,
    textColor: Color = Color.White,

    ) {
    val initials = getInitials(text)
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .size(Size.ORIGINAL)
            .transformations(CircleCropTransformation())
            .build()
    )

    Box(
        modifier = modifier
            .background(Color.Transparent, shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        when (painter.state) {
            is AsyncImagePainter.State.Success -> {
                Image(
                    painter = painter,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.matchParentSize()
                )
            }

            is AsyncImagePainter.State.Error,
            is AsyncImagePainter.State.Empty -> {
                if (initials != null) {
                    DisplayInitials(initials, textColor)
                } else {
                    placeholder()
                }
            }

            else -> Unit
        }
    }
}

@Composable
fun DisplayInitials(initials: String, textColor: Color) {
    BasicText(
        text = initials,
        style = TextStyle(
            color = textColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
    )
}

fun getInitials(text: String?): String? {
    val words = text.orEmpty().trim().split(" ").filter { it.isNotEmpty() }
    return when (words.size) {
        0 -> null
        1 -> words[0].take(2).uppercase()
        else -> "${words[0][0]}${words[1][0]}".uppercase()
    }.takeIf { it!!.all(Char::isLetter) }
}
