package com.vinicius.mypurchaseorders.views

import android.annotation.SuppressLint
import android.icu.text.AlphabeticIndex.Bucket.LabelType
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.VerifiedUser
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vinicius.mypurchaseorders.R
import com.vinicius.mypurchaseorders.ui.theme.*


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Home(){


    var userName by remember {
        mutableStateOf("")
    }
    var userPassword by remember {
        mutableStateOf("")
    }
    var isPasswordVisible by remember {
        mutableStateOf(false)
    }
    val isFormaValid by derivedStateOf {
        userName.isNotBlank() && userPassword.length >= 7
    }




    Scaffold(
        backgroundColor = DarkBlackground
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            ) {
            Image(
                painter = painterResource(id = R.drawable.purchase_order_welcome),
                contentDescription ="logo app",
                    modifier = Modifier.size(128.dp)
            )
            Text(
                text = "Welcome",
                fontSize = 26.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(4.dp)
                )
            
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(0.dp, 35.dp, 0.dp, 0.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Bottom,
            ) {
                Card(
                    Modifier
                        .fillMaxSize()
                        .weight(2f)
                        .padding(
                            top = 8.dp,
                            start = 1.dp,
                            end = 1.dp,
                            bottom = 0.dp
                        ),
                    backgroundColor = GreyBox,
                    shape = RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)
                ) {
                    Column(
                        Modifier
                            .fillMaxSize()
                            .padding(top = 14.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                    ) {
                        Text(
                            text = "Login to your account",
                            color = Color.White,
                            fontWeight = FontWeight.Medium,
                            fontSize = 19.sp,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 18.dp)
                            )
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(
                                    top = 30.dp,
                                    start = 28.dp,
                                    end = 28.dp,
                                    bottom = 15.dp
                                ),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top
                        ) {

                            OutlinedTextField(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(14.dp),
                                value = userName ,
                                onValueChange = {userName = it},
                                label = { Text(text = "Username")},
                                singleLine = true,
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    trailingIconColor = GreyTextBox,
                                    unfocusedBorderColor = GreyTextBox,
                                    focusedBorderColor = BorderYellow,
                                    focusedLabelColor = YellowDefault,
                                    unfocusedLabelColor = GreyTextBox,
                                    textColor = Color.White,
                                    disabledTextColor = Grey,
                                    cursorColor = YellowDefault

                                ),
                                trailingIcon ={
                                    if (userName.isNotBlank())
                                        IconButton(onClick = {userName = ""}) {
                                            Icon(
                                                imageVector = Icons.Rounded.Clear,
                                                contentDescription = ""
                                            )
                                        }else{
                                            Icon(imageVector = Icons.Rounded.AccountCircle,
                                                contentDescription ="" )
                                        }
                                }
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            OutlinedTextField(
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(14.dp),
                                value = userPassword,
                                onValueChange = { userPassword = it },
                                label = { Text(text = "Password")},
                                visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                                singleLine = true,
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    trailingIconColor = GreyTextBox,
                                    unfocusedBorderColor = GreyTextBox,
                                    focusedBorderColor = BorderYellow,
                                    focusedLabelColor = YellowDefault,
                                    unfocusedLabelColor = GreyTextBox,
                                    textColor = Color.White,
                                    disabledTextColor = Grey,
                                    cursorColor = YellowDefault

                                ),
                                trailingIcon = {
                                    IconButton(onClick = {isPasswordVisible = !isPasswordVisible}) {
                                        Icon(
                                            imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                            contentDescription ="Password Toggle" )
                                    }
                                }
                            )
                            Spacer(modifier = Modifier.height(16.dp))
                            Button(
                                onClick = {},
                                enabled = isFormaValid,
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Orange_color,
                                    contentColor = Color.White,
                                    disabledBackgroundColor = Grey
                                )
                            ) {
                                Text(text = "Log In", fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MeuPreview(){
    Home()
}