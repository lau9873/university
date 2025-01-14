package c.b.a.d;

import android.content.Context;
/* compiled from: DialogStringResolver.java */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    public final Context f3132a;

    /* renamed from: b  reason: collision with root package name */
    public final d.a.a.a.m.g.p f3133b;

    public r(Context context, d.a.a.a.m.g.p pVar) {
        this.f3132a = context;
        this.f3133b = pVar;
    }

    public String a() {
        return a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.f3133b.f4439g);
    }

    public String b() {
        return a("com.crashlytics.CrashSubmissionCancelTitle", this.f3133b.f4437e);
    }

    public String c() {
        return a("com.crashlytics.CrashSubmissionPromptMessage", this.f3133b.f4434b);
    }

    public String d() {
        return a("com.crashlytics.CrashSubmissionSendTitle", this.f3133b.f4435c);
    }

    public String e() {
        return a("com.crashlytics.CrashSubmissionPromptTitle", this.f3133b.f4433a);
    }

    public final String a(String str, String str2) {
        return b(d.a.a.a.m.b.i.b(this.f3132a, str), str2);
    }

    public final String b(String str, String str2) {
        return a(str) ? str2 : str;
    }

    public final boolean a(String str) {
        return str == null || str.length() == 0;
    }
}
