package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;
import java.util.List;
import p000a.p006b.p012d.C0040b;
import p000a.p006b.p012d.C0048j;
import p000a.p006b.p012d.C0049k;
import p000a.p006b.p012d.p013l.AnimationUtils;
import p000a.p006b.p012d.p019q.ThemeEnforcement;
import p000a.p006b.p012d.p026x.HeaderBehavior;
import p000a.p006b.p012d.p026x.HeaderScrollingViewBehavior;
import p000a.p006b.p012d.p026x.ViewUtilsLollipop;
import p000a.p006b.p030g.p038e.C0222a;
import p000a.p006b.p030g.p044j.ObjectsCompat;
import p000a.p006b.p030g.p045k.AbsSavedState;
import p000a.p006b.p030g.p045k.NestedScrollingChild;
import p000a.p006b.p030g.p045k.OnApplyWindowInsetsListener;
import p000a.p006b.p030g.p045k.ViewCompat;
import p000a.p006b.p030g.p045k.WindowInsetsCompat;

@CoordinatorLayout.InterfaceC0576d(Behavior.class)
/* loaded from: classes.dex */
public class AppBarLayout extends LinearLayout {

    /* renamed from: a */
    public int f3197a;

    /* renamed from: b */
    public int f3198b;

    /* renamed from: c */
    public int f3199c;

    /* renamed from: d */
    public boolean f3200d;

    /* renamed from: e */
    public int f3201e;

    /* renamed from: f */
    public WindowInsetsCompat f3202f;

    /* renamed from: g */
    public List<InterfaceC0542b> f3203g;

    /* renamed from: h */
    public boolean f3204h;

    /* renamed from: i */
    public boolean f3205i;

    /* renamed from: j */
    public boolean f3206j;

    /* renamed from: k */
    public boolean f3207k;

    /* renamed from: m */
    public int[] f3208m;

    /* loaded from: classes.dex */
    public static class BaseBehavior<T extends AppBarLayout> extends HeaderBehavior<T> {

        /* renamed from: k */
        public int f3209k;

        /* renamed from: l */
        public int f3210l;

        /* renamed from: m */
        public ValueAnimator f3211m;

        /* renamed from: n */
        public int f3212n;

        /* renamed from: o */
        public boolean f3213o;

        /* renamed from: p */
        public float f3214p;

        /* renamed from: q */
        public WeakReference<View> f3215q;

        /* renamed from: r */
        public AbstractC0538b f3216r;

        /* renamed from: android.support.design.widget.AppBarLayout$BaseBehavior$a */
        /* loaded from: classes.dex */
        public class C0537a implements ValueAnimator.AnimatorUpdateListener {

            /* renamed from: a */
            public final /* synthetic */ CoordinatorLayout f3217a;

            /* renamed from: b */
            public final /* synthetic */ AppBarLayout f3218b;

