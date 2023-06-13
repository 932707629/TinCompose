package me.soushin.tincompose.app.utils

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.blankj.utilcode.util.ActivityUtils

/**
 * 区域组件工具类
 * @author SouShin
 * created at 2023/6/13 09:15
 */
object ScopeUtils {

    @Composable
    fun buildTopBar(title: MutableState<String>, hasStatus:Boolean=true, isBack:Boolean=true){
        val modifier = if (hasStatus)Modifier.statusBarsPadding() else Modifier
        TopAppBar(modifier = modifier,) {
            if (isBack){
                IconButton(onClick = { ActivityUtils.getTopActivity().finish() }, modifier = Modifier) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "返回", modifier = Modifier.width(50.dp).height(50.dp).padding(10.dp))
                }
            }
            Text(text = title.value, textAlign = TextAlign.Center, modifier = Modifier.weight(1f), fontWeight = FontWeight.W700, fontSize = 18.sp)
            if (isBack){ Spacer(modifier = Modifier.width(50.dp)) }
        }
    }




}