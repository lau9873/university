package android.support.v7.widget;

import a.b.h.k.n0;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
/* loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements n0 {

    /* renamed from: a  reason: collision with root package name */
    public n0.a f2526a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        n0.a aVar = this.f2526a;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // a.b.h.k.n0
    public void setOnFitSystemWindowsListener(n0.a aVar) {
        this.f2526a = aVar;
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
