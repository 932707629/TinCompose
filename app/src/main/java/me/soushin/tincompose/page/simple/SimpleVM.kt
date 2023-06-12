package me.soushin.tincompose.page.simple

import android.app.Application
import me.soushin.tincompose.app.DataVM
import me.soushin.tincompose.page.main.MainRepository
import kotlin.contracts.SimpleEffect

class SimpleVM(app: Application): DataVM<SimpleRepos>(app, SimpleRepos()) {



}