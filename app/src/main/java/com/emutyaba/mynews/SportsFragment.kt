package com.emutyaba.mynews

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient


class SportsFragment : Fragment() {
  private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_sports, container, false)
        webView = root.findViewById<WebView>(R.id.webv)

        webView.loadUrl("https://www.skysports.com/")

        webView.settings.javaScriptEnabled=true
        webView.webViewClient = WebViewClient()

        return root
    }

}