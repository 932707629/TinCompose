package me.soushin.tincompose.app

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class DataVM<R: DataRepository>(app: Application,val mRepository: R):AndroidViewModel(app) {



}