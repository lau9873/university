package p070c.p115g.p125b.p126a;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import org.json.JSONObject;
import p070c.p115g.p128c.p129a.p130a.C1423a;
import p070c.p115g.p128c.p129a.p130a.C1429f;

/* renamed from: c.g.b.a.c */
/* loaded from: classes.dex */
public class C1418c {

    /* renamed from: a */
    public static InterfaceC1416a f6033a;

    /* renamed from: b */
    public static ArrayList<InterfaceC1416a> f6034b;

    /* renamed from: c */
    public static int f6035c;

    /* renamed from: d */
    public static C1418c f6036d;

    /* renamed from: c.g.b.a.c$a */
    /* loaded from: classes.dex */
    public static class C1419a implements InterfaceC1416a {

        /* renamed from: a */
        public final /* synthetic */ int f6037a;

        public C1419a(int i) {
            this.f6037a = i;
        }

        @Override // p070c.p115g.p125b.p126a.InterfaceC1416a
        public void notifyAnswer(int i, int i2, JSONObject jSONObject) {
            C1423a.m4478a("NOLISTENER", 4, "There is no listener for this id " + this.f6037a + " call = " + i2 + " ");
        }
    }

    /* renamed from: c.g.b.a.c$b */
    /* loaded from: classes.dex */
    public class C1420b implements InterfaceC1416a {

        /* renamed from: a */
        public final /* synthetic */ Integer f6038a;

        public C1420b(C1418c c1418c, Integer num) {
            this.f6038a = num;
        }

        @Override // p070c.p115g.p125b.p126a.InterfaceC1416a
        public void notifyAnswer(int i, int i2, JSONObject jSONObject) {
            C1418c.m4500a().notifyAnswer(i, this.f6038a.intValue(), jSONObject);
        }
    }

    /* renamed from: a */
    public static int m4495a(InterfaceC1416a interfaceC1416a) {
        m4494b().add(interfaceC1416a);
        return m4494b().size() - 1;
    }

    /* renamed from: a */
    public static InterfaceC1416a m4500a() {
        return f6033a;
    }

    /* renamed from: a */
    public static InterfaceC1416a m4499a(int i) {
        return (i < 0 || i >= m4494b().size()) ? new C1419a(i) : m4494b().get(i);
    }

    /* renamed from: b */
    public static ArrayList<InterfaceC1416a> m4494b() {
        if (f6034b == null) {
            m4491d();
        }
        return f6034b;
    }

    /* renamed from: b */
    public static void m4493b(InterfaceC1416a interfaceC1416a) {
        f6033a = interfaceC1416a;
    }

    /* renamed from: c */
    public static C1418c m4492c() {
        C1418c c1418c;
        synchronized ("sync") {
            if (f6036d == null) {
                f6036d = new C1418c();
            }
            c1418c = f6036d;
        }
        return c1418c;
    }

    /* renamed from: d */
    public static void m4491d() {
        f6034b = new ArrayList<>();
    }

    /* renamed from: a */
    public final void m4498a(Context context) {
        if (f6035c <= 0) {
            f6035c = 0;
            m4491d();
        }
    }

    /* renamed from: a */
    public synchronized void m4497a(Context context, Intent intent) {
        if (intent.getComponent().getClassName().equals(null)) {
            return;
        }
        if (intent.getComponent().getClassName().equals("com.spirtech.surpass.api.RequestReceiver")) {
            C1429f.m4444b(context);
            if ("SPA_TO_PTOA".equals(intent.getAction())) {
                m4496a(context, intent.getStringExtra("data"), Integer.valueOf(intent.getIntExtra("REQ_ID", 1)), Integer.valueOf(intent.getIntExtra("LISTENER_ID", -1)).intValue(), Integer.valueOf(intent.getIntExtra("result", -1)).intValue());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d A[Catch: Exception -> 0x0100, TryCatch #0 {Exception -> 0x0100, blocks: (B:5:0x0008, B:7:0x000e, B:9:0x0015, B:11:0x001d, B:13:0x0023, B:68:0x00fc, B:14:0x0036, B:17:0x0040, B:19:0x0046, B:20:0x0053, B:23:0x005e, B:25:0x0064, B:26:0x0067, B:28:0x0071, B:29:0x0074, B:31:0x007a, B:33:0x0080, B:34:0x0083, B:36:0x008b, B:38:0x0091, B:40:0x0099, B:42:0x00a1, B:44:0x00a9, B:46:0x00b1, B:53:0x00c1, B:55:0x00c7, B:56:0x00ca, B:59:0x00d5, B:61:0x00de, B:63:0x00e4, B:65:0x00ed, B:67:0x00f7), top: B:75:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036 A[Catch: Exception -> 0x0100, TryCatch #0 {Exception -> 0x0100, blocks: (B:5:0x0008, B:7:0x000e, B:9:0x0015, B:11:0x001d, B:13:0x0023, B:68:0x00fc, B:14:0x0036, B:17:0x0040, B:19:0x0046, B:20:0x0053, B:23:0x005e, B:25:0x0064, B:26:0x0067, B:28:0x0071, B:29:0x0074, B:31:0x007a, B:33:0x0080, B:34:0x0083, B:36:0x008b, B:38:0x0091, B:40:0x0099, B:42:0x00a1, B:44:0x00a9, B:46:0x00b1, B:53:0x00c1, B:55:0x00c7, B:56:0x00ca, B:59:0x00d5, B:61:0x00de, B:63:0x00e4, B:65:0x00ed, B:67:0x00f7), top: B:75:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d4  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m4496a(android.content.Context r10, java.lang.String r11, java.lang.Integer r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p070c.p115g.p125b.p126a.C1418c.m4496a(android.content.Context, java.lang.String, java.lang.Integer, int, int):void");
    }
}
