package com.gaaan.moxyhw4

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndStrategy::class)
interface MainView : MvpView {
    fun showResult(result: Long)
    fun showError(message: String)
}