package a.b.b;

import a.b.b.d;
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
/* compiled from: ConstraintSet.java */
/* loaded from: classes.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f60b = {0, 4, 8};

    /* renamed from: c  reason: collision with root package name */
    public static SparseIntArray f61c = new SparseIntArray();

    /* renamed from: a  reason: collision with root package name */
    public HashMap<Integer, b> f62a = new HashMap<>();

    /* compiled from: ConstraintSet.java */
    /* loaded from: classes.dex */
    public static class b {
        public int A;
        public int B;
        public int C;
        public int D;
        public int E;
        public int F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public float Q;
        public float R;
        public int S;
        public int T;
        public float U;
        public boolean V;
        public float W;
        public float X;
        public float Y;
        public float Z;

        /* renamed from: a  reason: collision with root package name */
        public boolean f63a;
        public float a0;

        /* renamed from: b  reason: collision with root package name */
        public int f64b;
        public float b0;

        /* renamed from: c  reason: collision with root package name */
        public int f65c;
        public float c0;

        /* renamed from: d  reason: collision with root package name */
        public int f66d;
        public float d0;

        /* renamed from: e  reason: collision with root package name */
        public int f67e;
        public float e0;

        /* renamed from: f  reason: collision with root package name */
        public int f68f;
        public float f0;

        /* renamed from: g  reason: collision with root package name */
        public float f69g;
        public float g0;

        /* renamed from: h  reason: collision with root package name */
        public int f70h;
        public boolean h0;

        /* renamed from: i  reason: collision with root package name */
        public int f71i;
        public boolean i0;
        public int j;
        public int j0;
        public int k;
        public int k0;
        public int l;
        public int l0;
        public int m;
        public int m0;
        public int n;
        public int n0;
        public int o;
        public int o0;
        public int p;
        public float p0;
        public int q;
        public float q0;
        public int r;
        public boolean r0;
        public int s;
        public int s0;
        public int t;
        public int t0;
        public float u;
        public int[] u0;
        public float v;
        public String v0;
        public String w;
        public int x;
        public int y;
        public float z;

        public b() {
            this.f63a = false;
            this.f67e = -1;
            this.f68f = -1;
            this.f69g = -1.0f;
            this.f70h = -1;
            this.f71i = -1;
            this.j = -1;
            this.k = -1;
            this.l = -1;
            this.m = -1;
            this.n = -1;
            this.o = -1;
            this.p = -1;
            this.q = -1;
            this.r = -1;
            this.s = -1;
            this.t = -1;
            this.u = 0.5f;
            this.v = 0.5f;
            this.w = null;
            this.x = -1;
            this.y = 0;
            this.z = 0.0f;
            this.A = -1;
            this.B = -1;
            this.C = -1;
            this.D = -1;
            this.E = -1;
            this.F = -1;
            this.G = -1;
            this.H = -1;
            this.I = -1;
            this.J = 0;
            this.K = -1;
            this.L = -1;
            this.M = -1;
            this.N = -1;
            this.O = -1;
            this.P = -1;
            this.Q = 0.0f;
            this.R = 0.0f;
            this.S = 0;
            this.T = 0;
            this.U = 1.0f;
            this.V = false;
            this.W = 0.0f;
            this.X = 0.0f;
            this.Y = 0.0f;
            this.Z = 0.0f;
            this.a0 = 1.0f;
            this.b0 = 1.0f;
            this.c0 = Float.NaN;
            this.d0 = Float.NaN;
            this.e0 = 0.0f;
            this.f0 = 0.0f;
            this.g0 = 0.0f;
            this.h0 = false;
            this.i0 = false;
            this.j0 = 0;
            this.k0 = 0;
            this.l0 = -1;
            this.m0 = -1;
            this.n0 = -1;
            this.o0 = -1;
            this.p0 = 1.0f;
            this.q0 = 1.0f;
            this.r0 = false;
            this.s0 = -1;
            this.t0 = -1;
        }

        /* renamed from: clone */
        public b m3clone() {
            b bVar = new b();
            bVar.f63a = this.f63a;
            bVar.f64b = this.f64b;
            bVar.f65c = this.f65c;
            bVar.f67e = this.f67e;
            bVar.f68f = this.f68f;
            bVar.f69g = this.f69g;
            bVar.f70h = this.f70h;
            bVar.f71i = this.f71i;
            bVar.j = this.j;
            bVar.k = this.k;
            bVar.l = this.l;
            bVar.m = this.m;
            bVar.n = this.n;
            bVar.o = this.o;
            bVar.p = this.p;
            bVar.q = this.q;
            bVar.r = this.r;
            bVar.s = this.s;
            bVar.t = this.t;
            bVar.u = this.u;
            bVar.v = this.v;
            bVar.w = this.w;
            bVar.A = this.A;
            bVar.B = this.B;
            bVar.u = this.u;
            bVar.u = this.u;
            bVar.u = this.u;
            bVar.u = this.u;
            bVar.u = this.u;
            bVar.C = this.C;
            bVar.D = this.D;
            bVar.E = this.E;
            bVar.F = this.F;
            bVar.G = this.G;
            bVar.H = this.H;
            bVar.I = this.I;
            bVar.J = this.J;
            bVar.K = this.K;
            bVar.L = this.L;
            bVar.M = this.M;
            bVar.N = this.N;
            bVar.O = this.O;
            bVar.P = this.P;
            bVar.Q = this.Q;
            bVar.R = this.R;
            bVar.S = this.S;
            bVar.T = this.T;
            bVar.U = this.U;
            bVar.V = this.V;
            bVar.W = this.W;
            bVar.X = this.X;
            bVar.Y = this.Y;
            bVar.Z = this.Z;
            bVar.a0 = this.a0;
            bVar.b0 = this.b0;
            bVar.c0 = this.c0;
            bVar.d0 = this.d0;
            bVar.e0 = this.e0;
            bVar.f0 = this.f0;
            bVar.g0 = this.g0;
            bVar.h0 = this.h0;
            bVar.i0 = this.i0;
            bVar.j0 = this.j0;
            bVar.k0 = this.k0;
            bVar.l0 = this.l0;
            bVar.m0 = this.m0;
            bVar.n0 = this.n0;
            bVar.o0 = this.o0;
            bVar.p0 = this.p0;
            bVar.q0 = this.q0;
            bVar.s0 = this.s0;
            bVar.t0 = this.t0;
            int[] iArr = this.u0;
            if (iArr != null) {
                bVar.u0 = Arrays.copyOf(iArr, iArr.length);
            }
            bVar.x = this.x;
            bVar.y = this.y;
            bVar.z = this.z;
            bVar.r0 = this.r0;
            return bVar;
        }

        public final void a(a.b.b.b bVar, int i2, d.a aVar) {
            a(i2, aVar);
            if (bVar instanceof a.b.b.a) {
                this.t0 = 1;
                a.b.b.a aVar2 = (a.b.b.a) bVar;
                this.s0 = aVar2.getType();
                this.u0 = aVar2.getReferencedIds();
            }
        }

        public final void a(int i2, d.a aVar) {
            a(i2, (ConstraintLayout.a) aVar);
            this.U = aVar.m0;
            this.X = aVar.p0;
            this.Y = aVar.q0;
            this.Z = aVar.r0;
            this.a0 = aVar.s0;
            this.b0 = aVar.t0;
            this.c0 = aVar.u0;
            this.d0 = aVar.v0;
            this.e0 = aVar.w0;
            this.f0 = aVar.x0;
            this.g0 = aVar.y0;
            this.W = aVar.o0;
            this.V = aVar.n0;
        }

        public final void a(int i2, ConstraintLayout.a aVar) {
            this.f66d = i2;
            this.f70h = aVar.f2054d;
            this.f71i = aVar.f2055e;
            this.j = aVar.f2056f;
            this.k = aVar.f2057g;
            this.l = aVar.f2058h;
            this.m = aVar.f2059i;
            this.n = aVar.j;
            this.o = aVar.k;
            this.p = aVar.l;
            this.q = aVar.p;
            this.r = aVar.q;
            this.s = aVar.r;
            this.t = aVar.s;
            this.u = aVar.z;
            this.v = aVar.A;
            this.w = aVar.B;
            this.x = aVar.m;
            this.y = aVar.n;
            this.z = aVar.o;
            this.A = aVar.P;
            this.B = aVar.Q;
            this.C = aVar.R;
            this.f69g = aVar.f2053c;
            this.f67e = aVar.f2051a;
            this.f68f = aVar.f2052b;
            this.f64b = ((ViewGroup.MarginLayoutParams) aVar).width;
            this.f65c = ((ViewGroup.MarginLayoutParams) aVar).height;
            this.D = ((ViewGroup.MarginLayoutParams) aVar).leftMargin;
            this.E = ((ViewGroup.MarginLayoutParams) aVar).rightMargin;
            this.F = ((ViewGroup.MarginLayoutParams) aVar).topMargin;
            this.G = ((ViewGroup.MarginLayoutParams) aVar).bottomMargin;
            this.Q = aVar.E;
            this.R = aVar.D;
            this.T = aVar.G;
            this.S = aVar.F;
            boolean z = aVar.S;
            this.h0 = z;
            this.i0 = aVar.T;
            this.j0 = aVar.H;
            this.k0 = aVar.I;
            this.h0 = z;
            this.l0 = aVar.L;
            this.m0 = aVar.M;
            this.n0 = aVar.J;
            this.o0 = aVar.K;
            this.p0 = aVar.N;
            this.q0 = aVar.O;
            if (Build.VERSION.SDK_INT >= 17) {
                this.H = aVar.getMarginEnd();
                this.I = aVar.getMarginStart();
            }
        }

        public void a(ConstraintLayout.a aVar) {
            aVar.f2054d = this.f70h;
            aVar.f2055e = this.f71i;
            aVar.f2056f = this.j;
            aVar.f2057g = this.k;
            aVar.f2058h = this.l;
            aVar.f2059i = this.m;
            aVar.j = this.n;
            aVar.k = this.o;
            aVar.l = this.p;
            aVar.p = this.q;
            aVar.q = this.r;
            aVar.r = this.s;
            aVar.s = this.t;
            ((ViewGroup.MarginLayoutParams) aVar).leftMargin = this.D;
            ((ViewGroup.MarginLayoutParams) aVar).rightMargin = this.E;
            ((ViewGroup.MarginLayoutParams) aVar).topMargin = this.F;
            ((ViewGroup.MarginLayoutParams) aVar).bottomMargin = this.G;
            aVar.x = this.P;
            aVar.y = this.O;
            aVar.z = this.u;
            aVar.A = this.v;
            aVar.m = this.x;
            aVar.n = this.y;
            aVar.o = this.z;
            aVar.B = this.w;
            aVar.P = this.A;
            aVar.Q = this.B;
            aVar.E = this.Q;
            aVar.D = this.R;
            aVar.G = this.T;
            aVar.F = this.S;
            aVar.S = this.h0;
            aVar.T = this.i0;
            aVar.H = this.j0;
            aVar.I = this.k0;
            aVar.L = this.l0;
            aVar.M = this.m0;
            aVar.J = this.n0;
            aVar.K = this.o0;
            aVar.N = this.p0;
            aVar.O = this.q0;
            aVar.R = this.C;
            aVar.f2053c = this.f69g;
            aVar.f2051a = this.f67e;
            aVar.f2052b = this.f68f;
            ((ViewGroup.MarginLayoutParams) aVar).width = this.f64b;
            ((ViewGroup.MarginLayoutParams) aVar).height = this.f65c;
            if (Build.VERSION.SDK_INT >= 17) {
                aVar.setMarginStart(this.I);
                aVar.setMarginEnd(this.H);
            }
            aVar.a();
        }
    }

    static {
        f61c.append(g.ConstraintSet_layout_constraintLeft_toLeftOf, 25);
        f61c.append(g.ConstraintSet_layout_constraintLeft_toRightOf, 26);
        f61c.append(g.ConstraintSet_layout_constraintRight_toLeftOf, 29);
        f61c.append(g.ConstraintSet_layout_constraintRight_toRightOf, 30);
        f61c.append(g.ConstraintSet_layout_constraintTop_toTopOf, 36);
        f61c.append(g.ConstraintSet_layout_constraintTop_toBottomOf, 35);
        f61c.append(g.ConstraintSet_layout_constraintBottom_toTopOf, 4);
        f61c.append(g.ConstraintSet_layout_constraintBottom_toBottomOf, 3);
        f61c.append(g.ConstraintSet_layout_constraintBaseline_toBaselineOf, 1);
        f61c.append(g.ConstraintSet_layout_editor_absoluteX, 6);
        f61c.append(g.ConstraintSet_layout_editor_absoluteY, 7);
        f61c.append(g.ConstraintSet_layout_constraintGuide_begin, 17);
        f61c.append(g.ConstraintSet_layout_constraintGuide_end, 18);
        f61c.append(g.ConstraintSet_layout_constraintGuide_percent, 19);
        f61c.append(g.ConstraintSet_android_orientation, 27);
        f61c.append(g.ConstraintSet_layout_constraintStart_toEndOf, 32);
        f61c.append(g.ConstraintSet_layout_constraintStart_toStartOf, 33);
        f61c.append(g.ConstraintSet_layout_constraintEnd_toStartOf, 10);
        f61c.append(g.ConstraintSet_layout_constraintEnd_toEndOf, 9);
        f61c.append(g.ConstraintSet_layout_goneMarginLeft, 13);
        f61c.append(g.ConstraintSet_layout_goneMarginTop, 16);
        f61c.append(g.ConstraintSet_layout_goneMarginRight, 14);
        f61c.append(g.ConstraintSet_layout_goneMarginBottom, 11);
        f61c.append(g.ConstraintSet_layout_goneMarginStart, 15);
        f61c.append(g.ConstraintSet_layout_goneMarginEnd, 12);
        f61c.append(g.ConstraintSet_layout_constraintVertical_weight, 40);
        f61c.append(g.ConstraintSet_layout_constraintHorizontal_weight, 39);
        f61c.append(g.ConstraintSet_layout_constraintHorizontal_chainStyle, 41);
        f61c.append(g.ConstraintSet_layout_constraintVertical_chainStyle, 42);
        f61c.append(g.ConstraintSet_layout_constraintHorizontal_bias, 20);
        f61c.append(g.ConstraintSet_layout_constraintVertical_bias, 37);
        f61c.append(g.ConstraintSet_layout_constraintDimensionRatio, 5);
        f61c.append(g.ConstraintSet_layout_constraintLeft_creator, 75);
        f61c.append(g.ConstraintSet_layout_constraintTop_creator, 75);
        f61c.append(g.ConstraintSet_layout_constraintRight_creator, 75);
        f61c.append(g.ConstraintSet_layout_constraintBottom_creator, 75);
        f61c.append(g.ConstraintSet_layout_constraintBaseline_creator, 75);
        f61c.append(g.ConstraintSet_android_layout_marginLeft, 24);
        f61c.append(g.ConstraintSet_android_layout_marginRight, 28);
        f61c.append(g.ConstraintSet_android_layout_marginStart, 31);
        f61c.append(g.ConstraintSet_android_layout_marginEnd, 8);
        f61c.append(g.ConstraintSet_android_layout_marginTop, 34);
        f61c.append(g.ConstraintSet_android_layout_marginBottom, 2);
        f61c.append(g.ConstraintSet_android_layout_width, 23);
        f61c.append(g.ConstraintSet_android_layout_height, 21);
        f61c.append(g.ConstraintSet_android_visibility, 22);
        f61c.append(g.ConstraintSet_android_alpha, 43);
        f61c.append(g.ConstraintSet_android_elevation, 44);
        f61c.append(g.ConstraintSet_android_rotationX, 45);
        f61c.append(g.ConstraintSet_android_rotationY, 46);
        f61c.append(g.ConstraintSet_android_rotation, 60);
        f61c.append(g.ConstraintSet_android_scaleX, 47);
        f61c.append(g.ConstraintSet_android_scaleY, 48);
        f61c.append(g.ConstraintSet_android_transformPivotX, 49);
        f61c.append(g.ConstraintSet_android_transformPivotY, 50);
        f61c.append(g.ConstraintSet_android_translationX, 51);
        f61c.append(g.ConstraintSet_android_translationY, 52);
        f61c.append(g.ConstraintSet_android_translationZ, 53);
        f61c.append(g.ConstraintSet_layout_constraintWidth_default, 54);
        f61c.append(g.ConstraintSet_layout_constraintHeight_default, 55);
        f61c.append(g.ConstraintSet_layout_constraintWidth_max, 56);
        f61c.append(g.ConstraintSet_layout_constraintHeight_max, 57);
        f61c.append(g.ConstraintSet_layout_constraintWidth_min, 58);
        f61c.append(g.ConstraintSet_layout_constraintHeight_min, 59);
        f61c.append(g.ConstraintSet_layout_constraintCircle, 61);
        f61c.append(g.ConstraintSet_layout_constraintCircleRadius, 62);
        f61c.append(g.ConstraintSet_layout_constraintCircleAngle, 63);
        f61c.append(g.ConstraintSet_android_id, 38);
        f61c.append(g.ConstraintSet_layout_constraintWidth_percent, 69);
        f61c.append(g.ConstraintSet_layout_constraintHeight_percent, 70);
        f61c.append(g.ConstraintSet_chainUseRtl, 71);
        f61c.append(g.ConstraintSet_barrierDirection, 72);
        f61c.append(g.ConstraintSet_constraint_referenced_ids, 73);
        f61c.append(g.ConstraintSet_barrierAllowsGoneWidgets, 74);
    }

    public void a(d dVar) {
        int childCount = dVar.getChildCount();
        this.f62a.clear();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = dVar.getChildAt(i2);
            d.a aVar = (d.a) childAt.getLayoutParams();
            int id = childAt.getId();
            if (id != -1) {
                if (!this.f62a.containsKey(Integer.valueOf(id))) {
                    this.f62a.put(Integer.valueOf(id), new b());
                }
                b bVar = this.f62a.get(Integer.valueOf(id));
                if (childAt instanceof a.b.b.b) {
                    bVar.a((a.b.b.b) childAt, id, aVar);
                }
                bVar.a(id, aVar);
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public void a(ConstraintLayout constraintLayout) {
        int childCount = constraintLayout.getChildCount();
        HashSet hashSet = new HashSet(this.f62a.keySet());
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = constraintLayout.getChildAt(i2);
            int id = childAt.getId();
            if (id != -1) {
                if (this.f62a.containsKey(Integer.valueOf(id))) {
                    hashSet.remove(Integer.valueOf(id));
                    b bVar = this.f62a.get(Integer.valueOf(id));
                    if (childAt instanceof a.b.b.a) {
                        bVar.t0 = 1;
                    }
                    int i3 = bVar.t0;
                    if (i3 != -1 && i3 == 1) {
                        a.b.b.a aVar = (a.b.b.a) childAt;
                        aVar.setId(id);
                        aVar.setType(bVar.s0);
                        aVar.setAllowsGoneWidget(bVar.r0);
                        int[] iArr = bVar.u0;
                        if (iArr != null) {
                            aVar.setReferencedIds(iArr);
                        } else {
                            String str = bVar.v0;
                            if (str != null) {
                                bVar.u0 = a(aVar, str);
                                aVar.setReferencedIds(bVar.u0);
                            }
                        }
                    }
                    ConstraintLayout.a aVar2 = (ConstraintLayout.a) childAt.getLayoutParams();
                    bVar.a(aVar2);
                    childAt.setLayoutParams(aVar2);
                    childAt.setVisibility(bVar.J);
                    if (Build.VERSION.SDK_INT >= 17) {
                        childAt.setAlpha(bVar.U);
                        childAt.setRotation(bVar.X);
                        childAt.setRotationX(bVar.Y);
                        childAt.setRotationY(bVar.Z);
                        childAt.setScaleX(bVar.a0);
                        childAt.setScaleY(bVar.b0);
                        if (!Float.isNaN(bVar.c0)) {
                            childAt.setPivotX(bVar.c0);
                        }
                        if (!Float.isNaN(bVar.d0)) {
                            childAt.setPivotY(bVar.d0);
                        }
                        childAt.setTranslationX(bVar.e0);
                        childAt.setTranslationY(bVar.f0);
                        if (Build.VERSION.SDK_INT >= 21) {
                            childAt.setTranslationZ(bVar.g0);
                            if (bVar.V) {
                                childAt.setElevation(bVar.W);
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
            b bVar2 = this.f62a.get(num);
            int i4 = bVar2.t0;
            if (i4 != -1 && i4 == 1) {
                a.b.b.a aVar3 = new a.b.b.a(constraintLayout.getContext());
                aVar3.setId(num.intValue());
                int[] iArr2 = bVar2.u0;
                if (iArr2 != null) {
                    aVar3.setReferencedIds(iArr2);
                } else {
                    String str2 = bVar2.v0;
                    if (str2 != null) {
                        bVar2.u0 = a(aVar3, str2);
                        aVar3.setReferencedIds(bVar2.u0);
                    }
                }
                aVar3.setType(bVar2.s0);
                ConstraintLayout.a generateDefaultLayoutParams = constraintLayout.generateDefaultLayoutParams();
                aVar3.a();
                bVar2.a(generateDefaultLayoutParams);
                constraintLayout.addView(aVar3, generateDefaultLayoutParams);
            }
            if (bVar2.f63a) {
                View guideline = new Guideline(constraintLayout.getContext());
                guideline.setId(num.intValue());
                ConstraintLayout.a generateDefaultLayoutParams2 = constraintLayout.generateDefaultLayoutParams();
                bVar2.a(generateDefaultLayoutParams2);
                constraintLayout.addView(guideline, generateDefaultLayoutParams2);
            }
        }
    }

    public void a(Context context, int i2) {
        XmlResourceParser xml = context.getResources().getXml(i2);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                    continue;
                } else if (eventType != 2) {
                    continue;
                } else {
                    String name = xml.getName();
                    b a2 = a(context, Xml.asAttributeSet(xml));
                    if (name.equalsIgnoreCase("Guideline")) {
                        a2.f63a = true;
                    }
                    this.f62a.put(Integer.valueOf(a2.f66d), a2);
                    continue;
                }
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    public static int a(TypedArray typedArray, int i2, int i3) {
        int resourceId = typedArray.getResourceId(i2, i3);
        return resourceId == -1 ? typedArray.getInt(i2, -1) : resourceId;
    }

    public final b a(Context context, AttributeSet attributeSet) {
        b bVar = new b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.ConstraintSet);
        a(bVar, obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        return bVar;
    }

    public final void a(b bVar, TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            int i3 = f61c.get(index);
            switch (i3) {
                case 1:
                    bVar.p = a(typedArray, index, bVar.p);
                    break;
                case 2:
                    bVar.G = typedArray.getDimensionPixelSize(index, bVar.G);
                    break;
                case 3:
                    bVar.o = a(typedArray, index, bVar.o);
                    break;
                case 4:
                    bVar.n = a(typedArray, index, bVar.n);
                    break;
                case 5:
                    bVar.w = typedArray.getString(index);
                    break;
                case 6:
                    bVar.A = typedArray.getDimensionPixelOffset(index, bVar.A);
                    break;
                case 7:
                    bVar.B = typedArray.getDimensionPixelOffset(index, bVar.B);
                    break;
                case 8:
                    bVar.H = typedArray.getDimensionPixelSize(index, bVar.H);
                    break;
                case 9:
                    bVar.t = a(typedArray, index, bVar.t);
                    break;
                case 10:
                    bVar.s = a(typedArray, index, bVar.s);
                    break;
                case 11:
                    bVar.N = typedArray.getDimensionPixelSize(index, bVar.N);
                    break;
                case 12:
                    bVar.O = typedArray.getDimensionPixelSize(index, bVar.O);
                    break;
                case 13:
                    bVar.K = typedArray.getDimensionPixelSize(index, bVar.K);
                    break;
                case 14:
                    bVar.M = typedArray.getDimensionPixelSize(index, bVar.M);
                    break;
                case 15:
                    bVar.P = typedArray.getDimensionPixelSize(index, bVar.P);
                    break;
                case 16:
                    bVar.L = typedArray.getDimensionPixelSize(index, bVar.L);
                    break;
                case 17:
                    bVar.f67e = typedArray.getDimensionPixelOffset(index, bVar.f67e);
                    break;
                case 18:
                    bVar.f68f = typedArray.getDimensionPixelOffset(index, bVar.f68f);
                    break;
                case 19:
                    bVar.f69g = typedArray.getFloat(index, bVar.f69g);
                    break;
                case 20:
                    bVar.u = typedArray.getFloat(index, bVar.u);
                    break;
                case 21:
                    bVar.f65c = typedArray.getLayoutDimension(index, bVar.f65c);
                    break;
                case 22:
                    bVar.J = typedArray.getInt(index, bVar.J);
                    bVar.J = f60b[bVar.J];
                    break;
                case 23:
                    bVar.f64b = typedArray.getLayoutDimension(index, bVar.f64b);
                    break;
                case 24:
                    bVar.D = typedArray.getDimensionPixelSize(index, bVar.D);
                    break;
                case 25:
                    bVar.f70h = a(typedArray, index, bVar.f70h);
                    break;
                case 26:
                    bVar.f71i = a(typedArray, index, bVar.f71i);
                    break;
                case 27:
                    bVar.C = typedArray.getInt(index, bVar.C);
                    break;
                case 28:
                    bVar.E = typedArray.getDimensionPixelSize(index, bVar.E);
                    break;
                case 29:
                    bVar.j = a(typedArray, index, bVar.j);
                    break;
                case 30:
                    bVar.k = a(typedArray, index, bVar.k);
                    break;
                case 31:
                    bVar.I = typedArray.getDimensionPixelSize(index, bVar.I);
                    break;
                case 32:
                    bVar.q = a(typedArray, index, bVar.q);
                    break;
                case 33:
                    bVar.r = a(typedArray, index, bVar.r);
                    break;
                case 34:
                    bVar.F = typedArray.getDimensionPixelSize(index, bVar.F);
                    break;
                case 35:
                    bVar.m = a(typedArray, index, bVar.m);
                    break;
                case 36:
                    bVar.l = a(typedArray, index, bVar.l);
                    break;
                case 37:
                    bVar.v = typedArray.getFloat(index, bVar.v);
                    break;
                case 38:
                    bVar.f66d = typedArray.getResourceId(index, bVar.f66d);
                    break;
                case 39:
                    bVar.R = typedArray.getFloat(index, bVar.R);
                    break;
                case 40:
                    bVar.Q = typedArray.getFloat(index, bVar.Q);
                    break;
                case 41:
                    bVar.S = typedArray.getInt(index, bVar.S);
                    break;
                case 42:
                    bVar.T = typedArray.getInt(index, bVar.T);
                    break;
                case 43:
                    bVar.U = typedArray.getFloat(index, bVar.U);
                    break;
                case 44:
                    bVar.V = true;
                    bVar.W = typedArray.getDimension(index, bVar.W);
                    break;
                case 45:
                    bVar.Y = typedArray.getFloat(index, bVar.Y);
                    break;
                case 46:
                    bVar.Z = typedArray.getFloat(index, bVar.Z);
                    break;
                case 47:
                    bVar.a0 = typedArray.getFloat(index, bVar.a0);
                    break;
                case 48:
                    bVar.b0 = typedArray.getFloat(index, bVar.b0);
                    break;
                case 49:
                    bVar.c0 = typedArray.getFloat(index, bVar.c0);
                    break;
                case 50:
                    bVar.d0 = typedArray.getFloat(index, bVar.d0);
                    break;
                case 51:
                    bVar.e0 = typedArray.getDimension(index, bVar.e0);
                    break;
                case 52:
                    bVar.f0 = typedArray.getDimension(index, bVar.f0);
                    break;
                case 53:
                    bVar.g0 = typedArray.getDimension(index, bVar.g0);
                    break;
                default:
                    switch (i3) {
                        case 60:
                            bVar.X = typedArray.getFloat(index, bVar.X);
                            continue;
                        case 61:
                            bVar.x = a(typedArray, index, bVar.x);
                            continue;
                        case 62:
                            bVar.y = typedArray.getDimensionPixelSize(index, bVar.y);
                            continue;
                        case 63:
                            bVar.z = typedArray.getFloat(index, bVar.z);
                            continue;
                        default:
                            switch (i3) {
                                case 69:
                                    bVar.p0 = typedArray.getFloat(index, 1.0f);
                                    continue;
                                case 70:
                                    bVar.q0 = typedArray.getFloat(index, 1.0f);
                                    continue;
                                case 71:
                                    Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                                    continue;
                                case 72:
                                    bVar.s0 = typedArray.getInt(index, bVar.s0);
                                    continue;
                                case 73:
                                    bVar.v0 = typedArray.getString(index);
                                    continue;
                                case 74:
                                    bVar.r0 = typedArray.getBoolean(index, bVar.r0);
                                    continue;
                                case 75:
                                    Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + f61c.get(index));
                                    continue;
                                default:
                                    Log.w("ConstraintSet", "Unknown attribute 0x" + Integer.toHexString(index) + "   " + f61c.get(index));
                                    continue;
                                    continue;
                            }
                    }
            }
        }
    }

    public final int[] a(View view, String str) {
        int i2;
        Object a2;
        String[] split = str.split(",");
        Context context = view.getContext();
        int[] iArr = new int[split.length];
        int i3 = 0;
        int i4 = 0;
        while (i3 < split.length) {
            String trim = split[i3].trim();
            try {
                i2 = f.class.getField(trim).getInt(null);
            } catch (Exception unused) {
                i2 = 0;
            }
            if (i2 == 0) {
                i2 = context.getResources().getIdentifier(trim, DatabaseFieldConfigLoader.FIELD_NAME_ID, context.getPackageName());
            }
            if (i2 == 0 && view.isInEditMode() && (view.getParent() instanceof ConstraintLayout) && (a2 = ((ConstraintLayout) view.getParent()).a(0, trim)) != null && (a2 instanceof Integer)) {
                i2 = ((Integer) a2).intValue();
            }
            iArr[i4] = i2;
            i3++;
            i4++;
        }
        return i4 != split.length ? Arrays.copyOf(iArr, i4) : iArr;
    }
}
