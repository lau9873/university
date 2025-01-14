package c.d.a.a.e.e.l;

import c.d.a.a.e.e.a;
import c.d.a.a.e.e.a.InterfaceC0057a;
import java.util.Arrays;
/* loaded from: classes.dex */
public final class g2<O extends a.InterfaceC0057a> {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f3299a;

    /* renamed from: b  reason: collision with root package name */
    public final int f3300b;

    /* renamed from: c  reason: collision with root package name */
    public final c.d.a.a.e.e.a<O> f3301c;

    /* renamed from: d  reason: collision with root package name */
    public final O f3302d;

    public g2(c.d.a.a.e.e.a<O> aVar) {
        this.f3299a = true;
        this.f3301c = aVar;
        this.f3302d = null;
        this.f3300b = System.identityHashCode(this);
    }

    public g2(c.d.a.a.e.e.a<O> aVar, O o) {
        this.f3299a = false;
        this.f3301c = aVar;
        this.f3302d = o;
        this.f3300b = Arrays.hashCode(new Object[]{this.f3301c, this.f3302d});
    }

    public static <O extends a.InterfaceC0057a> g2<O> a(c.d.a.a.e.e.a<O> aVar) {
        return new g2<>(aVar);
    }

    public static <O extends a.InterfaceC0057a> g2<O> a(c.d.a.a.e.e.a<O> aVar, O o) {
        return new g2<>(aVar, o);
    }

    public final String a() {
        return this.f3301c.a();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g2) {
            g2 g2Var = (g2) obj;
            return !this.f3299a && !g2Var.f3299a && c.d.a.a.e.f.z.a(this.f3301c, g2Var.f3301c) && c.d.a.a.e.f.z.a(this.f3302d, g2Var.f3302d);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3300b;
    }
}
