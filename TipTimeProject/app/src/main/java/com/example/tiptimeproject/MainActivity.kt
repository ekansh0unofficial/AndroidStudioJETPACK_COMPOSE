@file:OptIn(ExperimentalMaterial3Api::class)
//states , remember function , mutable function , text box , keyboard options
//state hoisting , action button , switch , scroll button/

package com.example.tiptimeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.VisibleForTesting
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tiptimeproject.ui.theme.TipTimeProjectTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TipTimeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipTimeLayout()
                }
            }
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun TipTimeLayout(modifier: Modifier = Modifier
    .fillMaxSize()
   // .verticalScroll(rememberScrollState())
    ) {

    var amountInput by remember {
        mutableStateOf("")
    }
    val amount = amountInput.toDoubleOrNull() ?: 0.0

    var tipInput by remember {
        mutableStateOf("")
    }
    val tip = tipInput.toDoubleOrNull() ?: 0.0

    var roundUp by remember {
        mutableStateOf(false)
    }

    val tipOut  = calculateTip(roundUp ,amount , tip)


    Column(
        modifier = modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number , imeAction = ImeAction.Next),
           leadingIcon = R.drawable.money,
            label = R.string.bill_amount ,
            value = amountInput ,
            onValueChange = { amountInput = it },
           modifier =  modifier.padding(bottom = 32.dp)
        )

        EditNumberField(
            keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number , imeAction = ImeAction.Done),
            leadingIcon = R.drawable.percent,
            label = R.string.how_was_the_service ,
            value = tipInput ,
            onValueChange = { tipInput = it },
            modifier =  modifier.padding(bottom = 32.dp)
        )

        RoundTheTip(roundUp = roundUp, onRoundChanged ={roundUp = it} ,Modifier.padding(32.dp) )

        Text(
            text = stringResource(R.string.tip_amount, tipOut),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = modifier.height(150.dp))

    }
}
@VisibleForTesting
internal fun calculateTip(roundUp: Boolean, amount: Double, tipPercent: Double ): String {
    var tip = tipPercent * amount / 100

    if(roundUp){
       tip = kotlin.math.ceil(tip)
    }
    return NumberFormat.getCurrencyInstance().format(tip)
}

@ExperimentalMaterial3Api
@Composable
fun EditNumberField(
    @StringRes label: Int,
    @DrawableRes leadingIcon : Int,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier ,
    keyboardOptions : KeyboardOptions
){

    TextField(
        value = value ,
        onValueChange =onValueChange ,
        leadingIcon = { Icon(painter = painterResource(id = leadingIcon), null) },
        modifier = Modifier
            .padding(all = 10.dp)
            .background(color = Color.Green)
            .fillMaxWidth(),
        label = { Text(stringResource(label)) },
        singleLine = true,
        //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number , imeAction = ImeAction.Next)
        keyboardOptions = keyboardOptions
    )
}

@Composable
fun RoundTheTip(roundUp : Boolean ,onRoundChanged :(Boolean)->Unit,modifier: Modifier = Modifier){

    Row (
        verticalAlignment = Alignment.CenterVertically,
       modifier = modifier
           .fillMaxWidth()
           .size(48.dp),

    ){
        Text(text = stringResource(R.string.round_up_tip))

        Switch(checked = roundUp, onCheckedChange = onRoundChanged,
                modifier = modifier
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.End)

            )

    }

}

@ExperimentalMaterial3Api
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun TipTimeProjectApp() {
    TipTimeProjectTheme {
        TipTimeLayout()
    }
}
