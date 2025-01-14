package i;

import e.d0;
import e.e0;
/* compiled from: Response.java */
/* loaded from: classes.dex */
public final class l<T> {

    /* renamed from: a  reason: collision with root package name */
    public final d0 f7490a;

    /* renamed from: b  reason: collision with root package name */
    public final T f7491b;

    public l(d0 d0Var, T t, e0 e0Var) {
        this.f7490a = d0Var;
        this.f7491b = t;
    }

    public static <T> l<T> a(T t, d0 d0Var) {
        o.a(d0Var, "rawResponse == null");
        if (d0Var.o()) {
            return new l<>(d0Var, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public int b() {
        return this.f7490a.l();
    }

    public boolean c() {
        return this.f7490a.o();
    }

    public String d() {
        return this.f7490a.p();
    }

    public String toString() {
        return this.f7490a.toString();
    }

    public static <T> l<T> a(e0 e0Var, d0 d0Var) {
        o.a(e0Var, "body == null");
        o.a(d0Var, "rawResponse == null");
        if (!d0Var.o()) {
            return new l<>(d0Var, null, e0Var);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public T a() {
        return this.f7491b;
    }
}
