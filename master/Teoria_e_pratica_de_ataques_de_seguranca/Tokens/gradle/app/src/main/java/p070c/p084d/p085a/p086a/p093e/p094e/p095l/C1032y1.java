package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC1039o;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0928g;
import p070c.p084d.p085a.p086a.p093e.p094e.InterfaceC0929h;

/* renamed from: c.d.a.a.e.e.l.y1 */
/* loaded from: classes.dex */
public final class C1032y1 {

    /* renamed from: d */
    public static final Status f5357d = new Status(8, "The connection to Google Play services was lost");

    /* renamed from: e */
    public static final BasePendingResult<?>[] f5358e = new BasePendingResult[0];

    /* renamed from: a */
    public final Set<BasePendingResult<?>> f5359a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));

    /* renamed from: b */
    public final InterfaceC0940b2 f5360b = new C1036z1(this);

    /* renamed from: c */
    public final Map<C0905a.C0914d<?>, C0905a.InterfaceC0916f> f5361c;

    public C1032y1(Map<C0905a.C0914d<?>, C0905a.InterfaceC0916f> map) {
        this.f5361c = map;
    }

    /* renamed from: a */
    public final void m5317a() {
        int i;
        BasePendingResult[] basePendingResultArr = (BasePendingResult[]) this.f5359a.toArray(f5358e);
        int length = basePendingResultArr.length;
        while (i < length) {
            BasePendingResult basePendingResult = basePendingResultArr[i];
            AbstractC1039o abstractC1039o = null;
            basePendingResult.m4364a((InterfaceC0940b2) null);
            if (basePendingResult.m4355e() == null) {
                i = basePendingResult.m4354f() ? 0 : i + 1;
            } else {
                basePendingResult.mo4365a((InterfaceC0929h) null);
                IBinder m5607i = this.f5361c.get(((AbstractC0981l2) basePendingResult).m5435h()).m5607i();
                if (basePendingResult.m4356d()) {
                    basePendingResult.m4364a(new C0936a2(basePendingResult, null, m5607i, null));
                } else {
                    if (m5607i == null || !m5607i.isBinderAlive()) {
                        basePendingResult.m4364a((InterfaceC0940b2) null);
                    } else {
                        C0936a2 c0936a2 = new C0936a2(basePendingResult, null, m5607i, null);
                        basePendingResult.m4364a(c0936a2);
                        try {
                            m5607i.linkToDeath(c0936a2, 0);
                        } catch (RemoteException unused) {
                        }
                    }
                    basePendingResult.m4368a();
                    abstractC1039o.m5300a(basePendingResult.m4355e().intValue());
                }
            }
            this.f5359a.remove(basePendingResult);
        }
    }

    /* renamed from: a */
    public final void m5316a(BasePendingResult<? extends InterfaceC0928g> basePendingResult) {
        this.f5359a.add(basePendingResult);
        basePendingResult.m4364a(this.f5360b);
    }

    /* renamed from: b */
    public final void m5315b() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.f5359a.toArray(f5358e)) {
            basePendingResult.m4359b(f5357d);
        }
    }
}
