package p000a.p006b.p008b;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
import p000a.p006b.p008b.Constraints;

/* renamed from: a.b.b.c */
/* loaded from: classes.dex */
public class ConstraintSet {

    /* renamed from: b */
    public static final int[] f59b = {0, 4, 8};

    /* renamed from: c */
    public static SparseIntArray f60c = new SparseIntArray();

    /* renamed from: a */
    public HashMap<Integer, C0020b> f61a = new HashMap<>();

    /* compiled from: ConstraintSet.java */
    /* renamed from: a.b.b.c$b */
    /* loaded from: classes.dex */
    public static class C0020b {

        /* renamed from: A */
        public int f62A;

        /* renamed from: B */
        public int f63B;

        /* renamed from: C */
        public int f64C;

        /* renamed from: D */
        public int f65D;

        /* renamed from: E */
        public int f66E;

        /* renamed from: F */
        public int f67F;

        /* renamed from: G */
        public int f68G;

        /* renamed from: H */
        public int f69H;

        /* renamed from: I */
        public int f70I;

        /* renamed from: J */
        public int f71J;

        /* renamed from: K */
        public int f72K;

        /* renamed from: L */
        public int f73L;

        /* renamed from: M */
        public int f74M;

        /* renamed from: N */
        public int f75N;

        /* renamed from: O */
        public int f76O;

        /* renamed from: P */
        public int f77P;

        /* renamed from: Q */
        public float f78Q;

        /* renamed from: R */
        public float f79R;

        /* renamed from: S */
        public int f80S;

        /* renamed from: T */
        public int f81T;

        /* renamed from: U */
        public float f82U;

        /* renamed from: V */
        public boolean f83V;

        /* renamed from: W */
        public float f84W;

        /* renamed from: X */
        public float f85X;

        /* renamed from: Y */
        public float f86Y;

        /* renamed from: Z */
        public float f87Z;

        /* renamed from: a */
        public boolean f88a;

        /* renamed from: a0 */
        public float f89a0;

        /* renamed from: b */
        public int f90b;

        /* renamed from: b0 */
        public float f91b0;

        /* renamed from: c */
        public int f92c;

        /* renamed from: c0 */
        public float f93c0;

        /* renamed from: d */
        public int f94d;

        /* renamed from: d0 */
        public float f95d0;

        /* renamed from: e */
        public int f96e;

        /* renamed from: e0 */
        public float f97e0;

        /* renamed from: f */
        public int f98f;

        /* renamed from: f0 */
        public float f99f0;

        /* renamed from: g */
        public float f100g;

        /* renamed from: g0 */
        public float f101g0;

        /* renamed from: h */
        public int f102h;

        /* renamed from: h0 */
        public boolean f103h0;

        /* renamed from: i */
        public int f104i;

        /* renamed from: i0 */
        public boolean f105i0;

        /* renamed from: j */
        public int f106j;

        /* renamed from: j0 */
        public int f107j0;

        /* renamed from: k */
        public int f108k;

        /* renamed from: k0 */
        public int f109k0;

        /* renamed from: l */
        public int f110l;

        /* renamed from: l0 */
        public int f111l0;

        /* renamed from: m */
        public int f112m;

        /* renamed from: m0 */
        public int f113m0;

        /* renamed from: n */
        public int f114n;

        /* renamed from: n0 */
        public int f115n0;

        /* renamed from: o */
        public int f116o;

        /* renamed from: o0 */
        public int f117o0;

        /* renamed from: p */
        public int f118p;

        /* renamed from: p0 */
        public float f119p0;

        /* renamed from: q */
        public int f120q;

        /* renamed from: q0 */
        public float f121q0;

        /* renamed from: r */
        public int f122r;

        /* renamed from: r0 */
        public boolean f123r0;

        /* renamed from: s */
        public int f124s;

        /* renamed from: s0 */
        public int f125s0;

        /* renamed from: t */
        public int f126t;

        /* renamed from: t0 */
        public int f127t0;

        /* renamed from: u */
        public float f128u;

        /* renamed from: u0 */
        public int[] f129u0;

        /* renamed from: v */
        public float f130v;

        /* renamed from: v0 */
        public String f131v0;

        /* renamed from: w */
        public String f132w;

        /* renamed from: x */
        public int f133x;

        /* renamed from: y */
        public int f134y;

        /* renamed from: z */
        public float f135z;

