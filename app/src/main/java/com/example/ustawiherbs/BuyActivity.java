package com.example.ustawiherbs;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class BuyActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        // Initialize WebView
        webView = findViewById(R.id.webView);

        // Configure WebView settings
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true); // Enable JavaScript if needed

        // Load a URL or local HTML file
        webView.setWebViewClient(new WebViewClient()); // Ensure links open within the WebView
        webView.loadUrl("https://mutheejj.github.io/UstawiHebs_landingpage/");// Replace with your desired URL

        // Check if the view is not null before setting the listener
        View decorView = getWindow().getDecorView();
        if (decorView != null) {
            decorView.setOnApplyWindowInsetsListener(new View.OnApplyWindowInsetsListener() {
                @Override
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    // Your code here
                    return windowInsets;
                }
            });
        }
    }

    public void onClickListener(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}
