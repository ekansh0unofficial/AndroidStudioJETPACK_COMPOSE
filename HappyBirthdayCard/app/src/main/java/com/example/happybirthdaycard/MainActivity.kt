package com.example.happybirthdaycard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.happybirthdaycard.ui.theme.HappyBirthdayCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HappyBirthdayCardTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(stringResource(R.string.always_keep_on_smiling))

                }
            }
        }
    }
}
@Composable
fun GreetingText( message : String,modifier: Modifier = Modifier ) {

    Column(modifier = modifier , verticalArrangement = Arrangement.Center  ){
        Text(
            text = "$message \nIdiot❤",
            modifier = modifier.padding(10.dp),
            fontSize = 50.sp,
            lineHeight = 60.sp,
            textAlign = TextAlign.Start,
            color = Color.Black

        )
        Text(
            text = "from me",
            fontSize = 20.sp,
            modifier = Modifier
                .padding(10.dp , 0.dp , 10.dp , 10.dp)
                .fillMaxWidth(),
            textAlign = TextAlign.End,
            color = Color.Black
        )

    }

}

@Composable
fun GreetingImage(message : String , modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidparty)

    Box {
        Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha =  0.8F
        )


            GreetingText(
                message,
                Modifier
                    .padding(8.dp)
                    .background(color = Color.White).align(alignment =  Alignment.Center)
            )


    }
    
}

@Preview(
    showBackground = true ,
    showSystemUi = true
)
@Composable
fun BirthdayCardPreview() {
    HappyBirthdayCardTheme {

        GreetingImage("Always keep on smiling")

    }
}

