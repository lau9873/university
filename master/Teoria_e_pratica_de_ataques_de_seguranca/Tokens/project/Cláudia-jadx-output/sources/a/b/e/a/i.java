package a.b.e.a;

import a.b.g.c.b;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: VectorDrawableCompat.java */
/* loaded from: classes.dex */
public class i extends a.b.e.a.h {
    public static final PorterDuff.Mode j = PorterDuff.Mode.SRC_IN;

    /* renamed from: b  reason: collision with root package name */
    public h f434b;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuffColorFilter f435c;

    /* renamed from: d  reason: collision with root package name */
    public ColorFilter f436d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f437e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f438f;

    /* renamed from: g  reason: collision with root package name */
    public final float[] f439g;

    /* renamed from: h  reason: collision with root package name */
    public final Matrix f440h;

    /* renamed from: i  reason: collision with root package name */
    public final Rect f441i;

    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class b extends f {
        public b() {
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (a.b.g.b.g.g.a(xmlPullParser, "pathData")) {
                TypedArray a2 = a.b.g.b.g.g.a(resources, theme, attributeSet, a.b.e.a.a.f412d);
                a(a2);
                a2.recycle();
            }
        }

        @Override // a.b.e.a.i.f
        public boolean b() {
            return true;
        }

        public b(b bVar) {
            super(bVar);
        }

        public final void a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f458b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f457a = a.b.g.c.b.a(string2);
            }
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class e {
        public e() {
        }

        public boolean a() {
            return false;
        }

        public boolean a(int[] iArr) {
            return false;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class h extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public int f469a;

        /* renamed from: b  reason: collision with root package name */
        public g f470b;

        /* renamed from: c  reason: collision with root package name */
        public ColorStateList f471c;

        /* renamed from: d  reason: collision with root package name */
        public PorterDuff.Mode f472d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f473e;

        /* renamed from: f  reason: collision with root package name */
        public Bitmap f474f;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f475g;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f476h;

        /* renamed from: i  reason: collision with root package name */
        public int f477i;
        public boolean j;
        public boolean k;
        public Paint l;

        public h(h hVar) {
            this.f471c = null;
            this.f472d = i.j;
            if (hVar != null) {
                this.f469a = hVar.f469a;
                this.f470b = new g(hVar.f470b);
                Paint paint = hVar.f470b.f464e;
                if (paint != null) {
                    this.f470b.f464e = new Paint(paint);
                }
                Paint paint2 = hVar.f470b.f463d;
                if (paint2 != null) {
                    this.f470b.f463d = new Paint(paint2);
                }
                this.f471c = hVar.f471c;
                this.f472d = hVar.f472d;
                this.f473e = hVar.f473e;
            }
        }

        public void a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f474f, (Rect) null, rect, a(colorFilter));
        }

        public boolean b() {
            return this.f470b.getRootAlpha() < 255;
        }

        public void c(int i2, int i3) {
            this.f474f.eraseColor(0);
            this.f470b.a(new Canvas(this.f474f), i2, i3, (ColorFilter) null);
        }

        public void d() {
            this.f475g = this.f471c;
            this.f476h = this.f472d;
            this.f477i = this.f470b.getRootAlpha();
            this.j = this.f473e;
            this.k = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f469a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new i(this);
        }

        public void b(int i2, int i3) {
            if (this.f474f == null || !a(i2, i3)) {
                this.f474f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.k = true;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new i(this);
        }

        public Paint a(ColorFilter colorFilter) {
            if (b() || colorFilter != null) {
                if (this.l == null) {
                    this.l = new Paint();
                    this.l.setFilterBitmap(true);
                }
                this.l.setAlpha(this.f470b.getRootAlpha());
                this.l.setColorFilter(colorFilter);
                return this.l;
            }
            return null;
        }

        public boolean c() {
            return this.f470b.a();
        }

        public boolean a(int i2, int i3) {
            return i2 == this.f474f.getWidth() && i3 == this.f474f.getHeight();
        }

        public boolean a() {
            return !this.k && this.f475g == this.f471c && this.f476h == this.f472d && this.j == this.f473e && this.f477i == this.f470b.getRootAlpha();
        }

        public h() {
            this.f471c = null;
            this.f472d = i.j;
            this.f470b = new g();
        }

        public boolean a(int[] iArr) {
            boolean a2 = this.f470b.a(iArr);
            this.k |= a2;
            return a2;
        }
    }

