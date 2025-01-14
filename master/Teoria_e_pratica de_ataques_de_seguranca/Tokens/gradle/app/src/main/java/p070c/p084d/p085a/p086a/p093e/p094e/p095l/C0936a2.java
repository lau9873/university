package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.IBinder;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.lang.ref.WeakReference;
import java.util.NoSuchElementException;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC1039o;

/* renamed from: c.d.a.a.e.e.l.a2 */
/* loaded from: classes.dex */
public final class C0936a2 implements IBinder.DeathRecipient, InterfaceC0940b2 {

    /* renamed from: a */
    public final WeakReference<BasePendingResult<?>> f5121a;

    /* renamed from: b */
    public final WeakReference<AbstractC1039o> f5122b;

    /* renamed from: c */
    public final WeakReference<IBinder> f5123c;

    public C0936a2(BasePendingResult<?> basePendingResult, AbstractC1039o abstractC1039o, IBinder iBinder) {
        this.f5122b = new WeakReference<>(abstractC1039o);
        this.f5121a = new WeakReference<>(basePendingResult);
        this.f5123c = new WeakReference<>(iBinder);
    }

    public /* synthetic */ C0936a2(BasePendingResult basePendingResult, AbstractC1039o abstractC1039o, IBinder iBinder, C1036z1 c1036z1) {
        this(basePendingResult, null, iBinder);
    }

    /* renamed from: a */
    public final void m5568a() {
        BasePendingResult<?> basePendingResult = this.f5121a.get();
        AbstractC1039o abstractC1039o = this.f5122b.get();
        if (abstractC1039o != null && basePendingResult != null) {
            abstractC1039o.m5300a(basePendingResult.m4355e().intValue());
        }
        IBinder iBinder = this.f5123c.get();
        if (iBinder != null) {
            try {
                iBinder.unlinkToDeath(this, 0);
            } catch (NoSuchElementException unused) {
            }
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0940b2
    /* renamed from: a */
    public final void mo5303a(BasePendingResult<?> basePendingResult) {
        m5568a();
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        m5568a();
    }
}
