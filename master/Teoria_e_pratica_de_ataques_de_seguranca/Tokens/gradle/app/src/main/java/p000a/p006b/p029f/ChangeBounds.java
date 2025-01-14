package p000a.p006b.p029f;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import p000a.p006b.p030g.p045k.ViewCompat;

/* renamed from: a.b.f.c */
/* loaded from: classes.dex */
public class ChangeBounds extends Transition {

    /* renamed from: N */
    public static final String[] f853N = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: O */
    public static final Property<Drawable, PointF> f854O = new C0097b(PointF.class, "boundsOrigin");

    /* renamed from: P */
    public static final Property<C0106k, PointF> f855P = new C0098c(PointF.class, "topLeft");

    /* renamed from: Q */
    public static final Property<C0106k, PointF> f856Q = new C0099d(PointF.class, "bottomRight");

    /* renamed from: R */
    public static final Property<View, PointF> f857R = new C0100e(PointF.class, "bottomRight");

    /* renamed from: S */
    public static final Property<View, PointF> f858S = new C0101f(PointF.class, "topLeft");

    /* renamed from: T */
    public static final Property<View, PointF> f859T = new C0102g(PointF.class, "position");

    /* renamed from: U */
    public static RectEvaluator f860U = new RectEvaluator();

    /* renamed from: K */
    public int[] f861K = new int[2];

    /* renamed from: L */
    public boolean f862L = false;

    /* renamed from: M */
    public boolean f863M = false;

    /* compiled from: ChangeBounds.java */
    /* renamed from: a.b.f.c$a */
    /* loaded from: classes.dex */
    public class C0096a extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ ViewGroup f864a;

        /* renamed from: b */
        public final /* synthetic */ BitmapDrawable f865b;

        /* renamed from: c */
        public final /* synthetic */ View f866c;

        /* renamed from: d */
        public final /* synthetic */ float f867d;

