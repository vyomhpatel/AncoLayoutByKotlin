package b12app.vyom.com.myancolayoutprac.ui

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.support.annotation.RequiresApi
import android.view.Gravity
import android.view.View
import android.widget.Toast
import b12app.vyom.com.myancolayoutprac.R
import b12app.vyom.com.myancolayoutprac.activities.MainActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.design.longSnackbar
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivityUI : AnkoComponent<MainActivity> {

    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

        frameLayout {
            val textField = editText {
                hint = "text for toast and snackbars."
            }.lparams(width= matchParent){
                margin = dip(12)
                topMargin = dip(30)
            }

            imageView(R.drawable.image_ic){
                onClick {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        this@imageView.imageTintList =
                                ColorStateList.valueOf(Color.parseColor("#4CAF50"))
                    }
                }
            }.lparams(dip(72),dip(72)){
                gravity = Gravity.CENTER
            }

            linearLayout{
                    button("Show Toast"){
                        onClick {
                            //toast accepts the char sequence so we don't need to convert text to string.
                            toast(textField.text)
                        }
                    }
                button("Show Snackbar"){
                    onClick {
                        //snackbar only accepts strings so we need to convert char sequence into string.
                        longSnackbar(this@frameLayout,textField.text.toString())
                    }
                }

            }.lparams(){
                gravity = Gravity.BOTTOM or Gravity.CENTER_HORIZONTAL
                bottomMargin = dip(72)
            }
        }
    }
}