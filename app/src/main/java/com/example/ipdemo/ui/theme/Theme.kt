package com.example.ipdemo.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

private val DarkColorPalette = darkColors(
    primary = Purple200,
    primaryVariant = Purple700,
    secondary = Teal200
)

private val LightColorPalette = lightColors(
    primary = Purple500,
    primaryVariant = Purple700,
    secondary = Teal200

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun IPDemoTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        LightColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

val bodyXSBoldTextStyle = TextStyle(
    fontFamily = fontRoboto,
    fontSize = 16.sp,
    color = ColorTextPrimary,
    fontWeight = FontWeight.W700,
    lineHeight = 23.sp,
    letterSpacing = .5.sp,
    textAlign = TextAlign.Left
)

val darkButtonTextStyle = TextStyle(
    fontFamily = fontRoboto,
    fontSize = 16.sp,
    color = Color.White,
    fontWeight = FontWeight.Bold,
    lineHeight = 23.sp,
    letterSpacing = .5.sp,
    textAlign = TextAlign.Left,
)