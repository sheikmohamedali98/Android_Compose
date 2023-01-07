package com.example.roundprogressbar

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : ComponentActivity() {


 private   lateinit var  connectivityManager:ConnectivityManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val  networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        // DownSpeed in MBPS
        val downSpeed = (networkCapabilities?.linkDownstreamBandwidthKbps)?.div(1000)

        // UpSpeed  in MBPS
        val upSpeed = (networkCapabilities?.linkUpstreamBandwidthKbps)?.div(1000)
        installSplashScreen()
        setContent {
            Column( modifier = Modifier.fillMaxSize() , horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center) {

                if (upSpeed != null) {
                    CircularProgressBar(percentage = 0.8f, number = upSpeed )
                }
            }

            Column (modifier = Modifier.fillMaxHeight(),verticalArrangement = Arrangement.Bottom){
                Button()
            }

        }
    }
}

@Composable
fun CircularProgressBar(
    percentage: Float,
    number: Int,
    fontSize: TextUnit = 28.sp,
    radius: Dp = 50.dp,
    color: Color = Color.Green,
    strokeWidth: Dp = 8.dp,
    animationDuration: Int = 1000,
    animationDelay: Int = 0,
) {
    var animatedPlay by remember {
        mutableStateOf(false)
    }

    val currentPercentage = animateFloatAsState(
        targetValue = if (animatedPlay) percentage else 0f,
        animationSpec = tween(durationMillis = animationDuration, delayMillis = animationDelay))

    LaunchedEffect(key1 = true){
        animatedPlay = true
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius*2f)
    ){
        Canvas(modifier = Modifier.size(radius*2f)){
            drawArc(
                color =  color,
                127f,
                360*currentPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(),cap = StrokeCap.Round)
            )
        }
        Text(text = (currentPercentage.value*number).toInt().toString(), color = Color.Black,
        fontWeight = FontWeight.Bold)
    }
}

@Composable
fun Button(){
    Row(
    modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,) {

        val context = LocalContext.current
        // Elevated Button
        Button(
            onClick = {
                Toast.makeText(context, "upload Speed", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.padding(8.dp),

            elevation = ButtonDefaults.elevation(),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = "Upload Speed")
        }

        // Rounded Button
        Button(
            onClick = {
                Toast.makeText(context, "Download Speed", Toast.LENGTH_SHORT).show()

            },
            modifier = Modifier.padding(8.dp),
            shape = RoundedCornerShape(20.dp)
        ) {
            Text(text = "Download Speed")
        }

    }
}
