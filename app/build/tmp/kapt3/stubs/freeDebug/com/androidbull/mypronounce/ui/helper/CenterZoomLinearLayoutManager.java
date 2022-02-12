package com.androidbull.mypronounce.ui.helper;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0002J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0010\u001a\b\u0018\u00010\u0011R\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\"\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/androidbull/mypronounce/ui/helper/CenterZoomLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "mShrinkDistance", "", "mShrinkAmount", "(Landroid/content/Context;FF)V", "onLayoutCompleted", "", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scaleChildren", "scrollHorizontallyBy", "", "dx", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "smoothScrollToPosition", "recyclerView", "position", "app_freeDebug"})
public final class CenterZoomLinearLayoutManager extends androidx.recyclerview.widget.LinearLayoutManager {
    private final float mShrinkDistance = 0.0F;
    private final float mShrinkAmount = 0.0F;
    
    @java.lang.Override()
    public void onLayoutCompleted(@org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView.State state) {
    }
    
    @java.lang.Override()
    public int scrollHorizontallyBy(int dx, @org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView.Recycler recycler, @org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView.State state) {
        return 0;
    }
    
    private final void scaleChildren() {
    }
    
    @java.lang.Override()
    public void smoothScrollToPosition(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView recyclerView, @org.jetbrains.annotations.Nullable()
    androidx.recyclerview.widget.RecyclerView.State state, int position) {
    }
    
    public CenterZoomLinearLayoutManager(@org.jetbrains.annotations.NotNull()
    android.content.Context context, float mShrinkDistance, float mShrinkAmount) {
        super(null);
    }
}