package com.example.ipdemo.Screen

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ipdemo.R
import com.example.ipdemo.Utils.Constants

@Composable
fun SettingsScreen() {

    val mCheckedState = remember { mutableStateOf(false) }
    val scrollState = rememberScrollState()
    val buildVersion = remember {
        mutableStateOf(1.2)
    }

    //
    Scaffold() {
        Column(
            modifier = Modifier
                .fillMaxWidth()

        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /*TODO*/ }) {

                    Icon(
                        painterResource(id = R.drawable.ic_baseline_arrow_back_24),
                        contentDescription = ""
                    )

                }

                Text(
                    text = Constants.home.capitalize(), style = TextStyle(
                        color = colorResource(id = R.color.default_text_color),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
            }


            Column(modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = Constants.setting.uppercase(), style = TextStyle(
                            color = colorResource(id = R.color.default_text_color),
                            fontSize = 21.sp,
                            //fontWeight = FontWeight.Bold,
                            fontFamily = FontFamily(Font(R.font.roboto_black))
                        )
                    )
                }

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = 5.dp

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.translation),
                            tint = colorResource(id = R.color.default_icon_color),
                            modifier = Modifier.size(25.dp),
                            contentDescription = ""
                        )

                        Text(
                            modifier = Modifier.padding(start = 30.dp),
                            text = Constants.language.capitalize(), style = TextStyle(
                                color = colorResource(id = R.color.default_text_color),
                                fontSize = 16.sp,
                                //fontWeight = FontWeight.Bold,
                                //fontFamily = FontFamily(Font(R.font.roboto_black))
                            )
                        )

                        Spacer(modifier = Modifier.weight(1f))

                        Text(
                            modifier = Modifier.padding(end = 10.dp),
                            text = "English".capitalize(), style = TextStyle(
                                color = Color.LightGray,
                                fontSize = 16.sp,
                                //fontWeight = FontWeight.Bold,
                                //fontFamily = FontFamily(Font(R.font.roboto_black))
                            )
                        )

                        Icon(
                            painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                            tint = Color.LightGray,
                            modifier = Modifier.size(16.dp),
                            contentDescription = ""
                        )
                    }
                }


                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp),
                    shape = RoundedCornerShape(16.dp),
                    elevation = 5.dp

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.notification),
                            tint = colorResource(id = R.color.default_icon_color),
                            modifier = Modifier.size(25.dp),
                            contentDescription = ""
                        )

                        Text(
                            modifier = Modifier.padding(start = 30.dp),
                            text = Constants.notifications.capitalize(), style = TextStyle(
                                color = colorResource(id = R.color.default_text_color),
                                fontSize = 16.sp,
                                //fontWeight = FontWeight.Bold,
                                //fontFamily = FontFamily(Font(R.font.roboto_black))
                            )
                        )

                        Spacer(modifier = Modifier.weight(1f))


                        Switch(
                            modifier = Modifier.size(25.dp),
                            checked = mCheckedState.value,
                            onCheckedChange = { mCheckedState.value = it })
                    }
                }

                Divider(modifier = Modifier.padding(15.dp))

                customItemCard(title = Constants.faq, R.drawable.faq)

                customItemCard(title = Constants.help_and_contact, R.drawable.help)

                customItemCard(title = Constants.report_problem, R.drawable.report)

                customItemCard(title = Constants.terms_of_use, R.drawable.faq)

                Divider(modifier = Modifier.padding(15.dp))

                customItemCard(title = Constants.about_us, R.drawable.faq)

                customItemCard(title = Constants.changelog, R.drawable.faq)

                customItemCard(title = Constants.about_us, R.drawable.faq)

                customItemCard(title = Constants.changelog, R.drawable.faq)

                customItemCard(title = Constants.about_us, R.drawable.faq)

                customItemCard(title = Constants.changelog, R.drawable.faq)


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 20.dp, bottom = 20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(end = 10.dp),
                        text = Constants.buildversion.capitalize(), style = TextStyle(
                            color = colorResource(id = R.color.default_text_color),
                            fontSize = 16.sp,
                            //fontWeight = FontWeight.Bold,
                            //fontFamily = FontFamily(Font(R.font.roboto_black))
                        )
                    )

                    Text(
                        text = buildVersion.value.toString(), style = TextStyle(
                            color = Color.Gray,
                            fontSize = 16.sp,
                            //fontWeight = FontWeight.Bold,
                            //fontFamily = FontFamily(Font(R.font.roboto_black))
                        )
                    )
                }
            }

        }
    }
}

@Composable
fun customItemCard(title: String, iconImage: Int) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)
            .clickable {
                Toast
                    .makeText(context, title, Toast.LENGTH_SHORT)
                    .show()
            },
        shape = RoundedCornerShape(16.dp),
        elevation = 5.dp

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(id = iconImage),
                tint = colorResource(id = R.color.default_icon_color),
                modifier = Modifier.size(25.dp),
                contentDescription = ""
            )

            Text(
                modifier = Modifier.padding(start = 30.dp),
                text = title.capitalize(), style = TextStyle(
                    color = colorResource(id = R.color.default_text_color),
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


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SettingsScreen()
}