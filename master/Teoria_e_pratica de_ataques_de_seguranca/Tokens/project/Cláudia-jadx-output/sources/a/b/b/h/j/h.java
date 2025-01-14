package a.b.b.h.j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* compiled from: ConstraintWidgetGroup.java */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public List<f> f179a;

    /* renamed from: b  reason: collision with root package name */
    public int f180b;

    /* renamed from: c  reason: collision with root package name */
    public int f181c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f182d;

    /* renamed from: e  reason: collision with root package name */
    public final int[] f183e;

    /* renamed from: f  reason: collision with root package name */
    public List<f> f184f;

    /* renamed from: g  reason: collision with root package name */
    public List<f> f185g;

    /* renamed from: h  reason: collision with root package name */
    public HashSet<f> f186h;

    /* renamed from: i  reason: collision with root package name */
    public HashSet<f> f187i;
    public List<f> j;
    public List<f> k;

    public h(List<f> list) {
        this.f180b = -1;
        this.f181c = -1;
        this.f182d = false;
        this.f183e = new int[]{this.f180b, this.f181c};
        this.f184f = new ArrayList();
        this.f185g = new ArrayList();
        this.f186h = new HashSet<>();
        this.f187i = new HashSet<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f179a = list;
    }

    public List<f> a(int i2) {
        if (i2 == 0) {
            return this.f184f;
        }
        if (i2 == 1) {
            return this.f185g;
        }
        return null;
    }

    public Set<f> b(int i2) {
        if (i2 == 0) {
            return this.f186h;
        }
        if (i2 == 1) {
            return this.f187i;
        }
        return null;
    }

    public void a(f fVar, int i2) {
        if (i2 == 0) {
            this.f186h.add(fVar);
        } else if (i2 == 1) {
            this.f187i.add(fVar);
        }
    }

    public void b() {
        int size = this.k.size();
        for (int i2 = 0; i2 < size; i2++) {
            a(this.k.get(i2));
        }
    }

    public List<f> a() {
        if (!this.j.isEmpty()) {
            return this.j;
        }
        int size = this.f179a.size();
        for (int i2 = 0; i2 < size; i2++) {
            f fVar = this.f179a.get(i2);
            if (!fVar.b0) {
                a((ArrayList) this.j, fVar);
            }
        }
        this.k.clear();
        this.k.addAll(this.f179a);
        this.k.removeAll(this.j);
        return this.j;
    }

    public h(List<f> list, boolean z) {
        this.f180b = -1;
        this.f181c = -1;
        this.f182d = false;
        this.f183e = new int[]{this.f180b, this.f181c};
        this.f184f = new ArrayList();
        this.f185g = new ArrayList();
        this.f186h = new HashSet<>();
        this.f187i = new HashSet<>();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.f179a = list;
        this.f182d = z;
    }

    public final void a(ArrayList<f> arrayList, f fVar) {
        if (fVar.d0) {
            return;
        }
        arrayList.add(fVar);
        fVar.d0 = true;
        if (fVar.z()) {
            return;
        }
        if (fVar instanceof j) {
            j jVar = (j) fVar;
            int i2 = jVar.l0;
            for (int i3 = 0; i3 < i2; i3++) {
                a(arrayList, jVar.k0[i3]);
            }
        }
        int length = fVar.A.length;
        for (int i4 = 0; i4 < length; i4++) {
            e eVar = fVar.A[i4].f140d;
            if (eVar != null) {
                f fVar2 = eVar.f138b;
                if (eVar != null && fVar2 != fVar.l()) {
                    a(arrayList, fVar2);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(a.b.b.h.j.f r7) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.b.b.h.j.h.a(a.b.b.h.j.f):void");
    }
}
