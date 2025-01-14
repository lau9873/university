package android.support.p067v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import p000a.p006b.p049h.p063k.FitWindowsViewGroup;

/* renamed from: android.support.v7.widget.FitWindowsFrameLayout */
/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout implements FitWindowsViewGroup {

    /* renamed from: a */
    public FitWindowsViewGroup.InterfaceC0484a f4048a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        FitWindowsViewGroup.InterfaceC0484a interfaceC0484a = this.f4048a;
        if (interfaceC0484a != null) {
            interfaceC0484a.mo8182a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // p000a.p006b.p049h.p063k.FitWindowsViewGroup
    public void setOnFitSystemWindowsListener(FitWindowsViewGroup.InterfaceC0484a interfaceC0484a) {
        this.f4048a = interfaceC0484a;
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
