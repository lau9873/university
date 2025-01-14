package p000a.p006b.p030g.p045k;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: a.b.g.k.q */
/* loaded from: classes.dex */
public abstract class PagerAdapter {
    public PagerAdapter() {
        new DataSetObservable();
    }

    /* renamed from: a */
    public float m9477a(int i) {
        return 1.0f;
    }

    /* renamed from: a */
    public abstract int mo1193a();

    /* renamed from: a */
    public int m9470a(Object obj) {
        return -1;
    }

    /* renamed from: a */
    public abstract Object mo9472a(ViewGroup viewGroup, int i);

    /* renamed from: a */
    public void m9476a(DataSetObserver dataSetObserver) {
        synchronized (this) {
        }
    }

    /* renamed from: a */
    public abstract void mo9475a(Parcelable parcelable, ClassLoader classLoader);

    /* renamed from: a */
    public abstract void mo9473a(ViewGroup viewGroup);

    /* renamed from: a */
    public abstract void mo9471a(ViewGroup viewGroup, int i, Object obj);

    /* renamed from: a */
    public abstract boolean mo9474a(View view, Object obj);

    /* renamed from: b */
    public abstract Parcelable mo9469b();

    /* renamed from: b */
    public abstract void mo9468b(ViewGroup viewGroup);

    /* renamed from: b */
    public abstract void mo9467b(ViewGroup viewGroup, int i, Object obj);
}
