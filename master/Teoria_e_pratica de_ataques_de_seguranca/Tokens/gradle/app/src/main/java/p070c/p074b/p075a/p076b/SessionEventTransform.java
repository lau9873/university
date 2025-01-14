package p070c.p074b.p075a.p076b;

import android.annotation.TargetApi;
import android.os.Build;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
import p136d.p137a.p138a.p139a.p140m.p145d.EventTransform;

/* renamed from: c.b.a.b.y */
/* loaded from: classes.dex */
public class SessionEventTransform implements EventTransform<SessionEvent> {
    @Override // p136d.p137a.p138a.p139a.p140m.p145d.EventTransform
    /* renamed from: b */
    public byte[] mo3957a(SessionEvent sessionEvent) {
        return m6004a(sessionEvent).toString().getBytes("UTF-8");
    }

    @TargetApi(9)
    /* renamed from: a  reason: avoid collision after fix types in other method */
    public JSONObject m6004a(SessionEvent sessionEvent) {
        try {
            JSONObject jSONObject = new JSONObject();
            SessionEventMetadata sessionEventMetadata = sessionEvent.f4717a;
            jSONObject.put("appBundleId", sessionEventMetadata.f4742a);
            jSONObject.put("executionId", sessionEventMetadata.f4743b);
            jSONObject.put("installationId", sessionEventMetadata.f4744c);
            jSONObject.put("androidId", sessionEventMetadata.f4745d);
            jSONObject.put("advertisingId", sessionEventMetadata.f4746e);
            jSONObject.put("limitAdTrackingEnabled", sessionEventMetadata.f4747f);
            jSONObject.put("betaDeviceToken", sessionEventMetadata.f4748g);
            jSONObject.put("buildId", sessionEventMetadata.f4749h);
            jSONObject.put("osVersion", sessionEventMetadata.f4750i);
            jSONObject.put("deviceModel", sessionEventMetadata.f4751j);
            jSONObject.put("appVersionCode", sessionEventMetadata.f4752k);
            jSONObject.put("appVersionName", sessionEventMetadata.f4753l);
            jSONObject.put("timestamp", sessionEvent.f4718b);
            jSONObject.put("type", sessionEvent.f4719c.toString());
            if (sessionEvent.f4720d != null) {
                jSONObject.put("details", new JSONObject(sessionEvent.f4720d));
            }
            jSONObject.put("customType", sessionEvent.f4721e);
            if (sessionEvent.f4722f != null) {
                jSONObject.put("customAttributes", new JSONObject(sessionEvent.f4722f));
            }
            jSONObject.put("predefinedType", sessionEvent.f4723g);
            if (sessionEvent.f4724h != null) {
                jSONObject.put("predefinedAttributes", new JSONObject(sessionEvent.f4724h));
            }
            return jSONObject;
        } catch (JSONException e) {
            if (Build.VERSION.SDK_INT >= 9) {
                throw new IOException(e.getMessage(), e);
            }
            throw new IOException(e.getMessage());
        }
    }
}