    public i() {
        this.f438f = true;
        this.f439g = new float[9];
        this.f440h = new Matrix();
        this.f441i = new Rect();
        this.f434b = new h();
    }

    public static i createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        i iVar = new i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    public Object a(String str) {
        return this.f434b.f470b.p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            a.b.g.c.j.a.a(drawable);
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f441i);
        if (this.f441i.width() <= 0 || this.f441i.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f436d;
        if (colorFilter == null) {
            colorFilter = this.f435c;
        }
        canvas.getMatrix(this.f440h);
        this.f440h.getValues(this.f439g);
        float abs = Math.abs(this.f439g[0]);
        float abs2 = Math.abs(this.f439g[4]);
        float abs3 = Math.abs(this.f439g[1]);
        float abs4 = Math.abs(this.f439g[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.f441i.width() * abs));
        int min2 = Math.min(2048, (int) (this.f441i.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.f441i;
        canvas.translate(rect.left, rect.top);
        if (a()) {
            canvas.translate(this.f441i.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f441i.offsetTo(0, 0);
        this.f434b.b(min, min2);
        if (!this.f438f) {
            this.f434b.c(min, min2);
        } else if (!this.f434b.a()) {
            this.f434b.c(min, min2);
            this.f434b.d();
        }
        this.f434b.a(canvas, colorFilter, this.f441i);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return a.b.g.c.j.a.c(drawable);
        }
        return this.f434b.f470b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f434b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f433a;
        if (drawable != null && Build.VERSION.SDK_INT >= 24) {
            return new C0010i(drawable.getConstantState());
        }
        this.f434b.f469a = getChangingConfigurations();
        return this.f434b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f434b.f470b.j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f434b.f470b.f468i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return a.b.g.c.j.a.f(drawable);
        }
        return this.f434b.f473e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        h hVar;
        ColorStateList colorStateList;
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((hVar = this.f434b) != null && (hVar.c() || ((colorStateList = this.f434b.f471c) != null && colorStateList.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f437e && super.mutate() == this) {
            this.f434b = new h(this.f434b);
            this.f437e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        h hVar = this.f434b;
        ColorStateList colorStateList = hVar.f471c;
        if (colorStateList != null && (mode = hVar.f472d) != null) {
            this.f435c = a(this.f435c, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (hVar.c() && hVar.a(iArr)) {
            invalidateSelf();
            return true;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.f434b.f470b.getRootAlpha() != i2) {
            this.f434b.f470b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            a.b.g.c.j.a.a(drawable, z);
        } else {
            this.f434b.f473e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f436d = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, a.b.g.c.j.e
    public void setTint(int i2) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            a.b.g.c.j.a.b(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable, a.b.g.c.j.e
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            a.b.g.c.j.a.a(drawable, colorStateList);
            return;
        }
        h hVar = this.f434b;
        if (hVar.f471c != colorStateList) {
            hVar.f471c = colorStateList;
            this.f435c = a(this.f435c, colorStateList, hVar.f472d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, a.b.g.c.j.e
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            a.b.g.c.j.a.a(drawable, mode);
            return;
        }
        h hVar = this.f434b;
        if (hVar.f472d != mode) {
            hVar.f472d = mode;
            this.f435c = a(this.f435c, hVar.f471c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class f extends e {

        /* renamed from: a  reason: collision with root package name */
        public b.C0022b[] f457a;

        /* renamed from: b  reason: collision with root package name */
        public String f458b;

        /* renamed from: c  reason: collision with root package name */
        public int f459c;

        public f() {
            super();
            this.f457a = null;
        }

        public void a(Path path) {
            path.reset();
            b.C0022b[] c0022bArr = this.f457a;
            if (c0022bArr != null) {
                b.C0022b.a(c0022bArr, path);
            }
        }

        public boolean b() {
            return false;
        }

        public b.C0022b[] getPathData() {
            return this.f457a;
        }

        public String getPathName() {
            return this.f458b;
        }

        public void setPathData(b.C0022b[] c0022bArr) {
            if (!a.b.g.c.b.a(this.f457a, c0022bArr)) {
                this.f457a = a.b.g.c.b.a(c0022bArr);
            } else {
                a.b.g.c.b.b(this.f457a, c0022bArr);
            }
        }

        public f(f fVar) {
            super();
            this.f457a = null;
            this.f458b = fVar.f458b;
            this.f459c = fVar.f459c;
            this.f457a = a.b.g.c.b.a(fVar.f457a);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: a.b.e.a.i$i  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0010i extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public final Drawable.ConstantState f478a;

        public C0010i(Drawable.ConstantState constantState) {
            this.f478a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f478a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f478a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i iVar = new i();
            iVar.f433a = (VectorDrawable) this.f478a.newDrawable();
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            i iVar = new i();
            iVar.f433a = (VectorDrawable) this.f478a.newDrawable(resources);
            return iVar;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            i iVar = new i();
            iVar.f433a = (VectorDrawable) this.f478a.newDrawable(resources, theme);
            return iVar;
        }
    }

    public PorterDuffColorFilter a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class c extends f {

        /* renamed from: d  reason: collision with root package name */
        public int[] f442d;

        /* renamed from: e  reason: collision with root package name */
        public a.b.g.b.g.b f443e;

        /* renamed from: f  reason: collision with root package name */
        public float f444f;

        /* renamed from: g  reason: collision with root package name */
        public a.b.g.b.g.b f445g;

        /* renamed from: h  reason: collision with root package name */
        public float f446h;

        /* renamed from: i  reason: collision with root package name */
        public int f447i;
        public float j;
        public float k;
        public float l;
        public float m;
        public Paint.Cap n;
        public Paint.Join o;
        public float p;

        public c() {
            this.f444f = 0.0f;
            this.f446h = 1.0f;
            this.f447i = 0;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
        }

        public final Paint.Cap a(int i2, Paint.Cap cap) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return i2 != 2 ? cap : Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        public float getFillAlpha() {
            return this.j;
        }

        public int getFillColor() {
            return this.f445g.a();
        }

        public float getStrokeAlpha() {
            return this.f446h;
        }

        public int getStrokeColor() {
            return this.f443e.a();
        }

        public float getStrokeWidth() {
            return this.f444f;
        }

        public float getTrimPathEnd() {
            return this.l;
        }

        public float getTrimPathOffset() {
            return this.m;
        }

        public float getTrimPathStart() {
            return this.k;
        }

        public void setFillAlpha(float f2) {
            this.j = f2;
        }

        public void setFillColor(int i2) {
            this.f445g.a(i2);
        }

        public void setStrokeAlpha(float f2) {
            this.f446h = f2;
        }

        public void setStrokeColor(int i2) {
            this.f443e.a(i2);
        }

        public void setStrokeWidth(float f2) {
            this.f444f = f2;
        }

        public void setTrimPathEnd(float f2) {
            this.l = f2;
        }

        public void setTrimPathOffset(float f2) {
            this.m = f2;
        }

        public void setTrimPathStart(float f2) {
            this.k = f2;
        }

        public final Paint.Join a(int i2, Paint.Join join) {
            if (i2 != 0) {
                if (i2 != 1) {
                    return i2 != 2 ? join : Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = a.b.g.b.g.g.a(resources, theme, attributeSet, a.b.e.a.a.f411c);
            a(a2, xmlPullParser, theme);
            a2.recycle();
        }

        public final void a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f442d = null;
            if (a.b.g.b.g.g.a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f458b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f457a = a.b.g.c.b.a(string2);
                }
                this.f445g = a.b.g.b.g.g.a(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.j = a.b.g.b.g.g.a(typedArray, xmlPullParser, "fillAlpha", 12, this.j);
                this.n = a(a.b.g.b.g.g.b(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.n);
                this.o = a(a.b.g.b.g.g.b(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.o);
                this.p = a.b.g.b.g.g.a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.p);
                this.f443e = a.b.g.b.g.g.a(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f446h = a.b.g.b.g.g.a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f446h);
                this.f444f = a.b.g.b.g.g.a(typedArray, xmlPullParser, "strokeWidth", 4, this.f444f);
                this.l = a.b.g.b.g.g.a(typedArray, xmlPullParser, "trimPathEnd", 6, this.l);
                this.m = a.b.g.b.g.g.a(typedArray, xmlPullParser, "trimPathOffset", 7, this.m);
                this.k = a.b.g.b.g.g.a(typedArray, xmlPullParser, "trimPathStart", 5, this.k);
                this.f447i = a.b.g.b.g.g.b(typedArray, xmlPullParser, "fillType", 13, this.f447i);
            }
        }

        public c(c cVar) {
            super(cVar);
            this.f444f = 0.0f;
            this.f446h = 1.0f;
            this.f447i = 0;
            this.j = 1.0f;
            this.k = 0.0f;
            this.l = 1.0f;
            this.m = 0.0f;
            this.n = Paint.Cap.BUTT;
            this.o = Paint.Join.MITER;
            this.p = 4.0f;
            this.f442d = cVar.f442d;
            this.f443e = cVar.f443e;
            this.f444f = cVar.f444f;
            this.f446h = cVar.f446h;
            this.f445g = cVar.f445g;
            this.f447i = cVar.f447i;
            this.j = cVar.j;
            this.k = cVar.k;
            this.l = cVar.l;
            this.m = cVar.m;
            this.n = cVar.n;
            this.o = cVar.o;
            this.p = cVar.p;
        }

        @Override // a.b.e.a.i.e
        public boolean a() {
            return this.f445g.d() || this.f443e.d();
        }

        @Override // a.b.e.a.i.e
        public boolean a(int[] iArr) {
            return this.f443e.a(iArr) | this.f445g.a(iArr);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class d extends e {

        /* renamed from: a  reason: collision with root package name */
        public final Matrix f448a;

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<e> f449b;

        /* renamed from: c  reason: collision with root package name */
        public float f450c;

        /* renamed from: d  reason: collision with root package name */
        public float f451d;

        /* renamed from: e  reason: collision with root package name */
        public float f452e;

        /* renamed from: f  reason: collision with root package name */
        public float f453f;

        /* renamed from: g  reason: collision with root package name */
        public float f454g;

        /* renamed from: h  reason: collision with root package name */
        public float f455h;

        /* renamed from: i  reason: collision with root package name */
        public float f456i;
        public final Matrix j;
        public int k;
        public int[] l;
        public String m;

        public d(d dVar, a.b.g.j.a<String, Object> aVar) {
            super();
            f bVar;
            this.f448a = new Matrix();
            this.f449b = new ArrayList<>();
            this.f450c = 0.0f;
            this.f451d = 0.0f;
            this.f452e = 0.0f;
            this.f453f = 1.0f;
            this.f454g = 1.0f;
            this.f455h = 0.0f;
            this.f456i = 0.0f;
            this.j = new Matrix();
            this.m = null;
            this.f450c = dVar.f450c;
            this.f451d = dVar.f451d;
            this.f452e = dVar.f452e;
            this.f453f = dVar.f453f;
            this.f454g = dVar.f454g;
            this.f455h = dVar.f455h;
            this.f456i = dVar.f456i;
            this.l = dVar.l;
            this.m = dVar.m;
            this.k = dVar.k;
            String str = this.m;
            if (str != null) {
                aVar.put(str, this);
            }
            this.j.set(dVar.j);
            ArrayList<e> arrayList = dVar.f449b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                e eVar = arrayList.get(i2);
                if (eVar instanceof d) {
                    this.f449b.add(new d((d) eVar, aVar));
                } else {
                    if (eVar instanceof c) {
                        bVar = new c((c) eVar);
                    } else if (eVar instanceof b) {
                        bVar = new b((b) eVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f449b.add(bVar);
                    String str2 = bVar.f458b;
                    if (str2 != null) {
                        aVar.put(str2, bVar);
                    }
                }
            }
        }

        public void a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a2 = a.b.g.b.g.g.a(resources, theme, attributeSet, a.b.e.a.a.f410b);
            a(a2, xmlPullParser);
            a2.recycle();
        }

        public final void b() {
            this.j.reset();
            this.j.postTranslate(-this.f451d, -this.f452e);
            this.j.postScale(this.f453f, this.f454g);
            this.j.postRotate(this.f450c, 0.0f, 0.0f);
            this.j.postTranslate(this.f455h + this.f451d, this.f456i + this.f452e);
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.j;
        }

        public float getPivotX() {
            return this.f451d;
        }

        public float getPivotY() {
            return this.f452e;
        }

        public float getRotation() {
            return this.f450c;
        }

        public float getScaleX() {
            return this.f453f;
        }

        public float getScaleY() {
            return this.f454g;
        }

        public float getTranslateX() {
            return this.f455h;
        }

        public float getTranslateY() {
            return this.f456i;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f451d) {
                this.f451d = f2;
                b();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f452e) {
                this.f452e = f2;
                b();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f450c) {
                this.f450c = f2;
                b();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f453f) {
                this.f453f = f2;
                b();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f454g) {
                this.f454g = f2;
                b();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f455h) {
                this.f455h = f2;
                b();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f456i) {
                this.f456i = f2;
                b();
            }
        }

        public final void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f450c = a.b.g.b.g.g.a(typedArray, xmlPullParser, "rotation", 5, this.f450c);
            this.f451d = typedArray.getFloat(1, this.f451d);
            this.f452e = typedArray.getFloat(2, this.f452e);
            this.f453f = a.b.g.b.g.g.a(typedArray, xmlPullParser, "scaleX", 3, this.f453f);
            this.f454g = a.b.g.b.g.g.a(typedArray, xmlPullParser, "scaleY", 4, this.f454g);
            this.f455h = a.b.g.b.g.g.a(typedArray, xmlPullParser, "translateX", 6, this.f455h);
            this.f456i = a.b.g.b.g.g.a(typedArray, xmlPullParser, "translateY", 7, this.f456i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            b();
        }

        @Override // a.b.e.a.i.e
        public boolean a() {
            for (int i2 = 0; i2 < this.f449b.size(); i2++) {
                if (this.f449b.get(i2).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // a.b.e.a.i.e
        public boolean a(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f449b.size(); i2++) {
                z |= this.f449b.get(i2).a(iArr);
            }
            return z;
        }

        public d() {
            super();
            this.f448a = new Matrix();
            this.f449b = new ArrayList<>();
            this.f450c = 0.0f;
            this.f451d = 0.0f;
            this.f452e = 0.0f;
            this.f453f = 1.0f;
            this.f454g = 1.0f;
            this.f455h = 0.0f;
            this.f456i = 0.0f;
            this.j = new Matrix();
            this.m = null;
        }
    }

    public static i a(Resources resources, int i2, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            i iVar = new i();
            iVar.f433a = a.b.g.b.g.f.a(resources, i2, theme);
            new C0010i(iVar.f433a.getConstantState());
            return iVar;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            while (true) {
                next = xml.next();
                if (next == 2 || next == 1) {
                    break;
                }
            }
            if (next == 2) {
                return createFromXmlInner(resources, (XmlPullParser) xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e("VectorDrawableCompat", "parser error", e3);
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f433a;
        if (drawable != null) {
            a.b.g.c.j.a.a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        h hVar = this.f434b;
        hVar.f470b = new g();
        TypedArray a2 = a.b.g.b.g.g.a(resources, theme, attributeSet, a.b.e.a.a.f409a);
        a(a2, xmlPullParser);
        a2.recycle();
        hVar.f469a = getChangingConfigurations();
        hVar.k = true;
        a(resources, xmlPullParser, attributeSet, theme);
        this.f435c = a(this.f435c, hVar.f471c, hVar.f472d);
    }

    public i(h hVar) {
        this.f438f = true;
        this.f439g = new float[9];
        this.f440h = new Matrix();
        this.f441i = new Rect();
        this.f434b = hVar;
        this.f435c = a(this.f435c, hVar.f471c, hVar.f472d);
    }

    /* compiled from: VectorDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class g {
        public static final Matrix q = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        public final Path f460a;

        /* renamed from: b  reason: collision with root package name */
        public final Path f461b;

        /* renamed from: c  reason: collision with root package name */
        public final Matrix f462c;

        /* renamed from: d  reason: collision with root package name */
        public Paint f463d;

        /* renamed from: e  reason: collision with root package name */
        public Paint f464e;

        /* renamed from: f  reason: collision with root package name */
        public PathMeasure f465f;

        /* renamed from: g  reason: collision with root package name */
        public int f466g;

        /* renamed from: h  reason: collision with root package name */
        public final d f467h;

        /* renamed from: i  reason: collision with root package name */
        public float f468i;
        public float j;
        public float k;
        public float l;
        public int m;
        public String n;
        public Boolean o;
        public final a.b.g.j.a<String, Object> p;

        public g() {
            this.f462c = new Matrix();
            this.f468i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new a.b.g.j.a<>();
            this.f467h = new d();
            this.f460a = new Path();
            this.f461b = new Path();
        }

        public static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        public final void a(d dVar, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            dVar.f448a.set(matrix);
            dVar.f448a.preConcat(dVar.j);
            canvas.save();
            for (int i4 = 0; i4 < dVar.f449b.size(); i4++) {
                e eVar = dVar.f449b.get(i4);
                if (eVar instanceof d) {
                    a((d) eVar, dVar.f448a, canvas, i2, i3, colorFilter);
                } else if (eVar instanceof f) {
                    a(dVar, (f) eVar, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.m;
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.m = i2;
        }

        public void a(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            a(this.f467h, q, canvas, i2, i3, colorFilter);
        }

        public g(g gVar) {
            this.f462c = new Matrix();
            this.f468i = 0.0f;
            this.j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 255;
            this.n = null;
            this.o = null;
            this.p = new a.b.g.j.a<>();
            this.f467h = new d(gVar.f467h, this.p);
            this.f460a = new Path(gVar.f460a);
            this.f461b = new Path(gVar.f461b);
            this.f468i = gVar.f468i;
            this.j = gVar.j;
            this.k = gVar.k;
            this.l = gVar.l;
            this.f466g = gVar.f466g;
            this.m = gVar.m;
            this.n = gVar.n;
            String str = gVar.n;
            if (str != null) {
                this.p.put(str, this);
            }
            this.o = gVar.o;
        }

        public final void a(d dVar, f fVar, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = i2 / this.k;
            float f3 = i3 / this.l;
            float min = Math.min(f2, f3);
            Matrix matrix = dVar.f448a;
            this.f462c.set(matrix);
            this.f462c.postScale(f2, f3);
            float a2 = a(matrix);
            if (a2 == 0.0f) {
                return;
            }
            fVar.a(this.f460a);
            Path path = this.f460a;
            this.f461b.reset();
            if (fVar.b()) {
                this.f461b.addPath(path, this.f462c);
                canvas.clipPath(this.f461b);
                return;
            }
            c cVar = (c) fVar;
            if (cVar.k != 0.0f || cVar.l != 1.0f) {
                float f4 = cVar.k;
                float f5 = cVar.m;
                float f6 = (f4 + f5) % 1.0f;
                float f7 = (cVar.l + f5) % 1.0f;
                if (this.f465f == null) {
                    this.f465f = new PathMeasure();
                }
                this.f465f.setPath(this.f460a, false);
                float length = this.f465f.getLength();
                float f8 = f6 * length;
                float f9 = f7 * length;
                path.reset();
                if (f8 > f9) {
                    this.f465f.getSegment(f8, length, path, true);
                    this.f465f.getSegment(0.0f, f9, path, true);
                } else {
                    this.f465f.getSegment(f8, f9, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f461b.addPath(path, this.f462c);
            if (cVar.f445g.e()) {
                a.b.g.b.g.b bVar = cVar.f445g;
                if (this.f464e == null) {
                    this.f464e = new Paint(1);
                    this.f464e.setStyle(Paint.Style.FILL);
                }
                Paint paint = this.f464e;
                if (bVar.c()) {
                    Shader b2 = bVar.b();
                    b2.setLocalMatrix(this.f462c);
                    paint.setShader(b2);
                    paint.setAlpha(Math.round(cVar.j * 255.0f));
                } else {
                    paint.setColor(i.a(bVar.a(), cVar.j));
                }
                paint.setColorFilter(colorFilter);
                this.f461b.setFillType(cVar.f447i == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f461b, paint);
            }
            if (cVar.f443e.e()) {
                a.b.g.b.g.b bVar2 = cVar.f443e;
                if (this.f463d == null) {
                    this.f463d = new Paint(1);
                    this.f463d.setStyle(Paint.Style.STROKE);
                }
                Paint paint2 = this.f463d;
                Paint.Join join = cVar.o;
                if (join != null) {
                    paint2.setStrokeJoin(join);
                }
                Paint.Cap cap = cVar.n;
                if (cap != null) {
                    paint2.setStrokeCap(cap);
                }
                paint2.setStrokeMiter(cVar.p);
                if (bVar2.c()) {
                    Shader b3 = bVar2.b();
                    b3.setLocalMatrix(this.f462c);
                    paint2.setShader(b3);
                    paint2.setAlpha(Math.round(cVar.f446h * 255.0f));
                } else {
                    paint2.setColor(i.a(bVar2.a(), cVar.f446h));
                }
                paint2.setColorFilter(colorFilter);
                paint2.setStrokeWidth(cVar.f444f * min * a2);
                canvas.drawPath(this.f461b, paint2);
            }
        }

        public final float a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public boolean a() {
            if (this.o == null) {
                this.o = Boolean.valueOf(this.f467h.a());
            }
            return this.o.booleanValue();
        }

        public boolean a(int[] iArr) {
            return this.f467h.a(iArr);
        }
    }

    public static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (Color.alpha(i2) * f2)) << 24);
    }

    public static PorterDuff.Mode a(int i2, PorterDuff.Mode mode) {
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 != 9) {
                    switch (i2) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    public final void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        h hVar = this.f434b;
        g gVar = hVar.f470b;
        hVar.f472d = a(a.b.g.b.g.g.b(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            hVar.f471c = colorStateList;
        }
        hVar.f473e = a.b.g.b.g.g.a(typedArray, xmlPullParser, "autoMirrored", 5, hVar.f473e);
        gVar.k = a.b.g.b.g.g.a(typedArray, xmlPullParser, "viewportWidth", 7, gVar.k);
        gVar.l = a.b.g.b.g.g.a(typedArray, xmlPullParser, "viewportHeight", 8, gVar.l);
        if (gVar.k > 0.0f) {
            if (gVar.l > 0.0f) {
                gVar.f468i = typedArray.getDimension(3, gVar.f468i);
                gVar.j = typedArray.getDimension(2, gVar.j);
                if (gVar.f468i > 0.0f) {
                    if (gVar.j > 0.0f) {
                        gVar.setAlpha(a.b.g.b.g.g.a(typedArray, xmlPullParser, "alpha", 4, gVar.getAlpha()));
                        String string = typedArray.getString(0);
                        if (string != null) {
                            gVar.n = string;
                            gVar.p.put(string, gVar);
                            return;
                        }
                        return;
                    }
                    throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
                }
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            }
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
    }

    public final void a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        h hVar = this.f434b;
        g gVar = hVar.f470b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(gVar.f467h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                d dVar = (d) arrayDeque.peek();
                if ("path".equals(name)) {
                    c cVar = new c();
                    cVar.a(resources, attributeSet, theme, xmlPullParser);
                    dVar.f449b.add(cVar);
                    if (cVar.getPathName() != null) {
                        gVar.p.put(cVar.getPathName(), cVar);
                    }
                    z = false;
                    hVar.f469a = cVar.f459c | hVar.f469a;
                } else if ("clip-path".equals(name)) {
                    b bVar = new b();
                    bVar.a(resources, attributeSet, theme, xmlPullParser);
                    dVar.f449b.add(bVar);
                    if (bVar.getPathName() != null) {
                        gVar.p.put(bVar.getPathName(), bVar);
                    }
                    hVar.f469a = bVar.f459c | hVar.f469a;
                } else if ("group".equals(name)) {
                    d dVar2 = new d();
                    dVar2.a(resources, attributeSet, theme, xmlPullParser);
                    dVar.f449b.add(dVar2);
                    arrayDeque.push(dVar2);
                    if (dVar2.getGroupName() != null) {
                        gVar.p.put(dVar2.getGroupName(), dVar2);
                    }
                    hVar.f469a = dVar2.k | hVar.f469a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    public void a(boolean z) {
        this.f438f = z;
    }

    public final boolean a() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && a.b.g.c.j.a.e(this) == 1;
    }
}
