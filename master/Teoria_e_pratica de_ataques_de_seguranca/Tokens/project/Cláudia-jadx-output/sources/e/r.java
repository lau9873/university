package e;

import java.util.ArrayList;
import java.util.List;
/* compiled from: FormBody.java */
/* loaded from: classes.dex */
public final class r extends c0 {

    /* renamed from: c  reason: collision with root package name */
    public static final w f5910c = w.a("application/x-www-form-urlencoded");

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f5911a;

    /* renamed from: b  reason: collision with root package name */
    public final List<String> f5912b;

    public r(List<String> list, List<String> list2) {
        this.f5911a = e.i0.c.a(list);
        this.f5912b = e.i0.c.a(list2);
    }

    @Override // e.c0
    public long a() {
        return a((f.d) null, true);
    }

    @Override // e.c0
    public w b() {
        return f5910c;
    }

    /* compiled from: FormBody.java */
    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f5913a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f5914b = new ArrayList();

        public a a(String str, String str2) {
            this.f5913a.add(u.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            this.f5914b.add(u.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, true));
            return this;
        }

        public a b(String str, String str2) {
            this.f5913a.add(u.a(str, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            this.f5914b.add(u.a(str2, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, true));
            return this;
        }

        public r a() {
            return new r(this.f5913a, this.f5914b);
        }
    }

    @Override // e.c0
    public void a(f.d dVar) {
        a(dVar, false);
    }

    public final long a(f.d dVar, boolean z) {
        f.c a2;
        if (z) {
            a2 = new f.c();
        } else {
            a2 = dVar.a();
        }
        int size = this.f5911a.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                a2.writeByte(38);
            }
            a2.a(this.f5911a.get(i2));
            a2.writeByte(61);
            a2.a(this.f5912b.get(i2));
        }
        if (z) {
            long s = a2.s();
            a2.l();
            return s;
        }
        return 0L;
    }
}
