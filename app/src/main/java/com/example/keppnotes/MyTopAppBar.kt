package com.example.keppnotes

import android.annotation.SuppressLint
import android.media.Image
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.keppnotes.ui.theme.Purple40
import com.example.keppnotes.ui.theme.PurpleGrey80

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MyTopAppBar(){
    val value by rememberInfiniteTransition().animateFloat(
        initialValue = 25f,
        targetValue = -25f,
        animationSpec = infiniteRepeatable(
            animation = tween(
                durationMillis = 600,
                easing = LinearEasing
            ),
            repeatMode = RepeatMode.Reverse
        )
    )
    var isMenuVisible by remember { mutableStateOf(false) }
    TopAppBar(//barra de menu parte superior de la pantalla
        title = {
            Text(text = "KeepNotes", color = Color.White, fontSize = 20.sp) //nombre que aparece en la barra
        },
        navigationIcon = {
            IconButton(
                onClick = {
                }
            ) {
                Icon(//Icono de las tres barras horizontales
                    imageVector = Icons.Default.Menu,
                    contentDescription = null,
                    tint = Color.White
                )
            }
        },
        actions = {
            IconButton(onClick = { isMenuVisible = !isMenuVisible }) {
                Icon(
                    imageVector = Icons.Filled.Notifications,
                    contentDescription = "Menu",
                    tint = Color.White,
                    modifier = Modifier
                        .graphicsLayer(
                            transformOrigin = TransformOrigin(
                                pivotFractionX = 0.5f,
                                pivotFractionY = 0.0f,
                            ),
                            rotationZ = value
                        )
                )

            }
            IconButton(onClick = { isMenuVisible = !isMenuVisible }) {
                Icon(imageVector = Icons.Filled.MoreVert, contentDescription = "Menu", tint = Color.White)
            }


        },
        colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color.Transparent),

    )
}