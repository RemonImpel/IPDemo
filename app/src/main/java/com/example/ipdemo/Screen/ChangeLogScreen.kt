package com.example.ipdemo.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
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
fun ChangeLogScreen(onBack: () -> Unit, navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),

        ) {
        Column(
            modifier = Modifier.fillMaxSize().background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.White,
                        lightPurple
                    )
                )
            )

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
                    text = Constants.changelog.capitalize(), style = TextStyle(
                        letterSpacing = 1.sp,
                        color = colorResource(id = R.color.default_text_color),
                        fontSize = 21.sp,
                        //fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.roboto_black))
                    )
                )
            }

            itemCard("Version 2.2", navController)

            itemCard("Version 2.1", navController)

        }
    }
}


@Composable
fun itemCard(title: String, navController: NavHostController) {
    Card(modifier = Modifier
        .padding(top = 15.dp)
        .clickable {
            navController.navigate(Screens.CHANGELOGDETAILS.name)
        }) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {

            Text(
                modifier = Modifier.padding(start = 30.dp),
                text = title, style = TextStyle(
                    color = blueButton,
                    fontSize = 16.sp,
                    //fontWeight = FontWeight.Bold,
                    //fontFamily = FontFamily(Font(R.font.roboto_black))
                )
            )

            Spacer(modifier = Modifier.weight(1f))

            Icon(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                tint = Color.LightGray,
                modifier = Modifier.size(16.dp),
                contentDescription = ""
            )
        }
    }
}
