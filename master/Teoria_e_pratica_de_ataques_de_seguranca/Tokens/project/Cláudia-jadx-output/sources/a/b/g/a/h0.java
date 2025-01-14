package a.b.g.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: TaskStackBuilder.java */
/* loaded from: classes.dex */
public final class h0 implements Iterable<Intent> {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList<Intent> f683a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public final Context f684b;

    /* compiled from: TaskStackBuilder.java */
    /* loaded from: classes.dex */
    public interface a {
        Intent e();
    }

    public h0(Context context) {
        this.f684b = context;
    }

    public static h0 a(Context context) {
        return new h0(context);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f683a.iterator();
    }

    public h0 a(Intent intent) {
        this.f683a.add(intent);
        return this;
    }

    public h0 a(Activity activity) {
        Intent e2 = activity instanceof a ? ((a) activity).e() : null;
        if (e2 == null) {
            e2 = w.a(activity);
        }
        if (e2 != null) {
            ComponentName component = e2.getComponent();
            if (component == null) {
                component = e2.resolveActivity(this.f684b.getPackageManager());
            }
            a(component);
            a(e2);
        }
        return this;
    }

    public h0 a(ComponentName componentName) {
        int size = this.f683a.size();
        try {
            Intent a2 = w.a(this.f684b, componentName);
            while (a2 != null) {
                this.f683a.add(size, a2);
                a2 = w.a(this.f684b, a2.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e2);
        }
    }

    public void a() {
        a((Bundle) null);
    }

    public void a(Bundle bundle) {
        if (!this.f683a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f683a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (a.b.g.b.b.a(this.f684b, intentArr, bundle)) {
                return;
            }
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f684b.startActivity(intent);
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
