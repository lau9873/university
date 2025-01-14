package p000a.p006b.p030g.p031a;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.support.p065v4.app.Fragment;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.Transformation;
import com.j256.ormlite.logger.Logger;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import p000a.p001a.p005b.ViewModelStore;
import p000a.p006b.p030g.p031a.FragmentManager;
import p000a.p006b.p030g.p044j.ArraySet;
import p000a.p006b.p030g.p044j.DebugUtils;
import p000a.p006b.p030g.p044j.LogWriter;
import p000a.p006b.p030g.p045k.ViewCompat;

/* compiled from: FragmentManager.java */
/* renamed from: a.b.g.a.l */
/* loaded from: classes.dex */
public final class LayoutInflater$Factory2C0152l extends FragmentManager implements LayoutInflater.Factory2 {

    /* renamed from: F */
    public static boolean f1130F = false;

    /* renamed from: G */
    public static Field f1131G;

    /* renamed from: H */
    public static final Interpolator f1132H = new DecelerateInterpolator(2.5f);

    /* renamed from: I */
    public static final Interpolator f1133I = new DecelerateInterpolator(1.5f);

    /* renamed from: C */
    public ArrayList<C0168n> f1136C;

    /* renamed from: D */
    public FragmentManagerNonConfig f1137D;

    /* renamed from: a */
    public ArrayList<InterfaceC0166l> f1139a;

    /* renamed from: b */
    public boolean f1140b;

    /* renamed from: e */
    public SparseArray<Fragment> f1143e;

    /* renamed from: f */
    public ArrayList<BackStackRecord> f1144f;

    /* renamed from: g */
    public ArrayList<Fragment> f1145g;

    /* renamed from: h */
    public ArrayList<BackStackRecord> f1146h;

    /* renamed from: i */
    public ArrayList<Integer> f1147i;

    /* renamed from: j */
    public ArrayList<FragmentManager.InterfaceC0151c> f1148j;

    /* renamed from: n */
    public FragmentHostCallback f1151n;

    /* renamed from: o */
    public FragmentContainer f1152o;

    /* renamed from: p */
    public Fragment f1153p;

    /* renamed from: q */
    public Fragment f1154q;

    /* renamed from: r */
    public boolean f1155r;

    /* renamed from: s */
    public boolean f1156s;

    /* renamed from: t */
    public boolean f1157t;

    /* renamed from: u */
    public boolean f1158u;

    /* renamed from: v */
    public String f1159v;

    /* renamed from: w */
    public boolean f1160w;

    /* renamed from: x */
    public ArrayList<BackStackRecord> f1161x;

    /* renamed from: y */
    public ArrayList<Boolean> f1162y;

    /* renamed from: z */
    public ArrayList<Fragment> f1163z;

    /* renamed from: c */
    public int f1141c = 0;

    /* renamed from: d */
    public final ArrayList<Fragment> f1142d = new ArrayList<>();

    /* renamed from: k */
    public final CopyOnWriteArrayList<C0164j> f1149k = new CopyOnWriteArrayList<>();

    /* renamed from: m */
    public int f1150m = 0;

    /* renamed from: A */
    public Bundle f1134A = null;

    /* renamed from: B */
    public SparseArray<Parcelable> f1135B = null;

    /* renamed from: E */
    public Runnable f1138E = new RunnableC0153a();

    /* compiled from: FragmentManager.java */
    /* renamed from: a.b.g.a.l$a */
    /* loaded from: classes.dex */
    public class RunnableC0153a implements Runnable {
        public RunnableC0153a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LayoutInflater$Factory2C0152l.this.m10160u();
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: a.b.g.a.l$b */
    /* loaded from: classes.dex */
    public class C0154b extends animationAnimation$AnimationListenerC0160f {

        /* renamed from: b */
        public final /* synthetic */ ViewGroup f1165b;

        /* renamed from: c */
        public final /* synthetic */ Fragment f1166c;

