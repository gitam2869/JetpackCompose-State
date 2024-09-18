package com.app.basicstatecodelab

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun WellnessScreen(
    wellnessViewModel: WellnessViewmodel = viewModel(),
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        StateFulCounter()
        WellnessTasksList(
            list = wellnessViewModel.tasks,
            onCheckedTask = { wellnessTask, checked ->
                wellnessViewModel.changeTaskChecked(wellnessTask, checked)
            },
            onCloseTask = { wellnessTask ->
                wellnessViewModel.remove(wellnessTask)
            }
        )
    }
}


@Preview
@Composable
fun WellnessScreenPreview() {
    WellnessScreen()
}