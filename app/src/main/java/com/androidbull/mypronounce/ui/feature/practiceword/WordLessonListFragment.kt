package com.androidbull.mypronounce.ui.feature.practiceword

import android.app.Activity
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.constant.Constants
import com.androidbull.mypronounce.data.local.database.AppDatabase
import com.androidbull.mypronounce.data.model.WordLesson
import com.androidbull.mypronounce.ui.feature.dailylesson.adapter.WordLessonAdapter
import com.androidbull.mypronounce.ui.helper.DividerItemDecoration
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class WordLessonListFragment : Fragment(), SharedPreferences.OnSharedPreferenceChangeListener {

    private lateinit var wordLessonAdapter: WordLessonAdapter
    private lateinit var rvWordLesson: RecyclerView
    private val wordLessonList = mutableListOf<WordLesson>()
    private lateinit var onLessonDetailRequestHandler: (wordLesson: WordLesson) -> Unit

    companion object {
        @JvmStatic
        fun newInstance() = WordLessonListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_word_lesson, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setWordLessonsRecyclerView(view)
        getWordLessons()
        context?.getSharedPreferences(context?.packageName, Activity.MODE_PRIVATE)?.registerOnSharedPreferenceChangeListener(this)
    }

    private fun getWordLessons() {

        lifecycleScope.launch(Dispatchers.IO) {
            val lessonList = AppDatabase.invoke(requireContext().applicationContext).wordLessonDao().getAllWithChildCount()

            withContext(Dispatchers.Main) {
                lessonList?.let {
                    if (it.isNotEmpty()) {
                        updateAdapter(it)
                    }
                }
            }
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val activity = requireActivity() as? PracticeWordActivity
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setWordLessonsRecyclerView(view: View) {

        wordLessonAdapter = WordLessonAdapter(wordLessonList, ::onLessonItemClick)

        rvWordLesson = view.findViewById(R.id.rvWordLesson)
        rvWordLesson.apply {
            adapter = wordLessonAdapter

            val isTablet = resources.getBoolean(R.bool.is_tablet)
            val currentOrientation = resources.configuration.orientation
            if (isTablet && currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                layoutManager = GridLayoutManager(requireContext(), 2)
            } else {
                layoutManager = LinearLayoutManager(requireContext())
                addItemDecoration(DividerItemDecoration(requireContext(), R.drawable.m_divider))
            }
        }
    }

    private fun updateAdapter(lessonList: List<WordLesson>) {
        wordLessonList.clear()
        wordLessonList.addAll(lessonList)
        wordLessonAdapter.notifyDataSetChanged()
    }

    private fun onLessonItemClick(wordLesson: WordLesson) {
        onLessonDetailRequestHandler.invoke(wordLesson)
    }

    fun setLessonDetailRequestHandler(onLessonDetailRequest: (wordLesson: WordLesson) -> Unit) {
        this.onLessonDetailRequestHandler = onLessonDetailRequest
    }


    override fun onDestroyView() {
        context?.getSharedPreferences(context?.packageName, Activity.MODE_PRIVATE)?.unregisterOnSharedPreferenceChangeListener(this)
        super.onDestroyView()
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String) {
        if (sharedPreferences != null && key == Constants.IS_VIP) {
            val isVip = sharedPreferences.getBoolean(key, false)
            if (isVip) {
                Handler(Looper.getMainLooper()).postDelayed({
                    getWordLessons()
                }, 1000L)
            }
        }
    }
}