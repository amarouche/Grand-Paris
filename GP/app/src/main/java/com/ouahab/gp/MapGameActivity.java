package com.ouahab.gp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MapGameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_map_game);

        WebView mapView = new WebView(this);
        setContentView(mapView);

        mapView.getSettings().setUseWideViewPort(true);
        mapView.getSettings().setLoadWithOverviewMode(true);
        mapView.getSettings().setJavaScriptEnabled(true);
        mapView.getSettings().setDomStorageEnabled(true);
        mapView.getSettings().setSupportZoom(true);
        mapView.getSettings().setBuiltInZoomControls(true);
        mapView.getSettings().setDisplayZoomControls(true);

        WebViewClient client = new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        };

        mapView.setWebViewClient(client);
        mapView.loadUrl("file:///android_asset/france.html");
    }

    @JavascriptInterface
    public void test() {
        Log.e("test", "test");
    }
}
