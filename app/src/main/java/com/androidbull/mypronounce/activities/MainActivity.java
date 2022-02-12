package com.androidbull.mypronounce.activities;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import com.androidbull.mypronounce.common.in_app_purchases.AppBillingProcessor;

import com.androidbull.mypronounce.ui.AdNetwork;
import com.androidbull.mypronounce.ui.BaseActivity;
import com.androidbull.mypronounce.ui.dialogs.ConsentDialog;
import com.androidbull.mypronounce.ui.dialogs.VipDialog;
import com.androidbull.mypronounce.ui.feature.practicesentence.PracticeSentenceActivity;
import com.androidbull.mypronounce.ui.helper.PreferenceManager;
import com.androidbull.mypronounce.data.local.database.DBPopulator;
import com.androidbull.mypronounce.ui.feature.dailylesson.DailyLessonActivity;
import com.androidbull.mypronounce.ui.helper.ProgressCalculator;
import com.androidbull.mypronounce.ui.feature.dailylesson.receiver.DailyLessonNotificationManager;
import com.androidbull.mypronounce.ui.feature.practiceword.PracticeWordActivity;
import com.androidbull.mypronounce.ui.feature.pronunciationchecker.PronunciationCheckerActivity;
import com.anjlab.android.iab.v3.BillingProcessor;
import com.anjlab.android.iab.v3.TransactionDetails;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.os.SystemClock;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.androidbull.mypronounce.FacebookLogger;
import com.androidbull.mypronounce.R;
import com.androidbull.mypronounce.util.HelperMethods;

import com.vaibhavlakhera.circularprogressview.CircularProgressView;

import java.util.Calendar;

import static com.androidbull.mypronounce.constant.Constants.DAILY_LESSON_NOTIFICATION_TIME;
import static com.androidbull.mypronounce.constant.Constants.DAILY_LESSON_NOTIFIER_REQUEST_CODE;
import static com.androidbull.mypronounce.constant.Constants.INTENT_ACTION_DAILY_LESSON_NOTIFIER;
import static com.androidbull.mypronounce.constant.Constants.IS_FIRST_LAUNCH;
import static com.androidbull.mypronounce.constant.Constants.LESSON_NO;
import static com.androidbull.mypronounce.constant.Constants.UNREAD_LESSON;


