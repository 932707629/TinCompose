package me.soushin.tincompose.page.main

import android.transition.TransitionManager.go
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import me.soushin.tincompose.app.go
import me.soushin.tincompose.page.complex.ComplexAct


@Composable
fun HomePager(activity: MainActivity){

    Column(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max)) {
        Button(onClick = { activity.go(ComplexAct::class.java) }) {
            Text(text = "复杂")
        }
    }

}