        /* compiled from: FragmentManager.java */
        /* renamed from: a.b.g.a.l$b$a */
        /* loaded from: classes.dex */
        public class RunnableC0155a implements Runnable {
            public RunnableC0155a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C0154b.this.f1166c.m7458m() != null) {
                    C0154b.this.f1166c.m7509a((View) null);
                    C0154b c0154b = C0154b.this;
                    LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = LayoutInflater$Factory2C0152l.this;
                    Fragment fragment = c0154b.f1166c;
                    layoutInflater$Factory2C0152l.m10244a(fragment, fragment.m7545F(), 0, 0, false);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0154b(Animation.AnimationListener animationListener, ViewGroup viewGroup, Fragment fragment) {
            super(animationListener);
            this.f1165b = viewGroup;
            this.f1166c = fragment;
        }

        @Override // p000a.p006b.p030g.p031a.LayoutInflater$Factory2C0152l.animationAnimation$AnimationListenerC0160f, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            super.onAnimationEnd(animation);
            this.f1165b.post(new RunnableC0155a());
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: a.b.g.a.l$c */
    /* loaded from: classes.dex */
    public class C0156c extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ ViewGroup f1169a;

        /* renamed from: b */
        public final /* synthetic */ View f1170b;

        /* renamed from: c */
        public final /* synthetic */ Fragment f1171c;

        public C0156c(ViewGroup viewGroup, View view, Fragment fragment) {
            this.f1169a = viewGroup;
            this.f1170b = view;
            this.f1171c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1169a.endViewTransition(this.f1170b);
            Animator m7455n = this.f1171c.m7455n();
            this.f1171c.m7524a((Animator) null);
            if (m7455n == null || this.f1169a.indexOfChild(this.f1170b) >= 0) {
                return;
            }
            LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = LayoutInflater$Factory2C0152l.this;
            Fragment fragment = this.f1171c;
            layoutInflater$Factory2C0152l.m10244a(fragment, fragment.m7545F(), 0, 0, false);
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: a.b.g.a.l$d */
    /* loaded from: classes.dex */
    public class C0157d extends AnimatorListenerAdapter {

        /* renamed from: a */
        public final /* synthetic */ ViewGroup f1173a;

        /* renamed from: b */
        public final /* synthetic */ View f1174b;

        /* renamed from: c */
        public final /* synthetic */ Fragment f1175c;

        public C0157d(LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l, ViewGroup viewGroup, View view, Fragment fragment) {
            this.f1173a = viewGroup;
            this.f1174b = view;
            this.f1175c = fragment;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1173a.endViewTransition(this.f1174b);
            animator.removeListener(this);
            View view = this.f1175c.f3473J;
            if (view != null) {
                view.setVisibility(8);
            }
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: a.b.g.a.l$e */
    /* loaded from: classes.dex */
    public static class C0158e extends animationAnimation$AnimationListenerC0160f {

        /* renamed from: b */
        public View f1176b;

        /* compiled from: FragmentManager.java */
        /* renamed from: a.b.g.a.l$e$a */
        /* loaded from: classes.dex */
        public class RunnableC0159a implements Runnable {
            public RunnableC0159a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0158e.this.f1176b.setLayerType(0, null);
            }
        }

        public C0158e(View view, Animation.AnimationListener animationListener) {
            super(animationListener);
            this.f1176b = view;
        }

        @Override // p000a.p006b.p030g.p031a.LayoutInflater$Factory2C0152l.animationAnimation$AnimationListenerC0160f, android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (!ViewCompat.m9410w(this.f1176b) && Build.VERSION.SDK_INT < 24) {
                this.f1176b.setLayerType(0, null);
            } else {
                this.f1176b.post(new RunnableC0159a());
            }
            super.onAnimationEnd(animation);
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: a.b.g.a.l$f  reason: invalid class name */
    /* loaded from: classes.dex */
    public static class animationAnimation$AnimationListenerC0160f implements Animation.AnimationListener {

        /* renamed from: a */
        public final Animation.AnimationListener f1178a;

        public animationAnimation$AnimationListenerC0160f(Animation.AnimationListener animationListener) {
            this.f1178a = animationListener;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Animation.AnimationListener animationListener = this.f1178a;
            if (animationListener != null) {
                animationListener.onAnimationEnd(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Animation.AnimationListener animationListener = this.f1178a;
            if (animationListener != null) {
                animationListener.onAnimationRepeat(animation);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Animation.AnimationListener animationListener = this.f1178a;
            if (animationListener != null) {
                animationListener.onAnimationStart(animation);
            }
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: a.b.g.a.l$h */
    /* loaded from: classes.dex */
    public static class C0162h extends AnimatorListenerAdapter {

        /* renamed from: a */
        public View f1181a;

        public C0162h(View view) {
            this.f1181a = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f1181a.setLayerType(0, null);
            animator.removeListener(this);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.f1181a.setLayerType(2, null);
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: a.b.g.a.l$j */
    /* loaded from: classes.dex */
    public static final class C0164j {

        /* renamed from: a */
        public final FragmentManager.AbstractC0150b f1187a;

        /* renamed from: b */
        public final boolean f1188b;
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: a.b.g.a.l$k */
    /* loaded from: classes.dex */
    public static class C0165k {

        /* renamed from: a */
        public static final int[] f1189a = {16842755, 16842960, 16842961};
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: a.b.g.a.l$l */
    /* loaded from: classes.dex */
    public interface InterfaceC0166l {
        /* renamed from: a */
        boolean mo10154a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2);
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: a.b.g.a.l$m */
    /* loaded from: classes.dex */
    public class C0167m implements InterfaceC0166l {

        /* renamed from: a */
        public final String f1190a;

        /* renamed from: b */
        public final int f1191b;

        /* renamed from: c */
        public final int f1192c;

        public C0167m(String str, int i, int i2) {
            this.f1190a = str;
            this.f1191b = i;
            this.f1192c = i2;
        }

        @Override // p000a.p006b.p030g.p031a.LayoutInflater$Factory2C0152l.InterfaceC0166l
        /* renamed from: a */
        public boolean mo10154a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
            FragmentManager m7492c0;
            Fragment fragment = LayoutInflater$Factory2C0152l.this.f1154q;
            if (fragment == null || this.f1191b >= 0 || this.f1190a != null || (m7492c0 = fragment.m7492c0()) == null || !m7492c0.mo10190f()) {
                return LayoutInflater$Factory2C0152l.this.m10225a(arrayList, arrayList2, this.f1190a, this.f1191b, this.f1192c);
            }
            return false;
        }
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: a.b.g.a.l$n */
    /* loaded from: classes.dex */
    public static class C0168n implements Fragment.InterfaceC0605e {

        /* renamed from: a */
        public final boolean f1194a;

        /* renamed from: b */
        public final BackStackRecord f1195b;

        /* renamed from: c */
        public int f1196c;

        public C0168n(BackStackRecord backStackRecord, boolean z) {
            this.f1194a = z;
            this.f1195b = backStackRecord;
        }

        @Override // android.support.p065v4.app.Fragment.InterfaceC0605e
        /* renamed from: a */
        public void mo7438a() {
            this.f1196c--;
            if (this.f1196c != 0) {
                return;
            }
            this.f1195b.f1048a.m10266D();
        }

        @Override // android.support.p065v4.app.Fragment.InterfaceC0605e
        /* renamed from: b */
        public void mo7437b() {
            this.f1196c++;
        }

        /* renamed from: c */
        public void m10153c() {
            BackStackRecord backStackRecord = this.f1195b;
            backStackRecord.f1048a.m10258a(backStackRecord, this.f1194a, false, false);
        }

        /* renamed from: d */
        public void m10152d() {
            boolean z = this.f1196c > 0;
            LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = this.f1195b.f1048a;
            int size = layoutInflater$Factory2C0152l.f1142d.size();
            for (int i = 0; i < size; i++) {
                Fragment fragment = layoutInflater$Factory2C0152l.f1142d.get(i);
                fragment.m7513a((Fragment.InterfaceC0605e) null);
                if (z && fragment.m7536O()) {
                    fragment.m7456m0();
                }
            }
            BackStackRecord backStackRecord = this.f1195b;
            backStackRecord.f1048a.m10258a(backStackRecord, this.f1194a, !z, true);
        }

        /* renamed from: e */
        public boolean m10151e() {
            return this.f1196c == 0;
        }
    }

    static {
        new AccelerateInterpolator(2.5f);
        new AccelerateInterpolator(1.5f);
    }

    /* renamed from: a */
    public static boolean m10256a(C0161g c0161g) {
        Animation animation = c0161g.f1179a;
        if (animation instanceof AlphaAnimation) {
            return true;
        }
        if (animation instanceof AnimationSet) {
            List<Animation> animations = ((AnimationSet) animation).getAnimations();
            for (int i = 0; i < animations.size(); i++) {
                if (animations.get(i) instanceof AlphaAnimation) {
                    return true;
                }
            }
            return false;
        }
        return m10252a(c0161g.f1180b);
    }

    /* renamed from: b */
    public static int m10221b(int i, boolean z) {
        if (i == 4097) {
            return z ? 1 : 2;
        } else if (i == 4099) {
            return z ? 5 : 6;
        } else if (i != 8194) {
            return -1;
        } else {
            return z ? 3 : 4;
        }
    }

    /* renamed from: b */
    public static boolean m10211b(View view, C0161g c0161g) {
        return view != null && c0161g != null && Build.VERSION.SDK_INT >= 19 && view.getLayerType() == 0 && ViewCompat.m9412u(view) && m10256a(c0161g);
    }

    /* renamed from: e */
    public static int m10193e(int i) {
        if (i != 4097) {
            if (i != 4099) {
                return i != 8194 ? 0 : 4097;
            }
            return 4099;
        }
        return 8194;
    }

    /* renamed from: A */
    public FragmentManagerNonConfig m10269A() {
        m10254a(this.f1137D);
        return this.f1137D;
    }

    /* renamed from: B */
    public Parcelable m10268B() {
        int[] iArr;
        int size;
        m10159v();
        m10161t();
        m10160u();
        this.f1156s = true;
        C0142d[] c0142dArr = null;
        this.f1137D = null;
        SparseArray<Fragment> sparseArray = this.f1143e;
        if (sparseArray == null || sparseArray.size() <= 0) {
            return null;
        }
        int size2 = this.f1143e.size();
        FragmentState[] fragmentStateArr = new FragmentState[size2];
        boolean z = false;
        for (int i = 0; i < size2; i++) {
            Fragment valueAt = this.f1143e.valueAt(i);
            if (valueAt != null) {
                if (valueAt.f3491e >= 0) {
                    FragmentState fragmentState = new FragmentState(valueAt);
                    fragmentStateArr[i] = fragmentState;
                    if (valueAt.f3487a > 0 && fragmentState.f1215k == null) {
                        fragmentState.f1215k = m10170n(valueAt);
                        Fragment fragment = valueAt.f3494h;
                        if (fragment != null) {
                            if (fragment.f3491e >= 0) {
                                if (fragmentState.f1215k == null) {
                                    fragmentState.f1215k = new Bundle();
                                }
                                mo10247a(fragmentState.f1215k, "android:target_state", valueAt.f3494h);
                                int i2 = valueAt.f3496j;
                                if (i2 != 0) {
                                    fragmentState.f1215k.putInt("android:target_req_state", i2);
                                }
                            } else {
                                m10232a(new IllegalStateException("Failure saving state: " + valueAt + " has target not in fragment manager: " + valueAt.f3494h));
                                throw null;
                            }
                        }
                    } else {
                        fragmentState.f1215k = valueAt.f3488b;
                    }
                    if (f1130F) {
                        Log.v("FragmentManager", "Saved state of " + valueAt + ": " + fragmentState.f1215k);
                    }
                    z = true;
                } else {
                    m10232a(new IllegalStateException("Failure saving state: active " + valueAt + " has cleared index: " + valueAt.f3491e));
                    throw null;
                }
            }
        }
        if (!z) {
            if (f1130F) {
                Log.v("FragmentManager", "saveAllState: no fragments!");
            }
            return null;
        }
        int size3 = this.f1142d.size();
        if (size3 > 0) {
            iArr = new int[size3];
            for (int i3 = 0; i3 < size3; i3++) {
                iArr[i3] = this.f1142d.get(i3).f3491e;
                if (iArr[i3] >= 0) {
                    if (f1130F) {
                        Log.v("FragmentManager", "saveAllState: adding fragment #" + i3 + ": " + this.f1142d.get(i3));
                    }
                } else {
                    m10232a(new IllegalStateException("Failure saving state: active " + this.f1142d.get(i3) + " has cleared index: " + iArr[i3]));
                    throw null;
                }
            }
        } else {
            iArr = null;
        }
        ArrayList<BackStackRecord> arrayList = this.f1144f;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            c0142dArr = new C0142d[size];
            for (int i4 = 0; i4 < size; i4++) {
                c0142dArr[i4] = new C0142d(this.f1144f.get(i4));
                if (f1130F) {
                    Log.v("FragmentManager", "saveAllState: adding back stack #" + i4 + ": " + this.f1144f.get(i4));
                }
            }
        }
        C0169n c0169n = new C0169n();
        c0169n.f1200a = fragmentStateArr;
        c0169n.f1201b = iArr;
        c0169n.f1202c = c0142dArr;
        Fragment fragment2 = this.f1154q;
        if (fragment2 != null) {
            c0169n.f1203d = fragment2.f3491e;
        }
        c0169n.f1204e = this.f1141c;
        m10267C();
        return c0169n;
    }

    /* renamed from: C */
    public void m10267C() {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        FragmentManagerNonConfig fragmentManagerNonConfig;
        if (this.f1143e != null) {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
            for (int i = 0; i < this.f1143e.size(); i++) {
                Fragment valueAt = this.f1143e.valueAt(i);
                if (valueAt != null) {
                    if (valueAt.f3467D) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(valueAt);
                        Fragment fragment = valueAt.f3494h;
                        valueAt.f3495i = fragment != null ? fragment.f3491e : -1;
                        if (f1130F) {
                            Log.v("FragmentManager", "retainNonConfig: keeping retained " + valueAt);
                        }
                    }
                    LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l = valueAt.f3506u;
                    if (layoutInflater$Factory2C0152l != null) {
                        layoutInflater$Factory2C0152l.m10267C();
                        fragmentManagerNonConfig = valueAt.f3506u.f1137D;
                    } else {
                        fragmentManagerNonConfig = valueAt.f3507v;
                    }
                    if (arrayList2 == null && fragmentManagerNonConfig != null) {
                        arrayList2 = new ArrayList(this.f1143e.size());
                        for (int i2 = 0; i2 < i; i2++) {
                            arrayList2.add(null);
                        }
                    }
                    if (arrayList2 != null) {
                        arrayList2.add(fragmentManagerNonConfig);
                    }
                    if (arrayList3 == null && valueAt.f3508w != null) {
                        arrayList3 = new ArrayList(this.f1143e.size());
                        for (int i3 = 0; i3 < i; i3++) {
                            arrayList3.add(null);
                        }
                    }
                    if (arrayList3 != null) {
                        arrayList3.add(valueAt.f3508w);
                    }
                }
            }
        } else {
            arrayList = null;
            arrayList2 = null;
            arrayList3 = null;
        }
        if (arrayList == null && arrayList2 == null && arrayList3 == null) {
            this.f1137D = null;
        } else {
            this.f1137D = new FragmentManagerNonConfig(arrayList, arrayList2, arrayList3);
        }
    }

    /* renamed from: D */
    public void m10266D() {
        synchronized (this) {
            boolean z = false;
            boolean z2 = (this.f1136C == null || this.f1136C.isEmpty()) ? false : true;
            if (this.f1139a != null && this.f1139a.size() == 1) {
                z = true;
            }
            if (z2 || z) {
                this.f1151n.m10289e().removeCallbacks(this.f1138E);
                this.f1151n.m10289e().post(this.f1138E);
            }
        }
    }

    /* renamed from: E */
    public void m10265E() {
        if (this.f1143e == null) {
            return;
        }
        for (int i = 0; i < this.f1143e.size(); i++) {
            Fragment valueAt = this.f1143e.valueAt(i);
            if (valueAt != null) {
                m10174l(valueAt);
            }
        }
    }

    @Override // p000a.p006b.p030g.p031a.FragmentManager
    /* renamed from: c */
    public List<Fragment> mo10206c() {
        List<Fragment> list;
        if (this.f1142d.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f1142d) {
            list = (List) this.f1142d.clone();
        }
        return list;
    }

    /* renamed from: d */
    public boolean m10198d(int i) {
        return this.f1150m >= i;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentManager
    /* renamed from: e */
    public void mo10194e() {
        m10255a((InterfaceC0166l) new C0167m(null, -1, 0), false);
    }

    @Override // p000a.p006b.p030g.p031a.FragmentManager
    /* renamed from: f */
    public boolean mo10190f() {
        m10184h();
        return m10230a((String) null, -1, 0);
    }

    /* renamed from: g */
    public void m10186g(Fragment fragment) {
        if (f1130F) {
            Log.v("FragmentManager", "hide: " + fragment);
        }
        if (fragment.f3465B) {
            return;
        }
        fragment.f3465B = true;
        fragment.f3479P = true ^ fragment.f3479P;
    }

    /* renamed from: h */
    public void m10183h(Fragment fragment) {
        if (fragment.f3491e >= 0) {
            return;
        }
        int i = this.f1141c;
        this.f1141c = i + 1;
        fragment.m7526a(i, this.f1153p);
        if (this.f1143e == null) {
            this.f1143e = new SparseArray<>();
        }
        this.f1143e.put(fragment.f3491e, fragment);
        if (f1130F) {
            Log.v("FragmentManager", "Allocated fragment index " + fragment);
        }
    }

    /* renamed from: i */
    public void m10180i(Fragment fragment) {
        if (fragment.f3491e < 0) {
            return;
        }
        if (f1130F) {
            Log.v("FragmentManager", "Freeing fragment index " + fragment);
        }
        this.f1143e.put(fragment.f3491e, null);
        fragment.m7542I();
    }

    /* renamed from: j */
    public void m10178j(Fragment fragment) {
        if (fragment == null) {
            return;
        }
        int i = this.f1150m;
        if (fragment.f3498m) {
            if (fragment.m7537N()) {
                i = Math.min(i, 1);
            } else {
                i = Math.min(i, 0);
            }
        }
        m10244a(fragment, i, fragment.m7445x(), fragment.m7444y(), false);
        if (fragment.f3473J != null) {
            Fragment m10189f = m10189f(fragment);
            if (m10189f != null) {
                View view = m10189f.f3473J;
                ViewGroup viewGroup = fragment.f3472I;
                int indexOfChild = viewGroup.indexOfChild(view);
                int indexOfChild2 = viewGroup.indexOfChild(fragment.f3473J);
                if (indexOfChild2 < indexOfChild) {
                    viewGroup.removeViewAt(indexOfChild2);
                    viewGroup.addView(fragment.f3473J, indexOfChild);
                }
            }
            if (fragment.f3478O && fragment.f3472I != null) {
                float f = fragment.f3480Q;
                if (f > 0.0f) {
                    fragment.f3473J.setAlpha(f);
                }
                fragment.f3480Q = 0.0f;
                fragment.f3478O = false;
                C0161g m10243a = m10243a(fragment, fragment.m7445x(), true, fragment.m7444y());
                if (m10243a != null) {
                    m10234a(fragment.f3473J, m10243a);
                    Animation animation = m10243a.f1179a;
                    if (animation != null) {
                        fragment.f3473J.startAnimation(animation);
                    } else {
                        m10243a.f1180b.setTarget(fragment.f3473J);
                        m10243a.f1180b.start();
                    }
                }
            }
        }
        if (fragment.f3479P) {
            m10204c(fragment);
        }
    }

    /* renamed from: k */
    public void m10176k(Fragment fragment) {
        m10244a(fragment, this.f1150m, 0, 0, false);
    }

    /* renamed from: l */
    public void m10174l(Fragment fragment) {
        if (fragment.f3475L) {
            if (this.f1140b) {
                this.f1160w = true;
                return;
            }
            fragment.f3475L = false;
            m10244a(fragment, this.f1150m, 0, 0, false);
        }
    }

    /* renamed from: m */
    public void m10172m(Fragment fragment) {
        if (f1130F) {
            Log.v("FragmentManager", "remove: " + fragment + " nesting=" + fragment.f3503r);
        }
        boolean z = !fragment.m7537N();
        if (!fragment.f3466C || z) {
            synchronized (this.f1142d) {
                this.f1142d.remove(fragment);
            }
            if (fragment.f3469F && fragment.f3470G) {
                this.f1155r = true;
            }
            fragment.f3497k = false;
            fragment.f3498m = true;
        }
    }

    /* renamed from: n */
    public Bundle m10170n(Fragment fragment) {
        Bundle bundle;
        if (this.f1134A == null) {
            this.f1134A = new Bundle();
        }
        fragment.m7467j(this.f1134A);
        m10196d(fragment, this.f1134A, false);
        if (this.f1134A.isEmpty()) {
            bundle = null;
        } else {
            bundle = this.f1134A;
            this.f1134A = null;
        }
        if (fragment.f3473J != null) {
            m10168o(fragment);
        }
        if (fragment.f3489c != null) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putSparseParcelableArray("android:view_state", fragment.f3489c);
        }
        if (!fragment.f3476M) {
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBoolean("android:user_visible_hint", fragment.f3476M);
        }
        return bundle;
    }

    /* renamed from: o */
    public void m10168o(Fragment fragment) {
        if (fragment.f3474K == null) {
            return;
        }
        SparseArray<Parcelable> sparseArray = this.f1135B;
        if (sparseArray == null) {
            this.f1135B = new SparseArray<>();
        } else {
            sparseArray.clear();
        }
        fragment.f3474K.saveHierarchyState(this.f1135B);
        if (this.f1135B.size() > 0) {
            fragment.f3489c = this.f1135B;
            this.f1135B = null;
        }
    }

    @Override // android.view.LayoutInflater.Factory2
    public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        Fragment fragment;
        if ("fragment".equals(str)) {
            String attributeValue = attributeSet.getAttributeValue(null, "class");
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0165k.f1189a);
            if (attributeValue == null) {
                attributeValue = obtainStyledAttributes.getString(0);
            }
            String str2 = attributeValue;
            int resourceId = obtainStyledAttributes.getResourceId(1, -1);
            String string = obtainStyledAttributes.getString(2);
            obtainStyledAttributes.recycle();
            if (Fragment.m7520a(this.f1151n.m10291c(), str2)) {
                int id = view != null ? view.getId() : 0;
                if (id == -1 && resourceId == -1 && string == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str2);
                }
                Fragment m10222b = resourceId != -1 ? m10222b(resourceId) : null;
                if (m10222b == null && string != null) {
                    m10222b = mo10231a(string);
                }
                if (m10222b == null && id != -1) {
                    m10222b = m10222b(id);
                }
                if (f1130F) {
                    Log.v("FragmentManager", "onCreateView: id=0x" + Integer.toHexString(resourceId) + " fname=" + str2 + " existing=" + m10222b);
                }
                if (m10222b == null) {
                    Fragment mo7440a = this.f1152o.mo7440a(context, str2, null);
                    mo7440a.f3499n = true;
                    mo7440a.f3510y = resourceId != 0 ? resourceId : id;
                    mo7440a.f3511z = id;
                    mo7440a.f3464A = string;
                    mo7440a.f3500o = true;
                    mo7440a.f3504s = this;
                    FragmentHostCallback fragmentHostCallback = this.f1151n;
                    mo7440a.f3505t = fragmentHostCallback;
                    mo7440a.m7521a(fragmentHostCallback.m10291c(), attributeSet, mo7440a.f3488b);
                    m10238a(mo7440a, true);
                    fragment = mo7440a;
                } else if (!m10222b.f3500o) {
                    m10222b.f3500o = true;
                    FragmentHostCallback fragmentHostCallback2 = this.f1151n;
                    m10222b.f3505t = fragmentHostCallback2;
                    if (!m10222b.f3468E) {
                        m10222b.m7521a(fragmentHostCallback2.m10291c(), attributeSet, m10222b.f3488b);
                    }
                    fragment = m10222b;
                } else {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string + ", or parent id 0x" + Integer.toHexString(id) + " with another fragment for " + str2);
                }
                if (this.f1150m < 1 && fragment.f3499n) {
                    m10244a(fragment, 1, 0, 0, false);
                } else {
                    m10176k(fragment);
                }
                View view2 = fragment.f3473J;
                if (view2 != null) {
                    if (resourceId != 0) {
                        view2.setId(resourceId);
                    }
                    if (fragment.f3473J.getTag() == null) {
                        fragment.f3473J.setTag(string);
                    }
                    return fragment.f3473J;
                }
                throw new IllegalStateException("Fragment " + str2 + " did not create a view.");
            }
            return null;
        }
        return null;
    }

    /* renamed from: p */
    public void m10167p() {
        this.f1156s = false;
        this.f1157t = false;
        m10263a(4);
    }

    /* renamed from: q */
    public void m10164q(Fragment fragment) {
        if (f1130F) {
            Log.v("FragmentManager", "show: " + fragment);
        }
        if (fragment.f3465B) {
            fragment.f3465B = false;
            fragment.f3479P = !fragment.f3479P;
        }
    }

    /* renamed from: r */
    public void m10163r() {
        this.f1157t = true;
        m10263a(2);
    }

    /* renamed from: s */
    public void m10162s() {
        if (this.f1160w) {
            this.f1160w = false;
            m10265E();
        }
    }

    /* renamed from: t */
    public final void m10161t() {
        SparseArray<Fragment> sparseArray = this.f1143e;
        int size = sparseArray == null ? 0 : sparseArray.size();
        for (int i = 0; i < size; i++) {
            Fragment valueAt = this.f1143e.valueAt(i);
            if (valueAt != null) {
                if (valueAt.m7458m() != null) {
                    int m7545F = valueAt.m7545F();
                    View m7458m = valueAt.m7458m();
                    Animation animation = m7458m.getAnimation();
                    if (animation != null) {
                        animation.cancel();
                        m7458m.clearAnimation();
                    }
                    valueAt.m7509a((View) null);
                    m10244a(valueAt, m7545F, 0, 0, false);
                } else if (valueAt.m7455n() != null) {
                    valueAt.m7455n().end();
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) Logger.DEFAULT_FULL_MESSAGE_LENGTH);
        sb.append("FragmentManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        Fragment fragment = this.f1153p;
        if (fragment != null) {
            DebugUtils.m9667a(fragment, sb);
        } else {
            DebugUtils.m9667a(this.f1151n, sb);
        }
        sb.append("}}");
        return sb.toString();
    }

    /* renamed from: u */
    public boolean m10160u() {
        m10200c(true);
        boolean z = false;
        while (m10209b(this.f1161x, this.f1162y)) {
            this.f1140b = true;
            try {
                m10201c(this.f1161x, this.f1162y);
                m10181i();
                z = true;
            } catch (Throwable th) {
                m10181i();
                throw th;
            }
        }
        m10162s();
        m10187g();
        return z;
    }

    /* renamed from: v */
    public final void m10159v() {
        if (this.f1136C != null) {
            while (!this.f1136C.isEmpty()) {
                this.f1136C.remove(0).m10152d();
            }
        }
    }

    /* renamed from: w */
    public LayoutInflater.Factory2 m10158w() {
        return this;
    }

    /* renamed from: x */
    public Fragment m10157x() {
        return this.f1154q;
    }

    /* renamed from: y */
    public void m10156y() {
        this.f1137D = null;
        this.f1156s = false;
        this.f1157t = false;
        int size = this.f1142d.size();
        for (int i = 0; i < size; i++) {
            Fragment fragment = this.f1142d.get(i);
            if (fragment != null) {
                fragment.m7531T();
            }
        }
    }

    /* renamed from: z */
    public void m10155z() {
        if (this.f1148j != null) {
            for (int i = 0; i < this.f1148j.size(); i++) {
                this.f1148j.get(i).m10270a();
            }
        }
    }

    /* renamed from: d */
    public void m10197d(Fragment fragment) {
        if (f1130F) {
            Log.v("FragmentManager", "detach: " + fragment);
        }
        if (fragment.f3466C) {
            return;
        }
        fragment.f3466C = true;
        if (fragment.f3497k) {
            if (f1130F) {
                Log.v("FragmentManager", "remove from detach: " + fragment);
            }
            synchronized (this.f1142d) {
                this.f1142d.remove(fragment);
            }
            if (fragment.f3469F && fragment.f3470G) {
                this.f1155r = true;
            }
            fragment.f3497k = false;
        }
    }

    /* renamed from: e */
    public void m10192e(Fragment fragment) {
        if (!fragment.f3499n || fragment.f3502q) {
            return;
        }
        fragment.m7502b(fragment.m7471i(fragment.f3488b), (ViewGroup) null, fragment.f3488b);
        View view = fragment.f3473J;
        if (view != null) {
            fragment.f3474K = view;
            view.setSaveFromParentEnabled(false);
            if (fragment.f3465B) {
                fragment.f3473J.setVisibility(8);
            }
            fragment.mo715a(fragment.f3473J, fragment.f3488b);
            m10239a(fragment, fragment.f3473J, fragment.f3488b, false);
            return;
        }
        fragment.f3474K = null;
    }

    /* renamed from: k */
    public void m10177k() {
        this.f1156s = false;
        this.f1157t = false;
        m10263a(1);
    }

    /* renamed from: f */
    public final Fragment m10189f(Fragment fragment) {
        ViewGroup viewGroup = fragment.f3472I;
        View view = fragment.f3473J;
        if (viewGroup != null && view != null) {
            for (int indexOf = this.f1142d.indexOf(fragment) - 1; indexOf >= 0; indexOf--) {
                Fragment fragment2 = this.f1142d.get(indexOf);
                if (fragment2.f3472I == viewGroup && fragment2.f3473J != null) {
                    return fragment2;
                }
            }
        }
        return null;
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: a.b.g.a.l$g */
    /* loaded from: classes.dex */
    public static class C0161g {

        /* renamed from: a */
        public final Animation f1179a;

        /* renamed from: b */
        public final Animator f1180b;

        public C0161g(Animation animation) {
            this.f1179a = animation;
            this.f1180b = null;
            if (animation == null) {
                throw new IllegalStateException("Animation cannot be null");
            }
        }

        public C0161g(Animator animator) {
            this.f1179a = null;
            this.f1180b = animator;
            if (animator == null) {
                throw new IllegalStateException("Animator cannot be null");
            }
        }
    }

    /* renamed from: p */
    public void m10166p(Fragment fragment) {
        if (fragment != null && (this.f1143e.get(fragment.f3491e) != fragment || (fragment.f3505t != null && fragment.m7447v() != this))) {
            throw new IllegalArgumentException("Fragment " + fragment + " is not an active fragment of FragmentManager " + this);
        }
        this.f1154q = fragment;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentManager
    /* renamed from: b */
    public int mo10223b() {
        ArrayList<BackStackRecord> arrayList = this.f1144f;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* renamed from: g */
    public final void m10187g() {
        SparseArray<Fragment> sparseArray = this.f1143e;
        if (sparseArray != null) {
            for (int size = sparseArray.size() - 1; size >= 0; size--) {
                if (this.f1143e.valueAt(size) == null) {
                    SparseArray<Fragment> sparseArray2 = this.f1143e;
                    sparseArray2.delete(sparseArray2.keyAt(size));
                }
            }
        }
    }

    /* renamed from: i */
    public final void m10181i() {
        this.f1140b = false;
        this.f1162y.clear();
        this.f1161x.clear();
    }

    /* renamed from: q */
    public void m10165q() {
        this.f1156s = false;
        this.f1157t = false;
        m10263a(3);
    }

    /* compiled from: FragmentManager.java */
    /* renamed from: a.b.g.a.l$i */
    /* loaded from: classes.dex */
    public static class RunnableC0163i extends AnimationSet implements Runnable {

        /* renamed from: a */
        public final ViewGroup f1182a;

        /* renamed from: b */
        public final View f1183b;

        /* renamed from: c */
        public boolean f1184c;

        /* renamed from: d */
        public boolean f1185d;

        /* renamed from: e */
        public boolean f1186e;

        public RunnableC0163i(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.f1186e = true;
            this.f1182a = viewGroup;
            this.f1183b = view;
            addAnimation(animation);
            this.f1182a.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.f1186e = true;
            if (this.f1184c) {
                return !this.f1185d;
            }
            if (!super.getTransformation(j, transformation)) {
                this.f1184c = true;
                OneShotPreDrawListener.m10363a(this.f1182a, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.f1184c && this.f1186e) {
                this.f1186e = false;
                this.f1182a.post(this);
                return;
            }
            this.f1182a.endViewTransition(this.f1183b);
            this.f1185d = true;
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.f1186e = true;
            if (this.f1184c) {
                return !this.f1185d;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.f1184c = true;
                OneShotPreDrawListener.m10363a(this.f1182a, this);
            }
            return true;
        }
    }

    /* renamed from: b */
    public void m10217b(Fragment fragment) {
        if (f1130F) {
            Log.v("FragmentManager", "attach: " + fragment);
        }
        if (fragment.f3466C) {
            fragment.f3466C = false;
            if (fragment.f3497k) {
                return;
            }
            if (!this.f1142d.contains(fragment)) {
                if (f1130F) {
                    Log.v("FragmentManager", "add from attach: " + fragment);
                }
                synchronized (this.f1142d) {
                    this.f1142d.add(fragment);
                }
                fragment.f3497k = true;
                if (fragment.f3469F && fragment.f3470G) {
                    this.f1155r = true;
                    return;
                }
                return;
            }
            throw new IllegalStateException("Fragment already added: " + fragment);
        }
    }

    /* renamed from: c */
    public void m10204c(Fragment fragment) {
        Animator animator;
        if (fragment.f3473J != null) {
            C0161g m10243a = m10243a(fragment, fragment.m7445x(), !fragment.f3465B, fragment.m7444y());
            if (m10243a != null && (animator = m10243a.f1180b) != null) {
                animator.setTarget(fragment.f3473J);
                if (fragment.f3465B) {
                    if (fragment.m7538M()) {
                        fragment.m7478g(false);
                    } else {
                        ViewGroup viewGroup = fragment.f3472I;
                        View view = fragment.f3473J;
                        viewGroup.startViewTransition(view);
                        m10243a.f1180b.addListener(new C0157d(this, viewGroup, view, fragment));
                    }
                } else {
                    fragment.f3473J.setVisibility(0);
                }
                m10234a(fragment.f3473J, m10243a);
                m10243a.f1180b.start();
            } else {
                if (m10243a != null) {
                    m10234a(fragment.f3473J, m10243a);
                    fragment.f3473J.startAnimation(m10243a.f1179a);
                    m10243a.f1179a.start();
                }
                fragment.f3473J.setVisibility((!fragment.f3465B || fragment.m7538M()) ? 0 : 8);
                if (fragment.m7538M()) {
                    fragment.m7478g(false);
                }
            }
        }
        if (fragment.f3497k && fragment.f3469F && fragment.f3470G) {
            this.f1155r = true;
        }
        fragment.f3479P = false;
        fragment.m7507a(fragment.f3465B);
    }

    /* renamed from: l */
    public void m10175l() {
        this.f1158u = true;
        m10160u();
        m10263a(0);
        this.f1151n = null;
        this.f1152o = null;
        this.f1153p = null;
    }

    /* renamed from: a */
    public static boolean m10252a(Animator animator) {
        if (animator == null) {
            return false;
        }
        if (animator instanceof ValueAnimator) {
            for (PropertyValuesHolder propertyValuesHolder : ((ValueAnimator) animator).getValues()) {
                if ("alpha".equals(propertyValuesHolder.getPropertyName())) {
                    return true;
                }
            }
        } else if (animator instanceof AnimatorSet) {
            ArrayList<Animator> childAnimations = ((AnimatorSet) animator).getChildAnimations();
            for (int i = 0; i < childAnimations.size(); i++) {
                if (m10252a(childAnimations.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: h */
    public final void m10184h() {
        if (!mo10199d()) {
            if (this.f1159v == null) {
                return;
            }
            throw new IllegalStateException("Can not perform this action inside of " + this.f1159v);
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    /* renamed from: f */
    public void m10188f(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f1153p;
        if (fragment2 != null) {
            FragmentManager m7447v = fragment2.m7447v();
            if (m7447v instanceof LayoutInflater$Factory2C0152l) {
                ((LayoutInflater$Factory2C0152l) m7447v).m10188f(fragment, true);
            }
        }
        Iterator<C0164j> it = this.f1149k.iterator();
        while (it.hasNext()) {
            C0164j next = it.next();
            if (!z || next.f1188b) {
                next.f1187a.m10273e(this, fragment);
            }
        }
    }

    /* renamed from: g */
    public void m10185g(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f1153p;
        if (fragment2 != null) {
            FragmentManager m7447v = fragment2.m7447v();
            if (m7447v instanceof LayoutInflater$Factory2C0152l) {
                ((LayoutInflater$Factory2C0152l) m7447v).m10185g(fragment, true);
            }
        }
        Iterator<C0164j> it = this.f1149k.iterator();
        while (it.hasNext()) {
            C0164j next = it.next();
            if (!z || next.f1188b) {
                next.f1187a.m10272f(this, fragment);
            }
        }
    }

    /* renamed from: o */
    public void m10169o() {
        m10263a(3);
    }

    /* renamed from: e */
    public void m10191e(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f1153p;
        if (fragment2 != null) {
            FragmentManager m7447v = fragment2.m7447v();
            if (m7447v instanceof LayoutInflater$Factory2C0152l) {
                ((LayoutInflater$Factory2C0152l) m7447v).m10191e(fragment, true);
            }
        }
        Iterator<C0164j> it = this.f1149k.iterator();
        while (it.hasNext()) {
            C0164j next = it.next();
            if (!z || next.f1188b) {
                next.f1187a.m10275d(this, fragment);
            }
        }
    }

    /* renamed from: h */
    public void m10182h(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f1153p;
        if (fragment2 != null) {
            FragmentManager m7447v = fragment2.m7447v();
            if (m7447v instanceof LayoutInflater$Factory2C0152l) {
                ((LayoutInflater$Factory2C0152l) m7447v).m10182h(fragment, true);
            }
        }
        Iterator<C0164j> it = this.f1149k.iterator();
        while (it.hasNext()) {
            C0164j next = it.next();
            if (!z || next.f1188b) {
                next.f1187a.m10271g(this, fragment);
            }
        }
    }

    /* renamed from: m */
    public void m10173m() {
        m10263a(1);
    }

    @Override // p000a.p006b.p030g.p031a.FragmentManager
    /* renamed from: d */
    public boolean mo10199d() {
        return this.f1156s || this.f1157t;
    }

    /* renamed from: d */
    public void m10195d(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f1153p;
        if (fragment2 != null) {
            FragmentManager m7447v = fragment2.m7447v();
            if (m7447v instanceof LayoutInflater$Factory2C0152l) {
                ((LayoutInflater$Factory2C0152l) m7447v).m10195d(fragment, true);
            }
        }
        Iterator<C0164j> it = this.f1149k.iterator();
        while (it.hasNext()) {
            C0164j next = it.next();
            if (!z || next.f1188b) {
                next.f1187a.m10277c(this, fragment);
            }
        }
    }

    /* renamed from: a */
    public final void m10232a(RuntimeException runtimeException) {
        Log.e("FragmentManager", runtimeException.getMessage());
        Log.e("FragmentManager", "Activity state:");
        PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
        FragmentHostCallback fragmentHostCallback = this.f1151n;
        if (fragmentHostCallback != null) {
            try {
                fragmentHostCallback.mo10294a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e) {
                Log.e("FragmentManager", "Failed dumping state", e);
            }
        } else {
            try {
                mo10229a("  ", (FileDescriptor) null, printWriter, new String[0]);
            } catch (Exception e2) {
                Log.e("FragmentManager", "Failed dumping state", e2);
            }
        }
        throw runtimeException;
    }

    /* renamed from: n */
    public void m10171n() {
        for (int i = 0; i < this.f1142d.size(); i++) {
            Fragment fragment = this.f1142d.get(i);
            if (fragment != null) {
                fragment.m7477g0();
            }
        }
    }

    /* renamed from: b */
    public Fragment m10222b(int i) {
        for (int size = this.f1142d.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f1142d.get(size);
            if (fragment != null && fragment.f3510y == i) {
                return fragment;
            }
        }
        SparseArray<Fragment> sparseArray = this.f1143e;
        if (sparseArray != null) {
            for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
                Fragment valueAt = this.f1143e.valueAt(size2);
                if (valueAt != null && valueAt.f3510y == i) {
                    return valueAt;
                }
            }
            return null;
        }
        return null;
    }

    /* renamed from: d */
    public void m10196d(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f1153p;
        if (fragment2 != null) {
            FragmentManager m7447v = fragment2.m7447v();
            if (m7447v instanceof LayoutInflater$Factory2C0152l) {
                ((LayoutInflater$Factory2C0152l) m7447v).m10196d(fragment, bundle, true);
            }
        }
        Iterator<C0164j> it = this.f1149k.iterator();
        while (it.hasNext()) {
            C0164j next = it.next();
            if (!z || next.f1188b) {
                next.f1187a.m10274d(this, fragment, bundle);
            }
        }
    }

    @Override // p000a.p006b.p030g.p031a.FragmentManager
    /* renamed from: a */
    public FragmentTransaction mo10264a() {
        return new BackStackRecord(this);
    }

    @Override // p000a.p006b.p030g.p031a.FragmentManager
    /* renamed from: a */
    public void mo10262a(int i, int i2) {
        if (i >= 0) {
            m10255a((InterfaceC0166l) new C0167m(null, i, i2), false);
            return;
        }
        throw new IllegalArgumentException("Bad id: " + i);
    }

    /* renamed from: b */
    public Fragment m10210b(String str) {
        Fragment m7508a;
        SparseArray<Fragment> sparseArray = this.f1143e;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size = sparseArray.size() - 1; size >= 0; size--) {
            Fragment valueAt = this.f1143e.valueAt(size);
            if (valueAt != null && (m7508a = valueAt.m7508a(str)) != null) {
                return m7508a;
            }
        }
        return null;
    }

    /* renamed from: a */
    public final boolean m10230a(String str, int i, int i2) {
        FragmentManager m7492c0;
        m10160u();
        m10200c(true);
        Fragment fragment = this.f1154q;
        if (fragment == null || i >= 0 || str != null || (m7492c0 = fragment.m7492c0()) == null || !m7492c0.mo10190f()) {
            boolean m10225a = m10225a(this.f1161x, this.f1162y, str, i, i2);
            if (m10225a) {
                this.f1140b = true;
                try {
                    m10201c(this.f1161x, this.f1162y);
                } finally {
                    m10181i();
                }
            }
            m10162s();
            m10187g();
            return m10225a;
        }
        return true;
    }

    /* renamed from: j */
    public void m10179j() {
        this.f1156s = false;
        this.f1157t = false;
        m10263a(2);
    }

    /* renamed from: b */
    public int m10220b(BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.f1147i != null && this.f1147i.size() > 0) {
                int intValue = this.f1147i.remove(this.f1147i.size() - 1).intValue();
                if (f1130F) {
                    Log.v("FragmentManager", "Adding back stack index " + intValue + " with " + backStackRecord);
                }
                this.f1146h.set(intValue, backStackRecord);
                return intValue;
            }
            if (this.f1146h == null) {
                this.f1146h = new ArrayList<>();
            }
            int size = this.f1146h.size();
            if (f1130F) {
                Log.v("FragmentManager", "Setting back stack index " + size + " to " + backStackRecord);
            }
            this.f1146h.add(backStackRecord);
            return size;
        }
    }

    /* renamed from: c */
    public void m10205c(int i) {
        synchronized (this) {
            this.f1146h.set(i, null);
            if (this.f1147i == null) {
                this.f1147i = new ArrayList<>();
            }
            if (f1130F) {
                Log.v("FragmentManager", "Freeing back stack index " + i);
            }
            this.f1147i.add(Integer.valueOf(i));
        }
    }

    @Override // p000a.p006b.p030g.p031a.FragmentManager
    /* renamed from: a */
    public void mo10247a(Bundle bundle, String str, Fragment fragment) {
        int i = fragment.f3491e;
        if (i >= 0) {
            bundle.putInt(str, i);
            return;
        }
        m10232a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    /* renamed from: c */
    public final void m10200c(boolean z) {
        if (!this.f1140b) {
            if (this.f1151n != null) {
                if (Looper.myLooper() == this.f1151n.m10289e().getLooper()) {
                    if (!z) {
                        m10184h();
                    }
                    if (this.f1161x == null) {
                        this.f1161x = new ArrayList<>();
                        this.f1162y = new ArrayList<>();
                    }
                    this.f1140b = true;
                    try {
                        m10228a((ArrayList<BackStackRecord>) null, (ArrayList<Boolean>) null);
                        return;
                    } finally {
                        this.f1140b = false;
                    }
                }
                throw new IllegalStateException("Must be called from main thread of fragment host");
            }
            throw new IllegalStateException("Fragment host has been destroyed");
        }
        throw new IllegalStateException("FragmentManager is already executing transactions");
    }

    @Override // p000a.p006b.p030g.p031a.FragmentManager
    /* renamed from: a */
    public Fragment mo10248a(Bundle bundle, String str) {
        int i = bundle.getInt(str, -1);
        if (i == -1) {
            return null;
        }
        Fragment fragment = this.f1143e.get(i);
        if (fragment != null) {
            return fragment;
        }
        m10232a(new IllegalStateException("Fragment no longer exists for key " + str + ": index " + i));
        throw null;
    }

    /* renamed from: b */
    public void m10219b(InterfaceC0166l interfaceC0166l, boolean z) {
        if (z && (this.f1151n == null || this.f1158u)) {
            return;
        }
        m10200c(z);
        if (interfaceC0166l.mo10154a(this.f1161x, this.f1162y)) {
            this.f1140b = true;
            try {
                m10201c(this.f1161x, this.f1162y);
            } finally {
                m10181i();
            }
        }
        m10162s();
        m10187g();
    }

    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // p000a.p006b.p030g.p031a.FragmentManager
    /* renamed from: a */
    public Fragment.C0606f mo10245a(Fragment fragment) {
        Bundle m10170n;
        if (fragment.f3491e >= 0) {
            if (fragment.f3487a <= 0 || (m10170n = m10170n(fragment)) == null) {
                return null;
            }
            return new Fragment.C0606f(m10170n);
        }
        m10232a(new IllegalStateException("Fragment " + fragment + " is not currently in the FragmentManager"));
        throw null;
    }

    @Override // p000a.p006b.p030g.p031a.FragmentManager
    /* renamed from: a */
    public void mo10229a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int size;
        int size2;
        int size3;
        int size4;
        int size5;
        String str2 = str + "    ";
        SparseArray<Fragment> sparseArray = this.f1143e;
        if (sparseArray != null && (size5 = sparseArray.size()) > 0) {
            printWriter.print(str);
            printWriter.print("Active Fragments in ");
            printWriter.print(Integer.toHexString(System.identityHashCode(this)));
            printWriter.println(":");
            for (int i = 0; i < size5; i++) {
                Fragment valueAt = this.f1143e.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i);
                printWriter.print(": ");
                printWriter.println(valueAt);
                if (valueAt != null) {
                    valueAt.mo5378a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
        int size6 = this.f1142d.size();
        if (size6 > 0) {
            printWriter.print(str);
            printWriter.println("Added Fragments:");
            for (int i2 = 0; i2 < size6; i2++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i2);
                printWriter.print(": ");
                printWriter.println(this.f1142d.get(i2).toString());
            }
        }
        ArrayList<Fragment> arrayList = this.f1145g;
        if (arrayList != null && (size4 = arrayList.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Fragments Created Menus:");
            for (int i3 = 0; i3 < size4; i3++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i3);
                printWriter.print(": ");
                printWriter.println(this.f1145g.get(i3).toString());
            }
        }
        ArrayList<BackStackRecord> arrayList2 = this.f1144f;
        if (arrayList2 != null && (size3 = arrayList2.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Back Stack:");
            for (int i4 = 0; i4 < size3; i4++) {
                BackStackRecord backStackRecord = this.f1144f.get(i4);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i4);
                printWriter.print(": ");
                printWriter.println(backStackRecord.toString());
                backStackRecord.m10379a(str2, fileDescriptor, printWriter, strArr);
            }
        }
        synchronized (this) {
            if (this.f1146h != null && (size2 = this.f1146h.size()) > 0) {
                printWriter.print(str);
                printWriter.println("Back Stack Indices:");
                for (int i5 = 0; i5 < size2; i5++) {
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(i5);
                    printWriter.print(": ");
                    printWriter.println((BackStackRecord) this.f1146h.get(i5));
                }
            }
            if (this.f1147i != null && this.f1147i.size() > 0) {
                printWriter.print(str);
                printWriter.print("mAvailBackStackIndices: ");
                printWriter.println(Arrays.toString(this.f1147i.toArray()));
            }
        }
        ArrayList<InterfaceC0166l> arrayList3 = this.f1139a;
        if (arrayList3 != null && (size = arrayList3.size()) > 0) {
            printWriter.print(str);
            printWriter.println("Pending Actions:");
            for (int i6 = 0; i6 < size; i6++) {
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(i6);
                printWriter.print(": ");
                printWriter.println((InterfaceC0166l) this.f1139a.get(i6));
            }
        }
        printWriter.print(str);
        printWriter.println("FragmentManager misc state:");
        printWriter.print(str);
        printWriter.print("  mHost=");
        printWriter.println(this.f1151n);
        printWriter.print(str);
        printWriter.print("  mContainer=");
        printWriter.println(this.f1152o);
        if (this.f1153p != null) {
            printWriter.print(str);
            printWriter.print("  mParent=");
            printWriter.println(this.f1153p);
        }
        printWriter.print(str);
        printWriter.print("  mCurState=");
        printWriter.print(this.f1150m);
        printWriter.print(" mStateSaved=");
        printWriter.print(this.f1156s);
        printWriter.print(" mStopped=");
        printWriter.print(this.f1157t);
        printWriter.print(" mDestroyed=");
        printWriter.println(this.f1158u);
        if (this.f1155r) {
            printWriter.print(str);
            printWriter.print("  mNeedMenuInvalidate=");
            printWriter.println(this.f1155r);
        }
        if (this.f1159v != null) {
            printWriter.print(str);
            printWriter.print("  mNoTransactionsBecause=");
            printWriter.println(this.f1159v);
        }
    }

    /* renamed from: b */
    public final void m10218b(ArraySet<Fragment> arraySet) {
        int size = arraySet.size();
        for (int i = 0; i < size; i++) {
            Fragment m9674d = arraySet.m9674d(i);
            if (!m9674d.f3497k) {
                View m7543H = m9674d.m7543H();
                m9674d.f3480Q = m7543H.getAlpha();
                m7543H.setAlpha(0.0f);
            }
        }
    }

    /* renamed from: c */
    public final void m10201c(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (arrayList2 != null && arrayList.size() == arrayList2.size()) {
            m10228a(arrayList, arrayList2);
            int size = arrayList.size();
            int i = 0;
            int i2 = 0;
            while (i < size) {
                if (!arrayList.get(i).f1067t) {
                    if (i2 != i) {
                        m10227a(arrayList, arrayList2, i2, i);
                    }
                    i2 = i + 1;
                    if (arrayList2.get(i).booleanValue()) {
                        while (i2 < size && arrayList2.get(i2).booleanValue() && !arrayList.get(i2).f1067t) {
                            i2++;
                        }
                    }
                    m10227a(arrayList, arrayList2, i, i2);
                    i = i2 - 1;
                }
                i++;
            }
            if (i2 != size) {
                m10227a(arrayList, arrayList2, i2, size);
                return;
            }
            return;
        }
        throw new IllegalStateException("Internal error with the back stack records");
    }

    /* renamed from: b */
    public static void m10208b(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        while (i < i2) {
            BackStackRecord backStackRecord = arrayList.get(i);
            if (arrayList2.get(i).booleanValue()) {
                backStackRecord.m10374b(-1);
                backStackRecord.m10371b(i == i2 + (-1));
            } else {
                backStackRecord.m10374b(1);
                backStackRecord.m10368e();
            }
            i++;
        }
    }

    /* renamed from: b */
    public final boolean m10209b(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        synchronized (this) {
            if (this.f1139a != null && this.f1139a.size() != 0) {
                int size = this.f1139a.size();
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    z |= this.f1139a.get(i).mo10154a(arrayList, arrayList2);
                }
                this.f1139a.clear();
                this.f1151n.m10289e().removeCallbacks(this.f1138E);
                return z;
            }
            return false;
        }
    }

    /* renamed from: c */
    public void m10203c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f1153p;
        if (fragment2 != null) {
            FragmentManager m7447v = fragment2.m7447v();
            if (m7447v instanceof LayoutInflater$Factory2C0152l) {
                ((LayoutInflater$Factory2C0152l) m7447v).m10203c(fragment, bundle, true);
            }
        }
        Iterator<C0164j> it = this.f1149k.iterator();
        while (it.hasNext()) {
            C0164j next = it.next();
            if (!z || next.f1188b) {
                next.f1187a.m10276c(this, fragment, bundle);
            }
        }
    }

    /* renamed from: b */
    public void m10207b(boolean z) {
        for (int size = this.f1142d.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f1142d.get(size);
            if (fragment != null) {
                fragment.m7484e(z);
            }
        }
    }

    /* renamed from: c */
    public void m10202c(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f1153p;
        if (fragment2 != null) {
            FragmentManager m7447v = fragment2.m7447v();
            if (m7447v instanceof LayoutInflater$Factory2C0152l) {
                ((LayoutInflater$Factory2C0152l) m7447v).m10202c(fragment, true);
            }
        }
        Iterator<C0164j> it = this.f1149k.iterator();
        while (it.hasNext()) {
            C0164j next = it.next();
            if (!z || next.f1188b) {
                next.f1187a.m10280b(this, fragment);
            }
        }
    }

    /* renamed from: b */
    public boolean m10213b(Menu menu) {
        if (this.f1150m < 1) {
            return false;
        }
        boolean z = false;
        for (int i = 0; i < this.f1142d.size(); i++) {
            Fragment fragment = this.f1142d.get(i);
            if (fragment != null && fragment.m7489d(menu)) {
                z = true;
            }
        }
        return z;
    }

    /* renamed from: b */
    public boolean m10212b(MenuItem menuItem) {
        if (this.f1150m < 1) {
            return false;
        }
        for (int i = 0; i < this.f1142d.size(); i++) {
            Fragment fragment = this.f1142d.get(i);
            if (fragment != null && fragment.m7485e(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public void m10216b(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.f1153p;
        if (fragment2 != null) {
            FragmentManager m7447v = fragment2.m7447v();
            if (m7447v instanceof LayoutInflater$Factory2C0152l) {
                ((LayoutInflater$Factory2C0152l) m7447v).m10216b(fragment, context, true);
            }
        }
        Iterator<C0164j> it = this.f1149k.iterator();
        while (it.hasNext()) {
            C0164j next = it.next();
            if (!z || next.f1188b) {
                next.f1187a.m10279b(this, fragment, context);
            }
        }
    }

    /* renamed from: b */
    public void m10215b(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f1153p;
        if (fragment2 != null) {
            FragmentManager m7447v = fragment2.m7447v();
            if (m7447v instanceof LayoutInflater$Factory2C0152l) {
                ((LayoutInflater$Factory2C0152l) m7447v).m10215b(fragment, bundle, true);
            }
        }
        Iterator<C0164j> it = this.f1149k.iterator();
        while (it.hasNext()) {
            C0164j next = it.next();
            if (!z || next.f1188b) {
                next.f1187a.m10278b(this, fragment, bundle);
            }
        }
    }

    /* renamed from: b */
    public void m10214b(Fragment fragment, boolean z) {
        Fragment fragment2 = this.f1153p;
        if (fragment2 != null) {
            FragmentManager m7447v = fragment2.m7447v();
            if (m7447v instanceof LayoutInflater$Factory2C0152l) {
                ((LayoutInflater$Factory2C0152l) m7447v).m10214b(fragment, true);
            }
        }
        Iterator<C0164j> it = this.f1149k.iterator();
        while (it.hasNext()) {
            C0164j next = it.next();
            if (!z || next.f1188b) {
                next.f1187a.m10284a(this, fragment);
            }
        }
    }

    /* renamed from: a */
    public static C0161g m10250a(Context context, float f, float f2, float f3, float f4) {
        AnimationSet animationSet = new AnimationSet(false);
        ScaleAnimation scaleAnimation = new ScaleAnimation(f, f2, f, f2, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(f1132H);
        scaleAnimation.setDuration(220L);
        animationSet.addAnimation(scaleAnimation);
        AlphaAnimation alphaAnimation = new AlphaAnimation(f3, f4);
        alphaAnimation.setInterpolator(f1133I);
        alphaAnimation.setDuration(220L);
        animationSet.addAnimation(alphaAnimation);
        return new C0161g(animationSet);
    }

    /* renamed from: a */
    public static C0161g m10251a(Context context, float f, float f2) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(f, f2);
        alphaAnimation.setInterpolator(f1133I);
        alphaAnimation.setDuration(220L);
        return new C0161g(alphaAnimation);
    }

    /* renamed from: a */
    public C0161g m10243a(Fragment fragment, int i, boolean z, int i2) {
        int m10221b;
        int m7446w = fragment.m7446w();
        Animation m7525a = fragment.m7525a(i, z, m7446w);
        if (m7525a != null) {
            return new C0161g(m7525a);
        }
        Animator m7504b = fragment.m7504b(i, z, m7446w);
        if (m7504b != null) {
            return new C0161g(m7504b);
        }
        if (m7446w != 0) {
            boolean equals = "anim".equals(this.f1151n.m10291c().getResources().getResourceTypeName(m7446w));
            boolean z2 = false;
            if (equals) {
                try {
                    Animation loadAnimation = AnimationUtils.loadAnimation(this.f1151n.m10291c(), m7446w);
                    if (loadAnimation != null) {
                        return new C0161g(loadAnimation);
                    }
                    z2 = true;
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                }
            }
            if (!z2) {
                try {
                    Animator loadAnimator = AnimatorInflater.loadAnimator(this.f1151n.m10291c(), m7446w);
                    if (loadAnimator != null) {
                        return new C0161g(loadAnimator);
                    }
                } catch (RuntimeException e2) {
                    if (!equals) {
                        Animation loadAnimation2 = AnimationUtils.loadAnimation(this.f1151n.m10291c(), m7446w);
                        if (loadAnimation2 != null) {
                            return new C0161g(loadAnimation2);
                        }
                    } else {
                        throw e2;
                    }
                }
            }
        }
        if (i != 0 && (m10221b = m10221b(i, z)) >= 0) {
            switch (m10221b) {
                case 1:
                    return m10250a(this.f1151n.m10291c(), 1.125f, 1.0f, 0.0f, 1.0f);
                case 2:
                    return m10250a(this.f1151n.m10291c(), 1.0f, 0.975f, 1.0f, 0.0f);
                case 3:
                    return m10250a(this.f1151n.m10291c(), 0.975f, 1.0f, 0.0f, 1.0f);
                case 4:
                    return m10250a(this.f1151n.m10291c(), 1.0f, 1.075f, 1.0f, 0.0f);
                case 5:
                    return m10251a(this.f1151n.m10291c(), 0.0f, 1.0f);
                case 6:
                    return m10251a(this.f1151n.m10291c(), 1.0f, 0.0f);
                default:
                    if (i2 == 0 && this.f1151n.mo10286h()) {
                        i2 = this.f1151n.mo10287g();
                    }
                    if (i2 == 0) {
                    }
                    return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static void m10234a(View view, C0161g c0161g) {
        if (view == null || c0161g == null || !m10211b(view, c0161g)) {
            return;
        }
        Animator animator = c0161g.f1180b;
        if (animator != null) {
            animator.addListener(new C0162h(view));
            return;
        }
        Animation.AnimationListener m10233a = m10233a(c0161g.f1179a);
        view.setLayerType(2, null);
        c0161g.f1179a.setAnimationListener(new C0158e(view, m10233a));
    }

    /* renamed from: a */
    public static Animation.AnimationListener m10233a(Animation animation) {
        try {
            if (f1131G == null) {
                f1131G = Animation.class.getDeclaredField("mListener");
                f1131G.setAccessible(true);
            }
            return (Animation.AnimationListener) f1131G.get(animation);
        } catch (IllegalAccessException e) {
            Log.e("FragmentManager", "Cannot access Animation's mListener field", e);
            return null;
        } catch (NoSuchFieldException e2) {
            Log.e("FragmentManager", "No field with the name mListener is found in Animation class", e2);
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0072, code lost:
        if (r0 != 3) goto L43;
     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:225:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m10244a(android.support.p065v4.app.Fragment r17, int r18, int r19, int r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 1101
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p030g.p031a.LayoutInflater$Factory2C0152l.m10244a(android.support.v4.app.Fragment, int, int, int, boolean):void");
    }

    /* renamed from: a */
    public final void m10242a(Fragment fragment, C0161g c0161g, int i) {
        View view = fragment.f3473J;
        ViewGroup viewGroup = fragment.f3472I;
        viewGroup.startViewTransition(view);
        fragment.m7496c(i);
        Animation animation = c0161g.f1179a;
        if (animation != null) {
            RunnableC0163i runnableC0163i = new RunnableC0163i(animation, viewGroup, view);
            fragment.m7509a(fragment.f3473J);
            runnableC0163i.setAnimationListener(new C0154b(m10233a(runnableC0163i), viewGroup, fragment));
            m10234a(view, c0161g);
            fragment.f3473J.startAnimation(runnableC0163i);
            return;
        }
        Animator animator = c0161g.f1180b;
        fragment.m7524a(animator);
        animator.addListener(new C0156c(viewGroup, view, fragment));
        animator.setTarget(fragment.f3473J);
        m10234a(fragment.f3473J, c0161g);
        animator.start();
    }

    /* renamed from: a */
    public void m10260a(int i, boolean z) {
        FragmentHostCallback fragmentHostCallback;
        if (this.f1151n == null && i != 0) {
            throw new IllegalStateException("No activity");
        }
        if (z || i != this.f1150m) {
            this.f1150m = i;
            if (this.f1143e != null) {
                int size = this.f1142d.size();
                for (int i2 = 0; i2 < size; i2++) {
                    m10178j(this.f1142d.get(i2));
                }
                int size2 = this.f1143e.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    Fragment valueAt = this.f1143e.valueAt(i3);
                    if (valueAt != null && ((valueAt.f3498m || valueAt.f3466C) && !valueAt.f3478O)) {
                        m10178j(valueAt);
                    }
                }
                m10265E();
                if (this.f1155r && (fragmentHostCallback = this.f1151n) != null && this.f1150m == 4) {
                    fragmentHostCallback.mo10285i();
                    this.f1155r = false;
                }
            }
        }
    }

    /* renamed from: a */
    public void m10238a(Fragment fragment, boolean z) {
        if (f1130F) {
            Log.v("FragmentManager", "add: " + fragment);
        }
        m10183h(fragment);
        if (fragment.f3466C) {
            return;
        }
        if (!this.f1142d.contains(fragment)) {
            synchronized (this.f1142d) {
                this.f1142d.add(fragment);
            }
            fragment.f3497k = true;
            fragment.f3498m = false;
            if (fragment.f3473J == null) {
                fragment.f3479P = false;
            }
            if (fragment.f3469F && fragment.f3470G) {
                this.f1155r = true;
            }
            if (z) {
                m10176k(fragment);
                return;
            }
            return;
        }
        throw new IllegalStateException("Fragment already added: " + fragment);
    }

    @Override // p000a.p006b.p030g.p031a.FragmentManager
    /* renamed from: a */
    public Fragment mo10231a(String str) {
        if (str != null) {
            for (int size = this.f1142d.size() - 1; size >= 0; size--) {
                Fragment fragment = this.f1142d.get(size);
                if (fragment != null && str.equals(fragment.f3464A)) {
                    return fragment;
                }
            }
        }
        SparseArray<Fragment> sparseArray = this.f1143e;
        if (sparseArray == null || str == null) {
            return null;
        }
        for (int size2 = sparseArray.size() - 1; size2 >= 0; size2--) {
            Fragment valueAt = this.f1143e.valueAt(size2);
            if (valueAt != null && str.equals(valueAt.f3464A)) {
                return valueAt;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0027, code lost:
        return;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m10255a(p000a.p006b.p030g.p031a.LayoutInflater$Factory2C0152l.InterfaceC0166l r2, boolean r3) {
        /*
            r1 = this;
            if (r3 != 0) goto L5
            r1.m10184h()
        L5:
            monitor-enter(r1)
            boolean r0 = r1.f1158u     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto L24
            a.b.g.a.j r0 = r1.f1151n     // Catch: java.lang.Throwable -> L30
            if (r0 != 0) goto Lf
            goto L24
        Lf:
            java.util.ArrayList<a.b.g.a.l$l> r3 = r1.f1139a     // Catch: java.lang.Throwable -> L30
            if (r3 != 0) goto L1a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L30
            r3.<init>()     // Catch: java.lang.Throwable -> L30
            r1.f1139a = r3     // Catch: java.lang.Throwable -> L30
        L1a:
            java.util.ArrayList<a.b.g.a.l$l> r3 = r1.f1139a     // Catch: java.lang.Throwable -> L30
            r3.add(r2)     // Catch: java.lang.Throwable -> L30
            r1.m10266D()     // Catch: java.lang.Throwable -> L30
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L24:
            if (r3 == 0) goto L28
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            return
        L28:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L30
            java.lang.String r3 = "Activity has been destroyed"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L30
            throw r2     // Catch: java.lang.Throwable -> L30
        L30:
            r2 = move-exception
            monitor-exit(r1)     // Catch: java.lang.Throwable -> L30
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p000a.p006b.p030g.p031a.LayoutInflater$Factory2C0152l.m10255a(a.b.g.a.l$l, boolean):void");
    }

    /* renamed from: a */
    public void m10261a(int i, BackStackRecord backStackRecord) {
        synchronized (this) {
            if (this.f1146h == null) {
                this.f1146h = new ArrayList<>();
            }
            int size = this.f1146h.size();
            if (i < size) {
                if (f1130F) {
                    Log.v("FragmentManager", "Setting back stack index " + i + " to " + backStackRecord);
                }
                this.f1146h.set(i, backStackRecord);
            } else {
                while (size < i) {
                    this.f1146h.add(null);
                    if (this.f1147i == null) {
                        this.f1147i = new ArrayList<>();
                    }
                    if (f1130F) {
                        Log.v("FragmentManager", "Adding available back stack index " + size);
                    }
                    this.f1147i.add(Integer.valueOf(size));
                    size++;
                }
                if (f1130F) {
                    Log.v("FragmentManager", "Adding back stack index " + i + " with " + backStackRecord);
                }
                this.f1146h.add(backStackRecord);
            }
        }
    }

    /* renamed from: a */
    public final void m10228a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2) {
        int indexOf;
        int indexOf2;
        ArrayList<C0168n> arrayList3 = this.f1136C;
        int size = arrayList3 == null ? 0 : arrayList3.size();
        int i = 0;
        while (i < size) {
            C0168n c0168n = this.f1136C.get(i);
            if (arrayList != null && !c0168n.f1194a && (indexOf2 = arrayList.indexOf(c0168n.f1195b)) != -1 && arrayList2.get(indexOf2).booleanValue()) {
                c0168n.m10153c();
            } else if (c0168n.m10151e() || (arrayList != null && c0168n.f1195b.m10377a(arrayList, 0, arrayList.size()))) {
                this.f1136C.remove(i);
                i--;
                size--;
                if (arrayList != null && !c0168n.f1194a && (indexOf = arrayList.indexOf(c0168n.f1195b)) != -1 && arrayList2.get(indexOf).booleanValue()) {
                    c0168n.m10153c();
                } else {
                    c0168n.m10152d();
                }
            }
            i++;
        }
    }

    /* renamed from: a */
    public final void m10227a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2) {
        int i3;
        int i4;
        int i5 = i;
        boolean z = arrayList.get(i5).f1067t;
        ArrayList<Fragment> arrayList3 = this.f1163z;
        if (arrayList3 == null) {
            this.f1163z = new ArrayList<>();
        } else {
            arrayList3.clear();
        }
        this.f1163z.addAll(this.f1142d);
        Fragment m10157x = m10157x();
        boolean z2 = false;
        for (int i6 = i5; i6 < i2; i6++) {
            BackStackRecord backStackRecord = arrayList.get(i6);
            if (!arrayList2.get(i6).booleanValue()) {
                m10157x = backStackRecord.m10376a(this.f1163z, m10157x);
            } else {
                m10157x = backStackRecord.m10372b(this.f1163z, m10157x);
            }
            z2 = z2 || backStackRecord.f1056i;
        }
        this.f1163z.clear();
        if (!z) {
            FragmentTransition.m10132a(this, arrayList, arrayList2, i, i2, false);
        }
        m10208b(arrayList, arrayList2, i, i2);
        if (z) {
            ArraySet<Fragment> arraySet = new ArraySet<>();
            m10253a(arraySet);
            int m10226a = m10226a(arrayList, arrayList2, i, i2, arraySet);
            m10218b(arraySet);
            i3 = m10226a;
        } else {
            i3 = i2;
        }
        if (i3 != i5 && z) {
            FragmentTransition.m10132a(this, arrayList, arrayList2, i, i3, true);
            m10260a(this.f1150m, true);
        }
        while (i5 < i2) {
            BackStackRecord backStackRecord2 = arrayList.get(i5);
            if (arrayList2.get(i5).booleanValue() && (i4 = backStackRecord2.f1060m) >= 0) {
                m10205c(i4);
                backStackRecord2.f1060m = -1;
            }
            backStackRecord2.m10365h();
            i5++;
        }
        if (z2) {
            m10155z();
        }
    }

    /* renamed from: a */
    public final int m10226a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, int i, int i2, ArraySet<Fragment> arraySet) {
        int i3 = i2;
        for (int i4 = i2 - 1; i4 >= i; i4--) {
            BackStackRecord backStackRecord = arrayList.get(i4);
            boolean booleanValue = arrayList2.get(i4).booleanValue();
            if (backStackRecord.m10366g() && !backStackRecord.m10377a(arrayList, i4 + 1, i2)) {
                if (this.f1136C == null) {
                    this.f1136C = new ArrayList<>();
                }
                C0168n c0168n = new C0168n(backStackRecord, booleanValue);
                this.f1136C.add(c0168n);
                backStackRecord.m10380a(c0168n);
                if (booleanValue) {
                    backStackRecord.m10368e();
                } else {
                    backStackRecord.m10371b(false);
                }
                i3--;
                if (i4 != i3) {
                    arrayList.remove(i4);
                    arrayList.add(i3, backStackRecord);
                }
                m10253a(arraySet);
            }
        }
        return i3;
    }

    /* renamed from: a */
    public void m10258a(BackStackRecord backStackRecord, boolean z, boolean z2, boolean z3) {
        if (z) {
            backStackRecord.m10371b(z3);
        } else {
            backStackRecord.m10368e();
        }
        ArrayList arrayList = new ArrayList(1);
        ArrayList arrayList2 = new ArrayList(1);
        arrayList.add(backStackRecord);
        arrayList2.add(Boolean.valueOf(z));
        if (z2) {
            FragmentTransition.m10132a(this, (ArrayList<BackStackRecord>) arrayList, (ArrayList<Boolean>) arrayList2, 0, 1, true);
        }
        if (z3) {
            m10260a(this.f1150m, true);
        }
        SparseArray<Fragment> sparseArray = this.f1143e;
        if (sparseArray != null) {
            int size = sparseArray.size();
            for (int i = 0; i < size; i++) {
                Fragment valueAt = this.f1143e.valueAt(i);
                if (valueAt != null && valueAt.f3473J != null && valueAt.f3478O && backStackRecord.m10370c(valueAt.f3511z)) {
                    float f = valueAt.f3480Q;
                    if (f > 0.0f) {
                        valueAt.f3473J.setAlpha(f);
                    }
                    if (z3) {
                        valueAt.f3480Q = 0.0f;
                    } else {
                        valueAt.f3480Q = -1.0f;
                        valueAt.f3478O = false;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public final void m10253a(ArraySet<Fragment> arraySet) {
        int i = this.f1150m;
        if (i < 1) {
            return;
        }
        int min = Math.min(i, 3);
        int size = this.f1142d.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fragment fragment = this.f1142d.get(i2);
            if (fragment.f3487a < min) {
                m10244a(fragment, min, fragment.m7446w(), fragment.m7445x(), false);
                if (fragment.f3473J != null && !fragment.f3465B && fragment.f3478O) {
                    arraySet.add(fragment);
                }
            }
        }
    }

    /* renamed from: a */
    public void m10259a(BackStackRecord backStackRecord) {
        if (this.f1144f == null) {
            this.f1144f = new ArrayList<>();
        }
        this.f1144f.add(backStackRecord);
    }

    /* renamed from: a */
    public boolean m10225a(ArrayList<BackStackRecord> arrayList, ArrayList<Boolean> arrayList2, String str, int i, int i2) {
        int size;
        ArrayList<BackStackRecord> arrayList3 = this.f1144f;
        if (arrayList3 == null) {
            return false;
        }
        if (str == null && i < 0 && (i2 & 1) == 0) {
            int size2 = arrayList3.size() - 1;
            if (size2 < 0) {
                return false;
            }
            arrayList.add(this.f1144f.remove(size2));
            arrayList2.add(true);
        } else {
            if (str != null || i >= 0) {
                size = this.f1144f.size() - 1;
                while (size >= 0) {
                    BackStackRecord backStackRecord = this.f1144f.get(size);
                    if ((str != null && str.equals(backStackRecord.m10367f())) || (i >= 0 && i == backStackRecord.f1060m)) {
                        break;
                    }
                    size--;
                }
                if (size < 0) {
                    return false;
                }
                if ((i2 & 1) != 0) {
                    while (true) {
                        size--;
                        if (size < 0) {
                            break;
                        }
                        BackStackRecord backStackRecord2 = this.f1144f.get(size);
                        if (str == null || !str.equals(backStackRecord2.m10367f())) {
                            if (i < 0 || i != backStackRecord2.f1060m) {
                                break;
                            }
                        }
                    }
                }
            } else {
                size = -1;
            }
            if (size == this.f1144f.size() - 1) {
                return false;
            }
            for (int size3 = this.f1144f.size() - 1; size3 > size; size3--) {
                arrayList.add(this.f1144f.remove(size3));
                arrayList2.add(true);
            }
        }
        return true;
    }

    /* renamed from: a */
    public static void m10254a(FragmentManagerNonConfig fragmentManagerNonConfig) {
        if (fragmentManagerNonConfig == null) {
            return;
        }
        List<Fragment> m10149b = fragmentManagerNonConfig.m10149b();
        if (m10149b != null) {
            for (Fragment fragment : m10149b) {
                fragment.f3468E = true;
            }
        }
        List<FragmentManagerNonConfig> m10150a = fragmentManagerNonConfig.m10150a();
        if (m10150a != null) {
            for (FragmentManagerNonConfig fragmentManagerNonConfig2 : m10150a) {
                m10254a(fragmentManagerNonConfig2);
            }
        }
    }

    /* renamed from: a */
    public void m10246a(Parcelable parcelable, FragmentManagerNonConfig fragmentManagerNonConfig) {
        List<FragmentManagerNonConfig> list;
        List<ViewModelStore> list2;
        if (parcelable == null) {
            return;
        }
        C0169n c0169n = (C0169n) parcelable;
        if (c0169n.f1200a == null) {
            return;
        }
        if (fragmentManagerNonConfig != null) {
            List<Fragment> m10149b = fragmentManagerNonConfig.m10149b();
            list = fragmentManagerNonConfig.m10150a();
            list2 = fragmentManagerNonConfig.m10148c();
            int size = m10149b != null ? m10149b.size() : 0;
            for (int i = 0; i < size; i++) {
                Fragment fragment = m10149b.get(i);
                if (f1130F) {
                    Log.v("FragmentManager", "restoreAllState: re-attaching retained " + fragment);
                }
                int i2 = 0;
                while (true) {
                    FragmentState[] fragmentStateArr = c0169n.f1200a;
                    if (i2 >= fragmentStateArr.length || fragmentStateArr[i2].f1206b == fragment.f3491e) {
                        break;
                    }
                    i2++;
                }
                FragmentState[] fragmentStateArr2 = c0169n.f1200a;
                if (i2 != fragmentStateArr2.length) {
                    FragmentState fragmentState = fragmentStateArr2[i2];
                    fragmentState.f1216m = fragment;
                    fragment.f3489c = null;
                    fragment.f3503r = 0;
                    fragment.f3500o = false;
                    fragment.f3497k = false;
                    fragment.f3494h = null;
                    Bundle bundle = fragmentState.f1215k;
                    if (bundle != null) {
                        bundle.setClassLoader(this.f1151n.m10291c().getClassLoader());
                        fragment.f3489c = fragmentState.f1215k.getSparseParcelableArray("android:view_state");
                        fragment.f3488b = fragmentState.f1215k;
                    }
                } else {
                    m10232a(new IllegalStateException("Could not find active fragment with index " + fragment.f3491e));
                    throw null;
                }
            }
        } else {
            list = null;
            list2 = null;
        }
        this.f1143e = new SparseArray<>(c0169n.f1200a.length);
        int i3 = 0;
        while (true) {
            FragmentState[] fragmentStateArr3 = c0169n.f1200a;
            if (i3 >= fragmentStateArr3.length) {
                break;
            }
            FragmentState fragmentState2 = fragmentStateArr3[i3];
            if (fragmentState2 != null) {
                Fragment m10147a = fragmentState2.m10147a(this.f1151n, this.f1152o, this.f1153p, (list == null || i3 >= list.size()) ? null : list.get(i3), (list2 == null || i3 >= list2.size()) ? null : list2.get(i3));
                if (f1130F) {
                    Log.v("FragmentManager", "restoreAllState: active #" + i3 + ": " + m10147a);
                }
                this.f1143e.put(m10147a.f3491e, m10147a);
                fragmentState2.f1216m = null;
            }
            i3++;
        }
        if (fragmentManagerNonConfig != null) {
            List<Fragment> m10149b2 = fragmentManagerNonConfig.m10149b();
            int size2 = m10149b2 != null ? m10149b2.size() : 0;
            for (int i4 = 0; i4 < size2; i4++) {
                Fragment fragment2 = m10149b2.get(i4);
                int i5 = fragment2.f3495i;
                if (i5 >= 0) {
                    fragment2.f3494h = this.f1143e.get(i5);
                    if (fragment2.f3494h == null) {
                        Log.w("FragmentManager", "Re-attaching retained fragment " + fragment2 + " target no longer exists: " + fragment2.f3495i);
                    }
                }
            }
        }
        this.f1142d.clear();
        if (c0169n.f1201b != null) {
            int i6 = 0;
            while (true) {
                int[] iArr = c0169n.f1201b;
                if (i6 >= iArr.length) {
                    break;
                }
                Fragment fragment3 = this.f1143e.get(iArr[i6]);
                if (fragment3 != null) {
                    fragment3.f3497k = true;
                    if (f1130F) {
                        Log.v("FragmentManager", "restoreAllState: added #" + i6 + ": " + fragment3);
                    }
                    if (!this.f1142d.contains(fragment3)) {
                        synchronized (this.f1142d) {
                            this.f1142d.add(fragment3);
                        }
                        i6++;
                    } else {
                        throw new IllegalStateException("Already added!");
                    }
                } else {
                    m10232a(new IllegalStateException("No instantiated fragment for index #" + c0169n.f1201b[i6]));
                    throw null;
                }
            }
        }
        C0142d[] c0142dArr = c0169n.f1202c;
        if (c0142dArr != null) {
            this.f1144f = new ArrayList<>(c0142dArr.length);
            int i7 = 0;
            while (true) {
                C0142d[] c0142dArr2 = c0169n.f1202c;
                if (i7 >= c0142dArr2.length) {
                    break;
                }
                BackStackRecord m10362a = c0142dArr2[i7].m10362a(this);
                if (f1130F) {
                    Log.v("FragmentManager", "restoreAllState: back stack #" + i7 + " (index " + m10362a.f1060m + "): " + m10362a);
                    PrintWriter printWriter = new PrintWriter(new LogWriter("FragmentManager"));
                    m10362a.m10378a("  ", printWriter, false);
                    printWriter.close();
                }
                this.f1144f.add(m10362a);
                int i8 = m10362a.f1060m;
                if (i8 >= 0) {
                    m10261a(i8, m10362a);
                }
                i7++;
            }
        } else {
            this.f1144f = null;
        }
        int i9 = c0169n.f1203d;
        if (i9 >= 0) {
            this.f1154q = this.f1143e.get(i9);
        }
        this.f1141c = c0169n.f1204e;
    }

    /* renamed from: a */
    public void m10257a(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment) {
        if (this.f1151n == null) {
            this.f1151n = fragmentHostCallback;
            this.f1152o = fragmentContainer;
            this.f1153p = fragment;
            return;
        }
        throw new IllegalStateException("Already attached");
    }

    /* renamed from: a */
    public final void m10263a(int i) {
        try {
            this.f1140b = true;
            m10260a(i, false);
            this.f1140b = false;
            m10160u();
        } catch (Throwable th) {
            this.f1140b = false;
            throw th;
        }
    }

    /* renamed from: a */
    public void m10224a(boolean z) {
        for (int size = this.f1142d.size() - 1; size >= 0; size--) {
            Fragment fragment = this.f1142d.get(size);
            if (fragment != null) {
                fragment.m7487d(z);
            }
        }
    }

    /* renamed from: a */
    public void m10249a(Configuration configuration) {
        for (int i = 0; i < this.f1142d.size(); i++) {
            Fragment fragment = this.f1142d.get(i);
            if (fragment != null) {
                fragment.m7515a(configuration);
            }
        }
    }

    /* renamed from: a */
    public boolean m10236a(Menu menu, MenuInflater menuInflater) {
        if (this.f1150m < 1) {
            return false;
        }
        ArrayList<Fragment> arrayList = null;
        boolean z = false;
        for (int i = 0; i < this.f1142d.size(); i++) {
            Fragment fragment = this.f1142d.get(i);
            if (fragment != null && fragment.m7500b(menu, menuInflater)) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(fragment);
                z = true;
            }
        }
        if (this.f1145g != null) {
            for (int i2 = 0; i2 < this.f1145g.size(); i2++) {
                Fragment fragment2 = this.f1145g.get(i2);
                if (arrayList == null || !arrayList.contains(fragment2)) {
                    fragment2.m7530V();
                }
            }
        }
        this.f1145g = arrayList;
        return z;
    }

    /* renamed from: a */
    public boolean m10235a(MenuItem menuItem) {
        if (this.f1150m < 1) {
            return false;
        }
        for (int i = 0; i < this.f1142d.size(); i++) {
            Fragment fragment = this.f1142d.get(i);
            if (fragment != null && fragment.m7488d(menuItem)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public void m10237a(Menu menu) {
        if (this.f1150m < 1) {
            return;
        }
        for (int i = 0; i < this.f1142d.size(); i++) {
            Fragment fragment = this.f1142d.get(i);
            if (fragment != null) {
                fragment.m7495c(menu);
            }
        }
    }

    /* renamed from: a */
    public void m10241a(Fragment fragment, Context context, boolean z) {
        Fragment fragment2 = this.f1153p;
        if (fragment2 != null) {
            FragmentManager m7447v = fragment2.m7447v();
            if (m7447v instanceof LayoutInflater$Factory2C0152l) {
                ((LayoutInflater$Factory2C0152l) m7447v).m10241a(fragment, context, true);
            }
        }
        Iterator<C0164j> it = this.f1149k.iterator();
        while (it.hasNext()) {
            C0164j next = it.next();
            if (!z || next.f1188b) {
                next.f1187a.m10283a(this, fragment, context);
            }
        }
    }

    /* renamed from: a */
    public void m10240a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f1153p;
        if (fragment2 != null) {
            FragmentManager m7447v = fragment2.m7447v();
            if (m7447v instanceof LayoutInflater$Factory2C0152l) {
                ((LayoutInflater$Factory2C0152l) m7447v).m10240a(fragment, bundle, true);
            }
        }
        Iterator<C0164j> it = this.f1149k.iterator();
        while (it.hasNext()) {
            C0164j next = it.next();
            if (!z || next.f1188b) {
                next.f1187a.m10282a(this, fragment, bundle);
            }
        }
    }

    /* renamed from: a */
    public void m10239a(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment fragment2 = this.f1153p;
        if (fragment2 != null) {
            FragmentManager m7447v = fragment2.m7447v();
            if (m7447v instanceof LayoutInflater$Factory2C0152l) {
                ((LayoutInflater$Factory2C0152l) m7447v).m10239a(fragment, view, bundle, true);
            }
        }
        Iterator<C0164j> it = this.f1149k.iterator();
        while (it.hasNext()) {
            C0164j next = it.next();
            if (!z || next.f1188b) {
                next.f1187a.m10281a(this, fragment, view, bundle);
            }
        }
    }
}
