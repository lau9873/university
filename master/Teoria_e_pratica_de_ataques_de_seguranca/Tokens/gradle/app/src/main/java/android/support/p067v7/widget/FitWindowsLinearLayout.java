package android.support.p067v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import p000a.p006b.p049h.p063k.FitWindowsViewGroup;

/* renamed from: android.support.v7.widget.FitWindowsLinearLayout */
/* loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements FitWindowsViewGroup {

    /* renamed from: a */
    public FitWindowsViewGroup.InterfaceC0484a f4049a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        FitWindowsViewGroup.InterfaceC0484a interfaceC0484a = this.f4049a;
        if (interfaceC0484a != null) {
            interfaceC0484a.mo8182a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // p000a.p006b.p049h.p063k.FitWindowsViewGroup
    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.InterfaceC0484a interfaceC0484a) {
        this.f4049a = interfaceC0484a;
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
