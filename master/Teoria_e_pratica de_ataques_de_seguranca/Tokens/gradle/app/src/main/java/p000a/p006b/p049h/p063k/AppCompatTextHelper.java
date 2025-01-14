package p000a.p006b.p049h.p063k;

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
import p000a.p006b.p030g.p032b.p033g.ResourcesCompat;
import p000a.p006b.p030g.p048l.AutoSizeableTextView;
import p000a.p006b.p030g.p048l.TextViewCompat;
import p000a.p006b.p049h.p051b.C0363j;

/* renamed from: a.b.h.k.y */
/* loaded from: classes.dex */
public class AppCompatTextHelper {

    /* renamed from: a */
    public final TextView f3003a;

    /* renamed from: b */
    public TintInfo f3004b;

    /* renamed from: c */
    public TintInfo f3005c;

    /* renamed from: d */
    public TintInfo f3006d;

    /* renamed from: e */
    public TintInfo f3007e;

    /* renamed from: f */
    public TintInfo f3008f;

    /* renamed from: g */
    public TintInfo f3009g;

    /* renamed from: h */
    public final AppCompatTextViewAutoSizeHelper f3010h;

    /* renamed from: i */
    public int f3011i = 0;

    /* renamed from: j */
    public Typeface f3012j;

    /* renamed from: k */
    public boolean f3013k;

    /* compiled from: AppCompatTextHelper.java */
    /* renamed from: a.b.h.k.y$a */
    /* loaded from: classes.dex */
    public class C0516a extends ResourcesCompat.AbstractC0210a {

        /* renamed from: a */
        public final /* synthetic */ WeakReference f3014a;

        public C0516a(WeakReference weakReference) {
            this.f3014a = weakReference;
        }

        @Override // p000a.p006b.p030g.p032b.p033g.ResourcesCompat.AbstractC0210a
        /* renamed from: a */
        public void mo7972a(int i) {
        }

        @Override // p000a.p006b.p030g.p032b.p033g.ResourcesCompat.AbstractC0210a
        /* renamed from: a */
        public void mo7971a(Typeface typeface) {
            AppCompatTextHelper.this.m7984a(this.f3014a, typeface);
        }
    }

