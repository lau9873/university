package a.b.h.e.a;

import a.b.e.a.i;
import a.b.g.j.o;
import a.b.h.b.j;
import a.b.h.e.a.b;
import a.b.h.e.a.d;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: AnimatedStateListDrawableCompat.java */
/* loaded from: classes.dex */
public class a extends a.b.h.e.a.d {
    public c p;
    public g q;
    public int r;
    public int s;
    public boolean t;

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class b extends g {

        /* renamed from: a  reason: collision with root package name */
        public final Animatable f1375a;

        public b(Animatable animatable) {
            super();
            this.f1375a = animatable;
        }

        @Override // a.b.h.e.a.a.g
        public void c() {
            this.f1375a.start();
        }

        @Override // a.b.h.e.a.a.g
        public void d() {
            this.f1375a.stop();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class c extends d.a {
        public a.b.g.j.f<Long> K;
        public o<Integer> L;

        public c(c cVar, a aVar, Resources resources) {
            super(cVar, aVar, resources);
            if (cVar != null) {
                this.K = cVar.K;
                this.L = cVar.L;
                return;
            }
            this.K = new a.b.g.j.f<>();
            this.L = new o<>();
        }

        public static long f(int i2, int i3) {
            return i3 | (i2 << 32);
        }

        public int a(int i2, int i3, Drawable drawable, boolean z) {
            int a2 = super.a(drawable);
            long f2 = f(i2, i3);
            long j = z ? 8589934592L : 0L;
            long j2 = a2;
            this.K.a(f2, Long.valueOf(j2 | j));
            if (z) {
                this.K.a(f(i3, i2), Long.valueOf(4294967296L | j2 | j));
            }
            return a2;
        }

        public int b(int[] iArr) {
            int a2 = super.a(iArr);
            return a2 >= 0 ? a2 : super.a(StateSet.WILD_CARD);
        }

        public int c(int i2, int i3) {
            return (int) this.K.b(f(i2, i3), -1L).longValue();
        }

        public int d(int i2) {
            if (i2 < 0) {
                return 0;
            }
            return this.L.b(i2, 0).intValue();
        }

        public boolean e(int i2, int i3) {
            return (this.K.b(f(i2, i3), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // a.b.h.e.a.d.a, a.b.h.e.a.b.c
        public void n() {
            this.K = this.K.m5clone();
            this.L = this.L.m6clone();
        }

        @Override // a.b.h.e.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new a(this, null);
        }

        public boolean d(int i2, int i3) {
            return (this.K.b(f(i2, i3), -1L).longValue() & 4294967296L) != 0;
        }

        @Override // a.b.h.e.a.d.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new a(this, resources);
        }

        public int a(int[] iArr, Drawable drawable, int i2) {
            int a2 = super.a(iArr, drawable);
            this.L.c(a2, Integer.valueOf(i2));
            return a2;
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class d extends g {

        /* renamed from: a  reason: collision with root package name */
        public final a.b.e.a.c f1376a;

        public d(a.b.e.a.c cVar) {
            super();
            this.f1376a = cVar;
        }

        @Override // a.b.h.e.a.a.g
        public void c() {
            this.f1376a.start();
        }

        @Override // a.b.h.e.a.a.g
        public void d() {
            this.f1376a.stop();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class e extends g {

        /* renamed from: a  reason: collision with root package name */
        public final ObjectAnimator f1377a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f1378b;

        public e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i2 = z ? numberOfFrames - 1 : 0;
            int i3 = z ? 0 : numberOfFrames - 1;
            f fVar = new f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i2, i3);
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration(fVar.a());
            ofInt.setInterpolator(fVar);
            this.f1378b = z2;
            this.f1377a = ofInt;
        }

        @Override // a.b.h.e.a.a.g
        public boolean a() {
            return this.f1378b;
        }

        @Override // a.b.h.e.a.a.g
        public void b() {
            this.f1377a.reverse();
        }

        @Override // a.b.h.e.a.a.g
        public void c() {
            this.f1377a.start();
        }

        @Override // a.b.h.e.a.a.g
        public void d() {
            this.f1377a.cancel();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static abstract class g {
        public g() {
        }

        public boolean a() {
            return false;
        }

        public void b() {
        }

        public abstract void c();

        public abstract void d();
    }

    public a() {
        this(null, null);
    }

    public static a e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            a aVar = new a();
            aVar.a(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    public final boolean b(int i2) {
        int b2;
        int c2;
        g bVar;
        g gVar = this.q;
        if (gVar != null) {
            if (i2 == this.r) {
                return true;
            }
            if (i2 == this.s && gVar.a()) {
                gVar.b();
                this.r = this.s;
                this.s = i2;
                return true;
            }
            b2 = this.r;
            gVar.d();
        } else {
            b2 = b();
        }
        this.q = null;
        this.s = -1;
        this.r = -1;
        c cVar = this.p;
        int d2 = cVar.d(b2);
        int d3 = cVar.d(i2);
        if (d3 == 0 || d2 == 0 || (c2 = cVar.c(d2, d3)) < 0) {
            return false;
        }
        boolean e2 = cVar.e(d2, d3);
        a(c2);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            bVar = new e((AnimationDrawable) current, cVar.d(d2, d3), e2);
        } else if (current instanceof a.b.e.a.c) {
            bVar = new d((a.b.e.a.c) current);
        } else {
            if (current instanceof Animatable) {
                bVar = new b((Animatable) current);
            }
            return false;
        }
        bVar.c();
        this.q = bVar;
        this.s = b2;
        this.r = i2;
        return true;
    }

    public final int c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray a2 = a.b.g.b.g.g.a(resources, theme, attributeSet, j.AnimatedStateListDrawableItem);
        int resourceId = a2.getResourceId(j.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = a2.getResourceId(j.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable c2 = resourceId2 > 0 ? a.b.h.d.a.a.c(context, resourceId2) : null;
        a2.recycle();
        int[] a3 = a(attributeSet);
        if (c2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                if (xmlPullParser.getName().equals("vector")) {
                    c2 = i.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    c2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                } else {
                    c2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                }
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (c2 != null) {
            return this.p.a(a3, c2, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    public final void d() {
        onStateChange(getState());
    }

    @Override // a.b.h.e.a.d, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // a.b.h.e.a.b, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        g gVar = this.q;
        if (gVar != null) {
            gVar.d();
            this.q = null;
            a(this.r);
            this.r = -1;
            this.s = -1;
        }
    }

    @Override // a.b.h.e.a.d, a.b.h.e.a.b, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.t) {
            super.mutate();
            if (this == this) {
                this.p.n();
                this.t = true;
            }
        }
        return this;
    }

    @Override // a.b.h.e.a.d, a.b.h.e.a.b, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int b2 = this.p.b(iArr);
        boolean z = b2 != b() && (b(b2) || a(b2));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    @Override // a.b.h.e.a.b, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.q != null && (visible || z2)) {
            if (z) {
                this.q.c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public a(c cVar, Resources resources) {
        super(null);
        this.r = -1;
        this.s = -1;
        a(new c(cVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    public final int d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray a2 = a.b.g.b.g.g.a(resources, theme, attributeSet, j.AnimatedStateListDrawableTransition);
        int resourceId = a2.getResourceId(j.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = a2.getResourceId(j.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = a2.getResourceId(j.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable c2 = resourceId3 > 0 ? a.b.h.d.a.a.c(context, resourceId3) : null;
        boolean z = a2.getBoolean(j.AnimatedStateListDrawableTransition_android_reversible, false);
        a2.recycle();
        if (c2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                if (xmlPullParser.getName().equals("animated-vector")) {
                    c2 = a.b.e.a.c.a(context, resources, xmlPullParser, attributeSet, theme);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    c2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                } else {
                    c2 = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                }
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (c2 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.p.a(resourceId, resourceId2, c2, z);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    public void a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray a2 = a.b.g.b.g.g.a(resources, theme, attributeSet, j.AnimatedStateListDrawableCompat);
        setVisible(a2.getBoolean(j.AnimatedStateListDrawableCompat_android_visible, true), true);
        a(a2);
        a(resources);
        a2.recycle();
        b(context, resources, xmlPullParser, attributeSet, theme);
        d();
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* loaded from: classes.dex */
    public static class f implements TimeInterpolator {

        /* renamed from: a  reason: collision with root package name */
        public int[] f1379a;

        /* renamed from: b  reason: collision with root package name */
        public int f1380b;

        /* renamed from: c  reason: collision with root package name */
        public int f1381c;

        public f(AnimationDrawable animationDrawable, boolean z) {
            a(animationDrawable, z);
        }

        public int a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f1380b = numberOfFrames;
            int[] iArr = this.f1379a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f1379a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f1379a;
            int i2 = 0;
            for (int i3 = 0; i3 < numberOfFrames; i3++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i3) - 1 : i3);
                iArr2[i3] = duration;
                i2 += duration;
            }
            this.f1381c = i2;
            return i2;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            int i2 = (int) ((f2 * this.f1381c) + 0.5f);
            int i3 = this.f1380b;
            int[] iArr = this.f1379a;
            int i4 = 0;
            while (i4 < i3 && i2 >= iArr[i4]) {
                i2 -= iArr[i4];
                i4++;
            }
            return (i4 / i3) + (i4 < i3 ? i2 / this.f1381c : 0.0f);
        }

        public int a() {
            return this.f1381c;
        }
    }

    public final void a(TypedArray typedArray) {
        c cVar = this.p;
        if (Build.VERSION.SDK_INT >= 21) {
            cVar.f1396d |= typedArray.getChangingConfigurations();
        }
        cVar.b(typedArray.getBoolean(j.AnimatedStateListDrawableCompat_android_variablePadding, cVar.f1401i));
        cVar.a(typedArray.getBoolean(j.AnimatedStateListDrawableCompat_android_constantSize, cVar.l));
        cVar.b(typedArray.getInt(j.AnimatedStateListDrawableCompat_android_enterFadeDuration, cVar.A));
        cVar.c(typedArray.getInt(j.AnimatedStateListDrawableCompat_android_exitFadeDuration, cVar.B));
        setDither(typedArray.getBoolean(j.AnimatedStateListDrawableCompat_android_dither, cVar.x));
    }

    @Override // a.b.h.e.a.d, a.b.h.e.a.b
    public c a() {
        return new c(this.p, this, null);
    }

    @Override // a.b.h.e.a.d, a.b.h.e.a.b
    public void a(b.c cVar) {
        super.a(cVar);
        if (cVar instanceof c) {
            this.p = (c) cVar;
        }
    }

    public final void b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    c(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    d(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }
}
