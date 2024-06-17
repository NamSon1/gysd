package com.example.gysd.Screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gysd.R
import com.example.gysd.ui.theme.backGroundgrey
import com.example.gysd.ui.theme.black

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun SettingsScreen() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.drawBehind {
                    val strokeWidth = 100 * density
                    val y = size.height - strokeWidth / 2

                    drawLine(
                        Color.LightGray,
                        Offset(0f, y),
                        Offset(size.width, y),
                        strokeWidth
                    )
                },

                title = {
                    Text(
                        "Settings",
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                    )
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = backGroundgrey,
                    titleContentColor = black,
                ),
            )
        }

    ){
        //Hauptstruktur: Anordung aller Elemente und Elementgruppen in einer Spalte (Column)
        Column(
            Modifier
                .fillMaxSize()
                .background(backGroundgrey)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            ){

            NotificationsGroup()
            AboutUsGroup()
        }
    }
}


@Composable
fun NotificationsGroup(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        // Notification-Überschrift
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Text(
                text = "NOTIFICATIONS",
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        // Lock screen alert - Row
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Lock Screen Alert",
                fontSize = 20.sp,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.weight(1f))
            MySwitch()
        }

        // Push Notifications - Row
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Push Notifications",
                fontSize = 20.sp,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.weight(1f))
            MySwitch()
        }

        // Sounds - Row
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Sounds",
                fontSize = 20.sp,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.weight(1f))
            MySwitch()
        }

        // Vibration Notifications - Row
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Vibration Notifications",
                fontSize = 20.sp,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.weight(1f))
            MySwitch()
        }
        Spacer(modifier = Modifier.size(25.dp))
    }
}


@Composable
fun AboutUsGroup(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ){
        // About_Us - Überschrift
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ){
            Text(
                text = "ABOUT US",
                style = MaterialTheme.typography.titleMedium,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        // Our Website - Row
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Our Website",
                fontSize = 20.sp,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.weight(1f))
            /*  - IconButton welcher "Expandable Text" aufklappt
                    - https://stackoverflow.com/questions/68894585/expandable-text-in-jetpack-compose
                    - https://medium.com/@munbonecci/how-to-implement-expandable-text-in-jetpack-compose-ca9ba35b645c
                    - https://arkadiuszchmura.com/posts/how-to-make-expandable-text-with-a-button-in-jetpack-compose/
                - oder als "Expandable Card" implementieren

             */
            IconButton(
                onClick = { /*TODO*/ }
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.sf_symbol__expandicon),
                    contentDescription = null
                )
            }
        }

        // Privacy Policy - Row
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Privacy Policy",
                fontSize = 20.sp,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = { /*TODO*/ }
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.sf_symbol__expandicon),
                    contentDescription = null
                )
            }

        }

        // Terms Of Service - Row
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Terms Of Service",
                fontSize = 20.sp,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = { /*TODO*/ }
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.sf_symbol__expandicon),
                    contentDescription = null
                )
            }
        }

        // Support Us - Row
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(
                text = "Support Us",
                fontSize = 20.sp,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = { /*TODO*/ }
            ){
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.sf_symbol__expandicon),
                    contentDescription = null
                )
            }
        }
    }
}


////////////////////////////////////////////////////////////////////////////////////////////////////

@Composable
private fun MySwitch(){
    var switch by remember {
        mutableStateOf(ToggleableInfo(
            isChecked = false,
            text = ""
        ))
    }

    Switch(
        checked = switch.isChecked,
        onCheckedChange = {isChecked ->
            switch = switch.copy(isChecked = isChecked)
        }
    )
}

////////////////////////////////////////////////////////////////////////////////////////////////////



