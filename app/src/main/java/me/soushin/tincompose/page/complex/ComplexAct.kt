package me.soushin.tincompose.page.complex

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import me.soushin.tincompose.R
import me.soushin.tincompose.app.DataBindingActivity
import me.soushin.tincompose.ui.theme.MyApplicationTheme

/**
 * 复杂布局
 * @author SouShin
 * created at 2023/6/6 10:12
 */
class ComplexAct  : DataBindingActivity<ComplexVM>() {

    override fun initView(savedInstanceState: Bundle?) {
        setContent {
            MyApplicationTheme() {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting() {
    val list = mutableListOf("","","","","")
    val name = stringResource(id = R.string.app_name)
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        item {
            Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "图片描述普通", modifier = Modifier
                    .width(100.dp)
                    .height(100.dp))
        }
        items(list){
            Text(text = "Hello $name!", style = TextStyle(color = Color.Green, fontSize = 45.sp))
            Spacer(modifier = Modifier.size(10.dp,))
//        Text(text = "Hello $name!", style = TextStyle(color = Color.White, fontSize = 45.sp))
//        Text(text = "Hello $name!", style = TextStyle(color = Color.Black, fontSize = 45.sp))
//        Text(text = "Hello $name!", style = TextStyle(color = Color.Blue, fontSize = 45.sp))
//        Text(text = "Hello $name!", style = TextStyle(color = Color.Cyan, fontSize = 45.sp))
            Text(text = "Hello $name!", style = TextStyle(color = Color.DarkGray, fontSize = 45.sp))
            Text(text = "Hello $name!", style = TextStyle(color = Color.Magenta, fontSize = 45.sp))

//            AndroidView(
//                factory = { return@AndroidView ImageView(it).apply {
//                    setImageResource(R.mipmap.ic_launcher)
//                } },
//                modifier = Modifier
//                    .width(100.dp)
//                    .height(100.dp)
//                    .clip(RoundedCornerShape(10.dp),),
//            )

//            val buttonText = remember { mutableStateOf("请登录") }
//            Button(onClick = { buttonText.value = if (buttonText.value.equals("请登录"))  "退出登录" else "请登录" }) {
//                Text(text = buttonText.value)
//            }

//            val textField = remember { mutableStateOf("") }

//            TextField(value = textField.value, onValueChange = { textField.value = it }, label = { Text(text = "居然在这里设置默认值") })
        }
        item {

            Row(horizontalArrangement = Arrangement.SpaceBetween) {
                Box {
                    Image(painter = painterResource(id = R.drawable.ic_launcher_background),
                        contentDescription = "头像", modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape))
                    Image(painter = painterResource(id = R.drawable.ic_launcher_foreground), contentDescription = "",
                        modifier = Modifier
                            .size(50.dp)
                            .align(Alignment.Center))
                }
                Spacer(modifier = Modifier.width(10.dp))
                Column {
                    Text(text = "标题吧这个是，会非常非常非常非常非常非常非常非常及非常长")
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "文本介绍吧这个是，会非常非常非常非常非常非常非常非常及非常长")
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, device = Devices.NEXUS_7)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {
            Greeting()
        }
    }
}