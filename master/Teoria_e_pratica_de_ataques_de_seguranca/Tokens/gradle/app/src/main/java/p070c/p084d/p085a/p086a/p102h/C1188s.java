package p070c.p084d.p085a.p086a.p102h;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1048c;
import p070c.p084d.p085a.p086a.p093e.p096f.C1086u0;

/* renamed from: c.d.a.a.h.s */
/* loaded from: classes.dex */
public class C1188s extends AbstractC1048c<InterfaceC1147e0> {

    /* renamed from: A */
    public final String f5577A;

    /* renamed from: B */
    public final InterfaceC1189s0<InterfaceC1147e0> f5578B;

    public C1188s(Context context, Looper looper, AbstractC0921d.InterfaceC0923b interfaceC0923b, AbstractC0921d.InterfaceC0924c interfaceC0924c, String str, C1086u0 c1086u0) {
        super(context, looper, 23, c1086u0, interfaceC0923b, interfaceC0924c);
        this.f5578B = new C1190t(this);
        this.f5577A = str;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0
    /* renamed from: A */
    public final String mo5013A() {
        return "com.google.android.gms.location.internal.IGoogleLocationManagerService";
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0
    /* renamed from: a */
    public final /* synthetic */ IInterface mo5012a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return queryLocalInterface instanceof InterfaceC1147e0 ? (InterfaceC1147e0) queryLocalInterface : new C1150f0(iBinder);
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0
    /* renamed from: p */
    public final Bundle mo5010p() {
        Bundle bundle = new Bundle();
        bundle.putString("client_name", this.f5577A);
        return bundle;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0
    /* renamed from: z */
    public final String mo5009z() {
        return "com.google.android.location.internal.GoogleLocationManagerService.START";
    }
}
