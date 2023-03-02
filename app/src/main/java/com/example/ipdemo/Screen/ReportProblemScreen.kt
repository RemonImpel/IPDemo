package com.example.ipdemo.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.ipdemo.Navigations.Screens
import com.example.ipdemo.R
import com.example.ipdemo.Utils.Constants
import com.example.ipdemo.Utils.ScreenSize
import com.example.ipdemo.ui.theme.Components.AppToolbarCompose
import com.example.ipdemo.ui.theme.blueButton
import com.example.ipdemo.ui.theme.darkButtonTextStyle
import com.example.ipdemo.ui.theme.gradientBottomColor

@Composable
fun ReportProblemScreen(onBack: () -> Unit, navController: NavHostController) {

    var context = LocalContext.current
    var issue by remember {
        mutableStateOf("")
    }

    Scaffold(
        floatingActionButton = {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 30.dp, end = 30.dp, bottom = 20.dp),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(blueButton),
                onClick = {

                    navController.navigate(Screens.REPORTSUCCESSSCREEN.name) {
                        navController.popBackStack(
                            Screens.SETTINGS.name,
                            inclusive = false,
                            saveState = false
                        )
                    }
                }) {

                Text(
                    text = Constants.report_problem.capitalize(),
                    style = darkButtonTextStyle,
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                )

            }
        }, floatingActionButtonPosition = FabPosition.Center
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
                title = Constants.setting.capitalize(), onBackClick = onBack
            )

            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 25.dp, end = 25.dp, top = 100.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    //verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = Constants.technical_issues.capitalize() + "?", style = TextStyle(
                            letterSpacing = 1.sp,
                            color = colorResource(id = R.color.default_text_color),
                            fontSize = 21.sp,
                            //fontWeight = FontWeight.Bold,l
                            fontFamily = FontFamily(Font(R.font.roboto_black))
                        )
                    )

                    Divider(color = Color.Transparent, modifier = Modifier.height(25.dp))

                    Text(
                        text = Constants.tech_issue_top.capitalize(), style = TextStyle(
                            fontSize = 14.sp,
                            lineHeight = 25.sp,
                            letterSpacing = .5.sp,
                            textAlign = TextAlign.Center
                        )
                    )

                    Divider(color = Color.Transparent, modifier = Modifier.height(25.dp))

                    Card(shape = RoundedCornerShape(15.dp)) {
                        OutlinedTextField(

                            colors = TextFieldDefaults.textFieldColors(
                                backgroundColor = Color.White,
                                focusedIndicatorColor = Color.White,
                                unfocusedIndicatorColor = Color.White,
                                cursorColor = Color.Black
                            ),
                            value = issue,
                            onValueChange = { issue = it },
                            placeholder = {
                                Text(
                                    text = Constants.describe.capitalize(),
                                    style = TextStyle(fontSize = 14.sp)
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height((ScreenSize.height() / 3).dp)
                        )
                    }

                    Divider(color = Color.Transparent, modifier = Modifier.height(25.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {

                        Text(
                            text = Constants.note.capitalize() + ": " + Constants.tech_issue_note.capitalize(),
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 25.sp,
                                letterSpacing = .5.sp,
                                textAlign = TextAlign.Center
                            )
                        )
                    }

                }
            }
        }
    }
}