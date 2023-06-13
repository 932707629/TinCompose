package me.soushin.tincompose.app

import android.content.Context
import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.fragment.app.Fragment
import com.hjq.toast.Toaster
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers


fun ComponentActivity.getThis():ComponentActivity{
    return this
}

fun Fragment.getThis():Fragment{
    return this
}

fun ComponentActivity.go(clazz:Class<*>,finish:Boolean = false){
    startActivity(Intent(getThis(),clazz))
    if (finish){ finish() }
}


fun Fragment.go(clazz:Class<*>,finish:Boolean = false){
    requireContext().startActivity(Intent(requireContext(),clazz))
    if (finish){ requireActivity().finish() }
}


fun Any.mainScope():CoroutineScope{
    return CoroutineScope(Dispatchers.Main)
}

fun Any.ioScope():CoroutineScope{
    return CoroutineScope(Dispatchers.IO)
}


fun showToasty(msg:String?){
    msg?.let { Toaster.show(msg) }
}




