package c.b.a.d;

import android.content.Context;
import java.io.File;
import java.util.Set;
/* compiled from: LogFileManager.java */
/* loaded from: classes.dex */
public class u {

    /* renamed from: d  reason: collision with root package name */
    public static final c f3137d = new c();

    /* renamed from: a  reason: collision with root package name */
    public final Context f3138a;

    /* renamed from: b  reason: collision with root package name */
    public final b f3139b;

    /* renamed from: c  reason: collision with root package name */
    public s f3140c;

    /* compiled from: LogFileManager.java */
    /* loaded from: classes.dex */
    public interface b {
        File a();
    }

    /* compiled from: LogFileManager.java */
    /* loaded from: classes.dex */
    public static final class c implements s {
        public c() {
        }

        @Override // c.b.a.d.s
        public void a() {
        }

        @Override // c.b.a.d.s
        public void a(long j, String str) {
        }

        @Override // c.b.a.d.s
        public c.b.a.d.b b() {
            return null;
        }

        @Override // c.b.a.d.s
        public void c() {
        }
    }

    public u(Context context, b bVar) {
        this(context, bVar, null);
    }

    public void a(long j, String str) {
        this.f3140c.a(j, str);
    }

    public final void b(String str) {
        this.f3140c.a();
        this.f3140c = f3137d;
        if (str == null) {
            return;
        }
        if (!d.a.a.a.m.b.i.a(this.f3138a, "com.crashlytics.CollectCustomLogs", true)) {
            d.a.a.a.c.h().e("CrashlyticsCore", "Preferences requested no custom logs. Aborting log file creation.");
        } else {
            a(a(str), 65536);
        }
    }

    public u(Context context, b bVar, String str) {
        this.f3138a = context;
        this.f3139b = bVar;
        this.f3140c = f3137d;
        b(str);
    }

    public void a() {
        this.f3140c.c();
    }

    public void a(Set<String> set) {
        File[] listFiles = this.f3139b.a().listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                if (!set.contains(a(file))) {
                    file.delete();
                }
            }
        }
    }

    public void a(File file, int i2) {
        this.f3140c = new c0(file, i2);
    }

    public c.b.a.d.b b() {
        return this.f3140c.b();
    }

    public final File a(String str) {
        return new File(this.f3139b.a(), "crashlytics-userlog-" + str + ".temp");
    }

    public final String a(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".temp");
        return lastIndexOf == -1 ? name : name.substring(20, lastIndexOf);
    }
}
