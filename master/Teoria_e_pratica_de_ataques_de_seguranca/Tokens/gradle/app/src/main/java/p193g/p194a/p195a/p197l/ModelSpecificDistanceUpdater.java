package p193g.p194a.p195a.p197l;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;

/* renamed from: g.a.a.l.f */
/* loaded from: classes.dex */
public class ModelSpecificDistanceUpdater extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    public Context f8553a;

    /* renamed from: b */
    public DistanceConfigFetcher f8554b;

    /* renamed from: c */
    public InterfaceC1834a f8555c;

    /* compiled from: ModelSpecificDistanceUpdater.java */
    /* renamed from: g.a.a.l.f$a */
    /* loaded from: classes.dex */
    public interface InterfaceC1834a {
        /* renamed from: a */
        void mo2435a(String str, Exception exc, int i);
    }

    public ModelSpecificDistanceUpdater(Context context, String str, InterfaceC1834a interfaceC1834a) {
        this.f8553a = context;
        this.f8554b = new DistanceConfigFetcher(str, m2437d());
        this.f8555c = interfaceC1834a;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        this.f8554b.m2458d();
        InterfaceC1834a interfaceC1834a = this.f8555c;
        if (interfaceC1834a != null) {
            interfaceC1834a.mo2435a(this.f8554b.m2459c(), this.f8554b.m2461a(), this.f8554b.m2460b());
            return null;
        }
        return null;
    }

    /* renamed from: b */
    public final String m2439b() {
        return AndroidModel.m2462e().toString();
    }

    /* renamed from: c */
    public final String m2438c() {
        return this.f8553a.getPackageName();
    }

    /* renamed from: d */
    public final String m2437d() {
        return "Android Beacon Library;" + m2436e() + ";" + m2438c() + ";" + m2441a() + ";" + m2439b();
    }

    /* renamed from: e */
    public final String m2436e() {
        return "2.16.3";
    }

    /* renamed from: a */
    public final String m2441a() {
        return Settings.Secure.getString(this.f8553a.getContentResolver(), "android_id");
    }
}
