package com.example.ipdemo.Navigations

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ipdemo.Helpers.NotificationStateController
import com.example.ipdemo.Screen.*

enum class Screens {
    SETTINGS,
    LANGUAGE,
    ABOUTUS,
    CHANGELOG,
    CHANGELOGDETAILS,
    HELPCONTACT,
    FAQ,
    REPORTPROBLEM,
    TERMSOFUSE,
    REPORTSUCCESSSCREEN
}

@Composable
fun IPApp(
    notificationStateController: NotificationStateController,
    navController: NavHostController = rememberNavController()
) {
    Scaffold() { innerpadding ->
        NavHost(
            navController = navController,
            startDestination = Screens.SETTINGS.name,
            modifier = Modifier.padding(innerpadding)
        ) {

            composable(route = Screens.SETTINGS.name) {

                SettingsScreen(
                    notificationStateController,
                    onBack = {},
                    navController
                )

            }

            composable(route = Screens.LANGUAGE.name) {
                LanguageScreen(onBack = {
                    navController.navigateUp()
                })
            }

            composable(route = Screens.ABOUTUS.name) {
                AboutUsScreen(onBack = {
                    navController.navigateUp()
                })
            }

            composable(route = Screens.CHANGELOG.name) {
                ChangeLogScreen(onBack = {
                    navController.navigateUp()
                }, navController)
            }

            composable(route = Screens.CHANGELOGDETAILS.name) {
                ChangeLogDetailsScreen(onBack = {
                    navController.navigateUp()
                })
            }

            composable(route = Screens.HELPCONTACT.name) {
                HelpContactScreen(onBack = {
                    navController.navigateUp()
                })
            }

            composable(route = Screens.FAQ.name) {
                FAQScreen(onBack = {
                    navController.navigateUp()
                })
            }

            composable(route = Screens.REPORTPROBLEM.name) {
                ReportProblemScreen(onBack = {
                    navController.navigateUp()
                }, navController)
            }

            composable(route = Screens.TERMSOFUSE.name) {

                TermsOfUseScreen(
                    onBack = { navController.navigateUp() },
                    navController
                )

            }

            composable(route = Screens.REPORTSUCCESSSCREEN.name) {

                ReportSuccessScreen(
                    onBack = { navController.navigateUp() },navController
                )

            }

        }

    }
}