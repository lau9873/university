package p000a.p006b.p049h.p063k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import p000a.p006b.p030g.p045k.TintableBackgroundView;
import p000a.p006b.p030g.p048l.TintableImageSourceView;

/* renamed from: a.b.h.k.p */
/* loaded from: classes.dex */
public class AppCompatImageView extends ImageView implements TintableBackgroundView, TintableImageSourceView {

    /* renamed from: a */
    public final AppCompatBackgroundHelper f2844a;

    /* renamed from: b */
    public final AppCompatImageHelper f2845b;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2844a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8424a();
        }
        AppCompatImageHelper appCompatImageHelper = this.f2845b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.m8180a();
        }
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2844a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.m8418b();
        }
        return null;
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2844a;
        if (appCompatBackgroundHelper != null) {
            return appCompatBackgroundHelper.m8415c();
        }
        return null;
    }

    @Override // p000a.p006b.p030g.p048l.TintableImageSourceView
    public ColorStateList getSupportImageTintList() {
        AppCompatImageHelper appCompatImageHelper = this.f2845b;
        if (appCompatImageHelper != null) {
            return appCompatImageHelper.m8174b();
        }
        return null;
    }

    @Override // p000a.p006b.p030g.p048l.TintableImageSourceView
    public PorterDuff.Mode getSupportImageTintMode() {
        AppCompatImageHelper appCompatImageHelper = this.f2845b;
        if (appCompatImageHelper != null) {
            return appCompatImageHelper.m8173c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f2845b.m8172d() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2844a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8416b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2844a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8423a(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        AppCompatImageHelper appCompatImageHelper = this.f2845b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.m8180a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        AppCompatImageHelper appCompatImageHelper = this.f2845b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.m8180a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        AppCompatImageHelper appCompatImageHelper = this.f2845b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.m8179a(i);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        AppCompatImageHelper appCompatImageHelper = this.f2845b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.m8180a();
        }
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2844a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8417b(colorStateList);
        }
    }

    @Override // p000a.p006b.p030g.p045k.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        AppCompatBackgroundHelper appCompatBackgroundHelper = this.f2844a;
        if (appCompatBackgroundHelper != null) {
            appCompatBackgroundHelper.m8421a(mode);
        }
    }

    @Override // p000a.p006b.p030g.p048l.TintableImageSourceView
    public void setSupportImageTintList(ColorStateList colorStateList) {
        AppCompatImageHelper appCompatImageHelper = this.f2845b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.m8178a(colorStateList);
        }
    }

    @Override // p000a.p006b.p030g.p048l.TintableImageSourceView
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        AppCompatImageHelper appCompatImageHelper = this.f2845b;
        if (appCompatImageHelper != null) {
            appCompatImageHelper.m8177a(mode);
        }
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(TintContextWrapper.m8342b(context), attributeSet, i);
        this.f2844a = new AppCompatBackgroundHelper(this);
        this.f2844a.m8419a(attributeSet, i);
        this.f2845b = new AppCompatImageHelper(this);
        this.f2845b.m8175a(attributeSet, i);
    }
}
