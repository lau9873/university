package a.b.g.a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/* compiled from: NotificationCompat.java */
/* loaded from: classes.dex */
public class y {

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Bundle f809a;

        /* renamed from: b  reason: collision with root package name */
        public final d0[] f810b;

        /* renamed from: c  reason: collision with root package name */
        public final d0[] f811c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f812d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f813e;

        /* renamed from: f  reason: collision with root package name */
        public final int f814f;

        /* renamed from: g  reason: collision with root package name */
        public int f815g;

        /* renamed from: h  reason: collision with root package name */
        public CharSequence f816h;

        /* renamed from: i  reason: collision with root package name */
        public PendingIntent f817i;

        /* compiled from: NotificationCompat.java */
        /* renamed from: a.b.g.a.y$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static final class C0017a {

            /* renamed from: a  reason: collision with root package name */
            public final int f818a;

            /* renamed from: b  reason: collision with root package name */
            public final CharSequence f819b;

            /* renamed from: c  reason: collision with root package name */
            public final PendingIntent f820c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f821d;

            /* renamed from: e  reason: collision with root package name */
            public final Bundle f822e;

            /* renamed from: f  reason: collision with root package name */
            public ArrayList<d0> f823f;

            /* renamed from: g  reason: collision with root package name */
            public int f824g;

            /* renamed from: h  reason: collision with root package name */
            public boolean f825h;

