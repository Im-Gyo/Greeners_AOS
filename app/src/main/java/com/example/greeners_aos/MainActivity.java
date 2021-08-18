package com.example.greeners_aos;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    private WebView mWebView;

    // 웹뷰 url 세팅
    private final String webViewUrl = "https://www.naver.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 웹뷰 컨트롤러 가져옴
        mWebView = findViewById(R.id.webview);

        // 상단 툴바 제거
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();

        mWebView.getSettings().setUseWideViewPort(true); // wide viewport를 사용하도록 설정
        mWebView.getSettings().setJavaScriptEnabled(true); // 자바스크립트 사용 허용
        mWebView.getSettings().setLoadWithOverviewMode(true); // 웹 컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정

        mWebView.setWebViewClient(new WebViewClient(){}); // 웹뷰를 웹뷰레이아웃 내에서 사용하기 위해 설정

        // 웹뷰로 보여줄 url주소 세팅
        mWebView.loadUrl(webViewUrl);

        AndroidBridge androidBridge = new AndroidBridge(mWebView, MainActivity.this);
        mWebView.addJavascriptInterface(androidBridge, "Android");
    }
}