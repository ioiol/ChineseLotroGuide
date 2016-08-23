package com.fc.lotro.activity;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.fc.lotro.R;
import com.fc.lotro.ui.Constants;

public class ClassWebActivity extends AppCompatActivity {
    private int position;
    private String category;
    private WebView webView;
    private ActionBar actionbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_web);
        position = getIntent().getIntExtra("position", 0);
        category = getIntent().getStringExtra("category");
        webView = (WebView) findViewById(R.id.webView);
        actionbar = getSupportActionBar();
        initWebView();
    }

    private void initWebView() {
        WebSettings webSettings = webView.getSettings();
        //支持js代码
        webSettings.setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                Log.d("ANDROID_LAB", "TITLE=" + title);
                actionbar.setTitle(title);
            }
        });

        webView.setWebViewClient(new WebViewClient() {
        });
        setWebViewLoadUrl();
        webView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
                    if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {  //表示按返回键时的操作
                        webView.goBack();   //后退
                        //webview.goForward();//前进
                        return true;
                    }
                }
                return false;
            }
        });
    }

    private void setWebViewLoadUrl() {
        if ("intro".equals(category)) {
            webView.loadUrl("file:///android_asset/html/" + Constants.classCategoryPath[position] + "/intro.html");
        } else if ("traits".equals(category)) {
            webView.loadUrl("file:///android_asset/html/" + Constants.classCategoryPath[position] + "/traits.html");
        } else if ("skill".equals(category)) {
            webView.loadUrl("file:///android_asset/html/" + Constants.classCategoryPath[position] + "/skill.html");
        } else if ("weapon".equals(category)){
            webView.loadUrl("file:///android_asset/html/" + Constants.classCategoryPath[position] + "/weapon.html");
        }else{
            webView.loadUrl("file:///android_asset/error.html");
        }
    }
}
