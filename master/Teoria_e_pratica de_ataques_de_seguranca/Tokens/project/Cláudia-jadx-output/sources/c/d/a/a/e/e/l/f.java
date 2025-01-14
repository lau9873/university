package c.d.a.a.e.e.l;

import c.d.a.a.e.e.e;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final Map<BasePendingResult<?>, Boolean> f3283a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    public final Map<c.d.a.a.j.d<?>, Boolean> f3284b = Collections.synchronizedMap(new WeakHashMap());

    public final <TResult> void a(c.d.a.a.j.d<TResult> dVar, boolean z) {
        this.f3284b.put(dVar, Boolean.valueOf(z));
        dVar.a().a(new h(this, dVar));
    }

    public final void a(BasePendingResult<? extends c.d.a.a.e.e.g> basePendingResult, boolean z) {
        this.f3283a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.a((e.a) new g(this, basePendingResult));
    }

    public final void a(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f3283a) {
            hashMap = new HashMap(this.f3283a);
        }
        synchronized (this.f3284b) {
            hashMap2 = new HashMap(this.f3284b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).b(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((c.d.a.a.j.d) entry2.getKey()).b((Exception) new ApiException(status));
            }
        }
    }

    public final boolean a() {
        return (this.f3283a.isEmpty() && this.f3284b.isEmpty()) ? false : true;
    }

    public final void b() {
        a(false, j0.n);
    }

    public final void c() {
        a(true, y1.f3444d);
    }
}
