package com.androidbull.mypronounce.ui.helper;

import java.lang.System;

/**
 * Defines a TextView widget where user can click on different words to see different actions
 */
@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0015B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J\u001c\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/androidbull/mypronounce/ui/helper/ClickableTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addClickablePart", "Landroid/text/SpannableStringBuilder;", "str", "", "clickableWords", "", "Lcom/androidbull/mypronounce/ui/helper/ClickableTextView$ClickableWord;", "setTextWithClickableWords", "", "text", "ClickableWord", "app_freeDebug"})
public final class ClickableTextView extends androidx.appcompat.widget.AppCompatTextView {
    
    public final void setTextWithClickableWords(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.util.List<com.androidbull.mypronounce.ui.helper.ClickableTextView.ClickableWord> clickableWords) {
    }
    
    private final android.text.SpannableStringBuilder addClickablePart(java.lang.String str, java.util.List<com.androidbull.mypronounce.ui.helper.ClickableTextView.ClickableWord> clickableWords) {
        return null;
    }
    
    public ClickableTextView(@org.jetbrains.annotations.Nullable()
    android.content.Context context) {
        super(null);
    }
    
    public ClickableTextView(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
    
    public ClickableTextView(@org.jetbrains.annotations.Nullable()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyle) {
        super(null);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/androidbull/mypronounce/ui/helper/ClickableTextView$ClickableWord;", "", "word", "", "clickableSpan", "Landroid/text/style/ClickableSpan;", "(Ljava/lang/String;Landroid/text/style/ClickableSpan;)V", "getClickableSpan", "()Landroid/text/style/ClickableSpan;", "getWord", "()Ljava/lang/String;", "app_freeDebug"})
    public static final class ClickableWord {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String word = null;
        @org.jetbrains.annotations.NotNull()
        private final android.text.style.ClickableSpan clickableSpan = null;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getWord() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.text.style.ClickableSpan getClickableSpan() {
            return null;
        }
        
        public ClickableWord(@org.jetbrains.annotations.NotNull()
        java.lang.String word, @org.jetbrains.annotations.NotNull()
        android.text.style.ClickableSpan clickableSpan) {
            super();
        }
    }
}