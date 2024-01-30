package com.example.artgalleryproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artgalleryproject.ui.theme.ArtGalleryProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtGalleryProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppActivity()
                }
            }
        }
    }
}


@Composable
fun Layout(paintID : Int ,stringID1 : Int ,stringID2 : Int,value: Int,onValuePrev :()->Unit ,onValueNext :()->Unit , modifier: Modifier = Modifier){
    Surface(modifier = Modifier.fillMaxSize()) {
        Column( modifier = Modifier
            .wrapContentSize()
            .fillMaxSize() ,
            horizontalAlignment = Alignment.CenterHorizontally
            ) {

            Image(
                painter = painterResource(paintID),
                contentDescription = "Sample",
                modifier = modifier
                    .size(600.dp)
                    .padding(32.dp),


            )

            Column(modifier = modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(stringID1) ,
                        textAlign = TextAlign.Justify ,
                        modifier = modifier.padding(4.dp),
                        fontWeight = FontWeight(700),
                        fontStyle = FontStyle.Italic,
                        fontSize = 20.sp
                    )

                    Text(
                        text = stringResource(stringID2),
                        textAlign = TextAlign.Justify ,
                        modifier = modifier.padding(4.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp


                    )
            }

            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.SpaceEvenly) {

                Button(onClick = onValuePrev) {
                    Text(
                        text = "Previous" ,
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                        )
                }

                Button(onClick = onValueNext) {
                    Text(
                        text = "   Next   " ,
                        fontSize = 20.sp,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }
        }
    }
}

@Composable
fun Default(value : Int , onValueChange :()->Unit , modifier :Modifier = Modifier){

    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(R.drawable.background),
            contentDescription ="background" ,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.fillMaxSize(),

            ) {
            Text(
                text = "Welcome To Art Gallery",
                fontWeight = FontWeight.Bold,
                fontSize = 72.sp,
                letterSpacing = 3.sp,
                lineHeight = 85.sp,
                textAlign = TextAlign.Center,
                color = Color(243, 236, 255, 255),
                fontFamily = FontFamily.Serif


            )
            Spacer(Modifier.height(100.dp))
            Button(onClick = onValueChange , colors = ButtonDefaults.buttonColors(
                Color(0, 137, 123, 255)
            )) {
                Text(text = "to the gallery ->", fontSize = 22.sp)
            }
        }
    }
}


@Composable
fun AppActivity(modifier :Modifier = Modifier){
    var value by remember{
        mutableIntStateOf(0)
    }
    val onValueNext :() ->Unit = {
        if(value < 5){
            value++
        }
    }
    val onValuePrev :() ->Unit ={
            if(value>0){
                value--
            }
    }

    when(value){
        1 -> Layout(R.drawable.mona_lisa,R.string.mona_lisa,R.string.mona_lisa_artist, value = value ,onValuePrev , onValueNext)
        2 -> Layout(R.drawable.starry_night,R.string.starry_night,R.string.starry_night_artist,value ,onValuePrev , onValueNext)
        3 -> Layout(R.drawable.girl_with_pearl_earring,R.string.girl_with_pearl_earring,R.string.girl_with_pearl_earring_artist,value ,onValuePrev , onValueNext)
        4 -> Layout(R.drawable.the_last_supper,R.string.the_last_supper,R.string.last_supper_artist,value ,onValuePrev , onValueNext)
        5 -> Layout(R.drawable.the_scream,R.string.the_scream,R.string.scream_artist,value ,onValuePrev , onValueNext)
        else -> Default(value ,onValueNext)

    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
    )
@Composable
fun LayoutPreview() {
    ArtGalleryProjectTheme {
        AppActivity()
    }
}

