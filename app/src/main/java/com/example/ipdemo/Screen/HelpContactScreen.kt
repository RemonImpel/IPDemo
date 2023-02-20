package com.example.ipdemo.Screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ipdemo.Navigations.Screens
import com.example.ipdemo.R
import com.example.ipdemo.Utils.Constants
import com.example.ipdemo.ui.theme.Components.AppToolbarCompose
import com.example.ipdemo.ui.theme.blueButton
import com.example.ipdemo.ui.theme.lightPurple

@Composable
fun HelpContactScreen(onBack: () -> Unit, navController: NavHostController) {

    Scaffold() {

        Column(
            modifier = Modifier
                .fillMaxSize()

        ) {
            AppToolbarCompose(
                title = Constants.back.capitalize(), onBackClick = onBack
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()

            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .offset(y = 20.dp)
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.White, lightPurple
                                )
                            )
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ip_police_headphone),
                        modifier = Modifier
                            .fillMaxHeight(),
                        //contentScale = ContentScale.Crop,
                        contentDescription = ""
                    )
                }

                Column(
                    modifier = Modifier
                        //.padding(top = 190.dp)
                        .fillMaxSize().verticalScroll(rememberScrollState())
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color.White,
                                    lightPurple
                                )
                            )
                        )

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 25.dp, bottom = 25.dp, start = 10.dp, end = 10.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = Constants.how_can_we_help_you.capitalize(),
                            style = TextStyle(
                                letterSpacing = 1.sp,
                                color = colorResource(id = R.color.default_text_color),
                                fontSize = 21.sp,
                                //fontWeight = FontWeight.Bold,
                                fontFamily = FontFamily(Font(R.font.roboto_black))
                            )
                        )
                    }



                    Text(
                        text = Constants.lorem_ipsum,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 25.sp,
                            letterSpacing = .5.sp,
                            textAlign = TextAlign.Center
                        ), modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                    )

                    Text(
                        text = Constants.lorem_ipsum,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 25.sp,
                            letterSpacing = .5.sp,
                            textAlign = TextAlign.Center
                        ), modifier = Modifier.padding(start = 10.dp, end = 10.dp)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .padding(10.dp)
                                .clickable {

                                    navController.navigate(Screens.MAILSUCCESS.name){
                                        navController.popBackStack(
                                            Screens.SETTINGS.name,
                                            inclusive = false,
                                            saveState = false
                                        )
                                    }
                                },
                            shape = RoundedCornerShape(20.dp),
                            elevation = 1.dp
                        ) {
                            Column(
                                modifier = Modifier.padding(30.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painterResource(id = R.drawable.mail),
                                    tint = blueButton,
                                    contentDescription = "", modifier = Modifier.size(25.dp)
                                )
                                Divider(
                                    color = Color.Transparent,
                                    modifier = Modifier.height(10.dp)
                                )

                                Text(
                                    text = Constants.email_us.capitalize(), style = TextStyle(
                                        color = colorResource(
                                            id = R.color.default_text_color
                                        ),
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 16.sp
                                    )
                                )
                            }
                        }

                        Card(
                            modifier = Modifier
                                .weight(1f)
                                .padding(10.dp),
                            shape = RoundedCornerShape(20.dp),
                            elevation = 1.dp
                        ) {
                            Column(
                                modifier = Modifier.padding(30.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Icon(
                                    painterResource(id = R.drawable.briefcase),
                                    tint = blueButton,
                                    contentDescription = "", modifier = Modifier.size(25.dp)
                                )
                                Divider(
                                    color = Color.Transparent,
                                    modifier = Modifier.height(10.dp)
                                )

                                Text(
                                    text = Constants.business.capitalize(), style = TextStyle(
                                        color = colorResource(
                                            id = R.color.default_text_color
                                        ),
                                        fontWeight = FontWeight.Bold,
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
}