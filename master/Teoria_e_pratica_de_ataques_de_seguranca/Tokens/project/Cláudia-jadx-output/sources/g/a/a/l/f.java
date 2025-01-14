package g.a.a.l;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.Settings;
/* compiled from: ModelSpecificDistanceUpdater.java */
/* loaded from: classes.dex */
public class f extends AsyncTask<Void, Void, Void> {

    /* renamed from: a  reason: collision with root package name */
    public Context f6091a;

    /* renamed from: b  reason: collision with root package name */
    public d f6092b;

    /* renamed from: c  reason: collision with root package name */
    public a f6093c;

    /* compiled from: ModelSpecificDistanceUpdater.java */
    /* loaded from: classes.dex */
    public interface a {
        void a(String str, Exception exc, int i2);
    }

    public f(Context context, String str, a aVar) {
        this.f6091a = context;
        this.f6092b = new d(str, d());
        this.f6093c = aVar;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Void doInBackground(Void... voidArr) {
        this.f6092b.d();
        a aVar = this.f6093c;
        if (aVar != null) {
            aVar.a(this.f6092b.c(), this.f6092b.a(), this.f6092b.b());
            return null;
        }
        return null;
    }

    public final String b() {
        return g.a.a.l.a.e().toString();
    }

    public final String c() {
        return this.f6091a.getPackageName();
    }

    public final String d() {
        return "Android Beacon Library;" + e() + ";" + c() + ";" + a() + ";" + b();
    }

    public final String e() {
        return "2.16.3";
    }

    public final String a() {
        return Settings.Secure.getString(this.f6091a.getContentResolver(), "android_id");
    }
}
