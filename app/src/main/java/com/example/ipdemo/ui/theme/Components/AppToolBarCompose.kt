package com.example.ipdemo.ui.theme.Components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.ipdemo.ui.theme.bodyXSBoldTextStyle

@Composable
fun AppToolbarCompose(
    title: String, onBackClick: () -> Unit
) {
    return Row(
        modifier = Modifier
            .fillMaxWidth().padding(10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            Icons.Default.ArrowBack,
            contentDescription = title,
            tint = Color(0xff7F87A5),
            modifier = Modifier
                .size(24.dp)
                .clickable {
                    onBackClick()
                },
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = title, style = bodyXSBoldTextStyle)
    }
}