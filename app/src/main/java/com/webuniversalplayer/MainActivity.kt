package com.webuniversalplayer

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.webkit.CookieManager
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient

/**
 * Initial WebView host.
 *
 * Site-specific behavior, channel discovery and remote-key routing are deliberately
 * kept out of this foundation layer and will be introduced in their dedicated phases.
 */
class MainActivity : Activity() {

    private lateinit var webView: WebView
    private var customView: View? = null
    private var customViewCallback: WebChromeClient.CustomViewCallback? = null

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webView = WebView(this).apply {
            layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            isFocusable = true
            isFocusableInTouchMode = true

            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
                mediaPlaybackRequiresUserGesture = false
                allowFileAccess = false
                allowContentAccess = true
                setSupportMultipleWindows(false)
            }

            webViewClient = WebViewClient()
            webChromeClient = createWebChromeClient()
        }

        CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)
        setContentView(webView)
        webView.loadUrl(START_PAGE_URL)
    }

    private fun createWebChromeClient() = object : WebChromeClient() {
        override fun onShowCustomView(view: View?, callback: CustomViewCallback?) {
            if (view == null) return
            if (customView != null) {
                callback?.onCustomViewHidden()
                return
            }

            customView = view
            customViewCallback = callback
            (webView.parent as? ViewGroup)?.removeView(webView)
            setContentView(view)
            window.decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                )
        }

        override fun onHideCustomView() {
            exitCustomView()
        }
    }

    private fun exitCustomView() {
        val view = customView ?: return
        customView = null
        customViewCallback?.onCustomViewHidden()
        customViewCallback = null
        setContentView(webView)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_VISIBLE
        (view.parent as? ViewGroup)?.removeView(view)
        webView.requestFocus()
    }

    @Deprecated("Deprecated in Android API; retained for compatibility with the Activity base class.")
    override fun onBackPressed() {
        if (customView != null) {
            exitCustomView()
        } else if (::webView.isInitialized && webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onDestroy() {
        if (::webView.isInitialized) {
            (webView.parent as? ViewGroup)?.removeView(webView)
            webView.stopLoading()
            webView.webChromeClient = null
            webView.webViewClient = WebViewClient()
            webView.destroy()
        }
        super.onDestroy()
    }

    companion object {
        private const val START_PAGE_URL = "file:///android_asset/index.html"
    }
}
