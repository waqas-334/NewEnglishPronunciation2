package com.androidbull.mypronounce;


import android.util.Log
import androidx.multidex.MultiDexApplication
import com.androidbull.mypronounce.common.facebook.AudienceNetworkInitializeHelper
import com.androidbull.mypronounce.common.in_app_purchases.AppBillingProcessor
import com.androidbull.mypronounce.constant.Constants
import com.androidbull.mypronounce.data.local.database.AppDatabase
import com.androidbull.mypronounce.data.model.DailyLesson
import com.facebook.stetho.Stetho
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class App : MultiDexApplication() {

    private val tag = "EpApplication";

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this);
        AppBillingProcessor.initialize(this)
        AudienceNetworkInitializeHelper.initialize(this)
        FirebaseDatabase.getInstance().setPersistenceEnabled(true)
        syncDailyLessonsDatabase()
    }

    private fun syncDailyLessonsDatabase() {
        Log.d("test", "syncDailyLessonsDatabase: app")


        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference(Constants.FIREBASE_DAILY_LESSON_ROOT_NODE)

        //TODO insert in single transaction (insert All)  count getChildren()
        val childEventListener = object : ChildEventListener {

            override fun onChildAdded(dataSnapshot: DataSnapshot, previousChildName: String?) {
                Log.d("test", "onChildAdded: app")

                try {

                    val dailyLesson = dataSnapshot.getValue(DailyLesson::class.java)

                    dailyLesson?.let {
                        GlobalScope.launch(Dispatchers.IO) { AppDatabase.invoke(this@App).dailyLessonDao().insert(it) }
                    }
                } catch (ex: Exception) {
                    Log.d("test", "onChildAdded: ${ex.message}")
                    ex.printStackTrace()
                }
            }

            override fun onChildChanged(dataSnapshot: DataSnapshot, previousChildName: String?) {
                Log.d("test", "onChildChanged: app")

                try {
                    val dailyLesson = dataSnapshot.getValue(DailyLesson::class.java)
                    dailyLesson?.let {
                        GlobalScope.launch(Dispatchers.IO) { AppDatabase.invoke(this@App).dailyLessonDao().update(it) }
                    }
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }

            override fun onChildRemoved(dataSnapshot: DataSnapshot) {
                Log.d("test", "onChildRemoved: app")

                try {
                    val dailyLesson = dataSnapshot.getValue(DailyLesson::class.java)
                    dailyLesson?.let {
                        GlobalScope.launch(Dispatchers.IO) { AppDatabase.invoke(this@App).dailyLessonDao().delete(it) }
                    }
                } catch (ex: Exception) {
                    ex.printStackTrace()
                }
            }

            override fun onCancelled(error: DatabaseError) {
            }

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
            }
        }

        myRef.addChildEventListener(childEventListener);
    }
}
