package com.xsoftcdmx.designsystem.components

import androidx.compose.runtime.*
import androidx.compose.ui.graphics.Color
import android.graphics.drawable.BitmapDrawable
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.palette.graphics.Palette
import coil.ImageLoader
import coil.request.ImageRequest
import coil.size.Size

@Composable
fun rememberDominantColorFromImage(
    imageUrl: String
): Color {
    val context = LocalContext.current
    var gradientColors by remember { mutableStateOf(listOf(Color.Gray, Color.DarkGray)) }

    var dominantColor by remember { mutableStateOf(Color.Gray) }
    LaunchedEffect(imageUrl) {
        try {
            val request = ImageRequest.Builder(context)
                .data(imageUrl)
                .allowHardware(false)
                .size(Size.ORIGINAL)
                .build()
            val result = ImageLoader(context).execute(request)
            val bitmap = (result.drawable as? BitmapDrawable)?.bitmap
            bitmap?.let {
                Palette.from(it).generate { palette ->
                    val color =
                        palette?.getDominantColor(Color.Gray.toArgb()) ?: Color.Gray.toArgb()
                    dominantColor = Color(color).copy(alpha = 0.7f)
                }
            }
        } catch (e: Exception) {
            dominantColor = Color.LightGray
        }
    }
    return dominantColor
}