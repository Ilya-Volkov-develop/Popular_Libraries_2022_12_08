package com.iliavolkov.popularlibraries.view.users

import com.github.terrakok.cicerone.Router
import com.iliavolkov.popularlibraries.App
import com.iliavolkov.popularlibraries.model.GithubUser
import com.iliavolkov.popularlibraries.repository.impl.GithubRepositoryImpl
import com.iliavolkov.popularlibraries.utils.nav.UserScreen
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import moxy.MvpPresenter

class UsersPresenter : MvpPresenter<UsersView>() {

    private val githubRepository: GithubRepositoryImpl by lazy { GithubRepositoryImpl() }
    private val router: Router by lazy { App.instance.router }
    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.showLoading()
        githubRepository.getUsers()
            .subscribeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.initList(it)
                viewState.hideLoading()
            }, {}).disposeBy(disposable)
    }

    fun openUserProfile(user: GithubUser) {
        router.navigateTo(UserScreen(user))
    }

    fun onBackPressed(): Boolean {
        router.exit()
        return true
    }

    private fun Disposable.disposeBy(bag: CompositeDisposable){
        bag.add(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }

}