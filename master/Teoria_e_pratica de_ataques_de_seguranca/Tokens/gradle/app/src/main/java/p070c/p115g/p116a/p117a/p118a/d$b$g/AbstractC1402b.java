package p070c.p115g.p116a.p117a.p118a.d$b$g;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.util.Base64;
import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import com.spirtech.android.hce.calypso.p135d.C1476e;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;
import p070c.p115g.p116a.p117a.p118a.C1373d;
import p070c.p115g.p128c.p129a.p130a.C1424b;
import p070c.p115g.p128c.p129a.p130a.C1425c;
import p070c.p115g.p128c.p129a.p130a.C1429f;

/* renamed from: c.g.a.a.a.d$b$g.b */
/* loaded from: classes.dex */
public abstract class AbstractC1402b extends C1373d.InterfaceC1375b.AbstractC1377c {
    public AbstractC1402b(Context context, JSONObject jSONObject, int i, int i2) {
        super(context, jSONObject, i, i2);
    }

    /* renamed from: a */
    public final String m4598a(boolean z) {
        if (z) {
            byte[] m4527d = C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4527d();
            if (m4527d.length > 2) {
                m4527d = Arrays.copyOfRange(m4527d, 2, m4527d.length);
            }
            return Base64.encodeToString(m4527d, 2);
        }
        return null;
    }

