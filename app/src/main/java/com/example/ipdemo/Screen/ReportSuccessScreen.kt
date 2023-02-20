package com.example.ipdemo.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.ipdemo.R
import com.example.ipdemo.Utils.Constants
import com.example.ipdemo.Utils.ScreenSize
import com.example.ipdemo.ui.theme.Components.AppToolbarCompose
import com.example.ipdemo.ui.theme.blueButton


@Composable
fun ReportSuccessScreen(onBack: () -> Unit, navController: NavHostController) {
    Scaffold(
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp),
                colors = ButtonDefaults.buttonColors(blueButton),
                shape = RoundedCornerShape(20.dp),
                onClick = { navController.navigateUp() }) {
                Text(
                    text = "Done",
                    style = TextStyle(color = Color.White, fontWeight = FontWeight.Bold)
                )
            }
        },
    ) {

//        AppToolbarCompose(
//            title = Constants.setting.capitalize(),
//            onBackClick = onBack
//        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painterResource(id = R.drawable.ip_police_ok),
                modifier = Modifier.size(200.dp),
                contentDescription = ""
            )

            Text(
                text = Constants.we_highly_appreciate_your_input.capitalize(),
                style = TextStyle(
                    letterSpacing = 1.sp,
                    color = colorResource(id = R.color.default_text_color),
                    fontSize = 18.sp,
                    //fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily(Font(R.font.roboto_black))
                ),
                modifier = Modifier.width((ScreenSize.width() / 2).dp),
                textAlign = TextAlign.Center
            )

        }
    }
}