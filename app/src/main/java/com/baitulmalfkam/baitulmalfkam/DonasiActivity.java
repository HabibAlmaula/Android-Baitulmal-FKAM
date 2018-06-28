package com.baitulmalfkam.baitulmalfkam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class DonasiActivity extends AppCompatActivity {
    WebView web_confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi);

        web_confirm = findViewById(R.id.web_confirm);

        web_confirm.getSettings().setJavaScriptEnabled(true);
        web_confirm.loadUrl("http://baitulmalfkam.com/layanan/konfirmasi-donasi/");
        web_confirm.setWebViewClient(new WebViewClient());
    }
}
