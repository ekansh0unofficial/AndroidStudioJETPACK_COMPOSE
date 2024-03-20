package com.example.superheroes

import SuperheroesTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.data.HeroList.heroes
import com.example.superheroes.model.Hero

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                }
            }
        }
    }
}


@Composable
fun HeroCard( myHero : Hero, modifier: Modifier = Modifier.padding(8.dp)) {
    Card(shape = RoundedCornerShape(16.dp) , modifier = Modifier, elevation = CardDefaults.cardElevation(20.dp) ){
        Row(
            modifier
                .padding(16.dp)
                .fillMaxWidth()  ,Arrangement.SpaceAround) {
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = stringResource(myHero.heroName),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = stringResource(id = myHero.heroDescription),
                    style = MaterialTheme.typography.bodySmall,
                    softWrap = true,
                    modifier = Modifier.width(200.dp)

                )
            }
            Image(
                painter = painterResource(myHero.heroImage),
                contentDescription =toString() ,
                modifier = Modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))

            )
        }
    }


}

@Composable
fun topBar(modifier: Modifier = Modifier){
    Row(
        horizontalArrangement = Arrangement.Center ,
        modifier = modifier
            .fillMaxWidth()
        ){
        Text(
            text = "SuperHeroes",
            style = MaterialTheme.typography.displayLarge
        )
    }
}

@Composable
fun HeroApp(modifier: Modifier = Modifier){
    Scaffold(topBar = {topBar()}){
        LazyColumn(contentPadding = it) {
            items(heroes) {
                HeroCard(myHero = it)
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true

    )
@Composable
fun GreetingPreview() {
    SuperheroesTheme {
        HeroApp()
    }
}