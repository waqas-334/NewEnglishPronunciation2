package com.androidbull.mypronounce.ui.feature.dailylesson.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0014\u0015B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016J\u000e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\bR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/androidbull/mypronounce/ui/feature/dailylesson/adapter/SentenceListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/androidbull/mypronounce/ui/feature/dailylesson/adapter/SentenceListAdapter$SentenceViewHolder;", "sentenceList", "", "Lcom/androidbull/mypronounce/data/model/Sentence;", "(Ljava/util/List;)V", "onSentenceItemChildViewClickListener", "Lcom/androidbull/mypronounce/ui/feature/dailylesson/adapter/SentenceListAdapter$OnSentenceItemChildViewClickListener;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setOnSentenceItemChildViewClickListener", "OnSentenceItemChildViewClickListener", "SentenceViewHolder", "app_freeDebug"})
public final class SentenceListAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.androidbull.mypronounce.ui.feature.dailylesson.adapter.SentenceListAdapter.SentenceViewHolder> {
    private com.androidbull.mypronounce.ui.feature.dailylesson.adapter.SentenceListAdapter.OnSentenceItemChildViewClickListener onSentenceItemChildViewClickListener;
    private final java.util.List<com.androidbull.mypronounce.data.model.Sentence> sentenceList = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.androidbull.mypronounce.ui.feature.dailylesson.adapter.SentenceListAdapter.SentenceViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.androidbull.mypronounce.ui.feature.dailylesson.adapter.SentenceListAdapter.SentenceViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void setOnSentenceItemChildViewClickListener(@org.jetbrains.annotations.NotNull()
    com.androidbull.mypronounce.ui.feature.dailylesson.adapter.SentenceListAdapter.OnSentenceItemChildViewClickListener onSentenceItemChildViewClickListener) {
    }
    
    public SentenceListAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.androidbull.mypronounce.data.model.Sentence> sentenceList) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/androidbull/mypronounce/ui/feature/dailylesson/adapter/SentenceListAdapter$SentenceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/androidbull/mypronounce/ui/feature/dailylesson/adapter/SentenceListAdapter;Landroid/view/View;)V", "ctvSpeechResult", "Lcom/androidbull/mypronounce/ui/helper/ClickableTextView;", "ibSpeech", "Landroid/widget/ImageButton;", "ibTranslate", "llAccuracy", "Landroid/widget/LinearLayout;", "tvAccuracyPercentage", "Landroid/widget/TextView;", "tvSentenceWords", "tvSpeechOutput", "bind", "", "sentence", "Lcom/androidbull/mypronounce/data/model/Sentence;", "position", "", "app_freeDebug"})
    public final class SentenceViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        private android.widget.TextView tvSentenceWords;
        private android.widget.TextView tvAccuracyPercentage;
        private com.androidbull.mypronounce.ui.helper.ClickableTextView ctvSpeechResult;
        private android.widget.TextView tvSpeechOutput;
        private android.widget.ImageButton ibSpeech;
        private android.widget.ImageButton ibTranslate;
        private android.widget.LinearLayout llAccuracy;
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.androidbull.mypronounce.data.model.Sentence sentence, int position) {
        }
        
        public SentenceViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\nH&\u00a8\u0006\u000b"}, d2 = {"Lcom/androidbull/mypronounce/ui/feature/dailylesson/adapter/SentenceListAdapter$OnSentenceItemChildViewClickListener;", "", "onSpeechViewClick", "", "sentence", "Lcom/androidbull/mypronounce/data/model/Sentence;", "position", "", "onTranslateViewClick", "onWrongSentenceClick", "", "app_freeDebug"})
    public static abstract interface OnSentenceItemChildViewClickListener {
        
        public abstract void onTranslateViewClick(@org.jetbrains.annotations.NotNull()
        com.androidbull.mypronounce.data.model.Sentence sentence, int position);
        
        public abstract void onSpeechViewClick(@org.jetbrains.annotations.NotNull()
        com.androidbull.mypronounce.data.model.Sentence sentence, int position);
        
        public abstract void onWrongSentenceClick(@org.jetbrains.annotations.NotNull()
        java.lang.String sentence);
    }
}