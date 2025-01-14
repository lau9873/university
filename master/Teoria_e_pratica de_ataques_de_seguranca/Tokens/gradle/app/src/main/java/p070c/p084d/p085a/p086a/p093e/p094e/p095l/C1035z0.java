package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.app.Activity;
import p000a.p006b.p030g.p031a.FragmentActivity;
import p070c.p084d.p085a.p086a.p093e.p096f.C1049c0;

/* renamed from: c.d.a.a.e.e.l.z0 */
/* loaded from: classes.dex */
public final class C1035z0 {

    /* renamed from: a */
    public final Object f5367a;

    public C1035z0(Activity activity) {
        C1049c0.m5293a(activity, "Activity must not be null");
        this.f5367a = activity;
    }

    /* renamed from: a */
    public final boolean m5307a() {
        return this.f5367a instanceof FragmentActivity;
    }

    /* renamed from: b */
    public final boolean m5306b() {
        return this.f5367a instanceof Activity;
    }

    /* renamed from: c */
    public final Activity m5305c() {
        return (Activity) this.f5367a;
    }

    /* renamed from: d */
    public final FragmentActivity m5304d() {
        return (FragmentActivity) this.f5367a;
    }
}
