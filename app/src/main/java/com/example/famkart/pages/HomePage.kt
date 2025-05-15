package com.example.famkart.pages

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.famkart.components.BannerView
import com.example.famkart.components.HeaderView

@Composable
fun HomePage(modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier.fillMaxSize()
            .padding(16.dp).safeDrawingPadding()
    ){
        HeaderView(modifier)



    }










}