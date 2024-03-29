package com.pushpak.image_preview

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp

@Composable
fun ImagePreview(
    str: Painter,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(size = 10.dp))
            .shadow(shape = RoundedCornerShape(15.dp), elevation = 15.dp)
    ) {
        Image(painter = str,
            contentDescription = "This is demo",
            contentScale = ContentScale.Crop,
            modifier= Modifier.fillMaxSize())
    }
}