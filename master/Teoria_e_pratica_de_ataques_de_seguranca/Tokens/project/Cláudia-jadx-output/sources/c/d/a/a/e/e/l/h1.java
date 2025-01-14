package c.d.a.a.e.e.l;

import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class h1 {

    /* renamed from: a  reason: collision with root package name */
    public final Set<d1<?>> f3306a = Collections.newSetFromMap(new WeakHashMap());

    public final void a() {
        for (d1<?> d1Var : this.f3306a) {
            d1Var.a();
        }
        this.f3306a.clear();
    }
}
