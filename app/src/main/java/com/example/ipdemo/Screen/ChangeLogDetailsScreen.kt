package com.example.ipdemo.Screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.ipdemo.R
import com.example.ipdemo.Utils.Constants
import com.example.ipdemo.ui.theme.Components.AppToolbarCompose


@Composable
fun ChangeLogDetailsScreen(onBack: () -> Unit) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),

        ) {
        Column(
            modifier = Modifier.fillMaxSize()

        ) {
            AppToolbarCompose(
                title = Constants.back.capitalize(), onBackClick = onBack
            )


        }
    }
}