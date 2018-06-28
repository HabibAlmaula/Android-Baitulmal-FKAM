package com.baitulmalfkam.baitulmalfkam.Detail;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.baitulmalfkam.baitulmalfkam.POJO.Majalah;
import com.baitulmalfkam.baitulmalfkam.R;

public class DetailMajalahActivity extends AppCompatActivity {
    TextView loading_tv;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_majalah);

        Majalah content = getIntent().getParcelableExtra("MAJALAH");

        loading_tv = findViewById(R.id.loading_tv);
        webView = (WebView)findViewById(R.id.browserMajalah);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(content.getUrl());
        webView.setWebViewClient(new WebViewClient());
        loading_tv.setVisibility(View.GONE);


        webView.setDownloadListener(new DownloadListener() {
            @Override
            public void onDownloadStart(String url, String userAgent, String contentDisposition, String mimetype, long contentLength) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                Toast.makeText(DetailMajalahActivity.this, "Mendownload Majalah", Toast.LENGTH_LONG).show();
                startActivity(i);
            }
        });
    }
}
