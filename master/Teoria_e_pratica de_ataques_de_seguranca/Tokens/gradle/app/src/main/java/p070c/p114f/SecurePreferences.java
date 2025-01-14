package p070c.p114f;

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
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import p070c.p131h.p132a.p133a.AesCbcWithIntegrity;

/* renamed from: c.f.a */
/* loaded from: classes.dex */
public class SecurePreferences implements SharedPreferences {

    /* renamed from: d */
    public static boolean f5965d = false;

    /* renamed from: e */
    public static final String f5966e = SecurePreferences.class.getName();

    /* renamed from: a */
    public SharedPreferences f5967a;

    /* renamed from: b */
    public AesCbcWithIntegrity.C1434c f5968b;

    /* renamed from: c */
    public String f5969c;

    /* compiled from: SecurePreferences.java */
    /* renamed from: c.f.a$b */
    /* loaded from: classes.dex */
    public final class SharedPreferences$EditorC1361b implements SharedPreferences.Editor {

        /* renamed from: a */
        public SharedPreferences.Editor f5970a;

        @Override // android.content.SharedPreferences.Editor
        @TargetApi(9)
        public void apply() {
            if (Build.VERSION.SDK_INT >= 9) {
                this.f5970a.apply();
            } else {
                commit();
            }
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor clear() {
            this.f5970a.clear();
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public boolean commit() {
            return this.f5970a.commit();
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            this.f5970a.putString(SecurePreferences.m4653c(str), SecurePreferences.this.m4654b(Boolean.toString(z)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putFloat(String str, float f) {
            this.f5970a.putString(SecurePreferences.m4653c(str), SecurePreferences.this.m4654b(Float.toString(f)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putInt(String str, int i) {
            this.f5970a.putString(SecurePreferences.m4653c(str), SecurePreferences.this.m4654b(Integer.toString(i)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putLong(String str, long j) {
            this.f5970a.putString(SecurePreferences.m4653c(str), SecurePreferences.this.m4654b(Long.toString(j)));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor putString(String str, String str2) {
            this.f5970a.putString(SecurePreferences.m4653c(str), SecurePreferences.this.m4654b(str2));
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        @TargetApi(11)
        public SharedPreferences.Editor putStringSet(String str, Set<String> set) {
            HashSet hashSet = new HashSet(set.size());
            for (String str2 : set) {
                hashSet.add(SecurePreferences.this.m4654b(str2));
            }
            this.f5970a.putStringSet(SecurePreferences.m4653c(str), hashSet);
            return this;
        }

        @Override // android.content.SharedPreferences.Editor
        public SharedPreferences.Editor remove(String str) {
            this.f5970a.remove(SecurePreferences.m4653c(str));
            return this;
        }

        public SharedPreferences$EditorC1361b() {
            this.f5970a = SecurePreferences.this.f5967a.edit();
        }
    }

    public SecurePreferences(Context context, String str, String str2, String str3, int i) {
        this(context, null, str, str2, str3, i);
    }

    @SuppressLint({"HardwareIds"})
    /* renamed from: b */
    public static String m4655b(Context context) {
        try {
            String str = (String) Build.class.getField("SERIAL").get(null);
            return TextUtils.isEmpty(str) ? Settings.Secure.getString(context.getContentResolver(), "android_id") : str;
        } catch (Exception unused) {
            return Settings.Secure.getString(context.getContentResolver(), "android_id");
        }
    }

    /* renamed from: c */
    public static String m4653c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] bytes = str.getBytes("UTF-8");
            messageDigest.update(bytes, 0, bytes.length);
            return Base64.encodeToString(messageDigest.digest(), 2);
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            if (f5965d) {
                Log.w(f5966e, "Problem generating hash", e);
                return null;
            }
            return null;
        }
    }

    @Override // android.content.SharedPreferences
    public boolean contains(String str) {
        return this.f5967a.contains(m4653c(str));
    }

    @Override // android.content.SharedPreferences
    public Map<String, String> getAll() {
        Map<String, ?> all = this.f5967a.getAll();
        HashMap hashMap = new HashMap(all.size());
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            try {
                Object value = entry.getValue();
                if (value != null && !value.equals(this.f5968b.toString())) {
                    hashMap.put(entry.getKey(), m4656a(value.toString()));
                }
            } catch (Exception e) {
                if (f5965d) {
                    Log.w(f5966e, "error during getAll", e);
                }
                hashMap.put(entry.getKey(), entry.getValue().toString());
            }
        }
        return hashMap;
    }

    @Override // android.content.SharedPreferences
    public boolean getBoolean(String str, boolean z) {
        String string = this.f5967a.getString(m4653c(str), null);
        if (string == null) {
            return z;
        }
        try {
            return Boolean.parseBoolean(m4656a(string));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    @Override // android.content.SharedPreferences
    public float getFloat(String str, float f) {
        String string = this.f5967a.getString(m4653c(str), null);
        if (string == null) {
            return f;
        }
        try {
            return Float.parseFloat(m4656a(string));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    @Override // android.content.SharedPreferences
    public int getInt(String str, int i) {
        String string = this.f5967a.getString(m4653c(str), null);
        if (string == null) {
            return i;
        }
        try {
            return Integer.parseInt(m4656a(string));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    @Override // android.content.SharedPreferences
    public long getLong(String str, long j) {
        String string = this.f5967a.getString(m4653c(str), null);
        if (string == null) {
            return j;
        }
        try {
            return Long.parseLong(m4656a(string));
        } catch (NumberFormatException e) {
            throw new ClassCastException(e.getMessage());
        }
    }

    @Override // android.content.SharedPreferences
    public String getString(String str, String str2) {
        String string = this.f5967a.getString(m4653c(str), null);
        String m4656a = m4656a(string);
        return (string == null || m4656a == null) ? str2 : m4656a;
    }

    @Override // android.content.SharedPreferences
    @TargetApi(11)
    public Set<String> getStringSet(String str, Set<String> set) {
        Set<String> stringSet = this.f5967a.getStringSet(m4653c(str), null);
        if (stringSet == null) {
            return set;
        }
        HashSet hashSet = new HashSet(stringSet.size());
        for (String str2 : stringSet) {
            hashSet.add(m4656a(str2));
        }
        return hashSet;
    }

    @Override // android.content.SharedPreferences
    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f5967a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    @Override // android.content.SharedPreferences
    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f5967a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public SecurePreferences(Context context, AesCbcWithIntegrity.C1434c c1434c, String str, String str2, String str3, int i) {
        if (this.f5967a == null) {
            this.f5967a = m4659a(context, str3);
        }
        this.f5969c = str2;
        if (c1434c != null) {
            this.f5968b = c1434c;
        } else if (TextUtils.isEmpty(str)) {
            try {
                String m4660a = m4660a(context, i);
                String string = this.f5967a.getString(m4660a, null);
                if (string == null) {
                    this.f5968b = AesCbcWithIntegrity.m4424c();
                    if (!this.f5967a.edit().putString(m4660a, this.f5968b.toString()).commit()) {
                        Log.w(f5966e, "Key not committed to prefs");
                    }
                } else {
                    this.f5968b = AesCbcWithIntegrity.m4434a(string);
                }
                if (this.f5968b != null) {
                    return;
                }
                throw new GeneralSecurityException("Problem generating Key");
            } catch (GeneralSecurityException e) {
                if (f5965d) {
                    String str4 = f5966e;
                    Log.e(str4, "Error init:" + e.getMessage());
                }
                throw new IllegalStateException(e);
            }
        } else {
            try {
                this.f5968b = AesCbcWithIntegrity.m4431a(str, m4661a(context).getBytes(), i);
                if (this.f5968b != null) {
                    return;
                }
                throw new GeneralSecurityException("Problem generating Key From Password");
            } catch (GeneralSecurityException e2) {
                if (f5965d) {
                    String str5 = f5966e;
                    Log.e(str5, "Error init using user password:" + e2.getMessage());
                }
                throw new IllegalStateException(e2);
            }
        }
    }

    @Override // android.content.SharedPreferences
    public SharedPreferences$EditorC1361b edit() {
        return new SharedPreferences$EditorC1361b();
    }

    /* renamed from: a */
    public final SharedPreferences m4659a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return PreferenceManager.getDefaultSharedPreferences(context);
        }
        return context.getSharedPreferences(str, 0);
    }

    /* renamed from: a */
    public final String m4660a(Context context, int i) {
        return m4653c(AesCbcWithIntegrity.m4431a(context.getPackageName(), m4661a(context).getBytes(), i).toString());
    }

    /* renamed from: b */
    public final String m4654b(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return AesCbcWithIntegrity.m4433a(str, this.f5968b).toString();
        } catch (UnsupportedEncodingException e) {
            if (f5965d) {
                Log.w(f5966e, "encrypt", e);
            }
            return null;
        } catch (GeneralSecurityException e2) {
            if (f5965d) {
                Log.w(f5966e, "encrypt", e2);
            }
            return null;
        }
    }

    /* renamed from: a */
    public final String m4661a(Context context) {
        if (TextUtils.isEmpty(this.f5969c)) {
            return m4655b(context);
        }
        return this.f5969c;
    }

    /* renamed from: a */
    public final String m4656a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            return AesCbcWithIntegrity.m4425b(new AesCbcWithIntegrity.C1430a(str), this.f5968b);
        } catch (UnsupportedEncodingException | GeneralSecurityException e) {
            if (f5965d) {
                Log.w(f5966e, "decrypt", e);
                return null;
            }
            return null;
        }
    }
}
