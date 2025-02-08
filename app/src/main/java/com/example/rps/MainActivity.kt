package com.example.rps

import android.media.Image
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.rps.ui.theme.RPSTheme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.FontScaling
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RPSTheme {
                Pokable(Modifier.fillMaxSize() )
            }
        }
    }
}

@Composable
fun Pokable(modifier: Modifier) {
    Column(
        modifier = modifier
    ) {
        var color1 by remember { mutableStateOf(Color.LightGray) }
        var color2 by remember { mutableStateOf(Color.Gray) }
        var color3 by remember { mutableStateOf(Color.DarkGray) }

        Box(
            modifier = modifier
                .background(color1)
                .clickable { color1 = toggleColor(color1, Color.LightGray, Color.Red) }
                .weight(1f),
            contentAlignment = Alignment.Center
        ){
            Text("Red", fontSize = 32.sp)
        }
        Box(
            modifier = modifier
                .background(color2)
                .clickable { color2 = toggleColor(color2, Color.Gray, Color.Green) }
                .weight(1f),
            contentAlignment = Alignment.Center
        ){
            Text("Green", fontSize = 32.sp)
        }
        Box(
            modifier = modifier
                .background(color3)
                .clickable { color3 = toggleColor(color3, Color.DarkGray, Color.Blue) }
                .weight(1f),
            contentAlignment = Alignment.Center
        ){
            Text("Blue", fontSize = 32.sp)
        }

        if (color1 == Color.Red && color2 == Color.Green && color3 == Color.Blue) {
            Image(
                painter = painterResource(id = R.drawable.colors),
                contentDescription = "All colors activated!",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}

fun toggleColor(currentColor: Color, defaultColor: Color, alternateColor: Color): Color {
    return if (currentColor == defaultColor) alternateColor else defaultColor
}