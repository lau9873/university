package c.a.a.o;

import c.a.a.k;
import com.android.volley.ParseError;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: JsonObjectRequest.java */
/* loaded from: classes.dex */
public class k extends l<JSONObject> {
    public k(int i2, String str, JSONObject jSONObject, k.b<JSONObject> bVar, k.a aVar) {
        super(i2, str, jSONObject == null ? null : jSONObject.toString(), bVar, aVar);
    }

    @Override // c.a.a.i
    public c.a.a.k<JSONObject> a(c.a.a.h hVar) {
        try {
            return c.a.a.k.a(new JSONObject(new String(hVar.f2769a, g.a(hVar.f2770b, "utf-8"))), g.a(hVar));
        } catch (UnsupportedEncodingException e2) {
            return c.a.a.k.a(new ParseError(e2));
        } catch (JSONException e3) {
            return c.a.a.k.a(new ParseError(e3));
        }
    }
}
