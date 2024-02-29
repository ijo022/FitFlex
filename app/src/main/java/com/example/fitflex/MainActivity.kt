package com.example.fitflex

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.fitflex.data.Endurance
import com.example.fitflex.data.Strength
import com.example.fitflex.data.endurances
import com.example.fitflex.data.strengths
import com.example.fitflex.model.ToggleCountViewModel
import com.example.fitflex.ui.theme.FitFlexTheme
import com.example.fitflex.util.ToggleCount

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
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                Text("")
                Text("")
                Text("")
                Text("")

                Summary()

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




/**
 * Composable that displays top app bar
 */

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


/**
 * Composable that shows count
 */
@Composable
fun Summary(toggleCountViewModel: ToggleCountViewModel = viewModel()) {
    val checkedButtonsCount = remember { ToggleCount.getCheckedButtonsCount() }
    val completeSet = if (checkedButtonsCount == 4) 1 else 0

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        Text(text = "${stringResource(R.string.summary_1)} $completeSet ${stringResource(R.string.and)} $checkedButtonsCount")
        Text(text = "${stringResource(R.string.summary_2)}: $completeSet")
        Text(text = "${stringResource(R.string.summary_3)}: $checkedButtonsCount")
    }
}



/**
 * Composable that displays sets in each exercise
 */

@Composable
fun SetSummary(toggleCountViewModel: ToggleCountViewModel = viewModel()) {
    val checkedButtonsCount = remember { ToggleCount.getCheckedButtonsCount() }
    val completeSet = if (checkedButtonsCount == 4) 1 else 0

    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        SetItem(text = stringResource(R.string.Set_1), setNumber = 1)
        SetItem(text = stringResource(R.string.Set_2), setNumber = 2)
        SetItem(text = stringResource(R.string.Set_3), setNumber = 3)
        SetItem(text = stringResource(R.string.Set_4), setNumber = 4)

        Text(text = "Antall set: $checkedButtonsCount")

        // Display the resultValue
        Text(text = "Antall hele øvelser: $completeSet")
    }
}

/**
 * Composable that shows set item and check button
 */
@Composable
fun SetItem(text: String, setNumber: Int) {
    val isChecked = ToggleCount.isSetToggled(setNumber)

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(text = text)

        Switch(
            checked = isChecked,
            onCheckedChange = { newCheckedState ->
                if (newCheckedState) {
                    ToggleCount.toggleSet(setNumber)
                } else {
                    ToggleCount.unToggleSet(setNumber)
                }
            }
        )
    }
}





/**
 * Composable that displays strength card with all of the info required
 */
@Composable
fun StrengthCard(strength: Strength, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                VideoLink()
                StrengthIcon(strength.strengthicon)
                StrengthInformation(strength.name)
                Spacer(Modifier.weight(1f))
                StrengthInfoButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded },
                )
            }

            if (expanded) {
                SetSummary()

            }
        }
    }
}




/**
 * Composable that displays endurance card with all of the info required
 */
@Composable
fun EnduranceCard(endurance: Endurance, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(R.dimen.padding_small))
            ) {
                EnduranceIcon(endurance.enduranceicon)
                EnduranceInformation(endurance.name)
                Spacer(Modifier.weight(1f))
                EnduranceInfoButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded },
                )
            }

            if (expanded) {
                // Depending on your structure, you might have a different composable here
                SetSummary()
            }
        }
    }
}


/**
 * Composable for button Strength
 */
@Composable
private fun StrengthInfoButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null
        )
    }
}


/**
 * Composable for button Endurance
 */
@Composable
private fun EnduranceInfoButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            contentDescription = null
        )
    }
}


/**
 * Composable list of strength cards
 */
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


/**
 * Composable list of endurance cards
 */
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
 * Composable that displays the name/title for each exercise
 */
@Composable
fun StrengthInformation(
    @StringRes name: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(name),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))

        )
    }
}


/**
 * Composable that displays the name/title for each exercise
 */
@Composable
fun EnduranceInformation(
    @StringRes name: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(name),
            style = MaterialTheme.typography.displayMedium,
            modifier = Modifier.padding(top = dimensionResource(R.dimen.padding_small))
        )
    }
}








/**
 * Composable displaying the icon per exercise
 */

@Composable
fun EnduranceIcon(
    @DrawableRes enduranceicon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(enduranceicon),


        contentDescription = null
    )
}

/**
 * Composable displaying the icon per exercise
 */
@Composable
fun StrengthIcon(
    @DrawableRes strengthicon: Int,
    modifier: Modifier = Modifier
) {
    Image(
        modifier = modifier
            .size(dimensionResource(R.dimen.image_size))
            .padding(dimensionResource(R.dimen.padding_small))
            .clip(MaterialTheme.shapes.small),
        contentScale = ContentScale.Crop,
        painter = painterResource(strengthicon),


        contentDescription = null
    )
}


/**
 * Composable displaying video link
 */
@Composable
fun VideoLink(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    Text(
        text = "Video",
        modifier = modifier
            .clickable {
                // Open the video link when clicked
                // You can replace the URL with the actual video link
                val videoLink = "https://uit.no/enhet/ivt"
                context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(videoLink)))
            }
            .padding(top = 8.dp)
    )
}




/**
 * Composable displaying preview with support for dark/light mode
 */
@Preview
@Composable
fun FlexFitPreview() {
    FitFlexTheme(darkTheme = false) {
        FlexFitApp()
    }
}


