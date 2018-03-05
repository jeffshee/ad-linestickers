package io.github.jeffshee.discordlinestickers;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        WebView webView = findViewById(R.id.webView);
        webView.loadDataWithBaseURL(null, getString(R.string.about_text),
                "text/html", "utf-8", null);
    }
}