            public C0537a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
                this.f3217a = coordinatorLayout;
                this.f3218b = appBarLayout;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseBehavior.this.m10738c(this.f3217a, (CoordinatorLayout) this.f3218b, ((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        }

        /* renamed from: android.support.design.widget.AppBarLayout$BaseBehavior$b */
        /* loaded from: classes.dex */
        public static abstract class AbstractC0538b<T extends AppBarLayout> {
            /* renamed from: a */
            public abstract boolean m7815a(T t);
        }

        public BaseBehavior() {
            this.f3212n = -1;
        }

        /* renamed from: a */
        public static boolean m7847a(int i, int i2) {
            return (i & i2) == i2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p000a.p006b.p012d.p026x.HeaderBehavior
        /* renamed from: b */
        public /* bridge */ /* synthetic */ int mo7823b(View view) {
            return m7827b((BaseBehavior<T>) ((AppBarLayout) view));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p000a.p006b.p012d.p026x.HeaderBehavior
        /* renamed from: c */
        public /* bridge */ /* synthetic */ int mo7819c(View view) {
            return m7822c((BaseBehavior<T>) ((AppBarLayout) view));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: d */
        public /* bridge */ /* synthetic */ Parcelable mo7690d(CoordinatorLayout coordinatorLayout, View view) {
            return m7825b(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p000a.p006b.p012d.p026x.HeaderBehavior
        /* renamed from: e */
        public /* bridge */ /* synthetic */ void mo7816e(CoordinatorLayout coordinatorLayout, View view) {
            m7841a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p000a.p006b.p012d.p026x.HeaderBehavior
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo7828a(View view) {
            return m7844a((BaseBehavior<T>) ((AppBarLayout) view));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: b */
        public /* bridge */ /* synthetic */ boolean mo7693b(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            return m7829a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, view3, i, i2);
        }

        /* renamed from: c */
        public int m7822c(T t) {
            return t.getTotalScrollRange();
        }

        /* renamed from: d */
        public final void m7817d(CoordinatorLayout coordinatorLayout, T t) {
            int mo7818d = mo7818d();
            int m7843a = m7843a((BaseBehavior<T>) t, mo7818d);
            if (m7843a >= 0) {
                View childAt = t.getChildAt(m7843a);
                C0543c c0543c = (C0543c) childAt.getLayoutParams();
                int m7807a = c0543c.m7807a();
                if ((m7807a & 17) == 17) {
                    int i = -childAt.getTop();
                    int i2 = -childAt.getBottom();
                    if (m7843a == t.getChildCount() - 1) {
                        i2 += t.getTopInset();
                    }
                    if (m7847a(m7807a, 2)) {
                        i2 += ViewCompat.m9421l(childAt);
                    } else if (m7847a(m7807a, 5)) {
                        int m9421l = ViewCompat.m9421l(childAt) + i2;
                        if (mo7818d < m9421l) {
                            i = m9421l;
                        } else {
                            i2 = m9421l;
                        }
                    }
                    if (m7847a(m7807a, 32)) {
                        i += ((LinearLayout.LayoutParams) c0543c).topMargin;
                        i2 -= ((LinearLayout.LayoutParams) c0543c).bottomMargin;
                    }
                    if (mo7818d < (i2 + i) / 2) {
                        i = i2;
                    }
                    m7839a(coordinatorLayout, (CoordinatorLayout) t, C0222a.m9830a(i, -t.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3212n = -1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p000a.p006b.p012d.p026x.ViewOffsetBehavior, android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo7643a(CoordinatorLayout coordinatorLayout, View view, int i) {
            return m7840a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p000a.p006b.p012d.p026x.HeaderBehavior
        /* renamed from: b */
        public /* bridge */ /* synthetic */ int mo7824b(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3) {
            return m7837a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), i, i2, i3);
        }

        /* renamed from: c */
        public final boolean m7820c(CoordinatorLayout coordinatorLayout, T t) {
            List<View> m7725c = coordinatorLayout.m7725c(t);
            int size = m7725c.size();
            for (int i = 0; i < size; i++) {
                CoordinatorLayout.AbstractC0575c m7673d = ((CoordinatorLayout.C0578f) m7725c.get(i).getLayoutParams()).m7673d();
                if (m7673d instanceof ScrollingViewBehavior) {
                    return ((ScrollingViewBehavior) m7673d).m10735c() != 0;
                }
            }
            return false;
        }

        /* renamed from: android.support.design.widget.AppBarLayout$BaseBehavior$c */
        /* loaded from: classes.dex */
        public static class C0539c extends AbsSavedState {
            public static final Parcelable.Creator<C0539c> CREATOR = new C0540a();

            /* renamed from: c */
            public int f3220c;

            /* renamed from: d */
            public float f3221d;

            /* renamed from: e */
            public boolean f3222e;

            /* renamed from: android.support.design.widget.AppBarLayout$BaseBehavior$c$a */
            /* loaded from: classes.dex */
            public static class C0540a implements Parcelable.ClassLoaderCreator<C0539c> {
                @Override // android.os.Parcelable.Creator
                public C0539c[] newArray(int i) {
                    return new C0539c[i];
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.ClassLoaderCreator
                public C0539c createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return new C0539c(parcel, classLoader);
                }

                @Override // android.os.Parcelable.Creator
                public C0539c createFromParcel(Parcel parcel) {
                    return new C0539c(parcel, null);
                }
            }

            public C0539c(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.f3220c = parcel.readInt();
                this.f3221d = parcel.readFloat();
                this.f3222e = parcel.readByte() != 0;
            }

            @Override // p000a.p006b.p030g.p045k.AbsSavedState, android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.f3220c);
                parcel.writeFloat(this.f3221d);
                parcel.writeByte(this.f3222e ? (byte) 1 : (byte) 0);
            }

            public C0539c(Parcelable parcelable) {
                super(parcelable);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo7709a(CoordinatorLayout coordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return m7836a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), i, i2, i3, i4);
        }

        /* renamed from: b */
        public int m7827b(T t) {
            return -t.getDownNestedScrollRange();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo7698a(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int[] iArr, int i3) {
            m7830a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, i, i2, iArr, i3);
        }

        /* renamed from: b */
        public final int m7826b(T t, int i) {
            int abs = Math.abs(i);
            int childCount = t.getChildCount();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i3 >= childCount) {
                    break;
                }
                View childAt = t.getChildAt(i3);
                C0543c c0543c = (C0543c) childAt.getLayoutParams();
                Interpolator m7806b = c0543c.m7806b();
                if (abs < childAt.getTop() || abs > childAt.getBottom()) {
                    i3++;
                } else if (m7806b != null) {
                    int m7807a = c0543c.m7807a();
                    if ((m7807a & 1) != 0) {
                        i2 = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) c0543c).topMargin + ((LinearLayout.LayoutParams) c0543c).bottomMargin;
                        if ((m7807a & 2) != 0) {
                            i2 -= ViewCompat.m9421l(childAt);
                        }
                    }
                    if (ViewCompat.m9426h(childAt)) {
                        i2 -= t.getTopInset();
                    }
                    if (i2 > 0) {
                        float f = i2;
                        return Integer.signum(i) * (childAt.getTop() + Math.round(f * m7806b.getInterpolation((abs - childAt.getTop()) / f)));
                    }
                }
            }
            return i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo7700a(CoordinatorLayout coordinatorLayout, View view, View view2, int i, int i2, int i3, int i4, int i5) {
            m7831a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, i, i2, i3, i4, i5);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo7706a(CoordinatorLayout coordinatorLayout, View view, Parcelable parcelable) {
            m7834a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), parcelable);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: a */
        public /* bridge */ /* synthetic */ void mo7702a(CoordinatorLayout coordinatorLayout, View view, View view2, int i) {
            m7832a(coordinatorLayout, (CoordinatorLayout) ((AppBarLayout) view), view2, i);
        }

        /* renamed from: a */
        public boolean m7829a(CoordinatorLayout coordinatorLayout, T t, View view, View view2, int i, int i2) {
            ValueAnimator valueAnimator;
            boolean z = (i & 2) != 0 && (t.m7849e() || m7833a(coordinatorLayout, (CoordinatorLayout) t, view));
            if (z && (valueAnimator = this.f3211m) != null) {
                valueAnimator.cancel();
            }
            this.f3215q = null;
            this.f3210l = i2;
            return z;
        }

        /* renamed from: c */
        public static View m7821c(AppBarLayout appBarLayout, int i) {
            int abs = Math.abs(i);
            int childCount = appBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = appBarLayout.getChildAt(i2);
                if (abs >= childAt.getTop() && abs <= childAt.getBottom()) {
                    return childAt;
                }
            }
            return null;
        }

        /* renamed from: a */
        public final boolean m7833a(CoordinatorLayout coordinatorLayout, T t, View view) {
            return t.m7851c() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
        }

        /* renamed from: a */
        public void m7830a(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int i5;
            if (i2 != 0) {
                if (i2 < 0) {
                    int i6 = -t.getTotalScrollRange();
                    i4 = i6;
                    i5 = t.getDownNestedPreScrollRange() + i6;
                } else {
                    i4 = -t.getUpNestedPreScrollRange();
                    i5 = 0;
                }
                if (i4 != i5) {
                    iArr[1] = m10740a(coordinatorLayout, (CoordinatorLayout) t, i2, i4, i5);
                    m7846a(i2, (int) t, view, i3);
                }
            }
        }

        /* renamed from: b */
        public Parcelable m7825b(CoordinatorLayout coordinatorLayout, T t) {
            Parcelable mo7690d = super.mo7690d(coordinatorLayout, (CoordinatorLayout) t);
            int m10657b = m10657b();
            int childCount = t.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = t.getChildAt(i);
                int bottom = childAt.getBottom() + m10657b;
                if (childAt.getTop() + m10657b <= 0 && bottom >= 0) {
                    C0539c c0539c = new C0539c(mo7690d);
                    c0539c.f3220c = i;
                    c0539c.f3222e = bottom == ViewCompat.m9421l(childAt) + t.getTopInset();
                    c0539c.f3221d = bottom / childAt.getHeight();
                    return c0539c;
                }
            }
            return mo7690d;
        }

        /* renamed from: a */
        public void m7831a(CoordinatorLayout coordinatorLayout, T t, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                m10740a(coordinatorLayout, (CoordinatorLayout) t, i4, -t.getDownNestedScrollRange(), 0);
                m7846a(i4, (int) t, view, i5);
            }
            if (t.m7849e()) {
                t.m7852b(view.getScrollY() > 0);
            }
        }

        @Override // p000a.p006b.p012d.p026x.HeaderBehavior
        /* renamed from: d */
        public int mo7818d() {
            return m10657b() + this.f3209k;
        }

        /* renamed from: a */
        public final void m7846a(int i, T t, View view, int i2) {
            if (i2 == 1) {
                int mo7818d = mo7818d();
                if ((i >= 0 || mo7818d != 0) && (i <= 0 || mo7818d != (-t.getDownNestedScrollRange()))) {
                    return;
                }
                ViewCompat.m9425h(view, 1);
            }
        }

        /* renamed from: a */
        public void m7832a(CoordinatorLayout coordinatorLayout, T t, View view, int i) {
            if (this.f3210l == 0 || i == 1) {
                m7817d(coordinatorLayout, (CoordinatorLayout) t);
            }
            this.f3215q = new WeakReference<>(view);
        }

        /* renamed from: a */
        public final void m7839a(CoordinatorLayout coordinatorLayout, T t, int i, float f) {
            int height;
            int abs = Math.abs(mo7818d() - i);
            float abs2 = Math.abs(f);
            if (abs2 > 0.0f) {
                height = Math.round((abs / abs2) * 1000.0f) * 3;
            } else {
                height = (int) (((abs / t.getHeight()) + 1.0f) * 150.0f);
            }
            m7838a(coordinatorLayout, (CoordinatorLayout) t, i, height);
        }

        /* renamed from: a */
        public final void m7838a(CoordinatorLayout coordinatorLayout, T t, int i, int i2) {
            int mo7818d = mo7818d();
            if (mo7818d == i) {
                ValueAnimator valueAnimator = this.f3211m;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.f3211m.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.f3211m;
            if (valueAnimator2 == null) {
                this.f3211m = new ValueAnimator();
                this.f3211m.setInterpolator(AnimationUtils.f425e);
                this.f3211m.addUpdateListener(new C0537a(coordinatorLayout, t));
            } else {
                valueAnimator2.cancel();
            }
            this.f3211m.setDuration(Math.min(i2, 600));
            this.f3211m.setIntValues(mo7818d, i);
            this.f3211m.start();
        }

        /* renamed from: a */
        public final int m7843a(T t, int i) {
            int childCount = t.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = t.getChildAt(i2);
                int top = childAt.getTop();
                int bottom = childAt.getBottom();
                C0543c c0543c = (C0543c) childAt.getLayoutParams();
                if (m7847a(c0543c.m7807a(), 32)) {
                    top -= ((LinearLayout.LayoutParams) c0543c).topMargin;
                    bottom += ((LinearLayout.LayoutParams) c0543c).bottomMargin;
                }
                int i3 = -i;
                if (top <= i3 && bottom >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        /* renamed from: a */
        public boolean m7836a(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3, int i4) {
            if (((ViewGroup.MarginLayoutParams) ((CoordinatorLayout.C0578f) t.getLayoutParams())).height == -2) {
                coordinatorLayout.m7743a(t, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
                return true;
            }
            return super.mo7709a(coordinatorLayout, (CoordinatorLayout) t, i, i2, i3, i4);
        }

        /* renamed from: a */
        public boolean m7840a(CoordinatorLayout coordinatorLayout, T t, int i) {
            int round;
            boolean mo7643a = super.mo7643a(coordinatorLayout, (CoordinatorLayout) t, i);
            int pendingAction = t.getPendingAction();
            int i2 = this.f3212n;
            if (i2 >= 0 && (pendingAction & 8) == 0) {
                View childAt = t.getChildAt(i2);
                int i3 = -childAt.getBottom();
                if (this.f3213o) {
                    round = ViewCompat.m9421l(childAt) + t.getTopInset();
                } else {
                    round = Math.round(childAt.getHeight() * this.f3214p);
                }
                m10738c(coordinatorLayout, (CoordinatorLayout) t, i3 + round);
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i4 = -t.getUpNestedPreScrollRange();
                    if (z) {
                        m7839a(coordinatorLayout, (CoordinatorLayout) t, i4, 0.0f);
                    } else {
                        m10738c(coordinatorLayout, (CoordinatorLayout) t, i4);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        m7839a(coordinatorLayout, (CoordinatorLayout) t, 0, 0.0f);
                    } else {
                        m10738c(coordinatorLayout, (CoordinatorLayout) t, 0);
                    }
                }
            }
            t.m7848f();
            this.f3212n = -1;
            m10658a(C0222a.m9830a(m10657b(), -t.getTotalScrollRange(), 0));
            m7835a(coordinatorLayout, (CoordinatorLayout) t, m10657b(), 0, true);
            t.m7858a(m10657b());
            return mo7643a;
        }

        /* renamed from: a */
        public boolean m7844a(T t) {
            AbstractC0538b abstractC0538b = this.f3216r;
            if (abstractC0538b != null) {
                return abstractC0538b.m7815a(t);
            }
            WeakReference<View> weakReference = this.f3215q;
            if (weakReference != null) {
                View view = weakReference.get();
                return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
            }
            return true;
        }

        /* renamed from: a */
        public void m7841a(CoordinatorLayout coordinatorLayout, T t) {
            m7817d(coordinatorLayout, (CoordinatorLayout) t);
        }

        /* renamed from: a */
        public int m7837a(CoordinatorLayout coordinatorLayout, T t, int i, int i2, int i3) {
            int mo7818d = mo7818d();
            int i4 = 0;
            if (i2 != 0 && mo7818d >= i2 && mo7818d <= i3) {
                int m9830a = C0222a.m9830a(i, i2, i3);
                if (mo7818d != m9830a) {
                    int m7826b = t.m7859a() ? m7826b((BaseBehavior<T>) t, m9830a) : m9830a;
                    boolean m10658a = m10658a(m7826b);
                    i4 = mo7818d - m9830a;
                    this.f3209k = m9830a - m7826b;
                    if (!m10658a && t.m7859a()) {
                        coordinatorLayout.m7745a(t);
                    }
                    t.m7858a(m10657b());
                    m7835a(coordinatorLayout, (CoordinatorLayout) t, m9830a, m9830a < mo7818d ? -1 : 1, false);
                }
            } else {
                this.f3209k = 0;
            }
            return i4;
        }

        /* JADX WARN: Removed duplicated region for block: B:25:0x0054  */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0056  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0061  */
        /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void m7835a(android.support.design.widget.CoordinatorLayout r6, T r7, int r8, int r9, boolean r10) {
            /*
                r5 = this;
                android.view.View r0 = m7821c(r7, r8)
                if (r0 == 0) goto L6e
                android.view.ViewGroup$LayoutParams r1 = r0.getLayoutParams()
                android.support.design.widget.AppBarLayout$c r1 = (android.support.design.widget.AppBarLayout.C0543c) r1
                int r1 = r1.m7807a()
                r2 = r1 & 1
                r3 = 1
                r4 = 0
                if (r2 == 0) goto L41
                int r2 = p000a.p006b.p030g.p045k.ViewCompat.m9421l(r0)
                if (r9 <= 0) goto L2f
                r9 = r1 & 12
                if (r9 == 0) goto L2f
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L41
            L2d:
                r8 = 1
                goto L42
            L2f:
                r9 = r1 & 2
                if (r9 == 0) goto L41
                int r8 = -r8
                int r9 = r0.getBottom()
                int r9 = r9 - r2
                int r0 = r7.getTopInset()
                int r9 = r9 - r0
                if (r8 < r9) goto L41
                goto L2d
            L41:
                r8 = 0
            L42:
                boolean r9 = r7.m7849e()
                if (r9 == 0) goto L57
                android.view.View r9 = r5.m7842a(r6)
                if (r9 == 0) goto L57
                int r8 = r9.getScrollY()
                if (r8 <= 0) goto L56
                r8 = 1
                goto L57
            L56:
                r8 = 0
            L57:
                boolean r8 = r7.m7852b(r8)
                int r9 = android.os.Build.VERSION.SDK_INT
                r0 = 11
                if (r9 < r0) goto L6e
                if (r10 != 0) goto L6b
                if (r8 == 0) goto L6e
                boolean r6 = r5.m7820c(r6, r7)
                if (r6 == 0) goto L6e
            L6b:
                r7.jumpDrawablesToCurrentState()
            L6e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.AppBarLayout.BaseBehavior.m7835a(android.support.design.widget.CoordinatorLayout, android.support.design.widget.AppBarLayout, int, int, boolean):void");
        }

        /* renamed from: a */
        public final View m7842a(CoordinatorLayout coordinatorLayout) {
            int childCount = coordinatorLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt instanceof NestedScrollingChild) {
                    return childAt;
                }
            }
            return null;
        }

        /* renamed from: a */
        public void m7834a(CoordinatorLayout coordinatorLayout, T t, Parcelable parcelable) {
            if (parcelable instanceof C0539c) {
                C0539c c0539c = (C0539c) parcelable;
                super.mo7706a(coordinatorLayout, (CoordinatorLayout) t, c0539c.m9588a());
                this.f3212n = c0539c.f3220c;
                this.f3214p = c0539c.f3221d;
                this.f3213o = c0539c.f3222e;
                return;
            }
            super.mo7706a(coordinatorLayout, (CoordinatorLayout) t, parcelable);
            this.f3212n = -1;
        }
    }

    /* loaded from: classes.dex */
    public static class Behavior extends BaseBehavior<AppBarLayout> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends HeaderScrollingViewBehavior {
        public ScrollingViewBehavior() {
        }

        @Override // p000a.p006b.p012d.p026x.HeaderScrollingViewBehavior
        /* renamed from: a */
        public /* bridge */ /* synthetic */ View mo7812a(List list) {
            return mo7812a((List<View>) list);
        }

        @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: b */
        public boolean mo7639b(CoordinatorLayout coordinatorLayout, View view, View view2) {
            m7813a(view, view2);
            m7810b(view, view2);
            return false;
        }

        @Override // p000a.p006b.p012d.p026x.HeaderScrollingViewBehavior
        /* renamed from: c */
        public int mo7809c(View view) {
            if (view instanceof AppBarLayout) {
                return ((AppBarLayout) view).getTotalScrollRange();
            }
            return super.mo7809c(view);
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0049k.ScrollingViewBehavior_Layout);
            m10736b(obtainStyledAttributes.getDimensionPixelSize(C0049k.ScrollingViewBehavior_Layout_behavior_overlapTop, 0));
            obtainStyledAttributes.recycle();
        }

        @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: a */
        public boolean mo7705a(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return view2 instanceof AppBarLayout;
        }

        @Override // android.support.design.widget.CoordinatorLayout.AbstractC0575c
        /* renamed from: a */
        public boolean mo7707a(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean z) {
            AppBarLayout mo7812a = mo7812a(coordinatorLayout.m7731b(view));
            if (mo7812a != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.f681d;
                rect2.set(0, 0, coordinatorLayout.getWidth(), coordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    mo7812a.m7855a(false, !z);
                    return true;
                }
            }
            return false;
        }

        @Override // p000a.p006b.p012d.p026x.HeaderScrollingViewBehavior
        /* renamed from: b */
        public float mo7811b(View view) {
            int i;
            if (view instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view;
                int totalScrollRange = appBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = appBarLayout.getDownNestedPreScrollRange();
                int m7814a = m7814a(appBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + m7814a > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (m7814a / i) + 1.0f;
                }
            }
            return 0.0f;
        }

        /* renamed from: b */
        public final void m7810b(View view, View view2) {
            if (view2 instanceof AppBarLayout) {
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                if (appBarLayout.m7849e()) {
                    appBarLayout.m7852b(view.getScrollY() > 0);
                }
            }
        }

        /* renamed from: a */
        public final void m7813a(View view, View view2) {
            CoordinatorLayout.AbstractC0575c m7673d = ((CoordinatorLayout.C0578f) view2.getLayoutParams()).m7673d();
            if (m7673d instanceof BaseBehavior) {
                ViewCompat.m9433d(view, (((view2.getBottom() - view.getTop()) + ((BaseBehavior) m7673d).f3209k) + m10733d()) - m10737a(view2));
            }
        }

        /* renamed from: a */
        public static int m7814a(AppBarLayout appBarLayout) {
            CoordinatorLayout.AbstractC0575c m7673d = ((CoordinatorLayout.C0578f) appBarLayout.getLayoutParams()).m7673d();
            if (m7673d instanceof BaseBehavior) {
                return ((BaseBehavior) m7673d).mo7818d();
            }
            return 0;
        }

        @Override // p000a.p006b.p012d.p026x.HeaderScrollingViewBehavior
        /* renamed from: a */
        public AppBarLayout mo7812a(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof AppBarLayout) {
                    return (AppBarLayout) view;
                }
            }
            return null;
        }
    }

    /* renamed from: android.support.design.widget.AppBarLayout$a */
    /* loaded from: classes.dex */
    public class C0541a implements OnApplyWindowInsetsListener {
        public C0541a() {
        }

        @Override // p000a.p006b.p030g.p045k.OnApplyWindowInsetsListener
        /* renamed from: a */
        public WindowInsetsCompat mo7712a(View view, WindowInsetsCompat windowInsetsCompat) {
            return AppBarLayout.this.m7857a(windowInsetsCompat);
        }
    }

    /* renamed from: android.support.design.widget.AppBarLayout$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0542b<T extends AppBarLayout> {
        /* renamed from: a */
        void m7808a(T t, int i);
    }

    public AppBarLayout(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    public void m7855a(boolean z, boolean z2) {
        m7854a(z, z2, true);
    }

    /* renamed from: b */
    public final boolean m7853b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (((C0543c) getChildAt(i).getLayoutParams()).m7805c()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public boolean m7851c() {
        return getTotalScrollRange() != 0;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0543c;
    }

    /* renamed from: d */
    public final void m7850d() {
        this.f3197a = -1;
        this.f3198b = -1;
        this.f3199c = -1;
    }

    /* renamed from: e */
    public boolean m7849e() {
        return this.f3207k;
    }

    /* renamed from: f */
    public void m7848f() {
        this.f3201e = 0;
    }

    public int getDownNestedPreScrollRange() {
        int topInset;
        int i = this.f3198b;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            C0543c c0543c = (C0543c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = c0543c.f3224a;
            if ((i3 & 5) == 5) {
                int i4 = i2 + ((LinearLayout.LayoutParams) c0543c).topMargin + ((LinearLayout.LayoutParams) c0543c).bottomMargin;
                if ((i3 & 8) != 0) {
                    i2 = i4 + ViewCompat.m9421l(childAt);
                } else {
                    if ((i3 & 2) != 0) {
                        topInset = ViewCompat.m9421l(childAt);
                    } else {
                        topInset = getTopInset();
                    }
                    i2 = i4 + (measuredHeight - topInset);
                }
            } else if (i2 > 0) {
                break;
            }
        }
        int max = Math.max(0, i2);
        this.f3198b = max;
        return max;
    }

    public int getDownNestedScrollRange() {
        int i = this.f3199c;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            C0543c c0543c = (C0543c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) c0543c).topMargin + ((LinearLayout.LayoutParams) c0543c).bottomMargin;
            int i4 = c0543c.f3224a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight;
            if ((i4 & 2) != 0) {
                i3 -= ViewCompat.m9421l(childAt) + getTopInset();
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3);
        this.f3199c = max;
        return max;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int m9421l = ViewCompat.m9421l(this);
        if (m9421l == 0) {
            int childCount = getChildCount();
            m9421l = childCount >= 1 ? ViewCompat.m9421l(getChildAt(childCount - 1)) : 0;
            if (m9421l == 0) {
                return getHeight() / 3;
            }
        }
        return (m9421l * 2) + topInset;
    }

    public int getPendingAction() {
        return this.f3201e;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    public final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.f3202f;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.m9571d();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.f3197a;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= childCount) {
                break;
            }
            View childAt = getChildAt(i2);
            C0543c c0543c = (C0543c) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i4 = c0543c.f3224a;
            if ((i4 & 1) == 0) {
                break;
            }
            i3 += measuredHeight + ((LinearLayout.LayoutParams) c0543c).topMargin + ((LinearLayout.LayoutParams) c0543c).bottomMargin;
            if ((i4 & 2) != 0) {
                i3 -= ViewCompat.m9421l(childAt);
                break;
            }
            i2++;
        }
        int max = Math.max(0, i3 - getTopInset());
        this.f3197a = max;
        return max;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (this.f3208m == null) {
            this.f3208m = new int[4];
        }
        int[] iArr = this.f3208m;
        int[] onCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        iArr[0] = this.f3205i ? C0040b.state_liftable : -C0040b.state_liftable;
        iArr[1] = (this.f3205i && this.f3206j) ? C0040b.state_lifted : -C0040b.state_lifted;
        iArr[2] = this.f3205i ? C0040b.state_collapsible : -C0040b.state_collapsible;
        iArr[3] = (this.f3205i && this.f3206j) ? C0040b.state_collapsed : -C0040b.state_collapsed;
        return LinearLayout.mergeDrawableStates(onCreateDrawableState, iArr);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m7850d();
        boolean z2 = false;
        this.f3200d = false;
        int childCount = getChildCount();
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            } else if (((C0543c) getChildAt(i5).getLayoutParams()).m7806b() != null) {
                this.f3200d = true;
                break;
            } else {
                i5++;
            }
        }
        if (this.f3204h) {
            return;
        }
        m7856a((this.f3207k || m7853b()) ? true : true);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        m7850d();
    }

