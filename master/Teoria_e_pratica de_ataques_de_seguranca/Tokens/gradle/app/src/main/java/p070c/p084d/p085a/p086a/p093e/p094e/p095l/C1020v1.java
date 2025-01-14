package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.lang.ref.WeakReference;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0930i;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0931j;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0932k;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0927f;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0929h;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;

/* renamed from: c.d.a.a.e.e.l.v1 */
/* loaded from: classes.dex */
public final class C1020v1<R extends InterfaceC0928g> extends AbstractC0932k<R> implements InterfaceC0929h<R> {

    /* renamed from: a */
    public AbstractC0931j<? super R, ? extends InterfaceC0928g> f5342a;

    /* renamed from: b */
    public C1020v1<? extends InterfaceC0928g> f5343b;

    /* renamed from: c */
    public volatile AbstractC0930i<? super R> f5344c;

    /* renamed from: d */
    public final Object f5345d;

    /* renamed from: e */
    public Status f5346e;

    /* renamed from: f */
    public final WeakReference<AbstractC0921d> f5347f;

    /* renamed from: g */
    public final HandlerC1028x1 f5348g;

    /* renamed from: a */
    public static void m5341a(InterfaceC0928g interfaceC0928g) {
        if (interfaceC0928g instanceof InterfaceC0927f) {
            try {
                ((InterfaceC0927f) interfaceC0928g).m5587a();
            } catch (RuntimeException e) {
                String valueOf = String.valueOf(interfaceC0928g);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("TransformedResultImpl", sb.toString(), e);
            }
        }
    }

    /* renamed from: a */
    public final void m5342a() {
        this.f5344c = null;
    }

    /* renamed from: a */
    public final void m5338a(Status status) {
        synchronized (this.f5345d) {
            this.f5346e = status;
            m5335b(this.f5346e);
        }
    }

    /* renamed from: b */
    public final void m5335b(Status status) {
        synchronized (this.f5345d) {
            if (this.f5342a != null) {
                Status m5583a = this.f5342a.m5583a(status);
                C1049c0.m5293a(m5583a, "onFailure must not return null");
                this.f5343b.m5338a(m5583a);
            } else if (m5337b()) {
                this.f5344c.m5585a(status);
            }
        }
    }

    /* renamed from: b */
    public final boolean m5337b() {
        return (this.f5344c == null || this.f5347f.get() == null) ? false : true;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0929h
    public final void onResult(R r) {
        synchronized (this.f5345d) {
            if (!r.mo4374a().m4370e()) {
                m5338a(r.mo4374a());
                m5341a(r);
            } else if (this.f5342a != null) {
                C0980l1.m5439a().submit(new RunnableC1024w1(this, r));
            } else if (m5337b()) {
                this.f5344c.m5586a((AbstractC0930i<? super R>) r);
            }
        }
    }
}
