package com.example.ipdemo.Screen

import android.widget.Toast
import androidx.compose.foundation.border
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
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ipdemo.R
import com.example.ipdemo.Utils.Constants
import com.example.ipdemo.ui.theme.Components.AppToolbarCompose
import com.example.ipdemo.ui.theme.blueButton
import com.example.ipdemo.ui.theme.darkButtonTextStyle

@Composable
fun ReportProblemScreen(onBack: () -> Unit) {

    var context = LocalContext.current
    var issue by remember {
        mutableStateOf("")
    }

    Scaffold(floatingActionButton = {
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, bottom = 20.dp),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(blueButton),
            onClick = {
                if(issue.isNotEmpty()){
                    Toast.makeText(context, issue, Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(context, "nothing to report", Toast.LENGTH_SHORT).show()
                }
            }) {

            Text(
                text = Constants.report_problem.capitalize(),
                style = darkButtonTextStyle,
                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
            )

        }
    }, floatingActionButtonPosition = FabPosition.Center) {
        Column(modifier = Modifier.fillMaxSize()) {
            AppToolbarCompose(
                title = Constants.setting.capitalize(), onBackClick = onBack
            )

            Box(modifier = Modifier.fillMaxSize()) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(start = 15.dp, end = 15.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    //verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = Constants.technical_issues.capitalize(), style = TextStyle(
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

                    OutlinedTextField(
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.Transparent,
                            focusedIndicatorColor = Color.LightGray,
                            unfocusedIndicatorColor = Color.LightGray,
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
                            .height(100.dp)
                    )

                    Divider(color = Color.Transparent, modifier = Modifier.height(25.dp))

                    Row() {

                        Text(
                            text = Constants.note.capitalize(), style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 25.sp,
                                letterSpacing = .5.sp,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold
                            )
                        )

                        Text(
                            text = Constants.tech_issue_note.capitalize(), style = TextStyle(
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