package c.g.a.a.a.d$b$g;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.Base64;
import c.g.a.a.a.d;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class b extends d.b.c {
    public b(Context context, JSONObject jSONObject, int i2, int i3) {
        super(context, jSONObject, i2, i3);
    }

    public final String a(boolean z) {
        if (z) {
            byte[] d2 = d.b.c.j().d();
            if (d2.length > 2) {
                d2 = Arrays.copyOfRange(d2, 2, d2.length);
            }
            return Base64.encodeToString(d2, 2);
        }
        return null;
    }

    public final byte[] a(boolean z, boolean z2, boolean z3) {
        byte[] bArr = {0};
        if (z) {
            bArr = new byte[]{1};
        }
        if (z2) {
            bArr = new byte[]{2};
        }
        if (z3) {
            bArr = new byte[]{4};
        }
        return (z2 && z3) ? new byte[]{6} : bArr;
    }

    @Override // c.g.a.a.a.d.b.c
    public boolean b(JSONObject jSONObject, int i2) {
        return true;
    }

    @Override // c.g.a.a.a.d.b.c
    public String f() {
        return "Update";
    }

    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    @Override // c.g.a.a.a.d.b.c
    public JSONObject g() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String encodeToString;
        String str7;
        JSONObject jSONObject = new JSONObject();
        byte b2 = 0;
        jSONObject.put("serverAnswered", false);
        jSONObject.put("serverContacted", false);
        jSONObject.put("updateAttempt", false);
        boolean m = m();
        boolean k = k();
        boolean l = l();
        boolean h2 = h();
        String optString = d().optString("actionAID");
        JSONArray optJSONArray = l ? d().optJSONArray("priorities") : null;
        if ((m && k) || ((m && l) || ((h2 && m) || ((h2 && l) || (h2 && k))))) {
            throw new Exception("this combination of sync options is illegal.  unregister? " + m + " cancel last event? " + k + " preselect " + l + "  autoupdate " + h2 + " ");
        } else if ((k || l) && (optString == null || optString.equals(""))) {
            throw new Exception("preselection and cancelling event require an AID to be provided");
        } else {
            if (h2) {
                if (!c.g.c.a.a.f.b().a("autoupdatesEnabled", true)) {
                    throw new com.spirtech.android.hce.calypso.d.e("autoupdates disabled", -128);
                }
                d.b.c.a(c().getApplicationContext()).a(c());
            }
            boolean a2 = d.b.c.a(c()).a();
            boolean b3 = d.b.c.j().b();
            if (a2 && b3) {
                byte[] a3 = a(m, k, l);
                int i2 = 2;
                String encodeToString2 = Base64.encodeToString(d.b.c.a(c()).b(a3), 2);
                String i3 = d.b.c.i();
                String a4 = a(m);
                try {
                    jSONObject.put("serverContacted", true);
                    str3 = "";
                } catch (Exception e2) {
                    e = e2;
                    str = "";
                }
                try {
                    JSONObject a5 = e().a(encodeToString2, null, i3, a4, optString, optJSONArray, (ContextWrapper) c());
                    if (l || k) {
                        a3 = new byte[]{0};
                    }
                    jSONObject.put("serverAnswered", true);
                    while (a5 != null && a5.optInt(DatabaseFieldConfigLoader.FIELD_NAME_ID) != 350) {
                        d.b.c.j().j();
                        int optInt = a5.optInt(DatabaseFieldConfigLoader.FIELD_NAME_ID);
                        if (optInt == 399) {
                            int optInt2 = a5.optInt("errorCode");
                            jSONObject.put("serverRefusal", optInt2);
                            throw new com.spirtech.android.hce.calypso.d.e("ANS_ERROR_399 " + optInt2, optInt2);
                        }
                        if (optInt == 304) {
                            long currentTimeMillis = System.currentTimeMillis();
                            jSONObject.put("updateAttempt", true);
                            byte[] b4 = d.b.c.j().b(Base64.decode(a5.getString("tamCert"), i2), Base64.decode(a5.getString("amAuth"), i2), Base64.decode(a5.getString("cmd"), i2));
                            if (k) {
                                d.b.c.j().b("{\"cancelTime\":" + currentTimeMillis + ", \"aid\":\"" + optString + "\"}");
                            }
                            String a6 = a(m);
                            String i4 = d.b.c.i();
                            if (b4[b2] != 0) {
                                jSONObject.put("updateExecution", (boolean) b2);
                                byte[] bArr = new byte[i2];
                                bArr[b2] = b4[1];
                                bArr[1] = b4[i2];
                                c.g.c.a.a.c.b(bArr);
                                int parseInt = Integer.parseInt(c.g.c.a.a.c.a(bArr), 16);
                                try {
                                    a5 = e().a(Base64.encodeToString(Arrays.copyOfRange(b4, 3, parseInt + 3), i2), Base64.encodeToString(Arrays.copyOfRange(b4, parseInt + 5, b4.length), i2), a6, i4, (ContextWrapper) c());
                                } catch (Exception e3) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("ANS_ERROR -2-");
                                    if (e3.getMessage() != null) {
                                        str6 = e3.getMessage();
                                    } else {
                                        str6 = str3 + e3;
                                    }
                                    sb.append(str6);
                                    throw new com.spirtech.android.hce.calypso.d.e(sb.toString(), -125);
                                }
                            } else {
                                str4 = str3;
                                if (k) {
                                    byte[] bArr2 = new byte[1];
                                    bArr2[b2] = b2;
                                    a3 = bArr2;
                                    encodeToString = Base64.encodeToString(d.b.c.a(c()).b(bArr2), i2);
                                } else {
                                    encodeToString = Base64.encodeToString(d.b.c.a(c()).b(a3), i2);
                                }
                                try {
                                    a5 = e().a(encodeToString, a6, i4, (ContextWrapper) c());
                                    jSONObject.put("updateExecution", true);
                                } catch (Exception e4) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("ANS_ERROR -3-");
                                    if (e4.getMessage() != null) {
                                        str7 = e4.getMessage();
                                    } else {
                                        str7 = str4 + e4;
                                    }
                                    sb2.append(str7);
                                    throw new com.spirtech.android.hce.calypso.d.e(sb2.toString(), -125);
                                }
                            }
                        } else {
                            str4 = str3;
                            if (optInt != 308) {
                                throw new com.spirtech.android.hce.calypso.d.e("Server answered data of unknown id " + a5 + " ", -131);
                            }
                            try {
                                a5 = e().b(Base64.encodeToString(d.b.c.j().b(a3), 2), a(true), d.b.c.i(), k ? optString : null, (ContextWrapper) c());
                            } catch (Exception e5) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("ANS_ERROR -4-");
                                if (e5.getMessage() != null) {
                                    str5 = e5.getMessage();
                                } else {
                                    str5 = str4 + e5;
                                }
                                sb3.append(str5);
                                throw new com.spirtech.android.hce.calypso.d.e(sb3.toString(), -125);
                            }
                        }
                        str3 = str4;
                        b2 = 0;
                        i2 = 2;
                    }
                    d.b.c.j().j();
                    if (a5 != null && a5.optInt(DatabaseFieldConfigLoader.FIELD_NAME_ID) == 350) {
                        jSONObject.put("noUpdateNoError", true);
                    }
                    e().b();
                    if (Build.VERSION.SDK_INT >= 19) {
                        c.g.c.a.a.b.a("updateAttempts", jSONObject, c());
                        return null;
                    }
                    return null;
                } catch (Exception e6) {
                    e = e6;
                    str = str3;
                    jSONObject.put("serverAnswered", false);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("ANS_ERROR -1-");
                    if (e.getMessage() != null) {
                        str2 = e.getMessage();
                    } else {
                        str2 = str + e;
                    }
                    sb4.append(str2);
                    throw new com.spirtech.android.hce.calypso.d.e(sb4.toString(), -125);
                }
            }
            throw new com.spirtech.android.hce.calypso.d.e("NOTENROLLED", -5);
        }
    }

    @Override // c.g.a.a.a.d.b.c
    public abstract boolean h();

    public abstract boolean k();

    public abstract boolean l();

    public abstract boolean m();
}