        public C0020b() {
            this.f88a = false;
            this.f96e = -1;
            this.f98f = -1;
            this.f100g = -1.0f;
            this.f102h = -1;
            this.f104i = -1;
            this.f106j = -1;
            this.f108k = -1;
            this.f110l = -1;
            this.f112m = -1;
            this.f114n = -1;
            this.f116o = -1;
            this.f118p = -1;
            this.f120q = -1;
            this.f122r = -1;
            this.f124s = -1;
            this.f126t = -1;
            this.f128u = 0.5f;
            this.f130v = 0.5f;
            this.f132w = null;
            this.f133x = -1;
            this.f134y = 0;
            this.f135z = 0.0f;
            this.f62A = -1;
            this.f63B = -1;
            this.f64C = -1;
            this.f65D = -1;
            this.f66E = -1;
            this.f67F = -1;
            this.f68G = -1;
            this.f69H = -1;
            this.f70I = -1;
            this.f71J = 0;
            this.f72K = -1;
            this.f73L = -1;
            this.f74M = -1;
            this.f75N = -1;
            this.f76O = -1;
            this.f77P = -1;
            this.f78Q = 0.0f;
            this.f79R = 0.0f;
            this.f80S = 0;
            this.f81T = 0;
            this.f82U = 1.0f;
            this.f83V = false;
            this.f84W = 0.0f;
            this.f85X = 0.0f;
            this.f86Y = 0.0f;
            this.f87Z = 0.0f;
            this.f89a0 = 1.0f;
            this.f91b0 = 1.0f;
            this.f93c0 = Float.NaN;
            this.f95d0 = Float.NaN;
            this.f97e0 = 0.0f;
            this.f99f0 = 0.0f;
            this.f101g0 = 0.0f;
            this.f103h0 = false;
            this.f105i0 = false;
            this.f107j0 = 0;
            this.f109k0 = 0;
            this.f111l0 = -1;
            this.f113m0 = -1;
            this.f115n0 = -1;
            this.f117o0 = -1;
            this.f119p0 = 1.0f;
            this.f121q0 = 1.0f;
            this.f123r0 = false;
            this.f125s0 = -1;
            this.f127t0 = -1;
        }

        /* renamed from: clone */
        public C0020b m11326clone() {
            C0020b c0020b = new C0020b();
            c0020b.f88a = this.f88a;
            c0020b.f90b = this.f90b;
            c0020b.f92c = this.f92c;
            c0020b.f96e = this.f96e;
            c0020b.f98f = this.f98f;
            c0020b.f100g = this.f100g;
            c0020b.f102h = this.f102h;
            c0020b.f104i = this.f104i;
            c0020b.f106j = this.f106j;
            c0020b.f108k = this.f108k;
            c0020b.f110l = this.f110l;
            c0020b.f112m = this.f112m;
            c0020b.f114n = this.f114n;
            c0020b.f116o = this.f116o;
            c0020b.f118p = this.f118p;
            c0020b.f120q = this.f120q;
            c0020b.f122r = this.f122r;
            c0020b.f124s = this.f124s;
            c0020b.f126t = this.f126t;
            c0020b.f128u = this.f128u;
            c0020b.f130v = this.f130v;
            c0020b.f132w = this.f132w;
            c0020b.f62A = this.f62A;
            c0020b.f63B = this.f63B;
            c0020b.f128u = this.f128u;
            c0020b.f128u = this.f128u;
            c0020b.f128u = this.f128u;
            c0020b.f128u = this.f128u;
            c0020b.f128u = this.f128u;
            c0020b.f64C = this.f64C;
            c0020b.f65D = this.f65D;
            c0020b.f66E = this.f66E;
            c0020b.f67F = this.f67F;
            c0020b.f68G = this.f68G;
            c0020b.f69H = this.f69H;
            c0020b.f70I = this.f70I;
            c0020b.f71J = this.f71J;
            c0020b.f72K = this.f72K;
            c0020b.f73L = this.f73L;
            c0020b.f74M = this.f74M;
            c0020b.f75N = this.f75N;
            c0020b.f76O = this.f76O;
            c0020b.f77P = this.f77P;
            c0020b.f78Q = this.f78Q;
            c0020b.f79R = this.f79R;
            c0020b.f80S = this.f80S;
            c0020b.f81T = this.f81T;
            c0020b.f82U = this.f82U;
            c0020b.f83V = this.f83V;
            c0020b.f84W = this.f84W;
            c0020b.f85X = this.f85X;
            c0020b.f86Y = this.f86Y;
            c0020b.f87Z = this.f87Z;
            c0020b.f89a0 = this.f89a0;
            c0020b.f91b0 = this.f91b0;
            c0020b.f93c0 = this.f93c0;
            c0020b.f95d0 = this.f95d0;
            c0020b.f97e0 = this.f97e0;
            c0020b.f99f0 = this.f99f0;
            c0020b.f101g0 = this.f101g0;
            c0020b.f103h0 = this.f103h0;
            c0020b.f105i0 = this.f105i0;
            c0020b.f107j0 = this.f107j0;
            c0020b.f109k0 = this.f109k0;
            c0020b.f111l0 = this.f111l0;
            c0020b.f113m0 = this.f113m0;
            c0020b.f115n0 = this.f115n0;
            c0020b.f117o0 = this.f117o0;
            c0020b.f119p0 = this.f119p0;
            c0020b.f121q0 = this.f121q0;
            c0020b.f125s0 = this.f125s0;
            c0020b.f127t0 = this.f127t0;
            int[] iArr = this.f129u0;
            if (iArr != null) {
                c0020b.f129u0 = Arrays.copyOf(iArr, iArr.length);
            }
            c0020b.f133x = this.f133x;
            c0020b.f134y = this.f134y;
            c0020b.f135z = this.f135z;
            c0020b.f123r0 = this.f123r0;
            return c0020b;
        }

