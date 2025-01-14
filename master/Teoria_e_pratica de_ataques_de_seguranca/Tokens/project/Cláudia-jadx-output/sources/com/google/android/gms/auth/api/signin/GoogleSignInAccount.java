package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import c.d.a.a.d.a.a.b;
import c.d.a.a.e.f.c0;
import c.d.a.a.e.h.c;
import c.d.a.a.h.a;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class GoogleSignInAccount extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new b();
    public static c.d.a.a.e.h.b o = c.b();

    /* renamed from: a  reason: collision with root package name */
    public int f4054a;

    /* renamed from: b  reason: collision with root package name */
    public String f4055b;

    /* renamed from: c  reason: collision with root package name */
    public String f4056c;

    /* renamed from: d  reason: collision with root package name */
    public String f4057d;

    /* renamed from: e  reason: collision with root package name */
    public String f4058e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f4059f;

    /* renamed from: g  reason: collision with root package name */
    public String f4060g;

    /* renamed from: h  reason: collision with root package name */
    public long f4061h;

    /* renamed from: i  reason: collision with root package name */
    public String f4062i;
    public List<Scope> j;
    public String k;
    public String m;
    public Set<Scope> n = new HashSet();

    public GoogleSignInAccount(int i2, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.f4054a = i2;
        this.f4055b = str;
        this.f4056c = str2;
        this.f4057d = str3;
        this.f4058e = str4;
        this.f4059f = uri;
        this.f4060g = str5;
        this.f4061h = j;
        this.f4062i = str6;
        this.j = list;
        this.k = str7;
        this.m = str8;
    }

    public static GoogleSignInAccount a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl", null);
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            hashSet.add(new Scope(jSONArray.getString(i2)));
        }
        GoogleSignInAccount a2 = a(jSONObject.optString(DatabaseFieldConfigLoader.FIELD_NAME_ID), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        a2.f4060g = jSONObject.optString("serverAuthCode", null);
        return a2;
    }

    public static GoogleSignInAccount a(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        long longValue = (l == null ? Long.valueOf(o.a() / 1000) : l).longValue();
        c0.a(str7);
        c0.a(set);
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, longValue, str7, new ArrayList(set), str5, str6);
    }

    public Account b() {
        String str = this.f4057d;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    public String c() {
        return this.f4058e;
    }

    public String d() {
        return this.f4057d;
    }

    public String e() {
        return this.m;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GoogleSignInAccount) {
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
            return googleSignInAccount.f4062i.equals(this.f4062i) && googleSignInAccount.k().equals(k());
        }
        return false;
    }

    public String f() {
        return this.k;
    }

    public String g() {
        return this.f4055b;
    }

    public String h() {
        return this.f4056c;
    }

    public int hashCode() {
        return ((this.f4062i.hashCode() + 527) * 31) + k().hashCode();
    }

    public Uri i() {
        return this.f4059f;
    }

    public String j() {
        return this.f4060g;
    }

    public final Set<Scope> k() {
        HashSet hashSet = new HashSet(this.j);
        hashSet.addAll(this.n);
        return hashSet;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = c.d.a.a.h.c.a(parcel);
        c.d.a.a.h.c.b(parcel, 1, this.f4054a);
        c.d.a.a.h.c.a(parcel, 2, g(), false);
        c.d.a.a.h.c.a(parcel, 3, h(), false);
        c.d.a.a.h.c.a(parcel, 4, d(), false);
        c.d.a.a.h.c.a(parcel, 5, c(), false);
        c.d.a.a.h.c.a(parcel, 6, (Parcelable) i(), i2, false);
        c.d.a.a.h.c.a(parcel, 7, j(), false);
        c.d.a.a.h.c.a(parcel, 8, this.f4061h);
        c.d.a.a.h.c.a(parcel, 9, this.f4062i, false);
        c.d.a.a.h.c.a(parcel, 10, (List) this.j, false);
        c.d.a.a.h.c.a(parcel, 11, f(), false);
        c.d.a.a.h.c.a(parcel, 12, e(), false);
        c.d.a.a.h.c.c(parcel, a2);
    }
}
