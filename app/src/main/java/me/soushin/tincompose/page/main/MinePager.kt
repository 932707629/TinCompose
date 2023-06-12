package me.soushin.tincompose.page.main

import android.transition.TransitionManager.go
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import me.soushin.tincompose.app.go
import me.soushin.tincompose.page.complex.ComplexAct


@Composable
fun MinePager(activity: MainActivity){
    println("每次都会走这里吗，，MinePager")

    Column(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max)
        .background(color = Color.Red)) { Text(text = "测试测试测试测试") }

}
