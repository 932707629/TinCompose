package me.soushin.tincompose.app.preview

import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

/**
 * Author: Soushin
 * Date: 2024/2/1 17:24
 * Description:预览使用
 **/
class PreviewActivityProvider : PreviewParameterProvider<AppCompatActivity> {
    override val values: Sequence<AppCompatActivity>
        get() = sequenceOf(AppCompatActivity())

}