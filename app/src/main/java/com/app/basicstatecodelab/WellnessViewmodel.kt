package com.app.basicstatecodelab

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel

class WellnessViewmodel : ViewModel() {
    private val _tasks = getWellnessTasks().toMutableStateList()
    val tasks: List<WellnessTask>
        get() = _tasks

    fun remove(wellnessTask: WellnessTask) {
        _tasks.remove(wellnessTask)
    }

    fun changeTaskChecked(wellnessTask: WellnessTask, checked: Boolean) {
        _tasks.find { it.id == wellnessTask.id }?.let {
            it.checked = checked
        }
    }
}


private fun getWellnessTasks(): List<WellnessTask> {
    return List(30) { i -> WellnessTask(i, "Task # $i") }
}