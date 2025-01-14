package a.b.h.j;

import a.b.g.k.a0;
import a.b.g.k.b0;
import a.b.g.k.z;
import android.view.View;
import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: ViewPropertyAnimatorCompatSet.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: c  reason: collision with root package name */
    public Interpolator f1516c;

    /* renamed from: d  reason: collision with root package name */
    public a0 f1517d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f1518e;

    /* renamed from: b  reason: collision with root package name */
    public long f1515b = -1;

    /* renamed from: f  reason: collision with root package name */
    public final b0 f1519f = new a();

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<z> f1514a = new ArrayList<>();

    /* compiled from: ViewPropertyAnimatorCompatSet.java */
    /* loaded from: classes.dex */
    public class a extends b0 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f1520a = false;

        /* renamed from: b  reason: collision with root package name */
        public int f1521b = 0;

        public a() {
        }

        public void a() {
            this.f1521b = 0;
            this.f1520a = false;
            h.this.b();
        }

        @Override // a.b.g.k.a0
        public void b(View view) {
            int i2 = this.f1521b + 1;
            this.f1521b = i2;
            if (i2 == h.this.f1514a.size()) {
                a0 a0Var = h.this.f1517d;
                if (a0Var != null) {
                    a0Var.b(null);
                }
                a();
            }
        }

        @Override // a.b.g.k.b0, a.b.g.k.a0
        public void c(View view) {
            if (this.f1520a) {
                return;
            }
            this.f1520a = true;
            a0 a0Var = h.this.f1517d;
            if (a0Var != null) {
                a0Var.c(null);
            }
        }
    }

    public h a(z zVar) {
        if (!this.f1518e) {
            this.f1514a.add(zVar);
        }
        return this;
    }

    public void b() {
        this.f1518e = false;
    }

    public void c() {
        if (this.f1518e) {
            return;
        }
        Iterator<z> it = this.f1514a.iterator();
        while (it.hasNext()) {
            z next = it.next();
            long j = this.f1515b;
            if (j >= 0) {
                next.a(j);
            }
            Interpolator interpolator = this.f1516c;
            if (interpolator != null) {
                next.a(interpolator);
            }
            if (this.f1517d != null) {
                next.a(this.f1519f);
            }
            next.c();
        }
        this.f1518e = true;
    }

    public h a(z zVar, z zVar2) {
        this.f1514a.add(zVar);
        zVar2.b(zVar.b());
        this.f1514a.add(zVar2);
        return this;
    }

    public void a() {
        if (this.f1518e) {
            Iterator<z> it = this.f1514a.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
            this.f1518e = false;
        }
    }

    public h a(long j) {
        if (!this.f1518e) {
            this.f1515b = j;
        }
        return this;
    }

    public h a(Interpolator interpolator) {
        if (!this.f1518e) {
            this.f1516c = interpolator;
        }
        return this;
    }

    public h a(a0 a0Var) {
        if (!this.f1518e) {
            this.f1517d = a0Var;
        }
        return this;
    }
}
