package a.b.f;

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
/* compiled from: ChangeBounds.java */
/* loaded from: classes.dex */
public class c extends m {
    public static final String[] N = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final Property<Drawable, PointF> O = new b(PointF.class, "boundsOrigin");
    public static final Property<k, PointF> P = new C0012c(PointF.class, "topLeft");
    public static final Property<k, PointF> Q = new d(PointF.class, "bottomRight");
    public static final Property<View, PointF> R = new e(PointF.class, "bottomRight");
    public static final Property<View, PointF> S = new f(PointF.class, "topLeft");
    public static final Property<View, PointF> T = new g(PointF.class, "position");
    public static a.b.f.k U = new a.b.f.k();
    public int[] K = new int[2];
    public boolean L = false;
    public boolean M = false;

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    public class a extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f485a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ BitmapDrawable f486b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f487c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ float f488d;

        public a(c cVar, ViewGroup viewGroup, BitmapDrawable bitmapDrawable, View view, float f2) {
            this.f485a = viewGroup;
            this.f486b = bitmapDrawable;
            this.f487c = view;
            this.f488d = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d0.b(this.f485a).b(this.f486b);
            d0.a(this.f487c, this.f488d);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* renamed from: a.b.f.c$c  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0012c extends Property<k, PointF> {
        public C0012c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(k kVar, PointF pointF) {
            kVar.b(pointF);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    public static class d extends Property<k, PointF> {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(k kVar) {
            return null;
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(k kVar, PointF pointF) {
            kVar.a(pointF);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    public static class e extends Property<View, PointF> {
        public e(Class cls, String str) {
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
            d0.a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    public static class f extends Property<View, PointF> {
        public f(Class cls, String str) {
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
            d0.a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    public static class g extends Property<View, PointF> {
        public g(Class cls, String str) {
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
            d0.a(view, round, round2, view.getWidth() + round, view.getHeight() + round2);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    public class h extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ k f490a;
        public k mViewBounds;

        public h(c cVar, k kVar) {
            this.f490a = kVar;
            this.mViewBounds = this.f490a;
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    public class i extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        public boolean f491a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f492b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Rect f493c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f494d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f495e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f496f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ int f497g;

        public i(c cVar, View view, Rect rect, int i2, int i3, int i4, int i5) {
            this.f492b = view;
            this.f493c = rect;
            this.f494d = i2;
            this.f495e = i3;
            this.f496f = i4;
            this.f497g = i5;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f491a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.f491a) {
                return;
            }
            a.b.g.k.u.a(this.f492b, this.f493c);
            d0.a(this.f492b, this.f494d, this.f495e, this.f496f, this.f497g);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    public class j extends n {

        /* renamed from: a  reason: collision with root package name */
        public boolean f498a = false;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f499b;

        public j(c cVar, ViewGroup viewGroup) {
            this.f499b = viewGroup;
        }

        @Override // a.b.f.n, a.b.f.m.f
        public void a(m mVar) {
            x.a(this.f499b, false);
        }

        @Override // a.b.f.m.f
        public void b(m mVar) {
            if (!this.f498a) {
                x.a(this.f499b, false);
            }
            mVar.b(this);
        }

        @Override // a.b.f.n, a.b.f.m.f
        public void d(m mVar) {
            x.a(this.f499b, true);
        }
    }

    @Override // a.b.f.m
    public void a(s sVar) {
        d(sVar);
    }

    @Override // a.b.f.m
    public void c(s sVar) {
        d(sVar);
    }

    public final void d(s sVar) {
        View view = sVar.f587b;
        if (!a.b.g.k.u.x(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        sVar.f586a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        sVar.f586a.put("android:changeBounds:parent", sVar.f587b.getParent());
        if (this.M) {
            sVar.f587b.getLocationInWindow(this.K);
            sVar.f586a.put("android:changeBounds:windowX", Integer.valueOf(this.K[0]));
            sVar.f586a.put("android:changeBounds:windowY", Integer.valueOf(this.K[1]));
        }
        if (this.L) {
            sVar.f586a.put("android:changeBounds:clip", a.b.g.k.u.e(view));
        }
    }

    @Override // a.b.f.m
    public String[] o() {
        return N;
    }

    public final boolean a(View view, View view2) {
        if (this.M) {
            s b2 = b(view, true);
            if (b2 == null) {
                if (view == view2) {
                    return true;
                }
            } else if (view2 == b2.f587b) {
                return true;
            }
            return false;
        }
        return true;
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    public static class b extends Property<Drawable, PointF> {

        /* renamed from: a  reason: collision with root package name */
        public Rect f489a;

        public b(Class cls, String str) {
            super(cls, str);
            this.f489a = new Rect();
        }

        @Override // android.util.Property
        /* renamed from: a */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f489a);
            this.f489a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f489a);
        }

        @Override // android.util.Property
        /* renamed from: a */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f489a);
            Rect rect = this.f489a;
            return new PointF(rect.left, rect.top);
        }
    }

    /* compiled from: ChangeBounds.java */
    /* loaded from: classes.dex */
    public static class k {

        /* renamed from: a  reason: collision with root package name */
        public int f500a;

        /* renamed from: b  reason: collision with root package name */
        public int f501b;

        /* renamed from: c  reason: collision with root package name */
        public int f502c;

        /* renamed from: d  reason: collision with root package name */
        public int f503d;

        /* renamed from: e  reason: collision with root package name */
        public View f504e;

        /* renamed from: f  reason: collision with root package name */
        public int f505f;

        /* renamed from: g  reason: collision with root package name */
        public int f506g;

        public k(View view) {
            this.f504e = view;
        }

        public void a(PointF pointF) {
            this.f502c = Math.round(pointF.x);
            this.f503d = Math.round(pointF.y);
            this.f506g++;
            if (this.f505f == this.f506g) {
                a();
            }
        }

        public void b(PointF pointF) {
            this.f500a = Math.round(pointF.x);
            this.f501b = Math.round(pointF.y);
            this.f505f++;
            if (this.f505f == this.f506g) {
                a();
            }
        }

        public final void a() {
            d0.a(this.f504e, this.f500a, this.f501b, this.f502c, this.f503d);
            this.f505f = 0;
            this.f506g = 0;
        }
    }

    @Override // a.b.f.m
    public Animator a(ViewGroup viewGroup, s sVar, s sVar2) {
        int i2;
        View view;
        int i3;
        Rect rect;
        ObjectAnimator objectAnimator;
        Animator a2;
        if (sVar == null || sVar2 == null) {
            return null;
        }
        Map<String, Object> map = sVar.f586a;
        Map<String, Object> map2 = sVar2.f586a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view2 = sVar2.f587b;
        if (a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) sVar.f586a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) sVar2.f586a.get("android:changeBounds:bounds");
            int i4 = rect2.left;
            int i5 = rect3.left;
            int i6 = rect2.top;
            int i7 = rect3.top;
            int i8 = rect2.right;
            int i9 = rect3.right;
            int i10 = rect2.bottom;
            int i11 = rect3.bottom;
            int i12 = i8 - i4;
            int i13 = i10 - i6;
            int i14 = i9 - i5;
            int i15 = i11 - i7;
            Rect rect4 = (Rect) sVar.f586a.get("android:changeBounds:clip");
            Rect rect5 = (Rect) sVar2.f586a.get("android:changeBounds:clip");
            if ((i12 == 0 || i13 == 0) && (i14 == 0 || i15 == 0)) {
                i2 = 0;
            } else {
                i2 = (i4 == i5 && i6 == i7) ? 0 : 1;
                if (i8 != i9 || i10 != i11) {
                    i2++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i2++;
            }
            if (i2 > 0) {
                if (!this.L) {
                    view = view2;
                    d0.a(view, i4, i6, i8, i10);
                    if (i2 == 2) {
                        if (i12 == i14 && i13 == i15) {
                            a2 = a.b.f.f.a(view, T, f().a(i4, i6, i5, i7));
                        } else {
                            k kVar = new k(view);
                            ObjectAnimator a3 = a.b.f.f.a(kVar, P, f().a(i4, i6, i5, i7));
                            ObjectAnimator a4 = a.b.f.f.a(kVar, Q, f().a(i8, i10, i9, i11));
                            AnimatorSet animatorSet = new AnimatorSet();
                            animatorSet.playTogether(a3, a4);
                            animatorSet.addListener(new h(this, kVar));
                            a2 = animatorSet;
                        }
                    } else if (i4 == i5 && i6 == i7) {
                        a2 = a.b.f.f.a(view, R, f().a(i8, i10, i9, i11));
                    } else {
                        a2 = a.b.f.f.a(view, S, f().a(i4, i6, i5, i7));
                    }
                } else {
                    view = view2;
                    d0.a(view, i4, i6, Math.max(i12, i14) + i4, Math.max(i13, i15) + i6);
                    ObjectAnimator a5 = (i4 == i5 && i6 == i7) ? null : a.b.f.f.a(view, T, f().a(i4, i6, i5, i7));
                    if (rect4 == null) {
                        i3 = 0;
                        rect = new Rect(0, 0, i12, i13);
                    } else {
                        i3 = 0;
                        rect = rect4;
                    }
                    Rect rect6 = rect5 == null ? new Rect(i3, i3, i14, i15) : rect5;
                    if (rect.equals(rect6)) {
                        objectAnimator = null;
                    } else {
                        a.b.g.k.u.a(view, rect);
                        a.b.f.k kVar2 = U;
                        Object[] objArr = new Object[2];
                        objArr[i3] = rect;
                        objArr[1] = rect6;
                        objectAnimator = ObjectAnimator.ofObject(view, "clipBounds", kVar2, objArr);
                        objectAnimator.addListener(new i(this, view, rect5, i5, i7, i9, i11));
                    }
                    a2 = r.a(a5, objectAnimator);
                }
                if (view.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                    x.a(viewGroup4, true);
                    a(new j(this, viewGroup4));
                }
                return a2;
            }
            return null;
        }
        int intValue = ((Integer) sVar.f586a.get("android:changeBounds:windowX")).intValue();
        int intValue2 = ((Integer) sVar.f586a.get("android:changeBounds:windowY")).intValue();
        int intValue3 = ((Integer) sVar2.f586a.get("android:changeBounds:windowX")).intValue();
        int intValue4 = ((Integer) sVar2.f586a.get("android:changeBounds:windowY")).intValue();
        if (intValue == intValue3 && intValue2 == intValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.K);
        Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(createBitmap));
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        float c2 = d0.c(view2);
        d0.a(view2, 0.0f);
        d0.b(viewGroup).a(bitmapDrawable);
        a.b.f.g f2 = f();
        int[] iArr = this.K;
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, a.b.f.i.a(O, f2.a(intValue - iArr[0], intValue2 - iArr[1], intValue3 - iArr[0], intValue4 - iArr[1])));
        ofPropertyValuesHolder.addListener(new a(this, viewGroup, bitmapDrawable, view2, c2));
        return ofPropertyValuesHolder;
    }
}
