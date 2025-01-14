package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

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
import p000a.p006b.p030g.p044j.ArrayMap;

/* renamed from: c.d.a.a.e.e.l.b1 */
/* loaded from: classes.dex */
public final class FragmentC0939b1 extends Fragment implements InterfaceC0935a1 {

    /* renamed from: d */
    public static WeakHashMap<Activity, WeakReference<FragmentC0939b1>> f5143d = new WeakHashMap<>();

    /* renamed from: a */
    public Map<String, LifecycleCallback> f5144a = new ArrayMap();

    /* renamed from: b */
    public int f5145b = 0;

    /* renamed from: c */
    public Bundle f5146c;

    /* renamed from: a */
    public static FragmentC0939b1 m5544a(Activity activity) {
        FragmentC0939b1 fragmentC0939b1;
        WeakReference<FragmentC0939b1> weakReference = f5143d.get(activity);
        if (weakReference == null || (fragmentC0939b1 = weakReference.get()) == null) {
            try {
                FragmentC0939b1 fragmentC0939b12 = (FragmentC0939b1) activity.getFragmentManager().findFragmentByTag("LifecycleFragmentImpl");
                if (fragmentC0939b12 == null || fragmentC0939b12.isRemoving()) {
                    fragmentC0939b12 = new FragmentC0939b1();
                    activity.getFragmentManager().beginTransaction().add(fragmentC0939b12, "LifecycleFragmentImpl").commitAllowingStateLoss();
                }
                f5143d.put(activity, new WeakReference<>(fragmentC0939b12));
                return fragmentC0939b12;
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag LifecycleFragmentImpl is not a LifecycleFragmentImpl", e);
            }
        }
        return fragmentC0939b1;
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0935a1
    /* renamed from: a */
    public final <T extends LifecycleCallback> T mo5377a(String str, Class<T> cls) {
        return cls.cast(this.f5144a.get(str));
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0935a1
    /* renamed from: a */
    public final void mo5379a(String str, LifecycleCallback lifecycleCallback) {
        if (this.f5144a.containsKey(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
            sb.append("LifecycleCallback with tag ");
            sb.append(str);
            sb.append(" already added to this fragment.");
            throw new IllegalArgumentException(sb.toString());
        }
        this.f5144a.put(str, lifecycleCallback);
        if (this.f5145b > 0) {
            new Handler(Looper.getMainLooper()).post(new RunnableC0943c1(this, lifecycleCallback, str));
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0935a1
    /* renamed from: c */
    public final Activity mo5374c() {
        return getActivity();
    }

    @Override // android.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.f5144a.values()) {
            lifecycleCallback.mo4346a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        for (LifecycleCallback lifecycleCallback : this.f5144a.values()) {
            lifecycleCallback.mo4350a(i, i2, intent);
        }
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f5145b = 1;
        this.f5146c = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f5144a.entrySet()) {
            entry.getValue().mo4348a(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        this.f5145b = 5;
        for (LifecycleCallback lifecycleCallback : this.f5144a.values()) {
            lifecycleCallback.m4345b();
        }
    }

    @Override // android.app.Fragment
    public final void onResume() {
        super.onResume();
        this.f5145b = 3;
        for (LifecycleCallback lifecycleCallback : this.f5144a.values()) {
            lifecycleCallback.m4343c();
        }
    }

    @Override // android.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.f5144a.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().mo4344b(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }

    @Override // android.app.Fragment
    public final void onStart() {
        super.onStart();
        this.f5145b = 2;
        for (LifecycleCallback lifecycleCallback : this.f5144a.values()) {
            lifecycleCallback.mo4342d();
        }
    }

    @Override // android.app.Fragment
    public final void onStop() {
        super.onStop();
        this.f5145b = 4;
        for (LifecycleCallback lifecycleCallback : this.f5144a.values()) {
            lifecycleCallback.mo4341e();
        }
    }
}
