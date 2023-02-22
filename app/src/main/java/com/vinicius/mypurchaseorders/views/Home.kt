package com.vinicius.mypurchaseorders.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.AppBarDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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
                elevation = 0.dp
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_user_acount_top_app_bar),
                        contentDescription = "Icon user account",
                        modifier = androidx.compose.ui.Modifier.size(40.dp),
                    )
                    Text(
                        text = "Hi User", color = YellowDefault,
                        modifier = androidx.compose.ui.Modifier.padding(start = 10.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                        )
                }
                Row(
                    modifier = androidx.compose.ui.Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    Image(
                        imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_menu),
                        contentDescription = "Icon Baseline Menu",
                        modifier = androidx.compose.ui.Modifier
                            .size(45.dp)
                            .padding(end = 10.dp)
                    )
                }
            }
        }
    ) {

    }
}

@Preview
@Composable
fun HomePreview(){
    Home()
}