        /* renamed from: a */
        public final void m11244a(ConstraintHelper constraintHelper, int i, Constraints.C0021a c0021a) {
            m11246a(i, c0021a);
            if (constraintHelper instanceof Barrier) {
                this.f127t0 = 1;
                Barrier barrier = (Barrier) constraintHelper;
                this.f125s0 = barrier.getType();
                this.f129u0 = barrier.getReferencedIds();
            }
        }

        /* renamed from: a */
        public final void m11246a(int i, Constraints.C0021a c0021a) {
            m11245a(i, (ConstraintLayout.C0520a) c0021a);
            this.f82U = c0021a.f137m0;
            this.f85X = c0021a.f140p0;
            this.f86Y = c0021a.f141q0;
            this.f87Z = c0021a.f142r0;
            this.f89a0 = c0021a.f143s0;
            this.f91b0 = c0021a.f144t0;
            this.f93c0 = c0021a.f145u0;
            this.f95d0 = c0021a.f146v0;
            this.f97e0 = c0021a.f147w0;
            this.f99f0 = c0021a.f148x0;
            this.f101g0 = c0021a.f149y0;
            this.f84W = c0021a.f139o0;
            this.f83V = c0021a.f138n0;
        }

        /* renamed from: a */
        public final void m11245a(int i, ConstraintLayout.C0520a c0520a) {
            this.f94d = i;
            this.f102h = c0520a.f3102d;
            this.f104i = c0520a.f3104e;
            this.f106j = c0520a.f3106f;
            this.f108k = c0520a.f3108g;
            this.f110l = c0520a.f3110h;
            this.f112m = c0520a.f3112i;
            this.f114n = c0520a.f3114j;
            this.f116o = c0520a.f3116k;
            this.f118p = c0520a.f3118l;
            this.f120q = c0520a.f3123p;
            this.f122r = c0520a.f3124q;
            this.f124s = c0520a.f3125r;
            this.f126t = c0520a.f3126s;
            this.f128u = c0520a.f3133z;
            this.f130v = c0520a.f3070A;
            this.f132w = c0520a.f3071B;
            this.f133x = c0520a.f3120m;
            this.f134y = c0520a.f3121n;
            this.f135z = c0520a.f3122o;
            this.f62A = c0520a.f3085P;
            this.f63B = c0520a.f3086Q;
            this.f64C = c0520a.f3087R;
            this.f100g = c0520a.f3100c;
            this.f96e = c0520a.f3096a;
            this.f98f = c0520a.f3098b;
            this.f90b = ((ViewGroup.MarginLayoutParams) c0520a).width;
            this.f92c = ((ViewGroup.MarginLayoutParams) c0520a).height;
            this.f65D = ((ViewGroup.MarginLayoutParams) c0520a).leftMargin;
            this.f66E = ((ViewGroup.MarginLayoutParams) c0520a).rightMargin;
            this.f67F = ((ViewGroup.MarginLayoutParams) c0520a).topMargin;
            this.f68G = ((ViewGroup.MarginLayoutParams) c0520a).bottomMargin;
            this.f78Q = c0520a.f3074E;
            this.f79R = c0520a.f3073D;
            this.f81T = c0520a.f3076G;
            this.f80S = c0520a.f3075F;
            boolean z = c0520a.f3088S;
            this.f103h0 = z;
            this.f105i0 = c0520a.f3089T;
            this.f107j0 = c0520a.f3077H;
            this.f109k0 = c0520a.f3078I;
            this.f103h0 = z;
            this.f111l0 = c0520a.f3081L;
            this.f113m0 = c0520a.f3082M;
            this.f115n0 = c0520a.f3079J;
            this.f117o0 = c0520a.f3080K;
            this.f119p0 = c0520a.f3083N;
            this.f121q0 = c0520a.f3084O;
            if (Build.VERSION.SDK_INT >= 17) {
                this.f69H = c0520a.getMarginEnd();
                this.f70I = c0520a.getMarginStart();
            }
        }

