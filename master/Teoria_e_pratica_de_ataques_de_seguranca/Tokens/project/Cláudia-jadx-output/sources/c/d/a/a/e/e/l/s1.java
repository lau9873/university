package c.d.a.a.e.e.l;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
/* loaded from: classes.dex */
public final class s1 extends Fragment implements a1 {
    public static WeakHashMap<a.b.g.a.g, WeakReference<s1>> c0 = new WeakHashMap<>();
    public Map<String, LifecycleCallback> Z = new a.b.g.j.a();
    public int a0 = 0;
    public Bundle b0;

    public static s1 a(a.b.g.a.g gVar) {
        s1 s1Var;
        WeakReference<s1> weakReference = c0.get(gVar);
        if (weakReference == null || (s1Var = weakReference.get()) == null) {
            try {
                s1 s1Var2 = (s1) gVar.f().a("SupportLifecycleFragmentImpl");
                if (s1Var2 == null || s1Var2.P()) {
                    s1Var2 = new s1();
                    a.b.g.a.q a2 = gVar.f().a();
                    a2.a(s1Var2, "SupportLifecycleFragmentImpl");
                    a2.b();
                }
                c0.put(gVar, new WeakReference<>(s1Var2));
                return s1Var2;
            } catch (ClassCastException e2) {
                throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e2);
            }
        }
        return s1Var;
    }

    @Override // android.support.v4.app.Fragment
    public final void U() {
        super.U();
        this.a0 = 5;
        for (LifecycleCallback lifecycleCallback : this.Z.values()) {
            lifecycleCallback.b();
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void Z() {
        super.Z();
        this.a0 = 3;
        for (LifecycleCallback lifecycleCallback : this.Z.values()) {
            lifecycleCallback.c();
        }
    }

    @Override // c.d.a.a.e.e.l.a1
    public final <T extends LifecycleCallback> T a(String str, Class<T> cls) {
        return cls.cast(this.Z.get(str));
    }

    @Override // android.support.v4.app.Fragment
    public final void a(int i2, int i3, Intent intent) {
        super.a(i2, i3, intent);
        for (LifecycleCallback lifecycleCallback : this.Z.values()) {
            lifecycleCallback.a(i2, i3, intent);
        }
    }

    @Override // c.d.a.a.e.e.l.a1
    public final void a(String str, LifecycleCallback lifecycleCallback) {
        if (this.Z.containsKey(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
            sb.append("LifecycleCallback with tag ");
            sb.append(str);
            sb.append(" already added to this fragment.");
            throw new IllegalArgumentException(sb.toString());
        }
        this.Z.put(str, lifecycleCallback);
        if (this.a0 > 0) {
            new Handler(Looper.getMainLooper()).post(new t1(this, lifecycleCallback, str));
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.a(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.Z.values()) {
            lifecycleCallback.a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void a0() {
        super.a0();
        this.a0 = 2;
        for (LifecycleCallback lifecycleCallback : this.Z.values()) {
            lifecycleCallback.d();
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void b0() {
        super.b0();
        this.a0 = 4;
        for (LifecycleCallback lifecycleCallback : this.Z.values()) {
            lifecycleCallback.e();
        }
    }

    @Override // c.d.a.a.e.e.l.a1
    public final /* synthetic */ Activity c() {
        return j();
    }

    @Override // android.support.v4.app.Fragment
    public final void c(Bundle bundle) {
        super.c(bundle);
        this.a0 = 1;
        this.b0 = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.Z.entrySet()) {
            entry.getValue().a(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.support.v4.app.Fragment
    public final void e(Bundle bundle) {
        super.e(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.Z.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().b(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }
}
