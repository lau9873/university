package a.b.h.k;

import a.b.g.b.g.f;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;
/* compiled from: AppCompatTextHelper.java */
/* loaded from: classes.dex */
public class y {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f1996a;

    /* renamed from: b  reason: collision with root package name */
    public j1 f1997b;

    /* renamed from: c  reason: collision with root package name */
    public j1 f1998c;

    /* renamed from: d  reason: collision with root package name */
    public j1 f1999d;

    /* renamed from: e  reason: collision with root package name */
    public j1 f2000e;

    /* renamed from: f  reason: collision with root package name */
    public j1 f2001f;

    /* renamed from: g  reason: collision with root package name */
    public j1 f2002g;

    /* renamed from: h  reason: collision with root package name */
    public final a0 f2003h;

    /* renamed from: i  reason: collision with root package name */
    public int f2004i = 0;
    public Typeface j;
    public boolean k;

    /* compiled from: AppCompatTextHelper.java */
    /* loaded from: classes.dex */
    public class a extends f.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ WeakReference f2005a;

        public a(WeakReference weakReference) {
            this.f2005a = weakReference;
        }

        @Override // a.b.g.b.g.f.a
        public void a(int i2) {
        }

        @Override // a.b.g.b.g.f.a
        public void a(Typeface typeface) {
            y.this.a(this.f2005a, typeface);
        }
    }

    public y(TextView textView) {
        this.f1996a = textView;
        this.f2003h = new a0(this.f1996a);
    }

    @SuppressLint({"NewApi"})
    public void a(AttributeSet attributeSet, int i2) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        boolean z;
        boolean z2;
        Context context = this.f1996a.getContext();
        k a2 = k.a();
        l1 a3 = l1.a(context, attributeSet, a.b.h.b.j.AppCompatTextHelper, i2, 0);
        int g2 = a3.g(a.b.h.b.j.AppCompatTextHelper_android_textAppearance, -1);
        if (a3.g(a.b.h.b.j.AppCompatTextHelper_android_drawableLeft)) {
            this.f1997b = a(context, a2, a3.g(a.b.h.b.j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (a3.g(a.b.h.b.j.AppCompatTextHelper_android_drawableTop)) {
            this.f1998c = a(context, a2, a3.g(a.b.h.b.j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (a3.g(a.b.h.b.j.AppCompatTextHelper_android_drawableRight)) {
            this.f1999d = a(context, a2, a3.g(a.b.h.b.j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (a3.g(a.b.h.b.j.AppCompatTextHelper_android_drawableBottom)) {
            this.f2000e = a(context, a2, a3.g(a.b.h.b.j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (a3.g(a.b.h.b.j.AppCompatTextHelper_android_drawableStart)) {
                this.f2001f = a(context, a2, a3.g(a.b.h.b.j.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (a3.g(a.b.h.b.j.AppCompatTextHelper_android_drawableEnd)) {
                this.f2002g = a(context, a2, a3.g(a.b.h.b.j.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        a3.a();
        boolean z3 = this.f1996a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z4 = true;
        if (g2 != -1) {
            l1 a4 = l1.a(context, g2, a.b.h.b.j.TextAppearance);
            if (z3 || !a4.g(a.b.h.b.j.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = a4.a(a.b.h.b.j.TextAppearance_textAllCaps, false);
                z = true;
            }
            a(context, a4);
            if (Build.VERSION.SDK_INT < 23) {
                ColorStateList a5 = a4.g(a.b.h.b.j.TextAppearance_android_textColor) ? a4.a(a.b.h.b.j.TextAppearance_android_textColor) : null;
                colorStateList2 = a4.g(a.b.h.b.j.TextAppearance_android_textColorHint) ? a4.a(a.b.h.b.j.TextAppearance_android_textColorHint) : null;
                ColorStateList colorStateList3 = a5;
                colorStateList = a4.g(a.b.h.b.j.TextAppearance_android_textColorLink) ? a4.a(a.b.h.b.j.TextAppearance_android_textColorLink) : null;
                r10 = colorStateList3;
            } else {
                colorStateList = null;
                colorStateList2 = null;
            }
            a4.a();
        } else {
            colorStateList = null;
            colorStateList2 = null;
            z = false;
            z2 = false;
        }
        l1 a6 = l1.a(context, attributeSet, a.b.h.b.j.TextAppearance, i2, 0);
        if (z3 || !a6.g(a.b.h.b.j.TextAppearance_textAllCaps)) {
            z4 = z;
        } else {
            z2 = a6.a(a.b.h.b.j.TextAppearance_textAllCaps, false);
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (a6.g(a.b.h.b.j.TextAppearance_android_textColor)) {
                r10 = a6.a(a.b.h.b.j.TextAppearance_android_textColor);
            }
            if (a6.g(a.b.h.b.j.TextAppearance_android_textColorHint)) {
                colorStateList2 = a6.a(a.b.h.b.j.TextAppearance_android_textColorHint);
            }
            if (a6.g(a.b.h.b.j.TextAppearance_android_textColorLink)) {
                colorStateList = a6.a(a.b.h.b.j.TextAppearance_android_textColorLink);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && a6.g(a.b.h.b.j.TextAppearance_android_textSize) && a6.c(a.b.h.b.j.TextAppearance_android_textSize, -1) == 0) {
            this.f1996a.setTextSize(0, 0.0f);
        }
        a(context, a6);
        a6.a();
        if (r10 != null) {
            this.f1996a.setTextColor(r10);
        }
        if (colorStateList2 != null) {
            this.f1996a.setHintTextColor(colorStateList2);
        }
        if (colorStateList != null) {
            this.f1996a.setLinkTextColor(colorStateList);
        }
        if (!z3 && z4) {
            a(z2);
        }
        Typeface typeface = this.j;
        if (typeface != null) {
            this.f1996a.setTypeface(typeface, this.f2004i);
        }
        this.f2003h.a(attributeSet, i2);
        if (a.b.g.l.b.l && this.f2003h.g() != 0) {
            int[] f2 = this.f2003h.f();
            if (f2.length > 0) {
                if (this.f1996a.getAutoSizeStepGranularity() != -1.0f) {
                    this.f1996a.setAutoSizeTextTypeUniformWithConfiguration(this.f2003h.d(), this.f2003h.c(), this.f2003h.e(), 0);
                } else {
                    this.f1996a.setAutoSizeTextTypeUniformWithPresetSizes(f2, 0);
                }
            }
        }
        l1 a7 = l1.a(context, attributeSet, a.b.h.b.j.AppCompatTextView);
        int c2 = a7.c(a.b.h.b.j.AppCompatTextView_firstBaselineToTopHeight, -1);
        int c3 = a7.c(a.b.h.b.j.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int c4 = a7.c(a.b.h.b.j.AppCompatTextView_lineHeight, -1);
        a7.a();
        if (c2 != -1) {
            a.b.g.l.p.a(this.f1996a, c2);
        }
        if (c3 != -1) {
            a.b.g.l.p.b(this.f1996a, c3);
        }
        if (c4 != -1) {
            a.b.g.l.p.c(this.f1996a, c4);
        }
    }

    public void b() {
        this.f2003h.a();
    }

    public int c() {
        return this.f2003h.c();
    }

    public int d() {
        return this.f2003h.d();
    }

    public int e() {
        return this.f2003h.e();
    }

    public int[] f() {
        return this.f2003h.f();
    }

    public int g() {
        return this.f2003h.g();
    }

    public boolean h() {
        return this.f2003h.h();
    }

    public final void b(int i2, float f2) {
        this.f2003h.a(i2, f2);
    }

    public final void a(Context context, l1 l1Var) {
        String d2;
        this.f2004i = l1Var.d(a.b.h.b.j.TextAppearance_android_textStyle, this.f2004i);
        if (!l1Var.g(a.b.h.b.j.TextAppearance_android_fontFamily) && !l1Var.g(a.b.h.b.j.TextAppearance_fontFamily)) {
            if (l1Var.g(a.b.h.b.j.TextAppearance_android_typeface)) {
                this.k = false;
                int d3 = l1Var.d(a.b.h.b.j.TextAppearance_android_typeface, 1);
                if (d3 == 1) {
                    this.j = Typeface.SANS_SERIF;
                    return;
                } else if (d3 == 2) {
                    this.j = Typeface.SERIF;
                    return;
                } else if (d3 != 3) {
                    return;
                } else {
                    this.j = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.j = null;
        int i2 = l1Var.g(a.b.h.b.j.TextAppearance_fontFamily) ? a.b.h.b.j.TextAppearance_fontFamily : a.b.h.b.j.TextAppearance_android_fontFamily;
        if (!context.isRestricted()) {
            try {
                this.j = l1Var.a(i2, this.f2004i, new a(new WeakReference(this.f1996a)));
                this.k = this.j == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.j != null || (d2 = l1Var.d(i2)) == null) {
            return;
        }
        this.j = Typeface.create(d2, this.f2004i);
    }

    public void a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.k) {
            this.j = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f2004i);
            }
        }
    }

    public void a(Context context, int i2) {
        ColorStateList a2;
        l1 a3 = l1.a(context, i2, a.b.h.b.j.TextAppearance);
        if (a3.g(a.b.h.b.j.TextAppearance_textAllCaps)) {
            a(a3.a(a.b.h.b.j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a3.g(a.b.h.b.j.TextAppearance_android_textColor) && (a2 = a3.a(a.b.h.b.j.TextAppearance_android_textColor)) != null) {
            this.f1996a.setTextColor(a2);
        }
        if (a3.g(a.b.h.b.j.TextAppearance_android_textSize) && a3.c(a.b.h.b.j.TextAppearance_android_textSize, -1) == 0) {
            this.f1996a.setTextSize(0, 0.0f);
        }
        a(context, a3);
        a3.a();
        Typeface typeface = this.j;
        if (typeface != null) {
            this.f1996a.setTypeface(typeface, this.f2004i);
        }
    }

    public void a(boolean z) {
        this.f1996a.setAllCaps(z);
    }

    public void a() {
        if (this.f1997b != null || this.f1998c != null || this.f1999d != null || this.f2000e != null) {
            Drawable[] compoundDrawables = this.f1996a.getCompoundDrawables();
            a(compoundDrawables[0], this.f1997b);
            a(compoundDrawables[1], this.f1998c);
            a(compoundDrawables[2], this.f1999d);
            a(compoundDrawables[3], this.f2000e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f2001f == null && this.f2002g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.f1996a.getCompoundDrawablesRelative();
            a(compoundDrawablesRelative[0], this.f2001f);
            a(compoundDrawablesRelative[2], this.f2002g);
        }
    }

    public final void a(Drawable drawable, j1 j1Var) {
        if (drawable == null || j1Var == null) {
            return;
        }
        k.a(drawable, j1Var, this.f1996a.getDrawableState());
    }

    public static j1 a(Context context, k kVar, int i2) {
        ColorStateList d2 = kVar.d(context, i2);
        if (d2 != null) {
            j1 j1Var = new j1();
            j1Var.f1795d = true;
            j1Var.f1792a = d2;
            return j1Var;
        }
        return null;
    }

    public void a(boolean z, int i2, int i3, int i4, int i5) {
        if (a.b.g.l.b.l) {
            return;
        }
        b();
    }

    public void a(int i2, float f2) {
        if (a.b.g.l.b.l || h()) {
            return;
        }
        b(i2, f2);
    }

    public void a(int i2) {
        this.f2003h.a(i2);
    }

    public void a(int i2, int i3, int i4, int i5) {
        this.f2003h.a(i2, i3, i4, i5);
    }

    public void a(int[] iArr, int i2) {
        this.f2003h.a(iArr, i2);
    }
}
