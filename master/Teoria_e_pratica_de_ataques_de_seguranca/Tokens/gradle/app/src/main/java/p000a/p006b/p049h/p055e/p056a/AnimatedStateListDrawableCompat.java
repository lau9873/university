package p000a.p006b.p049h.p055e.p056a;

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
import p000a.p006b.p027e.p028a.AnimatedVectorDrawableCompat;
import p000a.p006b.p027e.p028a.VectorDrawableCompat;
import p000a.p006b.p030g.p032b.p033g.TypedArrayUtils;
import p000a.p006b.p030g.p044j.LongSparseArray;
import p000a.p006b.p030g.p044j.SparseArrayCompat;
import p000a.p006b.p049h.p051b.C0363j;
import p000a.p006b.p049h.p053d.p054a.AppCompatResources;
import p000a.p006b.p049h.p055e.p056a.DrawableContainer;
import p000a.p006b.p049h.p055e.p056a.StateListDrawable;

/* renamed from: a.b.h.e.a.a */
/* loaded from: classes.dex */
public class AnimatedStateListDrawableCompat extends StateListDrawable {

    /* renamed from: p */
    public C0372c f2048p;

    /* renamed from: q */
    public AbstractC0376g f2049q;

    /* renamed from: r */
    public int f2050r;

    /* renamed from: s */
    public int f2051s;

    /* renamed from: t */
    public boolean f2052t;

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: a.b.h.e.a.a$b */
    /* loaded from: classes.dex */
    public static class C0371b extends AbstractC0376g {

        /* renamed from: a */
        public final Animatable f2053a;

        public C0371b(Animatable animatable) {
            super();
            this.f2053a = animatable;
        }

        @Override // p000a.p006b.p049h.p055e.p056a.AnimatedStateListDrawableCompat.AbstractC0376g
        /* renamed from: c */
        public void mo8944c() {
            this.f2053a.start();
        }

