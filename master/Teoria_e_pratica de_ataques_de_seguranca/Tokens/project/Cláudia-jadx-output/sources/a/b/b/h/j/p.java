package a.b.b.h.j;

import a.b.b.h.j.e;
import java.util.ArrayList;
/* compiled from: Snapshot.java */
/* loaded from: classes.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public int f200a;

    /* renamed from: b  reason: collision with root package name */
    public int f201b;

    /* renamed from: c  reason: collision with root package name */
    public int f202c;

    /* renamed from: d  reason: collision with root package name */
    public int f203d;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<a> f204e = new ArrayList<>();

    /* compiled from: Snapshot.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public e f205a;

        /* renamed from: b  reason: collision with root package name */
        public e f206b;

        /* renamed from: c  reason: collision with root package name */
        public int f207c;

        /* renamed from: d  reason: collision with root package name */
        public e.c f208d;

        /* renamed from: e  reason: collision with root package name */
        public int f209e;

        public a(e eVar) {
            this.f205a = eVar;
            this.f206b = eVar.g();
            this.f207c = eVar.b();
            this.f208d = eVar.f();
            this.f209e = eVar.a();
        }

        public void a(f fVar) {
            fVar.a(this.f205a.h()).a(this.f206b, this.f207c, this.f208d, this.f209e);
        }

        public void b(f fVar) {
            this.f205a = fVar.a(this.f205a.h());
            e eVar = this.f205a;
            if (eVar != null) {
                this.f206b = eVar.g();
                this.f207c = this.f205a.b();
                this.f208d = this.f205a.f();
                this.f209e = this.f205a.a();
                return;
            }
            this.f206b = null;
            this.f207c = 0;
            this.f208d = e.c.STRONG;
            this.f209e = 0;
        }
    }

    public p(f fVar) {
        this.f200a = fVar.w();
        this.f201b = fVar.x();
        this.f202c = fVar.t();
        this.f203d = fVar.j();
        ArrayList<e> c2 = fVar.c();
        int size = c2.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f204e.add(new a(c2.get(i2)));
        }
    }

    public void a(f fVar) {
        fVar.s(this.f200a);
        fVar.t(this.f201b);
        fVar.p(this.f202c);
        fVar.h(this.f203d);
        int size = this.f204e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f204e.get(i2).a(fVar);
        }
    }

    public void b(f fVar) {
        this.f200a = fVar.w();
        this.f201b = fVar.x();
        this.f202c = fVar.t();
        this.f203d = fVar.j();
        int size = this.f204e.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f204e.get(i2).b(fVar);
        }
    }
}
