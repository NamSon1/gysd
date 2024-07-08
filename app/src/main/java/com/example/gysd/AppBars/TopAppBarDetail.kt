package com.example.gysd.AppBars

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.gysd.R
import com.example.gysd.ui.theme.backGroundgrey
import com.example.gysd.ui.theme.black

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopBarDetail(navController: NavController) {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = backGroundgrey,
            titleContentColor = black,
        ),

        navigationIcon = {
            val context = LocalContext.current
            var finishActivity by remember { mutableStateOf(false) }

            navController.popBackStack()

            IconButton(
                onClick = {
                    finishActivity = true
                    /*TODO*/
                }
            ) {
                Icon(imageVector = ImageVector.vectorResource(id = R.drawable.arrow_backarrow_back), contentDescription = null)
            }
        },

        title = {
            Text(
                text = "DetailScreen",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(end = 40.dp),
                color = Color.Black,
            )
        },


        )
}