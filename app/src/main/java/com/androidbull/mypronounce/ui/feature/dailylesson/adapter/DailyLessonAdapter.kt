package com.androidbull.mypronounce.ui.feature.dailylesson.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.androidbull.mypronounce.R
import com.androidbull.mypronounce.data.model.DailyLesson
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions


class DailyLessonAdapter(private val dailyLessonList: List<DailyLesson>, private val onLessonItemClick: (dailyLesson: DailyLesson) -> Unit) :
        RecyclerView.Adapter<DailyLessonAdapter.DailyLessonViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): DailyLessonViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_daily_lesson, parent, false)

        return DailyLessonViewHolder(view)
    }


    override fun onBindViewHolder(holder: DailyLessonViewHolder, position: Int) {
        val dailyLesson: DailyLesson = dailyLessonList[position]
        holder.bind(dailyLesson)
    }

    override fun getItemCount(): Int = dailyLessonList.size

    inner class DailyLessonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private var ivLessonImage: ImageView = view.findViewById(R.id.ivLessonImage)
        private var tvLessonTitle: TextView = view.findViewById(R.id.tvLessonTitle)
        private var tvLessonSubtitle: TextView = view.findViewById(R.id.tvLessonSubtitle)
        private var ivOverlay: ImageView = view.findViewById(R.id.ivOverlay)

        init {
            itemView.setOnClickListener {
                onLessonItemClick.invoke(dailyLessonList[adapterPosition])
            }
        }

        fun bind(dailyLesson: DailyLesson) {
            tvLessonTitle.text = dailyLesson.title
            tvLessonSubtitle.text = dailyLesson.subtitle

            if (dailyLesson.isRead) {
                ivOverlay.visibility = View.INVISIBLE
            } else {
                ivOverlay.visibility = View.VISIBLE
            }

            Glide.with(ivOverlay)
                    .load(R.drawable.dl_overlay)
                    .transform(RoundedCorners(8))
                    .placeholder(R.drawable.dl_placeholder).into(ivOverlay)

            if (!TextUtils.isEmpty(dailyLesson.lessonImage))
            {
                Glide.with(ivLessonImage)
                        .load(dailyLesson.lessonImage)
                        .transform(RoundedCorners(8))
                        .placeholder(R.drawable.dl_placeholder).into(ivLessonImage)
            }



            /*    Picasso.get().load(R.drawable.dl_overlay).into(ivOverlay)


                if (!TextUtils.isEmpty(dailyLesson.lessonImage))
                    Picasso.get().load(dailyLesson.lessonImage).placeholder(R.drawable.dl_placeholder).into(ivLessonImage)*/
        }
    }
}