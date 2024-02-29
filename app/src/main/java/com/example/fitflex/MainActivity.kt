package com.example.fitflex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.fitflex.ui.theme.FitFlexTheme
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.fitflex.data.Strength
import com.example.fitflex.data.Endurance
import com.example.fitflex.data.strengths
import com.example.fitflex.data.endurances


i
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FitFlexTheme {

                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    FlexFitApp()
                }
            }
        }
    }
}




/**
 * Composable that displays an app for workout programs
 */
@Composable
fun FlexFitApp() {
    var selectedColumn by remember { mutableStateOf(1) }
    var isStrengthButtonEnabled by remember { mutableStateOf(true) }
    var isEnduranceButtonEnabled by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(2.dp, Color.Black)
    ) {
        Scaffold(
            topBar = {
                TopAppBar()
            }
        ) { it ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.Center)
            ) {

                Button(
                    onClick = {
                        selectedColumn = 1
                        isStrengthButtonEnabled = true
                        isEnduranceButtonEnabled = false
                    },
                    modifier = Modifier
                        .padding(8.dp),
                    enabled = isStrengthButtonEnabled
                ) {
                    Text(stringResource(R.string.button_strength))
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = {
                        selectedColumn = 2
                        isStrengthButtonEnabled = false
                        isEnduranceButtonEnabled = true
                    },
                    modifier = Modifier
                        .padding(8.dp),
                    enabled = isEnduranceButtonEnabled
                ) {
                    Text(stringResource(R.string.button_endurance))
                }

                Spacer(modifier = Modifier.height(16.dp))

                when (selectedColumn) {
                    1 -> StrengthList(strengths)
                    2 -> EnduranceList(endurances)
                }
            }
        }
    }
}






@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(modifier: Modifier = Modifier) {
    Box {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.app_topbar),
                    style = MaterialTheme.typography.displaySmall,
                )
            },
            modifier = modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .border(2.dp, MaterialTheme.colorScheme.primary)
        )
        Image(
            modifier = Modifier
                .size(dimensionResource(R.dimen.image_size_top))
                .padding(dimensionResource(R.dimen.padding_small)),
            painter = painterResource(R.drawable.custom_logo),


            contentDescription = null
        )
    }
}





@Composable
fun StrengthCard(strength: Strength, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(
                text = stringResource(strength.name),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            StrengthInformation(
                strengthName = strength.name,
                strengthNumber = strength.description
            )
        }
    }
}


@Composable
fun EnduranceCard(endurance: Endurance, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Text(
                text = stringResource(endurance.name),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            EnduranceInformation(
                enduranceName = endurance.name,
                enduranceNumber = endurance.description
            )
        }
    }
}







@Composable
fun StrengthList(strengthList: List<Strength>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(strengthList) { strength ->
            StrengthCard(
                strength = strength,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}



@Composable
fun EnduranceList(enduranceList: List<Endurance>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(enduranceList) { endurance ->
            EnduranceCard(
                endurance = endurance,
                modifier = Modifier.padding(dimensionResource(R.dimen.padding_small))
            )
        }
    }
}


/**
 * Composable that displays an app for workout programs
 */
@Composable
fun StrengthButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(stringResource(R.string.button_strength))
    }
}

/**
 * Composable that displays an app for workout programs
 */
@Composable
fun EnduranceButton(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .padding(8.dp)
    ) {
        Text(stringResource(R.string.button_endurance))
    }
}




/**
 * Composable that displays the strength icon
 */
@Composable
fun StrengthIcon(
    @DrawableRes strengthIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(strengthIcon),


        contentDescription = null
    )
}


/**
 * Composable that displays the endurance icon
 */
@Composable
fun EnduranceIcon(
    @DrawableRes enduranceIcon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(enduranceIcon),

        contentDescription = null
    )
}




/**
 * Composable that displays an app for workout programs
 */
@Composable
fun StrengthInformation(
    @StringRes strengthName: Int,
    strengthNumber: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(strengthName),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.program, strengthNumber),
        )
    }
}


@Composable
fun EnduranceInformation(
    @StringRes enduranceName: Int,
    enduranceNumber: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(enduranceName),
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
        Text(
            text = stringResource(R.string.program, enduranceNumber),
        )
    }
}





/**
 * PREVIEWS
 */



/**
 * Composable for light mode.
 */
@Preview
@Composable
fun FlexFitPreview() {
    FitFlexTheme(darkTheme = false) {
        FlexFitApp()
    }
}

/**
 * Composable for dark mode.
 */

