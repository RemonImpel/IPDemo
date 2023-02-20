package com.example.ipdemo.Screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Path
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ipdemo.Utils.ScreenSize
import com.example.ipdemo.ui.theme.blueButton
import com.example.ipdemo.ui.theme.lightGreen
import com.example.ipdemo.ui.theme.gradientBottomColor

@Composable
fun instagramIcon() {
    val instaColors = listOf(blueButton, gradientBottomColor, lightGreen)
    Canvas(
        modifier = Modifier
            .size(ScreenSize.width().dp)
            .padding(16.dp)
    ) {
        val width = size.width
        val height = size.height
        val path = Path().apply {
            moveTo(width.times(.76f), height.times(.72f))
            cubicTo(
                width.times(.93f),
                height.times(.72f),
                width.times(.98f),
                height.times(.41f),
                width.times(.76f),
                height.times(.40f)
            )
            cubicTo(
                width.times(.75f),
                height.times(.21f),
                width.times(.35f),
                height.times(.21f),
                width.times(.38f),
                height.times(.50f)
            )
            cubicTo(
                width.times(.25f),
                height.times(.50f),
                width.times(.20f),
                height.times(.69f),
                width.times(.41f),
                height.times(.72f)
            )
            close()
        }

        drawPath(path = path, color = blueButton.copy(alpha = .90f))
    }
}


@Preview(showBackground = true)
@Composable
fun InstaPreview() {
    instagramIcon()
}