package me.soushin.tincompose.page.simple

import android.os.Bundle
import android.widget.TextView
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.BitmapCompat
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.request.ImageRequest
import com.google.accompanist.flowlayout.FlowRow
import me.soushin.tincompose.R
import me.soushin.tincompose.app.DataBindingActivity
import me.soushin.tincompose.app.utils.ScopeUtils
import me.soushin.tincompose.ui.theme.MyApplicationTheme
import okhttp3.OkHttpClient

class SimpleAct : DataBindingActivity<SimpleVM>() {

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

    Scaffold(
        topBar = {
            ScopeUtils.buildTopBar(title = remember { mutableStateOf("基础页面") }, hasStatus = true, isBack = true)
        },
        content = { p->
            p.calculateTopPadding()

            LazyColumn(content = {
                item {
                    FlowRow(mainAxisSpacing = 10.dp, crossAxisSpacing = 10.dp) {
                        Text(text = "上左圆角", modifier = Modifier
                            .padding(10.dp)
                            .clip(RoundedCornerShape(topStart = 10.dp,))
                            .background(color = Color.Green)
                            .width(100.dp)
                            .height(100.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically)
                            .wrapContentWidth(align = Alignment.CenterHorizontally))
                        Text(text = "上右圆角", modifier = Modifier
                            .padding(10.dp)
                            .clip(RoundedCornerShape(topEnd = 10.dp))
                            .background(color = Color.Green)
                            .width(100.dp)
                            .height(100.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically)
                            .wrapContentWidth(align = Alignment.CenterHorizontally))
                        Text(text = "下左圆角", modifier = Modifier
                            .padding(10.dp)
                            .clip(RoundedCornerShape(bottomStart = 10.dp))
                            .background(color = Color.Green)
                            .width(100.dp)
                            .height(100.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically)
                            .wrapContentWidth(align = Alignment.CenterHorizontally))
                        Text(text = "上右圆角", modifier = Modifier
                            .padding(10.dp)
                            .clip(RoundedCornerShape(bottomEnd = 10.dp))
                            .background(color = Color.Green)
                            .width(100.dp)
                            .height(100.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically)
                            .wrapContentWidth(align = Alignment.CenterHorizontally))
                        Text(text = "全圆角+毛玻璃", modifier = Modifier
                            .padding(10.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(color = Color.Green)
                            .width(100.dp)
                            .height(100.dp)
                            .blur(3.dp, edgeTreatment = BlurredEdgeTreatment.Unbounded)
                            .wrapContentHeight(align = Alignment.CenterVertically)
                            .wrapContentWidth(align = Alignment.CenterHorizontally))

                        Icon(painter = rememberVectorPainter(image = Icons.Filled.Call), contentDescription = "图片"
                            , modifier = Modifier
                                .width(80.dp)
                                .height(80.dp))
                        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "图片上左圆角",
                            modifier = Modifier.clip(RoundedCornerShape(topStart = 10.dp)))
                        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "图片上右圆角",
                            modifier = Modifier.clip(RoundedCornerShape(topEnd = 10.dp)))
                        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "图片下左圆角",
                            modifier = Modifier.clip(RoundedCornerShape(bottomStart = 10.dp)))
                        Image(painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = "图片下右圆角",
                            modifier = Modifier.clip(RoundedCornerShape(bottomEnd = 10.dp)))

                        Icon(painter =  painterResource(id = R.drawable.ic_launcher_background), contentDescription = "全圆角+毛玻璃"
                            , modifier = Modifier
                                .width(80.dp)
                                .height(80.dp)
                                .clip(RoundedCornerShape(10.dp))
                                .blur(5.dp))

                        ClickableText(text = AnnotatedString("这是可点击的文本控件"), onClick = { println("点击了可点击的") })
                        Text(text = "正常文本", fontSize = 25.sp)
                        Text(text = "正常文本斜体", fontSize = 25.sp, fontStyle = FontStyle.Italic)
                        Text(text = "正常文本粗体", fontSize = 25.sp, fontWeight = FontWeight.W700)
                        Text(text = "正常文本绿色", fontSize = 25.sp, color = Color.Green)
                        Text(text = "正常文本字体", fontSize = 25.sp, fontFamily = FontFamily.Cursive)
                        IconButton(onClick = { println("如果是没有点击现在") }) {
                            Icon(Icons.Filled.Home, contentDescription ="")
                        }
                        IconButton(onClick = { println("如果是没有点击现在") }) {
                            Icon(Icons.Filled.AccountBox, contentDescription ="")
                        }
                        IconButton(onClick = { println("如果是没有点击现在") }) {
                            Icon(Icons.Default.Favorite, contentDescription ="")
                        }
                        TextButton(onClick = { println("如果是没有点击现在") }) {
                            Icon(Icons.Default.Lock, contentDescription = "")
                            Text(text = "点击跳转登录")
                        }
                        OutlinedButton(onClick = { println("如果是没有点击现在") }) {
                            Icon(Icons.Default.Lock, contentDescription = "")
                            Text(text = "点击跳转登录")
                        }
                        TextField(value = "请输入", onValueChange = {  }, label = {"这是label"}, placeholder ={ "这是placeholder"})
                        OutlinedTextField(value = "请输入", onValueChange = {  }, label = {"这是label"}, placeholder ={ "这是placeholder"})
                        Switch(checked = true, onCheckedChange = {})
                        Checkbox(checked = true, onCheckedChange = {})

                        AsyncImage(model = "http://wanandroid.com/blogimgs/af042353-c7c6-4f29-a988-3ad9b369964d.png",
                            contentDescription = "网络图片",
                            onState = {
                                if (it is AsyncImagePainter.State.Error){
                                    it.result.throwable.printStackTrace()
                                }else {
                                    println("状态变化：${it}")
                                }
                            }
                        )

                    }
                }
            })
        }
    )

}

@Preview(showBackground = true, showSystemUi = true, device = Devices.PIXEL_4_XL)
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

