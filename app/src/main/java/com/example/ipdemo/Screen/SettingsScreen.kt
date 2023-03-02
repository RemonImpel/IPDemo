package com.example.ipdemo.Screen

import android.annotation.SuppressLint
import android.view.Gravity
import androidx.compose.foundation.*
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.window.DialogWindowProvider
import androidx.navigation.NavHostController
import com.example.ipdemo.Helpers.NotificationStateController
import com.example.ipdemo.Navigations.Screens
import com.example.ipdemo.R
import com.example.ipdemo.Session.SessionManagement
import com.example.ipdemo.Utils.Constants
import com.example.ipdemo.Utils.ScreenSize
import com.example.ipdemo.ui.theme.Components.AppToolbarCompose
import com.example.ipdemo.ui.theme.blueButton
import com.example.ipdemo.ui.theme.fontRoboto
import com.example.ipdemo.ui.theme.gradientBottomColor

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun SettingsScreen(
    notificationStateController: NotificationStateController,
    onBack: () -> Unit,
    navController: NavHostController
//    onLanguageClick: () -> Unit,
//    onAboutUsClick: () -> Unit,
) {
    val context = LocalContext.current
    val sessionManagement = SessionManagement(context)

    val mCheckedState = remember { mutableStateOf(sessionManagement.getNotificationState()) }

    val scrollState = rememberScrollState()
    val buildVersion = remember {
        mutableStateOf(1.2)
    }


    val cardElevation = 1

    var permissionDialogState by remember {
        mutableStateOf(false)
    }

    var deniedDialogState by remember {
        mutableStateOf(false)
    }

    val interactionSource = remember {
        MutableInteractionSource()
    }

    notificationStateController.setState(sessionManagement.getNotificationState())


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
                title = Constants.home.capitalize(),
                onBackClick = onBack
            )

            // instagramIcon()

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = Constants.setting.capitalize(),
                        style = TextStyle(
                            letterSpacing = 1.sp,
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
                        .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)
                        .clickable {
                            //onLanguageClick()
                            navController.navigate(Screens.LANGUAGE.name)
                        },
                    shape = RoundedCornerShape(16.dp),
                    elevation = cardElevation.dp

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(25.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Start
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.language),
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
                            text = if (sessionManagement.getLanguage()
                                    ?.isNotEmpty() == true
                            ) sessionManagement.getLanguage()!!.capitalize()
                                .toString() else "none".capitalize(), style = TextStyle(
                                color = Color.LightGray,
                                fontSize = 12.sp,
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
                    elevation = cardElevation.dp

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(25.dp),
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
                            modifier = Modifier
                                .size(25.dp)
                                .clickable {

                                },
                            checked = notificationStateController.notificationState.value,
                            colors = SwitchDefaults.colors(
                                checkedThumbColor = colorResource(id = R.color.default_icon_color),
                                checkedTrackColor = colorResource(id = R.color.default_icon_color),
                                uncheckedThumbColor = colorResource(id = R.color.default_icon_color),
                                uncheckedTrackColor = Color.Gray,
                            ),
                            //interactionSource =,
                            onCheckedChange = { state ->

                                if (state) {
                                    permissionDialogState = true
                                    deniedDialogState = false
                                } else {
                                    permissionDialogState = false
                                    deniedDialogState = true
                                }

                            })
                    }
                }

                Divider(modifier = Modifier.padding(15.dp))

                customItemCard(
                    title = Constants.faq,
                    R.drawable.faq,
                    cardElevation,
                    navController
                )

                customItemCard(
                    title = Constants.help_and_contact,
                    R.drawable.help,
                    cardElevation,
                    navController
                )

                customItemCard(
                    title = Constants.report_a_problem,
                    R.drawable.report,
                    cardElevation,
                    navController
                )

                customItemCard(
                    title = Constants.terms_of_use,
                    R.drawable.terms_use_icon,
                    cardElevation,
                    navController
                )

                Divider(modifier = Modifier.padding(15.dp))

                customItemCard(
                    title = Constants.about_us,
                    R.drawable.small_icon,
                    cardElevation,
                    navController
                )

                customItemCard(
                    title = Constants.changelog,
                    R.drawable.changelog_icon,
                    cardElevation,
                    navController
                )


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

    notificationPermissionDialog(
        permissionDialogState = permissionDialogState,
        sessionManagement,
        notificationStateController
    ) {
        permissionDialogState = !it
    }

    notificationDeniedDialog(
        deniedDialogState = deniedDialogState,
        sessionManagement,
        notificationStateController
    ) {
        deniedDialogState = !it
    }
}