    /* renamed from: a */
    public final byte[] m4597a(boolean z, boolean z2, boolean z3) {
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

    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: b */
    public boolean mo4564b(JSONObject jSONObject, int i) {
        return true;
    }

    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: f */
    public String mo4563f() {
        return "Update";
    }

    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: g */
    public JSONObject mo4562g() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String encodeToString;
        String str6;
        JSONObject jSONObject = new JSONObject();
        byte b = 0;
        jSONObject.put("serverAnswered", false);
        jSONObject.put("serverContacted", false);
        jSONObject.put("updateAttempt", false);
        boolean mo4594m = mo4594m();
        boolean mo4596k = mo4596k();
        boolean mo4595l = mo4595l();
        boolean mo4575h = mo4575h();
        String optString = m4577d().optString("actionAID");
        JSONArray optJSONArray = mo4595l ? m4577d().optJSONArray("priorities") : null;
        if ((mo4594m && mo4596k) || ((mo4594m && mo4595l) || ((mo4575h && mo4594m) || ((mo4575h && mo4595l) || (mo4575h && mo4596k))))) {
            throw new Exception("this combination of sync options is illegal.  unregister? " + mo4594m + " cancel last event? " + mo4596k + " preselect " + mo4595l + "  autoupdate " + mo4575h + " ");
        } else if ((mo4596k || mo4595l) && (optString == null || optString.equals(""))) {
            throw new Exception("preselection and cancelling event require an AID to be provided");
        } else {
            if (mo4575h) {
                if (!C1429f.m4445b().m4446a("autoupdatesEnabled", true)) {
                    throw new C1476e("autoupdates disabled", -128);
                }
                C1373d.InterfaceC1375b.AbstractC1377c.m4589a(m4578c().getApplicationContext()).m4540a(m4578c());
            }
            boolean m4542a = C1373d.InterfaceC1375b.AbstractC1377c.m4589a(m4578c()).m4542a();
            boolean m4534b = C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4534b();
            if (!m4542a || !m4534b) {
                throw new C1476e("NOTENROLLED", -5);
            }
            byte[] m4597a = m4597a(mo4594m, mo4596k, mo4595l);
            int i = 2;
            String encodeToString2 = Base64.encodeToString(C1373d.InterfaceC1375b.AbstractC1377c.m4589a(m4578c()).m4530b(m4597a), 2);
            String m4574i = C1373d.InterfaceC1375b.AbstractC1377c.m4574i();
            String m4598a = m4598a(mo4594m);
            try {
                jSONObject.put("serverContacted", true);
                String str7 = "";
                try {
                    JSONObject mo4622a = m4576e().mo4622a(encodeToString2, null, m4574i, m4598a, optString, optJSONArray, (ContextWrapper) m4578c());
                    if (mo4595l || mo4596k) {
                        m4597a = new byte[]{0};
                    }
                    jSONObject.put("serverAnswered", true);
                    while (mo4622a != null && mo4622a.optInt(DatabaseFieldConfigLoader.FIELD_NAME_ID) != 350) {
                        C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4521j();
                        int optInt = mo4622a.optInt(DatabaseFieldConfigLoader.FIELD_NAME_ID);
                        if (optInt == 399) {
                            int optInt2 = mo4622a.optInt("errorCode");
                            jSONObject.put("serverRefusal", optInt2);
                            throw new C1476e("ANS_ERROR_399 " + optInt2, optInt2);
                        }
                        if (optInt == 304) {
                            long currentTimeMillis = System.currentTimeMillis();
                            jSONObject.put("updateAttempt", true);
                            byte[] m4529b = C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4529b(Base64.decode(mo4622a.getString("tamCert"), i), Base64.decode(mo4622a.getString("amAuth"), i), Base64.decode(mo4622a.getString("cmd"), i));
                            if (mo4596k) {
                                C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4531b("{\"cancelTime\":" + currentTimeMillis + ", \"aid\":\"" + optString + "\"}");
                            }
                            String m4598a2 = m4598a(mo4594m);
                            String m4574i2 = C1373d.InterfaceC1375b.AbstractC1377c.m4574i();
                            if (m4529b[b] != 0) {
                                jSONObject.put("updateExecution", (boolean) b);
                                byte[] bArr = new byte[i];
                                bArr[b] = m4529b[1];
                                bArr[1] = m4529b[i];
                                C1425c.m4465b(bArr);
                                int parseInt = Integer.parseInt(C1425c.m4469a(bArr), 16);
                                try {
                                    mo4622a = m4576e().m4623a(Base64.encodeToString(Arrays.copyOfRange(m4529b, 3, parseInt + 3), i), Base64.encodeToString(Arrays.copyOfRange(m4529b, parseInt + 5, m4529b.length), i), m4598a2, m4574i2, (ContextWrapper) m4578c());
                                } catch (Exception e) {
                                    StringBuilder sb = new StringBuilder();
                                    sb.append("ANS_ERROR -2-");
                                    if (e.getMessage() != null) {
                                        str5 = e.getMessage();
                                    } else {
                                        str5 = str7 + e;
                                    }
                                    sb.append(str5);
                                    throw new C1476e(sb.toString(), -125);
                                }
                            } else {
                                str3 = str7;
                                if (mo4596k) {
                                    byte[] bArr2 = new byte[1];
                                    bArr2[b] = b;
                                    m4597a = bArr2;
                                    encodeToString = Base64.encodeToString(C1373d.InterfaceC1375b.AbstractC1377c.m4589a(m4578c()).m4530b(bArr2), i);
                                } else {
                                    encodeToString = Base64.encodeToString(C1373d.InterfaceC1375b.AbstractC1377c.m4589a(m4578c()).m4530b(m4597a), i);
                                }
                                try {
                                    mo4622a = m4576e().m4624a(encodeToString, m4598a2, m4574i2, (ContextWrapper) m4578c());
                                    jSONObject.put("updateExecution", true);
                                } catch (Exception e2) {
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("ANS_ERROR -3-");
                                    if (e2.getMessage() != null) {
                                        str6 = e2.getMessage();
                                    } else {
                                        str6 = str3 + e2;
                                    }
                                    sb2.append(str6);
                                    throw new C1476e(sb2.toString(), -125);
                                }
                            }
                        } else {
                            str3 = str7;
                            if (optInt != 308) {
                                throw new C1476e("Server answered data of unknown id " + mo4622a + " ", -131);
                            }
                            try {
                                mo4622a = m4576e().m4619b(Base64.encodeToString(C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4530b(m4597a), 2), m4598a(true), C1373d.InterfaceC1375b.AbstractC1377c.m4574i(), mo4596k ? optString : null, (ContextWrapper) m4578c());
                            } catch (Exception e3) {
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("ANS_ERROR -4-");
                                if (e3.getMessage() != null) {
                                    str4 = e3.getMessage();
                                } else {
                                    str4 = str3 + e3;
                                }
                                sb3.append(str4);
                                throw new C1476e(sb3.toString(), -125);
                            }
                        }
                        str7 = str3;
                        b = 0;
                        i = 2;
                    }
                    C1373d.InterfaceC1375b.AbstractC1377c.m4573j().m4521j();
                    if (mo4622a != null && mo4622a.optInt(DatabaseFieldConfigLoader.FIELD_NAME_ID) == 350) {
                        jSONObject.put("noUpdateNoError", true);
                    }
                    m4576e().mo4621b();
                    if (Build.VERSION.SDK_INT >= 19) {
                        C1424b.m4471a("updateAttempts", jSONObject, m4578c());
                        return null;
                    }
                    return null;
                } catch (Exception e4) {
                    e = e4;
                    str = str7;
                    jSONObject.put("serverAnswered", false);
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("ANS_ERROR -1-");
                    if (e.getMessage() != null) {
                        str2 = e.getMessage();
                    } else {
                        str2 = str + e;
                    }
                    sb4.append(str2);
                    throw new C1476e(sb4.toString(), -125);
                }
            } catch (Exception e5) {
                e = e5;
                str = "";
            }
        }
    }

    @Override // p070c.p115g.p116a.p117a.p118a.C1373d.InterfaceC1375b.AbstractC1377c
    /* renamed from: h */
    public abstract boolean mo4575h();

    /* renamed from: k */
    public abstract boolean mo4596k();

    /* renamed from: l */
    public abstract boolean mo4595l();

    /* renamed from: m */
    public abstract boolean mo4594m();
}
