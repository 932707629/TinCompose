package me.soushin.tincompose.page.main

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.blankj.utilcode.util.ActivityUtils
import com.google.accompanist.flowlayout.FlowRow
import me.soushin.tincompose.page.complex.ComplexAct
import me.soushin.tincompose.page.simple.SimpleAct

@Preview(showBackground = true, showSystemUi = true, device = Devices.NEXUS_7)
@Composable
fun HomePager(){

    println("每次都会走这里吗，，HomePager")
    FlowRow(modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
        mainAxisSpacing = 10.dp
    ) {
        Button(onClick = { ActivityUtils.startActivity(SimpleAct::class.java) }) {
            Text(text = "基础控件")
        }
        Button(onClick = { ActivityUtils.startActivity(ComplexAct::class.java) }) {
            Text(text = "复杂")
        }
    }

}
