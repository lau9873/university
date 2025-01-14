package p000a.p006b.p049h.p055e.p056a;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import p000a.p006b.p030g.p034c.p035j.DrawableCompat;

/* renamed from: a.b.h.e.a.b */
/* loaded from: classes.dex */
public class DrawableContainer extends Drawable implements Drawable.Callback {

    /* renamed from: a */
    public AbstractC0379c f2062a;

    /* renamed from: b */
    public Rect f2063b;

    /* renamed from: c */
    public Drawable f2064c;

    /* renamed from: d */
    public Drawable f2065d;

    /* renamed from: f */
    public boolean f2067f;

    /* renamed from: h */
    public boolean f2069h;

    /* renamed from: i */
    public Runnable f2070i;

    /* renamed from: j */
    public long f2071j;

    /* renamed from: k */
    public long f2072k;

    /* renamed from: m */
    public C0378b f2073m;

    /* renamed from: e */
    public int f2066e = 255;

    /* renamed from: g */
    public int f2068g = -1;

    /* compiled from: DrawableContainer.java */
    /* renamed from: a.b.h.e.a.b$a */
    /* loaded from: classes.dex */
    public class RunnableC0377a implements Runnable {
        public RunnableC0377a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DrawableContainer.this.m8938a(true);
            DrawableContainer.this.invalidateSelf();
        }
    }

    /* compiled from: DrawableContainer.java */
    /* renamed from: a.b.h.e.a.b$b */
    /* loaded from: classes.dex */
    public static class C0378b implements Drawable.Callback {

        /* renamed from: a */
        public Drawable.Callback f2075a;

        /* renamed from: a */
        public C0378b m8934a(Drawable.Callback callback) {
            this.f2075a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.f2075a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f2075a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        /* renamed from: a */
        public Drawable.Callback m8935a() {
            Drawable.Callback callback = this.f2075a;
            this.f2075a = null;
            return callback;
        }
    }

    /* renamed from: a */
    public AbstractC0379c mo8908a() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m8942a(int r10) {
        /*
            r9 = this;
            int r0 = r9.f2068g
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            a.b.h.e.a.b$c r0 = r9.f2062a
            int r0 = r0.f2077B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f2065d
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f2064c
            if (r0 == 0) goto L29
            r9.f2065d = r0
            a.b.h.e.a.b$c r0 = r9.f2062a
            int r0 = r0.f2077B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.f2072k = r0
            goto L35
        L29:
            r9.f2065d = r4
            r9.f2072k = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f2064c
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            a.b.h.e.a.b$c r0 = r9.f2062a
            int r1 = r0.f2092h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.m8932a(r10)
            r9.f2064c = r0
            r9.f2068g = r10
            if (r0 == 0) goto L5a
            a.b.h.e.a.b$c r10 = r9.f2062a
            int r10 = r10.f2076A
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.f2071j = r2
        L51:
            r9.m8939a(r0)
            goto L5a
        L55:
            r9.f2064c = r4
            r10 = -1
            r9.f2068g = r10
        L5a:
            long r0 = r9.f2071j
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L67
            long r0 = r9.f2072k
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L79
        L67:
            java.lang.Runnable r0 = r9.f2070i
            if (r0 != 0) goto L73
            a.b.h.e.a.b$a r0 = new a.b.h.e.a.b$a
            r0.<init>()
            r9.f2070i = r0
            goto L76
        L73:
            r9.unscheduleSelf(r0)
        L76:
            r9.m8938a(r10)
        L79:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p049h.p055e.p056a.DrawableContainer.m8942a(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f2062a.m8931a(theme);
    }

    /* renamed from: b */
    public int m8937b() {
        return this.f2068g;
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(23)
    /* renamed from: c */
    public final boolean m8936c() {
        return isAutoMirrored() && getLayoutDirection() == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f2062a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f2064c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f2065d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2066e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f2062a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f2062a.m8933a()) {
            this.f2062a.f2088d = getChangingConfigurations();
            return this.f2062a;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f2064c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f2063b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f2062a.m8911m()) {
            return this.f2062a.m8918f();
        }
        Drawable drawable = this.f2064c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f2062a.m8911m()) {
            return this.f2062a.m8914j();
        }
        Drawable drawable = this.f2064c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f2062a.m8911m()) {
            return this.f2062a.m8917g();
        }
        Drawable drawable = this.f2064c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f2062a.m8911m()) {
            return this.f2062a.m8916h();
        }
        Drawable drawable = this.f2064c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f2064c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f2062a.m8913k();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f2064c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect m8915i = this.f2062a.m8915i();
        if (m8915i != null) {
            rect.set(m8915i);
            padding = (m8915i.right | ((m8915i.left | m8915i.top) | m8915i.bottom)) != 0;
        } else {
            Drawable drawable = this.f2064c;
            if (drawable != null) {
                padding = drawable.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if (m8936c()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        AbstractC0379c abstractC0379c = this.f2062a;
        if (abstractC0379c != null) {
            abstractC0379c.m8912l();
        }
        if (drawable != this.f2064c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f2062a.f2078C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f2065d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f2065d = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f2064c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f2067f) {
                this.f2064c.setAlpha(this.f2066e);
            }
        }
        if (this.f2072k != 0) {
            this.f2072k = 0L;
            z = true;
        }
        if (this.f2071j != 0) {
            this.f2071j = 0L;
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f2069h && super.mutate() == this) {
            AbstractC0379c mo8908a = mo8908a();
            mo8908a.mo8902n();
            mo8907a(mo8908a);
            this.f2069h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f2065d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f2064c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return this.f2062a.m8925b(i, m8937b());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        Drawable drawable = this.f2065d;
        if (drawable != null) {
            return drawable.setLevel(i);
        }
        Drawable drawable2 = this.f2064c;
        if (drawable2 != null) {
            return drawable2.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f2065d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f2064c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.f2064c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f2067f && this.f2066e == i) {
            return;
        }
        this.f2067f = true;
        this.f2066e = i;
        Drawable drawable = this.f2064c;
        if (drawable != null) {
            if (this.f2071j == 0) {
                drawable.setAlpha(i);
            } else {
                m8938a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        AbstractC0379c abstractC0379c = this.f2062a;
        if (abstractC0379c.f2078C != z) {
            abstractC0379c.f2078C = z;
            Drawable drawable = this.f2064c;
            if (drawable != null) {
                DrawableCompat.m9857a(drawable, abstractC0379c.f2078C);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        AbstractC0379c abstractC0379c = this.f2062a;
        abstractC0379c.f2080E = true;
        if (abstractC0379c.f2079D != colorFilter) {
            abstractC0379c.f2079D = colorFilter;
            Drawable drawable = this.f2064c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        AbstractC0379c abstractC0379c = this.f2062a;
        if (abstractC0379c.f2108x != z) {
            abstractC0379c.f2108x = z;
            Drawable drawable = this.f2064c;
            if (drawable != null) {
                drawable.setDither(abstractC0379c.f2108x);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        Drawable drawable = this.f2064c;
        if (drawable != null) {
            DrawableCompat.m9864a(drawable, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        Rect rect = this.f2063b;
        if (rect == null) {
            this.f2063b = new Rect(i, i2, i3, i4);
        } else {
            rect.set(i, i2, i3, i4);
        }
        Drawable drawable = this.f2064c;
        if (drawable != null) {
            DrawableCompat.m9862a(drawable, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        AbstractC0379c abstractC0379c = this.f2062a;
        abstractC0379c.f2083H = true;
        if (abstractC0379c.f2081F != colorStateList) {
            abstractC0379c.f2081F = colorStateList;
            DrawableCompat.m9861a(this.f2064c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        AbstractC0379c abstractC0379c = this.f2062a;
        abstractC0379c.f2084I = true;
        if (abstractC0379c.f2082G != mode) {
            abstractC0379c.f2082G = mode;
            DrawableCompat.m9858a(this.f2064c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f2065d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f2064c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f2064c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    /* compiled from: DrawableContainer.java */
    /* renamed from: a.b.h.e.a.b$c */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0379c extends Drawable.ConstantState {

        /* renamed from: A */
        public int f2076A;

        /* renamed from: B */
        public int f2077B;

        /* renamed from: C */
        public boolean f2078C;

        /* renamed from: D */
        public ColorFilter f2079D;

        /* renamed from: E */
        public boolean f2080E;

        /* renamed from: F */
        public ColorStateList f2081F;

        /* renamed from: G */
        public PorterDuff.Mode f2082G;

        /* renamed from: H */
        public boolean f2083H;

        /* renamed from: I */
        public boolean f2084I;

        /* renamed from: a */
        public final DrawableContainer f2085a;

        /* renamed from: b */
        public Resources f2086b;

        /* renamed from: c */
        public int f2087c;

        /* renamed from: d */
        public int f2088d;

        /* renamed from: e */
        public int f2089e;

        /* renamed from: f */
        public SparseArray<Drawable.ConstantState> f2090f;

        /* renamed from: g */
        public Drawable[] f2091g;

        /* renamed from: h */
        public int f2092h;

        /* renamed from: i */
        public boolean f2093i;

        /* renamed from: j */
        public boolean f2094j;

        /* renamed from: k */
        public Rect f2095k;

        /* renamed from: l */
        public boolean f2096l;

        /* renamed from: m */
        public boolean f2097m;

        /* renamed from: n */
        public int f2098n;

        /* renamed from: o */
        public int f2099o;

        /* renamed from: p */
        public int f2100p;

        /* renamed from: q */
        public int f2101q;

        /* renamed from: r */
        public boolean f2102r;

        /* renamed from: s */
        public int f2103s;

        /* renamed from: t */
        public boolean f2104t;

        /* renamed from: u */
        public boolean f2105u;

        /* renamed from: v */
        public boolean f2106v;

        /* renamed from: w */
        public boolean f2107w;

        /* renamed from: x */
        public boolean f2108x;

        /* renamed from: y */
        public boolean f2109y;

        /* renamed from: z */
        public int f2110z;

        public AbstractC0379c(AbstractC0379c abstractC0379c, DrawableContainer drawableContainer, Resources resources) {
            Resources resources2;
            this.f2087c = 160;
            this.f2093i = false;
            this.f2096l = false;
            this.f2108x = true;
            this.f2076A = 0;
            this.f2077B = 0;
            this.f2085a = drawableContainer;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = abstractC0379c != null ? abstractC0379c.f2086b : null;
            }
            this.f2086b = resources2;
            this.f2087c = DrawableContainer.m8940a(resources, abstractC0379c != null ? abstractC0379c.f2087c : 0);
            if (abstractC0379c != null) {
                this.f2088d = abstractC0379c.f2088d;
                this.f2089e = abstractC0379c.f2089e;
                this.f2106v = true;
                this.f2107w = true;
                this.f2093i = abstractC0379c.f2093i;
                this.f2096l = abstractC0379c.f2096l;
                this.f2108x = abstractC0379c.f2108x;
                this.f2109y = abstractC0379c.f2109y;
                this.f2110z = abstractC0379c.f2110z;
                this.f2076A = abstractC0379c.f2076A;
                this.f2077B = abstractC0379c.f2077B;
                this.f2078C = abstractC0379c.f2078C;
                this.f2079D = abstractC0379c.f2079D;
                this.f2080E = abstractC0379c.f2080E;
                this.f2081F = abstractC0379c.f2081F;
                this.f2082G = abstractC0379c.f2082G;
                this.f2083H = abstractC0379c.f2083H;
                this.f2084I = abstractC0379c.f2084I;
                if (abstractC0379c.f2087c == this.f2087c) {
                    if (abstractC0379c.f2094j) {
                        this.f2095k = new Rect(abstractC0379c.f2095k);
                        this.f2094j = true;
                    }
                    if (abstractC0379c.f2097m) {
                        this.f2098n = abstractC0379c.f2098n;
                        this.f2099o = abstractC0379c.f2099o;
                        this.f2100p = abstractC0379c.f2100p;
                        this.f2101q = abstractC0379c.f2101q;
                        this.f2097m = true;
                    }
                }
                if (abstractC0379c.f2102r) {
                    this.f2103s = abstractC0379c.f2103s;
                    this.f2102r = true;
                }
                if (abstractC0379c.f2104t) {
                    this.f2105u = abstractC0379c.f2105u;
                    this.f2104t = true;
                }
                Drawable[] drawableArr = abstractC0379c.f2091g;
                this.f2091g = new Drawable[drawableArr.length];
                this.f2092h = abstractC0379c.f2092h;
                SparseArray<Drawable.ConstantState> sparseArray = abstractC0379c.f2090f;
                if (sparseArray != null) {
                    this.f2090f = sparseArray.clone();
                } else {
                    this.f2090f = new SparseArray<>(this.f2092h);
                }
                int i = this.f2092h;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null) {
                        Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                        if (constantState != null) {
                            this.f2090f.put(i2, constantState);
                        } else {
                            this.f2091g[i2] = drawableArr[i2];
                        }
                    }
                }
                return;
            }
            this.f2091g = new Drawable[10];
            this.f2092h = 0;
        }

        /* renamed from: a */
        public final int m8929a(Drawable drawable) {
            int i = this.f2092h;
            if (i >= this.f2091g.length) {
                mo8905a(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f2085a);
            this.f2091g[i] = drawable;
            this.f2092h++;
            this.f2089e = drawable.getChangingConfigurations() | this.f2089e;
            m8912l();
            this.f2095k = null;
            this.f2094j = false;
            this.f2097m = false;
            this.f2106v = false;
            return i;
        }

        /* renamed from: b */
        public final Drawable m8924b(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.f2110z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f2085a);
            return mutate;
        }

        /* renamed from: c */
        public final void m8922c() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f2090f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i = 0; i < size; i++) {
                    this.f2091g[this.f2090f.keyAt(i)] = m8924b(this.f2090f.valueAt(i).newDrawable(this.f2086b));
                }
                this.f2090f = null;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i = this.f2092h;
            Drawable[] drawableArr = this.f2091g;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    if (drawable.canApplyTheme()) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = this.f2090f.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* renamed from: d */
        public final int m8920d() {
            return this.f2091g.length;
        }

        /* renamed from: e */
        public final int m8919e() {
            return this.f2092h;
        }

        /* renamed from: f */
        public final int m8918f() {
            if (!this.f2097m) {
                m8927b();
            }
            return this.f2099o;
        }

        /* renamed from: g */
        public final int m8917g() {
            if (!this.f2097m) {
                m8927b();
            }
            return this.f2101q;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2088d | this.f2089e;
        }

        /* renamed from: h */
        public final int m8916h() {
            if (!this.f2097m) {
                m8927b();
            }
            return this.f2100p;
        }

        /* renamed from: i */
        public final Rect m8915i() {
            if (this.f2093i) {
                return null;
            }
            if (this.f2095k == null && !this.f2094j) {
                m8922c();
                Rect rect = new Rect();
                int i = this.f2092h;
                Drawable[] drawableArr = this.f2091g;
                Rect rect2 = null;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2].getPadding(rect)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i3 = rect.left;
                        if (i3 > rect2.left) {
                            rect2.left = i3;
                        }
                        int i4 = rect.top;
                        if (i4 > rect2.top) {
                            rect2.top = i4;
                        }
                        int i5 = rect.right;
                        if (i5 > rect2.right) {
                            rect2.right = i5;
                        }
                        int i6 = rect.bottom;
                        if (i6 > rect2.bottom) {
                            rect2.bottom = i6;
                        }
                    }
                }
                this.f2094j = true;
                this.f2095k = rect2;
                return rect2;
            }
            return this.f2095k;
        }

        /* renamed from: j */
        public final int m8914j() {
            if (!this.f2097m) {
                m8927b();
            }
            return this.f2098n;
        }

        /* renamed from: k */
        public final int m8913k() {
            if (this.f2102r) {
                return this.f2103s;
            }
            m8922c();
            int i = this.f2092h;
            Drawable[] drawableArr = this.f2091g;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.f2103s = opacity;
            this.f2102r = true;
            return opacity;
        }

        /* renamed from: l */
        public void m8912l() {
            this.f2102r = false;
            this.f2104t = false;
        }

        /* renamed from: m */
        public final boolean m8911m() {
            return this.f2096l;
        }

        /* renamed from: n */
        public abstract void mo8902n();

        /* renamed from: b */
        public final boolean m8925b(int i, int i2) {
            int i3 = this.f2092h;
            Drawable[] drawableArr = this.f2091g;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                    if (i4 == i2) {
                        z = layoutDirection;
                    }
                }
            }
            this.f2110z = i;
            return z;
        }

        /* renamed from: c */
        public final void m8921c(int i) {
            this.f2077B = i;
        }

        /* renamed from: b */
        public final void m8923b(boolean z) {
            this.f2093i = z;
        }

        /* renamed from: b */
        public void m8927b() {
            this.f2097m = true;
            m8922c();
            int i = this.f2092h;
            Drawable[] drawableArr = this.f2091g;
            this.f2099o = -1;
            this.f2098n = -1;
            this.f2101q = 0;
            this.f2100p = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f2098n) {
                    this.f2098n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f2099o) {
                    this.f2099o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f2100p) {
                    this.f2100p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f2101q) {
                    this.f2101q = minimumHeight;
                }
            }
        }

        /* renamed from: a */
        public final Drawable m8932a(int i) {
            int indexOfKey;
            Drawable drawable = this.f2091g[i];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f2090f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable m8924b = m8924b(this.f2090f.valueAt(indexOfKey).newDrawable(this.f2086b));
            this.f2091g[i] = m8924b;
            this.f2090f.removeAt(indexOfKey);
            if (this.f2090f.size() == 0) {
                this.f2090f = null;
            }
            return m8924b;
        }

        /* renamed from: a */
        public final void m8930a(Resources resources) {
            if (resources != null) {
                this.f2086b = resources;
                int m8940a = DrawableContainer.m8940a(resources, this.f2087c);
                int i = this.f2087c;
                this.f2087c = m8940a;
                if (i != m8940a) {
                    this.f2097m = false;
                    this.f2094j = false;
                }
            }
        }

        /* renamed from: b */
        public final void m8926b(int i) {
            this.f2076A = i;
        }

        /* renamed from: a */
        public final void m8931a(Resources.Theme theme) {
            if (theme != null) {
                m8922c();
                int i = this.f2092h;
                Drawable[] drawableArr = this.f2091g;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                        drawableArr[i2].applyTheme(theme);
                        this.f2089e |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                m8930a(theme.getResources());
            }
        }

        /* renamed from: a */
        public final void m8928a(boolean z) {
            this.f2096l = z;
        }

        /* renamed from: a */
        public void mo8905a(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            System.arraycopy(this.f2091g, 0, drawableArr, 0, i);
            this.f2091g = drawableArr;
        }

        /* renamed from: a */
        public synchronized boolean m8933a() {
            if (this.f2106v) {
                return this.f2107w;
            }
            m8922c();
            this.f2106v = true;
            int i = this.f2092h;
            Drawable[] drawableArr = this.f2091g;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.f2107w = false;
                    return false;
                }
            }
            this.f2107w = true;
            return true;
        }
    }

    /* renamed from: a */
    public final void m8939a(Drawable drawable) {
        if (this.f2073m == null) {
            this.f2073m = new C0378b();
        }
        C0378b c0378b = this.f2073m;
        c0378b.m8934a(drawable.getCallback());
        drawable.setCallback(c0378b);
        try {
            if (this.f2062a.f2076A <= 0 && this.f2067f) {
                drawable.setAlpha(this.f2066e);
            }
            if (this.f2062a.f2080E) {
                drawable.setColorFilter(this.f2062a.f2079D);
            } else {
                if (this.f2062a.f2083H) {
                    DrawableCompat.m9861a(drawable, this.f2062a.f2081F);
                }
                if (this.f2062a.f2084I) {
                    DrawableCompat.m9858a(drawable, this.f2062a.f2082G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f2062a.f2108x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f2062a.f2078C);
            }
            Rect rect = this.f2063b;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f2073m.m8935a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m8938a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f2067f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f2064c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L38
            long r9 = r13.f2071j
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f2066e
            r3.setAlpha(r9)
            r13.f2071j = r7
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            a.b.h.e.a.b$c r9 = r13.f2062a
            int r9 = r9.f2076A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f2066e
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.f2071j = r7
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.f2065d
            if (r9 == 0) goto L65
            long r10 = r13.f2072k
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L67
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L52
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f2065d = r0
            r13.f2072k = r7
            goto L67
        L52:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            a.b.h.e.a.b$c r4 = r13.f2062a
            int r4 = r4.f2077B
            int r3 = r3 / r4
            int r4 = r13.f2066e
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L68
        L65:
            r13.f2072k = r7
        L67:
            r0 = r3
        L68:
            if (r14 == 0) goto L74
            if (r0 == 0) goto L74
            java.lang.Runnable r14 = r13.f2070i
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p049h.p055e.p056a.DrawableContainer.m8938a(boolean):void");
    }

    /* renamed from: a */
    public final void m8941a(Resources resources) {
        this.f2062a.m8930a(resources);
    }

    /* renamed from: a */
    public void mo8907a(AbstractC0379c abstractC0379c) {
        this.f2062a = abstractC0379c;
        int i = this.f2068g;
        if (i >= 0) {
            this.f2064c = abstractC0379c.m8932a(i);
            Drawable drawable = this.f2064c;
            if (drawable != null) {
                m8939a(drawable);
            }
        }
        this.f2065d = null;
    }

    /* renamed from: a */
    public static int m8940a(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        if (i == 0) {
            return 160;
        }
        return i;
    }
}