@Composable
fun customItemCard(
    title: String,
    iconImage: Int,
    cardElevation: Int,
    navController: NavHostController
) {
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 15.dp, end = 15.dp, top = 10.dp, bottom = 10.dp)
            .clickable {
//                Toast
//                    .makeText(context, title, Toast.LENGTH_SHORT)
//                    .show()

                if (title == Constants.about_us) {
                    navController.navigate(Screens.ABOUTUS.name)
                }

                if (title == Constants.changelog) {
                    navController.navigate(Screens.CHANGELOG.name)
                }

                if (title == Constants.help_and_contact) {
                    navController.navigate(Screens.HELPCONTACT.name)
                }

                if (title == Constants.faq) {
                    navController.navigate(Screens.FAQ.name)
                }

                if (title == Constants.report_a_problem) {
                    navController.navigate(Screens.REPORTPROBLEM.name)
                }

                if (title == Constants.terms_of_use) {
                    navController.navigate(Screens.TERMSOFUSE.name)
                }
            },
        shape = RoundedCornerShape(16.dp),
        elevation = cardElevation.dp

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            if (title != Constants.about_us) {
                Icon(
                    painter = painterResource(id = iconImage),
                    tint = colorResource(id = R.color.default_icon_color),
                    modifier = Modifier.size(25.dp),
                    contentDescription = ""
                )
            } else {
                Image(
                    painter = painterResource(id = iconImage),
                    modifier = Modifier.size(25.dp),
                    //tint = colorResource(id = R.color.default_icon_color),
                    contentDescription = ""
                )
            }

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

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun notificationPermissionDialog(
    permissionDialogState: Boolean,
    sessionManagement: SessionManagement,
    notificationStateController: NotificationStateController,
    onDismissRequest: (dialogState: Boolean) -> Unit
) {
    val context = LocalContext.current
    var dialogHeight by remember {
        mutableStateOf(160)
    }

    val bgColor = R.color.white


    if (permissionDialogState) {

        Dialog(
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
                usePlatformDefaultWidth = false
            ),
            onDismissRequest = {
                onDismissRequest(permissionDialogState)
            },
        ) {

            val dialogWindowProvider = LocalView.current.parent as DialogWindowProvider
            dialogWindowProvider.window.setGravity(Gravity.CENTER)

            Surface(
                color = colorResource(
                    id = bgColor
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(start = (ScreenSize.width() / 5).dp, end = (ScreenSize.width() / 5).dp)
                    .fillMaxWidth()
                //.height(dialogHeight.dp)

            ) {


                Column(modifier = Modifier.fillMaxWidth()) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {

                            Text(
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth(),
                                text = Constants.notification_title,
                                style = TextStyle(
                                    color = Color.Black,
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = fontRoboto,
                                    fontSize = 18.sp,
                                    letterSpacing = .5.sp
                                )
                            )

                            Divider(color = Color.Transparent, modifier = Modifier.height(10.dp))

                            Text(
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth(),
                                text = Constants.notification_msg,
                                style = TextStyle(
                                    color = Color.Black,
                                    fontFamily = fontRoboto,
                                    fontSize = 12.sp
                                )
                            )
                        }
                    }

                    Divider(
                        color = Color.LightGray,
                        modifier = Modifier.padding(top = 10.dp),
                        thickness = 1.dp
                    )

                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)) {
                        TextButton(
                            onClick = { onDismissRequest(permissionDialogState) },
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxHeight()
                        ) {
                            Text(text = "Don't Allow", style = TextStyle(color = blueButton))
                        }


                        Divider(
                            color = Color.LightGray,
                            modifier = Modifier.fillMaxHeight().width(1.dp)
                        )


                        TextButton(onClick = {
                            sessionManagement.saveNotificationState(true)
                            onDismissRequest(permissionDialogState)
                            notificationStateController.setState(true)

                        }, modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()) {
                            Text(text = "OK", style = TextStyle(color = blueButton))
                        }
                    }
                }


            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun notificationDeniedDialog(
    deniedDialogState: Boolean,
    sessionManagement: SessionManagement,
    notificationStateController: NotificationStateController,
    onDismissRequest: (deniedDialogState: Boolean) -> Unit
) {
    val context = LocalContext.current
    var dialogHeight by remember {
        mutableStateOf(200)
    }

    val bgColor = R.color.white


    if (deniedDialogState) {

        Dialog(
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
                usePlatformDefaultWidth = false
            ),
            onDismissRequest = {
                onDismissRequest(deniedDialogState)
                //dialogHeight = 200
            },
        ) {

            val dialogWindowProvider = LocalView.current.parent as DialogWindowProvider
            dialogWindowProvider.window.setGravity(Gravity.CENTER)

            Surface(
                color = colorResource(
                    id = bgColor
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                //.height(dialogHeight.dp)

            ) {


                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Box(modifier = Modifier.fillMaxWidth()) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {

                            Text(
                                textAlign = TextAlign.Center,
                                modifier = Modifier.fillMaxWidth(),
                                text = Constants.turn_off_notifications,
                                style = TextStyle(
                                    color = colorResource(id = R.color.default_text_color),
                                    fontWeight = FontWeight.Bold,
                                    fontFamily = fontRoboto,
                                    fontSize = 18.sp,
                                    letterSpacing = .5.sp
                                )
                            )

                            Divider(color = Color.Transparent, modifier = Modifier.height(10.dp))

                            Text(
                                textAlign = TextAlign.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 15.dp, end = 15.dp),
                                text = Constants.turn_off_notifications_confirm_msg,
                                style = TextStyle(
                                    color = Color.Gray,
                                    fontFamily = fontRoboto,
                                    //fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    lineHeight = 20.sp,
                                    letterSpacing = .5.sp
                                )
                            )
                        }
                    }

                    Image(
                        painter = painterResource(id = R.drawable.ip_police_cross),
                        contentDescription = "",
                        modifier = Modifier.size((ScreenSize.height() / 3).dp),
                        //contentScale = ContentScale.Crop
                    )

                    Row(modifier = Modifier.fillMaxWidth()) {
                        Button(
                            shape = RoundedCornerShape(30.dp),
                            colors = ButtonDefaults.buttonColors(blueButton),
                            onClick = { onDismissRequest(deniedDialogState) },
                            modifier = Modifier
                                .weight(1f)
                                .padding(10.dp)
                        ) {
                            Text(
                                modifier = Modifier.padding(5.dp),
                                text = "Cancel",
                                style = TextStyle(
                                    color = Color.White,
                                    fontFamily = fontRoboto,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    letterSpacing = .5.sp
                                )
                            )
                        }


                        Button(
                            shape = RoundedCornerShape(30.dp),
                            border = BorderStroke(1.dp, Color.Red),
                            colors = ButtonDefaults.buttonColors(Color.White),
                            onClick = {
                                sessionManagement.saveNotificationState(false)
                                onDismissRequest(deniedDialogState)
                                notificationStateController.setState(false)
                            },
                            modifier = Modifier
                                .weight(1f)
                                .padding(10.dp)
                        ) {
                            Text(
                                modifier = Modifier.padding(5.dp),
                                text = "Turn Off",
                                style = TextStyle(
                                    color = Color.Red,
                                    fontFamily = fontRoboto,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 14.sp,
                                    letterSpacing = .5.sp
                                )
                            )
                        }
                    }

                }


            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    //SettingsScreen()
}