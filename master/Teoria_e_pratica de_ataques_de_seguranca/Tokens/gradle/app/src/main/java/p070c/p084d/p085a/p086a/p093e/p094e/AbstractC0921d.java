package p070c.p084d.p085a.p086a.p093e.p094e;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
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
import p000a.p006b.p030g.p044j.ArrayMap;
import p070c.p084d.p085a.p086a.p093e.C0900a;
import p070c.p084d.p085a.p086a.p093e.C0902c;
import p070c.p084d.p085a.p086a.p093e.p094e.C0905a;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.AbstractC0981l2;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C0934a0;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C0964h2;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C1009s2;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C1020v1;
import p070c.p084d.p085a.p086a.p093e.p094e.p095l.C1035z0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1086u0;
import p070c.p084d.p085a.p086a.p093e.p096f.C1090w0;
import p070c.p084d.p085a.p086a.p102h.C1193u0;
import p070c.p084d.p085a.p086a.p102h.C1201y0;
import p070c.p084d.p085a.p086a.p102h.InterfaceC1199x0;

/* renamed from: c.d.a.a.e.e.d */
/* loaded from: classes.dex */
public abstract class AbstractC0921d {

    /* renamed from: a */
    public static final Set<AbstractC0921d> f5077a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: c.d.a.a.e.e.d$a */
    /* loaded from: classes.dex */
    public static final class C0922a {

        /* renamed from: a */
        public Account f5078a;

        /* renamed from: d */
        public int f5081d;

        /* renamed from: e */
        public View f5082e;

        /* renamed from: f */
        public String f5083f;

        /* renamed from: g */
        public String f5084g;

        /* renamed from: i */
        public final Context f5086i;

        /* renamed from: k */
        public C1035z0 f5088k;

        /* renamed from: m */
        public InterfaceC0924c f5090m;

        /* renamed from: n */
        public Looper f5091n;

        /* renamed from: b */
        public final Set<Scope> f5079b = new HashSet();

        /* renamed from: c */
        public final Set<Scope> f5080c = new HashSet();

        /* renamed from: h */
        public final Map<C0905a<?>, C1090w0> f5085h = new ArrayMap();

        /* renamed from: j */
        public final Map<C0905a<?>, C0905a.InterfaceC0906a> f5087j = new ArrayMap();

        /* renamed from: l */
        public int f5089l = -1;

        /* renamed from: o */
        public C0902c f5092o = C0902c.m5627c();

        /* renamed from: p */
        public C0905a.AbstractC0912b<? extends InterfaceC1199x0, C1201y0> f5093p = C1193u0.f5584c;

        /* renamed from: q */
        public final ArrayList<InterfaceC0923b> f5094q = new ArrayList<>();

        /* renamed from: r */
        public final ArrayList<InterfaceC0924c> f5095r = new ArrayList<>();

        public C0922a(Context context) {
            this.f5086i = context;
            this.f5091n = context.getMainLooper();
            this.f5083f = context.getPackageName();
            this.f5084g = context.getClass().getName();
        }

        /* renamed from: a */
        public final C0922a m5591a(C0905a<? extends C0905a.InterfaceC0906a.InterfaceC0910d> c0905a) {
            C1049c0.m5293a(c0905a, "Api must not be null");
            this.f5087j.put(c0905a, null);
            List<Scope> m5615a = c0905a.m5621b().m5615a(null);
            this.f5080c.addAll(m5615a);
            this.f5079b.addAll(m5615a);
            return this;
        }

        /* renamed from: a */
        public final C0922a m5590a(InterfaceC0923b interfaceC0923b) {
            C1049c0.m5293a(interfaceC0923b, "Listener must not be null");
            this.f5094q.add(interfaceC0923b);
            return this;
        }

        /* renamed from: a */
        public final C0922a m5589a(InterfaceC0924c interfaceC0924c) {
            C1049c0.m5293a(interfaceC0924c, "Listener must not be null");
            this.f5095r.add(interfaceC0924c);
            return this;
        }

