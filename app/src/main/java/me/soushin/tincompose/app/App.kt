package me.soushin.tincompose.app

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import com.blankj.utilcode.util.ImageUtils
import com.blankj.utilcode.util.Utils

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(ActivityLifecycleImpl())

        Utils.init(this)



    }





}