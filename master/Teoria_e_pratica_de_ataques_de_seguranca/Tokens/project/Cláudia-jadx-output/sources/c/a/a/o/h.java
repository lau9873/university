package c.a.a.o;

import java.io.InputStream;
import java.util.Collections;
import java.util.List;
/* compiled from: HttpResponse.java */
/* loaded from: classes.dex */
public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final int f2836a;

    /* renamed from: b  reason: collision with root package name */
    public final List<c.a.a.e> f2837b;

    /* renamed from: c  reason: collision with root package name */
    public final int f2838c;

    /* renamed from: d  reason: collision with root package name */
    public final InputStream f2839d;

    public h(int i2, List<c.a.a.e> list) {
        this(i2, list, -1, null);
    }

    public final InputStream a() {
        return this.f2839d;
    }

    public final int b() {
        return this.f2838c;
    }

    public final List<c.a.a.e> c() {
        return Collections.unmodifiableList(this.f2837b);
    }

    public final int d() {
        return this.f2836a;
    }

    public h(int i2, List<c.a.a.e> list, int i3, InputStream inputStream) {
        this.f2836a = i2;
        this.f2837b = list;
        this.f2838c = i3;
        this.f2839d = inputStream;
    }
}
