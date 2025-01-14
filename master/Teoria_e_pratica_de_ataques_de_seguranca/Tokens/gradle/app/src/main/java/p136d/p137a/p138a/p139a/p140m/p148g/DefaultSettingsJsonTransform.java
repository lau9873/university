package p136d.p137a.p138a.p139a.p140m.p148g;

import com.j256.ormlite.field.DatabaseFieldConfigLoader;
import org.json.JSONObject;
import p136d.p137a.p138a.p139a.p140m.p142b.CurrentTimeProvider;

/* renamed from: d.a.a.a.m.g.l */
/* loaded from: classes.dex */
public class DefaultSettingsJsonTransform implements SettingsJsonTransform {
    @Override // p136d.p137a.p138a.p139a.p140m.p148g.SettingsJsonTransform
    /* renamed from: a */
    public SettingsData mo3863a(CurrentTimeProvider currentTimeProvider, JSONObject jSONObject) {
        int optInt = jSONObject.optInt("settings_version", 0);
        int optInt2 = jSONObject.optInt("cache_duration", 3600);
        return new SettingsData(m3888a(currentTimeProvider, optInt2, jSONObject), m3886b(jSONObject.getJSONObject("app")), m3881g(jSONObject.getJSONObject("session")), m3882f(jSONObject.getJSONObject("prompt")), m3884d(jSONObject.getJSONObject("features")), m3887a(jSONObject.getJSONObject("analytics")), m3885c(jSONObject.getJSONObject("beta")), optInt, optInt2);
    }

    /* renamed from: b */
    public final AppSettingsData m3886b(JSONObject jSONObject) {
        return new AppSettingsData(jSONObject.getString("identifier"), jSONObject.getString("status"), jSONObject.getString("url"), jSONObject.getString("reports_url"), jSONObject.optBoolean("update_required", false), (jSONObject.has("icon") && jSONObject.getJSONObject("icon").has("hash")) ? m3883e(jSONObject.getJSONObject("icon")) : null);
    }

    /* renamed from: c */
    public final BetaSettingsData m3885c(JSONObject jSONObject) {
        return new BetaSettingsData(jSONObject.optString("update_endpoint", SettingsJsonConstants.f6664a), jSONObject.optInt("update_suspend_duration", 3600));
    }

    /* renamed from: d */
    public final FeaturesSettingsData m3884d(JSONObject jSONObject) {
        return new FeaturesSettingsData(jSONObject.optBoolean("prompt_enabled", false), jSONObject.optBoolean("collect_logged_exceptions", true), jSONObject.optBoolean("collect_reports", true), jSONObject.optBoolean("collect_analytics", false));
    }

    /* renamed from: e */
    public final AppIconSettingsData m3883e(JSONObject jSONObject) {
        return new AppIconSettingsData(jSONObject.getString("hash"), jSONObject.getInt(DatabaseFieldConfigLoader.FIELD_NAME_WIDTH), jSONObject.getInt("height"));
    }

    /* renamed from: f */
    public final PromptSettingsData m3882f(JSONObject jSONObject) {
        return new PromptSettingsData(jSONObject.optString("title", "Send Crash Report?"), jSONObject.optString("message", "Looks like we crashed! Please help us fix the problem by sending a crash report."), jSONObject.optString("send_button_title", "Send"), jSONObject.optBoolean("show_cancel_button", true), jSONObject.optString("cancel_button_title", "Don't Send"), jSONObject.optBoolean("show_always_send_button", true), jSONObject.optString("always_send_button_title", "Always Send"));
    }

    /* renamed from: g */
    public final SessionSettingsData m3881g(JSONObject jSONObject) {
        return new SessionSettingsData(jSONObject.optInt("log_buffer_size", 64000), jSONObject.optInt("max_chained_exception_depth", 8), jSONObject.optInt("max_custom_exception_events", 64), jSONObject.optInt("max_custom_key_value_pairs", 64), jSONObject.optInt("identifier_mask", 255), jSONObject.optBoolean("send_session_without_crash", false), jSONObject.optInt("max_complete_sessions_count", 4));
    }

    /* renamed from: a */
    public final AnalyticsSettingsData m3887a(JSONObject jSONObject) {
        return new AnalyticsSettingsData(jSONObject.optString("url", "https://e.crashlytics.com/spi/v2/events"), jSONObject.optInt("flush_interval_secs", 600), jSONObject.optInt("max_byte_size_per_file", 8000), jSONObject.optInt("max_file_count_per_send", 1), jSONObject.optInt("max_pending_send_file_count", 100), jSONObject.optBoolean("track_custom_events", true), jSONObject.optBoolean("track_predefined_events", true), jSONObject.optInt("sampling_rate", 1), jSONObject.optBoolean("flush_on_background", true));
    }

    /* renamed from: a */
    public final long m3888a(CurrentTimeProvider currentTimeProvider, long j, JSONObject jSONObject) {
        if (jSONObject.has("expires_at")) {
            return jSONObject.getLong("expires_at");
        }
        return currentTimeProvider.mo4007a() + (j * 1000);
    }
}
