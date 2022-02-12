package com.androidbull.mypronounce.ui.feature.practicesentence

import android.app.Activity
import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.constant.Constants
import com.androidbull.mypronounce.data.local.database.AppDatabase
import com.androidbull.mypronounce.data.model.SentenceLesson
import com.androidbull.mypronounce.ui.feature.dailylesson.adapter.SentenceLessonAdapter
import com.androidbull.mypronounce.ui.helper.DividerItemDecoration
import com.androidbull.mypronounce.ui.helper.PreferenceManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SentenceLessonListFragment : Fragment(), OnSharedPreferenceChangeListener {

    private lateinit var sentenceLessonAdapter: SentenceLessonAdapter
    private lateinit var rvSentenceLesson: RecyclerView
    private val sentenceLessonList = mutableListOf<SentenceLesson>()
    private lateinit var onLessonDetailRequestHandler: (sentenceLesson: SentenceLesson) -> Unit

    companion object {
        @JvmStatic
        fun newInstance() = SentenceLessonListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_sentence_lesson, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setSentenceLessonsRecyclerView(view)
        getSentenceLessons()
    }

    private fun getSentenceLessons() {

        lifecycleScope.launch(Dispatchers.IO) {
            val lessonList = AppDatabase.invoke(requireContext().applicationContext).sentenceLessonDao().getAllWithChildCount()

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
        val activity = requireActivity() as? PracticeSentenceActivity
        return when (item.itemId) {
            android.R.id.home -> {
                activity?.onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setSentenceLessonsRecyclerView(view: View) {

        sentenceLessonAdapter = SentenceLessonAdapter(sentenceLessonList, ::onLessonItemClick)

        rvSentenceLesson = view.findViewById(R.id.rvSentenceLesson)
        rvSentenceLesson.apply {
            adapter = sentenceLessonAdapter
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

    private fun updateAdapter(lessonList: List<SentenceLesson>) {
        sentenceLessonList.clear()
        sentenceLessonList.addAll(lessonList)
        sentenceLessonAdapter.notifyDataSetChanged()
    }

    private fun onLessonItemClick(sentenceLesson: SentenceLesson) {
        onLessonDetailRequestHandler.invoke(sentenceLesson)
    }

    fun setLessonDetailRequestHandler(onLessonDetailRequest: (sentenceLesson: SentenceLesson) -> Unit) {
        this.onLessonDetailRequestHandler = onLessonDetailRequest
    }

    override fun onStart() {
        context?.getSharedPreferences(context?.packageName, Activity.MODE_PRIVATE)?.registerOnSharedPreferenceChangeListener(this)
        super.onStart()
    }


    override fun onDestroy() {
        context?.getSharedPreferences(context?.packageName, Activity.MODE_PRIVATE)?.unregisterOnSharedPreferenceChangeListener(this)
        super.onDestroy()
    }

    override fun onSharedPreferenceChanged(sharedPreferences: SharedPreferences?, key: String) {
        if (sharedPreferences != null && key == Constants.IS_VIP) {
            val isVip = sharedPreferences.getBoolean(key, false)
            if (isVip) {
                Handler(Looper.getMainLooper()).postDelayed({
                    getSentenceLessons()
                }, 1000L)
            }
        }
    }
}