package c.d.b;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* compiled from: GsonBuilder.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: h  reason: collision with root package name */
    public String f3730h;

    /* renamed from: a  reason: collision with root package name */
    public c.d.b.v.d f3723a = c.d.b.v.d.f3759g;

    /* renamed from: b  reason: collision with root package name */
    public r f3724b = r.f3737a;

    /* renamed from: c  reason: collision with root package name */
    public e f3725c = d.f3704a;

    /* renamed from: d  reason: collision with root package name */
    public final Map<Type, h<?>> f3726d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public final List<t> f3727e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final List<t> f3728f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public boolean f3729g = false;

    /* renamed from: i  reason: collision with root package name */
    public int f3731i = 2;
    public int j = 2;
    public boolean k = false;
    public boolean l = false;
    public boolean m = true;
    public boolean n = false;
    public boolean o = false;
    public boolean p = false;

    public g a(String str) {
        this.f3730h = str;
        return this;
    }

    public g a(Type type, Object obj) {
        boolean z = obj instanceof q;
        c.d.b.v.a.a(z || (obj instanceof k) || (obj instanceof h) || (obj instanceof s));
        if (obj instanceof h) {
            this.f3726d.put(type, (h) obj);
        }
        if (z || (obj instanceof k)) {
            this.f3727e.add(c.d.b.v.n.l.a(c.d.b.w.a.get(type), obj));
        }
        if (obj instanceof s) {
            this.f3727e.add(c.d.b.v.n.n.a(c.d.b.w.a.get(type), (s) obj));
        }
        return this;
    }

    public f a() {
        List<t> arrayList = new ArrayList<>(this.f3727e.size() + this.f3728f.size() + 3);
        arrayList.addAll(this.f3727e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f3728f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        a(this.f3730h, this.f3731i, this.j, arrayList);
        return new f(this.f3723a, this.f3725c, this.f3726d, this.f3729g, this.k, this.o, this.m, this.n, this.p, this.l, this.f3724b, this.f3730h, this.f3731i, this.j, this.f3727e, this.f3728f, arrayList);
    }

    public final void a(String str, int i2, int i3, List<t> list) {
        a aVar;
        a aVar2;
        a aVar3;
        if (str != null && !"".equals(str.trim())) {
            a aVar4 = new a(Date.class, str);
            aVar2 = new a(Timestamp.class, str);
            aVar3 = new a(java.sql.Date.class, str);
            aVar = aVar4;
        } else if (i2 == 2 || i3 == 2) {
            return;
        } else {
            aVar = new a(Date.class, i2, i3);
            a aVar5 = new a(Timestamp.class, i2, i3);
            a aVar6 = new a(java.sql.Date.class, i2, i3);
            aVar2 = aVar5;
            aVar3 = aVar6;
        }
        list.add(c.d.b.v.n.n.a(Date.class, aVar));
        list.add(c.d.b.v.n.n.a(Timestamp.class, aVar2));
        list.add(c.d.b.v.n.n.a(java.sql.Date.class, aVar3));
    }
}
