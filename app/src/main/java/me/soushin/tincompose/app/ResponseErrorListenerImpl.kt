package me.soushin.tincompose.app

import android.content.Context
import com.blankj.utilcode.util.LogUtils
import me.soushin.tincompose.app.listener.ResponseErrorListener

/**
 * 全局异常监听处理器
 * @author SouShin
 * created at 2023/6/13 09:41
 */
class ResponseErrorListenerImpl:ResponseErrorListener {

    ///处理全局异常信息
    override fun handleResponseError(context: Context?, t: Throwable?) {
        t?.printStackTrace()
        LogUtils.e(context?.javaClass?.simpleName,t?.message)
    }


}