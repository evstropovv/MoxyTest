package vasyavich.test.com.moxytest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(), ImainView {

    @InjectPresenter
    lateinit var presenter: MainPresenter

    var btnStartTimer: Button? = null

    var textView: TextView? = null

    override fun hideTimer() {
        textView?.visibility = View.GONE
    }

    override fun showTime(msg: String) {
        textView?.visibility = View.VISIBLE
        textView?.text = "$msg Seconds"
    }

    override fun showMessage(msg: String) {
        textView?.text = msg
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView = findViewById(R.id.textView)
        btnStartTimer = findViewById(R.id.button)
        btnStartTimer?.setOnClickListener{
            presenter.startTimer()
        }
    }
}
