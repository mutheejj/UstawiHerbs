package com.example.ustawiherbs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class HomeActivity extends AppCompatActivity {
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // Set the Toolbar as the ActionBar

        if (getSupportActionBar()!= null) {
            getSupportActionBar().setTitle(R.string.app_name); // Now you can access the ActionBar
        }

        webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true); // Enable JavaScript
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setDatabaseEnabled(true);
        webView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        webView.loadUrl("https://mutheejj.github.io/UstawiHebs_landingpage/");
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.e("WebView", "Error loading webpage: " + description);
                Toast.makeText(HomeActivity.this, "Error loading webpage: " + description, Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton imgMenu = findViewById(R.id.imgMenu);
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the click event here
                Log.d("HomeActivity", "Menu button clicked");
                showPopupMenu(v);
            }
        });
    }

    private void showPopupMenu(View view) {
        // Create a PopupMenu
        PopupMenu popup = new PopupMenu(HomeActivity.this, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_main, popup.getMenu());

        // Handle menu item clicks
        popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_buy) {
                    Intent intent = new Intent(HomeActivity.this, BuyActivity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_home) {
                    // You're already in the home activity, so you don't need to do anything here
                    return true;
                } else if (item.getItemId() == R.id.action_settings) {
                    Intent intent = new Intent(HomeActivity.this, SettingsActivity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_contact) {
                    Intent intent = new Intent(HomeActivity.this, ContactActivity.class);
                    startActivity(intent);
                    return true;
                } else if (item.getItemId() == R.id.action_about_us) {
                    Intent intent = new Intent(HomeActivity.this, AboutUsActivity.class);
                    startActivity(intent);
                    return true;
                } else {
                    return false;
                }
            }
        });

        // Show the popup menu
        popup.show();
    }
}