package p070c.p084d.p085a.p086a.p093e.p094e;

import android.accounts.Account;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import p070c.p084d.p085a.p086a.p093e.p094e.AbstractC0921d;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a.InterfaceC0906a;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1086u0;
import p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1071n;
import p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1072n0;
import p070c.p084d.p085a.p086a.p093e.p096f.InterfaceC1084t0;

/* renamed from: c.d.a.a.e.e.a */
/* loaded from: classes.dex */
public final class C0905a<O extends InterfaceC0906a> {

    /* renamed from: a */
    public final AbstractC0912b<?, O> f5064a;

    /* renamed from: b */
    public final C0917g<?> f5065b;

    /* renamed from: c */
    public final String f5066c;

    /* renamed from: c.d.a.a.e.e.a$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0906a {

        /* renamed from: c.d.a.a.e.e.a$a$a */
        /* loaded from: classes.dex */
        public interface InterfaceC0907a extends InterfaceC0909c, InterfaceC0910d {
            /* renamed from: b */
            Account m5618b();
        }

        /* renamed from: c.d.a.a.e.e.a$a$b */
        /* loaded from: classes.dex */
        public interface InterfaceC0908b extends InterfaceC0909c {
            /* renamed from: a */
            GoogleSignInAccount m5617a();
        }

        /* renamed from: c.d.a.a.e.e.a$a$c */
        /* loaded from: classes.dex */
        public interface InterfaceC0909c extends InterfaceC0906a {
        }

        /* renamed from: c.d.a.a.e.e.a$a$d */
        /* loaded from: classes.dex */
        public interface InterfaceC0910d extends InterfaceC0906a {
        }

        /* renamed from: c.d.a.a.e.e.a$a$e */
        /* loaded from: classes.dex */
        public interface InterfaceC0911e extends InterfaceC0909c, InterfaceC0910d {
        }
    }

    /* renamed from: c.d.a.a.e.e.a$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0912b<T extends InterfaceC0916f, O> extends AbstractC0915e<T, O> {
        /* renamed from: a */
        public abstract T mo4987a(Context context, Looper looper, C1086u0 c1086u0, O o, AbstractC0921d.InterfaceC0923b interfaceC0923b, AbstractC0921d.InterfaceC0924c interfaceC0924c);
    }

    /* renamed from: c.d.a.a.e.e.a$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0913c {
    }

    /* renamed from: c.d.a.a.e.e.a$d */
    /* loaded from: classes.dex */
    public static class C0914d<C extends InterfaceC0913c> {
    }

    /* renamed from: c.d.a.a.e.e.a$e */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0915e<T extends InterfaceC0913c, O> {
        /* renamed from: a */
        public int m5616a() {
            return Integer.MAX_VALUE;
        }

        /* renamed from: a */
        public List<Scope> m5615a(O o) {
            return Collections.emptyList();
        }
    }

    /* renamed from: c.d.a.a.e.e.a$f */
    /* loaded from: classes.dex */
    public interface InterfaceC0916f extends InterfaceC0913c {
        /* renamed from: a */
        void mo5029a();

        /* renamed from: a */
        void m5614a(InterfaceC1072n0 interfaceC1072n0);

        /* renamed from: a */
        void m5613a(InterfaceC1071n interfaceC1071n, Set<Scope> set);

        /* renamed from: a */
        void m5612a(InterfaceC1084t0 interfaceC1084t0);

        /* renamed from: a */
        void m5611a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

        /* renamed from: c */
        boolean m5610c();

        /* renamed from: d */
        int mo5296d();

        /* renamed from: e */
        boolean mo5043e();

        /* renamed from: g */
        boolean m5609g();

        /* renamed from: h */
        boolean m5608h();

        /* renamed from: i */
        IBinder m5607i();

        /* renamed from: j */
        boolean m5606j();

        /* renamed from: k */
        Intent m5605k();

        /* renamed from: l */
        String m5604l();
    }

    /* renamed from: c.d.a.a.e.e.a$g */
    /* loaded from: classes.dex */
    public static final class C0917g<C extends InterfaceC0916f> extends C0914d<C> {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <C extends InterfaceC0916f> C0905a(String str, AbstractC0912b<C, O> abstractC0912b, C0917g<C> c0917g) {
        C1049c0.m5293a(abstractC0912b, "Cannot construct an Api with a null ClientBuilder");
        C1049c0.m5293a(c0917g, "Cannot construct an Api with a null ClientKey");
        this.f5066c = str;
        this.f5064a = abstractC0912b;
        this.f5065b = c0917g;
    }

    /* renamed from: a */
    public final String m5622a() {
        return this.f5066c;
    }

    /* renamed from: b */
    public final AbstractC0915e<?, O> m5621b() {
        return this.f5064a;
    }

    /* renamed from: c */
    public final AbstractC0912b<?, O> m5620c() {
        C1049c0.m5285b(this.f5064a != null, "This API was constructed with a SimpleClientBuilder. Use getSimpleClientBuilder");
        return this.f5064a;
    }

    /* renamed from: d */
    public final C0914d<?> m5619d() {
        C0917g<?> c0917g = this.f5065b;
        if (c0917g != null) {
            return c0917g;
        }
        throw new IllegalStateException("This API was constructed with null client keys. This should not be possible.");
    }
}
