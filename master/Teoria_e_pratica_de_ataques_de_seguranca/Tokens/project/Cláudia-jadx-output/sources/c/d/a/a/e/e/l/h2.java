package c.d.a.a.e.e.l;

import android.util.Log;
import android.util.SparseArray;
import c.d.a.a.e.e.d;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class h2 extends n2 {

    /* renamed from: f  reason: collision with root package name */
    public final SparseArray<a> f3307f;

    /* loaded from: classes.dex */
    public class a implements d.c {

        /* renamed from: a  reason: collision with root package name */
        public final int f3308a;

        /* renamed from: b  reason: collision with root package name */
        public final c.d.a.a.e.e.d f3309b;

        /* renamed from: c  reason: collision with root package name */
        public final d.c f3310c;

        public a(int i2, c.d.a.a.e.e.d dVar, d.c cVar) {
            this.f3308a = i2;
            this.f3309b = dVar;
            this.f3310c = cVar;
            dVar.a(this);
        }

        @Override // c.d.a.a.e.e.d.c
        public final void onConnectionFailed(c.d.a.a.e.a aVar) {
            String valueOf = String.valueOf(aVar);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
            sb.append("beginFailureResolution for ");
            sb.append(valueOf);
            Log.d("AutoManageHelper", sb.toString());
            h2.this.b(aVar, this.f3308a);
        }
    }

    public h2(a1 a1Var) {
        super(a1Var);
        this.f3307f = new SparseArray<>();
        this.f4085a.a("AutoManageHelper", this);
    }

    public static h2 b(z0 z0Var) {
        a1 a2 = LifecycleCallback.a(z0Var);
        h2 h2Var = (h2) a2.a("AutoManageHelper", h2.class);
        return h2Var != null ? h2Var : new h2(a2);
    }

    public final void a(int i2) {
        a aVar = this.f3307f.get(i2);
        this.f3307f.remove(i2);
        if (aVar != null) {
            aVar.f3309b.b(aVar);
            aVar.f3309b.b();
        }
    }

    public final void a(int i2, c.d.a.a.e.e.d dVar, d.c cVar) {
        c.d.a.a.e.f.c0.a(dVar, "GoogleApiClient instance cannot be null");
        boolean z = this.f3307f.indexOfKey(i2) < 0;
        StringBuilder sb = new StringBuilder(54);
        sb.append("Already managing a GoogleApiClient with id ");
        sb.append(i2);
        c.d.a.a.e.f.c0.b(z, sb.toString());
        o2 o2Var = this.f3373c.get();
        boolean z2 = this.f3372b;
        String valueOf = String.valueOf(o2Var);
        StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf).length() + 49);
        sb2.append("starting AutoManage for client ");
        sb2.append(i2);
        sb2.append(" ");
        sb2.append(z2);
        sb2.append(" ");
        sb2.append(valueOf);
        Log.d("AutoManageHelper", sb2.toString());
        this.f3307f.put(i2, new a(i2, dVar, cVar));
        if (this.f3372b && o2Var == null) {
            String valueOf2 = String.valueOf(dVar);
            StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf2).length() + 11);
            sb3.append("connecting ");
            sb3.append(valueOf2);
            Log.d("AutoManageHelper", sb3.toString());
            dVar.a();
        }
    }

    @Override // c.d.a.a.e.e.l.n2
    public final void a(c.d.a.a.e.a aVar, int i2) {
        Log.w("AutoManageHelper", "Unresolved error while connecting client. Stopping auto-manage.");
        if (i2 < 0) {
            Log.wtf("AutoManageHelper", "AutoManageLifecycleHelper received onErrorResolutionFailed callback but no failing client ID is set", new Exception());
            return;
        }
        a aVar2 = this.f3307f.get(i2);
        if (aVar2 != null) {
            a(i2);
            d.c cVar = aVar2.f3310c;
            if (cVar != null) {
                cVar.onConnectionFailed(aVar);
            }
        }
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        for (int i2 = 0; i2 < this.f3307f.size(); i2++) {
            a b2 = b(i2);
            if (b2 != null) {
                printWriter.append((CharSequence) str).append("GoogleApiClient #").print(b2.f3308a);
                printWriter.println(":");
                b2.f3309b.a(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
            }
        }
    }

    public final a b(int i2) {
        if (this.f3307f.size() <= i2) {
            return null;
        }
        SparseArray<a> sparseArray = this.f3307f;
        return sparseArray.get(sparseArray.keyAt(i2));
    }

    @Override // c.d.a.a.e.e.l.n2, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void d() {
        super.d();
        boolean z = this.f3372b;
        String valueOf = String.valueOf(this.f3307f);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 14);
        sb.append("onStart ");
        sb.append(z);
        sb.append(" ");
        sb.append(valueOf);
        Log.d("AutoManageHelper", sb.toString());
        if (this.f3373c.get() == null) {
            for (int i2 = 0; i2 < this.f3307f.size(); i2++) {
                a b2 = b(i2);
                if (b2 != null) {
                    b2.f3309b.a();
                }
            }
        }
    }

    @Override // c.d.a.a.e.e.l.n2, com.google.android.gms.common.api.internal.LifecycleCallback
    public final void e() {
        super.e();
        for (int i2 = 0; i2 < this.f3307f.size(); i2++) {
            a b2 = b(i2);
            if (b2 != null) {
                b2.f3309b.b();
            }
        }
    }

    @Override // c.d.a.a.e.e.l.n2
    public final void f() {
        for (int i2 = 0; i2 < this.f3307f.size(); i2++) {
            a b2 = b(i2);
            if (b2 != null) {
                b2.f3309b.a();
            }
        }
    }
}
