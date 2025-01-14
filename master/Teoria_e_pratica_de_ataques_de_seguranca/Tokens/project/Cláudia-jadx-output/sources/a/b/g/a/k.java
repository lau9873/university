package a.b.g.a;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
/* compiled from: FragmentManager.java */
/* loaded from: classes.dex */
public abstract class k {

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public static abstract class b {
        public abstract void a(k kVar, Fragment fragment);

        public abstract void a(k kVar, Fragment fragment, Context context);

        public abstract void a(k kVar, Fragment fragment, Bundle bundle);

        public abstract void a(k kVar, Fragment fragment, View view, Bundle bundle);

        public abstract void b(k kVar, Fragment fragment);

        public abstract void b(k kVar, Fragment fragment, Context context);

        public abstract void b(k kVar, Fragment fragment, Bundle bundle);

        public abstract void c(k kVar, Fragment fragment);

        public abstract void c(k kVar, Fragment fragment, Bundle bundle);

        public abstract void d(k kVar, Fragment fragment);

        public abstract void d(k kVar, Fragment fragment, Bundle bundle);

        public abstract void e(k kVar, Fragment fragment);

        public abstract void f(k kVar, Fragment fragment);

        public abstract void g(k kVar, Fragment fragment);
    }

    /* compiled from: FragmentManager.java */
    /* loaded from: classes.dex */
    public interface c {
        void a();
    }

    public abstract q a();

    public abstract Fragment.f a(Fragment fragment);

    public abstract Fragment a(Bundle bundle, String str);

    public abstract Fragment a(String str);

    public abstract void a(int i2, int i3);

    public abstract void a(Bundle bundle, String str, Fragment fragment);

    public abstract void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract int b();

    public abstract List<Fragment> c();

    public abstract boolean d();

    public abstract void e();

    public abstract boolean f();
}
