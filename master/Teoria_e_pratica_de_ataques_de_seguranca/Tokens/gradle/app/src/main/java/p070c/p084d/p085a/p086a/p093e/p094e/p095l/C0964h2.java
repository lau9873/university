package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.util.Log;
import android.util.SparseArray;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;

/* renamed from: c.d.a.a.e.e.l.h2 */
/* loaded from: classes.dex */
public class C0964h2 extends AbstractDialogInterface$OnCancelListenerC0989n2 {

    /* renamed from: f */
    public final SparseArray<C0965a> f5187f;

    /* renamed from: c.d.a.a.e.e.l.h2$a */
    /* loaded from: classes.dex */
    public class C0965a implements AbstractC0921d.InterfaceC0924c {

        /* renamed from: a */
        public final int f5188a;

        /* renamed from: b */
        public final AbstractC0921d f5189b;

        /* renamed from: c */
        public final AbstractC0921d.InterfaceC0924c f5190c;

        public C0965a(int i, AbstractC0921d abstractC0921d, AbstractC0921d.InterfaceC0924c interfaceC0924c) {
            this.f5188a = i;
            this.f5189b = abstractC0921d;
            this.f5190c = interfaceC0924c;
            abstractC0921d.mo5507a(this);
        }

        @Override // p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d.InterfaceC0924c
        public final void onConnectionFailed(C0900a c0900a) {
            String valueOf = String.valueOf(c0900a);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("beginFailureResolution for ");
            sb.append(valueOf);
            Log.d("AutoManageHelper", sb.toString());
            C0964h2.this.m5396b(c0900a, this.f5188a);
        }
    }

    public C0964h2(InterfaceC0935a1 interfaceC0935a1) {
        super(interfaceC0935a1);
        this.f5187f = new SparseArray<>();
        this.f6131a.mo5379a("AutoManageHelper", this);
    }

    /* renamed from: b */
    public static C0964h2 m5513b(C1035z0 c1035z0) {
        InterfaceC0935a1 m4347a = LifecycleCallback.m4347a(c1035z0);
        C0964h2 c0964h2 = (C0964h2) m4347a.mo5377a("AutoManageHelper", C0964h2.class);
        return c0964h2 != null ? c0964h2 : new C0964h2(m4347a);
    }

    /* renamed from: a */
    public final void m5516a(int i) {
        C0965a c0965a = this.f5187f.get(i);
        this.f5187f.remove(i);
        if (c0965a != null) {
            c0965a.f5189b.mo5504b(c0965a);
            c0965a.f5189b.mo5505b();
        }
    }

    /* renamed from: a */
    public final void m5515a(int i, AbstractC0921d abstractC0921d, AbstractC0921d.InterfaceC0924c interfaceC0924c) {
        C1049c0.m5293a(abstractC0921d, "GoogleApiClient instance cannot be null");
        boolean z = this.f5187f.indexOfKey(i) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i);
        C1049c0.m5285b(z, sb.toString());
        C0993o2 c0993o2 = this.f5278c.get();
        boolean z2 = this.f5277b;
        String valueOf = String.valueOf(c0993o2);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 49);
        sb2.append("starting AutoManage for client ");
        sb2.append(i);
        sb2.append(" ");
        sb2.append(z2);
        sb2.append(" ");
        sb2.append(valueOf);
        Log.d("AutoManageHelper", sb2.toString());
        this.f5187f.put(i, new C0965a(i, abstractC0921d, interfaceC0924c));
        if (this.f5277b && c0993o2 == null) {
            String valueOf2 = String.valueOf(abstractC0921d);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 11);
            sb3.append("connecting ");
            sb3.append(valueOf2);
            Log.d("AutoManageHelper", sb3.toString());
            abstractC0921d.mo5508a();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractDialogInterface$OnCancelListenerC0989n2
    /* renamed from: a */
    public final void mo5398a(C0900a c0900a, int i) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        C0965a c0965a = this.f5187f.get(i);
        if (c0965a != null) {
            m5516a(i);
            AbstractC0921d.InterfaceC0924c interfaceC0924c = c0965a.f5190c;
            if (interfaceC0924c != null) {
                interfaceC0924c.onConnectionFailed(c0900a);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    /* renamed from: a */
    public final void mo4346a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i = 0; i < this.f5187f.size(); i++) {
            C0965a m5514b = m5514b(i);
            if (m5514b != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(m5514b.f5188a);
                printWriter.println(":");
                m5514b.f5189b.mo5506a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    /* renamed from: b */
    public final C0965a m5514b(int i) {
        if (this.f5187f.size() <= i) {
            return null;
        }
        SparseArray<C0965a> sparseArray = this.f5187f;
        return sparseArray.get(sparseArray.keyAt(i));
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractDialogInterface$OnCancelListenerC0989n2, com.google.android.gms.common.api.internal.LifecycleCallback
    /* renamed from: d */
    public final void mo4342d() {
        super.mo4342d();
        boolean z = this.f5277b;
        String valueOf = String.valueOf(this.f5187f);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("onStart ");
        sb.append(z);
        sb.append(" ");
        sb.append(valueOf);
        Log.d("AutoManageHelper", sb.toString());
        if (this.f5278c.get() == null) {
            for (int i = 0; i < this.f5187f.size(); i++) {
                C0965a m5514b = m5514b(i);
                if (m5514b != null) {
                    m5514b.f5189b.mo5508a();
                }
            }
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractDialogInterface$OnCancelListenerC0989n2, com.google.android.gms.common.api.internal.LifecycleCallback
    /* renamed from: e */
    public final void mo4341e() {
        super.mo4341e();
        for (int i = 0; i < this.f5187f.size(); i++) {
            C0965a m5514b = m5514b(i);
            if (m5514b != null) {
                m5514b.f5189b.mo5505b();
            }
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractDialogInterface$OnCancelListenerC0989n2
    /* renamed from: f */
    public final void mo5395f() {
        for (int i = 0; i < this.f5187f.size(); i++) {
            C0965a m5514b = m5514b(i);
            if (m5514b != null) {
                m5514b.f5189b.mo5508a();
            }
        }
    }
}
