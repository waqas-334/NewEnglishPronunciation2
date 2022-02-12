package com.androidbull.mypronounce.ui.feature.dailylesson;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014J\b\u0010\r\u001a\u00020\u0004H\u0014J\b\u0010\u000e\u001a\u00020\u0004H\u0002J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001b\u001a\u00020\u0004H\u0014J\u0010\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0012H\u0002J\u0012\u0010\u001d\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0014J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0012H\u0002\u00a8\u0006\""}, d2 = {"Lcom/androidbull/mypronounce/ui/feature/dailylesson/DailyLessonActivity;", "Lcom/androidbull/mypronounce/ui/BaseActivity;", "()V", "clearNewLessonBadge", "", "getBannerAdID", "", "getBannerAdView", "Landroid/widget/LinearLayout;", "getLayoutResourceId", "", "hideAdRelatedViews", "initActions", "initViews", "logLessonActivityEvent", "logLessonDetailEvent", "source", "lesson", "Lcom/androidbull/mypronounce/data/model/DailyLesson;", "moveToLessonDetailFragment", "dailyLesson", "onAttachFragment", "fragment", "Landroidx/fragment/app/Fragment;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLessonDetailClick", "onNewIntent", "intent", "Landroid/content/Intent;", "setInitialFragment", "showDailyLessonDetailFragment", "app_freeDebug"})
public final class DailyLessonActivity extends com.androidbull.mypronounce.ui.BaseActivity {
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected int getLayoutResourceId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    protected java.lang.String getBannerAdID() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    protected android.widget.LinearLayout getBannerAdView() {
        return null;
    }
    
    @java.lang.Override()
    protected void initViews() {
    }
    
    @java.lang.Override()
    protected void initActions() {
    }
    
    @java.lang.Override()
    protected void hideAdRelatedViews() {
    }
    
    private final void clearNewLessonBadge() {
    }
    
    private final void moveToLessonDetailFragment(com.androidbull.mypronounce.data.model.DailyLesson dailyLesson) {
    }
    
    private final void setInitialFragment(android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onNewIntent(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    @java.lang.Override()
    public void onAttachFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment) {
    }
    
    private final void onLessonDetailClick(com.androidbull.mypronounce.data.model.DailyLesson dailyLesson) {
    }
    
    private final void showDailyLessonDetailFragment(com.androidbull.mypronounce.data.model.DailyLesson dailyLesson) {
    }
    
    private final void logLessonActivityEvent() {
    }
    
    private final void logLessonDetailEvent(java.lang.String source, com.androidbull.mypronounce.data.model.DailyLesson lesson) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public DailyLessonActivity() {
        super();
    }
}