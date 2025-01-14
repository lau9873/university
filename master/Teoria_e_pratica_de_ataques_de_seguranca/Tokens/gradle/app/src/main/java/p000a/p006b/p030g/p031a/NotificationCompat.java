package p000a.p006b.p030g.p031a;

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

/* renamed from: a.b.g.a.y */
/* loaded from: classes.dex */
public class NotificationCompat {

    /* compiled from: NotificationCompat.java */
    /* renamed from: a.b.g.a.y$a */
    /* loaded from: classes.dex */
    public static class C0186a {

        /* renamed from: a */
        public final Bundle f1280a;

        /* renamed from: b */
        public final RemoteInput[] f1281b;

        /* renamed from: c */
        public final RemoteInput[] f1282c;

        /* renamed from: d */
        public boolean f1283d;

        /* renamed from: e */
        public boolean f1284e;

        /* renamed from: f */
        public final int f1285f;

        /* renamed from: g */
        public int f1286g;

        /* renamed from: h */
        public CharSequence f1287h;

        /* renamed from: i */
        public PendingIntent f1288i;

        /* compiled from: NotificationCompat.java */
        /* renamed from: a.b.g.a.y$a$a */
        /* loaded from: classes.dex */
        public static final class C0187a {

            /* renamed from: a */
            public final int f1289a;

            /* renamed from: b */
            public final CharSequence f1290b;

            /* renamed from: c */
            public final PendingIntent f1291c;

            /* renamed from: d */
            public boolean f1292d;

            /* renamed from: e */
            public final Bundle f1293e;

            /* renamed from: f */
            public ArrayList<RemoteInput> f1294f;

            /* renamed from: g */
            public int f1295g;

            /* renamed from: h */
            public boolean f1296h;

            public C0187a(int i, CharSequence charSequence, PendingIntent pendingIntent) {
                this(i, charSequence, pendingIntent, new Bundle(), null, true, 0, true);
            }

            /* renamed from: a */
            public C0186a m10059a() {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<RemoteInput> arrayList3 = this.f1294f;
                if (arrayList3 != null) {
                    Iterator<RemoteInput> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        RemoteInput next = it.next();
                        if (next.m10353g()) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                RemoteInput[] remoteInputArr = arrayList.isEmpty() ? null : (RemoteInput[]) arrayList.toArray(new RemoteInput[arrayList.size()]);
                return new C0186a(this.f1289a, this.f1290b, this.f1291c, this.f1293e, arrayList2.isEmpty() ? null : (RemoteInput[]) arrayList2.toArray(new RemoteInput[arrayList2.size()]), remoteInputArr, this.f1292d, this.f1295g, this.f1296h);
            }

            public C0187a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, boolean z, int i2, boolean z2) {
                this.f1292d = true;
                this.f1296h = true;
                this.f1289a = i;
                this.f1290b = C0189c.m10037d(charSequence);
                this.f1291c = pendingIntent;
                this.f1293e = bundle;
                this.f1294f = remoteInputArr == null ? null : new ArrayList<>(Arrays.asList(remoteInputArr));
                this.f1292d = z;
                this.f1295g = i2;
                this.f1296h = z2;
            }
        }

        public C0186a(int i, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, RemoteInput[] remoteInputArr, RemoteInput[] remoteInputArr2, boolean z, int i2, boolean z2) {
            this.f1284e = true;
            this.f1286g = i;
            this.f1287h = C0189c.m10037d(charSequence);
            this.f1288i = pendingIntent;
            this.f1280a = bundle == null ? new Bundle() : bundle;
            this.f1281b = remoteInputArr;
            this.f1282c = remoteInputArr2;
            this.f1283d = z;
            this.f1285f = i2;
            this.f1284e = z2;
        }

        /* renamed from: a */
        public PendingIntent m10068a() {
            return this.f1288i;
        }

        /* renamed from: b */
        public boolean m10067b() {
            return this.f1283d;
        }

        /* renamed from: c */
        public RemoteInput[] m10066c() {
            return this.f1282c;
        }

        /* renamed from: d */
        public Bundle m10065d() {
            return this.f1280a;
        }

        /* renamed from: e */
        public int m10064e() {
            return this.f1286g;
        }

        /* renamed from: f */
        public RemoteInput[] m10063f() {
            return this.f1281b;
        }

        /* renamed from: g */
        public int m10062g() {
            return this.f1285f;
        }

