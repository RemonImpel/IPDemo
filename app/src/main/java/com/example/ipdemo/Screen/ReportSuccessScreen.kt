package com.example.ipdemo.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ipdemo.R
import com.example.ipdemo.Utils.Constants
import com.example.ipdemo.Utils.ScreenSize
import com.example.ipdemo.ui.theme.Components.AppToolbarCompose
import com.example.ipdemo.ui.theme.blueButton
import com.example.ipdemo.ui.theme.darkButtonTextStyle
import com.example.ipdemo.ui.theme.gradientBottomColor


@Composable
fun ReportSuccessScreen(onBack: () -> Unit) {
    Scaffold(
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            Button(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, bottom = 10.dp),
                colors = ButtonDefaults.buttonColors(blueButton),
                shape = RoundedCornerShape(20.dp),
                onClick = { onBack() }) {
                Text(
                    text = "Done",
                    style = darkButtonTextStyle,
                    modifier = Modifier.padding(top = 5.dp, bottom = 5.dp)
                )
            }
        },
    ) {

        AppToolbarCompose(
            title = Constants.setting.capitalize(),
            onBackClick = onBack
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.White,
                            gradientBottomColor
                        )
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                painterResource(id = R.drawable.ip_police_ok),
                modifier = Modifier.size((ScreenSize.height()/3).dp),
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