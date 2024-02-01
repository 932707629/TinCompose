package me.soushin.tincompose.page.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true, showSystemUi = true, device = Devices.NEXUS_7)
@Composable
fun MinePager(){
    println("每次都会走这里吗，，MinePager")

    Column(modifier = Modifier.fillMaxWidth().height(IntrinsicSize.Max)
        .background(color = Color.Red)) { Text(text = "测试测试测试测试") }

}
