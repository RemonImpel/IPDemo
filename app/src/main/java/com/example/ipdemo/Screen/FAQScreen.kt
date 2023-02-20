package com.example.ipdemo.Screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ipdemo.Modal.FAQResponse
import com.example.ipdemo.Modal.Questions
import com.example.ipdemo.R
import com.example.ipdemo.Utils.Constants
import com.example.ipdemo.Utils.ScreenSize
import com.example.ipdemo.ui.theme.Components.AppToolbarCompose
import com.example.ipdemo.ui.theme.blueButton
import com.example.ipdemo.ui.theme.lightGreen
import com.example.ipdemo.ui.theme.gradientBottomColor

@Composable
fun FAQScreen(onBack: () -> Unit) {

    val questionList = listOf(
        FAQResponse(
            "Category A",
            listOf(
                Questions("Question 1", Constants.lorem_ipsum),
                Questions("Question 2", Constants.lorem_ipsum),
                Questions("Question 3", Constants.lorem_ipsum),
                Questions("Question 4", Constants.lorem_ipsum)
            )
        ),

        FAQResponse(
            "Category B",
            listOf(
                Questions("Question 5", Constants.lorem_ipsum),
                Questions("Question 6", Constants.lorem_ipsum),
                Questions("Question 7", Constants.lorem_ipsum)
            )
        ),
        FAQResponse(
            "Category C",
            listOf(
                Questions("Question 8", Constants.lorem_ipsum),
                Questions("Question 9", Constants.lorem_ipsum),
                Questions("Question 10", Constants.lorem_ipsum),
                Questions("Question 11", Constants.lorem_ipsum),
                Questions("Question 12", Constants.lorem_ipsum)
            )
        )

    )

    Scaffold() {

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
                title = Constants.setting.capitalize(), onBackClick = onBack
            )

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

            BoxWithConstraints(
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(color = lightGreen),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(questionList) { item ->
                        Text(
                            text = item.title,
                            modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                            style = TextStyle(
                                color = colorResource(id = R.color.default_text_color),
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.White)
                        ) {


                            Column(modifier = Modifier.fillMaxWidth()) {
                                for (i in 0 until item.questions.size) {

                                    var viewState by remember {
                                        mutableStateOf(false)
                                    }
                                    Column(modifier = Modifier
                                        .fillMaxWidth()
                                        .clickable {
                                            viewState = !viewState
                                        }) {

                                        Row(modifier = Modifier.padding(15.dp)) {
                                            Text(
                                                text = item.questions[i].question,
                                                style = TextStyle(
                                                    color = blueButton,
                                                    fontWeight = FontWeight.Bold,
                                                    fontSize = 16.sp
                                                )
                                            )

                                            Spacer(modifier = Modifier.weight(1f))

                                            Icon(
                                                if (viewState) painterResource(id = R.drawable.arrow_up_24) else painterResource(
                                                    id = R.drawable.arrow_down_24
                                                ),
                                                contentDescription = "",
                                                modifier = Modifier.size(20.dp),
                                                tint = Color.LightGray
                                            )
                                        }

                                        if (viewState) {
                                            Text(
                                                text = item.questions[i].answer,
                                                style = TextStyle(
                                                    color = Color.Black,
                                                    fontSize = 12.sp
                                                ),
                                                modifier = Modifier.padding(15.dp)
                                            )
                                        }


                                        Divider()

                                    }
                                }
                            }
                        }

                    }

                }
            }

        }

    }

}

