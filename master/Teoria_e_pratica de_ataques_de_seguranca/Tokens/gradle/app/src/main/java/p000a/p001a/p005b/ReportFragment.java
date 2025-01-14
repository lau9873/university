package p000a.p001a.p005b;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import p000a.p001a.p005b.Lifecycle;

/* renamed from: a.a.b.m */
/* loaded from: classes.dex */
public class ReportFragment extends Fragment {

    /* renamed from: a */
    public InterfaceC0015a f46a;

    /* compiled from: ReportFragment.java */
    /* renamed from: a.a.b.m$a */
    /* loaded from: classes.dex */
    public interface InterfaceC0015a {
        /* renamed from: a */
        void m11267a();

        /* renamed from: b */
        void m11266b();

        /* renamed from: c */
        void m11265c();
    }

    /* renamed from: a */
    public static void m11270a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new ReportFragment(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    /* renamed from: b */
    public final void m11269b(InterfaceC0015a interfaceC0015a) {
        if (interfaceC0015a != null) {
            interfaceC0015a.m11266b();
        }
    }

    /* renamed from: c */
    public final void m11268c(InterfaceC0015a interfaceC0015a) {
        if (interfaceC0015a != null) {
            interfaceC0015a.m11265c();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        m11271a(this.f46a);
        m11272a(Lifecycle.EnumC0011a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        m11272a(Lifecycle.EnumC0011a.ON_DESTROY);
        this.f46a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        m11272a(Lifecycle.EnumC0011a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        m11269b(this.f46a);
        m11272a(Lifecycle.EnumC0011a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        m11268c(this.f46a);
        m11272a(Lifecycle.EnumC0011a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        m11272a(Lifecycle.EnumC0011a.ON_STOP);
    }

    /* renamed from: a */
    public final void m11271a(InterfaceC0015a interfaceC0015a) {
        if (interfaceC0015a != null) {
            interfaceC0015a.m11267a();
        }
    }

    /* renamed from: a */
    public final void m11272a(Lifecycle.EnumC0011a enumC0011a) {
        Activity activity = getActivity();
        if (activity instanceof LifecycleRegistryOwner) {
            ((LifecycleRegistryOwner) activity).mo7439a().m11297a(enumC0011a);
        } else if (activity instanceof LifecycleOwner) {
            Lifecycle mo7439a = ((LifecycleOwner) activity).mo7439a();
            if (mo7439a instanceof LifecycleRegistry) {
                ((LifecycleRegistry) mo7439a).m11297a(enumC0011a);
            }
        }
    }
}
