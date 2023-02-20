package com.example.ipdemo.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ipdemo.Modal.ChangeLogResponse
import com.example.ipdemo.R
import com.example.ipdemo.Session.SessionManagement
import com.example.ipdemo.Utils.Constants
import com.example.ipdemo.ui.theme.Components.AppToolbarCompose
import com.example.ipdemo.ui.theme.gradientBottomColor


@Composable
fun ChangeLogDetailsScreen(onBack: () -> Unit) {

    var context = LocalContext.current
    val sessionManagement = SessionManagement(context)
    var version by remember {
        mutableStateOf(sessionManagement.getVersion())
    }
    var msgList = listOf(
        ChangeLogResponse(Constants.lorem_ipsum),
        ChangeLogResponse(Constants.lorem_ipsum),
        ChangeLogResponse(Constants.lorem_ipsum),
        ChangeLogResponse(Constants.lorem_ipsum),
        ChangeLogResponse(Constants.lorem_ipsum),
        ChangeLogResponse(Constants.lorem_ipsum),
        ChangeLogResponse(Constants.lorem_ipsum)
    )


    Scaffold(
        modifier = Modifier.fillMaxSize(),

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White,
                            gradientBottomColor
                        )
                    )
                )

        ) {
            AppToolbarCompose(
                title = Constants.back.capitalize(), onBackClick = onBack
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                Text(
                    text = "What's new?".capitalize(), style = TextStyle(
                        letterSpacing = 1.sp,
                        color = colorResource(id = R.color.default_text_color),
                        fontSize = 18.sp,
                        //fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.roboto_black))
                    )
                )

                Divider(color = Color.Transparent, modifier = Modifier.height(10.dp))

                Text(
                    text = version?.capitalize() ?: "none", style = TextStyle(
                        letterSpacing = 1.sp,
                        color = Color.Gray,
                        fontSize = 18.sp,
                        //fontWeight = FontWeight.Bold,
                        //fontFamily = FontFamily(Font(R.font.roboto_black))
                    )
                )

                Divider(color = Color.Transparent, modifier = Modifier.height(20.dp))

                LazyColumn() {
                    items(msgList) { response ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp), horizontalArrangement = Arrangement.Start
                        ) {

                            Icon(
                                painterResource(id = R.drawable.ic_baseline_arrow_right_24),
                                contentDescription = "",
                                tint = colorResource(id = R.color.default_text_color),
                                modifier = Modifier
                                    .padding(end = 10.dp)
                                    .size(20.dp)
                            )

                            Text(
                                text = response.msg,
                                style = TextStyle(
                                    color = colorResource(id = R.color.default_text_color),
                                    fontSize = 16.sp
                                )
                            )
                        }
                    }
                }
            }


        }
    }
}