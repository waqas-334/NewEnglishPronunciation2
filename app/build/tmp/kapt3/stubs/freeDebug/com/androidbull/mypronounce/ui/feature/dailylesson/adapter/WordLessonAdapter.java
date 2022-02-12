package com.androidbull.mypronounce.ui.feature.dailylesson.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0016B6\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\u000b2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/androidbull/mypronounce/ui/feature/dailylesson/adapter/WordLessonAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/androidbull/mypronounce/ui/feature/dailylesson/adapter/WordLessonAdapter$WordLessonViewHolder;", "wordLessonList", "", "Lcom/androidbull/mypronounce/data/model/WordLesson;", "onLessonItemClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "wordLesson", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "WordLessonViewHolder", "app_freeDebug"})
public final class WordLessonAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.androidbull.mypronounce.ui.feature.dailylesson.adapter.WordLessonAdapter.WordLessonViewHolder> {
    private final java.util.List<com.androidbull.mypronounce.data.model.WordLesson> wordLessonList = null;
    private final kotlin.jvm.functions.Function1<com.androidbull.mypronounce.data.model.WordLesson, kotlin.Unit> onLessonItemClick = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.androidbull.mypronounce.ui.feature.dailylesson.adapter.WordLessonAdapter.WordLessonViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.androidbull.mypronounce.ui.feature.dailylesson.adapter.WordLessonAdapter.WordLessonViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public WordLessonAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.androidbull.mypronounce.data.model.WordLesson> wordLessonList, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.androidbull.mypronounce.data.model.WordLesson, kotlin.Unit> onLessonItemClick) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/androidbull/mypronounce/ui/feature/dailylesson/adapter/WordLessonAdapter$WordLessonViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/androidbull/mypronounce/ui/feature/dailylesson/adapter/WordLessonAdapter;Landroid/view/View;)V", "cpvLessonWords", "Lcom/vaibhavlakhera/circularprogressview/CircularProgressView;", "ivLessonLocked", "Landroid/widget/ImageView;", "tvLessonSubtitle", "Landroid/widget/TextView;", "tvTitleLesson", "tvWordsCompleted", "bind", "", "wordLesson", "Lcom/androidbull/mypronounce/data/model/WordLesson;", "app_freeDebug"})
    public final class WordLessonViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private android.widget.TextView tvTitleLesson;
        private android.widget.TextView tvLessonSubtitle;
        private android.widget.ImageView ivLessonLocked;
        private android.widget.TextView tvWordsCompleted;
        private com.vaibhavlakhera.circularprogressview.CircularProgressView cpvLessonWords;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.androidbull.mypronounce.data.model.WordLesson wordLesson) {
        }
        
        public WordLessonViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}