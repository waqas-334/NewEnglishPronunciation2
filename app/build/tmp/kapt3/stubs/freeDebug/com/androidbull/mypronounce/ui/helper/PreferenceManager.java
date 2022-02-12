package com.androidbull.mypronounce.ui.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0006J\u0016\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000bJ\u0016\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\rJ\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b\u00a8\u0006\u0015"}, d2 = {"Lcom/androidbull/mypronounce/ui/helper/PreferenceManager;", "", "()V", "clearPreferences", "", "getBoolean", "", "key", "", "getBooleanFirstLaunch", "getInt", "", "getLong", "", "getString", "setBoolean", "value", "setInt", "setLong", "setString", "Companion", "app_freeDebug"})
public final class PreferenceManager {
    private static final com.androidbull.mypronounce.ui.helper.PreferenceManager sharePref = null;
    private static android.content.SharedPreferences mSharedPreferences;
    public static final com.androidbull.mypronounce.ui.helper.PreferenceManager.Companion Companion = null;
    
    public final void setString(@org.jetbrains.annotations.NotNull()
    java.lang.String key, @org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getString(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return null;
    }
    
    public final void setInt(@org.jetbrains.annotations.NotNull()
    java.lang.String key, int value) {
    }
    
    public final int getInt(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return 0;
    }
    
    public final void setLong(@org.jetbrains.annotations.NotNull()
    java.lang.String key, long value) {
    }
    
    public final long getLong(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return 0L;
    }
    
    public final void setBoolean(@org.jetbrains.annotations.NotNull()
    java.lang.String key, boolean value) {
    }
    
    public final boolean getBoolean(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return false;
    }
    
    public final boolean getBooleanFirstLaunch(@org.jetbrains.annotations.NotNull()
    java.lang.String key) {
        return false;
    }
    
    public final void clearPreferences() {
    }
    
    public PreferenceManager() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/androidbull/mypronounce/ui/helper/PreferenceManager$Companion;", "", "()V", "mSharedPreferences", "Landroid/content/SharedPreferences;", "sharePref", "Lcom/androidbull/mypronounce/ui/helper/PreferenceManager;", "getInstance", "context", "Landroid/content/Context;", "app_freeDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.androidbull.mypronounce.ui.helper.PreferenceManager getInstance(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}