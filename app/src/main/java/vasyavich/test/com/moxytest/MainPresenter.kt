package vasyavich.test.com.moxytest

import android.os.AsyncTask
import android.os.CountDownTimer
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter


@InjectViewState
class MainPresenter : MvpPresenter<ImainView>() {
    var timer: CountDownTimer? = null
    var isStarting: Boolean = false

    init {
        doSomeWork()
    }

    fun startTimer() {
        if (!isStarting)
            timer = object : CountDownTimer(2000000, 1000) {
                override fun onTick(millisUntilFinished: Long) {
                    viewState.showTime(millisUntilFinished.toString())
                    isStarting = true
                }

                override fun onFinish() {
                    viewState.hideTimer()
                    isStarting = false
                }
            }.start()
    }

    fun doSomeWork() {
        viewState.showMessage("Presenter is Loading")
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

    }
}