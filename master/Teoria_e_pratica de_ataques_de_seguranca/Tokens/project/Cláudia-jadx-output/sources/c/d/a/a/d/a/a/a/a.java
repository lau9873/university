package c.d.a.a.d.a.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import c.d.a.a.e.f.c0;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static final Lock f3208c = new ReentrantLock();

    /* renamed from: d  reason: collision with root package name */
    public static a f3209d;

    /* renamed from: a  reason: collision with root package name */
    public final Lock f3210a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    public final SharedPreferences f3211b;

    public a(Context context) {
        this.f3211b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static a a(Context context) {
        c0.a(context);
        f3208c.lock();
        try {
            if (f3209d == null) {
                f3209d = new a(context.getApplicationContext());
            }
            return f3209d;
        } finally {
            f3208c.unlock();
        }
    }

    public static String a(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        return sb.toString();
    }

    public final GoogleSignInAccount a() {
        return a(b("defaultGoogleSignInAccount"));
    }

    public final GoogleSignInAccount a(String str) {
        String b2;
        if (!TextUtils.isEmpty(str) && (b2 = b(a("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.a(b2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final String b(String str) {
        this.f3210a.lock();
        try {
            return this.f3211b.getString(str, null);
        } finally {
            this.f3210a.unlock();
        }
    }
}
