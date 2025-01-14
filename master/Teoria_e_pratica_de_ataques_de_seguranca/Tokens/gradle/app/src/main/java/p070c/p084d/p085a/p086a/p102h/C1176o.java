package p070c.p084d.p085a.p086a.p102h;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0925e;
import p070c.p084d.p085a.p086a.p103i.InterfaceC1207b;

/* renamed from: c.d.a.a.h.o */
/* loaded from: classes.dex */
public final class C1176o implements InterfaceC1207b {
    @Override // p070c.p084d.p085a.p086a.p103i.InterfaceC1207b
    /* renamed from: a */
    public final AbstractC0925e<Status> mo4994a(AbstractC0921d abstractC0921d, long j, PendingIntent pendingIntent) {
        return abstractC0921d.mo5371a((AbstractC0921d) new C1179p(this, abstractC0921d, j, pendingIntent));
    }

    @Override // p070c.p084d.p085a.p086a.p103i.InterfaceC1207b
    /* renamed from: a */
    public final AbstractC0925e<Status> mo4993a(AbstractC0921d abstractC0921d, PendingIntent pendingIntent) {
        return abstractC0921d.mo5371a((AbstractC0921d) new C1182q(this, abstractC0921d, pendingIntent));
    }
}
