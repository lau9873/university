package c.d.a.a.e.e;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import c.d.a.a.e.e.a.InterfaceC0057a;
import c.d.a.a.e.e.d;
import c.d.a.a.e.f.c0;
import c.d.a.a.e.f.n0;
import c.d.a.a.e.f.t0;
import c.d.a.a.e.f.u0;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class a<O extends InterfaceC0057a> {

    /* renamed from: a  reason: collision with root package name */
    public final b<?, O> f3224a;

    /* renamed from: b  reason: collision with root package name */
    public final g<?> f3225b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3226c;

    /* renamed from: c.d.a.a.e.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0057a {

        /* renamed from: c.d.a.a.e.e.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public interface InterfaceC0058a extends c, d {
            Account b();
        }

        /* renamed from: c.d.a.a.e.e.a$a$b */
        /* loaded from: classes.dex */
        public interface b extends c {
            GoogleSignInAccount a();
        }

        /* renamed from: c.d.a.a.e.e.a$a$c */
        /* loaded from: classes.dex */
        public interface c extends InterfaceC0057a {
        }

        /* renamed from: c.d.a.a.e.e.a$a$d */
        /* loaded from: classes.dex */
        public interface d extends InterfaceC0057a {
        }

        /* renamed from: c.d.a.a.e.e.a$a$e */
        /* loaded from: classes.dex */
        public interface e extends c, d {
        }
    }

    /* loaded from: classes.dex */
    public static abstract class b<T extends f, O> extends e<T, O> {
        public abstract T a(Context context, Looper looper, u0 u0Var, O o, d.b bVar, d.c cVar);
    }

    /* loaded from: classes.dex */
    public interface c {
    }

    /* loaded from: classes.dex */
    public static class d<C extends c> {
    }

    /* loaded from: classes.dex */
    public static abstract class e<T extends c, O> {
        public int a() {
            return Integer.MAX_VALUE;
        }

        public List<Scope> a(O o) {
            return Collections.emptyList();
        }
    }

    /* loaded from: classes.dex */
    public interface f extends c {
        void a();

        void a(n0 n0Var);

        void a(c.d.a.a.e.f.n nVar, Set<Scope> set);

        void a(t0 t0Var);

        void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        boolean c();

        int d();

        boolean e();

        boolean g();

        boolean h();

        IBinder i();

        boolean j();

        Intent k();

        String l();
    }

    /* loaded from: classes.dex */
    public static final class g<C extends f> extends d<C> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends f> a(String str, b<C, O> bVar, g<C> gVar) {
        c0.a(bVar, "Cannot construct an Api with a null ClientBuilder");
        c0.a(gVar, "Cannot construct an Api with a null ClientKey");
        this.f3226c = str;
        this.f3224a = bVar;
        this.f3225b = gVar;
    }

    public final String a() {
        return this.f3226c;
    }

    public final e<?, O> b() {
        return this.f3224a;
    }

    public final b<?, O> c() {
        c0.b(this.f3224a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f3224a;
    }

    public final d<?> d() {
        g<?> gVar = this.f3225b;
        if (gVar != null) {
            return gVar;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }
}
