package a.b.h.k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
/* compiled from: AppCompatImageView.java */
/* loaded from: classes.dex */
public class p extends ImageView implements a.b.g.k.t, a.b.g.l.r {

    /* renamed from: a  reason: collision with root package name */
    public final f f1880a;

    /* renamed from: b  reason: collision with root package name */
    public final o f1881b;

    public p(Context context) {
        this(context, null);
    }

    @Override // android.widget.ImageView, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        f fVar = this.f1880a;
        if (fVar != null) {
            fVar.a();
        }
        o oVar = this.f1881b;
        if (oVar != null) {
            oVar.a();
        }
    }

    @Override // a.b.g.k.t
    public ColorStateList getSupportBackgroundTintList() {
        f fVar = this.f1880a;
        if (fVar != null) {
            return fVar.b();
        }
        return null;
    }

    @Override // a.b.g.k.t
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        f fVar = this.f1880a;
        if (fVar != null) {
            return fVar.c();
        }
        return null;
    }

    @Override // a.b.g.l.r
    public ColorStateList getSupportImageTintList() {
        o oVar = this.f1881b;
        if (oVar != null) {
            return oVar.b();
        }
        return null;
    }

    @Override // a.b.g.l.r
    public PorterDuff.Mode getSupportImageTintMode() {
        o oVar = this.f1881b;
        if (oVar != null) {
            return oVar.c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f1881b.d() && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        f fVar = this.f1880a;
        if (fVar != null) {
            fVar.b(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i2) {
        super.setBackgroundResource(i2);
        f fVar = this.f1880a;
        if (fVar != null) {
            fVar.a(i2);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        o oVar = this.f1881b;
        if (oVar != null) {
            oVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        o oVar = this.f1881b;
        if (oVar != null) {
            oVar.a();
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        o oVar = this.f1881b;
        if (oVar != null) {
            oVar.a(i2);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        o oVar = this.f1881b;
        if (oVar != null) {
            oVar.a();
        }
    }

    @Override // a.b.g.k.t
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        f fVar = this.f1880a;
        if (fVar != null) {
            fVar.b(colorStateList);
        }
    }

    @Override // a.b.g.k.t
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        f fVar = this.f1880a;
        if (fVar != null) {
            fVar.a(mode);
        }
    }

    @Override // a.b.g.l.r
    public void setSupportImageTintList(ColorStateList colorStateList) {
        o oVar = this.f1881b;
        if (oVar != null) {
            oVar.a(colorStateList);
        }
    }

    @Override // a.b.g.l.r
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        o oVar = this.f1881b;
        if (oVar != null) {
            oVar.a(mode);
        }
    }

    public p(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public p(Context context, AttributeSet attributeSet, int i2) {
        super(i1.b(context), attributeSet, i2);
        this.f1880a = new f(this);
        this.f1880a.a(attributeSet, i2);
        this.f1881b = new o(this);
        this.f1881b.a(attributeSet, i2);
    }
}
