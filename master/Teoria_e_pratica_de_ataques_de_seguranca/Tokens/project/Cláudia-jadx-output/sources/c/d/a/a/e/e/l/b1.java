package c.d.a.a.e.e.l;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class b1 extends Fragment implements a1 {

    /* renamed from: d  reason: collision with root package name */
    public static WeakHashMap<Activity, WeakReference<b1>> f3268d = new WeakHashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, LifecycleCallback> f3269a = new a.b.g.j.a();

    /* renamed from: b  reason: collision with root package name */
    public int f3270b = 0;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f3271c;

    public static b1 a(Activity activity) {
        b1 b1Var;
        WeakReference<b1> weakReference = f3268d.get(activity);
        if (weakReference == null || (b1Var = weakReference.get()) == null) {
            try {
                b1 b1Var2 = (b1) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                if (b1Var2 == null || b1Var2.isRemoving()) {
                    b1Var2 = new b1();
                    activity.getFragmentManager().beginTransaction().add(b1Var2, "LifecycleFragmentImpl").commitAllowingStateLoss();
                }
                f3268d.put(activity, new WeakReference<>(b1Var2));
                return b1Var2;
            } catch (ClassCastException e2) {
                throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e2);
            }
        }
        return b1Var;
    }

    @Override // c.d.a.a.e.e.l.a1
    public final <T extends LifecycleCallback> T a(String str, Class<T> cls) {
        return cls.cast(this.f3269a.get(str));
    }

    @Override // c.d.a.a.e.e.l.a1
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (this.f3269a.containsKey(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
            sb.append("LifecycleCallback with tag ");
            sb.append(str);
            sb.append(" already added to this fragment.");
            throw new IllegalArgumentException(sb.toString());
        }
        this.f3269a.put(str, lifecycleCallback);
        if (this.f3270b > 0) {
            new Handler(Looper.getMainLooper()).post(new c1(this, lifecycleCallback, str));
        }
    }

    @Override // c.d.a.a.e.e.l.a1
    public final Activity c() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.f3269a.values()) {
            lifecycleCallback.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        for (LifecycleCallback lifecycleCallback : this.f3269a.values()) {
            lifecycleCallback.a(i2, i3, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f3270b = 1;
        this.f3271c = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f3269a.entrySet()) {
            entry.getValue().a(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f3270b = 5;
        for (LifecycleCallback lifecycleCallback : this.f3269a.values()) {
            lifecycleCallback.b();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f3270b = 3;
        for (LifecycleCallback lifecycleCallback : this.f3269a.values()) {
            lifecycleCallback.c();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.f3269a.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().b(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f3270b = 2;
        for (LifecycleCallback lifecycleCallback : this.f3269a.values()) {
            lifecycleCallback.d();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f3270b = 4;
        for (LifecycleCallback lifecycleCallback : this.f3269a.values()) {
            lifecycleCallback.e();
        }
    }
}
