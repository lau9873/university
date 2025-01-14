package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a.InterfaceC0913c;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;

/* renamed from: c.d.a.a.e.e.l.l2 */
/* loaded from: classes.dex */
public abstract class AbstractC0981l2<R extends InterfaceC0928g, A extends C0905a.InterfaceC0913c> extends BasePendingResult<R> implements InterfaceC0985m2<R> {

    /* renamed from: q */
    public final C0905a.C0914d<A> f5243q;

    /* renamed from: r */
    public final C0905a<?> f5244r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0981l2(C0905a<?> c0905a, AbstractC0921d abstractC0921d) {
        super(abstractC0921d);
        C1049c0.m5293a(abstractC0921d, "GoogleApiClient must not be null");
        C1049c0.m5293a(c0905a, "Api must not be null");
        this.f5243q = (C0905a.C0914d<A>) c0905a.m5619d();
        this.f5244r = c0905a;
    }

    /* renamed from: a */
    public final void m5438a(RemoteException remoteException) {
        m5436c(new Status(8, remoteException.getLocalizedMessage(), null));
    }

    /* renamed from: a */
    public abstract void mo5020a(A a);

    /* renamed from: b */
    public final void m5437b(A a) {
        try {
            mo5020a((AbstractC0981l2<R, A>) a);
        } catch (DeadObjectException e) {
            m5438a(e);
            throw e;
        } catch (RemoteException e2) {
            m5438a(e2);
        }
    }

    /* renamed from: c */
    public final void m5436c(Status status) {
        C1049c0.m5289a(!status.m4370e(), "Failed result must not be success");
        mo4363a(status);
        m4366a((AbstractC0981l2<R, A>) status);
    }

    /* renamed from: h */
    public final C0905a.C0914d<A> m5435h() {
        return this.f5243q;
    }

    /* renamed from: i */
    public final C0905a<?> m5434i() {
        return this.f5244r;
    }
}
