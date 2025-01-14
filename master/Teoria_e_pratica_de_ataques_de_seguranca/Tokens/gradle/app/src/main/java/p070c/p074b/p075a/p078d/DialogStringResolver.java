package p070c.p074b.p075a.p078d;

import android.content.Context;
import p136d.p137a.p138a.p139a.p140m.p142b.CommonUtils;
import p136d.p137a.p138a.p139a.p140m.p148g.PromptSettingsData;

/* renamed from: c.b.a.d.r */
/* loaded from: classes.dex */
public class DialogStringResolver {

    /* renamed from: a */
    public final Context f4970a;

    /* renamed from: b */
    public final PromptSettingsData f4971b;

    public DialogStringResolver(Context context, PromptSettingsData promptSettingsData) {
        this.f4970a = context;
        this.f4971b = promptSettingsData;
    }

    /* renamed from: a */
    public String m5739a() {
        return m5737a("com.crashlytics.CrashSubmissionAlwaysSendTitle", this.f4971b.f6645g);
    }

    /* renamed from: b */
    public String m5736b() {
        return m5737a("com.crashlytics.CrashSubmissionCancelTitle", this.f4971b.f6643e);
    }

    /* renamed from: c */
    public String m5734c() {
        return m5737a("com.crashlytics.CrashSubmissionPromptMessage", this.f4971b.f6640b);
    }

    /* renamed from: d */
    public String m5733d() {
        return m5737a("com.crashlytics.CrashSubmissionSendTitle", this.f4971b.f6641c);
    }

    /* renamed from: e */
    public String m5732e() {
        return m5737a("com.crashlytics.CrashSubmissionPromptTitle", this.f4971b.f6639a);
    }

    /* renamed from: a */
    public final String m5737a(String str, String str2) {
        return m5735b(CommonUtils.m4087b(this.f4970a, str), str2);
    }

    /* renamed from: b */
    public final String m5735b(String str, String str2) {
        return m5738a(str) ? str2 : str;
    }

    /* renamed from: a */
    public final boolean m5738a(String str) {
        return str == null || str.length() == 0;
    }
}
