package com.androidbull.mypronounce.ui.feature.practiceword;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\nH\u0002J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0006H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u001a\u0010 \u001a\u00020\n2\b\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020$H\u0016J\u001a\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J)\u0010\'\u001a\u00020\n2!\u0010(\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005J\u0010\u0010)\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u0013H\u0002J\u0016\u0010*\u001a\u00020\n2\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060,H\u0002R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/androidbull/mypronounce/ui/feature/practiceword/WordLessonListFragment;", "Landroidx/fragment/app/Fragment;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "()V", "onLessonDetailRequestHandler", "Lkotlin/Function1;", "Lcom/androidbull/mypronounce/data/model/WordLesson;", "Lkotlin/ParameterName;", "name", "wordLesson", "", "rvWordLesson", "Landroidx/recyclerview/widget/RecyclerView;", "wordLessonAdapter", "Lcom/androidbull/mypronounce/ui/feature/dailylesson/adapter/WordLessonAdapter;", "wordLessonList", "", "getWordLessons", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onLessonItemClick", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "onSharedPreferenceChanged", "sharedPreferences", "Landroid/content/SharedPreferences;", "key", "", "onViewCreated", "view", "setLessonDetailRequestHandler", "onLessonDetailRequest", "setWordLessonsRecyclerView", "updateAdapter", "lessonList", "", "Companion", "app_freeDebug"})
public final class WordLessonListFragment extends androidx.fragment.app.Fragment implements android.content.SharedPreferences.OnSharedPreferenceChangeListener {
    private com.androidbull.mypronounce.ui.feature.dailylesson.adapter.WordLessonAdapter wordLessonAdapter;
    private androidx.recyclerview.widget.RecyclerView rvWordLesson;
    private final java.util.List<com.androidbull.mypronounce.data.model.WordLesson> wordLessonList = null;
    private kotlin.jvm.functions.Function1<? super com.androidbull.mypronounce.data.model.WordLesson, kotlin.Unit> onLessonDetailRequestHandler;
    public static final com.androidbull.mypronounce.ui.feature.practiceword.WordLessonListFragment.Companion Companion = null;
    
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
    
    private final void getWordLessons() {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void setWordLessonsRecyclerView(android.view.View view) {
    }
    
    private final void updateAdapter(java.util.List<com.androidbull.mypronounce.data.model.WordLesson> lessonList) {
    }
    
    private final void onLessonItemClick(com.androidbull.mypronounce.data.model.WordLesson wordLesson) {
    }
    
    public final void setLessonDetailRequestHandler(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.androidbull.mypronounce.data.model.WordLesson, kotlin.Unit> onLessonDetailRequest) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    @java.lang.Override()
    public void onSharedPreferenceChanged(@org.jetbrains.annotations.Nullable()
    android.content.SharedPreferences sharedPreferences, @org.jetbrains.annotations.NotNull()
    java.lang.String key) {
    }
    
    public WordLessonListFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.androidbull.mypronounce.ui.feature.practiceword.WordLessonListFragment newInstance() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/androidbull/mypronounce/ui/feature/practiceword/WordLessonListFragment$Companion;", "", "()V", "newInstance", "Lcom/androidbull/mypronounce/ui/feature/practiceword/WordLessonListFragment;", "app_freeDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.androidbull.mypronounce.ui.feature.practiceword.WordLessonListFragment newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}