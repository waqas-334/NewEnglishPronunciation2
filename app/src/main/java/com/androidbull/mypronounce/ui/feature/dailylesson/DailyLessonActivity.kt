package com.androidbull.mypronounce.ui.feature.dailylesson

import android.app.NotificationManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.FrameLayout
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.androidbull.mypronounce.constant.Constants.*
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.ui.helper.PreferenceManager
import com.google.firebase.analytics.FirebaseAnalytics
import com.androidbull.mypronounce.data.model.DailyLesson
import com.androidbull.mypronounce.ui.AdNetwork
import com.androidbull.mypronounce.ui.BaseActivity

class DailyLessonActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if ((intent != null) && (!TextUtils.isEmpty(intent.action)) && (intent.action.equals(INTENT_ACTION_READ_MORE))) {

            val notificationId = intent.getIntExtra(INTENT_EXTRA_READ_MORE_NOTIFICATION_ID, -1)
            if (notificationId > 0) {
                val notificationManager = this
                        .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.cancel(notificationId)
            }

            intent.extras?.let {
                val lesson = it.getSerializable(INTENT_EXTRA_READ_MORE) as DailyLesson
                logLessonDetailEvent("notification", lesson)
                moveToLessonDetailFragment(lesson)
            }
        } else {
            logLessonActivityEvent()
            setInitialFragment(savedInstanceState)
        }

        clearNewLessonBadge()
    }

    override fun getLayoutResourceId() = R.layout.activity_daily_lesson
    override fun getBannerAdID() = if (super.adNetwork === AdNetwork.FACEBOOK) getString(R.string.daily_lesson_bottom_banner_ad) else  getString(R.string.admob_daily_lesson_bottom_banner_ad)
    override fun getBannerAdView(): LinearLayout? = findViewById(R.id.llAdsBannerContainer)

    override fun initViews() {}

    override fun initActions() {}
    override fun hideAdRelatedViews() {}


    private fun clearNewLessonBadge() {
        PreferenceManager.getInstance(this).setBoolean(UNREAD_LESSON, false)
    }

    private fun moveToLessonDetailFragment(dailyLesson: DailyLesson) {
        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, DailyLessonListFragment.newInstance())
                .replace(R.id.fragmentContainer, DailyLessonDetailFragment.newInstance(dailyLesson))
                .commit()
    }

    private fun setInitialFragment(savedInstanceState: Bundle?) {
        if (findViewById<FrameLayout>(R.id.fragmentContainer) != null) {
            if (savedInstanceState != null) {
                return
            }
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentContainer, DailyLessonListFragment.newInstance())
                    .commit()
        }
    }


    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        intent?.let {

            if ((!TextUtils.isEmpty(intent.action)) && (intent.action.equals(INTENT_ACTION_READ_MORE))) {

                val notificationId = intent.getIntExtra(INTENT_EXTRA_READ_MORE_NOTIFICATION_ID, -1)
                if (notificationId > 0) {
                    val notificationManager = this
                            .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                    notificationManager.cancel(notificationId)
                }

                intent.extras?.let {
                    val lesson = it.getSerializable(INTENT_EXTRA_READ_MORE) as DailyLesson
                    logLessonDetailEvent("notification", lesson)
                    showDailyLessonDetailFragment(lesson)
                }
            }
        }
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        if (fragment is DailyLessonListFragment)
            fragment.setLessonDetailRequestHandler(::onLessonDetailClick)
    }

    private fun onLessonDetailClick(dailyLesson: DailyLesson) {
        logLessonDetailEvent("list", dailyLesson)
        showDailyLessonDetailFragment(dailyLesson)
    }

    private fun showDailyLessonDetailFragment(dailyLesson: DailyLesson) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, DailyLessonDetailFragment.newInstance(dailyLesson))
                .addToBackStack(null)
                .commit()
    }

    private fun logLessonActivityEvent() {
        val params = Bundle()
        params.putString(DAILY_LESSON_LIST_OPENED_PARAM, "navigation activity")
        FirebaseAnalytics.getInstance(this).logEvent(DAILY_LESSON_LIST_OPENED, params)
    }

    private fun logLessonDetailEvent(source: String, lesson: DailyLesson) {
        val params = Bundle()
        params.putString(DAILY_LESSON_DETAIL_OPENED_PARAM_SOURCE, source)
        params.putInt(DAILY_LESSON_DETAIL_OPENED_PARAM_LESSON_ID, lesson.lessonId)
        FirebaseAnalytics.getInstance(this).logEvent("lesson_opened_" + source + "_" + lesson.lessonId, params)
    }

    override fun onDestroy() {
        super.onDestroy()
        clearNewLessonBadge()

    }
}