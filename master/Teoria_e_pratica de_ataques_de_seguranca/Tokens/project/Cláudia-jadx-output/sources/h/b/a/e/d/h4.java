package h.b.a.e.d;

import a.b.h.a.c;
import android.content.DialogInterface;
import android.view.View;
import h.b.a.e.d.h4;
import java.util.List;
import java.util.Locale;
import pt.card4b.backendbeacons.BackendListeners;
import pt.card4b.backendbeacons.DataModels;
/* compiled from: TripFragment.java */
/* loaded from: classes.dex */
public class h4 implements BackendListeners.PaymentMethodsRequestListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g4 f7204a;

    /* compiled from: TripFragment.java */
    /* loaded from: classes.dex */
    public class a implements h.b.a.d.r {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f7205a;

        /* compiled from: TripFragment.java */
        /* renamed from: h.b.a.e.d.h4$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0167a implements h.b.a.d.s {
            public C0167a() {
            }

            public /* synthetic */ void a() {
                h4.this.f7204a.e0.post(new f3(h4.this.f7204a));
            }

            @Override // h.b.a.d.s
            public void onError(DataModels.Error error) {
                h4.this.f7204a.d0.a(error.getMessageToUser(), 0).m();
            }

            @Override // h.b.a.d.s
            public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
                h.b.a.c.b(h4.this.f7204a.b0).o().a(new Runnable() { // from class: h.b.a.e.d.a2
                    @Override // java.lang.Runnable
                    public final void run() {
                        h4.a.C0167a.this.a();
                    }
                });
                c.a aVar = new c.a(h4.this.f7204a.b0);
                aVar.b(h4.this.f7204a.b0.getString(2131755406));
                aVar.a(h4.this.f7204a.b0.getString(2131755407));
                aVar.b(17039370, (DialogInterface.OnClickListener) null);
                aVar.a(false);
                aVar.c();
            }
        }

        /* compiled from: TripFragment.java */
        /* loaded from: classes.dex */
        public class b implements h.b.a.d.s {
            public b() {
            }

            public /* synthetic */ void a() {
                h4.this.f7204a.e0.post(new f3(h4.this.f7204a));
            }

            @Override // h.b.a.d.s
            public void onError(DataModels.Error error) {
                h4.this.f7204a.d0.a(error.getMessageToUser(), 0).m();
            }

            @Override // h.b.a.d.s
            public void onSuccess(DataModels.UserAccountInfo userAccountInfo) {
                h.b.a.c.b(h4.this.f7204a.b0).o().a(new Runnable() { // from class: h.b.a.e.d.b2
                    @Override // java.lang.Runnable
                    public final void run() {
                        h4.a.b.this.a();
                    }
                });
            }
        }

        public a(List list) {
            this.f7205a = list;
        }

        @Override // h.b.a.d.r
        public void a() {
            h.b.a.c.b(h4.this.f7204a.b0).o().a(new b());
        }

        @Override // h.b.a.d.r
        public h.b.a.d.y b() {
            return null;
        }

        @Override // h.b.a.d.r
        public List<DataModels.PaymentMethod> c() {
            return this.f7205a;
        }

        @Override // h.b.a.d.r
        public View d() {
            return h4.this.f7204a.e0;
        }

        @Override // h.b.a.d.r
        public boolean e() {
            return false;
        }

        @Override // h.b.a.d.r
        public void f() {
            h.b.a.c.b(h4.this.f7204a.b0).o().a(new C0167a());
        }
    }

    public h4(g4 g4Var) {
        this.f7204a = g4Var;
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.BaseRequestListener
    public void onError(DataModels.Error error) {
        this.f7204a.d0.a(String.format(Locale.getDefault(), "%s: %s", this.f7204a.b0.getString(2131755195), error.getMessageToUser()), 0).m();
    }

    @Override // pt.card4b.backendbeacons.BackendListeners.PaymentMethodsRequestListener
    public void onSuccess(List<DataModels.PaymentMethod> list) {
        v3 v3Var = new v3();
        v3Var.a((h.b.a.d.r) new a(list));
        a.b.g.a.k v = this.f7204a.v();
        if (v != null) {
            v3Var.a(v, "PaymentMethodDialogFragment");
        }
    }
}
