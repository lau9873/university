package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0925e;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;
import p070c.p084d.p085a.p086a.p104j.C1238d;

/* renamed from: c.d.a.a.e.e.l.f */
/* loaded from: classes.dex */
public final class C0953f {

    /* renamed from: a */
    public final Map<BasePendingResult<?>, Boolean> f5158a = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: b */
    public final Map<C1238d<?>, Boolean> f5159b = Collections.synchronizedMap(new WeakHashMap());

    /* renamed from: a */
    public final <TResult> void m5535a(C1238d<TResult> c1238d, boolean z) {
        this.f5159b.put(c1238d, Boolean.valueOf(z));
        c1238d.m4981a().mo4968a(new C0961h(this, c1238d));
    }

    /* renamed from: a */
    public final void m5534a(BasePendingResult<? extends InterfaceC0928g> basePendingResult, boolean z) {
        this.f5158a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.m4367a((AbstractC0925e.InterfaceC0926a) new C0957g(this, basePendingResult));
    }

    /* renamed from: a */
    public final void m5533a(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.f5158a) {
            hashMap = new HashMap(this.f5158a);
        }
        synchronized (this.f5159b) {
            hashMap2 = new HashMap(this.f5159b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).m4359b(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((C1238d) entry2.getKey()).m4978b((Exception) new ApiException(status));
            }
        }
    }

    /* renamed from: a */
    public final boolean m5537a() {
        return (this.f5158a.isEmpty() && this.f5159b.isEmpty()) ? false : true;
    }

    /* renamed from: b */
    public final void m5532b() {
        m5533a(false, C0971j0.f5202n);
    }

    /* renamed from: c */
    public final void m5530c() {
        m5533a(true, C1032y1.f5357d);
    }
}
