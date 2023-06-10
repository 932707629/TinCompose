package me.soushin.tincompose.page.main

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.PagerState
import kotlinx.coroutines.launch
import me.soushin.tincompose.R
import me.soushin.tincompose.app.DataBindingActivity
import me.soushin.tincompose.app.mainScope
import me.soushin.tincompose.ui.theme.MyApplicationTheme


class MainActivity : DataBindingActivity<MainVM>() {

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

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Greeting() {

    val pageState = PagerState(pageCount = 2, currentPage = 0)
    Scaffold(
        content = {p->
            println("计算padding:${p.calculateTopPadding()},${IntrinsicSize.Max}")
            HorizontalPager(
                state = pageState,
//                dragEnabled = false,
                modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(bottom = 60.dp),
                verticalAlignment = Alignment.Top,
                horizontalAlignment = Alignment.Start,
            ) { page ->
                when(page){
                    0-> HomePager(LocalContext.current as MainActivity)
                    1-> MinePager(LocalContext.current as MainActivity)
                }
            }
        },
        bottomBar = {
            BottomNavigation(backgroundColor = Color.White, modifier = Modifier.height(60.dp)) {
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selectedContentColor = colorResource(id = R.color.purple_700),
                    unselectedContentColor = colorResource(id = R.color.black),
                    selected = pageState.currentPage == 0,
                    onClick = {
                        mainScope().launch {
                            // Call scrollToPage from a coroutine
                            pageState.scrollToPage(0)
                        }
                    }
                )
                BottomNavigationItem(
                    icon = { Icon(Icons.Filled.Settings, contentDescription = "Settings") },
                    label = { Text("Settings") },
                    selectedContentColor = colorResource(id = R.color.purple_700),
                    unselectedContentColor = colorResource(id = R.color.black),
                    selected = pageState.currentPage == 1,
                    onClick = {
                        mainScope().launch {
                            // Call scrollToPage from a coroutine
                            pageState.scrollToPage(1)
                        }
                    }
                )
            }
        }
    )



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