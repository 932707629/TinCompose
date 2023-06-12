package me.soushin.tincompose.app

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.compose.ui.graphics.Color
import androidx.core.content.ContextCompat
import com.blankj.utilcode.util.BarUtils
import me.soushin.tincompose.R

/**
 * 监听
 * @author SouShin
 * created at 2023/6/11 14:53
 */
class ActivityLifecycleImpl : Application.ActivityLifecycleCallbacks {
    
    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        println("onActivityCreated:${activity.localClassName}")
        BarUtils.setStatusBarLightMode(activity,false)
        BarUtils.setStatusBarColor(activity, ContextCompat.getColor(activity,R.color.purple_700),true)
    }

    override fun onActivityStarted(activity: Activity) {

    }

    override fun onActivityResumed(activity: Activity) {
         
    }

    override fun onActivityPaused(activity: Activity) {
         
    }

    override fun onActivityStopped(activity: Activity) {
         
    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
         
    }

    override fun onActivityDestroyed(activity: Activity) {
        println("onActivityDestroyed:${activity.localClassName}")
    }


}