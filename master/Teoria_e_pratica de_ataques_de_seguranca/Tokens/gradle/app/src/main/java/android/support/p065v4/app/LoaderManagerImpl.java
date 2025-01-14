package android.support.p065v4.app;

import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.j256.ormlite.logger.Logger;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import p000a.p001a.p005b.LifecycleOwner;
import p000a.p001a.p005b.MutableLiveData;
import p000a.p001a.p005b.Observer;
import p000a.p001a.p005b.ViewModel;
import p000a.p001a.p005b.ViewModelProvider;
import p000a.p001a.p005b.ViewModelStore;
import p000a.p006b.p030g.p031a.LoaderManager;
import p000a.p006b.p030g.p032b.Loader;
import p000a.p006b.p030g.p044j.DebugUtils;
import p000a.p006b.p030g.p044j.SparseArrayCompat;

/* renamed from: android.support.v4.app.LoaderManagerImpl */
/* loaded from: classes.dex */
public class LoaderManagerImpl extends LoaderManager {

    /* renamed from: c */
    public static boolean f3535c = false;

    /* renamed from: a */
    public final LifecycleOwner f3536a;

    /* renamed from: b */
    public final LoaderViewModel f3537b;

    /* renamed from: android.support.v4.app.LoaderManagerImpl$LoaderViewModel */
    /* loaded from: classes.dex */
    public static class LoaderViewModel extends ViewModel {

        /* renamed from: b */
        public static final ViewModelProvider.InterfaceC0016a f3538b = new C0608a();

        /* renamed from: a */
        public SparseArrayCompat<C0609a> f3539a = new SparseArrayCompat<>();

        /* renamed from: android.support.v4.app.LoaderManagerImpl$LoaderViewModel$a */
        /* loaded from: classes.dex */
        public static class C0608a implements ViewModelProvider.InterfaceC0016a {
            @Override // p000a.p001a.p005b.ViewModelProvider.InterfaceC0016a
            /* renamed from: a */
            public <T extends ViewModel> T mo7430a(Class<T> cls) {
                return new LoaderViewModel();
            }
        }

        /* renamed from: a */
        public static LoaderViewModel m7433a(ViewModelStore viewModelStore) {
            return (LoaderViewModel) new ViewModelProvider(viewModelStore, f3538b).m11264a(LoaderViewModel.class);
        }

        /* renamed from: b */
        public void m7431b() {
            int m9600c = this.f3539a.m9600c();
            for (int i = 0; i < m9600c; i++) {
                this.f3539a.m9595f(i).m7421g();
            }
        }

        @Override // p000a.p001a.p005b.ViewModel
        /* renamed from: a */
        public void mo7434a() {
            super.mo7434a();
            int m9600c = this.f3539a.m9600c();
            for (int i = 0; i < m9600c; i++) {
                this.f3539a.m9595f(i).m7426a(true);
            }
            this.f3539a.m9606a();
        }

        /* renamed from: a */
        public void m7432a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f3539a.m9600c() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i = 0; i < this.f3539a.m9600c(); i++) {
                    C0609a m9595f = this.f3539a.m9595f(i);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f3539a.m9597d(i));
                    printWriter.print(": ");
                    printWriter.println(m9595f.toString());
                    m9595f.m7427a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    /* renamed from: android.support.v4.app.LoaderManagerImpl$b */
    /* loaded from: classes.dex */
    public static class C0610b<D> implements Observer<D> {
        /* renamed from: a */
        public void m7419a(String str, PrintWriter printWriter) {
            throw null;
        }

        /* renamed from: a */
        public boolean m7420a() {
            throw null;
        }

        /* renamed from: b */
        public void m7418b() {
            throw null;
        }
    }

    public LoaderManagerImpl(LifecycleOwner lifecycleOwner, ViewModelStore viewModelStore) {
        this.f3536a = lifecycleOwner;
        this.f3537b = LoaderViewModel.m7433a(viewModelStore);
    }

