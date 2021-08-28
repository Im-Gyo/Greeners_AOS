package com.example.greeners_aos;

import android.os.Handler;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

public class AndroidBridge {

    private String TAG = "AndroidBridge";
    final public Handler handler = new Handler();

    // 생성 시 내부적으로 사용할 코드들 저장
    private WebView mAppView;
    private MainActivity mContext;

    // 기본 생성자
    public AndroidBridge(WebView _mAppView, MainActivity _mContext){
        mAppView = _mAppView;
        mContext = _mContext;
    }

    // 로그 메소드
    @JavascriptInterface
    public void call_log(final String _message){
        Log.d(TAG, _message);

        handler.post(new Runnable() {
            @Override
            public void run() {
                mAppView.loadUrl("javascript:alert('"+_message+"라는 로그발생')");
            }
        });
    }
}
