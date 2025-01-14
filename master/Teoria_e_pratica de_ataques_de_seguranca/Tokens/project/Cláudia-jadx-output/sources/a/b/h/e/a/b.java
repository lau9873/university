package a.b.h.e.a;

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
/* compiled from: DrawableContainer.java */
/* loaded from: classes.dex */
public class b extends Drawable implements Drawable.Callback {

    /* renamed from: a  reason: collision with root package name */
    public c f1382a;

    /* renamed from: b  reason: collision with root package name */
    public Rect f1383b;

    /* renamed from: c  reason: collision with root package name */
    public Drawable f1384c;

    /* renamed from: d  reason: collision with root package name */
    public Drawable f1385d;

    /* renamed from: f  reason: collision with root package name */
    public boolean f1387f;

    /* renamed from: h  reason: collision with root package name */
    public boolean f1389h;

    /* renamed from: i  reason: collision with root package name */
    public Runnable f1390i;
    public long j;
    public long k;
    public C0039b m;

    /* renamed from: e  reason: collision with root package name */
    public int f1386e = 255;

    /* renamed from: g  reason: collision with root package name */
    public int f1388g = -1;

    /* compiled from: DrawableContainer.java */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b.this.a(true);
            b.this.invalidateSelf();
        }
    }

    /* compiled from: DrawableContainer.java */
    /* renamed from: a.b.h.e.a.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0039b implements Drawable.Callback {

        /* renamed from: a  reason: collision with root package name */
        public Drawable.Callback f1392a;

        public C0039b a(Drawable.Callback callback) {
            this.f1392a = callback;
            return this;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            Drawable.Callback callback = this.f1392a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            Drawable.Callback callback = this.f1392a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        public Drawable.Callback a() {
            Drawable.Callback callback = this.f1392a;
            this.f1392a = null;
            return callback;
        }
    }

    public c a() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(int r10) {
        /*
            r9 = this;
            int r0 = r9.f1388g
            r1 = 0
            if (r10 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            a.b.h.e.a.b$c r0 = r9.f1382a
            int r0 = r0.B
            r4 = 0
            r5 = 0
            if (r0 <= 0) goto L2e
            android.graphics.drawable.Drawable r0 = r9.f1385d
            if (r0 == 0) goto L1a
            r0.setVisible(r1, r1)
        L1a:
            android.graphics.drawable.Drawable r0 = r9.f1384c
            if (r0 == 0) goto L29
            r9.f1385d = r0
            a.b.h.e.a.b$c r0 = r9.f1382a
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r9.k = r0
            goto L35
        L29:
            r9.f1385d = r4
            r9.k = r5
            goto L35
        L2e:
            android.graphics.drawable.Drawable r0 = r9.f1384c
            if (r0 == 0) goto L35
            r0.setVisible(r1, r1)
        L35:
            if (r10 < 0) goto L55
            a.b.h.e.a.b$c r0 = r9.f1382a
            int r1 = r0.f1400h
            if (r10 >= r1) goto L55
            android.graphics.drawable.Drawable r0 = r0.a(r10)
            r9.f1384c = r0
            r9.f1388g = r10
            if (r0 == 0) goto L5a
            a.b.h.e.a.b$c r10 = r9.f1382a
            int r10 = r10.A
            if (r10 <= 0) goto L51
            long r7 = (long) r10
            long r2 = r2 + r7
            r9.j = r2
        L51:
            r9.a(r0)
            goto L5a
        L55:
            r9.f1384c = r4
            r10 = -1
            r9.f1388g = r10
        L5a:
            long r0 = r9.j
            r10 = 1
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 != 0) goto L67
            long r0 = r9.k
            int r2 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r2 == 0) goto L79
        L67:
            java.lang.Runnable r0 = r9.f1390i
            if (r0 != 0) goto L73
            a.b.h.e.a.b$a r0 = new a.b.h.e.a.b$a
            r0.<init>()
            r9.f1390i = r0
            goto L76
        L73:
            r9.unscheduleSelf(r0)
        L76:
            r9.a(r10)
        L79:
            r9.invalidateSelf()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.h.e.a.b.a(int):boolean");
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f1382a.a(theme);
    }

    public int b() {
        return this.f1388g;
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(23)
    public final boolean c() {
        return isAutoMirrored() && getLayoutDirection() == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f1382a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f1384c;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f1385d;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f1386e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f1382a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (this.f1382a.a()) {
            this.f1382a.f1396d = getChangingConfigurations();
            return this.f1382a;
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f1384c;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        Rect rect2 = this.f1383b;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f1382a.m()) {
            return this.f1382a.f();
        }
        Drawable drawable = this.f1384c;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f1382a.m()) {
            return this.f1382a.j();
        }
        Drawable drawable = this.f1384c;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f1382a.m()) {
            return this.f1382a.g();
        }
        Drawable drawable = this.f1384c;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f1382a.m()) {
            return this.f1382a.h();
        }
        Drawable drawable = this.f1384c;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f1384c;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f1382a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        Drawable drawable = this.f1384c;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect i2 = this.f1382a.i();
        if (i2 != null) {
            rect.set(i2);
            padding = (i2.right | ((i2.left | i2.top) | i2.bottom)) != 0;
        } else {
            Drawable drawable = this.f1384c;
            if (drawable != null) {
                padding = drawable.getPadding(rect);
            } else {
                padding = super.getPadding(rect);
            }
        }
        if (c()) {
            int i3 = rect.left;
            rect.left = rect.right;
            rect.right = i3;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        c cVar = this.f1382a;
        if (cVar != null) {
            cVar.l();
        }
        if (drawable != this.f1384c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f1382a.C;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f1385d;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f1385d = null;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f1384c;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f1387f) {
                this.f1384c.setAlpha(this.f1386e);
            }
        }
        if (this.k != 0) {
            this.k = 0L;
            z = true;
        }
        if (this.j != 0) {
            this.j = 0L;
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f1389h && super.mutate() == this) {
            c a2 = a();
            a2.n();
            a(a2);
            this.f1389h = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f1385d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f1384c;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        return this.f1382a.b(i2, b());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i2) {
        Drawable drawable = this.f1385d;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f1384c;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f1385d;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f1384c;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.f1384c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.f1387f && this.f1386e == i2) {
            return;
        }
        this.f1387f = true;
        this.f1386e = i2;
        Drawable drawable = this.f1384c;
        if (drawable != null) {
            if (this.j == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        c cVar = this.f1382a;
        if (cVar.C != z) {
            cVar.C = z;
            Drawable drawable = this.f1384c;
            if (drawable != null) {
                a.b.g.c.j.a.a(drawable, cVar.C);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        c cVar = this.f1382a;
        cVar.E = true;
        if (cVar.D != colorFilter) {
            cVar.D = colorFilter;
            Drawable drawable = this.f1384c;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        c cVar = this.f1382a;
        if (cVar.x != z) {
            cVar.x = z;
            Drawable drawable = this.f1384c;
            if (drawable != null) {
                drawable.setDither(cVar.x);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f1384c;
        if (drawable != null) {
            a.b.g.c.j.a.a(drawable, f2, f3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.f1383b;
        if (rect == null) {
            this.f1383b = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f1384c;
        if (drawable != null) {
            a.b.g.c.j.a.a(drawable, i2, i3, i4, i5);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        c cVar = this.f1382a;
        cVar.H = true;
        if (cVar.F != colorStateList) {
            cVar.F = colorStateList;
            a.b.g.c.j.a.a(this.f1384c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        c cVar = this.f1382a;
        cVar.I = true;
        if (cVar.G != mode) {
            cVar.G = mode;
            a.b.g.c.j.a.a(this.f1384c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f1385d;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f1384c;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f1384c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    /* compiled from: DrawableContainer.java */
    /* loaded from: classes.dex */
    public static abstract class c extends Drawable.ConstantState {
        public int A;
        public int B;
        public boolean C;
        public ColorFilter D;
        public boolean E;
        public ColorStateList F;
        public PorterDuff.Mode G;
        public boolean H;
        public boolean I;

        /* renamed from: a  reason: collision with root package name */
        public final b f1393a;

        /* renamed from: b  reason: collision with root package name */
        public Resources f1394b;

        /* renamed from: c  reason: collision with root package name */
        public int f1395c;

        /* renamed from: d  reason: collision with root package name */
        public int f1396d;

        /* renamed from: e  reason: collision with root package name */
        public int f1397e;

        /* renamed from: f  reason: collision with root package name */
        public SparseArray<Drawable.ConstantState> f1398f;

        /* renamed from: g  reason: collision with root package name */
        public Drawable[] f1399g;

        /* renamed from: h  reason: collision with root package name */
        public int f1400h;

        /* renamed from: i  reason: collision with root package name */
        public boolean f1401i;
        public boolean j;
        public Rect k;
        public boolean l;
        public boolean m;
        public int n;
        public int o;
        public int p;
        public int q;
        public boolean r;
        public int s;
        public boolean t;
        public boolean u;
        public boolean v;
        public boolean w;
        public boolean x;
        public boolean y;
        public int z;

        public c(c cVar, b bVar, Resources resources) {
            Resources resources2;
            this.f1395c = 160;
            this.f1401i = false;
            this.l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.f1393a = bVar;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = cVar != null ? cVar.f1394b : null;
            }
            this.f1394b = resources2;
            this.f1395c = b.a(resources, cVar != null ? cVar.f1395c : 0);
            if (cVar != null) {
                this.f1396d = cVar.f1396d;
                this.f1397e = cVar.f1397e;
                this.v = true;
                this.w = true;
                this.f1401i = cVar.f1401i;
                this.l = cVar.l;
                this.x = cVar.x;
                this.y = cVar.y;
                this.z = cVar.z;
                this.A = cVar.A;
                this.B = cVar.B;
                this.C = cVar.C;
                this.D = cVar.D;
                this.E = cVar.E;
                this.F = cVar.F;
                this.G = cVar.G;
                this.H = cVar.H;
                this.I = cVar.I;
                if (cVar.f1395c == this.f1395c) {
                    if (cVar.j) {
                        this.k = new Rect(cVar.k);
                        this.j = true;
                    }
                    if (cVar.m) {
                        this.n = cVar.n;
                        this.o = cVar.o;
                        this.p = cVar.p;
                        this.q = cVar.q;
                        this.m = true;
                    }
                }
                if (cVar.r) {
                    this.s = cVar.s;
                    this.r = true;
                }
                if (cVar.t) {
                    this.u = cVar.u;
                    this.t = true;
                }
                Drawable[] drawableArr = cVar.f1399g;
                this.f1399g = new Drawable[drawableArr.length];
                this.f1400h = cVar.f1400h;
                SparseArray<Drawable.ConstantState> sparseArray = cVar.f1398f;
                if (sparseArray != null) {
                    this.f1398f = sparseArray.clone();
                } else {
                    this.f1398f = new SparseArray<>(this.f1400h);
                }
                int i2 = this.f1400h;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null) {
                        Drawable.ConstantState constantState = drawableArr[i3].getConstantState();
                        if (constantState != null) {
                            this.f1398f.put(i3, constantState);
                        } else {
                            this.f1399g[i3] = drawableArr[i3];
                        }
                    }
                }
                return;
            }
            this.f1399g = new Drawable[10];
            this.f1400h = 0;
        }

        public final int a(Drawable drawable) {
            int i2 = this.f1400h;
            if (i2 >= this.f1399g.length) {
                a(i2, i2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f1393a);
            this.f1399g[i2] = drawable;
            this.f1400h++;
            this.f1397e = drawable.getChangingConfigurations() | this.f1397e;
            l();
            this.k = null;
            this.j = false;
            this.m = false;
            this.v = false;
            return i2;
        }

        public final Drawable b(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f1393a);
            return mutate;
        }

        public final void c() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f1398f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f1399g[this.f1398f.keyAt(i2)] = b(this.f1398f.valueAt(i2).newDrawable(this.f1394b));
                }
                this.f1398f = null;
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i2 = this.f1400h;
            Drawable[] drawableArr = this.f1399g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable != null) {
                    if (drawable.canApplyTheme()) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = this.f1398f.get(i3);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                }
            }
            return false;
        }

        public final int d() {
            return this.f1399g.length;
        }

        public final int e() {
            return this.f1400h;
        }

        public final int f() {
            if (!this.m) {
                b();
            }
            return this.o;
        }

        public final int g() {
            if (!this.m) {
                b();
            }
            return this.q;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f1396d | this.f1397e;
        }

        public final int h() {
            if (!this.m) {
                b();
            }
            return this.p;
        }

        public final Rect i() {
            if (this.f1401i) {
                return null;
            }
            if (this.k == null && !this.j) {
                c();
                Rect rect = new Rect();
                int i2 = this.f1400h;
                Drawable[] drawableArr = this.f1399g;
                Rect rect2 = null;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3].getPadding(rect)) {
                        if (rect2 == null) {
                            rect2 = new Rect(0, 0, 0, 0);
                        }
                        int i4 = rect.left;
                        if (i4 > rect2.left) {
                            rect2.left = i4;
                        }
                        int i5 = rect.top;
                        if (i5 > rect2.top) {
                            rect2.top = i5;
                        }
                        int i6 = rect.right;
                        if (i6 > rect2.right) {
                            rect2.right = i6;
                        }
                        int i7 = rect.bottom;
                        if (i7 > rect2.bottom) {
                            rect2.bottom = i7;
                        }
                    }
                }
                this.j = true;
                this.k = rect2;
                return rect2;
            }
            return this.k;
        }

        public final int j() {
            if (!this.m) {
                b();
            }
            return this.n;
        }

        public final int k() {
            if (this.r) {
                return this.s;
            }
            c();
            int i2 = this.f1400h;
            Drawable[] drawableArr = this.f1399g;
            int opacity = i2 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i3 = 1; i3 < i2; i3++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
            }
            this.s = opacity;
            this.r = true;
            return opacity;
        }

        public void l() {
            this.r = false;
            this.t = false;
        }

        public final boolean m() {
            return this.l;
        }

        public abstract void n();

        public final boolean b(int i2, int i3) {
            int i4 = this.f1400h;
            Drawable[] drawableArr = this.f1399g;
            boolean z = false;
            for (int i5 = 0; i5 < i4; i5++) {
                if (drawableArr[i5] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i5].setLayoutDirection(i2) : false;
                    if (i5 == i3) {
                        z = layoutDirection;
                    }
                }
            }
            this.z = i2;
            return z;
        }

        public final void c(int i2) {
            this.B = i2;
        }

        public final void b(boolean z) {
            this.f1401i = z;
        }

        public void b() {
            this.m = true;
            c();
            int i2 = this.f1400h;
            Drawable[] drawableArr = this.f1399g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.n) {
                    this.n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                    this.o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.p) {
                    this.p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.q) {
                    this.q = minimumHeight;
                }
            }
        }

        public final Drawable a(int i2) {
            int indexOfKey;
            Drawable drawable = this.f1399g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f1398f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable b2 = b(this.f1398f.valueAt(indexOfKey).newDrawable(this.f1394b));
            this.f1399g[i2] = b2;
            this.f1398f.removeAt(indexOfKey);
            if (this.f1398f.size() == 0) {
                this.f1398f = null;
            }
            return b2;
        }

        public final void a(Resources resources) {
            if (resources != null) {
                this.f1394b = resources;
                int a2 = b.a(resources, this.f1395c);
                int i2 = this.f1395c;
                this.f1395c = a2;
                if (i2 != a2) {
                    this.m = false;
                    this.j = false;
                }
            }
        }

        public final void b(int i2) {
            this.A = i2;
        }

        public final void a(Resources.Theme theme) {
            if (theme != null) {
                c();
                int i2 = this.f1400h;
                Drawable[] drawableArr = this.f1399g;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null && drawableArr[i3].canApplyTheme()) {
                        drawableArr[i3].applyTheme(theme);
                        this.f1397e |= drawableArr[i3].getChangingConfigurations();
                    }
                }
                a(theme.getResources());
            }
        }

        public final void a(boolean z) {
            this.l = z;
        }

        public void a(int i2, int i3) {
            Drawable[] drawableArr = new Drawable[i3];
            System.arraycopy(this.f1399g, 0, drawableArr, 0, i2);
            this.f1399g = drawableArr;
        }

        public synchronized boolean a() {
            if (this.v) {
                return this.w;
            }
            c();
            this.v = true;
            int i2 = this.f1400h;
            Drawable[] drawableArr = this.f1399g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getConstantState() == null) {
                    this.w = false;
                    return false;
                }
            }
            this.w = true;
            return true;
        }
    }

    public final void a(Drawable drawable) {
        if (this.m == null) {
            this.m = new C0039b();
        }
        C0039b c0039b = this.m;
        c0039b.a(drawable.getCallback());
        drawable.setCallback(c0039b);
        try {
            if (this.f1382a.A <= 0 && this.f1387f) {
                drawable.setAlpha(this.f1386e);
            }
            if (this.f1382a.E) {
                drawable.setColorFilter(this.f1382a.D);
            } else {
                if (this.f1382a.H) {
                    a.b.g.c.j.a.a(drawable, this.f1382a.F);
                }
                if (this.f1382a.I) {
                    a.b.g.c.j.a.a(drawable, this.f1382a.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f1382a.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f1382a.C);
            }
            Rect rect = this.f1383b;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.m.a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f1387f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f1384c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L38
            long r9 = r13.j
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f1386e
            r3.setAlpha(r9)
            r13.j = r7
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            a.b.h.e.a.b$c r9 = r13.f1382a
            int r9 = r9.A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f1386e
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.j = r7
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.f1385d
            if (r9 == 0) goto L65
            long r10 = r13.k
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L67
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L52
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f1385d = r0
            r13.k = r7
            goto L67
        L52:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            a.b.h.e.a.b$c r4 = r13.f1382a
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.f1386e
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L68
        L65:
            r13.k = r7
        L67:
            r0 = r3
        L68:
            if (r14 == 0) goto L74
            if (r0 == 0) goto L74
            java.lang.Runnable r14 = r13.f1390i
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L74:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.h.e.a.b.a(boolean):void");
    }

    public final void a(Resources resources) {
        this.f1382a.a(resources);
    }

    public void a(c cVar) {
        this.f1382a = cVar;
        int i2 = this.f1388g;
        if (i2 >= 0) {
            this.f1384c = cVar.a(i2);
            Drawable drawable = this.f1384c;
            if (drawable != null) {
                a(drawable);
            }
        }
        this.f1385d = null;
    }

    public static int a(Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        if (i2 == 0) {
            return 160;
        }
        return i2;
    }
}
