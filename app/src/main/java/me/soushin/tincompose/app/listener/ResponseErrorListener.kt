package me.soushin.tincompose.app.listener

import android.content.Context


/**
 * 全局错误内容监听回调
 * @author SouShin
 * created at 2023/6/13 09:38
 */
interface ResponseErrorListener {

    fun handleResponseError(context: Context?, t: Throwable?)

    companion object{
        var EMPTY=object :ResponseErrorListener{
            override fun handleResponseError(context: Context?, t: Throwable?) {

            }
        }
    }

}