package com.example.project2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.project2.ui.theme.Project2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   MainBox(modifier = Modifier)
                }
            }
        }
    }
}

@Composable
fun TextBox(head : String, body : String, colour: Color , modifier: Modifier = Modifier) {


        Column(
            Modifier
                .background(color = colour)
                .padding(all = 10.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) { Text(
                text = head,
                modifier = modifier.padding(all = 16.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center

            )
            Text(
                text = body,
                color = Color.Black,
                modifier = modifier
                    .padding(all = 16.dp)
                    .fillMaxSize()
                    .align(alignment = Alignment.End),
                textAlign = TextAlign.Justify



            )
        }

}
@Composable
fun MainBox(modifier: Modifier = Modifier) {


    Column(Modifier.fillMaxHeight()){
        Row(
            modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            TextBox(
                stringResource(R.string.text_composable),
                stringResource(R.string.text_para),
                Color(0xFFEADDFF),
                modifier
                    .weight(1f)
                    .fillMaxWidth(0.5f))
            TextBox(stringResource(R.string.image_composable),
                    stringResource(R.string.image_para),
                Color(0xFFD0BCFF),
                modifier
                    .weight(1f)
                    .fillMaxWidth())
        }

        Row(
            modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            TextBox(stringResource(R.string.row_composable),
                    stringResource(R.string.row_para),
                Color(0xFFB69DF8),
                modifier
                    .weight(1f)
                    .fillMaxWidth(0.5F))
            TextBox(stringResource(R.string.column_composable),
                    stringResource(R.string.column_para),
                Color(0xFFF6EDFF),
                modifier
                    .weight(1f)
                    .fillMaxWidth())
        }
    }


}
@Preview(showBackground = true ,
         showSystemUi = true
        )
@Composable
fun GreetingPreview() {
    Project2Theme {
        MainBox()
    }
}

//@Preview(showBackground = true ,
//    showSystemUi = true
//)
//@Composable
//fun GreetingPreview() {
//    Project2Theme {
//        TextBox("apple" , "mango " , Color(0xFFEADDFF))
//    }
//}