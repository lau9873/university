package c.d.a.a.e.e.l;

import c.d.a.a.e.e.a;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Set;
/* loaded from: classes.dex */
public final class t extends x {

    /* renamed from: b  reason: collision with root package name */
    public final ArrayList<a.f> f3409b;

    /* renamed from: c  reason: collision with root package name */
    public /* synthetic */ n f3410c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(n nVar, ArrayList<a.f> arrayList) {
        super(nVar, null);
        this.f3410c = nVar;
        this.f3409b = arrayList;
    }

    @Override // c.d.a.a.e.e.l.x
    public final void a() {
        f0 f0Var;
        Set<Scope> i2;
        c.d.a.a.e.f.n nVar;
        f0 f0Var2;
        f0Var = this.f3410c.f3354a;
        a0 a0Var = f0Var.m;
        i2 = this.f3410c.i();
        a0Var.q = i2;
        ArrayList<a.f> arrayList = this.f3409b;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            a.f fVar = arrayList.get(i3);
            i3++;
            nVar = this.f3410c.o;
            f0Var2 = this.f3410c.f3354a;
            fVar.a(nVar, f0Var2.m.q);
        }
    }
}
