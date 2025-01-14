package p070c.p074b.p075a.p076b;

import android.app.Activity;
import android.os.Bundle;
import p070c.p074b.p075a.p076b.SessionEvent;
import p136d.p137a.p138a.p139a.ActivityLifecycleManager;

/* renamed from: c.b.a.b.g */
/* loaded from: classes.dex */
public class AnswersLifecycleCallbacks extends ActivityLifecycleManager.AbstractC1480b {

    /* renamed from: a */
    public final SessionAnalyticsManager f4678a;

    /* renamed from: b */
    public final BackgroundManager f4679b;

    public AnswersLifecycleCallbacks(SessionAnalyticsManager sessionAnalyticsManager, BackgroundManager backgroundManager) {
        this.f4678a = sessionAnalyticsManager;
        this.f4679b = backgroundManager;
    }

    @Override // p136d.p137a.p138a.p139a.ActivityLifecycleManager.AbstractC1480b
    /* renamed from: a */
    public void mo4224a(Activity activity) {
    }

    @Override // p136d.p137a.p138a.p139a.ActivityLifecycleManager.AbstractC1480b
    /* renamed from: a */
    public void mo4194a(Activity activity, Bundle bundle) {
    }

    @Override // p136d.p137a.p138a.p139a.ActivityLifecycleManager.AbstractC1480b
    /* renamed from: b */
    public void mo4223b(Activity activity) {
        this.f4678a.m6026a(activity, SessionEvent.EnumC0810c.PAUSE);
        this.f4679b.m6039b();
    }

    @Override // p136d.p137a.p138a.p139a.ActivityLifecycleManager.AbstractC1480b
    /* renamed from: b */
    public void mo4222b(Activity activity, Bundle bundle) {
    }

    @Override // p136d.p137a.p138a.p139a.ActivityLifecycleManager.AbstractC1480b
    /* renamed from: c */
    public void mo4193c(Activity activity) {
        this.f4678a.m6026a(activity, SessionEvent.EnumC0810c.RESUME);
        this.f4679b.m6038c();
    }

    @Override // p136d.p137a.p138a.p139a.ActivityLifecycleManager.AbstractC1480b
    /* renamed from: d */
    public void mo4192d(Activity activity) {
        this.f4678a.m6026a(activity, SessionEvent.EnumC0810c.START);
    }

    @Override // p136d.p137a.p138a.p139a.ActivityLifecycleManager.AbstractC1480b
    /* renamed from: e */
    public void mo4221e(Activity activity) {
        this.f4678a.m6026a(activity, SessionEvent.EnumC0810c.STOP);
    }
}
