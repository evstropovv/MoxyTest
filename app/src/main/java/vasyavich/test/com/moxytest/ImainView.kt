package vasyavich.test.com.moxytest

import com.arellomobile.mvp.MvpView
import java.util.*

interface ImainView : MvpView {

    fun showMessage(msg: String)

    fun hideTimer()

    fun showTime(msg: String)

}