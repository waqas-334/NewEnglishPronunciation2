package com.androidbull.mypronounce.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.core.content.ContextCompat;

import com.androidbull.mypronounce.R;

/****************************************
 *  Created by Auve on 12/8/2019         
 *  Email: auvehassan@gmail.com  
 ****************************************/
public class HelperMethods {

  public static void shareApp(Activity activity) {
    Intent sharingIntent = new Intent(Intent.ACTION_SEND);
    sharingIntent.setType("text/plain");
    String shareBody =  activity.getString(R.string.str_share_msg)
                    + activity.getPackageName();
    sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Share");
    sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
    activity.startActivity(Intent.createChooser(sharingIntent, activity.getString(R.string.str_share_title)));
  }

  public static void closeKeyboard(Activity activity) {
    // Check if no view has focus:
    View view = activity.getCurrentFocus();
    if (view != null) {
      InputMethodManager imm = (InputMethodManager) view.getContext().getApplicationContext().getSystemService(Context.INPUT_METHOD_SERVICE);
      imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
  }
}
