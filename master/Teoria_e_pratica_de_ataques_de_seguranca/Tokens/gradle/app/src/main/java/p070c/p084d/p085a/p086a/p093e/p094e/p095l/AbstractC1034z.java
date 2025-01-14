package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import p070c.p084d.p085a.p086a.p104j.C1238d;

/* renamed from: c.d.a.a.e.e.l.z */
/* loaded from: classes.dex */
public abstract class AbstractC1034z<T> extends AbstractC0933a {

    /* renamed from: a */
    public final C1238d<T> f5366a;

    public AbstractC1034z(int i, C1238d<T> c1238d) {
        super(i);
        this.f5366a = c1238d;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC0933a
    /* renamed from: a */
    public final void mo5311a(C0979l0<?> c0979l0) {
        Status m5582a;
        Status m5582a2;
        try {
            mo5308b(c0979l0);
        } catch (DeadObjectException e) {
            m5582a2 = AbstractC0933a.m5582a(e);
            mo5310a(m5582a2);
            throw e;
        } catch (RemoteException e2) {
            m5582a = AbstractC0933a.m5582a(e2);
            mo5310a(m5582a);
        } catch (RuntimeException e3) {
            m5309a(e3);
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC0933a
    /* renamed from: a */
    public void mo5310a(Status status) {
        this.f5366a.m4978b(new ApiException(status));
    }

    /* renamed from: a */
    public void m5309a(RuntimeException runtimeException) {
        this.f5366a.m4978b(runtimeException);
    }

    /* renamed from: b */
    public abstract void mo5308b(C0979l0<?> c0979l0);
}
