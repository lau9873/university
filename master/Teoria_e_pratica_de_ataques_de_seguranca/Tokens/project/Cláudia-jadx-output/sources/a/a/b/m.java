package a.a.b;

import a.a.b.c;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
/* compiled from: ReportFragment.java */
/* loaded from: classes.dex */
public class m extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public a f47a;

    /* compiled from: ReportFragment.java */
    /* loaded from: classes.dex */
    public interface a {
        void a();

        void b();

        void c();
    }

    public static void a(Activity activity) {
        FragmentManager fragmentManager = activity.getFragmentManager();
        if (fragmentManager.findFragmentByTag("android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag") == null) {
            fragmentManager.beginTransaction().add(new m(), "android.arch.lifecycle.LifecycleDispatcher.report_fragment_tag").commit();
            fragmentManager.executePendingTransactions();
        }
    }

    public final void b(a aVar) {
        if (aVar != null) {
            aVar.b();
        }
    }

    public final void c(a aVar) {
        if (aVar != null) {
            aVar.c();
        }
    }

    @Override // android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        a(this.f47a);
        a(c.a.ON_CREATE);
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        a(c.a.ON_DESTROY);
        this.f47a = null;
    }

    @Override // android.app.Fragment
    public void onPause() {
        super.onPause();
        a(c.a.ON_PAUSE);
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        b(this.f47a);
        a(c.a.ON_RESUME);
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        c(this.f47a);
        a(c.a.ON_START);
    }

    @Override // android.app.Fragment
    public void onStop() {
        super.onStop();
        a(c.a.ON_STOP);
    }

    public final void a(a aVar) {
        if (aVar != null) {
            aVar.a();
        }
    }

    public final void a(c.a aVar) {
        Activity activity = getActivity();
        if (activity instanceof g) {
            ((g) activity).a().a(aVar);
        } else if (activity instanceof e) {
            c a2 = ((e) activity).a();
            if (a2 instanceof f) {
                ((f) a2).a(aVar);
            }
        }
    }
}
