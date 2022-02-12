package com.androidbull.mypronounce.activities;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;

import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.androidbull.mypronounce.R;
import com.androidbull.mypronounce.ui.AdNetwork;
import com.androidbull.mypronounce.ui.BaseActivity;
import com.google.android.material.appbar.MaterialToolbar;

import org.jetbrains.annotations.Nullable;

import java.util.Locale;

public class SpeakActivity extends BaseActivity implements OnInitListener {

    float pitch = -1;
    float speechRate = -1;
    TextToSpeech textToSpeech;
    private EditText write;

    private String menuIntentData = "";
    private TextToSpeech myTTS;
    private int MY_DATA_CHECK_CODE = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Intent checkTTSIntent = new Intent();
            checkTTSIntent
                    .setAction(TextToSpeech.Engine.ACTION_CHECK_TTS_DATA);
            startActivityForResult(checkTTSIntent, MY_DATA_CHECK_CODE);
        } catch (ActivityNotFoundException ex) {
            Toast.makeText(this, getString(R.string.err_tts_not_supported), Toast.LENGTH_SHORT).show();
        }

        Intent inputIntent = getIntent();
        CharSequence text = "";
        try {
            if (inputIntent.getAction().equals("android.intent.action.PROCESS_TEXT")) {
                text = inputIntent.getCharSequenceExtra("android.intent.extra.PROCESS_TEXT");
                menuIntentData = text.toString();
            }
        } catch (NullPointerException e) {

        }


        write = (EditText) findViewById(R.id.txtInput);
        if (!menuIntentData.isEmpty()) {
            write.setText(menuIntentData);
        }
        textToSpeech = new TextToSpeech(getApplicationContext(),
                status -> {
                    if (status != TextToSpeech.ERROR) {
                        textToSpeech.setLanguage(Locale.US);
                    }
                });

        addButtonListener();

    }


    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_speech;
    }

    @Nullable
    @Override
    protected LinearLayout getBannerAdView() {
        return findViewById(R.id.llAdsBannerContainer);
    }

    @NonNull
    @Override
    protected String getBannerAdID() {
        if (super.getAdNetwork() == AdNetwork.FACEBOOK)
            return getString(R.string.speak_bottom_banner_ad);
        else
            return getString(R.string.admob_speak_bottom_banner_ad);
    }


    @Override
    protected void initViews() {
        setToolbar();
    }

    @Override
    protected void initActions() {

    }


    private void setToolbar() {
        MaterialToolbar tbHomophone = findViewById(R.id.tbTextToSpeech);
        setSupportActionBar(tbHomophone);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setTitle(getString(R.string.str_text_to_speech));
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MY_DATA_CHECK_CODE) {
            if (resultCode == TextToSpeech.Engine.CHECK_VOICE_DATA_PASS) {
                // the user has the necessary data - create the TTS
                myTTS = new TextToSpeech(this, this);
            } else {
                // no data - install it now
                Intent installTTSIntent = new Intent();
                installTTSIntent
                        .setAction(TextToSpeech.Engine.ACTION_INSTALL_TTS_DATA);
                startActivity(installTTSIntent);
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    // --------------------------------------------------------
    public void onInit(int initStatus) {

        if (initStatus == TextToSpeech.SUCCESS) {
            if (myTTS.isLanguageAvailable(Locale.US) == TextToSpeech.LANG_AVAILABLE) {
                myTTS.setLanguage(Locale.US);
            }
        } else if (initStatus == TextToSpeech.ERROR) {
            Toast.makeText(this, getString(R.string.err_tts_not_supported),
                    Toast.LENGTH_LONG).show();
        }


    }


    private void addButtonListener() {

        //----------- Star Button back --------------------------------------

//    btnBack = (ImageButton) findViewById (R.id.btnBack);
//    btnBack.setOnClickListener(new OnClickListener(){
//
//		public void onClick(View v) {
//			finish();
//		}
//
//    });

        //----------- end Button back --------------------------------------

        //----------- Star Button Clear --------------------------------------
//    btnClear = (ImageButton) findViewById (R.id.btnClear);
//    btnClear.setOnClickListener(new OnClickListener(){
//
//		public void onClick(View v) {
//
//			write.setText("");
//			ttobj.stop();
//
//		}
//
//    });
//
        //----------- end Button Clear --------------------------------------

    }


    public void onPause() {
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
        super.onPause();
    }


    public void speakText(View view) {

        textToSpeech.setPitch(pitch);
        textToSpeech.setSpeechRate(speechRate);
        String toSpeak = write.getText().toString();
        textToSpeech.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);


    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    @Override
    protected void hideAdRelatedViews() { }
}
