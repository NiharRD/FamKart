package com.example.famkart.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.famkart.R
import com.example.famkart.viewmodel.AppUtil
import com.example.famkart.viewmodel.AuthViewModel

@Composable
fun LoginScreen(modifier: Modifier = Modifier,navController: NavController,authViewModel: AuthViewModel= viewModel()) {
    var email by remember { mutableStateOf("") }

    var password by remember { mutableStateOf("") }
    var context= LocalContext.current
    var isLoading by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize().padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text="LogIN to FamKaRt",
            modifier = Modifier.fillMaxWidth(),
            style = TextStyle(
                fontSize=30.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
//        Text(
//            text="Create new Account ",
//            modifier = Modifier.fillMaxWidth(),
//            style = TextStyle(
//                fontSize=15.sp,
//                fontFamily = FontFamily.Monospace,
//                fontWeight = FontWeight.Bold
//            )
//        )
        Spacer(modifier = Modifier.height(10.dp))
        Image(painter = painterResource(id= R.drawable.icon_ecom),contentDescription = "banner",modifier=Modifier.fillMaxWidth()
            .height(150.dp))

        Spacer(modifier = Modifier.height(10.dp))

        OutlinedTextField(
            value = email,
            onValueChange = {email=it},
            label = { Text(text="Email Address") }, modifier = Modifier.fillMaxWidth())



        OutlinedTextField(
            value = password,
            onValueChange = {password=it},
            label = { Text(text="Enter Password") },modifier=Modifier.fillMaxWidth()
            , visualTransformation = PasswordVisualTransformation()
        )
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            isLoading=true
            authViewModel.login(email,password){
                    success,errorMeseeage->
                if(success){ isLoading=false
                    navController.navigate("home") {
                        popUpTo("auth") { inclusive = true} // i.e agr sign in kar ke home screen jyege aur back teepenge to
                        // wo phir sign  in pr nehi jyega
                        // we will have only home screen in the stack


                    } }
                else{ isLoading=false
                    AppUtil.showToast(context,errorMeseeage?:"Something went wrong")
                }
            }





        }, modifier = Modifier.fillMaxWidth()
            .height(60.dp),
            enabled = !isLoading) {
            Text(text = if(isLoading) "Loging In..." else " Log IN ", fontSize = 22.sp)
        }








    }

}