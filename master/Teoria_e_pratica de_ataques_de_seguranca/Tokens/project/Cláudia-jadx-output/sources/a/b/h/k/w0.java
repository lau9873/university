package a.b.h.k;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: OrientationHelper.java */
/* loaded from: classes.dex */
public abstract class w0 {

    /* renamed from: a  reason: collision with root package name */
    public final RecyclerView.o f1975a;

    /* renamed from: b  reason: collision with root package name */
    public int f1976b;

    /* renamed from: c  reason: collision with root package name */
    public final Rect f1977c;

    /* compiled from: OrientationHelper.java */
    /* loaded from: classes.dex */
    public static class a extends w0 {
        public a(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // a.b.h.k.w0
        public int a() {
            return this.f1975a.q();
        }

        @Override // a.b.h.k.w0
        public int b() {
            return this.f1975a.q() - this.f1975a.o();
        }

        @Override // a.b.h.k.w0
        public int c(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1975a.g(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // a.b.h.k.w0
        public int d(View view) {
            return this.f1975a.f(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).leftMargin;
        }

        @Override // a.b.h.k.w0
        public int e(View view) {
            this.f1975a.a(view, true, this.f1977c);
            return this.f1977c.right;
        }

        @Override // a.b.h.k.w0
        public int f() {
            return this.f1975a.n();
        }

        @Override // a.b.h.k.w0
        public int g() {
            return (this.f1975a.q() - this.f1975a.n()) - this.f1975a.o();
        }

        @Override // a.b.h.k.w0
        public void a(int i2) {
            this.f1975a.d(i2);
        }

        @Override // a.b.h.k.w0
        public int b(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1975a.h(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // a.b.h.k.w0
        public int f(View view) {
            this.f1975a.a(view, true, this.f1977c);
            return this.f1977c.left;
        }

        @Override // a.b.h.k.w0
        public int a(View view) {
            return this.f1975a.i(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).rightMargin;
        }

        @Override // a.b.h.k.w0
        public int c() {
            return this.f1975a.o();
        }

        @Override // a.b.h.k.w0
        public int d() {
            return this.f1975a.r();
        }

        @Override // a.b.h.k.w0
        public int e() {
            return this.f1975a.i();
        }
    }

    /* compiled from: OrientationHelper.java */
    /* loaded from: classes.dex */
    public static class b extends w0 {
        public b(RecyclerView.o oVar) {
            super(oVar, null);
        }

        @Override // a.b.h.k.w0
        public int a() {
            return this.f1975a.h();
        }

        @Override // a.b.h.k.w0
        public int b() {
            return this.f1975a.h() - this.f1975a.m();
        }

        @Override // a.b.h.k.w0
        public int c(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1975a.h(view) + ((ViewGroup.MarginLayoutParams) pVar).leftMargin + ((ViewGroup.MarginLayoutParams) pVar).rightMargin;
        }

        @Override // a.b.h.k.w0
        public int d(View view) {
            return this.f1975a.j(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).topMargin;
        }

        @Override // a.b.h.k.w0
        public int e(View view) {
            this.f1975a.a(view, true, this.f1977c);
            return this.f1977c.bottom;
        }

        @Override // a.b.h.k.w0
        public int f() {
            return this.f1975a.p();
        }

        @Override // a.b.h.k.w0
        public int g() {
            return (this.f1975a.h() - this.f1975a.p()) - this.f1975a.m();
        }

        @Override // a.b.h.k.w0
        public void a(int i2) {
            this.f1975a.e(i2);
        }

        @Override // a.b.h.k.w0
        public int b(View view) {
            RecyclerView.p pVar = (RecyclerView.p) view.getLayoutParams();
            return this.f1975a.g(view) + ((ViewGroup.MarginLayoutParams) pVar).topMargin + ((ViewGroup.MarginLayoutParams) pVar).bottomMargin;
        }

        @Override // a.b.h.k.w0
        public int f(View view) {
            this.f1975a.a(view, true, this.f1977c);
            return this.f1977c.top;
        }

        @Override // a.b.h.k.w0
        public int a(View view) {
            return this.f1975a.e(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.p) view.getLayoutParams())).bottomMargin;
        }

        @Override // a.b.h.k.w0
        public int c() {
            return this.f1975a.m();
        }

        @Override // a.b.h.k.w0
        public int d() {
            return this.f1975a.i();
        }

        @Override // a.b.h.k.w0
        public int e() {
            return this.f1975a.r();
        }
    }

    public /* synthetic */ w0(RecyclerView.o oVar, a aVar) {
        this(oVar);
    }

    public static w0 a(RecyclerView.o oVar, int i2) {
        if (i2 != 0) {
            if (i2 == 1) {
                return b(oVar);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return a(oVar);
    }

    public static w0 b(RecyclerView.o oVar) {
        return new b(oVar);
    }

    public abstract int a();

    public abstract int a(View view);

    public abstract void a(int i2);

    public abstract int b();

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public int h() {
        if (Integer.MIN_VALUE == this.f1976b) {
            return 0;
        }
        return g() - this.f1976b;
    }

    public void i() {
        this.f1976b = g();
    }

    public w0(RecyclerView.o oVar) {
        this.f1976b = Integer.MIN_VALUE;
        this.f1977c = new Rect();
        this.f1975a = oVar;
    }

    public static w0 a(RecyclerView.o oVar) {
        return new a(oVar);
    }
}
