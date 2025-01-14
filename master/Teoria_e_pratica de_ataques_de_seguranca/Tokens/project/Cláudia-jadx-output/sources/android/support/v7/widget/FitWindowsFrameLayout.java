package android.support.v7.widget;

import a.b.h.k.n0;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
/* loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout implements n0 {

    /* renamed from: a  reason: collision with root package name */
    public n0.a f2525a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    @Override // android.view.View
    public boolean fitSystemWindows(Rect rect) {
        n0.a aVar = this.f2525a;
        if (aVar != null) {
            aVar.a(rect);
        }
        return super.fitSystemWindows(rect);
    }

    @Override // a.b.h.k.n0
    public void setOnFitSystemWindowsListener(n0.a aVar) {
        this.f2525a = aVar;
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
