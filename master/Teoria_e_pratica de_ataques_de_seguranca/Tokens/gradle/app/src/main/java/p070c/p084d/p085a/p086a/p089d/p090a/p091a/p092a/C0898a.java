package p070c.p084d.p085a.p086a.p089d.p090a.p091a.p092a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;

/* renamed from: c.d.a.a.d.a.a.a.a */
/* loaded from: classes.dex */
public final class C0898a {

    /* renamed from: c */
    public static final Lock f5046c = new ReentrantLock();

    /* renamed from: d */
    public static C0898a f5047d;

    /* renamed from: a */
    public final Lock f5048a = new ReentrantLock();

    /* renamed from: b */
    public final SharedPreferences f5049b;

    public C0898a(Context context) {
        this.f5049b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    /* renamed from: a */
    public static C0898a m5650a(Context context) {
        C1049c0.m5294a(context);
        f5046c.lock();
        try {
            if (f5047d == null) {
                f5047d = new C0898a(context.getApplicationContext());
            }
            return f5047d;
        } finally {
            f5046c.unlock();
        }
    }

    /* renamed from: a */
    public static String m5648a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    /* renamed from: a */
    public final GoogleSignInAccount m5651a() {
        return m5649a(m5647b("defaultGoogleSignInAccount"));
    }

    /* renamed from: a */
    public final GoogleSignInAccount m5649a(String str) {
        String m5647b;
        if (!TextUtils.isEmpty(str) && (m5647b = m5647b(m5648a("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.m4390a(m5647b);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    /* renamed from: b */
    public final String m5647b(String str) {
        this.f5048a.lock();
        try {
            return this.f5049b.getString(str, null);
        } finally {
            this.f5048a.unlock();
        }
    }
}
