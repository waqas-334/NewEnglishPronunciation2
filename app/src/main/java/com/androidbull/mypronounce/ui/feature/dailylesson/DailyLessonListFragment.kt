package com.androidbull.mypronounce.ui.feature.dailylesson

import android.app.Activity
import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidbull.mypronounce.constant.Constants.LESSON_NO
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.data.local.database.AppDatabase
import com.androidbull.mypronounce.ui.helper.PreferenceManager
import com.androidbull.mypronounce.data.model.DailyLesson
import com.androidbull.mypronounce.ui.feature.dailylesson.adapter.DailyLessonAdapter
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.coroutines.*


class DailyLessonListFragment : Fragment(), OnSharedPreferenceChangeListener {

    private lateinit var dailyLessonAdapter: DailyLessonAdapter
    private lateinit var rvDailyLessons: RecyclerView
    private val dailyLessonList = mutableListOf<DailyLesson>()
    private lateinit var onLessonDetailRequestHandler: (dailyLesson: DailyLesson) -> Unit
    private lateinit var tbDailyLessons: MaterialToolbar

    companion object {
        @JvmStatic
        fun newInstance() = DailyLessonListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_daily_lesson, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tbDailyLessons = view.findViewById(R.id.tbDailyLessons)
        tbDailyLessons.setNavigationOnClickListener {
            activity?.onBackPressed()
        }

        setLessonsRecyclerView(view)
        getDailyLessons()
    }


    private fun setLessonsRecyclerView(view: View) {

        dailyLessonAdapter = DailyLessonAdapter(dailyLessonList, ::onLessonItemClick)

        rvDailyLessons = view.findViewById(R.id.rvDailyLessons)
        rvDailyLessons.apply {
            adapter = dailyLessonAdapter
            val currentOrientation = resources.configuration.orientation
            layoutManager = if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
                LinearLayoutManager(requireContext())
            } else {
                GridLayoutManager(requireContext(), 2)
            }
        }
    }

    //TODO SQL BETWEEN
    private fun getDailyLessons() {

        val lesson = PreferenceManager.getInstance(requireContext().applicationContext).getInt(LESSON_NO)
        if (lesson > 0) {
            lifecycleScope.launch(Dispatchers.IO) {
                val lessonList = AppDatabase.invoke(requireContext().applicationContext).dailyLessonDao().getAll()
                val unReadLesson = AppDatabase.invoke(requireContext().applicationContext).dailyLessonDao().getUnreadLesson()
                withContext(Dispatchers.Main) {
                    lessonList?.let {
                        if (it.isNotEmpty()) {
                            // display lesson according to day
                            val ll = mutableListOf<DailyLesson>()
                            for (dailyList in it) {
                                if (dailyList.lessonId <= lesson)
                                    ll.add(dailyList)
                            }
                            updateAdapter(ll)
                        }
                    }

                    unReadLesson?.let {
                        rvDailyLessons.scrollToPosition(it.lessonId)
                    }
                }
            }
        }
    }

    private fun updateAdapter(lessonList: List<DailyLesson>) {
        dailyLessonList.clear()
        dailyLessonList.addAll(lessonList)
        dailyLessonAdapter.notifyDataSetChanged()
    }

    private fun onLessonItemClick(dailyLesson: DailyLesson) {
        onLessonDetailRequestHandler.invoke(dailyLesson)
    }

    fun setLessonDetailRequestHandler(onLessonDetailRequest: (dailyLesson: DailyLesson) -> Unit) {
        this.onLessonDetailRequestHandler = onLessonDetailRequest
    }

    override fun onStart() {
        super.onStart()
        requireContext().getSharedPreferences(requireContext().packageName, Activity.MODE_PRIVATE).registerOnSharedPreferenceChangeListener(this)
    }


    override fun onStop() {
        super.onStop()
        requireContext().getSharedPreferences(requireContext().packageName, Activity.MODE_PRIVATE).unregisterOnSharedPreferenceChangeListener(this)
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String) {
        if (sharedPreferences != null && key == LESSON_NO) {
            getDailyLessons()
        }
    }
}