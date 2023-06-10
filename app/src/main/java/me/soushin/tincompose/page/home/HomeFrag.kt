package me.soushin.tincompose.page.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.fragment.app.Fragment
import me.soushin.tincompose.app.DataBindingFragment
import me.soushin.tincompose.app.go
import me.soushin.tincompose.page.complex.ComplexAct
import me.soushin.tincompose.page.complex.ComplexVM

/**
 * 首页
 * @author SouShin
 * created at 2023/6/9 10:50
 */
class HomeFrag: DataBindingFragment<HomeVM>() {

    @Composable
    override fun initView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) {
        Column() {
            Button(onClick = { go(ComplexAct::class.java) }) {
                Text(text = "复杂")
            }
        }
    }


}



