package c.d.a.a.e.e.l;

import c.d.a.a.e.e.e;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Map;
/* loaded from: classes.dex */
public final class g implements e.a {

    /* renamed from: a  reason: collision with root package name */
    public /* synthetic */ BasePendingResult f3296a;

    /* renamed from: b  reason: collision with root package name */
    public /* synthetic */ f f3297b;

    public g(f fVar, BasePendingResult basePendingResult) {
        this.f3297b = fVar;
        this.f3296a = basePendingResult;
    }

    @Override // c.d.a.a.e.e.e.a
    public final void a(Status status) {
        Map map;
        map = this.f3297b.f3283a;
        map.remove(this.f3296a);
    }
}