        /* renamed from: a */
        public void m11241a(ConstraintLayout.C0520a c0520a) {
            c0520a.f3102d = this.f102h;
            c0520a.f3104e = this.f104i;
            c0520a.f3106f = this.f106j;
            c0520a.f3108g = this.f108k;
            c0520a.f3110h = this.f110l;
            c0520a.f3112i = this.f112m;
            c0520a.f3114j = this.f114n;
            c0520a.f3116k = this.f116o;
            c0520a.f3118l = this.f118p;
            c0520a.f3123p = this.f120q;
            c0520a.f3124q = this.f122r;
            c0520a.f3125r = this.f124s;
            c0520a.f3126s = this.f126t;
            ((ViewGroup.MarginLayoutParams) c0520a).leftMargin = this.f65D;
            ((ViewGroup.MarginLayoutParams) c0520a).rightMargin = this.f66E;
            ((ViewGroup.MarginLayoutParams) c0520a).topMargin = this.f67F;
            ((ViewGroup.MarginLayoutParams) c0520a).bottomMargin = this.f68G;
            c0520a.f3131x = this.f77P;
            c0520a.f3132y = this.f76O;
            c0520a.f3133z = this.f128u;
            c0520a.f3070A = this.f130v;
            c0520a.f3120m = this.f133x;
            c0520a.f3121n = this.f134y;
            c0520a.f3122o = this.f135z;
            c0520a.f3071B = this.f132w;
            c0520a.f3085P = this.f62A;
            c0520a.f3086Q = this.f63B;
            c0520a.f3074E = this.f78Q;
            c0520a.f3073D = this.f79R;
            c0520a.f3076G = this.f81T;
            c0520a.f3075F = this.f80S;
            c0520a.f3088S = this.f103h0;
            c0520a.f3089T = this.f105i0;
            c0520a.f3077H = this.f107j0;
            c0520a.f3078I = this.f109k0;
            c0520a.f3081L = this.f111l0;
            c0520a.f3082M = this.f113m0;
            c0520a.f3079J = this.f115n0;
            c0520a.f3080K = this.f117o0;
            c0520a.f3083N = this.f119p0;
            c0520a.f3084O = this.f121q0;
            c0520a.f3087R = this.f64C;
            c0520a.f3100c = this.f100g;
            c0520a.f3096a = this.f96e;
            c0520a.f3098b = this.f98f;
            ((ViewGroup.MarginLayoutParams) c0520a).width = this.f90b;
            ((ViewGroup.MarginLayoutParams) c0520a).height = this.f92c;
            if (Build.VERSION.SDK_INT >= 17) {
                c0520a.setMarginStart(this.f70I);
                c0520a.setMarginEnd(this.f69H);
            }
            c0520a.m7922a();
        }
    }