    public AppCompatTextHelper(TextView textView) {
        this.f3003a = textView;
        this.f3010h = new AppCompatTextViewAutoSizeHelper(this.f3003a);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m7985a(AttributeSet attributeSet, int i) {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        boolean z;
        boolean z2;
        Context context = this.f3003a.getContext();
        AppCompatDrawableManager m8318a = AppCompatDrawableManager.m8318a();
        TintTypedArray m8257a = TintTypedArray.m8257a(context, attributeSet, C0363j.AppCompatTextHelper, i, 0);
        int m8244g = m8257a.m8244g(C0363j.AppCompatTextHelper_android_textAppearance, -1);
        if (m8257a.m8245g(C0363j.AppCompatTextHelper_android_drawableLeft)) {
            this.f3004b = m7988a(context, m8318a, m8257a.m8244g(C0363j.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (m8257a.m8245g(C0363j.AppCompatTextHelper_android_drawableTop)) {
            this.f3005c = m7988a(context, m8318a, m8257a.m8244g(C0363j.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (m8257a.m8245g(C0363j.AppCompatTextHelper_android_drawableRight)) {
            this.f3006d = m7988a(context, m8318a, m8257a.m8244g(C0363j.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (m8257a.m8245g(C0363j.AppCompatTextHelper_android_drawableBottom)) {
            this.f3007e = m7988a(context, m8318a, m8257a.m8244g(C0363j.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (m8257a.m8245g(C0363j.AppCompatTextHelper_android_drawableStart)) {
                this.f3008f = m7988a(context, m8318a, m8257a.m8244g(C0363j.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (m8257a.m8245g(C0363j.AppCompatTextHelper_android_drawableEnd)) {
                this.f3009g = m7988a(context, m8318a, m8257a.m8244g(C0363j.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        m8257a.m8265a();
        boolean z3 = this.f3003a.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean z4 = true;
        if (m8244g != -1) {
            TintTypedArray m8259a = TintTypedArray.m8259a(context, m8244g, C0363j.TextAppearance);
            if (z3 || !m8259a.m8245g(C0363j.TextAppearance_textAllCaps)) {
                z = false;
                z2 = false;
            } else {
                z2 = m8259a.m8260a(C0363j.TextAppearance_textAllCaps, false);
                z = true;
            }
            m7987a(context, m8259a);
            if (Build.VERSION.SDK_INT < 23) {
                ColorStateList m8264a = m8259a.m8245g(C0363j.TextAppearance_android_textColor) ? m8259a.m8264a(C0363j.TextAppearance_android_textColor) : null;
                colorStateList2 = m8259a.m8245g(C0363j.TextAppearance_android_textColorHint) ? m8259a.m8264a(C0363j.TextAppearance_android_textColorHint) : null;
                ColorStateList colorStateList3 = m8264a;
                colorStateList = m8259a.m8245g(C0363j.TextAppearance_android_textColorLink) ? m8259a.m8264a(C0363j.TextAppearance_android_textColorLink) : null;
                r10 = colorStateList3;
            } else {
                colorStateList = null;
                colorStateList2 = null;
            }
            m8259a.m8265a();
        } else {
            colorStateList = null;
            colorStateList2 = null;
            z = false;
            z2 = false;
        }
        TintTypedArray m8257a2 = TintTypedArray.m8257a(context, attributeSet, C0363j.TextAppearance, i, 0);
        if (z3 || !m8257a2.m8245g(C0363j.TextAppearance_textAllCaps)) {
            z4 = z;
        } else {
            z2 = m8257a2.m8260a(C0363j.TextAppearance_textAllCaps, false);
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (m8257a2.m8245g(C0363j.TextAppearance_android_textColor)) {
                r10 = m8257a2.m8264a(C0363j.TextAppearance_android_textColor);
            }
            if (m8257a2.m8245g(C0363j.TextAppearance_android_textColorHint)) {
                colorStateList2 = m8257a2.m8264a(C0363j.TextAppearance_android_textColorHint);
            }
            if (m8257a2.m8245g(C0363j.TextAppearance_android_textColorLink)) {
                colorStateList = m8257a2.m8264a(C0363j.TextAppearance_android_textColorLink);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && m8257a2.m8245g(C0363j.TextAppearance_android_textSize) && m8257a2.m8252c(C0363j.TextAppearance_android_textSize, -1) == 0) {
            this.f3003a.setTextSize(0, 0.0f);
        }
        m7987a(context, m8257a2);
        m8257a2.m8265a();
        if (r10 != null) {
            this.f3003a.setTextColor(r10);
        }
        if (colorStateList2 != null) {
            this.f3003a.setHintTextColor(colorStateList2);
        }
        if (colorStateList != null) {
            this.f3003a.setLinkTextColor(colorStateList);
        }
        if (!z3 && z4) {
            m7983a(z2);
        }
        Typeface typeface = this.f3012j;
        if (typeface != null) {
            this.f3003a.setTypeface(typeface, this.f3011i);
        }
        this.f3010h.m8552a(attributeSet, i);
        if (AutoSizeableTextView.f1775l && this.f3010h.m8540g() != 0) {
            int[] m8541f = this.f3010h.m8541f();
            if (m8541f.length > 0) {
                if (this.f3003a.getAutoSizeStepGranularity() != -1.0f) {
                    this.f3003a.setAutoSizeTextTypeUniformWithConfiguration(this.f3010h.m8543d(), this.f3010h.m8544c(), this.f3010h.m8542e(), 0);
                } else {
                    this.f3003a.setAutoSizeTextTypeUniformWithPresetSizes(m8541f, 0);
                }
            }
        }
        TintTypedArray m8258a = TintTypedArray.m8258a(context, attributeSet, C0363j.AppCompatTextView);
        int m8252c = m8258a.m8252c(C0363j.AppCompatTextView_firstBaselineToTopHeight, -1);
        int m8252c2 = m8258a.m8252c(C0363j.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int m8252c3 = m8258a.m8252c(C0363j.AppCompatTextView_lineHeight, -1);
        m8258a.m8265a();
        if (m8252c != -1) {
            TextViewCompat.m9215a(this.f3003a, m8252c);
        }
        if (m8252c2 != -1) {
            TextViewCompat.m9209b(this.f3003a, m8252c2);
        }
        if (m8252c3 != -1) {
            TextViewCompat.m9207c(this.f3003a, m8252c3);
        }
    }

    /* renamed from: b */
    public void m7980b() {
        this.f3010h.m8561a();
    }

    /* renamed from: c */
    public int m7978c() {
        return this.f3010h.m8544c();
    }

    /* renamed from: d */
    public int m7977d() {
        return this.f3010h.m8543d();
    }

    /* renamed from: e */
    public int m7976e() {
        return this.f3010h.m8542e();
    }

    /* renamed from: f */
    public int[] m7975f() {
        return this.f3010h.m8541f();
    }

    /* renamed from: g */
    public int m7974g() {
        return this.f3010h.m8540g();
    }

    /* renamed from: h */
    public boolean m7973h() {
        return this.f3010h.m8539h();
    }

    /* renamed from: b */
    public final void m7979b(int i, float f) {
        this.f3010h.m8557a(i, f);
    }

    /* renamed from: a */
    public final void m7987a(Context context, TintTypedArray tintTypedArray) {
        String m8251d;
        this.f3011i = tintTypedArray.m8250d(C0363j.TextAppearance_android_textStyle, this.f3011i);
        if (!tintTypedArray.m8245g(C0363j.TextAppearance_android_fontFamily) && !tintTypedArray.m8245g(C0363j.TextAppearance_fontFamily)) {
            if (tintTypedArray.m8245g(C0363j.TextAppearance_android_typeface)) {
                this.f3013k = false;
                int m8250d = tintTypedArray.m8250d(C0363j.TextAppearance_android_typeface, 1);
                if (m8250d == 1) {
                    this.f3012j = Typeface.SANS_SERIF;
                    return;
                } else if (m8250d == 2) {
                    this.f3012j = Typeface.SERIF;
                    return;
                } else if (m8250d != 3) {
                    return;
                } else {
                    this.f3012j = Typeface.MONOSPACE;
                    return;
                }
            }
            return;
        }
        this.f3012j = null;
        int i = tintTypedArray.m8245g(C0363j.TextAppearance_fontFamily) ? C0363j.TextAppearance_fontFamily : C0363j.TextAppearance_android_fontFamily;
        if (!context.isRestricted()) {
            try {
                this.f3012j = tintTypedArray.m8261a(i, this.f3011i, new C0516a(new WeakReference(this.f3003a)));
                this.f3013k = this.f3012j == null;
            } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
            }
        }
        if (this.f3012j != null || (m8251d = tintTypedArray.m8251d(i)) == null) {
            return;
        }
        this.f3012j = Typeface.create(m8251d, this.f3011i);
    }

    /* renamed from: a */
    public void m7984a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f3013k) {
            this.f3012j = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f3011i);
            }
        }
    }

    /* renamed from: a */
    public void m7989a(Context context, int i) {
        ColorStateList m8264a;
        TintTypedArray m8259a = TintTypedArray.m8259a(context, i, C0363j.TextAppearance);
        if (m8259a.m8245g(C0363j.TextAppearance_textAllCaps)) {
            m7983a(m8259a.m8260a(C0363j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && m8259a.m8245g(C0363j.TextAppearance_android_textColor) && (m8264a = m8259a.m8264a(C0363j.TextAppearance_android_textColor)) != null) {
            this.f3003a.setTextColor(m8264a);
        }
        if (m8259a.m8245g(C0363j.TextAppearance_android_textSize) && m8259a.m8252c(C0363j.TextAppearance_android_textSize, -1) == 0) {
            this.f3003a.setTextSize(0, 0.0f);
        }
        m7987a(context, m8259a);
        m8259a.m8265a();
        Typeface typeface = this.f3012j;
        if (typeface != null) {
            this.f3003a.setTypeface(typeface, this.f3011i);
        }
    }

    /* renamed from: a */
    public void m7983a(boolean z) {
        this.f3003a.setAllCaps(z);
    }

    /* renamed from: a */
    public void m7993a() {
        if (this.f3004b != null || this.f3005c != null || this.f3006d != null || this.f3007e != null) {
            Drawable[] compoundDrawables = this.f3003a.getCompoundDrawables();
            m7986a(compoundDrawables[0], this.f3004b);
            m7986a(compoundDrawables[1], this.f3005c);
            m7986a(compoundDrawables[2], this.f3006d);
            m7986a(compoundDrawables[3], this.f3007e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f3008f == null && this.f3009g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.f3003a.getCompoundDrawablesRelative();
            m7986a(compoundDrawablesRelative[0], this.f3008f);
            m7986a(compoundDrawablesRelative[2], this.f3009g);
        }
    }

    /* renamed from: a */
    public final void m7986a(Drawable drawable, TintInfo tintInfo) {
        if (drawable == null || tintInfo == null) {
            return;
        }
        AppCompatDrawableManager.m8302a(drawable, tintInfo, this.f3003a.getDrawableState());
    }

    /* renamed from: a */
    public static TintInfo m7988a(Context context, AppCompatDrawableManager appCompatDrawableManager, int i) {
        ColorStateList m8293d = appCompatDrawableManager.m8293d(context, i);
        if (m8293d != null) {
            TintInfo tintInfo = new TintInfo();
            tintInfo.f2716d = true;
            tintInfo.f2713a = m8293d;
            return tintInfo;
        }
        return null;
    }

    /* renamed from: a */
    public void m7982a(boolean z, int i, int i2, int i3, int i4) {
        if (AutoSizeableTextView.f1775l) {
            return;
        }
        m7980b();
    }

    /* renamed from: a */
    public void m7991a(int i, float f) {
        if (AutoSizeableTextView.f1775l || m7973h()) {
            return;
        }
        m7979b(i, f);
    }

    /* renamed from: a */
    public void m7992a(int i) {
        this.f3010h.m8558a(i);
    }

    /* renamed from: a */
    public void m7990a(int i, int i2, int i3, int i4) {
        this.f3010h.m8556a(i, i2, i3, i4);
    }

    /* renamed from: a */
    public void m7981a(int[] iArr, int i) {
        this.f3010h.m8546a(iArr, i);
    }
}
