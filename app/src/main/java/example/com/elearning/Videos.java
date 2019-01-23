package example.com.elearning;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Videos extends AppCompatActivity {

    WebView webView ;

    String urls;
    String YouTubeVideoEmbedCode = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videos);

        urls = getIntent().getStringExtra("url");
        Log.d("yo",urls);

        YouTubeVideoEmbedCode = "<html><body><iframe width=\"100%\" height=\"100%\" src=\"" + urls + "\" frameborder=\"0\" allowfullscreen></iframe></body></html>";

        Log.d("dsa",YouTubeVideoEmbedCode);

        webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient() {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                return false;
            }
        });

        WebSettings webSettings = webView.getSettings();

        webSettings.setJavaScriptEnabled(true);

        webView.loadData(YouTubeVideoEmbedCode, "text/html", "utf-8");
    }

    @Override
    public void onPause() {
        super.onPause();
        webView.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        webView.onResume();
    }
}