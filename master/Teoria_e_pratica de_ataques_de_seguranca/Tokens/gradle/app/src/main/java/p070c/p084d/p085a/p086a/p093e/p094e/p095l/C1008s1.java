package p070c.p084d.p085a.p086a.p093e.p094e.p095l;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.p065v4.app.Fragment;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.WeakHashMap;
import p000a.p006b.p030g.p031a.FragmentActivity;
import p000a.p006b.p030g.p031a.FragmentTransaction;
import p000a.p006b.p030g.p044j.ArrayMap;

/* renamed from: c.d.a.a.e.e.l.s1 */
/* loaded from: classes.dex */
public final class C1008s1 extends Fragment implements InterfaceC0935a1 {

    /* renamed from: c0 */
    public static WeakHashMap<FragmentActivity, WeakReference<C1008s1>> f5311c0 = new WeakHashMap<>();

    /* renamed from: Z */
    public Map<String, LifecycleCallback> f5312Z = new ArrayMap();

    /* renamed from: a0 */
    public int f5313a0 = 0;

    /* renamed from: b0 */
    public Bundle f5314b0;

    /* renamed from: a */
    public static C1008s1 m5381a(FragmentActivity fragmentActivity) {
        C1008s1 c1008s1;
        WeakReference<C1008s1> weakReference = f5311c0.get(fragmentActivity);
        if (weakReference == null || (c1008s1 = weakReference.get()) == null) {
            try {
                C1008s1 c1008s12 = (C1008s1) fragmentActivity.m10333f().mo10231a("SupportLifecycleFragmentImpl");
                if (c1008s12 == null || c1008s12.m7535P()) {
                    c1008s12 = new C1008s1();
                    FragmentTransaction mo10264a = fragmentActivity.m10333f().mo10264a();
                    mo10264a.mo10142a(c1008s12, "SupportLifecycleFragmentImpl");
                    mo10264a.mo10140b();
                }
                f5311c0.put(fragmentActivity, new WeakReference<>(c1008s12));
                return c1008s12;
            } catch (ClassCastException e) {
                throw new IllegalStateException("Fragment with tag SupportLifecycleFragmentImpl is not a SupportLifecycleFragmentImpl", e);
            }
        }
        return c1008s1;
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: U */
    public final void mo897U() {
        super.mo897U();
        this.f5313a0 = 5;
        for (LifecycleCallback lifecycleCallback : this.f5312Z.values()) {
            lifecycleCallback.m4345b();
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: Z */
    public final void mo873Z() {
        super.mo873Z();
        this.f5313a0 = 3;
        for (LifecycleCallback lifecycleCallback : this.f5312Z.values()) {
            lifecycleCallback.m4343c();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0935a1
    /* renamed from: a */
    public final <T extends LifecycleCallback> T mo5377a(String str, Class<T> cls) {
        return cls.cast(this.f5312Z.get(str));
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public final void mo1127a(int i, int i2, Intent intent) {
        super.mo1127a(i, i2, intent);
        for (LifecycleCallback lifecycleCallback : this.f5312Z.values()) {
            lifecycleCallback.mo4350a(i, i2, intent);
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0935a1
    /* renamed from: a */
    public final void mo5379a(String str, LifecycleCallback lifecycleCallback) {
        if (this.f5312Z.containsKey(str)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 59);
            sb.append("LifecycleCallback with tag ");
            sb.append(str);
            sb.append(" already added to this fragment.");
            throw new IllegalArgumentException(sb.toString());
        }
        this.f5312Z.put(str, lifecycleCallback);
        if (this.f5313a0 > 0) {
            new Handler(Looper.getMainLooper()).post(new RunnableC1012t1(this, lifecycleCallback, str));
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a */
    public final void mo5378a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.mo5378a(str, fileDescriptor, printWriter, strArr);
        for (LifecycleCallback lifecycleCallback : this.f5312Z.values()) {
            lifecycleCallback.mo4346a(str, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: a0 */
    public final void mo5376a0() {
        super.mo5376a0();
        this.f5313a0 = 2;
        for (LifecycleCallback lifecycleCallback : this.f5312Z.values()) {
            lifecycleCallback.mo4342d();
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: b0 */
    public final void mo883b0() {
        super.mo883b0();
        this.f5313a0 = 4;
        for (LifecycleCallback lifecycleCallback : this.f5312Z.values()) {
            lifecycleCallback.mo4341e();
        }
    }

    @Override // p070c.p084d.p085a.p086a.p093e.p094e.p095l.InterfaceC0935a1
    /* renamed from: c */
    public final /* synthetic */ Activity mo5374c() {
        return m7468j();
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: c */
    public final void mo728c(Bundle bundle) {
        super.mo728c(bundle);
        this.f5313a0 = 1;
        this.f5314b0 = bundle;
        for (Map.Entry<String, LifecycleCallback> entry : this.f5312Z.entrySet()) {
            entry.getValue().mo4348a(bundle != null ? bundle.getBundle(entry.getKey()) : null);
        }
    }

    @Override // android.support.p065v4.app.Fragment
    /* renamed from: e */
    public final void mo924e(Bundle bundle) {
        super.mo924e(bundle);
        if (bundle == null) {
            return;
        }
        for (Map.Entry<String, LifecycleCallback> entry : this.f5312Z.entrySet()) {
            Bundle bundle2 = new Bundle();
            entry.getValue().mo4344b(bundle2);
            bundle.putBundle(entry.getKey(), bundle2);
        }
    }
}
