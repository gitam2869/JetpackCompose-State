package com.app.basicstatecodelab

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

private const val TAG = "WaterCounter"

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp)
    ) {
        var count by rememberSaveable { mutableStateOf(0) }
        if (count > 0) {
            Text(text = "You have had $count glasses.")
        }
        Button(
            modifier = Modifier.padding(top = 8.dp),
            onClick = { count++ },
            enabled = count < 10
        ) {
            Text(text = stringResource(R.string.add_one))
        }
    }
}

@Composable
fun StateFulCounter(
    modifier: Modifier = Modifier
) {
    Log.d(TAG, "StateFulCounter: ")
    var count by remember { mutableStateOf(0) }
    var juiceCount by remember { mutableStateOf(0) }

    Column {
        StateLessCounter("Water", count, { count++ }, modifier)
    }
}

@Composable
fun StateLessCounter(
    title: String,
    count: Int,
    onIncrement: () -> Unit,
    modifier: Modifier = Modifier
) {
    Log.d(TAG, "StateLessCounter: $title")
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        if (count > 0)
            Text(text = "You have had $count glasses.")

        Button(
            onClick = { onIncrement() },
            enabled = count < 10,
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text(text = stringResource(id = R.string.add_one))
        }
    }
}


@Preview(showBackground = true)
@Composable
fun WaterCounterPreview() {
    StateFulCounter()
}