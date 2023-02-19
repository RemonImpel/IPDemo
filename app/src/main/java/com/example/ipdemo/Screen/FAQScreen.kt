package com.example.ipdemo.Screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ipdemo.R
import com.example.ipdemo.Utils.Constants
import com.example.ipdemo.Utils.ScreenSize
import com.example.ipdemo.ui.theme.Components.AppToolbarCompose
import com.example.ipdemo.ui.theme.blueButton

@Composable
fun FAQScreen(onBack: () -> Unit) {

    Scaffold() {

        Column(modifier = Modifier.fillMaxSize()) {
            AppToolbarCompose(
                title = Constants.setting.capitalize(), onBackClick = onBack
            )


            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.faq_top_background),
                        modifier = Modifier.fillMaxWidth(),
                        contentDescription = ""
                    )

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 7.dp, bottom = 13.dp),
                        contentAlignment = Alignment.BottomStart
                    ) {
                        Row(modifier = Modifier.fillMaxSize()) {
                            Image(
                                painter = painterResource(id = R.drawable.character_bruin_haar),
//                            modifier = Modifier.fillMaxWidth(),
                                contentDescription = ""
                            )

                            Column(
                                modifier = Modifier
                                    .fillMaxHeight()
                                    .padding(bottom = 20.dp),
                                verticalArrangement = Arrangement.Bottom
                            ) {
                                Text(
                                    text = "App Tutorial",
                                    style = TextStyle(
                                        color = Color.White,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )


                                Button(
                                    shape = RoundedCornerShape(5.dp),
                                    border = BorderStroke(width = .5.dp, color = Color.White),
                                    colors = ButtonDefaults.buttonColors(blueButton),
                                    onClick = {
                                    },
                                    modifier = Modifier
                                        .padding(top = 10.dp, end = 30.dp)
                                        .fillMaxWidth()
                                    //.width((ScreenSize.width() / 2.5).dp)
                                ) {
                                    Row(
                                        verticalAlignment = Alignment.CenterVertically,
                                        horizontalArrangement = Arrangement.Start
                                    ) {
                                        Text(
                                            modifier = Modifier
                                                .width((ScreenSize.width() / 3).dp),
                                            text = Constants.view_video_app_features.capitalize(),
                                            color = Color.White,
                                            fontSize = 10.sp,
                                            overflow = TextOverflow.Ellipsis,
                                            //lineHeight = 16.sp,
                                            maxLines = 1
                                        )
                                        Spacer(modifier = Modifier.weight(1f))
                                        Icon(
                                            Icons.Default.ArrowForward,
                                            tint = Color.White,
                                            contentDescription = "",
                                            modifier = Modifier.size(16.dp)
                                        )
                                    }
                                }
                            }


                        }
                    }
                }

                Divider(color = Color.Transparent)

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = Constants.frequently_asked_question.capitalize(),
                        style = TextStyle(
                            letterSpacing = 1.sp,
                            color = colorResource(id = R.color.default_text_color),
                            fontSize = 21.sp,
                            //fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(R.font.roboto_black))
                        )
                    )
                }
            }

        }

    }

}

/*
Column(horizontalAlignment = Alignment.Start) {
    Text(
        text = "App Tutorial",
        style = TextStyle(
            color = Color.White,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    )


    Button(
        shape = RoundedCornerShape(5.dp),
        border = BorderStroke(width = .5.dp, color = Color.White),
        colors = ButtonDefaults.buttonColors(blueButton),
        onClick = {
 },
        modifier = Modifier.padding(top = 10.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = Constants.view_video_app_features.capitalize(),
                color = Color.White
            )
            Spacer(modifier = Modifier.padding(10.dp))
            Icon(
                Icons.Default.ArrowForward,
                tint = Color.White,
                contentDescription = "",
                modifier = Modifier.size(16.dp)
            )
        }
    }
}*/
