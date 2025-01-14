package p000a.p006b.p030g.p031a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import p000a.p006b.p030g.p032b.ContextCompat;

/* renamed from: a.b.g.a.h0 */
/* loaded from: classes.dex */
public final class TaskStackBuilder implements Iterable<Intent> {

    /* renamed from: a */
    public final ArrayList<Intent> f1123a = new ArrayList<>();

    /* renamed from: b */
    public final Context f1124b;

    /* compiled from: TaskStackBuilder.java */
    /* renamed from: a.b.g.a.h0$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0148a {
        /* renamed from: e */
        Intent mo9122e();
    }

    public TaskStackBuilder(Context context) {
        this.f1124b = context;
    }

    /* renamed from: a */
    public static TaskStackBuilder m10326a(Context context) {
        return new TaskStackBuilder(context);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f1123a.iterator();
    }

    /* renamed from: a */
    public TaskStackBuilder m10325a(Intent intent) {
        this.f1123a.add(intent);
        return this;
    }

    /* renamed from: a */
    public TaskStackBuilder m10328a(Activity activity) {
        Intent mo9122e = activity instanceof InterfaceC0148a ? ((InterfaceC0148a) activity).mo9122e() : null;
        if (mo9122e == null) {
            mo9122e = NavUtils.m10075a(activity);
        }
        if (mo9122e != null) {
            ComponentName component = mo9122e.getComponent();
            if (component == null) {
                component = mo9122e.resolveActivity(this.f1124b.getPackageManager());
            }
            m10327a(component);
            m10325a(mo9122e);
        }
        return this;
    }

    /* renamed from: a */
    public TaskStackBuilder m10327a(ComponentName componentName) {
        int size = this.f1123a.size();
        try {
            Intent m10073a = NavUtils.m10073a(this.f1124b, componentName);
            while (m10073a != null) {
                this.f1123a.add(size, m10073a);
                m10073a = NavUtils.m10073a(this.f1124b, m10073a.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    /* renamed from: a */
    public void m10329a() {
        m10324a((Bundle) null);
    }

    /* renamed from: a */
    public void m10324a(Bundle bundle) {
        if (!this.f1123a.isEmpty()) {
            ArrayList<Intent> arrayList = this.f1123a;
            Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
            intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
            if (ContextCompat.m10020a(this.f1124b, intentArr, bundle)) {
                return;
            }
            Intent intent = new Intent(intentArr[intentArr.length - 1]);
            intent.addFlags(268435456);
            this.f1124b.startActivity(intent);
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }
}
