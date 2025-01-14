package p000a.p006b.p049h.p063k;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p049h.p051b.C0363j;

/* renamed from: a.b.h.k.f */
/* loaded from: classes.dex */
public class AppCompatBackgroundHelper {

    /* renamed from: a */
    public final View f2610a;

    /* renamed from: d */
    public TintInfo f2613d;

    /* renamed from: e */
    public TintInfo f2614e;

    /* renamed from: f */
    public TintInfo f2615f;

    /* renamed from: c */
    public int f2612c = -1;

    /* renamed from: b */
    public final AppCompatDrawableManager f2611b = AppCompatDrawableManager.m8318a();

    public AppCompatBackgroundHelper(View view) {
        this.f2610a = view;
    }

    /* renamed from: a */
    public void m8419a(AttributeSet attributeSet, int i) {
        TintTypedArray m8257a = TintTypedArray.m8257a(this.f2610a.getContext(), attributeSet, C0363j.ViewBackgroundHelper, i, 0);
        try {
            if (m8257a.m8245g(C0363j.ViewBackgroundHelper_android_background)) {
                this.f2612c = m8257a.m8244g(C0363j.ViewBackgroundHelper_android_background, -1);
                ColorStateList m8293d = this.f2611b.m8293d(this.f2610a.getContext(), this.f2612c);
                if (m8293d != null) {
                    m8422a(m8293d);
                }
            }
            if (m8257a.m8245g(C0363j.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.m9450a(this.f2610a, m8257a.m8264a(C0363j.ViewBackgroundHelper_backgroundTint));
            }
            if (m8257a.m8245g(C0363j.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.m9449a(this.f2610a, C0475k0.m8284a(m8257a.m8250d(C0363j.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            m8257a.m8265a();
        }
    }

    /* renamed from: b */
    public void m8416b(Drawable drawable) {
        this.f2612c = -1;
        m8422a((ColorStateList) null);
        m8424a();
    }

    /* renamed from: c */
    public PorterDuff.Mode m8415c() {
        TintInfo tintInfo = this.f2614e;
        if (tintInfo != null) {
            return tintInfo.f2714b;
        }
        return null;
    }

    /* renamed from: d */
    public final boolean m8414d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f2613d != null : i == 21;
    }

    /* renamed from: b */
    public void m8417b(ColorStateList colorStateList) {
        if (this.f2614e == null) {
            this.f2614e = new TintInfo();
        }
        TintInfo tintInfo = this.f2614e;
        tintInfo.f2713a = colorStateList;
        tintInfo.f2716d = true;
        m8424a();
    }

    /* renamed from: b */
    public ColorStateList m8418b() {
        TintInfo tintInfo = this.f2614e;
        if (tintInfo != null) {
            return tintInfo.f2713a;
        }
        return null;
    }

    /* renamed from: a */
    public void m8423a(int i) {
        this.f2612c = i;
        AppCompatDrawableManager appCompatDrawableManager = this.f2611b;
        m8422a(appCompatDrawableManager != null ? appCompatDrawableManager.m8293d(this.f2610a.getContext(), i) : null);
        m8424a();
    }

    /* renamed from: a */
    public void m8421a(PorterDuff.Mode mode) {
        if (this.f2614e == null) {
            this.f2614e = new TintInfo();
        }
        TintInfo tintInfo = this.f2614e;
        tintInfo.f2714b = mode;
        tintInfo.f2715c = true;
        m8424a();
    }

    /* renamed from: a */
    public void m8424a() {
        Drawable background = this.f2610a.getBackground();
        if (background != null) {
            if (m8414d() && m8420a(background)) {
                return;
            }
            TintInfo tintInfo = this.f2614e;
            if (tintInfo != null) {
                AppCompatDrawableManager.m8302a(background, tintInfo, this.f2610a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f2613d;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.m8302a(background, tintInfo2, this.f2610a.getDrawableState());
            }
        }
    }

    /* renamed from: a */
    public void m8422a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2613d == null) {
                this.f2613d = new TintInfo();
            }
            TintInfo tintInfo = this.f2613d;
            tintInfo.f2713a = colorStateList;
            tintInfo.f2716d = true;
        } else {
            this.f2613d = null;
        }
        m8424a();
    }

    /* renamed from: a */
    public final boolean m8420a(Drawable drawable) {
        if (this.f2615f == null) {
            this.f2615f = new TintInfo();
        }
        TintInfo tintInfo = this.f2615f;
        tintInfo.m8319a();
        ColorStateList m9436c = ViewCompat.m9436c(this.f2610a);
        if (m9436c != null) {
            tintInfo.f2716d = true;
            tintInfo.f2713a = m9436c;
        }
        PorterDuff.Mode m9434d = ViewCompat.m9434d(this.f2610a);
        if (m9434d != null) {
            tintInfo.f2715c = true;
            tintInfo.f2714b = m9434d;
        }
        if (tintInfo.f2716d || tintInfo.f2715c) {
            AppCompatDrawableManager.m8302a(drawable, tintInfo, this.f2610a.getDrawableState());
            return true;
        }
        return false;
    }
}
