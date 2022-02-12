package com.androidbull.mypronounce.activities;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.androidbull.mypronounce.constant.Constants;
import com.androidbull.mypronounce.IAPPrefrences;
import com.androidbull.mypronounce.R;

//import com.google.android.gms.ads.AdRequest;
//import com.google.android.gms.ads.AdSize;
//import com.google.android.gms.ads.AdView;


public class TutorialActivity extends AppCompatActivity {

  WebView mWebView;
  private boolean isPaid = false;
  private LinearLayout mLladContainer;
  View.OnClickListener onClickListener = new OnClickListener() {
    @Override
    public void onClick(View view) {

    }
  };

  public interface testInterface{
    void print();
  }


  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
        WindowManager.LayoutParams.FLAG_FULLSCREEN);
    setContentView(R.layout.activity_tutorial);

    isPaid = IAPPrefrences.isPaid(Constants.PAID_STATE, this);

    if (isPaid) {
//      removeAds();
    } else {
      loadAd();
    }

    TutorialActivity.testInterface testInterface = new testInterface() {
      @Override
      public void print() {

      }
    };

    Bundle b = getIntent().getExtras();
    mWebView = (WebView) findViewById(R.id.web1);

    mWebView.getSettings().setJavaScriptEnabled(true);
    mWebView.getSettings().setBuiltInZoomControls(true);

    int result = Integer.parseInt(b.getString("pme1"));

    if (result == 1) {
      mWebView.loadUrl("file:///android_asset/Lesson1.html");

    } else if (result == 2) {
      mWebView.loadUrl("file:///android_asset/Lesson2.html");

    } else if (result == 3) {
      mWebView.loadUrl("file:///android_asset/Lesson3.html");

    } else if (result == 4) {
      mWebView.loadUrl("file:///android_asset/Lesson4.html");

    } else if (result == 5) {
      mWebView.loadUrl("file:///android_asset/Lesson5.html");

    } else if (result == 6) {
      mWebView.loadUrl("file:///android_asset/Lesson6.html");

    } else if (result == 7) {
      mWebView.loadUrl("file:///android_asset/Lesson7.html");

    } else if (result == 8) {
      mWebView.loadUrl("file:///android_asset/Lesson8.html");

    } else if (result == 9) {
      mWebView.loadUrl("file:///android_asset/Lesson9.html");

    } else if (result == 10) {
      mWebView.loadUrl("file:///android_asset/Lesson10.html");

    } else if (result == 11) {
      mWebView.loadUrl("file:///android_asset/Lesson11.html");

    } else if (result == 12) {
      mWebView.loadUrl("file:///android_asset/Lesson12.html");

    } else if (result == 13) {
      mWebView.loadUrl("file:///android_asset/Lesson13.html");

    } else if (result == 14) {
      mWebView.loadUrl("file:///android_asset/Lesson14.html");

    } else if (result == 15) {
      mWebView.loadUrl("file:///android_asset/Lesson15.html");

    } else if (result == 16) {
      mWebView.loadUrl("file:///android_asset/Lesson16.html");

    } else if (result == 17) {
      mWebView.loadUrl("file:///android_asset/Lesson17.html");

    } else if (result == 18) {
      mWebView.loadUrl("file:///android_asset/Lesson18.html");

    } else if (result == 19) {
      mWebView.loadUrl("file:///android_asset/Lesson19.html");

    } else if (result == 20) {
      mWebView.loadUrl("file:///android_asset/Lesson20.html");

    } else if (result == 21) {
      mWebView.loadUrl("file:///android_asset/Lesson21.html");

    }


  }

  private void loadAd() {
    mLladContainer = findViewById(R.id.banner_container_tutorial);
   /* adView = new AdView(this);
    adView.setAdSize(AdSize.SMART_BANNER);
    adView.setAdUnitId(getString(R.string.tutorials_bottom_banner_ad));
    adView.loadAd(new AdRequest.Builder().build());
    mLladContainer.addView(adView);

  }

  private void removeAds() {
    if (adView != null) {
      mLladContainer.removeAllViews();
    }*/
  }


}