        /* renamed from: h */
        public boolean m10061h() {
            return this.f1284e;
        }

        /* renamed from: i */
        public CharSequence m10060i() {
            return this.f1287h;
        }
    }

    /* compiled from: NotificationCompat.java */
    /* renamed from: a.b.g.a.y$b */
    /* loaded from: classes.dex */
    public static class C0188b extends AbstractC0190d {

        /* renamed from: e */
        public CharSequence f1297e;

        /* renamed from: a */
        public C0188b m10058a(CharSequence charSequence) {
            this.f1297e = C0189c.m10037d(charSequence);
            return this;
        }

        @Override // p000a.p006b.p030g.p031a.NotificationCompat.AbstractC0190d
        /* renamed from: a */
        public void mo10036a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            if (Build.VERSION.SDK_INT >= 16) {
                Notification.BigTextStyle bigText = new Notification.BigTextStyle(notificationBuilderWithBuilderAccessor.mo10030a()).setBigContentTitle(this.f1340b).bigText(this.f1297e);
                if (this.f1342d) {
                    bigText.setSummaryText(this.f1341c);
                }
            }
        }
    }

    /* compiled from: NotificationCompat.java */
    /* renamed from: a.b.g.a.y$c */
    /* loaded from: classes.dex */
    public static class C0189c {

        /* renamed from: A */
        public String f1298A;

        /* renamed from: B */
        public Bundle f1299B;

        /* renamed from: C */
        public int f1300C;

        /* renamed from: D */
        public int f1301D;

        /* renamed from: E */
        public Notification f1302E;

        /* renamed from: F */
        public RemoteViews f1303F;

        /* renamed from: G */
        public RemoteViews f1304G;

        /* renamed from: H */
        public RemoteViews f1305H;

        /* renamed from: I */
        public String f1306I;

        /* renamed from: J */
        public int f1307J;

        /* renamed from: K */
        public String f1308K;

        /* renamed from: L */
        public long f1309L;

        /* renamed from: M */
        public int f1310M;

        /* renamed from: N */
        public Notification f1311N;
        @Deprecated

        /* renamed from: O */
        public ArrayList<String> f1312O;

        /* renamed from: a */
        public Context f1313a;

        /* renamed from: b */
        public ArrayList<C0186a> f1314b;

        /* renamed from: c */
        public ArrayList<C0186a> f1315c;

        /* renamed from: d */
        public CharSequence f1316d;

        /* renamed from: e */
        public CharSequence f1317e;

        /* renamed from: f */
        public PendingIntent f1318f;

        /* renamed from: g */
        public PendingIntent f1319g;

        /* renamed from: h */
        public RemoteViews f1320h;

        /* renamed from: i */
        public Bitmap f1321i;

        /* renamed from: j */
        public CharSequence f1322j;

        /* renamed from: k */
        public int f1323k;

        /* renamed from: l */
        public int f1324l;

        /* renamed from: m */
        public boolean f1325m;

        /* renamed from: n */
        public boolean f1326n;

        /* renamed from: o */
        public AbstractC0190d f1327o;

        /* renamed from: p */
        public CharSequence f1328p;

        /* renamed from: q */
        public CharSequence[] f1329q;

        /* renamed from: r */
        public int f1330r;

        /* renamed from: s */
        public int f1331s;

        /* renamed from: t */
        public boolean f1332t;

        /* renamed from: u */
        public String f1333u;

        /* renamed from: v */
        public boolean f1334v;

        /* renamed from: w */
        public String f1335w;

        /* renamed from: x */
        public boolean f1336x;

        /* renamed from: y */
        public boolean f1337y;

        /* renamed from: z */
        public boolean f1338z;

        public C0189c(Context context, String str) {
            this.f1314b = new ArrayList<>();
            this.f1315c = new ArrayList<>();
            this.f1325m = true;
            this.f1336x = false;
            this.f1300C = 0;
            this.f1301D = 0;
            this.f1307J = 0;
            this.f1310M = 0;
            this.f1311N = new Notification();
            this.f1313a = context;
            this.f1306I = str;
            this.f1311N.when = System.currentTimeMillis();
            this.f1311N.audioStreamType = -1;
            this.f1324l = 0;
            this.f1312O = new ArrayList<>();
        }

        /* renamed from: a */
        public C0189c m10054a(long j) {
            this.f1311N.when = j;
            return this;
        }

        /* renamed from: b */
        public C0189c m10044b(CharSequence charSequence) {
            this.f1316d = m10037d(charSequence);
            return this;
        }

        /* renamed from: c */
        public C0189c m10041c(int i) {
            this.f1311N.icon = i;
            return this;
        }

        /* renamed from: d */
        public C0189c m10038d(int i) {
            this.f1301D = i;
            return this;
        }

        /* renamed from: d */
        public static CharSequence m10037d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        /* renamed from: a */
        public C0189c m10050a(CharSequence charSequence) {
            this.f1317e = m10037d(charSequence);
            return this;
        }

        /* renamed from: b */
        public C0189c m10042b(boolean z) {
            this.f1336x = z;
            return this;
        }

        /* renamed from: c */
        public C0189c m10040c(CharSequence charSequence) {
            this.f1311N.tickerText = m10037d(charSequence);
            return this;
        }

        /* renamed from: a */
        public C0189c m10051a(PendingIntent pendingIntent) {
            this.f1318f = pendingIntent;
            return this;
        }

        /* renamed from: b */
        public C0189c m10045b(int i) {
            this.f1324l = i;
            return this;
        }

        /* renamed from: c */
        public C0189c m10039c(String str) {
            this.f1333u = str;
            return this;
        }

        /* renamed from: a */
        public C0189c m10047a(long[] jArr) {
            this.f1311N.vibrate = jArr;
            return this;
        }

        /* renamed from: b */
        public Bundle m10046b() {
            if (this.f1299B == null) {
                this.f1299B = new Bundle();
            }
            return this.f1299B;
        }

        /* renamed from: a */
        public C0189c m10048a(boolean z) {
            m10055a(16, z);
            return this;
        }

        /* renamed from: a */
        public C0189c m10049a(String str) {
            this.f1298A = str;
            return this;
        }

        /* renamed from: a */
        public final void m10055a(int i, boolean z) {
            if (z) {
                Notification notification = this.f1311N;
                notification.flags = i | notification.flags;
                return;
            }
            Notification notification2 = this.f1311N;
            notification2.flags = (~i) & notification2.flags;
        }

        /* renamed from: b */
        public C0189c m10043b(String str) {
            this.f1306I = str;
            return this;
        }

        /* renamed from: a */
        public C0189c m10053a(C0186a c0186a) {
            this.f1314b.add(c0186a);
            return this;
        }

        /* renamed from: a */
        public C0189c m10052a(AbstractC0190d abstractC0190d) {
            if (this.f1327o != abstractC0190d) {
                this.f1327o = abstractC0190d;
                AbstractC0190d abstractC0190d2 = this.f1327o;
                if (abstractC0190d2 != null) {
                    abstractC0190d2.m10035a(this);
                }
            }
            return this;
        }

        /* renamed from: a */
        public C0189c m10056a(int i) {
            this.f1300C = i;
            return this;
        }

        /* renamed from: a */
        public Notification m10057a() {
            return new NotificationCompatBuilder(this).m10027b();
        }

        @Deprecated
        public C0189c(Context context) {
            this(context, null);
        }
    }

    /* compiled from: NotificationCompat.java */
    /* renamed from: a.b.g.a.y$d */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0190d {

        /* renamed from: a */
        public C0189c f1339a;

        /* renamed from: b */
        public CharSequence f1340b;

        /* renamed from: c */
        public CharSequence f1341c;

        /* renamed from: d */
        public boolean f1342d = false;

        /* renamed from: a */
        public abstract void mo10036a(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor);

        /* renamed from: a */
        public void m10035a(C0189c c0189c) {
            if (this.f1339a != c0189c) {
                this.f1339a = c0189c;
                C0189c c0189c2 = this.f1339a;
                if (c0189c2 != null) {
                    c0189c2.m10052a(this);
                }
            }
        }

        /* renamed from: a */
        public void m10034a(Bundle bundle) {
        }

        /* renamed from: b */
        public RemoteViews m10033b(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        /* renamed from: c */
        public RemoteViews m10032c(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }

        /* renamed from: d */
        public RemoteViews m10031d(NotificationBuilderWithBuilderAccessor notificationBuilderWithBuilderAccessor) {
            return null;
        }
    }

    /* renamed from: a */
    public static Bundle m10069a(Notification notification) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 19) {
            return notification.extras;
        }
        if (i >= 16) {
            return NotificationCompatJellybean.m10407a(notification);
        }
        return null;
    }
}
