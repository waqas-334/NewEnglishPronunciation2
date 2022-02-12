package com.androidbull.mypronounce;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class PromotedAppDialog extends Dialog {

  public PromotedAppDialog(@NonNull Context context) {
    super(context);
  }

  String AppName, PackageName, AppIcon, ShortDesc;

  public PromotedAppDialog(Context context, String AppName, String PackageName, String ShortDesc,
      String AppIconUrl) {
    super(context);
    this.AppName = AppName;
    this.PackageName = PackageName;
    this.AppIcon = AppIconUrl;
    this.ShortDesc = ShortDesc;
  }

  ImageView mIvAppIcon;
  TextView mTvAppName, mTvShortDesc, mTvLetsGo, mTvNotNow;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.dialog_promoted_app);

    mTvAppName = findViewById(R.id.tv_promoted_app_name);
    mIvAppIcon = findViewById(R.id.iv_pormoted_app_icon);
    mTvShortDesc = findViewById(R.id.tv_promoted_app_short_desc);
    mTvLetsGo = findViewById(R.id.tv_lets_go);
    mTvNotNow = findViewById(R.id.tv_not_now);

    mTvShortDesc.setText(ShortDesc);
    mTvAppName.setText(AppName);

    mTvLetsGo.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        final String appPackageName = PackageName; // getPackageName() from Context or Activity object
        try {
          getContext().startActivity(
              new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName + "&referrer=utm_source%3DEnglish%2520Pronunciation%2520Paid%26utm_medium%3DLock%2520Feature%26anid%3Dadmob")));
        } catch (android.content.ActivityNotFoundException anfe) {
          getContext().startActivity(new Intent(Intent.ACTION_VIEW,
              Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName + "&referrer=utm_source%3DEnglish%2520Pronunciation%2520Paid%26utm_medium%3DLock%2520Feature%26anid%3Dadmob")));
        }
        https://play.google.com/store/apps/details?id=com.androidbull.word.link
        PromotedAppDialog.this.dismiss();

      }
    });

    mTvNotNow.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        PromotedAppDialog.this.dismiss();
      }
    });
  }
}

