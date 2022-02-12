package com.androidbull.mypronounce.ui.dialogs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u001a\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0004H\u0002J\b\u0010\u0016\u001a\u00020\nH\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/androidbull/mypronounce/ui/dialogs/RecordPronunciationFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "logTag", "", "kotlin.jvm.PlatformType", "paramWord", "speechDelegate", "Lnet/gotev/speech/SpeechDelegate;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onDestroyView", "onViewCreated", "view", "Landroid/view/View;", "setRecognitionListener", "showSpeechRecognitionError", "errorStr", "startListening", "Companion", "app_freeDebug"})
public final class RecordPronunciationFragment extends androidx.fragment.app.DialogFragment {
    private final java.lang.String logTag = null;
    private java.lang.String paramWord;
    private net.gotev.speech.SpeechDelegate speechDelegate;
    public static final com.androidbull.mypronounce.ui.dialogs.RecordPronunciationFragment.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public android.app.Dialog onCreateDialog(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void setRecognitionListener(@org.jetbrains.annotations.NotNull()
    net.gotev.speech.SpeechDelegate speechDelegate) {
    }
    
    private final void startListening() {
    }
    
    private final void showSpeechRecognitionError(java.lang.String errorStr) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    public RecordPronunciationFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.androidbull.mypronounce.ui.dialogs.RecordPronunciationFragment newInstance(@org.jetbrains.annotations.NotNull()
    java.lang.String word) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/androidbull/mypronounce/ui/dialogs/RecordPronunciationFragment$Companion;", "", "()V", "newInstance", "Lcom/androidbull/mypronounce/ui/dialogs/RecordPronunciationFragment;", "word", "", "app_freeDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.androidbull.mypronounce.ui.dialogs.RecordPronunciationFragment newInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String word) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}