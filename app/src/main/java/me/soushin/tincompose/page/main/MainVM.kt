package me.soushin.tincompose.page.main

import android.Manifest
import android.app.Application
import com.blankj.utilcode.util.PermissionUtils
import me.soushin.tincompose.app.DataVM
import me.soushin.tincompose.app.showToasty

class MainVM(app: Application):DataVM<MainRepository>(app, MainRepository()) {


    fun requestPermission(){
        PermissionUtils.permission(Manifest.permission.CAMERA,Manifest.permission.READ_EXTERNAL_STORAGE)
            .callback(object :PermissionUtils.SimpleCallback{
                override fun onGranted() {

                }

                override fun onDenied() {
                    showToasty("权限已被拒绝，可以到设置中开启")
                }
            }).request()
    }



}