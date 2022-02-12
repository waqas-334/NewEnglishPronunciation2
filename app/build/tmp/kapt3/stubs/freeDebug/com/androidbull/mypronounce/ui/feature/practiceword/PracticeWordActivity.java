package com.androidbull.mypronounce.ui.feature.practiceword;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0014J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0014J\"\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u000eH\u0014J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016J\u0010\u0010%\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010&\u001a\u00020\u000e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\'\u001a\u00020\u000eH\u0002J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020\bH\u0002J\b\u0010*\u001a\u00020\u000eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/androidbull/mypronounce/ui/feature/practiceword/PracticeWordActivity;", "Lcom/androidbull/mypronounce/ui/BaseActivity;", "()V", "billingProcessor", "Lcom/anjlab/android/iab/v3/BillingProcessor;", "tvScoreWords", "Landroid/widget/TextView;", "getBannerAdID", "", "getBannerAdView", "Landroid/widget/LinearLayout;", "getLayoutResourceId", "", "getWordScore", "", "hideAdRelatedViews", "initActions", "initViews", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttachFragment", "fragment", "Landroidx/fragment/app/Fragment;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onLessonDetailClick", "wordLesson", "Lcom/androidbull/mypronounce/data/model/WordLesson;", "onOptionsItemSelected", "", "item", "Landroid/view/MenuItem;", "replaceFragment", "setInitialFragment", "setToolbar", "setToolbarTitle", "title", "showVipDialog", "app_freeDebug"})
public final class PracticeWordActivity extends com.androidbull.mypronounce.ui.BaseActivity {
    private android.widget.TextView tvScoreWords;
    private com.anjlab.android.iab.v3.BillingProcessor billingProcessor;
    
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
    
    private final void setToolbar() {
    }
    
    private final void getWordScore() {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void setInitialFragment(android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onAttachFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment fragment) {
    }
    
    private final void onLessonDetailClick(com.androidbull.mypronounce.data.model.WordLesson wordLesson) {
    }
    
    private final void showVipDialog() {
    }
    
    private final void replaceFragment(androidx.fragment.app.Fragment fragment) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    private final void setToolbarTitle(java.lang.String title) {
    }
    
    public PracticeWordActivity() {
        super();
    }
}