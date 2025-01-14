package p000a.p006b.p027e.p028a;

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
import p000a.p006b.p030g.p032b.p033g.ComplexColorCompat;
import p000a.p006b.p030g.p032b.p033g.ResourcesCompat;
import p000a.p006b.p030g.p032b.p033g.TypedArrayUtils;
import p000a.p006b.p030g.p034c.PathParser;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;
import p000a.p006b.p030g.p044j.ArrayMap;

/* renamed from: a.b.e.a.i */
/* loaded from: classes.dex */
public class VectorDrawableCompat extends VectorDrawableCommon {

    /* renamed from: j */
    public static final PorterDuff.Mode f779j = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    public C0092h f780b;

    /* renamed from: c */
    public PorterDuffColorFilter f781c;

    /* renamed from: d */
    public ColorFilter f782d;

    /* renamed from: e */
    public boolean f783e;

    /* renamed from: f */
    public boolean f784f;

    /* renamed from: g */
    public final float[] f785g;

    /* renamed from: h */
    public final Matrix f786h;

    /* renamed from: i */
    public final Rect f787i;

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: a.b.e.a.i$b */
    /* loaded from: classes.dex */
    public static class C0086b extends AbstractC0090f {
        public C0086b() {
        }

        /* renamed from: a */
        public void m10606a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.m9936a(xmlPullParser, "pathData")) {
                TypedArray m9945a = TypedArrayUtils.m9945a(resources, theme, attributeSet, AndroidResources.f754d);
                m10605a(m9945a);
                m9945a.recycle();
            }
        }

        @Override // p000a.p006b.p027e.p028a.VectorDrawableCompat.AbstractC0090f
        /* renamed from: b */
        public boolean mo10594b() {
            return true;
        }

        public C0086b(C0086b c0086b) {
            super(c0086b);
        }

        /* renamed from: a */
        public final void m10605a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f815b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f814a = PathParser.m9924a(string2);
            }
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: a.b.e.a.i$e */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0089e {
        public AbstractC0089e() {
        }

        /* renamed from: a */
        public boolean mo10597a() {
            return false;
        }

        /* renamed from: a */
        public boolean mo10596a(int[] iArr) {
            return false;
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: a.b.e.a.i$h */
    /* loaded from: classes.dex */
    public static class C0092h extends Drawable.ConstantState {

        /* renamed from: a */
        public int f834a;

        /* renamed from: b */
        public C0091g f835b;

        /* renamed from: c */
        public ColorStateList f836c;

        /* renamed from: d */
        public PorterDuff.Mode f837d;

        /* renamed from: e */
        public boolean f838e;

        /* renamed from: f */
        public Bitmap f839f;

        /* renamed from: g */
        public ColorStateList f840g;

        /* renamed from: h */
        public PorterDuff.Mode f841h;

        /* renamed from: i */
        public int f842i;

        /* renamed from: j */
        public boolean f843j;

        /* renamed from: k */
        public boolean f844k;

        /* renamed from: l */
        public Paint f845l;

        public C0092h(C0092h c0092h) {
            this.f836c = null;
            this.f837d = VectorDrawableCompat.f779j;
            if (c0092h != null) {
                this.f834a = c0092h.f834a;
                this.f835b = new C0091g(c0092h.f835b);
                Paint paint = c0092h.f835b.f822e;
                if (paint != null) {
                    this.f835b.f822e = new Paint(paint);
                }
                Paint paint2 = c0092h.f835b.f821d;
                if (paint2 != null) {
                    this.f835b.f821d = new Paint(paint2);
                }
                this.f836c = c0092h.f836c;
                this.f837d = c0092h.f837d;
                this.f838e = c0092h.f838e;
            }
        }

        /* renamed from: a */
        public void m10584a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f839f, (Rect) null, rect, m10583a(colorFilter));
        }

        /* renamed from: b */
        public boolean m10581b() {
            return this.f835b.getRootAlpha() < 255;
        }

        /* renamed from: c */
        public void m10578c(int i, int i2) {
            this.f839f.eraseColor(0);
            this.f835b.m10589a(new Canvas(this.f839f), i, i2, (ColorFilter) null);
        }

        /* renamed from: d */
        public void m10577d() {
            this.f840g = this.f836c;
            this.f841h = this.f837d;
            this.f842i = this.f835b.getRootAlpha();
            this.f843j = this.f838e;
            this.f844k = false;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f834a;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        /* renamed from: b */
        public void m10580b(int i, int i2) {
            if (this.f839f == null || !m10585a(i, i2)) {
                this.f839f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.f844k = true;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        /* renamed from: a */
        public Paint m10583a(ColorFilter colorFilter) {
            if (m10581b() || colorFilter != null) {
                if (this.f845l == null) {
                    this.f845l = new Paint();
                    this.f845l.setFilterBitmap(true);
                }
                this.f845l.setAlpha(this.f835b.getRootAlpha());
                this.f845l.setColorFilter(colorFilter);
                return this.f845l;
            }
            return null;
        }

        /* renamed from: c */
        public boolean m10579c() {
            return this.f835b.m10593a();
        }

        /* renamed from: a */
        public boolean m10585a(int i, int i2) {
            return i == this.f839f.getWidth() && i2 == this.f839f.getHeight();
        }

        /* renamed from: a */
        public boolean m10586a() {
            return !this.f844k && this.f840g == this.f836c && this.f841h == this.f837d && this.f843j == this.f838e && this.f842i == this.f835b.getRootAlpha();
        }

        public C0092h() {
            this.f836c = null;
            this.f837d = VectorDrawableCompat.f779j;
            this.f835b = new C0091g();
        }

        /* renamed from: a */
        public boolean m10582a(int[] iArr) {
            boolean m10587a = this.f835b.m10587a(iArr);
            this.f844k |= m10587a;
            return m10587a;
        }
    }

    public VectorDrawableCompat() {
        this.f784f = true;
        this.f785g = new float[9];
        this.f786h = new Matrix();
        this.f787i = new Rect();
        this.f780b = new C0092h();
    }

    public static VectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    /* renamed from: a */
    public Object m10608a(String str) {
        return this.f780b.f835b.f833p.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            DrawableCompat.m9865a(drawable);
            return false;
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.f787i);
        if (this.f787i.width() <= 0 || this.f787i.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f782d;
        if (colorFilter == null) {
            colorFilter = this.f781c;
        }
        canvas.getMatrix(this.f786h);
        this.f786h.getValues(this.f785g);
        float abs = Math.abs(this.f785g[0]);
        float abs2 = Math.abs(this.f785g[4]);
        float abs3 = Math.abs(this.f785g[1]);
        float abs4 = Math.abs(this.f785g[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.f787i.width() * abs));
        int min2 = Math.min(2048, (int) (this.f787i.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.f787i;
        canvas.translate(rect.left, rect.top);
        if (m10615a()) {
            canvas.translate(this.f787i.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f787i.offsetTo(0, 0);
        this.f780b.m10580b(min, min2);
        if (!this.f784f) {
            this.f780b.m10578c(min, min2);
        } else if (!this.f780b.m10586a()) {
            this.f780b.m10578c(min, min2);
            this.f780b.m10577d();
        }
        this.f780b.m10584a(canvas, colorFilter, this.f787i);
        canvas.restoreToCount(save);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return DrawableCompat.m9854c(drawable);
        }
        return this.f780b.f835b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f780b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        Drawable drawable = this.f778a;
        if (drawable != null && Build.VERSION.SDK_INT >= 24) {
            return new C0093i(drawable.getConstantState());
        }
        this.f780b.f834a = getChangingConfigurations();
        return this.f780b;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.f780b.f835b.f827j;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.f780b.f835b.f826i;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return DrawableCompat.m9851f(drawable);
        }
        return this.f780b.f838e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        C0092h c0092h;
        ColorStateList colorStateList;
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return drawable.isStateful();
        }
        return super.isStateful() || ((c0092h = this.f780b) != null && (c0092h.m10579c() || ((colorStateList = this.f780b.f836c) != null && colorStateList.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.f783e && super.mutate() == this) {
            this.f780b = new C0092h(this.f780b);
            this.f783e = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        C0092h c0092h = this.f780b;
        ColorStateList colorStateList = c0092h.f836c;
        if (colorStateList != null && (mode = c0092h.f837d) != null) {
            this.f781c = m10609a(this.f781c, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (c0092h.m10579c() && c0092h.m10582a(iArr)) {
            invalidateSelf();
            return true;
        }
        return z;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            drawable.setAlpha(i);
        } else if (this.f780b.f835b.getRootAlpha() != i) {
            this.f780b.f835b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            DrawableCompat.m9857a(drawable, z);
        } else {
            this.f780b.f838e = z;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.f782d = colorFilter;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, p000a.p006b.p030g.p034c.p035j.TintAwareDrawable
    public void setTint(int i) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            DrawableCompat.m9855b(drawable, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, p000a.p006b.p030g.p034c.p035j.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            DrawableCompat.m9861a(drawable, colorStateList);
            return;
        }
        C0092h c0092h = this.f780b;
        if (c0092h.f836c != colorStateList) {
            c0092h.f836c = colorStateList;
            this.f781c = m10609a(this.f781c, colorStateList, c0092h.f837d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, p000a.p006b.p030g.p034c.p035j.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            DrawableCompat.m9858a(drawable, mode);
            return;
        }
        C0092h c0092h = this.f780b;
        if (c0092h.f837d != mode) {
            c0092h.f837d = mode;
            this.f781c = m10609a(this.f781c, c0092h.f836c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            return drawable.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: a.b.e.a.i$f */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0090f extends AbstractC0089e {

        /* renamed from: a */
        public PathParser.C0214b[] f814a;

        /* renamed from: b */
        public String f815b;

        /* renamed from: c */
        public int f816c;

        public AbstractC0090f() {
            super();
            this.f814a = null;
        }

        /* renamed from: a */
        public void m10595a(Path path) {
            path.reset();
            PathParser.C0214b[] c0214bArr = this.f814a;
            if (c0214bArr != null) {
                PathParser.C0214b.m9910a(c0214bArr, path);
            }
        }

        /* renamed from: b */
        public boolean mo10594b() {
            return false;
        }

        public PathParser.C0214b[] getPathData() {
            return this.f814a;
        }

        public String getPathName() {
            return this.f815b;
        }

        public void setPathData(PathParser.C0214b[] c0214bArr) {
            if (!PathParser.m9918a(this.f814a, c0214bArr)) {
                this.f814a = PathParser.m9919a(c0214bArr);
            } else {
                PathParser.m9916b(this.f814a, c0214bArr);
            }
        }

        public AbstractC0090f(AbstractC0090f abstractC0090f) {
            super();
            this.f814a = null;
            this.f815b = abstractC0090f.f815b;
            this.f816c = abstractC0090f.f816c;
            this.f814a = PathParser.m9919a(abstractC0090f.f814a);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: a.b.e.a.i$i */
    /* loaded from: classes.dex */
    public static class C0093i extends Drawable.ConstantState {

        /* renamed from: a */
        public final Drawable.ConstantState f846a;

        public C0093i(Drawable.ConstantState constantState) {
            this.f846a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f846a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f846a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f778a = (VectorDrawable) this.f846a.newDrawable();
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f778a = (VectorDrawable) this.f846a.newDrawable(resources);
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f778a = (VectorDrawable) this.f846a.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    /* renamed from: a */
    public PorterDuffColorFilter m10609a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: a.b.e.a.i$c */
    /* loaded from: classes.dex */
    public static class C0087c extends AbstractC0090f {

        /* renamed from: d */
        public int[] f788d;

        /* renamed from: e */
        public ComplexColorCompat f789e;

        /* renamed from: f */
        public float f790f;

        /* renamed from: g */
        public ComplexColorCompat f791g;

        /* renamed from: h */
        public float f792h;

        /* renamed from: i */
        public int f793i;

        /* renamed from: j */
        public float f794j;

        /* renamed from: k */
        public float f795k;

        /* renamed from: l */
        public float f796l;

        /* renamed from: m */
        public float f797m;

        /* renamed from: n */
        public Paint.Cap f798n;

        /* renamed from: o */
        public Paint.Join f799o;

        /* renamed from: p */
        public float f800p;

        public C0087c() {
            this.f790f = 0.0f;
            this.f792h = 1.0f;
            this.f793i = 0;
            this.f794j = 1.0f;
            this.f795k = 0.0f;
            this.f796l = 1.0f;
            this.f797m = 0.0f;
            this.f798n = Paint.Cap.BUTT;
            this.f799o = Paint.Join.MITER;
            this.f800p = 4.0f;
        }

        /* renamed from: a */
        public final Paint.Cap m10604a(int i, Paint.Cap cap) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? cap : Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }

        public float getFillAlpha() {
            return this.f794j;
        }

        public int getFillColor() {
            return this.f791g.m9989a();
        }

        public float getStrokeAlpha() {
            return this.f792h;
        }

        public int getStrokeColor() {
            return this.f789e.m9989a();
        }

        public float getStrokeWidth() {
            return this.f790f;
        }

        public float getTrimPathEnd() {
            return this.f796l;
        }

        public float getTrimPathOffset() {
            return this.f797m;
        }

        public float getTrimPathStart() {
            return this.f795k;
        }

        public void setFillAlpha(float f) {
            this.f794j = f;
        }

        public void setFillColor(int i) {
            this.f791g.m9988a(i);
        }

        public void setStrokeAlpha(float f) {
            this.f792h = f;
        }

        public void setStrokeColor(int i) {
            this.f789e.m9988a(i);
        }

        public void setStrokeWidth(float f) {
            this.f790f = f;
        }

        public void setTrimPathEnd(float f) {
            this.f796l = f;
        }

        public void setTrimPathOffset(float f) {
            this.f797m = f;
        }

        public void setTrimPathStart(float f) {
            this.f795k = f;
        }

        /* renamed from: a */
        public final Paint.Join m10603a(int i, Paint.Join join) {
            if (i != 0) {
                if (i != 1) {
                    return i != 2 ? join : Paint.Join.BEVEL;
                }
                return Paint.Join.ROUND;
            }
            return Paint.Join.MITER;
        }

        /* renamed from: a */
        public void m10602a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray m9945a = TypedArrayUtils.m9945a(resources, theme, attributeSet, AndroidResources.f753c);
            m10601a(m9945a, xmlPullParser, theme);
            m9945a.recycle();
        }

        /* renamed from: a */
        public final void m10601a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f788d = null;
            if (TypedArrayUtils.m9936a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f815b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f814a = PathParser.m9924a(string2);
                }
                this.f791g = TypedArrayUtils.m9941a(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f794j = TypedArrayUtils.m9939a(typedArray, xmlPullParser, "fillAlpha", 12, this.f794j);
                this.f798n = m10604a(TypedArrayUtils.m9932b(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f798n);
                this.f799o = m10603a(TypedArrayUtils.m9932b(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f799o);
                this.f800p = TypedArrayUtils.m9939a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f800p);
                this.f789e = TypedArrayUtils.m9941a(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f792h = TypedArrayUtils.m9939a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f792h);
                this.f790f = TypedArrayUtils.m9939a(typedArray, xmlPullParser, "strokeWidth", 4, this.f790f);
                this.f796l = TypedArrayUtils.m9939a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f796l);
                this.f797m = TypedArrayUtils.m9939a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f797m);
                this.f795k = TypedArrayUtils.m9939a(typedArray, xmlPullParser, "trimPathStart", 5, this.f795k);
                this.f793i = TypedArrayUtils.m9932b(typedArray, xmlPullParser, "fillType", 13, this.f793i);
            }
        }

        public C0087c(C0087c c0087c) {
            super(c0087c);
            this.f790f = 0.0f;
            this.f792h = 1.0f;
            this.f793i = 0;
            this.f794j = 1.0f;
            this.f795k = 0.0f;
            this.f796l = 1.0f;
            this.f797m = 0.0f;
            this.f798n = Paint.Cap.BUTT;
            this.f799o = Paint.Join.MITER;
            this.f800p = 4.0f;
            this.f788d = c0087c.f788d;
            this.f789e = c0087c.f789e;
            this.f790f = c0087c.f790f;
            this.f792h = c0087c.f792h;
            this.f791g = c0087c.f791g;
            this.f793i = c0087c.f793i;
            this.f794j = c0087c.f794j;
            this.f795k = c0087c.f795k;
            this.f796l = c0087c.f796l;
            this.f797m = c0087c.f797m;
            this.f798n = c0087c.f798n;
            this.f799o = c0087c.f799o;
            this.f800p = c0087c.f800p;
        }

        @Override // p000a.p006b.p027e.p028a.VectorDrawableCompat.AbstractC0089e
        /* renamed from: a */
        public boolean mo10597a() {
            return this.f791g.m9979d() || this.f789e.m9979d();
        }

        @Override // p000a.p006b.p027e.p028a.VectorDrawableCompat.AbstractC0089e
        /* renamed from: a */
        public boolean mo10596a(int[] iArr) {
            return this.f789e.m9984a(iArr) | this.f791g.m9984a(iArr);
        }
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: a.b.e.a.i$d */
    /* loaded from: classes.dex */
    public static class C0088d extends AbstractC0089e {

        /* renamed from: a */
        public final Matrix f801a;

        /* renamed from: b */
        public final ArrayList<AbstractC0089e> f802b;

        /* renamed from: c */
        public float f803c;

        /* renamed from: d */
        public float f804d;

        /* renamed from: e */
        public float f805e;

        /* renamed from: f */
        public float f806f;

        /* renamed from: g */
        public float f807g;

        /* renamed from: h */
        public float f808h;

        /* renamed from: i */
        public float f809i;

        /* renamed from: j */
        public final Matrix f810j;

        /* renamed from: k */
        public int f811k;

        /* renamed from: l */
        public int[] f812l;

        /* renamed from: m */
        public String f813m;

        public C0088d(C0088d c0088d, ArrayMap<String, Object> arrayMap) {
            super();
            AbstractC0090f c0086b;
            this.f801a = new Matrix();
            this.f802b = new ArrayList<>();
            this.f803c = 0.0f;
            this.f804d = 0.0f;
            this.f805e = 0.0f;
            this.f806f = 1.0f;
            this.f807g = 1.0f;
            this.f808h = 0.0f;
            this.f809i = 0.0f;
            this.f810j = new Matrix();
            this.f813m = null;
            this.f803c = c0088d.f803c;
            this.f804d = c0088d.f804d;
            this.f805e = c0088d.f805e;
            this.f806f = c0088d.f806f;
            this.f807g = c0088d.f807g;
            this.f808h = c0088d.f808h;
            this.f809i = c0088d.f809i;
            this.f812l = c0088d.f812l;
            this.f813m = c0088d.f813m;
            this.f811k = c0088d.f811k;
            String str = this.f813m;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.f810j.set(c0088d.f810j);
            ArrayList<AbstractC0089e> arrayList = c0088d.f802b;
            for (int i = 0; i < arrayList.size(); i++) {
                AbstractC0089e abstractC0089e = arrayList.get(i);
                if (abstractC0089e instanceof C0088d) {
                    this.f802b.add(new C0088d((C0088d) abstractC0089e, arrayMap));
                } else {
                    if (abstractC0089e instanceof C0087c) {
                        c0086b = new C0087c((C0087c) abstractC0089e);
                    } else if (abstractC0089e instanceof C0086b) {
                        c0086b = new C0086b((C0086b) abstractC0089e);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f802b.add(c0086b);
                    String str2 = c0086b.f815b;
                    if (str2 != null) {
                        arrayMap.put(str2, c0086b);
                    }
                }
            }
        }

        /* renamed from: a */
        public void m10600a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray m9945a = TypedArrayUtils.m9945a(resources, theme, attributeSet, AndroidResources.f752b);
            m10599a(m9945a, xmlPullParser);
            m9945a.recycle();
        }

        /* renamed from: b */
        public final void m10598b() {
            this.f810j.reset();
            this.f810j.postTranslate(-this.f804d, -this.f805e);
            this.f810j.postScale(this.f806f, this.f807g);
            this.f810j.postRotate(this.f803c, 0.0f, 0.0f);
            this.f810j.postTranslate(this.f808h + this.f804d, this.f809i + this.f805e);
        }

        public String getGroupName() {
            return this.f813m;
        }

        public Matrix getLocalMatrix() {
            return this.f810j;
        }

        public float getPivotX() {
            return this.f804d;
        }

        public float getPivotY() {
            return this.f805e;
        }

        public float getRotation() {
            return this.f803c;
        }

        public float getScaleX() {
            return this.f806f;
        }

        public float getScaleY() {
            return this.f807g;
        }

        public float getTranslateX() {
            return this.f808h;
        }

        public float getTranslateY() {
            return this.f809i;
        }

        public void setPivotX(float f) {
            if (f != this.f804d) {
                this.f804d = f;
                m10598b();
            }
        }

        public void setPivotY(float f) {
            if (f != this.f805e) {
                this.f805e = f;
                m10598b();
            }
        }

        public void setRotation(float f) {
            if (f != this.f803c) {
                this.f803c = f;
                m10598b();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f806f) {
                this.f806f = f;
                m10598b();
            }
        }

        public void setScaleY(float f) {
            if (f != this.f807g) {
                this.f807g = f;
                m10598b();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.f808h) {
                this.f808h = f;
                m10598b();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.f809i) {
                this.f809i = f;
                m10598b();
            }
        }

        /* renamed from: a */
        public final void m10599a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f812l = null;
            this.f803c = TypedArrayUtils.m9939a(typedArray, xmlPullParser, "rotation", 5, this.f803c);
            this.f804d = typedArray.getFloat(1, this.f804d);
            this.f805e = typedArray.getFloat(2, this.f805e);
            this.f806f = TypedArrayUtils.m9939a(typedArray, xmlPullParser, "scaleX", 3, this.f806f);
            this.f807g = TypedArrayUtils.m9939a(typedArray, xmlPullParser, "scaleY", 4, this.f807g);
            this.f808h = TypedArrayUtils.m9939a(typedArray, xmlPullParser, "translateX", 6, this.f808h);
            this.f809i = TypedArrayUtils.m9939a(typedArray, xmlPullParser, "translateY", 7, this.f809i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f813m = string;
            }
            m10598b();
        }

        @Override // p000a.p006b.p027e.p028a.VectorDrawableCompat.AbstractC0089e
        /* renamed from: a */
        public boolean mo10597a() {
            for (int i = 0; i < this.f802b.size(); i++) {
                if (this.f802b.get(i).mo10597a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // p000a.p006b.p027e.p028a.VectorDrawableCompat.AbstractC0089e
        /* renamed from: a */
        public boolean mo10596a(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.f802b.size(); i++) {
                z |= this.f802b.get(i).mo10596a(iArr);
            }
            return z;
        }

        public C0088d() {
            super();
            this.f801a = new Matrix();
            this.f802b = new ArrayList<>();
            this.f803c = 0.0f;
            this.f804d = 0.0f;
            this.f805e = 0.0f;
            this.f806f = 1.0f;
            this.f807g = 1.0f;
            this.f808h = 0.0f;
            this.f809i = 0.0f;
            this.f810j = new Matrix();
            this.f813m = null;
        }
    }

    /* renamed from: a */
    public static VectorDrawableCompat m10612a(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f778a = ResourcesCompat.m9949a(resources, i, theme);
            new C0093i(vectorDrawableCompat.f778a.getConstantState());
            return vectorDrawableCompat;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
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
        } catch (IOException e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (XmlPullParserException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        Drawable drawable = this.f778a;
        if (drawable != null) {
            DrawableCompat.m9859a(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0092h c0092h = this.f780b;
        c0092h.f835b = new C0091g();
        TypedArray m9945a = TypedArrayUtils.m9945a(resources, theme, attributeSet, AndroidResources.f751a);
        m10610a(m9945a, xmlPullParser);
        m9945a.recycle();
        c0092h.f834a = getChangingConfigurations();
        c0092h.f844k = true;
        m10611a(resources, xmlPullParser, attributeSet, theme);
        this.f781c = m10609a(this.f781c, c0092h.f836c, c0092h.f837d);
    }

    public VectorDrawableCompat(C0092h c0092h) {
        this.f784f = true;
        this.f785g = new float[9];
        this.f786h = new Matrix();
        this.f787i = new Rect();
        this.f780b = c0092h;
        this.f781c = m10609a(this.f781c, c0092h.f836c, c0092h.f837d);
    }

    /* compiled from: VectorDrawableCompat.java */
    /* renamed from: a.b.e.a.i$g */
    /* loaded from: classes.dex */
    public static class C0091g {

        /* renamed from: q */
        public static final Matrix f817q = new Matrix();

        /* renamed from: a */
        public final Path f818a;

        /* renamed from: b */
        public final Path f819b;

        /* renamed from: c */
        public final Matrix f820c;

        /* renamed from: d */
        public Paint f821d;

        /* renamed from: e */
        public Paint f822e;

        /* renamed from: f */
        public PathMeasure f823f;

        /* renamed from: g */
        public int f824g;

        /* renamed from: h */
        public final C0088d f825h;

        /* renamed from: i */
        public float f826i;

        /* renamed from: j */
        public float f827j;

        /* renamed from: k */
        public float f828k;

        /* renamed from: l */
        public float f829l;

        /* renamed from: m */
        public int f830m;

        /* renamed from: n */
        public String f831n;

        /* renamed from: o */
        public Boolean f832o;

        /* renamed from: p */
        public final ArrayMap<String, Object> f833p;

        public C0091g() {
            this.f820c = new Matrix();
            this.f826i = 0.0f;
            this.f827j = 0.0f;
            this.f828k = 0.0f;
            this.f829l = 0.0f;
            this.f830m = 255;
            this.f831n = null;
            this.f832o = null;
            this.f833p = new ArrayMap<>();
            this.f825h = new C0088d();
            this.f818a = new Path();
            this.f819b = new Path();
        }

        /* renamed from: a */
        public static float m10592a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        /* renamed from: a */
        public final void m10590a(C0088d c0088d, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c0088d.f801a.set(matrix);
            c0088d.f801a.preConcat(c0088d.f810j);
            canvas.save();
            for (int i3 = 0; i3 < c0088d.f802b.size(); i3++) {
                AbstractC0089e abstractC0089e = c0088d.f802b.get(i3);
                if (abstractC0089e instanceof C0088d) {
                    m10590a((C0088d) abstractC0089e, c0088d.f801a, canvas, i, i2, colorFilter);
                } else if (abstractC0089e instanceof AbstractC0090f) {
                    m10591a(c0088d, (AbstractC0090f) abstractC0089e, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.f830m;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.f830m = i;
        }

        /* renamed from: a */
        public void m10589a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m10590a(this.f825h, f817q, canvas, i, i2, colorFilter);
        }

        public C0091g(C0091g c0091g) {
            this.f820c = new Matrix();
            this.f826i = 0.0f;
            this.f827j = 0.0f;
            this.f828k = 0.0f;
            this.f829l = 0.0f;
            this.f830m = 255;
            this.f831n = null;
            this.f832o = null;
            this.f833p = new ArrayMap<>();
            this.f825h = new C0088d(c0091g.f825h, this.f833p);
            this.f818a = new Path(c0091g.f818a);
            this.f819b = new Path(c0091g.f819b);
            this.f826i = c0091g.f826i;
            this.f827j = c0091g.f827j;
            this.f828k = c0091g.f828k;
            this.f829l = c0091g.f829l;
            this.f824g = c0091g.f824g;
            this.f830m = c0091g.f830m;
            this.f831n = c0091g.f831n;
            String str = c0091g.f831n;
            if (str != null) {
                this.f833p.put(str, this);
            }
            this.f832o = c0091g.f832o;
        }

        /* renamed from: a */
        public final void m10591a(C0088d c0088d, AbstractC0090f abstractC0090f, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.f828k;
            float f2 = i2 / this.f829l;
            float min = Math.min(f, f2);
            Matrix matrix = c0088d.f801a;
            this.f820c.set(matrix);
            this.f820c.postScale(f, f2);
            float m10588a = m10588a(matrix);
            if (m10588a == 0.0f) {
                return;
            }
            abstractC0090f.m10595a(this.f818a);
            Path path = this.f818a;
            this.f819b.reset();
            if (abstractC0090f.mo10594b()) {
                this.f819b.addPath(path, this.f820c);
                canvas.clipPath(this.f819b);
                return;
            }
            C0087c c0087c = (C0087c) abstractC0090f;
            if (c0087c.f795k != 0.0f || c0087c.f796l != 1.0f) {
                float f3 = c0087c.f795k;
                float f4 = c0087c.f797m;
                float f5 = (f3 + f4) % 1.0f;
                float f6 = (c0087c.f796l + f4) % 1.0f;
                if (this.f823f == null) {
                    this.f823f = new PathMeasure();
                }
                this.f823f.setPath(this.f818a, false);
                float length = this.f823f.getLength();
                float f7 = f5 * length;
                float f8 = f6 * length;
                path.reset();
                if (f7 > f8) {
                    this.f823f.getSegment(f7, length, path, true);
                    this.f823f.getSegment(0.0f, f8, path, true);
                } else {
                    this.f823f.getSegment(f7, f8, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f819b.addPath(path, this.f820c);
            if (c0087c.f791g.m9978e()) {
                ComplexColorCompat complexColorCompat = c0087c.f791g;
                if (this.f822e == null) {
                    this.f822e = new Paint(1);
                    this.f822e.setStyle(Paint.Style.FILL);
                }
                Paint paint = this.f822e;
                if (complexColorCompat.m9980c()) {
                    Shader m9983b = complexColorCompat.m9983b();
                    m9983b.setLocalMatrix(this.f820c);
                    paint.setShader(m9983b);
                    paint.setAlpha(Math.round(c0087c.f794j * 255.0f));
                } else {
                    paint.setColor(VectorDrawableCompat.m10614a(complexColorCompat.m9989a(), c0087c.f794j));
                }
                paint.setColorFilter(colorFilter);
                this.f819b.setFillType(c0087c.f793i == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f819b, paint);
            }
            if (c0087c.f789e.m9978e()) {
                ComplexColorCompat complexColorCompat2 = c0087c.f789e;
                if (this.f821d == null) {
                    this.f821d = new Paint(1);
                    this.f821d.setStyle(Paint.Style.STROKE);
                }
                Paint paint2 = this.f821d;
                Paint.Join join = c0087c.f799o;
                if (join != null) {
                    paint2.setStrokeJoin(join);
                }
                Paint.Cap cap = c0087c.f798n;
                if (cap != null) {
                    paint2.setStrokeCap(cap);
                }
                paint2.setStrokeMiter(c0087c.f800p);
                if (complexColorCompat2.m9980c()) {
                    Shader m9983b2 = complexColorCompat2.m9983b();
                    m9983b2.setLocalMatrix(this.f820c);
                    paint2.setShader(m9983b2);
                    paint2.setAlpha(Math.round(c0087c.f792h * 255.0f));
                } else {
                    paint2.setColor(VectorDrawableCompat.m10614a(complexColorCompat2.m9989a(), c0087c.f792h));
                }
                paint2.setColorFilter(colorFilter);
                paint2.setStrokeWidth(c0087c.f790f * min * m10588a);
                canvas.drawPath(this.f819b, paint2);
            }
        }

        /* renamed from: a */
        public final float m10588a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float m10592a = m10592a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot(fArr[0], fArr[1]), (float) Math.hypot(fArr[2], fArr[3]));
            if (max > 0.0f) {
                return Math.abs(m10592a) / max;
            }
            return 0.0f;
        }

        /* renamed from: a */
        public boolean m10593a() {
            if (this.f832o == null) {
                this.f832o = Boolean.valueOf(this.f825h.mo10597a());
            }
            return this.f832o.booleanValue();
        }

        /* renamed from: a */
        public boolean m10587a(int[] iArr) {
            return this.f825h.mo10596a(iArr);
        }
    }

    /* renamed from: a */
    public static int m10614a(int i, float f) {
        return (i & 16777215) | (((int) (Color.alpha(i) * f)) << 24);
    }

    /* renamed from: a */
    public static PorterDuff.Mode m10613a(int i, PorterDuff.Mode mode) {
        if (i != 3) {
            if (i != 5) {
                if (i != 9) {
                    switch (i) {
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

    /* renamed from: a */
    public final void m10610a(TypedArray typedArray, XmlPullParser xmlPullParser) {
        C0092h c0092h = this.f780b;
        C0091g c0091g = c0092h.f835b;
        c0092h.f837d = m10613a(TypedArrayUtils.m9932b(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0092h.f836c = colorStateList;
        }
        c0092h.f838e = TypedArrayUtils.m9937a(typedArray, xmlPullParser, "autoMirrored", 5, c0092h.f838e);
        c0091g.f828k = TypedArrayUtils.m9939a(typedArray, xmlPullParser, "viewportWidth", 7, c0091g.f828k);
        c0091g.f829l = TypedArrayUtils.m9939a(typedArray, xmlPullParser, "viewportHeight", 8, c0091g.f829l);
        if (c0091g.f828k > 0.0f) {
            if (c0091g.f829l > 0.0f) {
                c0091g.f826i = typedArray.getDimension(3, c0091g.f826i);
                c0091g.f827j = typedArray.getDimension(2, c0091g.f827j);
                if (c0091g.f826i > 0.0f) {
                    if (c0091g.f827j > 0.0f) {
                        c0091g.setAlpha(TypedArrayUtils.m9939a(typedArray, xmlPullParser, "alpha", 4, c0091g.getAlpha()));
                        String string = typedArray.getString(0);
                        if (string != null) {
                            c0091g.f831n = string;
                            c0091g.f833p.put(string, c0091g);
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

    /* renamed from: a */
    public final void m10611a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        C0092h c0092h = this.f780b;
        C0091g c0091g = c0092h.f835b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(c0091g.f825h);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                C0088d c0088d = (C0088d) arrayDeque.peek();
                if ("path".equals(name)) {
                    C0087c c0087c = new C0087c();
                    c0087c.m10602a(resources, attributeSet, theme, xmlPullParser);
                    c0088d.f802b.add(c0087c);
                    if (c0087c.getPathName() != null) {
                        c0091g.f833p.put(c0087c.getPathName(), c0087c);
                    }
                    z = false;
                    c0092h.f834a = c0087c.f816c | c0092h.f834a;
                } else if ("clip-path".equals(name)) {
                    C0086b c0086b = new C0086b();
                    c0086b.m10606a(resources, attributeSet, theme, xmlPullParser);
                    c0088d.f802b.add(c0086b);
                    if (c0086b.getPathName() != null) {
                        c0091g.f833p.put(c0086b.getPathName(), c0086b);
                    }
                    c0092h.f834a = c0086b.f816c | c0092h.f834a;
                } else if ("group".equals(name)) {
                    C0088d c0088d2 = new C0088d();
                    c0088d2.m10600a(resources, attributeSet, theme, xmlPullParser);
                    c0088d.f802b.add(c0088d2);
                    arrayDeque.push(c0088d2);
                    if (c0088d2.getGroupName() != null) {
                        c0091g.f833p.put(c0088d2.getGroupName(), c0088d2);
                    }
                    c0092h.f834a = c0088d2.f811k | c0092h.f834a;
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

    /* renamed from: a */
    public void m10607a(boolean z) {
        this.f784f = z;
    }

    /* renamed from: a */
    public final boolean m10615a() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && DrawableCompat.m9852e(this) == 1;
    }
}