    static {
        f60c.append(C0023g.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f60c.append(C0023g.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f60c.append(C0023g.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f60c.append(C0023g.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f60c.append(C0023g.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f60c.append(C0023g.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f60c.append(C0023g.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f60c.append(C0023g.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f60c.append(C0023g.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f60c.append(C0023g.ConstraintSet_layout_editor_absoluteX, 6);
        f60c.append(C0023g.ConstraintSet_layout_editor_absoluteY, 7);
        f60c.append(C0023g.ConstraintSet_layout_constraintGuide_begin, 17);
        f60c.append(C0023g.ConstraintSet_layout_constraintGuide_end, 18);
        f60c.append(C0023g.ConstraintSet_layout_constraintGuide_percent, 19);
        f60c.append(C0023g.ConstraintSet_android_orientation, 27);
        f60c.append(C0023g.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f60c.append(C0023g.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f60c.append(C0023g.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f60c.append(C0023g.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f60c.append(C0023g.ConstraintSet_layout_goneMarginLeft, 13);
        f60c.append(C0023g.ConstraintSet_layout_goneMarginTop, 16);
        f60c.append(C0023g.ConstraintSet_layout_goneMarginRight, 14);
        f60c.append(C0023g.ConstraintSet_layout_goneMarginBottom, 11);
        f60c.append(C0023g.ConstraintSet_layout_goneMarginStart, 15);
        f60c.append(C0023g.ConstraintSet_layout_goneMarginEnd, 12);
        f60c.append(C0023g.ConstraintSet_layout_constraintVertical_weight, 40);
        f60c.append(C0023g.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f60c.append(C0023g.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f60c.append(C0023g.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f60c.append(C0023g.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f60c.append(C0023g.ConstraintSet_layout_constraintVertical_bias, 37);
        f60c.append(C0023g.ConstraintSet_layout_constraintDimensionRatio, 5);
        f60c.append(C0023g.ConstraintSet_layout_constraintLeft_creator, 75);
        f60c.append(C0023g.ConstraintSet_layout_constraintTop_creator, 75);
        f60c.append(C0023g.ConstraintSet_layout_constraintRight_creator, 75);
        f60c.append(C0023g.ConstraintSet_layout_constraintBottom_creator, 75);
        f60c.append(C0023g.ConstraintSet_layout_constraintBaseline_creator, 75);
        f60c.append(C0023g.ConstraintSet_android_layout_marginLeft, 24);
        f60c.append(C0023g.ConstraintSet_android_layout_marginRight, 28);
        f60c.append(C0023g.ConstraintSet_android_layout_marginStart, 31);
        f60c.append(C0023g.ConstraintSet_android_layout_marginEnd, 8);
        f60c.append(C0023g.ConstraintSet_android_layout_marginTop, 34);
        f60c.append(C0023g.ConstraintSet_android_layout_marginBottom, 2);
        f60c.append(C0023g.ConstraintSet_android_layout_width, 23);
        f60c.append(C0023g.ConstraintSet_android_layout_height, 21);
        f60c.append(C0023g.ConstraintSet_android_visibility, 22);
        f60c.append(C0023g.ConstraintSet_android_alpha, 43);
        f60c.append(C0023g.ConstraintSet_android_elevation, 44);
        f60c.append(C0023g.ConstraintSet_android_rotationX, 45);
        f60c.append(C0023g.ConstraintSet_android_rotationY, 46);
        f60c.append(C0023g.ConstraintSet_android_rotation, 60);
        f60c.append(C0023g.ConstraintSet_android_scaleX, 47);
        f60c.append(C0023g.ConstraintSet_android_scaleY, 48);
        f60c.append(C0023g.ConstraintSet_android_transformPivotX, 49);
        f60c.append(C0023g.ConstraintSet_android_transformPivotY, 50);
        f60c.append(C0023g.ConstraintSet_android_translationX, 51);
        f60c.append(C0023g.ConstraintSet_android_translationY, 52);
        f60c.append(C0023g.ConstraintSet_android_translationZ, 53);
        f60c.append(C0023g.ConstraintSet_layout_constraintWidth_default, 54);
        f60c.append(C0023g.ConstraintSet_layout_constraintHeight_default, 55);
        f60c.append(C0023g.ConstraintSet_layout_constraintWidth_max, 56);
        f60c.append(C0023g.ConstraintSet_layout_constraintHeight_max, 57);
        f60c.append(C0023g.ConstraintSet_layout_constraintWidth_min, 58);
        f60c.append(C0023g.ConstraintSet_layout_constraintHeight_min, 59);
        f60c.append(C0023g.ConstraintSet_layout_constraintCircle, 61);
        f60c.append(C0023g.ConstraintSet_layout_constraintCircleRadius, 62);
        f60c.append(C0023g.ConstraintSet_layout_constraintCircleAngle, 63);
        f60c.append(C0023g.ConstraintSet_android_id, 38);
        f60c.append(C0023g.ConstraintSet_layout_constraintWidth_percent, 69);
        f60c.append(C0023g.ConstraintSet_layout_constraintHeight_percent, 70);
        f60c.append(C0023g.ConstraintSet_chainUseRtl, 71);
        f60c.append(C0023g.ConstraintSet_barrierDirection, 72);
        f60c.append(C0023g.ConstraintSet_constraint_referenced_ids, 73);
        f60c.append(C0023g.ConstraintSet_barrierAllowsGoneWidgets, 74);
    }

    /* renamed from: a */
    public void m11252a(Constraints constraints) {
        int childCount = constraints.getChildCount();
        this.f61a.clear();
        for (int i = 0; i < childCount; i++) {
            View childAt = constraints.getChildAt(i);
            Constraints.C0021a c0021a = (Constraints.C0021a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id != -1) {
                if (!this.f61a.containsKey(Integer.valueOf(id))) {
                    this.f61a.put(Integer.valueOf(id), new C0020b());
                }
                C0020b c0020b = this.f61a.get(Integer.valueOf(id));
                if (childAt instanceof ConstraintHelper) {
                    c0020b.m11244a((ConstraintHelper) childAt, id, c0021a);
                }
                c0020b.m11246a(id, c0021a);
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    /* renamed from: a */
    public void m11248a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f61a.keySet());
        for (int i = 0; i < childCount; i++) {
            View childAt = constraintLayout.getChildAt(i);
            int id = childAt.getId();
            if (id != -1) {
                if (this.f61a.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    C0020b c0020b = this.f61a.get(Integer.valueOf(id));
                    if (childAt instanceof Barrier) {
                        c0020b.f127t0 = 1;
                    }
                    int i2 = c0020b.f127t0;
                    if (i2 != -1 && i2 == 1) {
                        Barrier barrier = (Barrier) childAt;
                        barrier.setId(id);
                        barrier.setType(c0020b.f125s0);
                        barrier.setAllowsGoneWidget(c0020b.f123r0);
                        int[] iArr = c0020b.f129u0;
                        if (iArr != null) {
                            barrier.setReferencedIds(iArr);
                        } else {
                            String str = c0020b.f131v0;
                            if (str != null) {
                                c0020b.f129u0 = m11247a(barrier, str);
                                barrier.setReferencedIds(c0020b.f129u0);
                            }
                        }
                    }
                    ConstraintLayout.C0520a c0520a = (ConstraintLayout.C0520a) childAt.getLayoutParams();
                    c0020b.m11241a(c0520a);
                    childAt.setLayoutParams(c0520a);
                    childAt.setVisibility(c0020b.f71J);
                    if (Build.VERSION.SDK_INT >= 17) {
                        childAt.setAlpha(c0020b.f82U);
                        childAt.setRotation(c0020b.f85X);
                        childAt.setRotationX(c0020b.f86Y);
                        childAt.setRotationY(c0020b.f87Z);
                        childAt.setScaleX(c0020b.f89a0);
                        childAt.setScaleY(c0020b.f91b0);
                        if (!Float.isNaN(c0020b.f93c0)) {
                            childAt.setPivotX(c0020b.f93c0);
                        }
                        if (!Float.isNaN(c0020b.f95d0)) {
                            childAt.setPivotY(c0020b.f95d0);
                        }
                        childAt.setTranslationX(c0020b.f97e0);
                        childAt.setTranslationY(c0020b.f99f0);
                        if (Build.VERSION.SDK_INT >= 21) {
                            childAt.setTranslationZ(c0020b.f101g0);
                            if (c0020b.f83V) {
                                childAt.setElevation(c0020b.f84W);
                            }
                        }
                    }
                }
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            C0020b c0020b2 = this.f61a.get(num);
            int i3 = c0020b2.f127t0;
            if (i3 != -1 && i3 == 1) {
                Barrier barrier2 = new Barrier(constraintLayout.getContext());
                barrier2.setId(num.intValue());
                int[] iArr2 = c0020b2.f129u0;
                if (iArr2 != null) {
                    barrier2.setReferencedIds(iArr2);
                } else {
                    String str2 = c0020b2.f131v0;
                    if (str2 != null) {
                        c0020b2.f129u0 = m11247a(barrier2, str2);
                        barrier2.setReferencedIds(c0020b2.f129u0);
                    }
                }
                barrier2.setType(c0020b2.f125s0);
                ConstraintLayout.C0520a generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                barrier2.m11259a();
                c0020b2.m11241a(generateDefaultLayoutParams);
                constraintLayout.addView(barrier2, generateDefaultLayoutParams);
            }
            if (c0020b2.f88a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.C0520a generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                c0020b2.m11241a(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    /* renamed from: a */
    public void m11251a(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    C0020b m11250a = m11250a(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        m11250a.f88a = true;
                    }
                    this.f61a.put(Integer.valueOf(m11250a.f94d), m11250a);
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public static int m11249a(TypedArray typedArray, int i, int i2) {
        int resourceId = typedArray.getResourceId(i, i2);
        return resourceId == -1 ? typedArray.getInt(i, -1) : resourceId;
    }

    /* renamed from: a */
    public final C0020b m11250a(Context context, AttributeSet attributeSet) {
        C0020b c0020b = new C0020b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0023g.ConstraintSet);
        m11253a(c0020b, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return c0020b;
    }

    /* renamed from: a */
    public final void m11253a(C0020b c0020b, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int index = typedArray.getIndex(i);
            int i2 = f60c.get(index);
            switch (i2) {
                case 1:
                    c0020b.f118p = m11249a(typedArray, index, c0020b.f118p);
                    break;
                case 2:
                    c0020b.f68G = typedArray.getDimensionPixelSize(index, c0020b.f68G);
                    break;
                case 3:
                    c0020b.f116o = m11249a(typedArray, index, c0020b.f116o);
                    break;
                case 4:
                    c0020b.f114n = m11249a(typedArray, index, c0020b.f114n);
                    break;
                case 5:
                    c0020b.f132w = typedArray.getString(index);
                    break;
                case 6:
                    c0020b.f62A = typedArray.getDimensionPixelOffset(index, c0020b.f62A);
                    break;
                case 7:
                    c0020b.f63B = typedArray.getDimensionPixelOffset(index, c0020b.f63B);
                    break;
                case 8:
                    c0020b.f69H = typedArray.getDimensionPixelSize(index, c0020b.f69H);
                    break;
                case 9:
                    c0020b.f126t = m11249a(typedArray, index, c0020b.f126t);
                    break;
                case 10:
                    c0020b.f124s = m11249a(typedArray, index, c0020b.f124s);
                    break;
                case 11:
                    c0020b.f75N = typedArray.getDimensionPixelSize(index, c0020b.f75N);
                    break;
                case 12:
                    c0020b.f76O = typedArray.getDimensionPixelSize(index, c0020b.f76O);
                    break;
                case 13:
                    c0020b.f72K = typedArray.getDimensionPixelSize(index, c0020b.f72K);
                    break;
                case 14:
                    c0020b.f74M = typedArray.getDimensionPixelSize(index, c0020b.f74M);
                    break;
                case 15:
                    c0020b.f77P = typedArray.getDimensionPixelSize(index, c0020b.f77P);
                    break;
                case 16:
                    c0020b.f73L = typedArray.getDimensionPixelSize(index, c0020b.f73L);
                    break;
                case 17:
                    c0020b.f96e = typedArray.getDimensionPixelOffset(index, c0020b.f96e);
                    break;
                case 18:
                    c0020b.f98f = typedArray.getDimensionPixelOffset(index, c0020b.f98f);
                    break;
                case 19:
                    c0020b.f100g = typedArray.getFloat(index, c0020b.f100g);
                    break;
                case 20:
                    c0020b.f128u = typedArray.getFloat(index, c0020b.f128u);
                    break;
                case 21:
                    c0020b.f92c = typedArray.getLayoutDimension(index, c0020b.f92c);
                    break;
                case 22:
                    c0020b.f71J = typedArray.getInt(index, c0020b.f71J);
                    c0020b.f71J = f59b[c0020b.f71J];
                    break;
                case 23:
                    c0020b.f90b = typedArray.getLayoutDimension(index, c0020b.f90b);
                    break;
                case 24:
                    c0020b.f65D = typedArray.getDimensionPixelSize(index, c0020b.f65D);
                    break;
                case 25:
                    c0020b.f102h = m11249a(typedArray, index, c0020b.f102h);
                    break;
                case 26:
                    c0020b.f104i = m11249a(typedArray, index, c0020b.f104i);
                    break;
                case 27:
                    c0020b.f64C = typedArray.getInt(index, c0020b.f64C);
                    break;
                case 28:
                    c0020b.f66E = typedArray.getDimensionPixelSize(index, c0020b.f66E);
                    break;
                case 29:
                    c0020b.f106j = m11249a(typedArray, index, c0020b.f106j);
                    break;
                case 30:
                    c0020b.f108k = m11249a(typedArray, index, c0020b.f108k);
                    break;
                case 31:
                    c0020b.f70I = typedArray.getDimensionPixelSize(index, c0020b.f70I);
                    break;
                case 32:
                    c0020b.f120q = m11249a(typedArray, index, c0020b.f120q);
                    break;
                case 33:
                    c0020b.f122r = m11249a(typedArray, index, c0020b.f122r);
                    break;
                case 34:
                    c0020b.f67F = typedArray.getDimensionPixelSize(index, c0020b.f67F);
                    break;
                case 35:
                    c0020b.f112m = m11249a(typedArray, index, c0020b.f112m);
                    break;
                case 36:
                    c0020b.f110l = m11249a(typedArray, index, c0020b.f110l);
                    break;
                case 37:
                    c0020b.f130v = typedArray.getFloat(index, c0020b.f130v);
                    break;
                case 38:
                    c0020b.f94d = typedArray.getResourceId(index, c0020b.f94d);
                    break;
                case 39:
                    c0020b.f79R = typedArray.getFloat(index, c0020b.f79R);
                    break;
                case 40:
                    c0020b.f78Q = typedArray.getFloat(index, c0020b.f78Q);
                    break;
                case 41:
                    c0020b.f80S = typedArray.getInt(index, c0020b.f80S);
                    break;
                case 42:
                    c0020b.f81T = typedArray.getInt(index, c0020b.f81T);
                    break;
                case 43:
                    c0020b.f82U = typedArray.getFloat(index, c0020b.f82U);
                    break;
                case 44:
                    c0020b.f83V = true;
                    c0020b.f84W = typedArray.getDimension(index, c0020b.f84W);
                    break;
                case 45:
                    c0020b.f86Y = typedArray.getFloat(index, c0020b.f86Y);
                    break;
                case 46:
                    c0020b.f87Z = typedArray.getFloat(index, c0020b.f87Z);
                    break;
                case 47:
                    c0020b.f89a0 = typedArray.getFloat(index, c0020b.f89a0);
                    break;
                case 48:
                    c0020b.f91b0 = typedArray.getFloat(index, c0020b.f91b0);
                    break;
                case 49:
                    c0020b.f93c0 = typedArray.getFloat(index, c0020b.f93c0);
                    break;
                case 50:
                    c0020b.f95d0 = typedArray.getFloat(index, c0020b.f95d0);
                    break;
                case 51:
                    c0020b.f97e0 = typedArray.getDimension(index, c0020b.f97e0);
                    break;
                case 52:
                    c0020b.f99f0 = typedArray.getDimension(index, c0020b.f99f0);
                    break;
                case 53:
                    c0020b.f101g0 = typedArray.getDimension(index, c0020b.f101g0);
                    break;
                default:
                    switch (i2) {
                        case 60:
                            c0020b.f85X = typedArray.getFloat(index, c0020b.f85X);
                            continue;
                        case 61:
                            c0020b.f133x = m11249a(typedArray, index, c0020b.f133x);
                            continue;
                        case 62:
                            c0020b.f134y = typedArray.getDimensionPixelSize(index, c0020b.f134y);
                            continue;
                        case 63:
                            c0020b.f135z = typedArray.getFloat(index, c0020b.f135z);
                            continue;
                        default:
                            switch (i2) {
                                case 69:
                                    c0020b.f119p0 = typedArray.getFloat(index, 1.0f);
                                    continue;
                                case 70:
                                    c0020b.f121q0 = typedArray.getFloat(index, 1.0f);
                                    continue;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    continue;
                                case 72:
                                    c0020b.f125s0 = typedArray.getInt(index, c0020b.f125s0);
                                    continue;
                                case 73:
                                    c0020b.f131v0 = typedArray.getString(index);
                                    continue;
                                case 74:
                                    c0020b.f123r0 = typedArray.getBoolean(index, c0020b.f123r0);
                                    continue;
                                case 75:
                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f60c.get(index));
                                    continue;
                                default:
                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f60c.get(index));
                                    continue;
                                    continue;
                            }
                    }
            }
        }
    }

    /* renamed from: a */
    public final int[] m11247a(View view, String str) {
        int i;
        Object m7932a;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i2 = 0;
        int i3 = 0;
        while (i2 < split.length) {
            String trim = split[i2].trim();
            try {
                i = C0022f.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = context.getResources().getIdentifier(trim, DatabaseFieldConfigLoader.FIELD_NAME_ID, context.getPackageName());
            }
            if (i == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (m7932a = ((ConstraintLayout) view.getParent()).m7932a(0, trim)) != null && (m7932a instanceof Integer)) {
                i = ((Integer) m7932a).intValue();
            }
            iArr[i3] = i;
            i2++;
            i3++;
        }
        return i3 != split.length ? Arrays.copyOf(iArr, i3) : iArr;
    }
}
