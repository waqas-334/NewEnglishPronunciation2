package com.androidbull.mypronounce.ui.feature.dailylesson

import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.data.local.database.AppDatabase
import com.androidbull.mypronounce.data.model.DailyLesson
import com.bumptech.glide.Glide
import com.google.android.material.appbar.CollapsingToolbarLayout
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private const val ARG_PARAM_DAILY_LESSON = "dailyLesson"

class DailyLessonDetailFragment : Fragment() {

    private var paramDailyLesson: DailyLesson? = null

    companion object {
        @JvmStatic
        fun newInstance(dailyLesson: DailyLesson) =
                DailyLessonDetailFragment().apply {
                    arguments = Bundle().apply {
                        putSerializable(ARG_PARAM_DAILY_LESSON, dailyLesson)
                    }
                }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramDailyLesson = it.getSerializable(ARG_PARAM_DAILY_LESSON) as DailyLesson
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_daily_lesson_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        paramDailyLesson?.let {

            setLessonRead(it)

            view.findViewById<CollapsingToolbarLayout>(R.id.ctbLessonDetail).title = it.subtitle
            view.findViewById<TextView>(R.id.tvLessonDescription).text = HtmlCompat.fromHtml(it.description,HtmlCompat.FROM_HTML_MODE_LEGACY)
            val ivLessonImage = view.findViewById<ImageView>(R.id.ivLessonImage)
            if (!TextUtils.isEmpty(it.lessonImage))
            {
                Glide.with(ivLessonImage).load(it.lessonImage).placeholder(R.drawable.dl_placeholder).into(ivLessonImage)
            }
//                Picasso.get().load(it.lessonImage).placeholder(R.drawable.dl_placeholder).into(ivLessonImage)
        }
    }

    private fun setLessonRead(dailyLesson: DailyLesson) {
        dailyLesson.isRead = true
        GlobalScope.launch(Dispatchers.IO) {
            AppDatabase.invoke(requireContext()).dailyLessonDao().update(dailyLesson)
        }
    }
}