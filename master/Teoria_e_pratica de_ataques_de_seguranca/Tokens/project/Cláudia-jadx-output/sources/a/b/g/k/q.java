package a.b.g.k;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: PagerAdapter.java */
/* loaded from: classes.dex */
public abstract class q {
    public q() {
        new DataSetObservable();
    }

    public float a(int i2) {
        return 1.0f;
    }

    public abstract int a();

    public int a(Object obj) {
        return -1;
    }

    public abstract Object a(ViewGroup viewGroup, int i2);

    public void a(DataSetObserver dataSetObserver) {
        synchronized (this) {
        }
    }

    public abstract void a(Parcelable parcelable, ClassLoader classLoader);

    public abstract void a(ViewGroup viewGroup);

    public abstract void a(ViewGroup viewGroup, int i2, Object obj);

    public abstract boolean a(View view, Object obj);

    public abstract Parcelable b();

    public abstract void b(ViewGroup viewGroup);

    public abstract void b(ViewGroup viewGroup, int i2, Object obj);
}
