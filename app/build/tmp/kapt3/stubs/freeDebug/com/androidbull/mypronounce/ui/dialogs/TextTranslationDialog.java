package com.androidbull.mypronounce.ui.dialogs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005\u00a2\u0006\u0002\u0010\u0002J!\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010!\u001a\u00020\u0015H\u0016J\u001a\u0010\"\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010#\u001a\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082.\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006%"}, d2 = {"Lcom/androidbull/mypronounce/ui/dialogs/TextTranslationDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "btnTranslate", "Landroid/widget/Button;", "call", "Lokhttp3/Call;", "paramText", "", "pbTranslation", "Landroid/widget/ProgressBar;", "spnTargetLanguage", "Landroid/widget/Spinner;", "supportedLanguageList", "", "Lcom/androidbull/mypronounce/data/model/TranslationSupportedLanguage;", "targetLanguageCode", "tvTextToTranslate", "Landroid/widget/TextView;", "tvTranslatedText", "googleTranslate", "", "text", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "initActions", "initView", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onDestroyView", "onViewCreated", "setLanguagesSpinner", "Companion", "app_freeDebug"})
public final class TextTranslationDialog extends androidx.fragment.app.DialogFragment {
    private java.lang.String paramText;
    private android.widget.TextView tvTextToTranslate;
    private android.widget.TextView tvTranslatedText;
    private android.widget.Button btnTranslate;
    private android.widget.Spinner spnTargetLanguage;
    private android.widget.ProgressBar pbTranslation;
    private java.util.List<com.androidbull.mypronounce.data.model.TranslationSupportedLanguage> supportedLanguageList;
    private java.lang.String targetLanguageCode = "en";
    private okhttp3.Call call;
    public static final com.androidbull.mypronounce.ui.dialogs.TextTranslationDialog.Companion Companion = null;
    
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
    
    private final void setLanguagesSpinner() {
    }
    
    private final void initView(android.view.View view) {
    }
    
    private final void initActions() {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    public TextTranslationDialog() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.androidbull.mypronounce.ui.dialogs.TextTranslationDialog newInstance(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/androidbull/mypronounce/ui/dialogs/TextTranslationDialog$Companion;", "", "()V", "newInstance", "Lcom/androidbull/mypronounce/ui/dialogs/TextTranslationDialog;", "text", "", "app_freeDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.androidbull.mypronounce.ui.dialogs.TextTranslationDialog newInstance(@org.jetbrains.annotations.NotNull()
        java.lang.String text) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}