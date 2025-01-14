package d.a.a.a.m.g;

import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import org.json.JSONObject;
/* compiled from: DefaultSettingsJsonTransform.java */
/* loaded from: classes.dex */
public class l implements w {
    @Override // d.a.a.a.m.g.w
    public u a(d.a.a.a.m.b.k kVar, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new u(a(kVar, optInt2, jSONObject), b(jSONObject.getJSONObject("app")), g(jSONObject.getJSONObject("session")), f(jSONObject.getJSONObject("prompt")), d(jSONObject.getJSONObject("features")), a(jSONObject.getJSONObject("analytics")), c(jSONObject.getJSONObject("beta")), optInt, optInt2);
    }

    public final e b(JSONObject jSONObject) {
        return new e(jSONObject.getString("identifier"), jSONObject.getString("status"), jSONObject.getString("url"), jSONObject.getString("reports_url"), jSONObject.optBoolean("update_required", false), (jSONObject.has("icon") && jSONObject.getJSONObject("icon").has("hash")) ? e(jSONObject.getJSONObject("icon")) : null);
    }

    public final g c(JSONObject jSONObject) {
        return new g(jSONObject.optString("update_endpoint", v.f4458a), jSONObject.optInt("update_suspend_duration", 3600));
    }

    public final n d(JSONObject jSONObject) {
        return new n(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false));
    }

    public final c e(JSONObject jSONObject) {
        return new c(jSONObject.getString("hash"), jSONObject.getInt(DatabaseFieldConfigLoader.FIELD_NAME_WIDTH), jSONObject.getInt("height"));
    }

    public final p f(JSONObject jSONObject) {
        return new p(jSONObject.optString("title", "Send Crash Report?"), jSONObject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
    }

    public final q g(JSONObject jSONObject) {
        return new q(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", 255), jSONObject.optBoolean("send_session_without_crash", false), jSONObject.optInt("max_complete_sessions_count", 4));
    }

    public final b a(JSONObject jSONObject) {
        return new b(jSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", 8000), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1), jSONObject.optBoolean("flush_on_background", true));
    }

    public final long a(d.a.a.a.m.b.k kVar, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return kVar.a() + (j * 1000);
    }
}
