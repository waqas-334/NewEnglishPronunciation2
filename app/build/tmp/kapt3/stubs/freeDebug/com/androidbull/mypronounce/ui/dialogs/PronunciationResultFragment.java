package com.androidbull.mypronounce.ui.dialogs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0012\u0010\u0010\u001a\u00020\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/androidbull/mypronounce/ui/dialogs/PronunciationResultFragment;", "Landroidx/fragment/app/DialogFragment;", "()V", "onClickListener", "Landroid/view/View$OnClickListener;", "pronunciationAccuracy", "", "speechResult", "userInput", "initActions", "", "view", "Landroid/view/View;", "initView", "isPronunciationAccuracyBelowAverage", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onViewCreated", "setOnClickListener", "Companion", "app_freeDebug"})
public final class PronunciationResultFragment extends androidx.fragment.app.DialogFragment {
    private java.lang.String speechResult;
    private java.lang.String userInput;
    private java.lang.String pronunciationAccuracy;
    private android.view.View.OnClickListener onClickListener;
    public static final com.androidbull.mypronounce.ui.dialogs.PronunciationResultFragment.Companion Companion = null;
    
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
    
    private final void initView(android.view.View view) {
    }
    
    private final void initActions(android.view.View view) {
    }
    
    private final boolean isPronunciationAccuracyBelowAverage() {
        return false;
    }
    
    public final void setOnClickListener(@org.jetbrains.annotations.NotNull()
    android.view.View.OnClickListener onClickListener) {
    }
    
    public PronunciationResultFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.androidbull.mypronounce.ui.dialogs.PronunciationResultFragment newInstance(@org.jetbrains.annotations.NotNull()
    java.lang.String userInput, @org.jetbrains.annotations.NotNull()
    java.lang.String speechResult, @org.jetbrains.annotations.NotNull()
    java.lang.String pronunciationAccuracy) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0007\u00a8\u0006\t"}, d2 = {"Lcom/androidbull/mypronounce/ui/dialogs/PronunciationResultFragment$Companion;", "", "()V", "newInstance", "Lcom/androidbull/mypronounce/ui/dialogs/PronunciationResultFragment;", "userInput", "", "speechResult", "pronunciationAccuracy", "app_freeDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.androidbull.mypronounce.ui.dialogs.PronunciationResultFragment newInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String userInput, @org.jetbrains.annotations.NotNull()
        java.lang.String speechResult, @org.jetbrains.annotations.NotNull()
        java.lang.String pronunciationAccuracy) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}