        /* JADX WARN: Type inference failed for: r4v18, types: [c.d.a.a.e.e.a$f, java.lang.Object] */
        /* renamed from: a */
        public final AbstractC0921d m5592a() {
            C1049c0.m5289a(!this.f5087j.isEmpty(), "must call addApi() to add at least one API");
            C1086u0 m5588b = m5588b();
            C0905a<?> c0905a = null;
            Map<C0905a<?>, C1090w0> m5176e = m5588b.m5176e();
            ArrayMap arrayMap = new ArrayMap();
            ArrayMap arrayMap2 = new ArrayMap();
            ArrayList arrayList = new ArrayList();
            boolean z = false;
            for (C0905a<?> c0905a2 : this.f5087j.keySet()) {
                C0905a.InterfaceC0906a interfaceC0906a = this.f5087j.get(c0905a2);
                boolean z2 = m5176e.get(c0905a2) != null;
                arrayMap.put(c0905a2, Boolean.valueOf(z2));
                C1009s2 c1009s2 = new C1009s2(c0905a2, z2);
                arrayList.add(c1009s2);
                C0905a.AbstractC0912b<?, ?> m5620c = c0905a2.m5620c();
                ?? mo4987a = m5620c.mo4987a(this.f5086i, this.f5091n, m5588b, interfaceC0906a, c1009s2, c1009s2);
                arrayMap2.put(c0905a2.m5619d(), mo4987a);
                if (m5620c.m5616a() == 1) {
                    z = interfaceC0906a != null;
                }
                if (mo4987a.m5606j()) {
                    if (c0905a != null) {
                        String m5622a = c0905a2.m5622a();
                        String m5622a2 = c0905a.m5622a();
                        StringBuilder sb = new StringBuilder(String.valueOf(m5622a).length() + 21 + String.valueOf(m5622a2).length());
                        sb.append(m5622a);
                        sb.append(" cannot be used with ");
                        sb.append(m5622a2);
                        throw new IllegalStateException(sb.toString());
                    }
                    c0905a = c0905a2;
                }
            }
            if (c0905a != null) {
                if (z) {
                    String m5622a3 = c0905a.m5622a();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(m5622a3).length() + 82);
                    sb2.append("With using ");
                    sb2.append(m5622a3);
                    sb2.append(", GamesOptions can only be specified within GoogleSignInOptions.Builder");
                    throw new IllegalStateException(sb2.toString());
                }
                C1049c0.m5288a(this.f5078a == null, "Must not set an account in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead", c0905a.m5622a());
                C1049c0.m5288a(this.f5079b.equals(this.f5080c), "Must not set scopes in GoogleApiClient.Builder when using %s. Set account in GoogleSignInOptions.Builder instead.", c0905a.m5622a());
            }
            C0934a0 c0934a0 = new C0934a0(this.f5086i, new ReentrantLock(), this.f5091n, m5588b, this.f5092o, this.f5093p, arrayMap, this.f5094q, this.f5095r, arrayMap2, this.f5089l, C0934a0.m5578a((Iterable<C0905a.InterfaceC0916f>) arrayMap2.values(), true), arrayList, false);
            synchronized (AbstractC0921d.f5077a) {
                AbstractC0921d.f5077a.add(c0934a0);
            }
            if (this.f5089l >= 0) {
                C0964h2.m5513b(this.f5088k).m5515a(this.f5089l, c0934a0, this.f5090m);
            }
            return c0934a0;
        }

        /* renamed from: b */
        public final C1086u0 m5588b() {
            C1201y0 c1201y0 = C1201y0.f5596i;
            if (this.f5087j.containsKey(C1193u0.f5586e)) {
                c1201y0 = (C1201y0) this.f5087j.get(C1193u0.f5586e);
            }
            return new C1086u0(this.f5078a, this.f5079b, this.f5085h, this.f5081d, this.f5082e, this.f5083f, this.f5084g, c1201y0);
        }
    }

    /* renamed from: c.d.a.a.e.e.d$b */
    /* loaded from: classes.dex */
    public interface InterfaceC0923b {
        void onConnected(Bundle bundle);

        void onConnectionSuspended(int i);
    }

    /* renamed from: c.d.a.a.e.e.d$c */
    /* loaded from: classes.dex */
    public interface InterfaceC0924c {
        void onConnectionFailed(C0900a c0900a);
    }

    /* renamed from: a */
    public <A extends C0905a.InterfaceC0913c, T extends AbstractC0981l2<? extends InterfaceC0928g, A>> T mo5371a(T t) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public abstract void mo5508a();

    /* renamed from: a */
    public abstract void mo5507a(InterfaceC0924c interfaceC0924c);

    /* renamed from: a */
    public void mo5370a(C1020v1 c1020v1) {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public abstract void mo5506a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    /* renamed from: b */
    public abstract void mo5505b();

    /* renamed from: b */
    public abstract void mo5504b(InterfaceC0924c interfaceC0924c);

    /* renamed from: c */
    public Looper mo5369c() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: d */
    public abstract boolean mo5503d();
}
