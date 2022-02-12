package com.androidbull.mypronounce.ui.feature.dailylesson;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 ,2\u00020\u00012\u00020\u0002:\u0001,B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u000eH\u0002J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\bH\u0002J\u001a\u0010\u001d\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020\u000eH\u0016J\b\u0010#\u001a\u00020\u000eH\u0016J\u001a\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J)\u0010&\u001a\u00020\u000e2!\u0010\'\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nJ\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0015H\u0002J\u0016\u0010)\u001a\u00020\u000e2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\b0+H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/androidbull/mypronounce/ui/feature/dailylesson/DailyLessonListFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "()V", "dailyLessonAdapter", "Lcom/androidbull/mypronounce/ui/feature/dailylesson/adapter/DailyLessonAdapter;", "dailyLessonList", "", "Lcom/androidbull/mypronounce/data/model/DailyLesson;", "onLessonDetailRequestHandler", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "dailyLesson", "", "rvDailyLessons", "Landroidx/recyclerview/widget/RecyclerView;", "tbDailyLessons", "Lcom/google/android/material/appbar/MaterialToolbar;", "getDailyLessons", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onLessonItemClick", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "", "onStart", "onStop", "onViewCreated", "view", "setLessonDetailRequestHandler", "onLessonDetailRequest", "setLessonsRecyclerView", "updateAdapter", "lessonList", "", "Companion", "app_freeDebug"})
public final class DailyLessonListFragment extends androidx.fragment.app.Fragment implements android.content.SharedPreferences.OnSharedPreferenceChangeListener {
    private com.androidbull.mypronounce.ui.feature.dailylesson.adapter.DailyLessonAdapter dailyLessonAdapter;
    private androidx.recyclerview.widget.RecyclerView rvDailyLessons;
    private final java.util.List<com.androidbull.mypronounce.data.model.DailyLesson> dailyLessonList = null;
    private kotlin.jvm.functions.Function1<? super com.androidbull.mypronounce.data.model.DailyLesson, kotlin.Unit> onLessonDetailRequestHandler;
    private com.google.android.material.appbar.MaterialToolbar tbDailyLessons;
    public static final com.androidbull.mypronounce.ui.feature.dailylesson.DailyLessonListFragment.Companion Companion = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setLessonsRecyclerView(android.view.View view) {
    }
    
    private final void getDailyLessons() {
    }
    
    private final void updateAdapter(java.util.List<com.androidbull.mypronounce.data.model.DailyLesson> lessonList) {
    }
    
    private final void onLessonItemClick(com.androidbull.mypronounce.data.model.DailyLesson dailyLesson) {
    }
    
    public final void setLessonDetailRequestHandler(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.androidbull.mypronounce.data.model.DailyLesson, kotlin.Unit> onLessonDetailRequest) {
    }
    
    @java.lang.Override()
    public void onStart() {
    }
    
    @java.lang.Override()
    public void onStop() {
    }
    
    @java.lang.Override()
    public void onSharedPreferenceChanged(@org.jetbrains.annotations.Nullable()
    android.content.SharedPreferences sharedPreferences, @org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    public DailyLessonListFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.androidbull.mypronounce.ui.feature.dailylesson.DailyLessonListFragment newInstance() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/androidbull/mypronounce/ui/feature/dailylesson/DailyLessonListFragment$Companion;", "", "()V", "newInstance", "Lcom/androidbull/mypronounce/ui/feature/dailylesson/DailyLessonListFragment;", "app_freeDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.androidbull.mypronounce.ui.feature.dailylesson.DailyLessonListFragment newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}