package b12app.vyom.com.myancolayoutprac.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import b12app.vyom.com.myancolayoutprac.ui.MainActivityUI
import org.jetbrains.anko.frameLayout
import org.jetbrains.anko.setContentView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainActivityUI().setContentView(this)
    }
}
