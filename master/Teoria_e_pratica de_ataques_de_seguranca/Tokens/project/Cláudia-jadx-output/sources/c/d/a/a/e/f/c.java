package c.d.a.a.e.f;

import android.accounts.Account;
import android.content.Context;
import android.os.IInterface;
import android.os.Looper;
import c.d.a.a.e.e.a;
import c.d.a.a.e.e.d;
import com.google.android.gms.common.api.Scope;
import java.util.Set;
/* loaded from: classes.dex */
public abstract class c<T extends IInterface> extends h0<T> implements a.f, g {
    public final Set<Scope> y;
    public final Account z;

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(android.content.Context r10, android.os.Looper r11, int r12, c.d.a.a.e.f.u0 r13, c.d.a.a.e.e.d.b r14, c.d.a.a.e.e.d.c r15) {
        /*
            r9 = this;
            c.d.a.a.e.f.h r3 = c.d.a.a.e.f.h.a(r10)
            c.d.a.a.e.c r4 = c.d.a.a.e.c.c()
            c.d.a.a.e.f.c0.a(r14)
            r7 = r14
            c.d.a.a.e.e.d$b r7 = (c.d.a.a.e.e.d.b) r7
            c.d.a.a.e.f.c0.a(r15)
            r8 = r15
            c.d.a.a.e.e.d$c r8 = (c.d.a.a.e.e.d.c) r8
            r0 = r9
            r1 = r10
            r2 = r11
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c.d.a.a.e.f.c.<init>(android.content.Context, android.os.Looper, int, c.d.a.a.e.f.u0, c.d.a.a.e.e.d$b, c.d.a.a.e.e.d$c):void");
    }

    public c(Context context, Looper looper, h hVar, c.d.a.a.e.c cVar, int i2, u0 u0Var, d.b bVar, d.c cVar2) {
        super(context, looper, hVar, cVar, i2, bVar == null ? null : new d(bVar), cVar2 == null ? null : new e(cVar2), u0Var.g());
        this.z = u0Var.a();
        Set<Scope> d2 = u0Var.d();
        a(d2);
        for (Scope scope : d2) {
            if (!d2.contains(scope)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.y = d2;
    }

    public Set<Scope> a(Set<Scope> set) {
        return set;
    }

    @Override // c.d.a.a.e.e.a.f
    public final int d() {
        return -1;
    }

    @Override // c.d.a.a.e.f.h0
    public final Account n() {
        return this.z;
    }

    @Override // c.d.a.a.e.f.h0
    public c.d.a.a.e.k[] t() {
        return new c.d.a.a.e.k[0];
    }

    @Override // c.d.a.a.e.f.h0
    public final Set<Scope> x() {
        return this.y;
    }
}
