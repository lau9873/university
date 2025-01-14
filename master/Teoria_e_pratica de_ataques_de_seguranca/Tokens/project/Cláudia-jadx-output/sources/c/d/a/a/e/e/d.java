package c.d.a.a.e.e;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import c.d.a.a.e.e.a;
import c.d.a.a.e.e.l.a0;
import c.d.a.a.e.e.l.h2;
import c.d.a.a.e.e.l.l2;
import c.d.a.a.e.e.l.s2;
import c.d.a.a.e.e.l.v1;
import c.d.a.a.e.e.l.z0;
import c.d.a.a.e.f.c0;
import c.d.a.a.e.f.w0;
import c.d.a.a.h.u0;
import c.d.a.a.h.x0;
import c.d.a.a.h.y0;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.ReentrantLock;
/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<d> f3237a = Collections.newSetFromMap(new WeakHashMap());

    /* loaded from: classes.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public Account f3238a;

        /* renamed from: d  reason: collision with root package name */
        public int f3241d;

        /* renamed from: e  reason: collision with root package name */
        public View f3242e;

        /* renamed from: f  reason: collision with root package name */
        public String f3243f;

        /* renamed from: g  reason: collision with root package name */
        public String f3244g;

        /* renamed from: i  reason: collision with root package name */
        public final Context f3246i;
        public z0 k;
        public c m;
        public Looper n;

        /* renamed from: b  reason: collision with root package name */
        public final Set<Scope> f3239b = new HashSet();

        /* renamed from: c  reason: collision with root package name */
        public final Set<Scope> f3240c = new HashSet();

        /* renamed from: h  reason: collision with root package name */
        public final Map<c.d.a.a.e.e.a<?>, w0> f3245h = new a.b.g.j.a();
        public final Map<c.d.a.a.e.e.a<?>, a.InterfaceC0057a> j = new a.b.g.j.a();
        public int l = -1;
        public c.d.a.a.e.c o = c.d.a.a.e.c.c();
        public a.b<? extends x0, y0> p = u0.f3641c;
        public final ArrayList<b> q = new ArrayList<>();
        public final ArrayList<c> r = new ArrayList<>();

        public a(Context context) {
            this.f3246i = context;
            this.n = context.getMainLooper();
            this.f3243f = context.getPackageName();
            this.f3244g = context.getClass().getName();
        }

        public final a a(c.d.a.a.e.e.a<? extends a.InterfaceC0057a.d> aVar) {
            c0.a(aVar, "Api must not be null");
            this.j.put(aVar, null);
            List<Scope> a2 = aVar.b().a(null);
            this.f3240c.addAll(a2);
            this.f3239b.addAll(a2);
            return this;
        }

        public final a a(b bVar) {
            c0.a(bVar, "Listener must not be null");
            this.q.add(bVar);
            return this;
        }

        public final a a(c cVar) {
            c0.a(cVar, "Listener must not be null");
            this.r.add(cVar);
            return this;
        }

        /* JADX WARN: Type inference failed for: r4v18, types: [c.d.a.a.e.e.a$f, java.lang.Object] */
        public final d a() {
            c0.a(!this.j.isEmpty(), "must call addApi() to add at least one API");
            c.d.a.a.e.f.u0 b2 = b();
            c.d.a.a.e.e.a<?> aVar = null;
            Map<c.d.a.a.e.e.a<?>, w0> e2 = b2.e();
            a.b.g.j.a aVar2 = new a.b.g.j.a();
            a.b.g.j.a aVar3 = new a.b.g.j.a();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (c.d.a.a.e.e.a<?> aVar4 : this.j.keySet()) {
                a.InterfaceC0057a interfaceC0057a = this.j.get(aVar4);
                boolean z2 = e2.get(aVar4) != null;
                aVar2.put(aVar4, Boolean.valueOf(z2));
                s2 s2Var = new s2(aVar4, z2);
                arrayList.add(s2Var);
                a.b<?, ?> c2 = aVar4.c();
                ?? a2 = c2.a(this.f3246i, this.n, b2, interfaceC0057a, s2Var, s2Var);
                aVar3.put(aVar4.d(), a2);
                if (c2.a() == 1) {
                    z = interfaceC0057a != null;
                }
                if (a2.j()) {
                    if (aVar != null) {
                        String a3 = aVar4.a();
                        String a4 = aVar.a();
                        StringBuilder sb = new StringBuilder(String.valueOf(a3).length() + 21 + String.valueOf(a4).length());
                        sb.append(a3);
                        sb.append(" cannot be used with ");
                        sb.append(a4);
                        throw new IllegalStateException(sb.toString());
                    }
                    aVar = aVar4;
                }
            }
            if (aVar != null) {
                if (z) {
                    String a5 = aVar.a();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(a5).length() + 82);
                    sb2.append("With using ");
                    sb2.append(a5);
                    sb2.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                    throw new IllegalStateException(sb2.toString());
                }
                c0.a(this.f3238a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", aVar.a());
                c0.a(this.f3239b.equals(this.f3240c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", aVar.a());
            }
            a0 a0Var = new a0(this.f3246i, new ReentrantLock(), this.n, b2, this.o, this.p, aVar2, this.q, this.r, aVar3, this.l, a0.a((Iterable<a.f>) aVar3.values(), true), arrayList, false);
            synchronized (d.f3237a) {
                d.f3237a.add(a0Var);
            }
            if (this.l >= 0) {
                h2.b(this.k).a(this.l, a0Var, this.m);
            }
            return a0Var;
        }

        public final c.d.a.a.e.f.u0 b() {
            y0 y0Var = y0.f3653i;
            if (this.j.containsKey(u0.f3643e)) {
                y0Var = (y0) this.j.get(u0.f3643e);
            }
            return new c.d.a.a.e.f.u0(this.f3238a, this.f3239b, this.f3245h, this.f3241d, this.f3242e, this.f3243f, this.f3244g, y0Var);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i2);
    }

    /* loaded from: classes.dex */
    public interface c {
        void onConnectionFailed(c.d.a.a.e.a aVar);
    }

    public <A extends a.c, T extends l2<? extends g, A>> T a(T t) {
        throw new UnsupportedOperationException();
    }

    public abstract void a();

    public abstract void a(c cVar);

    public void a(v1 v1Var) {
        throw new UnsupportedOperationException();
    }

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void b();

    public abstract void b(c cVar);

    public Looper c() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean d();
}
