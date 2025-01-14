package p070c.p084d.p085a.p086a.p102h;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import p070c.p084d.p085a.p086a.p089d.p090a.p091a.p092a.C0898a;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1048c;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1052d0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1078q0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1086u0;
import p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1071n;

/* renamed from: c.d.a.a.h.h1 */
/* loaded from: classes.dex */
public final class C1157h1 extends AbstractC1048c<InterfaceC1151f1> implements InterfaceC1199x0 {

    /* renamed from: A */
    public final boolean f5544A;

    /* renamed from: B */
    public final C1086u0 f5545B;

    /* renamed from: C */
    public final Bundle f5546C;

    /* renamed from: D */
    public Integer f5547D;

    public C1157h1(Context context, Looper looper, boolean z, C1086u0 c1086u0, Bundle bundle, AbstractC0921d.InterfaceC0923b interfaceC0923b, AbstractC0921d.InterfaceC0924c interfaceC0924c) {
        super(context, looper, 44, c1086u0, interfaceC0923b, interfaceC0924c);
        this.f5544A = true;
        this.f5545B = c1086u0;
        this.f5546C = bundle;
        this.f5547D = c1086u0.m5172i();
    }

    public C1157h1(Context context, Looper looper, boolean z, C1086u0 c1086u0, C1201y0 c1201y0, AbstractC0921d.InterfaceC0923b interfaceC0923b, AbstractC0921d.InterfaceC0924c interfaceC0924c) {
        this(context, looper, true, c1086u0, m5044a(c1086u0), interfaceC0923b, interfaceC0924c);
    }

    /* renamed from: a */
    public static Bundle m5044a(C1086u0 c1086u0) {
        C1201y0 m5173h = c1086u0.m5173h();
        Integer m5172i = c1086u0.m5172i();
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", c1086u0.m5182a());
        if (m5172i != null) {
            bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", m5172i.intValue());
        }
        if (m5173h != null) {
            bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", m5173h.m5000c());
            bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", m5173h.m5001b());
            bundle.putString("com.google.android.gms.signin.internal.serverClientId", m5173h.m5002a());
            bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
            bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", m5173h.m4999d());
            bundle.putString("com.google.android.gms.signin.internal.hostedDomain", m5173h.m4998e());
            bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", m5173h.m4997f());
            if (m5173h.m4996g() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.authApiSignInModuleVersion", m5173h.m4996g().longValue());
            }
            if (m5173h.m4995h() != null) {
                bundle.putLong("com.google.android.gms.signin.internal.realClientLibraryVersion", m5173h.m4995h().longValue());
            }
        }
        return bundle;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0
    /* renamed from: A */
    public final String mo5013A() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0
    /* renamed from: a */
    public final /* synthetic */ IInterface mo5012a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return queryLocalInterface instanceof InterfaceC1151f1 ? (InterfaceC1151f1) queryLocalInterface : new C1154g1(iBinder);
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1199x0
    /* renamed from: a */
    public final void mo5006a(InterfaceC1071n interfaceC1071n, boolean z) {
        try {
            ((InterfaceC1151f1) m5227v()).mo5047a(interfaceC1071n, this.f5547D.intValue(), z);
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when saveDefaultAccount is called");
        }
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1199x0
    /* renamed from: a */
    public final void mo5005a(InterfaceC1145d1 interfaceC1145d1) {
        C1049c0.m5293a(interfaceC1145d1, "Expecting a valid ISignInCallbacks");
        try {
            Account m5179b = this.f5545B.m5179b();
            ((InterfaceC1151f1) m5227v()).mo5046a(new C1160i1(new C1052d0(m5179b, this.f5547D.intValue(), "<<default account>>".equals(m5179b.name) ? C0898a.m5650a(m5233o()).m5651a() : null)), interfaceC1145d1);
        } catch (RemoteException e) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                interfaceC1145d1.mo5063a(new C1166k1(8));
            } catch (RemoteException unused) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e);
            }
        }
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1199x0
    /* renamed from: b */
    public final void mo5004b() {
        m5255a(new C1078q0(this));
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0, p070c.p084d.p085a.p086a.p093e.p094e.C0905a.InterfaceC0916f
    /* renamed from: e */
    public final boolean mo5043e() {
        return this.f5544A;
    }

    @Override // p070c.p084d.p085a.p086a.p102h.InterfaceC1199x0
    /* renamed from: f */
    public final void mo5003f() {
        try {
            ((InterfaceC1151f1) m5227v()).mo5045c(this.f5547D.intValue());
        } catch (RemoteException unused) {
            Log.w("SignInClientImpl", "Remote service probably died when clearAccountFromSessionStore is called");
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0
    /* renamed from: p */
    public final Bundle mo5010p() {
        if (!m5233o().getPackageName().equals(this.f5545B.m5175f())) {
            this.f5546C.putString("com.google.android.gms.signin.internal.realClientPackageName", this.f5545B.m5175f());
        }
        return this.f5546C;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p096f.AbstractC1060h0
    /* renamed from: z */
    public final String mo5009z() {
        return "com.google.android.gms.signin.service.START";
    }
}
