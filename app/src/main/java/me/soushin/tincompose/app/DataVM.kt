package me.soushin.tincompose.app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

open class DataVM<R: DataRepository>(app: Application,val mRepository: R):AndroidViewModel(app) {

    val scope by lazy { mainScope() }

    val exceptionHandler by lazy {
        CoroutineExceptionHandler { _, throwable ->
            GlobalConfig.get().errorHandler.handleResponseError(app,throwable)
        }
    }

    init {
        scope.launch(exceptionHandler) {

        }
    }


}