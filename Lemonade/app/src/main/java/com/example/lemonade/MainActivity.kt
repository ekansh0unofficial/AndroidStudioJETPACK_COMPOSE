package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   LemonadeApp()
                }
            }
        }
    }
}


@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {

    val random by remember {
        mutableStateOf((2..4).random())
    }
    var value by remember {
        mutableStateOf(1)
    }
    var imageSource = when (value) {
        1 -> R.drawable.lemon_tree
        2-> R.drawable.lemon_squeeze
        random+2 -> R.drawable.lemon_drink
        random+3 -> R.drawable.lemon_restart
        else -> R.drawable.lemon_squeeze
    }
    var textSource = when (value){
        1 -> R.string.lemon_tree
        2 -> R.string.lemon
        random+2 -> R.string.lemon_juice
        random+3 -> R.string.empty_glass
        else -> R.string.lemon
    }
    var colorSource = when (value){
        1 -> R.color.teal_200
        2 -> R.color.yellow
        random+2 -> R.color.green
        random+3 -> R.color.white
        else -> R.color.yellow
    }
    Box(
        modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.white))) {

        Row(verticalAlignment = Alignment.Top,horizontalArrangement = Arrangement.Center ) {
            Text(
                text = "Lemonade",
                modifier = modifier
                    .fillMaxWidth()
                    .background(color = Color(255, 235, 59, 255)),
                textAlign = TextAlign.Center,
                fontSize = 24.sp,
                color = Color.Black,
            )
        }
        Column(modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally ,
            verticalArrangement = Arrangement.Center,

            ) {

            FilledTonalButton(
                shape = RoundedCornerShape(10.dp),
                onClick = {
                    if(value == random+3){value = 1}
                    else {value++}
                          },
                colors = ButtonDefaults.outlinedButtonColors(colorResource(id = colorSource))

            ) {

                Image(painter = painterResource(imageSource), contentDescription = "NULL")
            }
            Spacer(modifier.height(20.dp))
            Text(text = stringResource(textSource) , modifier.fillMaxWidth(),textAlign = TextAlign.Center,color = Color.Black )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}

