package com.app.basicstatecodelab

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


private const val TAG = "WellnessTasksList"

@Composable
fun WellnessTasksList(
    list: List<WellnessTask>,
    onCheckedTask: (WellnessTask, Boolean) -> Unit,
    onCloseTask: (WellnessTask) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = list,
            key = { task -> task.id }
        )
        { task ->
            Log.d(TAG, "WellnessTasksList: id ${task.id}")
            WellnessTaskItem(
                taskName = task.label,
                checked = task.checked,
                onCheckChange = { checked ->
                    onCheckedTask(task, checked)
                },
                onClose = {
                    onCloseTask(task)
                })
        }
    }
}
