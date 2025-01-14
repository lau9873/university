package c.d.a.a.e.e.l;

import android.os.IBinder;
import android.os.RemoteException;
import c.d.a.a.e.e.a;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class y1 {

    /* renamed from: d  reason: collision with root package name */
    public static final Status f3444d = new Status(8, "The connection to Google Play services was lost");

    /* renamed from: e  reason: collision with root package name */
    public static final BasePendingResult<?>[] f3445e = new BasePendingResult[0];

    /* renamed from: a  reason: collision with root package name */
    public final Set<BasePendingResult<?>> f3446a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: b  reason: collision with root package name */
    public final b2 f3447b = new z1(this);

    /* renamed from: c  reason: collision with root package name */
    public final Map<a.d<?>, a.f> f3448c;

    public y1(Map<a.d<?>, a.f> map) {
        this.f3448c = map;
    }

    public final void a() {
        int i2;
        BasePendingResult[] basePendingResultArr = (BasePendingResult[]) this.f3446a.toArray(f3445e);
        int length = basePendingResultArr.length;
        while (i2 < length) {
            BasePendingResult basePendingResult = basePendingResultArr[i2];
            c.d.a.a.e.e.o oVar = null;
            basePendingResult.a((b2) null);
            if (basePendingResult.e() == null) {
                i2 = basePendingResult.f() ? 0 : i2 + 1;
            } else {
                basePendingResult.a((c.d.a.a.e.e.h) null);
                IBinder i3 = this.f3448c.get(((l2) basePendingResult).h()).i();
                if (basePendingResult.d()) {
                    basePendingResult.a(new a2(basePendingResult, null, i3, null));
                } else {
                    if (i3 == null || !i3.isBinderAlive()) {
                        basePendingResult.a((b2) null);
                    } else {
                        a2 a2Var = new a2(basePendingResult, null, i3, null);
                        basePendingResult.a(a2Var);
                        try {
                            i3.linkToDeath(a2Var, 0);
                        } catch (RemoteException unused) {
                        }
                    }
                    basePendingResult.a();
                    oVar.a(basePendingResult.e().intValue());
                }
            }
            this.f3446a.remove(basePendingResult);
        }
    }

    public final void a(BasePendingResult<? extends c.d.a.a.e.e.g> basePendingResult) {
        this.f3446a.add(basePendingResult);
        basePendingResult.a(this.f3447b);
    }

    public final void b() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f3446a.toArray(f3445e)) {
            basePendingResult.b(f3444d);
        }
    }
}
