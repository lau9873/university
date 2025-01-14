package p000a.p006b.p030g.p031a;

import android.app.RemoteInput;
import android.os.Bundle;
import java.util.Set;

/* renamed from: a.b.g.a.d0 */
/* loaded from: classes.dex */
public final class RemoteInput {

    /* renamed from: a */
    public final String f1090a;

    /* renamed from: b */
    public final CharSequence f1091b;

    /* renamed from: c */
    public final CharSequence[] f1092c;

    /* renamed from: d */
    public final boolean f1093d;

    /* renamed from: e */
    public final Bundle f1094e;

    /* renamed from: f */
    public final Set<String> f1095f;

    /* renamed from: a */
    public boolean m10361a() {
        return this.f1093d;
    }

    /* renamed from: b */
    public Set<String> m10358b() {
        return this.f1095f;
    }

    /* renamed from: c */
    public CharSequence[] m10357c() {
        return this.f1092c;
    }

    /* renamed from: d */
    public Bundle m10356d() {
        return this.f1094e;
    }

    /* renamed from: e */
    public CharSequence m10355e() {
        return this.f1091b;
    }

    /* renamed from: f */
    public String m10354f() {
        return this.f1090a;
    }

    /* renamed from: g */
    public boolean m10353g() {
        return (m10361a() || (m10357c() != null && m10357c().length != 0) || m10358b() == null || m10358b().isEmpty()) ? false : true;
    }

    /* renamed from: a */
    public static android.app.RemoteInput[] m10359a(RemoteInput[] remoteInputArr) {
        if (remoteInputArr == null) {
            return null;
        }
        android.app.RemoteInput[] remoteInputArr2 = new android.app.RemoteInput[remoteInputArr.length];
        for (int i = 0; i < remoteInputArr.length; i++) {
            remoteInputArr2[i] = m10360a(remoteInputArr[i]);
        }
        return remoteInputArr2;
    }

    /* renamed from: a */
    public static android.app.RemoteInput m10360a(RemoteInput remoteInput) {
        return new RemoteInput.Builder(remoteInput.m10354f()).setLabel(remoteInput.m10355e()).setChoices(remoteInput.m10357c()).setAllowFreeFormInput(remoteInput.m10361a()).addExtras(remoteInput.m10356d()).build();
    }
}
