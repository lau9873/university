package p070c.p071a.p072a.p073o;

import com.android.volley.ParseError;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;
import p070c.p071a.p072a.NetworkResponse;
import p070c.p071a.p072a.Response;

/* renamed from: c.a.a.o.k */
/* loaded from: classes.dex */
public class JsonObjectRequest extends JsonRequest<JSONObject> {
    public JsonObjectRequest(int i, String str, JSONObject jSONObject, Response.InterfaceC0790b<JSONObject> interfaceC0790b, Response.InterfaceC0789a interfaceC0789a) {
        super(i, str, jSONObject == null ? null : jSONObject.toString(), interfaceC0790b, interfaceC0789a);
    }

    @Override // p070c.p071a.p072a.Request
    /* renamed from: a */
    public Response<JSONObject> mo6098a(NetworkResponse networkResponse) {
        try {
            return Response.m6177a(new JSONObject(new String(networkResponse.f4559a, HttpHeaderParser.m6115a(networkResponse.f4560b, "utf-8"))), HttpHeaderParser.m6119a(networkResponse));
        } catch (UnsupportedEncodingException e) {
            return Response.m6178a(new ParseError(e));
        } catch (JSONException e2) {
            return Response.m6178a(new ParseError(e2));
        }
    }
}
