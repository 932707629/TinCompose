package me.soushin.tincompose.app

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType


abstract class DataBindingActivity<T : DataVM<out DataRepository>>: AppCompatActivity() {

    var vm:T? = null

    //通过ViewModelProvider可以获取同一个Activity下共享的ViewModel
    public var vmProvider: ViewModelProvider?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createVM()
        initView(savedInstanceState)
    }

    open fun createVM(){
        vmProvider = ViewModelProvider(getThis())

        val type = this::class.java.genericSuperclass as ParameterizedType
        val genericType = type.actualTypeArguments[0] as Class<ViewModel>
        vm = vmProvider!![genericType] as T

    }

    abstract fun initView(savedInstanceState: Bundle?)


    open fun sharedViewModel():Boolean{
        return true
    }

    open fun useFragment():Boolean{
        return true
    }


}