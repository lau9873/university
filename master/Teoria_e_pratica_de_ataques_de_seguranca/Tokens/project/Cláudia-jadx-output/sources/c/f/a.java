package c.f;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import c.h.a.a.a;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/* compiled from: SecurePreferences.java */
/* loaded from: classes.dex */
public class a implements SharedPreferences {

    /* renamed from: d  reason: collision with root package name */
    public static boolean f3938d = false;

    /* renamed from: e  reason: collision with root package name */
    public static final String f3939e = a.class.getName();

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f3940a;

    /* renamed from: b  reason: collision with root package name */
    public a.c f3941b;

    /* renamed from: c  reason: collision with root package name */
    public String f3942c;

    /* compiled from: SecurePreferences.java */
    /* loaded from: classes.dex */
    public final class b implements SharedPreferences.Editor {

        /* renamed from: a  reason: collision with root package name */
        public SharedPreferences.Editor f3943a;

        @Override // android.content.SharedPreferences.Editor
        @TargetApi(9)
        public void apply() {
            if (Build.VERSION.SDK_INT >= 9) {
                this.f3943a.apply();
            } else {
                commit();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f3943a.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return this.f3943a.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.f3943a.putString(a.c(str), a.this.b(Boolean.toString(z)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f2) {
            this.f3943a.putString(a.c(str), a.this.b(Float.toString(f2)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i2) {
            this.f3943a.putString(a.c(str), a.this.b(Integer.toString(i2)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            this.f3943a.putString(a.c(str), a.this.b(Long.toString(j)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.f3943a.putString(a.c(str), a.this.b(str2));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @TargetApi(11)
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            HashSet hashSet = new HashSet(set.size());
            for (String str2 : set) {
                hashSet.add(a.this.b(str2));
            }
            this.f3943a.putStringSet(a.c(str), hashSet);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.f3943a.remove(a.c(str));
            return this;
        }

        public b() {
            this.f3943a = a.this.f3940a.edit();
        }
    }

    public a(Context context, String str, String str2, String str3, int i2) {
        this(context, null, str, str2, str3, i2);
    }

    @SuppressLint({"HardwareIds"})
    public static String b(Context context) {
        try {
            String str = (String) Build.class.getField("SERIAL").get(null);
            return TextUtils.isEmpty(str) ? Settings.Secure.getString(context.getContentResolver(), "android_id") : str;
        } catch (Exception unused) {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
    }

    public static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = str.getBytes("UTF-8");
            messageDigest.update(bytes, 0, bytes.length);
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e2) {
            if (f3938d) {
                Log.w(f3939e, "Problem generating hash", e2);
                return null;
            }
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f3940a.contains(c(str));
    }

    @Override // android.content.SharedPreferences
    public Map<String, String> getAll() {
        Map<String, ?> all = this.f3940a.getAll();
        HashMap hashMap = new HashMap(all.size());
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            try {
                Object value = entry.getValue();
                if (value != null && !value.equals(this.f3941b.toString())) {
                    hashMap.put(entry.getKey(), a(value.toString()));
                }
            } catch (Exception e2) {
                if (f3938d) {
                    Log.w(f3939e, "error during getAll", e2);
                }
                hashMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        String string = this.f3940a.getString(c(str), null);
        if (string == null) {
            return z;
        }
        try {
            return Boolean.parseBoolean(a(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f2) {
        String string = this.f3940a.getString(c(str), null);
        if (string == null) {
            return f2;
        }
        try {
            return Float.parseFloat(a(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i2) {
        String string = this.f3940a.getString(c(str), null);
        if (string == null) {
            return i2;
        }
        try {
            return Integer.parseInt(a(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        String string = this.f3940a.getString(c(str), null);
        if (string == null) {
            return j;
        }
        try {
            return Long.parseLong(a(string));
        } catch (NumberFormatException e2) {
            throw new ClassCastException(e2.getMessage());
        }
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        String string = this.f3940a.getString(c(str), null);
        String a2 = a(string);
        return (string == null || a2 == null) ? str2 : a2;
    }

    @Override // android.content.SharedPreferences
    @TargetApi(11)
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> stringSet = this.f3940a.getStringSet(c(str), null);
        if (stringSet == null) {
            return set;
        }
        HashSet hashSet = new HashSet(stringSet.size());
        for (String str2 : stringSet) {
            hashSet.add(a(str2));
        }
        return hashSet;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f3940a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f3940a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public a(Context context, a.c cVar, String str, String str2, String str3, int i2) {
        if (this.f3940a == null) {
            this.f3940a = a(context, str3);
        }
        this.f3942c = str2;
        if (cVar != null) {
            this.f3941b = cVar;
        } else if (TextUtils.isEmpty(str)) {
            try {
                String a2 = a(context, i2);
                String string = this.f3940a.getString(a2, null);
                if (string == null) {
                    this.f3941b = c.h.a.a.a.c();
                    if (!this.f3940a.edit().putString(a2, this.f3941b.toString()).commit()) {
                        Log.w(f3939e, "Key not committed to prefs");
                    }
                } else {
                    this.f3941b = c.h.a.a.a.a(string);
                }
                if (this.f3941b != null) {
                    return;
                }
                throw new GeneralSecurityException("Problem generating Key");
            } catch (GeneralSecurityException e2) {
                if (f3938d) {
                    String str4 = f3939e;
                    Log.e(str4, "Error init:" + e2.getMessage());
                }
                throw new IllegalStateException(e2);
            }
        } else {
            try {
                this.f3941b = c.h.a.a.a.a(str, a(context).getBytes(), i2);
                if (this.f3941b != null) {
                    return;
                }
                throw new GeneralSecurityException("Problem generating Key From Password");
            } catch (GeneralSecurityException e3) {
                if (f3938d) {
                    String str5 = f3939e;
                    Log.e(str5, "Error init using user password:" + e3.getMessage());
                }
                throw new IllegalStateException(e3);
            }
        }
    }

    @Override // android.content.SharedPreferences
    public b edit() {
        return new b();
    }

    public final SharedPreferences a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return PreferenceManager.getDefaultSharedPreferences(context);
        }
        return context.getSharedPreferences(str, 0);
    }

    public final String a(Context context, int i2) {
        return c(c.h.a.a.a.a(context.getPackageName(), a(context).getBytes(), i2).toString());
    }

    public final String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return c.h.a.a.a.a(str, this.f3941b).toString();
        } catch (UnsupportedEncodingException e2) {
            if (f3938d) {
                Log.w(f3939e, "encrypt", e2);
            }
            return null;
        } catch (GeneralSecurityException e3) {
            if (f3938d) {
                Log.w(f3939e, "encrypt", e3);
            }
            return null;
        }
    }

    public final String a(Context context) {
        if (TextUtils.isEmpty(this.f3942c)) {
            return b(context);
        }
        return this.f3942c;
    }

    public final String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return c.h.a.a.a.b(new a.C0081a(str), this.f3941b);
        } catch (UnsupportedEncodingException | GeneralSecurityException e2) {
            if (f3938d) {
                Log.w(f3939e, "decrypt", e2);
                return null;
            }
            return null;
        }
    }
}
