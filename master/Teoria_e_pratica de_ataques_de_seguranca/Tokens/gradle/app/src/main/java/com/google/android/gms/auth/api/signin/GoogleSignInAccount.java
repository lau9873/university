package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
import p070c.p084d.p085a.p086a.p089d.p090a.p091a.C0899b;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;
import p070c.p084d.p085a.p086a.p093e.p098h.C1100c;
import p070c.p084d.p085a.p086a.p093e.p098h.InterfaceC1099b;
import p070c.p084d.p085a.p086a.p102h.AbstractC1134a;
import p070c.p084d.p085a.p086a.p102h.C1140c;

/* loaded from: classes.dex */
public class GoogleSignInAccount extends AbstractC1134a implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new C0899b();

    /* renamed from: o */
    public static InterfaceC1099b f6088o = C1100c.m5142b();

    /* renamed from: a */
    public int f6089a;

    /* renamed from: b */
    public String f6090b;

    /* renamed from: c */
    public String f6091c;

    /* renamed from: d */
    public String f6092d;

    /* renamed from: e */
    public String f6093e;

    /* renamed from: f */
    public Uri f6094f;

    /* renamed from: g */
    public String f6095g;

    /* renamed from: h */
    public long f6096h;

    /* renamed from: i */
    public String f6097i;

    /* renamed from: j */
    public List<Scope> f6098j;

    /* renamed from: k */
    public String f6099k;

    /* renamed from: m */
    public String f6100m;

    /* renamed from: n */
    public Set<Scope> f6101n = new HashSet();

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, List<Scope> list, String str7, String str8) {
        this.f6089a = i;
        this.f6090b = str;
        this.f6091c = str2;
        this.f6092d = str3;
        this.f6093e = str4;
        this.f6094f = uri;
        this.f6095g = str5;
        this.f6096h = j;
        this.f6097i = str6;
        this.f6098j = list;
        this.f6099k = str7;
        this.f6100m = str8;
    }

    /* renamed from: a */
    public static GoogleSignInAccount m4390a(String str) {
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
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(jSONArray.getString(i)));
        }
        GoogleSignInAccount m4389a = m4389a(jSONObject.optString(DatabaseFieldConfigLoader.FIELD_NAME_ID), jSONObject.optString("tokenId", null), jSONObject.optString("email", null), jSONObject.optString("displayName", null), jSONObject.optString("givenName", null), jSONObject.optString("familyName", null), parse, Long.valueOf(parseLong), jSONObject.getString("obfuscatedIdentifier"), hashSet);
        m4389a.f6095g = jSONObject.optString("serverAuthCode", null);
        return m4389a;
    }

    /* renamed from: a */
    public static GoogleSignInAccount m4389a(String str, String str2, String str3, String str4, String str5, String str6, Uri uri, Long l, String str7, Set<Scope> set) {
        long longValue = (l == null ? Long.valueOf(f6088o.mo5143a() / 1000) : l).longValue();
        C1049c0.m5292a(str7);
        C1049c0.m5294a(set);
        return new GoogleSignInAccount(3, str, str2, str3, str4, uri, null, longValue, str7, new ArrayList(set), str5, str6);
    }

    /* renamed from: b */
    public Account m4388b() {
        String str = this.f6092d;
        if (str == null) {
            return null;
        }
        return new Account(str, "com.google");
    }

    /* renamed from: c */
    public String m4387c() {
        return this.f6093e;
    }

    /* renamed from: d */
    public String m4386d() {
        return this.f6092d;
    }

    /* renamed from: e */
    public String m4385e() {
        return this.f6100m;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof GoogleSignInAccount) {
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
            return googleSignInAccount.f6097i.equals(this.f6097i) && googleSignInAccount.m4379k().equals(m4379k());
        }
        return false;
    }

    /* renamed from: f */
    public String m4384f() {
        return this.f6099k;
    }

    /* renamed from: g */
    public String m4383g() {
        return this.f6090b;
    }

    /* renamed from: h */
    public String m4382h() {
        return this.f6091c;
    }

    public int hashCode() {
        return ((this.f6097i.hashCode() + 527) * 31) + m4379k().hashCode();
    }

    /* renamed from: i */
    public Uri m4381i() {
        return this.f6094f;
    }

    /* renamed from: j */
    public String m4380j() {
        return this.f6095g;
    }

    /* renamed from: k */
    public final Set<Scope> m4379k() {
        HashSet hashSet = new HashSet(this.f6098j);
        hashSet.addAll(this.f6101n);
        return hashSet;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int m5080a = C1140c.m5080a(parcel);
        C1140c.m5066b(parcel, 1, this.f6089a);
        C1140c.m5072a(parcel, 2, m4383g(), false);
        C1140c.m5072a(parcel, 3, m4382h(), false);
        C1140c.m5072a(parcel, 4, m4386d(), false);
        C1140c.m5072a(parcel, 5, m4387c(), false);
        C1140c.m5073a(parcel, 6, (Parcelable) m4381i(), i, false);
        C1140c.m5072a(parcel, 7, m4380j(), false);
        C1140c.m5076a(parcel, 8, this.f6096h);
        C1140c.m5072a(parcel, 9, this.f6097i, false);
        C1140c.m5071a(parcel, 10, (List) this.f6098j, false);
        C1140c.m5072a(parcel, 11, m4384f(), false);
        C1140c.m5072a(parcel, 12, m4385e(), false);
        C1140c.m5065c(parcel, m5080a);
    }
}