        @Override // p000a.p006b.p049h.p055e.p056a.AnimatedStateListDrawableCompat.AbstractC0376g
        /* renamed from: d */
        public void mo8943d() {
            this.f2053a.stop();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: a.b.h.e.a.a$c */
    /* loaded from: classes.dex */
    public static class C0372c extends StateListDrawable.C0380a {

        /* renamed from: K */
        public LongSparseArray<Long> f2054K;

        /* renamed from: L */
        public SparseArrayCompat<Integer> f2055L;

        public C0372c(C0372c c0372c, AnimatedStateListDrawableCompat animatedStateListDrawableCompat, Resources resources) {
            super(c0372c, animatedStateListDrawableCompat, resources);
            if (c0372c != null) {
                this.f2054K = c0372c.f2054K;
                this.f2055L = c0372c.f2055L;
                return;
            }
            this.f2054K = new LongSparseArray<>();
            this.f2055L = new SparseArrayCompat<>();
        }

        /* renamed from: f */
        public static long m8949f(int i, int i2) {
            return i2 | (i << 32);
        }

        /* renamed from: a */
        public int m8956a(int i, int i2, Drawable drawable, boolean z) {
            int m8929a = super.m8929a(drawable);
            long m8949f = m8949f(i, i2);
            long j = z ? 8589934592L : 0L;
            long j2 = m8929a;
            this.f2054K.m9662a(m8949f, Long.valueOf(j2 | j));
            if (z) {
                this.f2054K.m9662a(m8949f(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return m8929a;
        }

        /* renamed from: b */
        public int m8954b(int[] iArr) {
            int m8904a = super.m8904a(iArr);
            return m8904a >= 0 ? m8904a : super.m8904a(StateSet.WILD_CARD);
        }

        /* renamed from: c */
        public int m8953c(int i, int i2) {
            return (int) this.f2054K.m9658b(m8949f(i, i2), -1L).longValue();
        }

        /* renamed from: d */
        public int m8952d(int i) {
            if (i < 0) {
                return 0;
            }
            return this.f2055L.m9601b(i, 0).intValue();
        }

        /* renamed from: e */
        public boolean m8950e(int i, int i2) {
            return (this.f2054K.m9658b(m8949f(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // p000a.p006b.p049h.p055e.p056a.StateListDrawable.C0380a, p000a.p006b.p049h.p055e.p056a.DrawableContainer.AbstractC0379c
        /* renamed from: n */
        public void mo8902n() {
            this.f2054K = this.f2054K.m11328clone();
            this.f2055L = this.f2055L.m11329clone();
        }

        @Override // p000a.p006b.p049h.p055e.p056a.StateListDrawable.C0380a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        /* renamed from: d */
        public boolean m8951d(int i, int i2) {
            return (this.f2054K.m9658b(m8949f(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        @Override // p000a.p006b.p049h.p055e.p056a.StateListDrawable.C0380a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new AnimatedStateListDrawableCompat(this, resources);
        }

        /* renamed from: a */
        public int m8955a(int[] iArr, Drawable drawable, int i) {
            int m8903a = super.m8903a(iArr, drawable);
            this.f2055L.m9598c(m8903a, Integer.valueOf(i));
            return m8903a;
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: a.b.h.e.a.a$d */
    /* loaded from: classes.dex */
    public static class C0373d extends AbstractC0376g {

        /* renamed from: a */
        public final AnimatedVectorDrawableCompat f2056a;

        public C0373d(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super();
            this.f2056a = animatedVectorDrawableCompat;
        }

        @Override // p000a.p006b.p049h.p055e.p056a.AnimatedStateListDrawableCompat.AbstractC0376g
        /* renamed from: c */
        public void mo8944c() {
            this.f2056a.start();
        }

        @Override // p000a.p006b.p049h.p055e.p056a.AnimatedStateListDrawableCompat.AbstractC0376g
        /* renamed from: d */
        public void mo8943d() {
            this.f2056a.stop();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: a.b.h.e.a.a$e */
    /* loaded from: classes.dex */
    public static class C0374e extends AbstractC0376g {

        /* renamed from: a */
        public final ObjectAnimator f2057a;

        /* renamed from: b */
        public final boolean f2058b;

        public C0374e(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            C0375f c0375f = new C0375f(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration(c0375f.m8948a());
            ofInt.setInterpolator(c0375f);
            this.f2058b = z2;
            this.f2057a = ofInt;
        }

        @Override // p000a.p006b.p049h.p055e.p056a.AnimatedStateListDrawableCompat.AbstractC0376g
        /* renamed from: a */
        public boolean mo8946a() {
            return this.f2058b;
        }

        @Override // p000a.p006b.p049h.p055e.p056a.AnimatedStateListDrawableCompat.AbstractC0376g
        /* renamed from: b */
        public void mo8945b() {
            this.f2057a.reverse();
        }

        @Override // p000a.p006b.p049h.p055e.p056a.AnimatedStateListDrawableCompat.AbstractC0376g
        /* renamed from: c */
        public void mo8944c() {
            this.f2057a.start();
        }

        @Override // p000a.p006b.p049h.p055e.p056a.AnimatedStateListDrawableCompat.AbstractC0376g
        /* renamed from: d */
        public void mo8943d() {
            this.f2057a.cancel();
        }
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: a.b.h.e.a.a$g */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0376g {
        public AbstractC0376g() {
        }

        /* renamed from: a */
        public boolean mo8946a() {
            return false;
        }

        /* renamed from: b */
        public void mo8945b() {
        }

        /* renamed from: c */
        public abstract void mo8944c();

        /* renamed from: d */
        public abstract void mo8943d();
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    /* renamed from: e */
    public static AnimatedStateListDrawableCompat m8957e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            AnimatedStateListDrawableCompat animatedStateListDrawableCompat = new AnimatedStateListDrawableCompat();
            animatedStateListDrawableCompat.m8964a(context, resources, xmlPullParser, attributeSet, theme);
            return animatedStateListDrawableCompat;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    /* renamed from: b */
    public final boolean m8962b(int i) {
        int m8937b;
        int m8953c;
        AbstractC0376g c0371b;
        AbstractC0376g abstractC0376g = this.f2049q;
        if (abstractC0376g != null) {
            if (i == this.f2050r) {
                return true;
            }
            if (i == this.f2051s && abstractC0376g.mo8946a()) {
                abstractC0376g.mo8945b();
                this.f2050r = this.f2051s;
                this.f2051s = i;
                return true;
            }
            m8937b = this.f2050r;
            abstractC0376g.mo8943d();
        } else {
            m8937b = m8937b();
        }
        this.f2049q = null;
        this.f2051s = -1;
        this.f2050r = -1;
        C0372c c0372c = this.f2048p;
        int m8952d = c0372c.m8952d(m8937b);
        int m8952d2 = c0372c.m8952d(i);
        if (m8952d2 == 0 || m8952d == 0 || (m8953c = c0372c.m8953c(m8952d, m8952d2)) < 0) {
            return false;
        }
        boolean m8950e = c0372c.m8950e(m8952d, m8952d2);
        m8942a(m8953c);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            c0371b = new C0374e((AnimationDrawable) current, c0372c.m8951d(m8952d, m8952d2), m8950e);
        } else if (current instanceof AnimatedVectorDrawableCompat) {
            c0371b = new C0373d((AnimatedVectorDrawableCompat) current);
        } else {
            if (current instanceof Animatable) {
                c0371b = new C0371b((Animatable) current);
            }
            return false;
        }
        c0371b.mo8944c();
        this.f2049q = c0371b;
        this.f2051s = m8937b;
        this.f2050r = i;
        return true;
    }

    /* renamed from: c */
    public final int m8960c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray m9945a = TypedArrayUtils.m9945a(resources, theme, attributeSet, C0363j.AnimatedStateListDrawableItem);
        int resourceId = m9945a.getResourceId(C0363j.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = m9945a.getResourceId(C0363j.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable m8967c = resourceId2 > 0 ? AppCompatResources.m8967c(context, resourceId2) : null;
        m9945a.recycle();
        int[] m8906a = m8906a(attributeSet);
        if (m8967c == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                if (xmlPullParser.getName().equals("vector")) {
                    m8967c = VectorDrawableCompat.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    m8967c = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                } else {
                    m8967c = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                }
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (m8967c != null) {
            return this.f2048p.m8955a(m8906a, m8967c, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    /* renamed from: d */
    public final void m8959d() {
        onStateChange(getState());
    }

    @Override // p000a.p006b.p049h.p055e.p056a.StateListDrawable, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // p000a.p006b.p049h.p055e.p056a.DrawableContainer, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        AbstractC0376g abstractC0376g = this.f2049q;
        if (abstractC0376g != null) {
            abstractC0376g.mo8943d();
            this.f2049q = null;
            m8942a(this.f2050r);
            this.f2050r = -1;
            this.f2051s = -1;
        }
    }

    @Override // p000a.p006b.p049h.p055e.p056a.StateListDrawable, p000a.p006b.p049h.p055e.p056a.DrawableContainer, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f2052t) {
            super.mutate();
            if (this == this) {
                this.f2048p.mo8902n();
                this.f2052t = true;
            }
        }
        return this;
    }

    @Override // p000a.p006b.p049h.p055e.p056a.StateListDrawable, p000a.p006b.p049h.p055e.p056a.DrawableContainer, android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        int m8954b = this.f2048p.m8954b(iArr);
        boolean z = m8954b != m8937b() && (m8962b(m8954b) || m8942a(m8954b));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    @Override // p000a.p006b.p049h.p055e.p056a.DrawableContainer, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.f2049q != null && (visible || z2)) {
            if (z) {
                this.f2049q.mo8944c();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public AnimatedStateListDrawableCompat(C0372c c0372c, Resources resources) {
        super(null);
        this.f2050r = -1;
        this.f2051s = -1;
        mo8907a(new C0372c(c0372c, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* renamed from: d */
    public final int m8958d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray m9945a = TypedArrayUtils.m9945a(resources, theme, attributeSet, C0363j.AnimatedStateListDrawableTransition);
        int resourceId = m9945a.getResourceId(C0363j.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = m9945a.getResourceId(C0363j.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = m9945a.getResourceId(C0363j.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable m8967c = resourceId3 > 0 ? AppCompatResources.m8967c(context, resourceId3) : null;
        boolean z = m9945a.getBoolean(C0363j.AnimatedStateListDrawableTransition_android_reversible, false);
        m9945a.recycle();
        if (m8967c == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                if (xmlPullParser.getName().equals("animated-vector")) {
                    m8967c = AnimatedVectorDrawableCompat.m10645a(context, resources, xmlPullParser, attributeSet, theme);
                } else if (Build.VERSION.SDK_INT >= 21) {
                    m8967c = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
                } else {
                    m8967c = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                }
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (m8967c == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.f2048p.m8956a(resourceId, resourceId2, m8967c, z);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    /* renamed from: a */
    public void m8964a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray m9945a = TypedArrayUtils.m9945a(resources, theme, attributeSet, C0363j.AnimatedStateListDrawableCompat);
        setVisible(m9945a.getBoolean(C0363j.AnimatedStateListDrawableCompat_android_visible, true), true);
        m8963a(m9945a);
        m8941a(resources);
        m9945a.recycle();
        m8961b(context, resources, xmlPullParser, attributeSet, theme);
        m8959d();
    }

    /* compiled from: AnimatedStateListDrawableCompat.java */
    /* renamed from: a.b.h.e.a.a$f */
    /* loaded from: classes.dex */
    public static class C0375f implements TimeInterpolator {

        /* renamed from: a */
        public int[] f2059a;

        /* renamed from: b */
        public int f2060b;

        /* renamed from: c */
        public int f2061c;

        public C0375f(AnimationDrawable animationDrawable, boolean z) {
            m8947a(animationDrawable, z);
        }

        /* renamed from: a */
        public int m8947a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f2060b = numberOfFrames;
            int[] iArr = this.f2059a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f2059a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f2059a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.f2061c = i;
            return i;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) ((f * this.f2061c) + 0.5f);
            int i2 = this.f2060b;
            int[] iArr = this.f2059a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.f2061c : 0.0f);
        }

        /* renamed from: a */
        public int m8948a() {
            return this.f2061c;
        }
    }

    /* renamed from: a */
    public final void m8963a(TypedArray typedArray) {
        C0372c c0372c = this.f2048p;
        if (Build.VERSION.SDK_INT >= 21) {
            c0372c.f2088d |= typedArray.getChangingConfigurations();
        }
        c0372c.m8923b(typedArray.getBoolean(C0363j.AnimatedStateListDrawableCompat_android_variablePadding, c0372c.f2093i));
        c0372c.m8928a(typedArray.getBoolean(C0363j.AnimatedStateListDrawableCompat_android_constantSize, c0372c.f2096l));
        c0372c.m8926b(typedArray.getInt(C0363j.AnimatedStateListDrawableCompat_android_enterFadeDuration, c0372c.f2076A));
        c0372c.m8921c(typedArray.getInt(C0363j.AnimatedStateListDrawableCompat_android_exitFadeDuration, c0372c.f2077B));
        setDither(typedArray.getBoolean(C0363j.AnimatedStateListDrawableCompat_android_dither, c0372c.f2108x));
    }

    @Override // p000a.p006b.p049h.p055e.p056a.StateListDrawable, p000a.p006b.p049h.p055e.p056a.DrawableContainer
    /* renamed from: a */
    public C0372c mo8908a() {
        return new C0372c(this.f2048p, this, null);
    }

    @Override // p000a.p006b.p049h.p055e.p056a.StateListDrawable, p000a.p006b.p049h.p055e.p056a.DrawableContainer
    /* renamed from: a */
    public void mo8907a(DrawableContainer.AbstractC0379c abstractC0379c) {
        super.mo8907a(abstractC0379c);
        if (abstractC0379c instanceof C0372c) {
            this.f2048p = (C0372c) abstractC0379c;
        }
    }

    /* renamed from: b */
    public final void m8961b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
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
                    m8960c(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    m8958d(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }
}
