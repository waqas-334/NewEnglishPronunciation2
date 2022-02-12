package com.androidbull.mypronounce.ui.dialogs;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0012\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0018\u001a\u00020\u000eH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/androidbull/mypronounce/ui/dialogs/VipDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "billingProcessor", "Lcom/anjlab/android/iab/v3/BillingProcessor;", "onClickListener", "Landroid/view/View$OnClickListener;", "tvDiscountedPrice", "Landroid/widget/TextView;", "tvPrice", "getActualPrice", "", "discountedPrice", "initActions", "", "view", "Landroid/view/View;", "initView", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "setOnClickListener", "setPrice", "Companion", "app_freeDebug"})
public final class VipDialog extends androidx.fragment.app.DialogFragment {
    private android.view.View.OnClickListener onClickListener;
    private android.widget.TextView tvDiscountedPrice;
    private android.widget.TextView tvPrice;
    private com.anjlab.android.iab.v3.BillingProcessor billingProcessor;
    public static final com.androidbull.mypronounce.ui.dialogs.VipDialog.Companion Companion = null;
    
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
    
    private final void setPrice() {
    }
    
    private final double getActualPrice(double discountedPrice) {
        return 0.0;
    }
    
    private final void initView(android.view.View view) {
    }
    
    private final void initActions(android.view.View view) {
    }
    
    public final void setOnClickListener(@org.jetbrains.annotations.NotNull()
    android.view.View.OnClickListener onClickListener) {
    }
    
    public VipDialog() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final com.androidbull.mypronounce.ui.dialogs.VipDialog newInstance() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007\u00a8\u0006\u0005"}, d2 = {"Lcom/androidbull/mypronounce/ui/dialogs/VipDialog$Companion;", "", "()V", "newInstance", "Lcom/androidbull/mypronounce/ui/dialogs/VipDialog;", "app_freeDebug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.androidbull.mypronounce.ui.dialogs.VipDialog newInstance() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}