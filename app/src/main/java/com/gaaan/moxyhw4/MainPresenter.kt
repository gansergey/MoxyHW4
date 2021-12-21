package com.gaaan.moxyhw4

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.BehaviorSubject
import moxy.MvpPresenter

class MainPresenter : MvpPresenter<MainView>() {

    private val subject: BehaviorSubject<Long> = BehaviorSubject.create()

    private val observerResult: Observable<Long> = subject
        .map { it * it }
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showResult(0)
        subscribe()
    }

    private fun subscribe() {
        observerResult.subscribe {
            viewState.showResult(it)
        }
    }

    fun calculate(number: String?) {
        number?.let {
            subject.onNext(number.toLong())
        } ?: viewState.showError("Введите число!")
    }

}