    @Override // p000a.p006b.p030g.p031a.LoaderManager
    /* renamed from: a */
    public void mo7436a() {
        this.f3537b.m7431b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((int) Logger.DEFAULT_FULL_MESSAGE_LENGTH);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        DebugUtils.m9667a(this.f3536a, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // p000a.p006b.p030g.p031a.LoaderManager
    @Deprecated
    /* renamed from: a */
    public void mo7435a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3537b.m7432a(str, fileDescriptor, printWriter, strArr);
    }

    /* renamed from: android.support.v4.app.LoaderManagerImpl$a */
    /* loaded from: classes.dex */
    public static class C0609a<D> extends MutableLiveData<D> implements Loader.InterfaceC0193b<D> {

        /* renamed from: k */
        public final int f3540k;

        /* renamed from: l */
        public final Bundle f3541l;

        /* renamed from: m */
        public final Loader<D> f3542m;

        /* renamed from: n */
        public LifecycleOwner f3543n;

        /* renamed from: o */
        public C0610b<D> f3544o;

        /* renamed from: p */
        public Loader<D> f3545p;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.arch.lifecycle.LiveData
        /* renamed from: a */
        public void mo7429a(Observer<? super D> observer) {
            super.mo7429a((Observer) observer);
            this.f3543n = null;
            this.f3544o = null;
        }

        @Override // p000a.p001a.p005b.MutableLiveData, android.arch.lifecycle.LiveData
        /* renamed from: b */
        public void mo7425b(D d) {
            super.mo7425b((C0609a<D>) d);
            Loader<D> loader = this.f3545p;
            if (loader != null) {
                loader.reset();
                this.f3545p = null;
            }
        }

        @Override // android.arch.lifecycle.LiveData
        /* renamed from: c */
        public void mo7424c() {
            if (LoaderManagerImpl.f3535c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.f3542m.startLoading();
        }

        @Override // android.arch.lifecycle.LiveData
        /* renamed from: d */
        public void mo7423d() {
            if (LoaderManagerImpl.f3535c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.f3542m.stopLoading();
        }

        /* renamed from: f */
        public Loader<D> m7422f() {
            return this.f3542m;
        }

        /* renamed from: g */
        public void m7421g() {
            LifecycleOwner lifecycleOwner = this.f3543n;
            C0610b<D> c0610b = this.f3544o;
            if (lifecycleOwner == null || c0610b == null) {
                return;
            }
            super.mo7429a((Observer) c0610b);
            m7953a(lifecycleOwner, c0610b);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.f3540k);
            sb.append(" : ");
            DebugUtils.m9667a(this.f3542m, sb);
            sb.append("}}");
            return sb.toString();
        }

        /* renamed from: a */
        public Loader<D> m7426a(boolean z) {
            if (LoaderManagerImpl.f3535c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.f3542m.cancelLoad();
            this.f3542m.abandon();
            C0610b<D> c0610b = this.f3544o;
            if (c0610b != null) {
                mo7429a((Observer) c0610b);
                if (z) {
                    c0610b.m7418b();
                    throw null;
                }
            }
            this.f3542m.unregisterListener(this);
            if (c0610b != null) {
                c0610b.m7420a();
                throw null;
            } else if (z) {
                this.f3542m.reset();
                return this.f3545p;
            } else {
                return this.f3542m;
            }
        }

        @Override // p000a.p006b.p030g.p032b.Loader.InterfaceC0193b
        /* renamed from: a */
        public void mo7428a(Loader<D> loader, D d) {
            if (LoaderManagerImpl.f3535c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                mo7425b((C0609a<D>) d);
                return;
            }
            if (LoaderManagerImpl.f3535c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            mo7947a((C0609a<D>) d);
        }

        /* renamed from: a */
        public void m7427a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.f3540k);
            printWriter.print(" mArgs=");
            printWriter.println(this.f3541l);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.f3542m);
            Loader<D> loader = this.f3542m;
            loader.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.f3544o == null) {
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(m7422f().dataToString(m7954a()));
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.println(m7945b());
                return;
            }
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.f3544o);
            C0610b<D> c0610b = this.f3544o;
            c0610b.m7419a(str + "  ", printWriter);
            throw null;
        }
    }
}
