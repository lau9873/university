package p070c.p074b.p075a.p077c;

import org.json.JSONObject;

/* renamed from: c.b.a.c.g */
/* loaded from: classes.dex */
public class CheckForUpdatesResponseTransform {
    /* renamed from: a */
    public CheckForUpdatesResponse m5982a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new CheckForUpdatesResponse(jSONObject.optString("url", null), jSONObject.optString("version_string", null), jSONObject.optString("display_version", null), jSONObject.optString("build_version", null), jSONObject.optString("identifier", null), jSONObject.optString("instance_identifier", null));
    }
}