            public C0017a(int i2, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i2, charSequence, pendingIntent, new Bundle(), null, true, 0, true);
            }

            public a a() {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<d0> arrayList3 = this.f823f;
                if (arrayList3 != null) {
                    Iterator<d0> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        d0 next = it.next();
                        if (next.g()) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                d0[] d0VarArr = arrayList.isEmpty() ? null : (d0[]) arrayList.toArray(new d0[arrayList.size()]);
                return new a(this.f818a, this.f819b, this.f820c, this.f822e, arrayList2.isEmpty() ? null : (d0[]) arrayList2.toArray(new d0[arrayList2.size()]), d0VarArr, this.f821d, this.f824g, this.f825h);
            }

            public C0017a(int i2, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, d0[] d0VarArr, boolean z, int i3, boolean z2) {
                this.f821d = true;
                this.f825h = true;
                this.f818a = i2;
                this.f819b = c.d(charSequence);
                this.f820c = pendingIntent;
                this.f822e = bundle;
                this.f823f = d0VarArr == null ? null : new ArrayList<>(Arrays.asList(d0VarArr));
                this.f821d = z;
                this.f824g = i3;
                this.f825h = z2;
            }
        }

        public a(int i2, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, d0[] d0VarArr, d0[] d0VarArr2, boolean z, int i3, boolean z2) {
            this.f813e = true;
            this.f815g = i2;
            this.f816h = c.d(charSequence);
            this.f817i = pendingIntent;
            this.f809a = bundle == null ? new Bundle() : bundle;
            this.f810b = d0VarArr;
            this.f811c = d0VarArr2;
            this.f812d = z;
            this.f814f = i3;
            this.f813e = z2;
        }

        public PendingIntent a() {
            return this.f817i;
        }

        public boolean b() {
            return this.f812d;
        }

        public d0[] c() {
            return this.f811c;
        }

        public Bundle d() {
            return this.f809a;
        }

        public int e() {
            return this.f815g;
        }

        public d0[] f() {
            return this.f810b;
        }

        public int g() {
            return this.f814f;
        }

        public boolean h() {
            return this.f813e;
        }

        public CharSequence i() {
            return this.f816h;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class b extends d {

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f826e;

        public b a(CharSequence charSequence) {
            this.f826e = c.d(charSequence);
            return this;
        }

        @Override // a.b.g.a.y.d
        public void a(x xVar) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(xVar.a()).setBigContentTitle(this.f837b).bigText(this.f826e);
                if (this.f839d) {
                    bigText.setSummaryText(this.f838c);
                }
            }
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static class c {
        public String A;
        public Bundle B;
        public int C;
        public int D;
        public Notification E;
        public RemoteViews F;
        public RemoteViews G;
        public RemoteViews H;
        public String I;
        public int J;
        public String K;
        public long L;
        public int M;
        public Notification N;
        @Deprecated
        public ArrayList<String> O;

        /* renamed from: a  reason: collision with root package name */
        public Context f827a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f828b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<a> f829c;

        /* renamed from: d  reason: collision with root package name */
        public CharSequence f830d;

        /* renamed from: e  reason: collision with root package name */
        public CharSequence f831e;

        /* renamed from: f  reason: collision with root package name */
        public PendingIntent f832f;

        /* renamed from: g  reason: collision with root package name */
        public PendingIntent f833g;

        /* renamed from: h  reason: collision with root package name */
        public RemoteViews f834h;

        /* renamed from: i  reason: collision with root package name */
        public Bitmap f835i;
        public CharSequence j;
        public int k;
        public int l;
        public boolean m;
        public boolean n;
        public d o;
        public CharSequence p;
        public CharSequence[] q;
        public int r;
        public int s;
        public boolean t;
        public String u;
        public boolean v;
        public String w;
        public boolean x;
        public boolean y;
        public boolean z;

        public c(Context context, String str) {
            this.f828b = new ArrayList<>();
            this.f829c = new ArrayList<>();
            this.m = true;
            this.x = false;
            this.C = 0;
            this.D = 0;
            this.J = 0;
            this.M = 0;
            this.N = new Notification();
            this.f827a = context;
            this.I = str;
            this.N.when = System.currentTimeMillis();
            this.N.audioStreamType = -1;
            this.l = 0;
            this.O = new ArrayList<>();
        }

        public c a(long j) {
            this.N.when = j;
            return this;
        }

        public c b(CharSequence charSequence) {
            this.f830d = d(charSequence);
            return this;
        }

        public c c(int i2) {
            this.N.icon = i2;
            return this;
        }

        public c d(int i2) {
            this.D = i2;
            return this;
        }

        public static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public c a(CharSequence charSequence) {
            this.f831e = d(charSequence);
            return this;
        }

        public c b(boolean z) {
            this.x = z;
            return this;
        }

        public c c(CharSequence charSequence) {
            this.N.tickerText = d(charSequence);
            return this;
        }

        public c a(PendingIntent pendingIntent) {
            this.f832f = pendingIntent;
            return this;
        }

        public c b(int i2) {
            this.l = i2;
            return this;
        }

        public c c(String str) {
            this.u = str;
            return this;
        }

        public c a(long[] jArr) {
            this.N.vibrate = jArr;
            return this;
        }

        public Bundle b() {
            if (this.B == null) {
                this.B = new Bundle();
            }
            return this.B;
        }

        public c a(boolean z) {
            a(16, z);
            return this;
        }

        public c a(String str) {
            this.A = str;
            return this;
        }

        public final void a(int i2, boolean z) {
            if (z) {
                Notification notification = this.N;
                notification.flags = i2 | notification.flags;
                return;
            }
            Notification notification2 = this.N;
            notification2.flags = (~i2) & notification2.flags;
        }

        public c b(String str) {
            this.I = str;
            return this;
        }

        public c a(a aVar) {
            this.f828b.add(aVar);
            return this;
        }

        public c a(d dVar) {
            if (this.o != dVar) {
                this.o = dVar;
                d dVar2 = this.o;
                if (dVar2 != null) {
                    dVar2.a(this);
                }
            }
            return this;
        }

        public c a(int i2) {
            this.C = i2;
            return this;
        }

        public Notification a() {
            return new z(this).b();
        }

        @Deprecated
        public c(Context context) {
            this(context, null);
        }
    }

    /* compiled from: NotificationCompat.java */
    /* loaded from: classes.dex */
    public static abstract class d {

        /* renamed from: a  reason: collision with root package name */
        public c f836a;

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f837b;

        /* renamed from: c  reason: collision with root package name */
        public CharSequence f838c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f839d = false;

        public abstract void a(x xVar);

        public void a(c cVar) {
            if (this.f836a != cVar) {
                this.f836a = cVar;
                c cVar2 = this.f836a;
                if (cVar2 != null) {
                    cVar2.a(this);
                }
            }
        }

        public void a(Bundle bundle) {
        }

        public RemoteViews b(x xVar) {
            return null;
        }

        public RemoteViews c(x xVar) {
            return null;
        }

        public RemoteViews d(x xVar) {
            return null;
        }
    }

    public static Bundle a(Notification notification) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            return notification.extras;
        }
        if (i2 >= 16) {
            return a0.a(notification);
        }
        return null;
    }
}
