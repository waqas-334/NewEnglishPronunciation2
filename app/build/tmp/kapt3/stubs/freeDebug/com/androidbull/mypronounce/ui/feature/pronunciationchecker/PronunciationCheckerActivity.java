package com.androidbull.mypronounce.ui.feature.pronunciationchecker;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0002J\b\u0010\f\u001a\u00020\rH\u0014J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0010\u001a\u00020\u0011H\u0014J\b\u0010\u0012\u001a\u00020\rH\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u000bH\u0014J\b\u0010\u0016\u001a\u00020\u000bH\u0014J\b\u0010\u0017\u001a\u00020\u000bH\u0014J\u0010\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\rH\u0002J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u000bH\u0014J\u0010\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001f\u001a\u00020 H\u0016J+\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00112\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0$2\u0006\u0010%\u001a\u00020&H\u0016\u00a2\u0006\u0002\u0010\'J\u0018\u0010(\u001a\u00020\u000b2\u000e\u0010)\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010*H\u0016J\u0012\u0010+\u001a\u00020\u000b2\b\u0010,\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u000bH\u0016J\b\u00101\u001a\u00020\u000bH\u0002J\b\u00102\u001a\u00020\u000bH\u0002J\b\u00103\u001a\u00020\u000bH\u0002J\b\u00104\u001a\u00020\u000bH\u0002J \u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\r2\u0006\u0010,\u001a\u00020\r2\u0006\u00107\u001a\u00020\rH\u0002J\u0010\u00108\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\rH\u0002J\u0010\u00109\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006:"}, d2 = {"Lcom/androidbull/mypronounce/ui/feature/pronunciationchecker/PronunciationCheckerActivity;", "Lcom/androidbull/mypronounce/ui/BaseActivity;", "Lnet/gotev/speech/SpeechDelegate;", "()V", "etWord", "Landroid/widget/EditText;", "pronunciationResultFragment", "Lcom/androidbull/mypronounce/ui/dialogs/PronunciationResultFragment;", "recordPronunciationFragment", "Lcom/androidbull/mypronounce/ui/dialogs/RecordPronunciationFragment;", "dismissRecordPronunciationFragment", "", "getBannerAdID", "", "getBannerAdView", "Landroid/widget/LinearLayout;", "getLayoutResourceId", "", "getUserInput", "hasRecordPermissions", "", "hideAdRelatedViews", "initActions", "initViews", "isValidWord", "word", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "requestCode", "permissions", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onSpeechPartialResults", "results", "", "onSpeechResult", "speechResult", "onSpeechRmsChanged", "value", "", "onStartOfSpeech", "requestRecordPermissions", "setToolbar", "showInputError", "showPermissionDeniedError", "showPronunciationResultFragment", "userInput", "pronunciationAccuracy", "showRecordPronunciationFragment", "startSpeakActivity", "app_freeDebug"})
public final class PronunciationCheckerActivity extends com.androidbull.mypronounce.ui.BaseActivity implements net.gotev.speech.SpeechDelegate {
    private android.widget.EditText etWord;
    private com.androidbull.mypronounce.ui.dialogs.RecordPronunciationFragment recordPronunciationFragment;
    private com.androidbull.mypronounce.ui.dialogs.PronunciationResultFragment pronunciationResultFragment;
    
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
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final java.lang.String getUserInput() {
        return null;
    }
    
    private final void showInputError() {
    }
    
    private final void showPermissionDeniedError() {
    }
    
    private final boolean hasRecordPermissions() {
        return false;
    }
    
    private final void requestRecordPermissions() {
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
    }
    
    @java.lang.Override()
    public void onStartOfSpeech() {
    }
    
    @java.lang.Override()
    public void onSpeechPartialResults(@org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> results) {
    }
    
    @java.lang.Override()
    public void onSpeechRmsChanged(float value) {
    }
    
    @java.lang.Override()
    public void onSpeechResult(@org.jetbrains.annotations.Nullable()
    java.lang.String speechResult) {
    }
    
    private final void showRecordPronunciationFragment(java.lang.String userInput) {
    }
    
    private final void dismissRecordPronunciationFragment() {
    }
    
    private final void showPronunciationResultFragment(java.lang.String userInput, java.lang.String speechResult, java.lang.String pronunciationAccuracy) {
    }
    
    private final boolean isValidWord(java.lang.String word) {
        return false;
    }
    
    private final void startSpeakActivity(java.lang.String userInput) {
    }
    
    @java.lang.Override()
    protected void onDestroy() {
    }
    
    public PronunciationCheckerActivity() {
        super();
    }
}