public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener, SharedPreferences.OnSharedPreferenceChangeListener {

    public static final String TAG = "TestingAds";

    private Button btnDailyLesson, btnPracticeWords, btnPracticeSentences, btnTestPronunciation, btnHomophones, btnTestPronunciationTab, btnHomophonesTab;
    private CircularProgressView cpvDailyLessons, cpvWordLessons, cpvSentenceLessons;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private MaterialToolbar tbMain;
    private Menu menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        firstRunSetup();
        drawerSetup();
        getAppPrice();
    }

    @Override
    protected LinearLayout getBannerAdView() {
        return findViewById(R.id.llAdsBannerContainer);
    }

    @NonNull
    @Override
    protected String getBannerAdID() {
        if (super.getAdNetwork() == AdNetwork.FACEBOOK)
            return getString(R.string.main_bottom_banner_ad_id);
        else
        return getString(R.string.admob_main_bottom_banner_ad_id);

    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void hideAdRelatedViews() {
        if (menu != null) {
            MenuItem miAd = menu.getItem(R.id.miAd);
            miAd.setVisible(false);
        }

        MenuItem menuItemRemoveAds = navigationView.getMenu().findItem(R.id.remove_ads);
        menuItemRemoveAds.setVisible(false);
    }

    @Override
    protected void initViews() {

        tbMain = findViewById(R.id.tbMain);
        setSupportActionBar(tbMain);

        drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);

        btnDailyLesson = findViewById(R.id.btnDailyLesson);
        btnPracticeWords = findViewById(R.id.btnPracticeWords);
        btnPracticeSentences = findViewById(R.id.btnPracticeSentences);
        btnTestPronunciation = findViewById(R.id.btnTestPronunciation);
        btnHomophones = findViewById(R.id.btnHomophones);
        btnTestPronunciationTab = findViewById(R.id.btnTestPronunciationTab);
        btnHomophonesTab = findViewById(R.id.btnHomophonesTab);

        cpvDailyLessons = findViewById(R.id.cpvDailyLessons);
        cpvWordLessons = findViewById(R.id.cpvWordLessons);
        cpvSentenceLessons = findViewById(R.id.cpvSentenceLessons);
    }

    @Override
    protected void initActions() {
        btnDailyLesson.setOnClickListener(this);
        btnPracticeWords.setOnClickListener(this);
        btnPracticeSentences.setOnClickListener(this);
        btnTestPronunciation.setOnClickListener(this);
        btnHomophones.setOnClickListener(this);
        btnTestPronunciationTab.setOnClickListener(this);
        btnHomophonesTab.setOnClickListener(this);

    }


    private void getAppPrice() {

        AppBillingProcessor.INSTANCE.getInstance(() -> {
            AppBillingProcessor.INSTANCE.getInstance().getPurchaseListingDetails(getString(R.string.remove_ad_id)); // automatic cache on call
        });
    }


    private void drawerSetup() {
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, tbMain,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.bringToFront();

        if (isVip() || isProVersion()) {
            MenuItem menuItemRemoveAds = navigationView.getMenu().findItem(R.id.remove_ads);
            menuItemRemoveAds.setVisible(false);
        }
    }

    //region onEvent

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnTestPronunciation || id == R.id.btnTestPronunciationTab) {
            startEpActivity(new Intent(this, PronunciationCheckerActivity.class));
        } else if (id == R.id.btnPracticeWords) {
            startEpActivity(new Intent(this, PracticeWordActivity.class));
        } else if (id == R.id.btnPracticeSentences) {
            startEpActivity(new Intent(this, PracticeSentenceActivity.class));
        } else if (id == R.id.btnDailyLesson) {
            FacebookLogger.log(this, "Daily Lessons clicked from main activity");
            startEpActivity(new Intent(this, DailyLessonActivity.class));
        } else if (id == R.id.btnHomophones || id == R.id.btnHomophonesTab) {
            startEpActivity(new Intent(this, HomoPhoneActivity.class));
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int ID = item.getItemId();
        if (ID == R.id.miAd) {
            showInterstitialAd();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.remove_ads) {
            showVipDialog();
            FacebookLogger.log(this, "Remove ads clicked from drawer");
        } else if (itemId == R.id.privacy_policy) {
            FacebookLogger.log(this, "Privacy Policy clicked from drawer");
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.privacy_policy_url))));
        } else if (itemId == R.id.nav_share) {
            FacebookLogger.log(this, "Share clicked from drawer");
            HelperMethods.shareApp(this);
        } else if (itemId == R.id.rate) {
            FacebookLogger.log(this, "Rate clicked from drawer");
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.google_play_url) + getPackageName())));
        } else if (itemId == R.id.more_apps) {
            FacebookLogger.log(this, "More apps clicked from drawer");
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/dev?id=7526655877048557790")));
        } else if (itemId == R.id.miPronunciationGuide) {
            startActivity(new Intent(MainActivity.this, PronunciationGuideActivity.class));
        } else if (itemId == R.id.miTextToSpeech) {
            startActivity(new Intent(this, SpeakActivity.class));
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.ad_menu, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem miAd = menu.findItem(R.id.miAd);
        miAd.setVisible(!isVip() && !isProVersion());
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    //endregion

    //region firstRunSetup

    private void firstRunSetup() {
        this.getSharedPreferences(this.getPackageName(), Activity.MODE_PRIVATE).registerOnSharedPreferenceChangeListener(this);

        if (isFirstRun()) {
            if ((!isVip()) && (!isProVersion()))
                displayConsentDialog();
            PreferenceManager.Companion.getInstance(this).setBoolean(IS_FIRST_LAUNCH, false);
            initLessonNumber();
            DBPopulator.populateDB(this);
            setNotifierForDailyLessons();
        }
    }

    private void displayConsentDialog() {
        ConsentDialog consentDialog = ConsentDialog.newInstance();
        consentDialog.setListener(view -> showVipDialog());
        consentDialog.show(getSupportFragmentManager(), "consentDialog");
    }

    private void showVipDialog() {
        VipDialog vipDialog = VipDialog.newInstance();
        vipDialog.setOnClickListener(view -> {
            if (view.getId() == R.id.btnUpgrade) {
                if (AppBillingProcessor.INSTANCE.getInstance().isOneTimePurchaseSupported()) {
                    AppBillingProcessor.INSTANCE.getInstance(new BillingProcessor.IBillingHandler() {
                        @Override
                        public void onProductPurchased(@NonNull String productId, TransactionDetails details) {
                            unlockVip();
                        }

                        @Override
                        public void onPurchaseHistoryRestored() {
                        }

                        @Override
                        public void onBillingError(int errorCode, Throwable error) {
                        }

                        @Override
                        public void onBillingInitialized() {

                        }
                    }).purchase(this, getString(R.string.remove_ad_id));
                } else {
                    Toast.makeText(this, getString(R.string.err_In_app_billing_service_is_unavailable), Toast.LENGTH_SHORT).show();
                }
            }
        });
        vipDialog.show(getSupportFragmentManager(), "vipDialog");

    }


    private void initLessonNumber() {
        PreferenceManager.Companion.getInstance(this).setInt(LESSON_NO, 0);
    }

    private boolean isFirstRun() {
        return PreferenceManager.Companion.getInstance(this).getBooleanFirstLaunch(IS_FIRST_LAUNCH);
    }

    private void setNotifierForDailyLessons() {

        int milliseconds = 20000; // 20 seconds

        AlarmManager alarmManager = (AlarmManager) this.getSystemService(ALARM_SERVICE);
        Intent intent = new Intent(this, DailyLessonNotificationManager.class);
        intent.setAction(INTENT_ACTION_DAILY_LESSON_NOTIFIER);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, DAILY_LESSON_NOTIFIER_REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M)
            alarmManager.setExactAndAllowWhileIdle(AlarmManager.ELAPSED_REALTIME_WAKEUP, (SystemClock.elapsedRealtime() + milliseconds), pendingIntent);
        else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AlarmManager.AlarmClockInfo alarmClockInfo
                    = new AlarmManager.AlarmClockInfo((SystemClock.elapsedRealtime() + milliseconds), null);
            alarmManager.setAlarmClock(alarmClockInfo, pendingIntent);
        }
        //setExact for 19
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + milliseconds, pendingIntent);
        } else {
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + milliseconds, pendingIntent);
        }

        saveDailyLessonNotificationTime();
    }

    private void saveDailyLessonNotificationTime() {
        PreferenceManager.Companion.getInstance(this).setLong(DAILY_LESSON_NOTIFICATION_TIME, Calendar.getInstance().getTimeInMillis());
    }
    //endregion


    //region Lessons Progress
    //TODO add width rounded option to xml (CircularProgressView)
    private void setDailyLessonProgressPercentage() {
        int progressPercentage = (int) ProgressCalculator.getDailyLessonProgress(this);
        cpvDailyLessons.setProgress(progressPercentage, true);
    }

    private void setWordLessonProgressPercentage() {
        int progressPercentage = (int) ProgressCalculator.getWordLessonProgress(this);
        cpvWordLessons.setProgress(progressPercentage, true);
    }


    private void setSentenceLessonProgressPercentage() {
        int progressPercentage = (int) ProgressCalculator.getSentenceLessonProgressPercentage(this);
        cpvSentenceLessons.setProgress(progressPercentage, true);
    }
    //endregion

    @Override
    protected void onStart() {
        super.onStart();
        setDailyLessonProgressPercentage();
        setWordLessonProgressPercentage();
        setSentenceLessonProgressPercentage();
        this.getSharedPreferences(this.getPackageName(), Activity.MODE_PRIVATE).registerOnSharedPreferenceChangeListener(this);
    }


    @Override
    protected void onDestroy() {
        this.getSharedPreferences(this.getPackageName(), Activity.MODE_PRIVATE).unregisterOnSharedPreferenceChangeListener(this);
        super.onDestroy();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if ((sharedPreferences != null) && (key.equals(UNREAD_LESSON))) {

            View vUnreadLessonBadge = findViewById(R.id.vUnreadLessonBadge);
            boolean isUnreadLesson = sharedPreferences.getBoolean(key, false);
            vUnreadLessonBadge.setVisibility((isUnreadLesson) ? View.VISIBLE : View.INVISIBLE);

        }
    }

}

