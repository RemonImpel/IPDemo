package com.example.ipdemo.Screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
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
import com.example.ipdemo.Utils.ScreenSize
import com.example.ipdemo.ui.theme.Components.AppToolbarCompose
import com.example.ipdemo.ui.theme.blueButton
import com.example.ipdemo.ui.theme.darkButtonTextStyle
import com.example.ipdemo.ui.theme.fontRoboto


@Composable
fun AboutUsScreen(onBack: () -> Unit) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),

        ) {
        Column(
            modifier = Modifier.fillMaxSize()

        ) {
            AppToolbarCompose(
                title = Constants.setting.capitalize(), onBackClick = onBack
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    painter = painterResource(id = R.drawable.title_logo),
                    modifier = Modifier
                        .height((ScreenSize.height() / 9).dp)
                        .padding(top = 20.dp, bottom = 20.dp),
                    contentDescription = ""
                )

                Image(
                    painter = painterResource(id = R.drawable.ip_police_hand_block),
                    modifier = Modifier.height((ScreenSize.height() / 4).dp),
                    contentDescription = ""
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp, bottom = 25.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = Constants.about_us.capitalize(), style = TextStyle(
                            letterSpacing = 1.sp,
                            color = colorResource(id = R.color.default_text_color),
                            fontSize = 21.sp,
                            //fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(R.font.roboto_black))
                        )
                    )
                }

                Text(
                    text = Constants.lorem_ipsum.capitalize(), style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 25.sp,
                        letterSpacing = .5.sp,
                        textAlign = TextAlign.Center
                    )
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 25.dp, bottom = 25.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "lorem ipsum".capitalize(), style = TextStyle(
                            letterSpacing = 1.sp,
                            color = colorResource(id = R.color.default_text_color),
                            fontSize = 21.sp,
                            //fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(R.font.roboto_black))
                        )
                    )
                }

                Text(
                    text = Constants.lorem_ipsum.capitalize() + " " + Constants.lorem_ipsum.capitalize(),
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