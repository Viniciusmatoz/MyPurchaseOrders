package com.vinicius.mypurchaseorders.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vinicius.mypurchaseorders.R
import com.vinicius.mypurchaseorders.ui.theme.*
import java.lang.reflect.Modifier

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun Home(){
    Scaffold(
        backgroundColor = DarkBlackground,
        topBar = {
            TopAppBar(
                modifier = androidx.compose.ui.Modifier.padding(top = 10.dp),
                backgroundColor = DarkBlackground,
                elevation = 0.dp,
            ) {
                Row(
                    modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_menu),
                        contentDescription = "Icon baseline menu",
                        modifier = androidx.compose.ui.Modifier.size(40.dp),
                    )
                    Text(
                        text = "Purchase Orders", color = YellowDefault,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                        )
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_settings),
                        contentDescription = "Icon Settings",
                        modifier = androidx.compose.ui.Modifier
                            .size(40.dp)
                            .padding(end = 2.dp)
                    )
                } }
            }
    ) {
        Column(
            modifier = androidx.compose.ui.Modifier
                .padding(top = 15.dp, start = 15.dp, end = 15.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = androidx.compose.ui.Modifier.size(width = 500.dp, height = 250.dp),
                backgroundColor = YellowDefault,
            ) {
            }
        }
    }
}

@Preview
@Composable
fun HomePreview(){
    Home()
}