package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import p000a.p006b.p030g.p048l.PopupWindowCompat;
import p000a.p006b.p049h.p051b.C0363j;

/* renamed from: a.b.h.k.r */
/* loaded from: classes.dex */
public class AppCompatPopupWindow extends PopupWindow {

    /* renamed from: b */
    public static final boolean f2882b;

    /* renamed from: a */
    public boolean f2883a;

    static {
        f2882b = Build.VERSION.SDK_INT < 21;
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m8128a(context, attributeSet, i, i2);
    }

    /* renamed from: a */
    public final void m8128a(Context context, AttributeSet attributeSet, int i, int i2) {
        TintTypedArray m8257a = TintTypedArray.m8257a(context, attributeSet, C0363j.PopupWindow, i, i2);
        if (m8257a.m8245g(C0363j.PopupWindow_overlapAnchor)) {
            m8127a(m8257a.m8260a(C0363j.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(m8257a.m8256b(C0363j.PopupWindow_android_popupBackground));
        m8257a.m8265a();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (f2882b && this.f2883a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        if (f2882b && this.f2883a) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f2882b && this.f2883a) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    /* renamed from: a */
    public final void m8127a(boolean z) {
        if (f2882b) {
            this.f2883a = z;
        } else {
            PopupWindowCompat.m9220a(this, z);
        }
    }
}