    public void setExpanded(boolean z) {
        m7855a(z, ViewCompat.m9409x(this));
    }

    public void setLiftOnScroll(boolean z) {
        this.f3207k = z;
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i == 1) {
            super.setOrientation(i);
            return;
        }
        throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
    }

    @Deprecated
    public void setTargetElevation(float f) {
        if (Build.VERSION.SDK_INT >= 21) {
            ViewUtilsLollipop.m10649a(this, f);
        }
    }

    public AppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3197a = -1;
        this.f3198b = -1;
        this.f3199c = -1;
        this.f3201e = 0;
        setOrientation(1);
        if (Build.VERSION.SDK_INT >= 21) {
            ViewUtilsLollipop.m10650a(this);
            ViewUtilsLollipop.m10648a(this, attributeSet, 0, C0048j.Widget_Design_AppBarLayout);
        }
        TypedArray m10861c = ThemeEnforcement.m10861c(context, attributeSet, C0049k.AppBarLayout, 0, C0048j.Widget_Design_AppBarLayout, new int[0]);
        ViewCompat.m9447a(this, m10861c.getDrawable(C0049k.AppBarLayout_android_background));
        if (m10861c.hasValue(C0049k.AppBarLayout_expanded)) {
            m7854a(m10861c.getBoolean(C0049k.AppBarLayout_expanded, false), false, false);
        }
        if (Build.VERSION.SDK_INT >= 21 && m10861c.hasValue(C0049k.AppBarLayout_elevation)) {
            ViewUtilsLollipop.m10649a(this, m10861c.getDimensionPixelSize(C0049k.AppBarLayout_elevation, 0));
        }
        if (Build.VERSION.SDK_INT >= 26) {
            if (m10861c.hasValue(C0049k.AppBarLayout_android_keyboardNavigationCluster)) {
                setKeyboardNavigationCluster(m10861c.getBoolean(C0049k.AppBarLayout_android_keyboardNavigationCluster, false));
            }
            if (m10861c.hasValue(C0049k.AppBarLayout_android_touchscreenBlocksFocus)) {
                setTouchscreenBlocksFocus(m10861c.getBoolean(C0049k.AppBarLayout_android_touchscreenBlocksFocus, false));
            }
        }
        this.f3207k = m10861c.getBoolean(C0049k.AppBarLayout_liftOnScroll, false);
        m10861c.recycle();
        ViewCompat.m9452a(this, new C0541a());
    }

    /* renamed from: a */
    public final void m7854a(boolean z, boolean z2, boolean z3) {
        this.f3201e = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    /* renamed from: b */
    public boolean m7852b(boolean z) {
        if (this.f3206j != z) {
            this.f3206j = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public C0543c generateDefaultLayoutParams() {
        return new C0543c(-1, -2);
    }

    /* renamed from: a */
    public boolean m7859a() {
        return this.f3200d;
    }

    /* renamed from: a */
    public void m7858a(int i) {
        List<InterfaceC0542b> list = this.f3203g;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                InterfaceC0542b interfaceC0542b = this.f3203g.get(i2);
                if (interfaceC0542b != null) {
                    interfaceC0542b.m7808a(this, i);
                }
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public C0543c generateLayoutParams(AttributeSet attributeSet) {
        return new C0543c(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public C0543c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (Build.VERSION.SDK_INT >= 19 && (layoutParams instanceof LinearLayout.LayoutParams)) {
            return new C0543c((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new C0543c((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new C0543c(layoutParams);
    }

    /* renamed from: android.support.design.widget.AppBarLayout$c */
    /* loaded from: classes.dex */
    public static class C0543c extends LinearLayout.LayoutParams {

        /* renamed from: a */
        public int f3224a;

        /* renamed from: b */
        public Interpolator f3225b;

        public C0543c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3224a = 1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0049k.AppBarLayout_Layout);
            this.f3224a = obtainStyledAttributes.getInt(C0049k.AppBarLayout_Layout_layout_scrollFlags, 0);
            if (obtainStyledAttributes.hasValue(C0049k.AppBarLayout_Layout_layout_scrollInterpolator)) {
                this.f3225b = android.view.animation.AnimationUtils.loadInterpolator(context, obtainStyledAttributes.getResourceId(C0049k.AppBarLayout_Layout_layout_scrollInterpolator, 0));
            }
            obtainStyledAttributes.recycle();
        }

        /* renamed from: a */
        public int m7807a() {
            return this.f3224a;
        }

        /* renamed from: b */
        public Interpolator m7806b() {
            return this.f3225b;
        }

        /* renamed from: c */
        public boolean m7805c() {
            int i = this.f3224a;
            return (i & 1) == 1 && (i & 10) != 0;
        }

        public C0543c(int i, int i2) {
            super(i, i2);
            this.f3224a = 1;
        }

        public C0543c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3224a = 1;
        }

        public C0543c(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3224a = 1;
        }

        public C0543c(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3224a = 1;
        }
    }

    /* renamed from: a */
    public final boolean m7856a(boolean z) {
        if (this.f3205i != z) {
            this.f3205i = z;
            refreshDrawableState();
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public WindowInsetsCompat m7857a(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.m9426h(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.m9627a(this.f3202f, windowInsetsCompat2)) {
            this.f3202f = windowInsetsCompat2;
            m7850d();
        }
        return windowInsetsCompat;
    }
}
