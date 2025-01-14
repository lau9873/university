package a.b.h.k;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
/* compiled from: AppCompatPopupWindow.java */
/* loaded from: classes.dex */
public class r extends PopupWindow {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f1918b;

    /* renamed from: a  reason: collision with root package name */
    public boolean f1919a;

    static {
        f1918b = Build.VERSION.SDK_INT < 21;
    }

    public r(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        a(context, attributeSet, i2, i3);
    }

    public final void a(Context context, AttributeSet attributeSet, int i2, int i3) {
        l1 a2 = l1.a(context, attributeSet, a.b.h.b.j.PopupWindow, i2, i3);
        if (a2.g(a.b.h.b.j.PopupWindow_overlapAnchor)) {
            a(a2.a(a.b.h.b.j.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(a2.b(a.b.h.b.j.PopupWindow_android_popupBackground));
        a2.a();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3) {
        if (f1918b && this.f1919a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i2, int i3, int i4, int i5) {
        if (f1918b && this.f1919a) {
            i3 -= view.getHeight();
        }
        super.update(view, i2, i3, i4, i5);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i2, int i3, int i4) {
        if (f1918b && this.f1919a) {
            i3 -= view.getHeight();
        }
        super.showAsDropDown(view, i2, i3, i4);
    }

    public final void a(boolean z) {
        if (f1918b) {
            this.f1919a = z;
        } else {
            a.b.g.l.m.a(this, z);
        }
    }
}
