package com.example.ipdemo.Screen

import android.annotation.SuppressLint
import android.util.Log
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import androidx.compose.ui.viewinterop.AndroidView
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavHostController
import com.example.ipdemo.Helpers.NotificationStateController
import com.example.ipdemo.R
import com.example.ipdemo.Utils.Constants
import com.example.ipdemo.ui.theme.Components.AppToolbarCompose
import com.example.ipdemo.ui.theme.blueButton
import com.example.ipdemo.ui.theme.fontRoboto

@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun TermsOfUseScreen(
    onBack: () -> Unit,
    navController: NavHostController
) {


    var privacyPolicyDialogState by remember {
        mutableStateOf(false)
    }


    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize()

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
                    text = Constants.terms_of_use.capitalize(), style = TextStyle(
                        letterSpacing = 1.sp,
                        color = colorResource(id = R.color.default_text_color),
                        fontSize = 21.sp,
                        //fontWeight = FontWeight.Bold,
                        fontFamily = FontFamily(Font(R.font.roboto_black))
                    )
                )
            }

            Card(modifier = Modifier
                .padding(top = 15.dp)
                .clickable {
                    //privacyPolicyDialogState = true
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
                        text = Constants.terms_and_conditions.capitalize(), style = TextStyle(
                            color = blueButton,
                            fontSize = 16.sp,
                            //fontWeight = FontWeight.Bold,
                            //fontFamily = FontFamily(Font(R.font.roboto_black))
                        )
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        painter = painterResource(id = R.drawable.arrow_up_right_angle),
                        tint = blueButton,
                        modifier = Modifier.size(16.dp),
                        contentDescription = ""
                    )
                }
            }

            Card(modifier = Modifier
                .padding(top = 15.dp)
                .clickable {
                    privacyPolicyDialogState = true
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
                        text = Constants.privacy_policy.capitalize(), style = TextStyle(
                            color = blueButton,
                            fontSize = 16.sp,
                            //fontWeight = FontWeight.Bold,
                            //fontFamily = FontFamily(Font(R.font.roboto_black))
                        )
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    Icon(
                        painter = painterResource(id = R.drawable.arrow_up_right_angle),
                        tint = blueButton,
                        modifier = Modifier.size(16.dp),
                        contentDescription = ""
                    )
                }
            }
        }

    }

    PrivacyPolicyDialog(privacyPolicyDialogState = privacyPolicyDialogState) {
        privacyPolicyDialogState = !it
    }

    //Log.d("dataxx", "TermsOfUseScreen: ${notificationStateController.privacyPolicyState.value.toString()}")
}


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun PrivacyPolicyDialog(
    privacyPolicyDialogState: Boolean,
    onDismissRequest: (dialogState: Boolean) -> Unit
) {

    val context = LocalContext.current

    val bgColor = R.color.white
    if (privacyPolicyDialogState) {
        Dialog(
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false,
                usePlatformDefaultWidth = false
            ),
            onDismissRequest = {
                onDismissRequest(privacyPolicyDialogState)
            },
        ) {


            Surface(
                color = colorResource(
                    id = bgColor
                ),
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize()
            ) {
                Scaffold(
                    floatingActionButtonPosition = FabPosition.Center,
                    floatingActionButton = {
                        Button(modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, bottom = 10.dp),
                            colors = ButtonDefaults.buttonColors(blueButton),
                            shape = RoundedCornerShape(20.dp),
                            onClick = { onDismissRequest(privacyPolicyDialogState) }) {
                            Text(text = "Ok, Got It", style = TextStyle(color = Color.White))
                        }
                    },

                    ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {

                        Text(
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            text = Constants.privacy_policy.capitalize(),
                            style = TextStyle(
                                color = Color.Black,
                                fontWeight = FontWeight.Bold,
                                fontFamily = fontRoboto,
                                fontSize = 18.sp,
                                letterSpacing = .5.sp
                            )
                        )

                        val mUrl = "https://loremipsum.io/privacy-policy/"

                        AndroidView(factory = {
                            WebView(it).apply {
                                layoutParams = ViewGroup.LayoutParams(
                                    ViewGroup.LayoutParams.MATCH_PARENT,
                                    ViewGroup.LayoutParams.MATCH_PARENT
                                )
                                webViewClient = WebViewClient()
                                loadUrl(mUrl)
                            }
                        }, update = {
                            it.loadUrl(mUrl)
                        })
                    }
                }
            }

        }
    }
}