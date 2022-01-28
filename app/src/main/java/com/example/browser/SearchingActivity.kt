package com.example.browser

import android.app.ProgressDialog
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.browser.module.Checking
import kotlinx.android.synthetic.main.activity_searching.*
import java.net.URL

class SearchingActivity : AppCompatActivity() {
    lateinit var progresDialog:ProgressDialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_searching)

        max.text = "Max ${Checking.KnowIt} browser "


        progresDialog = ProgressDialog(this)
        progresDialog.setMessage("Loading . . . ")


        when (Checking.KnowIt) {
            "google" -> {

                web_window.loadUrl("https://google.com/")
                web_window.webViewClient = object : WebViewClient() {
                    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                        view?.loadUrl(url!!)

                        return true
                    }

                    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                        super.onPageStarted(view, url, favicon)
                        progresDialog.show()
                    }

                    override fun onPageFinished(view: WebView?, url: String?) {
                        super.onPageFinished(view, url)
                        progresDialog.hide()
                    }
                }
            }
            "youtube" -> {
                web_window.loadUrl("https://youtube.com")
            }
            "github" -> {
                web("https://github.com")
            }
            "android" -> {
                web("https://android.com")
            }
            else -> {
                if (Checking.KnowIt.subSequence(
                        Checking.KnowIt.length - 3,
                        Checking.KnowIt.length
                    ) == "com" || Checking.KnowIt.subSequence(
                        Checking.KnowIt.length - 3,
                        Checking.KnowIt.length
                    ) == "ru" || Checking.KnowIt.subSequence(
                        Checking.KnowIt.length - 3,
                        Checking.KnowIt.length
                    ) == "uz"
                ) {
                    web("https://${Checking.KnowIt}")
                } else {
                    hide()
                }
            }
        }
    }

    fun web(_url:String){
        web_window.loadUrl(_url)
        web_window.webViewClient = object  : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, url:String?): Boolean {
                view?.loadUrl(url!!)
                return true
            }
        }
    }
    fun hide(){
        web("https://www.google.com/search?q=${Checking.KnowIt}&oq=ofhdai&aqs=chrome..69i57j69i59i450l8.618j0j15&sourceid=chrome&ie=UTF-8")

    }
}