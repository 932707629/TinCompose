package me.soushin.tincompose.app

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType


abstract class DataBindingFragment<T : DataVM<out DataRepository>>: Fragment() {

    public var vm:T? = null

    //通过ViewModelProvider可以获取同一个Activity下共享的ViewModel
    public var vmProvider: ViewModelProvider?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        createVM()
//        setContent { initView(savedInstanceState) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        createVM()
        return ComposeView(requireContext()).apply {
            setContent {
                initView(inflater = inflater, container = container, savedInstanceState = savedInstanceState)
            }
        }
    }

    open fun createVM(){
        vmProvider = ViewModelProvider(getThis())

        val type = this::class.java.genericSuperclass as ParameterizedType
        val genericType = type.actualTypeArguments[0] as Class<ViewModel>
        vm = vmProvider!![genericType] as T

    }

    @Composable
    abstract fun initView(inflater: LayoutInflater,
                          container: ViewGroup?,
                          savedInstanceState: Bundle?)


}