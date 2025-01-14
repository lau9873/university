package p000a.p006b.p049h.p063k;

import android.graphics.Rect;
import android.support.p067v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: a.b.h.k.w0 */
/* loaded from: classes.dex */
public abstract class OrientationHelper {

    /* renamed from: a */
    public final RecyclerView.AbstractC0722o f2976a;

    /* renamed from: b */
    public int f2977b;

    /* renamed from: c */
    public final Rect f2978c;

    /* compiled from: OrientationHelper.java */
    /* renamed from: a.b.h.k.w0$a */
    /* loaded from: classes.dex */
    public static class C0507a extends OrientationHelper {
        public C0507a(RecyclerView.AbstractC0722o abstractC0722o) {
            super(abstractC0722o, null);
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: a */
        public int mo8017a() {
            return this.f2976a.m6618q();
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: b */
        public int mo8014b() {
            return this.f2976a.m6618q() - this.f2976a.m6621o();
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: c */
        public int mo8011c(View view) {
            RecyclerView.C0727p c0727p = (RecyclerView.C0727p) view.getLayoutParams();
            return this.f2976a.m6636g(view) + ((ViewGroup.MarginLayoutParams) c0727p).topMargin + ((ViewGroup.MarginLayoutParams) c0727p).bottomMargin;
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: d */
        public int mo8009d(View view) {
            return this.f2976a.m6639f(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.C0727p) view.getLayoutParams())).leftMargin;
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: e */
        public int mo8007e(View view) {
            this.f2976a.m6670a(view, true, this.f2978c);
            return this.f2978c.right;
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: f */
        public int mo8006f() {
            return this.f2976a.m6623n();
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: g */
        public int mo8004g() {
            return (this.f2976a.m6618q() - this.f2976a.m6623n()) - this.f2976a.m6621o();
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: a */
        public void mo8016a(int i) {
            this.f2976a.mo6416d(i);
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: b */
        public int mo8013b(View view) {
            RecyclerView.C0727p c0727p = (RecyclerView.C0727p) view.getLayoutParams();
            return this.f2976a.m6634h(view) + ((ViewGroup.MarginLayoutParams) c0727p).leftMargin + ((ViewGroup.MarginLayoutParams) c0727p).rightMargin;
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: f */
        public int mo8005f(View view) {
            this.f2976a.m6670a(view, true, this.f2978c);
            return this.f2978c.left;
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: a */
        public int mo8015a(View view) {
            return this.f2976a.m6632i(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.C0727p) view.getLayoutParams())).rightMargin;
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: c */
        public int mo8012c() {
            return this.f2976a.m6621o();
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: d */
        public int mo8010d() {
            return this.f2976a.m6617r();
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: e */
        public int mo8008e() {
            return this.f2976a.m6633i();
        }
    }

    /* compiled from: OrientationHelper.java */
    /* renamed from: a.b.h.k.w0$b */
    /* loaded from: classes.dex */
    public static class C0508b extends OrientationHelper {
        public C0508b(RecyclerView.AbstractC0722o abstractC0722o) {
            super(abstractC0722o, null);
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: a */
        public int mo8017a() {
            return this.f2976a.m6635h();
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: b */
        public int mo8014b() {
            return this.f2976a.m6635h() - this.f2976a.m6625m();
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: c */
        public int mo8011c(View view) {
            RecyclerView.C0727p c0727p = (RecyclerView.C0727p) view.getLayoutParams();
            return this.f2976a.m6634h(view) + ((ViewGroup.MarginLayoutParams) c0727p).leftMargin + ((ViewGroup.MarginLayoutParams) c0727p).rightMargin;
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: d */
        public int mo8009d(View view) {
            return this.f2976a.m6630j(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.C0727p) view.getLayoutParams())).topMargin;
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: e */
        public int mo8007e(View view) {
            this.f2976a.m6670a(view, true, this.f2978c);
            return this.f2978c.bottom;
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: f */
        public int mo8006f() {
            return this.f2976a.m6619p();
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: g */
        public int mo8004g() {
            return (this.f2976a.m6635h() - this.f2976a.m6619p()) - this.f2976a.m6625m();
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: a */
        public void mo8016a(int i) {
            this.f2976a.mo6412e(i);
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: b */
        public int mo8013b(View view) {
            RecyclerView.C0727p c0727p = (RecyclerView.C0727p) view.getLayoutParams();
            return this.f2976a.m6636g(view) + ((ViewGroup.MarginLayoutParams) c0727p).topMargin + ((ViewGroup.MarginLayoutParams) c0727p).bottomMargin;
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: f */
        public int mo8005f(View view) {
            this.f2976a.m6670a(view, true, this.f2978c);
            return this.f2978c.top;
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: a */
        public int mo8015a(View view) {
            return this.f2976a.m6642e(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.C0727p) view.getLayoutParams())).bottomMargin;
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: c */
        public int mo8012c() {
            return this.f2976a.m6625m();
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: d */
        public int mo8010d() {
            return this.f2976a.m6633i();
        }

        @Override // p000a.p006b.p049h.p063k.OrientationHelper
        /* renamed from: e */
        public int mo8008e() {
            return this.f2976a.m6617r();
        }
    }

    public /* synthetic */ OrientationHelper(RecyclerView.AbstractC0722o abstractC0722o, C0507a c0507a) {
        this(abstractC0722o);
    }

    /* renamed from: a */
    public static OrientationHelper m8021a(RecyclerView.AbstractC0722o abstractC0722o, int i) {
        if (i != 0) {
            if (i == 1) {
                return m8020b(abstractC0722o);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return m8022a(abstractC0722o);
    }

    /* renamed from: b */
    public static OrientationHelper m8020b(RecyclerView.AbstractC0722o abstractC0722o) {
        return new C0508b(abstractC0722o);
    }

    /* renamed from: a */
    public abstract int mo8017a();

    /* renamed from: a */
    public abstract int mo8015a(View view);

    /* renamed from: a */
    public abstract void mo8016a(int i);

    /* renamed from: b */
    public abstract int mo8014b();

    /* renamed from: b */
    public abstract int mo8013b(View view);

    /* renamed from: c */
    public abstract int mo8012c();

    /* renamed from: c */
    public abstract int mo8011c(View view);

    /* renamed from: d */
    public abstract int mo8010d();

    /* renamed from: d */
    public abstract int mo8009d(View view);

    /* renamed from: e */
    public abstract int mo8008e();

    /* renamed from: e */
    public abstract int mo8007e(View view);

    /* renamed from: f */
    public abstract int mo8006f();

    /* renamed from: f */
    public abstract int mo8005f(View view);

    /* renamed from: g */
    public abstract int mo8004g();

    /* renamed from: h */
    public int m8019h() {
        if (Integer.MIN_VALUE == this.f2977b) {
            return 0;
        }
        return mo8004g() - this.f2977b;
    }

    /* renamed from: i */
    public void m8018i() {
        this.f2977b = mo8004g();
    }

    public OrientationHelper(RecyclerView.AbstractC0722o abstractC0722o) {
        this.f2977b = Integer.MIN_VALUE;
        this.f2978c = new Rect();
        this.f2976a = abstractC0722o;
    }

    /* renamed from: a */
    public static OrientationHelper m8022a(RecyclerView.AbstractC0722o abstractC0722o) {
        return new C0507a(abstractC0722o);
    }
}
