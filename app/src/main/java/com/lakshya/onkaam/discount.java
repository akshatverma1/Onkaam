package com.lakshya.onkaam;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class discount extends AppCompatActivity {

         WebView webView2;
         ProgressBar mprogressBar2;


        @Override
        protected void onCreate (Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_discount);

            mprogressBar2 = findViewById(R.id.progressBar2);
            mprogressBar2.setMax(100);


            webView2 = findViewById(R.id.webView2);
            webView2.setWebViewClient(new WebViewClient() {


                @Override
                public void onPageStarted(WebView view, String url, Bitmap favicon) {
                    super.onPageStarted(view, url, favicon);
                    mprogressBar2.setVisibility(View.VISIBLE);
                    setTitle("loading...");

                }


                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);

                    mprogressBar2.setVisibility(View.GONE);
                    setTitle(view.getTitle());


                }
            });
            webView2.loadUrl("https://awep001.blogspot.com/p/discount-codes.html");
            WebSettings webSettings = webView2.getSettings();
            webSettings.setJavaScriptEnabled(true);


        }


        @Override
        public void onBackPressed () {
            if (webView2.canGoBack()) {
                webView2.goBack();
            } else {
                super.onBackPressed();
            }


        }


    }

