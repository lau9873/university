package android.support.v4.app;

import a.a.b.e;
import a.a.b.j;
import a.a.b.k;
import a.a.b.n;
import a.a.b.o;
import a.a.b.p;
import a.b.g.a.v;
import a.b.g.b.c;
import a.b.g.j.d;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* loaded from: classes.dex */
public class LoaderManagerImpl extends v {

    /* renamed from: c  reason: collision with root package name */
    public static boolean f2270c = false;

    /* renamed from: a  reason: collision with root package name */
    public final e f2271a;

    /* renamed from: b  reason: collision with root package name */
    public final LoaderViewModel f2272b;

    /* loaded from: classes.dex */
    public static class LoaderViewModel extends n {

        /* renamed from: b  reason: collision with root package name */
        public static final o.a f2273b = new a();

        /* renamed from: a  reason: collision with root package name */
        public a.b.g.j.o<a> f2274a = new a.b.g.j.o<>();

        /* loaded from: classes.dex */
        public static class a implements o.a {
            @Override // a.a.b.o.a
            public <T extends n> T a(Class<T> cls) {
                return new LoaderViewModel();
            }
        }

        public static LoaderViewModel a(p pVar) {
            return (LoaderViewModel) new o(pVar, f2273b).a(LoaderViewModel.class);
        }

        public void b() {
            int c2 = this.f2274a.c();
            for (int i2 = 0; i2 < c2; i2++) {
                this.f2274a.f(i2).g();
            }
        }

        @Override // a.a.b.n
        public void a() {
            super.a();
            int c2 = this.f2274a.c();
            for (int i2 = 0; i2 < c2; i2++) {
                this.f2274a.f(i2).a(true);
            }
            this.f2274a.a();
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f2274a.c() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                for (int i2 = 0; i2 < this.f2274a.c(); i2++) {
                    a f2 = this.f2274a.f(i2);
                    printWriter.print(str);
                    printWriter.print("  #");
                    printWriter.print(this.f2274a.d(i2));
                    printWriter.print(": ");
                    printWriter.println(f2.toString());
                    f2.a(str2, fileDescriptor, printWriter, strArr);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static class b<D> implements k<D> {
        public void a(String str, PrintWriter printWriter) {
            throw null;
        }

        public boolean a() {
            throw null;
        }

        public void b() {
            throw null;
        }
    }

    public LoaderManagerImpl(e eVar, p pVar) {
        this.f2271a = eVar;
        this.f2272b = LoaderViewModel.a(pVar);
    }

    @Override // a.b.g.a.v
    public void a() {
        this.f2272b.b();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        d.a(this.f2271a, sb);
        sb.append("}}");
        return sb.toString();
    }

    @Override // a.b.g.a.v
    @Deprecated
    public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f2272b.a(str, fileDescriptor, printWriter, strArr);
    }

    /* loaded from: classes.dex */
    public static class a<D> extends j<D> implements c.b<D> {
        public final int k;
        public final Bundle l;
        public final c<D> m;
        public e n;
        public b<D> o;
        public c<D> p;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.arch.lifecycle.LiveData
        public void a(k<? super D> kVar) {
            super.a((k) kVar);
            this.n = null;
            this.o = null;
        }

        @Override // a.a.b.j, android.arch.lifecycle.LiveData
        public void b(D d2) {
            super.b((a<D>) d2);
            c<D> cVar = this.p;
            if (cVar != null) {
                cVar.reset();
                this.p = null;
            }
        }

        @Override // android.arch.lifecycle.LiveData
        public void c() {
            if (LoaderManagerImpl.f2270c) {
                Log.v("LoaderManager", "  Starting: " + this);
            }
            this.m.startLoading();
        }

        @Override // android.arch.lifecycle.LiveData
        public void d() {
            if (LoaderManagerImpl.f2270c) {
                Log.v("LoaderManager", "  Stopping: " + this);
            }
            this.m.stopLoading();
        }

        public c<D> f() {
            return this.m;
        }

        public void g() {
            e eVar = this.n;
            b<D> bVar = this.o;
            if (eVar == null || bVar == null) {
                return;
            }
            super.a((k) bVar);
            a(eVar, bVar);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.k);
            sb.append(" : ");
            d.a(this.m, sb);
            sb.append("}}");
            return sb.toString();
        }

        public c<D> a(boolean z) {
            if (LoaderManagerImpl.f2270c) {
                Log.v("LoaderManager", "  Destroying: " + this);
            }
            this.m.cancelLoad();
            this.m.abandon();
            b<D> bVar = this.o;
            if (bVar != null) {
                a((k) bVar);
                if (z) {
                    bVar.b();
                    throw null;
                }
            }
            this.m.unregisterListener(this);
            if (bVar != null) {
                bVar.a();
                throw null;
            } else if (z) {
                this.m.reset();
                return this.p;
            } else {
                return this.m;
            }
        }

        @Override // a.b.g.b.c.b
        public void a(c<D> cVar, D d2) {
            if (LoaderManagerImpl.f2270c) {
                Log.v("LoaderManager", "onLoadComplete: " + this);
            }
            if (Looper.myLooper() == Looper.getMainLooper()) {
                b((a<D>) d2);
                return;
            }
            if (LoaderManagerImpl.f2270c) {
                Log.w("LoaderManager", "onLoadComplete was incorrectly called on a background thread");
            }
            a((a<D>) d2);
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            printWriter.print(str);
            printWriter.print("mId=");
            printWriter.print(this.k);
            printWriter.print(" mArgs=");
            printWriter.println(this.l);
            printWriter.print(str);
            printWriter.print("mLoader=");
            printWriter.println(this.m);
            c<D> cVar = this.m;
            cVar.dump(str + "  ", fileDescriptor, printWriter, strArr);
            if (this.o == null) {
                printWriter.print(str);
                printWriter.print("mData=");
                printWriter.println(f().dataToString(a()));
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.println(b());
                return;
            }
            printWriter.print(str);
            printWriter.print("mCallbacks=");
            printWriter.println(this.o);
            b<D> bVar = this.o;
            bVar.a(str + "  ", printWriter);
            throw null;
        }
    }
}
