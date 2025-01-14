package p000a.p006b.p049h.p063k;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import p000a.p006b.p030g.p048l.ImageViewCompat;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;

/* renamed from: a.b.h.k.o */
/* loaded from: classes.dex */
public class AppCompatImageHelper {

    /* renamed from: a */
    public final ImageView f2816a;

    /* renamed from: b */
    public TintInfo f2817b;

    /* renamed from: c */
    public TintInfo f2818c;

    /* renamed from: d */
    public TintInfo f2819d;

    public AppCompatImageHelper(ImageView imageView) {
        this.f2816a = imageView;
    }

    /* renamed from: a */
    public void m8175a(AttributeSet attributeSet, int i) {
        int m8244g;
        TintTypedArray m8257a = TintTypedArray.m8257a(this.f2816a.getContext(), attributeSet, C0363j.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f2816a.getDrawable();
            if (drawable == null && (m8244g = m8257a.m8244g(C0363j.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = AppCompatResources.m8967c(this.f2816a.getContext(), m8244g)) != null) {
                this.f2816a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                C0475k0.m8282b(drawable);
            }
            if (m8257a.m8245g(C0363j.AppCompatImageView_tint)) {
                ImageViewCompat.m9230a(this.f2816a, m8257a.m8264a(C0363j.AppCompatImageView_tint));
            }
            if (m8257a.m8245g(C0363j.AppCompatImageView_tintMode)) {
                ImageViewCompat.m9229a(this.f2816a, C0475k0.m8284a(m8257a.m8250d(C0363j.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            m8257a.m8265a();
        }
    }

    /* renamed from: b */
    public ColorStateList m8174b() {
        TintInfo tintInfo = this.f2818c;
        if (tintInfo != null) {
            return tintInfo.f2713a;
        }
        return null;
    }

    /* renamed from: c */
    public PorterDuff.Mode m8173c() {
        TintInfo tintInfo = this.f2818c;
        if (tintInfo != null) {
            return tintInfo.f2714b;
        }
        return null;
    }

    /* renamed from: d */
    public boolean m8172d() {
        return Build.VERSION.SDK_INT < 21 || !(this.f2816a.getBackground() instanceof RippleDrawable);
    }

    /* renamed from: e */
    public final boolean m8171e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f2817b != null : i == 21;
    }

    /* renamed from: a */
    public void m8179a(int i) {
        if (i != 0) {
            Drawable m8967c = AppCompatResources.m8967c(this.f2816a.getContext(), i);
            if (m8967c != null) {
                C0475k0.m8282b(m8967c);
            }
            this.f2816a.setImageDrawable(m8967c);
        } else {
            this.f2816a.setImageDrawable(null);
        }
        m8180a();
    }

    /* renamed from: a */
    public void m8178a(ColorStateList colorStateList) {
        if (this.f2818c == null) {
            this.f2818c = new TintInfo();
        }
        TintInfo tintInfo = this.f2818c;
        tintInfo.f2713a = colorStateList;
        tintInfo.f2716d = true;
        m8180a();
    }

    /* renamed from: a */
    public void m8177a(PorterDuff.Mode mode) {
        if (this.f2818c == null) {
            this.f2818c = new TintInfo();
        }
        TintInfo tintInfo = this.f2818c;
        tintInfo.f2714b = mode;
        tintInfo.f2715c = true;
        m8180a();
    }

    /* renamed from: a */
    public void m8180a() {
        Drawable drawable = this.f2816a.getDrawable();
        if (drawable != null) {
            C0475k0.m8282b(drawable);
        }
        if (drawable != null) {
            if (m8171e() && m8176a(drawable)) {
                return;
            }
            TintInfo tintInfo = this.f2818c;
            if (tintInfo != null) {
                AppCompatDrawableManager.m8302a(drawable, tintInfo, this.f2816a.getDrawableState());
                return;
            }
            TintInfo tintInfo2 = this.f2817b;
            if (tintInfo2 != null) {
                AppCompatDrawableManager.m8302a(drawable, tintInfo2, this.f2816a.getDrawableState());
            }
        }
    }

    /* renamed from: a */
    public final boolean m8176a(Drawable drawable) {
        if (this.f2819d == null) {
            this.f2819d = new TintInfo();
        }
        TintInfo tintInfo = this.f2819d;
        tintInfo.m8319a();
        ColorStateList m9231a = ImageViewCompat.m9231a(this.f2816a);
        if (m9231a != null) {
            tintInfo.f2716d = true;
            tintInfo.f2713a = m9231a;
        }
        PorterDuff.Mode m9228b = ImageViewCompat.m9228b(this.f2816a);
        if (m9228b != null) {
            tintInfo.f2715c = true;
            tintInfo.f2714b = m9228b;
        }
        if (tintInfo.f2716d || tintInfo.f2715c) {
            AppCompatDrawableManager.m8302a(drawable, tintInfo, this.f2816a.getDrawableState());
            return true;
        }
        return false;
    }
}
