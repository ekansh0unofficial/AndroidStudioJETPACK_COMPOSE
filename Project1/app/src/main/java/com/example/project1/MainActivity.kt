package com.example.project1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.project1.ui.theme.Project1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project1Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Introduction(
                        stringResource(R.string.jetpack_compose_tutorial) ,
                        stringResource(R.string.intro_to_jetpack),
                        stringResource(R.string.para)

                    )
                }
            }
        }
    }
}

@Composable
fun Introduction(heading: String, intro : String , para : String ,    modifier: Modifier = Modifier) {

    val image = painterResource(R.drawable.bg_compose_background)

    Column {
        Image(
            painter = image,
            contentDescription = null,
            modifier.fillMaxWidth(),

        )

        Text(
            text = heading,
            fontSize = 20.sp,
            modifier = modifier
        )

        Text(
            text = intro,
            modifier.padding(all= 15.dp),
            textAlign = TextAlign.Justify,

            )

        Text(
            text = para,
            modifier.padding(all= 15.dp),
            textAlign = TextAlign.Justify,

            )
    }
}

@Preview(showBackground = true ,
         showSystemUi = true,  )
@Composable
fun IntroductionPreview() {
    Project1Theme {
        Introduction(
            stringResource(R.string.jetpack_compose_tutorial) ,
            stringResource(R.string.intro_to_jetpack) ,
            stringResource(R.string.para)
        )
    }
}