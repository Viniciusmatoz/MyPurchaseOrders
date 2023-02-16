package com.vinicius.mypurchaseorders.views

import android.annotation.SuppressLint
import android.icu.text.AlphabeticIndex.Bucket.LabelType
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material.icons.rounded.Person
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.HorizontalAlignmentLine
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
                            Spacer(modifier = Modifier.height(1.dp))

                            Column(
                                Modifier.fillMaxWidth()
                            ) {
                                TextButton(onClick = {},
                                ) {
                                    Text(text = "Forgot Password?",
                                        color = BorderYellow,
                                        textAlign = TextAlign.Start
                                    )
                                }
                            }
                            Button(
                                onClick = {},
                                enabled = isFormaValid,
                                modifier = Modifier.fillMaxWidth(),
                                shape = RoundedCornerShape(16.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = YellowDefault,
                                    contentColor = text_Blue,
                                    disabledBackgroundColor = YellowDefault,
                                    disabledContentColor = text_Blue
                                )
                            ) {
                                Text(text = "Log In", fontWeight = FontWeight.ExtraBold, fontSize = 16.sp)
                            }

                            Column(
                                Modifier
                                    .fillMaxWidth()
                                    .padding(top = 50.dp),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally

                            ) {
                                Text(text = "Or sign in with", color = Color.White, modifier = Modifier.padding(bottom = 10.dp))
                            }
                            Row(modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            Arrangement.SpaceAround) {
                                Button(onClick = { /*TODO*/ },
                                    shape = RoundedCornerShape(50),
                                    modifier = Modifier
                                        .height(70.dp)
                                        .width(70.dp),
                                    colors = ButtonDefaults.buttonColors(GreyBox),
                                ){
                                    Image(painter = painterResource(id = R.drawable.ic_google),
                                        contentDescription ="google logo",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }
                                Button(onClick = { /*TODO*/ },
                                    shape = RoundedCornerShape(50),
                                    modifier = Modifier
                                        .height(70.dp)
                                        .width(70.dp),
                                    colors = ButtonDefaults.buttonColors(GreyBox),
                                ){
                                    Image(painter = painterResource(id = R.drawable.ic_facebook),
                                        contentDescription ="facebook logo",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }

                                Button(onClick = { /*TODO*/ },
                                    shape = RoundedCornerShape(50),
                                    modifier = Modifier
                                        .height(70.dp)
                                        .width(70.dp),
                                    colors = ButtonDefaults.buttonColors(GreyBox),
                                ){
                                    Image(painter = painterResource(id = R.drawable.ic_telegram),
                                        contentDescription ="telegram logo",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }

                                Button(onClick = { /*TODO*/ },
                                    shape = RoundedCornerShape(50),
                                    modifier = Modifier
                                        .height(70.dp)
                                        .width(70.dp),
                                    colors = ButtonDefaults.buttonColors(GreyBox),
                                ){
                                    Image(painter = painterResource(id = R.drawable.ic_twitter),
                                        contentDescription ="Twitter logo",
                                        contentScale = ContentScale.Fit,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                }
                            }
                        }
                    }
                    Column(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.Bottom
                    ) {
                        Divider(color = LineGrey)
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(text = "Don't have an account?",
                                color = Color.White,
                                modifier = Modifier.padding(start = 2.dp))
                            TextButton(onClick = {}) {
                                Text(text = "SIGN UP",
                                    color = YellowDefault,
                                    modifier = Modifier.padding(start = 2.dp),
                                )
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
fun PreviewV(){
    Home()
}