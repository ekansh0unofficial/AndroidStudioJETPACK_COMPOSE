package com.example.project3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project3.ui.theme.Project3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project3Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Viewpage()           }
            }
        }
    }
}

@Composable
fun TitleBlock(name: String, title : String , modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.androidlogo)
   Column(
        verticalArrangement = Arrangement.Center,
       horizontalAlignment = Alignment.CenterHorizontally
   ) {

       Image(
           painter = image,
           modifier = modifier,
           contentDescription = null
       )
       Text(
           text = name,
           color = Color.Black,
           modifier = modifier,
           fontSize = 25.sp
       )
       Spacer(modifier = modifier.width(10.dp))
       Text(
           text = title,
           color = Color(14, 150, 67, 255),
           fontWeight = FontWeight.Bold
       )
   }
}

@Composable
fun InfoBox(modifier: Modifier = Modifier){

    //val call = Icon(Icons.Rounded.Call, contentDescription = null )
    Column(modifier.padding(all = 20.dp) , verticalArrangement = Arrangement.Bottom , horizontalAlignment = Alignment.CenterHorizontally) {
        Row(horizontalArrangement = Arrangement.Start) {

            Icon(Icons.Rounded.Call, contentDescription = null)
            Spacer(modifier = modifier.width(10.dp))
            Text(
                    text = "+91 xxx -xxxx-xxx",

                )
        }

        Row(horizontalArrangement = Arrangement.Start){

            Icon(Icons.Rounded.Share, contentDescription = null )
            Spacer(modifier = modifier.width(10.dp))
            Text(
                text = "@instagramprofile"
            )
        }

        Row (horizontalArrangement = Arrangement.Start){

            Icon(Icons.Rounded.Email, contentDescription = null)
            Spacer(modifier = modifier.width(10.dp))
            Text(
                text = "email.id@web.com"
            )
        }
    }
}

@Composable
fun Viewpage(modifier: Modifier = Modifier){
    Surface(color = Color(134, 241, 138, 255))
    {
        TitleBlock("Ekansh Mittal ", "Learner")
        InfoBox()
    }
}


@Preview(showBackground = true,
         showSystemUi = true)
@Composable
fun GreetingPreview() {
    Project3Theme {
            Viewpage()
    }
}