package c.b.a.b;

import android.annotation.TargetApi;
import android.os.Build;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: SessionEventTransform.java */
/* loaded from: classes.dex */
public class y implements d.a.a.a.m.d.a<w> {
    @Override // d.a.a.a.m.d.a
    /* renamed from: b */
    public byte[] a(w wVar) {
        return a2(wVar).toString().getBytes("UTF-8");
    }

    @TargetApi(9)
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public JSONObject a2(w wVar) {
        try {
            JSONObject jSONObject = new JSONObject();
            x xVar = wVar.f2912a;
            jSONObject.put("appBundleId", xVar.f2937a);
            jSONObject.put("executionId", xVar.f2938b);
            jSONObject.put("installationId", xVar.f2939c);
            jSONObject.put("androidId", xVar.f2940d);
            jSONObject.put("advertisingId", xVar.f2941e);
            jSONObject.put("limitAdTrackingEnabled", xVar.f2942f);
            jSONObject.put("betaDeviceToken", xVar.f2943g);
            jSONObject.put("buildId", xVar.f2944h);
            jSONObject.put("osVersion", xVar.f2945i);
            jSONObject.put("deviceModel", xVar.j);
            jSONObject.put("appVersionCode", xVar.k);
            jSONObject.put("appVersionName", xVar.l);
            jSONObject.put("timestamp", wVar.f2913b);
            jSONObject.put("type", wVar.f2914c.toString());
            if (wVar.f2915d != null) {
                jSONObject.put("details", new JSONObject(wVar.f2915d));
            }
            jSONObject.put("customType", wVar.f2916e);
            if (wVar.f2917f != null) {
                jSONObject.put("customAttributes", new JSONObject(wVar.f2917f));
            }
            jSONObject.put("predefinedType", wVar.f2918g);
            if (wVar.f2919h != null) {
                jSONObject.put("predefinedAttributes", new JSONObject(wVar.f2919h));
            }
            return jSONObject;
        } catch (JSONException e2) {
            if (Build.VERSION.SDK_INT >= 9) {
                throw new IOException(e2.getMessage(), e2);
            }
            throw new IOException(e2.getMessage());
        }
    }
}
