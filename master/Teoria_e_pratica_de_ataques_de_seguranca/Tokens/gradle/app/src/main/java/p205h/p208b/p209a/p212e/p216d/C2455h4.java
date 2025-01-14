package p205h.p208b.p209a.p212e.p216d;

import android.content.DialogInterface;
import android.view.View;
import com.hbb20.C1444R;
import java.util.List;
import java.util.Locale;
import p000a.p006b.p030g.p031a.FragmentManager;
import p000a.p006b.p049h.p050a.AlertDialog;
import p205h.p208b.p209a.Anda;
import p205h.p208b.p209a.p210d.PaymentMethodsListener;
import p205h.p208b.p209a.p210d.RemoteUserListener;
import p205h.p208b.p209a.p210d.UserProfile;
import p205h.p208b.p209a.p212e.p216d.C2455h4;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;

/* compiled from: TripFragment.java */
/* renamed from: h.b.a.e.d.h4 */
/* loaded from: classes.dex */
public class C2455h4 implements BackendListeners.PaymentMethodsRequestListener {

    /* renamed from: a */
    public final /* synthetic */ TripFragment f9948a;

    /* compiled from: TripFragment.java */
    /* renamed from: h.b.a.e.d.h4$a */
    /* loaded from: classes.dex */
    public class C2456a implements PaymentMethodsListener {

        /* renamed from: a */
        public final /* synthetic */ List f9949a;

        /* compiled from: TripFragment.java */
        /* renamed from: h.b.a.e.d.h4$a$a */
        /* loaded from: classes.dex */
        public class C2457a implements RemoteUserListener {
            public C2457a() {
            }

            /* renamed from: a */
            public /* synthetic */ void m993a() {
                C2455h4.this.f9948a.f9863e0.post(new RunnableC2422f3(C2455h4.this.f9948a));
            }

            @Override // p205h.p208b.p209a.p210d.RemoteUserListener
            public void onError(DataModels.Error error) {
                C2455h4.this.f9948a.f9862d0.m1447a(error.getMessageToUser(), 0).mo7619m();
            }

            @Override // p205h.p208b.p209a.p210d.RemoteUserListener
            public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
                Anda.m1443b(C2455h4.this.f9948a.f9860b0).m1400o().mo1280a(new Runnable() { // from class: h.b.a.e.d.a2
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2455h4.C2456a.C2457a.this.m993a();
                    }
                });
                AlertDialog.C0325a c0325a = new AlertDialog.C0325a(C2455h4.this.f9948a.f9860b0);
                c0325a.m9131b(C2455h4.this.f9948a.f9860b0.getString(C1444R.string.user_paymentinstructions));
                c0325a.m9140a(C2455h4.this.f9948a.f9860b0.getString(C1444R.string.user_paymentmb_instructions));
                c0325a.m9133b(17039370, (DialogInterface.OnClickListener) null);
                c0325a.m9138a(false);
                c0325a.m9129c();
            }
        }

        /* compiled from: TripFragment.java */
        /* renamed from: h.b.a.e.d.h4$a$b */
        /* loaded from: classes.dex */
        public class C2458b implements RemoteUserListener {
            public C2458b() {
            }

            /* renamed from: a */
            public /* synthetic */ void m992a() {
                C2455h4.this.f9948a.f9863e0.post(new RunnableC2422f3(C2455h4.this.f9948a));
            }

            @Override // p205h.p208b.p209a.p210d.RemoteUserListener
            public void onError(DataModels.Error error) {
                C2455h4.this.f9948a.f9862d0.m1447a(error.getMessageToUser(), 0).mo7619m();
            }

            @Override // p205h.p208b.p209a.p210d.RemoteUserListener
            public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
                Anda.m1443b(C2455h4.this.f9948a.f9860b0).m1400o().mo1280a(new Runnable() { // from class: h.b.a.e.d.b2
                    @Override // java.lang.Runnable
                    public final void run() {
                        C2455h4.C2456a.C2458b.this.m992a();
                    }
                });
            }
        }

        public C2456a(List list) {
            this.f9949a = list;
        }

        @Override // p205h.p208b.p209a.p210d.PaymentMethodsListener
        /* renamed from: a */
        public void mo810a() {
            Anda.m1443b(C2455h4.this.f9948a.f9860b0).m1400o().mo1282a(new C2458b());
        }

        @Override // p205h.p208b.p209a.p210d.PaymentMethodsListener
        /* renamed from: b */
        public UserProfile mo809b() {
            return null;
        }

        @Override // p205h.p208b.p209a.p210d.PaymentMethodsListener
        /* renamed from: c */
        public List<DataModels.PaymentMethod> mo808c() {
            return this.f9949a;
        }

        @Override // p205h.p208b.p209a.p210d.PaymentMethodsListener
        /* renamed from: d */
        public View mo807d() {
            return C2455h4.this.f9948a.f9863e0;
        }

        @Override // p205h.p208b.p209a.p210d.PaymentMethodsListener
        /* renamed from: e */
        public boolean mo806e() {
            return false;
        }

        @Override // p205h.p208b.p209a.p210d.PaymentMethodsListener
        /* renamed from: f */
        public void mo805f() {
            Anda.m1443b(C2455h4.this.f9948a.f9860b0).m1400o().mo1282a(new C2457a());
        }
    }

    public C2455h4(TripFragment tripFragment) {
        this.f9948a = tripFragment;
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
    public void onError(DataModels.Error error) {
        this.f9948a.f9862d0.m1447a(String.format(Locale.getDefault(), "%s: %s", this.f9948a.f9860b0.getString(C1444R.string.error), error.getMessageToUser()), 0).mo7619m();
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.PaymentMethodsRequestListener
    public void onSuccess(List<DataModels.PaymentMethod> list) {
        C2567v3 c2567v3 = new C2567v3();
        c2567v3.m777a((PaymentMethodsListener) new C2456a(list));
        FragmentManager m7447v = this.f9948a.m7447v();
        if (m7447v != null) {
            c2567v3.mo5624a(m7447v, "PaymentMethodDialogFragment");
        }
    }
}
