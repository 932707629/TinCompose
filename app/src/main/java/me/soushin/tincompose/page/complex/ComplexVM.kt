package me.soushin.tincompose.page.complex

import android.app.Application
import me.soushin.tincompose.app.DataVM
import me.soushin.tincompose.page.main.MainRepository

class ComplexVM(app: Application): DataVM<MainRepository>(app, MainRepository()) {



}