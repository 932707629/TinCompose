package me.soushin.tincompose.page.main

import android.transition.TransitionManager.go
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.layout.LazyLayout
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import com.google.accompanist.flowlayout.FlowColumn
import com.google.accompanist.flowlayout.FlowRow
import me.soushin.tincompose.app.go
import me.soushin.tincompose.page.complex.ComplexAct
import me.soushin.tincompose.page.simple.SimpleAct
import org.intellij.lang.annotations.JdkConstants
import java.util.concurrent.Flow


@Composable
fun HomePager(activity: MainActivity){

    println("每次都会走这里吗，，HomePager")
    FlowRow(modifier = Modifier.fillMaxWidth().padding(horizontal = 15.dp),
        mainAxisSpacing = 10.dp
    ) {
        Button(onClick = { activity.go(SimpleAct::class.java) }) {
            Text(text = "基础控件")
        }
        Button(onClick = { activity.go(ComplexAct::class.java) }) {
            Text(text = "复杂")
        }
    }

}