        public C0096a(ChangeBounds changeBounds, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f) {
            this.f864a = viewGroup;
            this.f865b = bitmapDrawable;
            this.f866c = view;
            this.f867d = f;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C0109d0.m10539b(this.f864a).mo10426b(this.f865b);
            C0109d0.m10543a(this.f866c, this.f867d);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: a.b.f.c$c */
    /* loaded from: classes.dex */
    public static class C0098c extends Property<C0106k, PointF> {
        public C0098c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(C0106k c0106k) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(C0106k c0106k, PointF pointF) {
            c0106k.m10548b(pointF);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: a.b.f.c$d */
    /* loaded from: classes.dex */
    public static class C0099d extends Property<C0106k, PointF> {
        public C0099d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(C0106k c0106k) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(C0106k c0106k, PointF pointF) {
            c0106k.m10549a(pointF);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: a.b.f.c$e */
    /* loaded from: classes.dex */
    public static class C0100e extends Property<View, PointF> {
        public C0100e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, PointF pointF) {
            C0109d0.m10541a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: a.b.f.c$f */
    /* loaded from: classes.dex */
    public static class C0101f extends Property<View, PointF> {
        public C0101f(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, PointF pointF) {
            C0109d0.m10541a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: a.b.f.c$g */
    /* loaded from: classes.dex */
    public static class C0102g extends Property<View, PointF> {
        public C0102g(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(View view, PointF pointF) {
            int round = Math.round(pointF.x);
            int round2 = Math.round(pointF.y);
            C0109d0.m10541a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: a.b.f.c$h */
    /* loaded from: classes.dex */
    public class C0103h extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ C0106k f869a;
        public C0106k mViewBounds;

        public C0103h(ChangeBounds changeBounds, C0106k c0106k) {
            this.f869a = c0106k;
            this.mViewBounds = this.f869a;
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: a.b.f.c$i */
    /* loaded from: classes.dex */
    public class C0104i extends AnimatorListenerAdapter {

        /* renamed from: a */
        public boolean f870a;

        /* renamed from: b */
        public final /* synthetic */ View f871b;

        /* renamed from: c */
        public final /* synthetic */ Rect f872c;

        /* renamed from: d */
        public final /* synthetic */ int f873d;

        /* renamed from: e */
        public final /* synthetic */ int f874e;

        /* renamed from: f */
        public final /* synthetic */ int f875f;

        /* renamed from: g */
        public final /* synthetic */ int f876g;

        public C0104i(ChangeBounds changeBounds, View view, Rect rect, int i, int i2, int i3, int i4) {
            this.f871b = view;
            this.f872c = rect;
            this.f873d = i;
            this.f874e = i2;
            this.f875f = i3;
            this.f876g = i4;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f870a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f870a) {
                return;
            }
            ViewCompat.m9448a(this.f871b, this.f872c);
            C0109d0.m10541a(this.f871b, this.f873d, this.f874e, this.f875f, this.f876g);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: a.b.f.c$j */
    /* loaded from: classes.dex */
    public class C0105j extends TransitionListenerAdapter {

        /* renamed from: a */
        public boolean f877a = false;

        /* renamed from: b */
        public final /* synthetic */ ViewGroup f878b;

        public C0105j(ChangeBounds changeBounds, ViewGroup viewGroup) {
            this.f878b = viewGroup;
        }

        @Override // p000a.p006b.p029f.TransitionListenerAdapter, p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: a */
        public void mo10466a(Transition transition) {
            ViewGroupUtils.m10422a(this.f878b, false);
        }

        @Override // p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: b */
        public void mo10433b(Transition transition) {
            if (!this.f877a) {
                ViewGroupUtils.m10422a(this.f878b, false);
            }
            transition.mo10442b(this);
        }

        @Override // p000a.p006b.p029f.TransitionListenerAdapter, p000a.p006b.p029f.Transition.InterfaceC0125f
        /* renamed from: d */
        public void mo10465d(Transition transition) {
            ViewGroupUtils.m10422a(this.f878b, true);
        }
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public void mo10449a(TransitionValues transitionValues) {
        m10563d(transitionValues);
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: c */
    public void mo10440c(TransitionValues transitionValues) {
        m10563d(transitionValues);
    }

    /* renamed from: d */
    public final void m10563d(TransitionValues transitionValues) {
        View view = transitionValues.f1000b;
        if (!ViewCompat.m9409x(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        transitionValues.f999a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        transitionValues.f999a.put("android:changeBounds:parent", transitionValues.f1000b.getParent());
        if (this.f863M) {
            transitionValues.f1000b.getLocationInWindow(this.f861K);
            transitionValues.f999a.put("android:changeBounds:windowX", Integer.valueOf(this.f861K[0]));
            transitionValues.f999a.put("android:changeBounds:windowY", Integer.valueOf(this.f861K[1]));
        }
        if (this.f862L) {
            transitionValues.f999a.put("android:changeBounds:clip", ViewCompat.m9432e(view));
        }
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: o */
    public String[] mo10470o() {
        return f853N;
    }

    /* renamed from: a */
    public final boolean m10564a(View view, View view2) {
        if (this.f863M) {
            TransitionValues m10482b = m10482b(view, true);
            if (m10482b == null) {
                if (view == view2) {
                    return true;
                }
            } else if (view2 == m10482b.f1000b) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: a.b.f.c$b */
    /* loaded from: classes.dex */
    public static class C0097b extends Property<Drawable, PointF> {

        /* renamed from: a */
        public Rect f868a;

        public C0097b(Class cls, String str) {
            super(cls, str);
            this.f868a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f868a);
            this.f868a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f868a);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f868a);
            Rect rect = this.f868a;
            return new PointF(rect.left, rect.top);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: a.b.f.c$k */
    /* loaded from: classes.dex */
    public static class C0106k {

        /* renamed from: a */
        public int f879a;

        /* renamed from: b */
        public int f880b;

        /* renamed from: c */
        public int f881c;

        /* renamed from: d */
        public int f882d;

        /* renamed from: e */
        public View f883e;

        /* renamed from: f */
        public int f884f;

        /* renamed from: g */
        public int f885g;

        public C0106k(View view) {
            this.f883e = view;
        }

        /* renamed from: a */
        public void m10549a(PointF pointF) {
            this.f881c = Math.round(pointF.x);
            this.f882d = Math.round(pointF.y);
            this.f885g++;
            if (this.f884f == this.f885g) {
                m10550a();
            }
        }

        /* renamed from: b */
        public void m10548b(PointF pointF) {
            this.f879a = Math.round(pointF.x);
            this.f880b = Math.round(pointF.y);
            this.f884f++;
            if (this.f884f == this.f885g) {
                m10550a();
            }
        }

        /* renamed from: a */
        public final void m10550a() {
            C0109d0.m10541a(this.f883e, this.f879a, this.f880b, this.f881c, this.f882d);
            this.f884f = 0;
            this.f885g = 0;
        }
    }

    @Override // p000a.p006b.p029f.Transition
    /* renamed from: a */
    public Animator mo10488a(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        int i;
        View view;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator m10431a;
        if (transitionValues == null || transitionValues2 == null) {
            return null;
        }
        Map<String, Object> map = transitionValues.f999a;
        Map<String, Object> map2 = transitionValues2.f999a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = transitionValues2.f1000b;
        if (m10564a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) transitionValues.f999a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) transitionValues2.f999a.get("android:changeBounds:bounds");
            int i3 = rect2.left;
            int i4 = rect3.left;
            int i5 = rect2.top;
            int i6 = rect3.top;
            int i7 = rect2.right;
            int i8 = rect3.right;
            int i9 = rect2.bottom;
            int i10 = rect3.bottom;
            int i11 = i7 - i3;
            int i12 = i9 - i5;
            int i13 = i8 - i4;
            int i14 = i10 - i6;
            Rect rect4 = (Rect) transitionValues.f999a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) transitionValues2.f999a.get("android:changeBounds:clip");
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                i = 0;
            } else {
                i = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (i7 != i8 || i9 != i10) {
                    i++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i > 0) {
                if (!this.f862L) {
                    view = view2;
                    C0109d0.m10541a(view, i3, i5, i7, i9);
                    if (i == 2) {
                        if (i11 == i13 && i12 == i14) {
                            m10431a = ObjectAnimatorUtils.m10527a(view, f859T, m10477f().mo10467a(i3, i5, i4, i6));
                        } else {
                            C0106k c0106k = new C0106k(view);
                            ObjectAnimator m10527a = ObjectAnimatorUtils.m10527a(c0106k, f855P, m10477f().mo10467a(i3, i5, i4, i6));
                            ObjectAnimator m10527a2 = ObjectAnimatorUtils.m10527a(c0106k, f856Q, m10477f().mo10467a(i7, i9, i8, i10));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(m10527a, m10527a2);
                            animatorSet.addListener(new C0103h(this, c0106k));
                            m10431a = animatorSet;
                        }
                    } else if (i3 == i4 && i5 == i6) {
                        m10431a = ObjectAnimatorUtils.m10527a(view, f857R, m10477f().mo10467a(i7, i9, i8, i10));
                    } else {
                        m10431a = ObjectAnimatorUtils.m10527a(view, f858S, m10477f().mo10467a(i3, i5, i4, i6));
                    }
                } else {
                    view = view2;
                    C0109d0.m10541a(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                    ObjectAnimator m10527a3 = (i3 == i4 && i5 == i6) ? null : ObjectAnimatorUtils.m10527a(view, f859T, m10477f().mo10467a(i3, i5, i4, i6));
                    if (rect4 == null) {
                        i2 = 0;
                        rect = new Rect(0, 0, i11, i12);
                    } else {
                        i2 = 0;
                        rect = rect4;
                    }
                    Rect rect6 = rect5 == null ? new Rect(i2, i2, i13, i14) : rect5;
                    if (rect.equals(rect6)) {
                        objectAnimator = null;
                    } else {
                        ViewCompat.m9448a(view, rect);
                        RectEvaluator rectEvaluator = f860U;
                        Object[] objArr = new Object[2];
                        objArr[i2] = rect;
                        objArr[1] = rect6;
                        objectAnimator = ObjectAnimator.ofObject(view, "clipBounds", rectEvaluator, objArr);
                        objectAnimator.addListener(new C0104i(this, view, rect5, i4, i6, i8, i10));
                    }
                    m10431a = TransitionUtils.m10431a(m10527a3, objectAnimator);
                }
                if (view.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    ViewGroupUtils.m10422a(viewGroup4, true);
                    mo10452a(new C0105j(this, viewGroup4));
                }
                return m10431a;
            }
            return null;
        }
        int intValue = ((Integer) transitionValues.f999a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) transitionValues.f999a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) transitionValues2.f999a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) transitionValues2.f999a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.f861K);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float m10537c = C0109d0.m10537c(view2);
        C0109d0.m10543a(view2, 0.0f);
        C0109d0.m10539b(viewGroup).mo10427a(bitmapDrawable);
        PathMotion m10477f = m10477f();
        int[] iArr = this.f861K;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, PropertyValuesHolderUtils.m10515a(f854O, m10477f.mo10467a(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
        ofPropertyValuesHolder.addListener(new C0096a(this, viewGroup, bitmapDrawable, view2, m10537c));
        return ofPropertyValuesHolder;
    }
}
