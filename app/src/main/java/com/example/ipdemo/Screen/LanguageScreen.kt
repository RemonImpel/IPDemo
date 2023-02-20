package com.example.ipdemo.Screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ipdemo.Modal.LanguageResponse
import com.example.ipdemo.R
import com.example.ipdemo.Session.SessionManagement
import com.example.ipdemo.Utils.Constants
import com.example.ipdemo.ui.theme.Components.AppToolbarCompose
import com.example.ipdemo.ui.theme.blueButton
import com.example.ipdemo.ui.theme.darkButtonTextStyle
import com.example.ipdemo.ui.theme.fontRoboto
import com.example.ipdemo.ui.theme.gradientBottomColor


//private lateinit var languageList: ArrayList<LanguageResponse>

@Composable
fun LanguageScreen(onBack: () -> Unit) {
    val cardElevation = 1

    val context = LocalContext.current

    val languageList = listOf(
        LanguageResponse("english", R.drawable.uk),
        LanguageResponse("nederlands", R.drawable.nd),
        LanguageResponse("español", R.drawable.spain),
        LanguageResponse("deutsch", R.drawable.ger),
        LanguageResponse("français", R.drawable.france),
        LanguageResponse("Italiano", R.drawable.italy)
    )

    val languageState = remember {
        mutableStateOf(false)
    }

    val sessionManagement = SessionManagement(context)

    val selectedLanguage = remember {
        mutableStateOf(sessionManagement.getLanguage().toString())
    }


    Scaffold(modifier = Modifier.fillMaxSize(), floatingActionButton = {
        Button(modifier = Modifier
            .fillMaxWidth()
            .padding(start = 30.dp, end = 30.dp, bottom = 0.dp),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(blueButton),
            onClick = {

                sessionManagement.saveLanguage(selectedLanguage.value.toString())
//                Toast.makeText(context, "language changed", Toast.LENGTH_SHORT)
//                    .show()

                onBack()
            }) {

            Text(
                text = Constants.choose_language.capitalize(),
                style = darkButtonTextStyle,
                modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
            )

        }
    }, floatingActionButtonPosition = FabPosition.Center) {
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
                .padding(bottom = 60.dp)

        ) {
            AppToolbarCompose(
                title = Constants.setting.capitalize(), onBackClick = onBack
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 25.dp, bottom = 25.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = Constants.choose_language.capitalize(), style = TextStyle(
                        letterSpacing = 1.sp,
                        color = colorResource(id = R.color.default_text_color),
                        fontSize = 21.sp,
                        //fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.roboto_black))
                    )
                )
            }

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(languageList) { item ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)
                            .clickable {
//                                Toast
//                                    .makeText(context, item.title, Toast.LENGTH_SHORT)
//                                    .show()
                                selectedLanguage.value = item.title
                            }, shape = RoundedCornerShape(16.dp), elevation = cardElevation.dp

                    ) {
                        languageState.value = item.title == selectedLanguage.value
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(
                                    color = if (languageState.value) colorResource(
                                        id = R.color.slected_language_bg_color
                                    ) else {
                                        colorResource(id = R.color.white)
                                    }
                                )
                                .border(
                                    shape = RoundedCornerShape(16.dp),
                                    border = if (languageState.value) BorderStroke(
                                        1.dp, colorResource(
                                            id = R.color.default_icon_color
                                        )
                                    ) else BorderStroke(
                                        1.dp, colorResource(
                                            id = R.color.white
                                        )
                                    )
                                )
                                .padding(15.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Start
                        ) {

                            Image(
                                painter = painterResource(item.image),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .fillMaxSize(),
                                contentScale = ContentScale.Crop,
                                alignment = Alignment.Center
                            )

                            Text(
                                modifier = Modifier.padding(start = 30.dp),
                                text = item.title.capitalize(),
                                style = TextStyle(
                                    color = colorResource(id = R.color.default_text_color),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = fontRoboto
                                )
                            )

                            Spacer(modifier = Modifier.weight(1f))



                            if (languageState.value) {
                                Icon(
                                    painter = painterResource(id = R.drawable.ic_baseline_check_24),
                                    tint = colorResource(id = R.color.default_icon_color),
                                    modifier = Modifier.size(16.dp),
                                    contentDescription = ""
                                )
                            }
                        }
                    }

                }
            }

        }
    }
}