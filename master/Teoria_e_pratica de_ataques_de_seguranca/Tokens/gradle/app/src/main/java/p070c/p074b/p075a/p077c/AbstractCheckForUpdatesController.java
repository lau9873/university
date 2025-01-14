package p070c.p074b.p075a.p077c;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import p136d.p137a.p138a.p139a.Fabric;
import p136d.p137a.p138a.p139a.Logger;
import p136d.p137a.p138a.p139a.p140m.p142b.ApiKey;
import p136d.p137a.p138a.p139a.p140m.p142b.CurrentTimeProvider;
import p136d.p137a.p138a.p139a.p140m.p142b.IdManager;
import p136d.p137a.p138a.p139a.p140m.p146e.HttpRequestFactory;
import p136d.p137a.p138a.p139a.p140m.p147f.PreferenceStore;
import p136d.p137a.p138a.p139a.p140m.p148g.BetaSettingsData;

/* renamed from: c.b.a.c.a */
/* loaded from: classes.dex */
public abstract class AbstractCheckForUpdatesController implements UpdatesController {

    /* renamed from: a */
    public final AtomicBoolean f4759a;

    /* renamed from: b */
    public final AtomicBoolean f4760b;

    /* renamed from: c */
    public Context f4761c;

    /* renamed from: d */
    public Beta f4762d;

    /* renamed from: e */
    public IdManager f4763e;

    /* renamed from: f */
    public BetaSettingsData f4764f;

    /* renamed from: g */
    public BuildProperties f4765g;

    /* renamed from: h */
    public PreferenceStore f4766h;

    /* renamed from: i */
    public CurrentTimeProvider f4767i;

    /* renamed from: j */
    public HttpRequestFactory f4768j;

    /* renamed from: k */
    public long f4769k;

    public AbstractCheckForUpdatesController() {
        this(false);
    }

    @Override // p070c.p074b.p075a.p077c.UpdatesController
    /* renamed from: a */
    public void mo5979a(Context context, Beta beta, IdManager idManager, BetaSettingsData betaSettingsData, BuildProperties buildProperties, PreferenceStore preferenceStore, CurrentTimeProvider currentTimeProvider, HttpRequestFactory httpRequestFactory) {
        this.f4761c = context;
        this.f4762d = beta;
        this.f4763e = idManager;
        this.f4764f = betaSettingsData;
        this.f4765g = buildProperties;
        this.f4766h = preferenceStore;
        this.f4767i = currentTimeProvider;
        this.f4768j = httpRequestFactory;
        if (m5996e()) {
            m6001a();
        }
    }

    /* renamed from: b */
    public long m5999b() {
        return this.f4769k;
    }

    /* renamed from: c */
    public final void m5998c() {
        Fabric.m4197h().mo4157e("Beta", "Performing update check");
        Beta beta = this.f4762d;
        new CheckForUpdatesRequest(beta, beta.m5989p(), this.f4764f.f6622a, this.f4768j, new CheckForUpdatesResponseTransform()).m5984a(new ApiKey().m4115c(this.f4761c), this.f4763e.m4046g().get(IdManager.EnumC1497a.FONT_TOKEN), this.f4765g);
    }

    /* renamed from: d */
    public boolean m5997d() {
        this.f4760b.set(true);
        return this.f4759a.get();
    }

    /* renamed from: e */
    public boolean m5996e() {
        this.f4759a.set(true);
        return this.f4760b.get();
    }

    public AbstractCheckForUpdatesController(boolean z) {
        this.f4759a = new AtomicBoolean();
        this.f4769k = 0L;
        this.f4760b = new AtomicBoolean(z);
    }

    @SuppressLint({"CommitPrefEdits"})
    /* renamed from: a */
    public void m6001a() {
        synchronized (this.f4766h) {
            if (this.f4766h.get().contains("last_update_check")) {
                this.f4766h.mo3902a(this.f4766h.edit().remove("last_update_check"));
            }
        }
        long mo4007a = this.f4767i.mo4007a();
        long j = this.f4764f.f6623b * 1000;
        Logger m4197h = Fabric.m4197h();
        m4197h.mo4157e("Beta", "Check for updates delay: " + j);
        Logger m4197h2 = Fabric.m4197h();
        m4197h2.mo4157e("Beta", "Check for updates last check time: " + m5999b());
        long m5999b = m5999b() + j;
        Logger m4197h3 = Fabric.m4197h();
        m4197h3.mo4157e("Beta", "Check for updates current time: " + mo4007a + ", next check time: " + m5999b);
        if (mo4007a >= m5999b) {
            try {
                m5998c();
                return;
            } finally {
                m6000a(mo4007a);
            }
        }
        Fabric.m4197h().mo4157e("Beta", "Check for updates next check time was not passed");
    }

    /* renamed from: a */
    public void m6000a(long j) {
        this.f4769k = j;
    }
}
