package c.g.b.a;

import android.content.Context;
import android.content.Intent;
import c.g.c.a.a.f;
import java.util.ArrayList;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static c.g.b.a.a f4004a;

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<c.g.b.a.a> f4005b;

    /* renamed from: c  reason: collision with root package name */
    public static int f4006c;

    /* renamed from: d  reason: collision with root package name */
    public static c f4007d;

    /* loaded from: classes.dex */
    public static class a implements c.g.b.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f4008a;

        public a(int i2) {
            this.f4008a = i2;
        }

        @Override // c.g.b.a.a
        public void notifyAnswer(int i2, int i3, JSONObject jSONObject) {
            c.g.c.a.a.a.a("NOLISTENER", 4, "There is no listener for this id " + this.f4008a + " call = " + i3 + " ");
        }
    }

    /* loaded from: classes.dex */
    public class b implements c.g.b.a.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Integer f4009a;

        public b(c cVar, Integer num) {
            this.f4009a = num;
        }

        @Override // c.g.b.a.a
        public void notifyAnswer(int i2, int i3, JSONObject jSONObject) {
            c.a().notifyAnswer(i2, this.f4009a.intValue(), jSONObject);
        }
    }

    public static int a(c.g.b.a.a aVar) {
        b().add(aVar);
        return b().size() - 1;
    }

    public static c.g.b.a.a a() {
        return f4004a;
    }

    public static c.g.b.a.a a(int i2) {
        return (i2 < 0 || i2 >= b().size()) ? new a(i2) : b().get(i2);
    }

    public static ArrayList<c.g.b.a.a> b() {
        if (f4005b == null) {
            d();
        }
        return f4005b;
    }

    public static void b(c.g.b.a.a aVar) {
        f4004a = aVar;
    }

    public static c c() {
        c cVar;
        synchronized ("sync") {
            if (f4007d == null) {
                f4007d = new c();
            }
            cVar = f4007d;
        }
        return cVar;
    }

    public static void d() {
        f4005b = new ArrayList<>();
    }

    public final void a(Context context) {
        if (f4006c <= 0) {
            f4006c = 0;
            d();
        }
    }

    public synchronized void a(Context context, Intent intent) {
        if (intent.getComponent().getClassName().equals(null)) {
            return;
        }
        if (intent.getComponent().getClassName().equals("com.spirtech.surpass.api.RequestReceiver")) {
            f.b(context);
            if ("SPA_TO_PTOA".equals(intent.getAction())) {
                a(context, intent.getStringExtra("data"), Integer.valueOf(intent.getIntExtra("REQ_ID", 1)), Integer.valueOf(intent.getIntExtra("LISTENER_ID", -1)).intValue(), Integer.valueOf(intent.getIntExtra("result", -1)).intValue());
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d A[Catch: Exception -> 0x0100, TryCatch #0 {Exception -> 0x0100, blocks: (B:5:0x0008, B:7:0x000e, B:9:0x0015, B:11:0x001d, B:13:0x0023, B:68:0x00fc, B:14:0x0036, B:17:0x0040, B:19:0x0046, B:20:0x0053, B:23:0x005e, B:25:0x0064, B:26:0x0067, B:28:0x0071, B:29:0x0074, B:31:0x007a, B:33:0x0080, B:34:0x0083, B:36:0x008b, B:38:0x0091, B:40:0x0099, B:42:0x00a1, B:44:0x00a9, B:46:0x00b1, B:53:0x00c1, B:55:0x00c7, B:56:0x00ca, B:59:0x00d5, B:61:0x00de, B:63:0x00e4, B:65:0x00ed, B:67:0x00f7), top: B:75:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036 A[Catch: Exception -> 0x0100, TryCatch #0 {Exception -> 0x0100, blocks: (B:5:0x0008, B:7:0x000e, B:9:0x0015, B:11:0x001d, B:13:0x0023, B:68:0x00fc, B:14:0x0036, B:17:0x0040, B:19:0x0046, B:20:0x0053, B:23:0x005e, B:25:0x0064, B:26:0x0067, B:28:0x0071, B:29:0x0074, B:31:0x007a, B:33:0x0080, B:34:0x0083, B:36:0x008b, B:38:0x0091, B:40:0x0099, B:42:0x00a1, B:44:0x00a9, B:46:0x00b1, B:53:0x00c1, B:55:0x00c7, B:56:0x00ca, B:59:0x00d5, B:61:0x00de, B:63:0x00e4, B:65:0x00ed, B:67:0x00f7), top: B:75:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(android.content.Context r10, java.lang.String r11, java.lang.Integer r12, int r13, int r14) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c.g.b.a.c.a(android.content.Context, java.lang.String, java.lang.Integer, int, int):void");
    }
}
