package a.b.d.q;

import a.b.h.j.j.k;
import a.b.h.j.j.p;
import a.b.h.j.j.v;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: BottomNavigationPresenter.java */
/* loaded from: classes.dex */
public class d implements p {

    /* renamed from: a  reason: collision with root package name */
    public a.b.h.j.j.h f280a;

    /* renamed from: b  reason: collision with root package name */
    public c f281b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f282c = false;

    /* renamed from: d  reason: collision with root package name */
    public int f283d;

    /* compiled from: BottomNavigationPresenter.java */
    /* loaded from: classes.dex */
    public static class a implements Parcelable {
        public static final Parcelable.Creator<a> CREATOR = new C0005a();

        /* renamed from: a  reason: collision with root package name */
        public int f284a;

        /* compiled from: BottomNavigationPresenter.java */
        /* renamed from: a.b.d.q.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0005a implements Parcelable.Creator<a> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public a[] newArray(int i2) {
                return new a[i2];
            }
        }

        public a() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f284a);
        }

        public a(Parcel parcel) {
            this.f284a = parcel.readInt();
        }
    }

    public void a(c cVar) {
        this.f281b = cVar;
    }

    @Override // a.b.h.j.j.p
    public void a(a.b.h.j.j.h hVar, boolean z) {
    }

    @Override // a.b.h.j.j.p
    public boolean a(a.b.h.j.j.h hVar, k kVar) {
        return false;
    }

    @Override // a.b.h.j.j.p
    public boolean a(v vVar) {
        return false;
    }

    public void b(boolean z) {
        this.f282c = z;
    }

    @Override // a.b.h.j.j.p
    public boolean b() {
        return false;
    }

    @Override // a.b.h.j.j.p
    public boolean b(a.b.h.j.j.h hVar, k kVar) {
        return false;
    }

    @Override // a.b.h.j.j.p
    public Parcelable c() {
        a aVar = new a();
        aVar.f284a = this.f281b.getSelectedItemId();
        return aVar;
    }

    @Override // a.b.h.j.j.p
    public void a(Context context, a.b.h.j.j.h hVar) {
        this.f280a = hVar;
        this.f281b.a(this.f280a);
    }

    @Override // a.b.h.j.j.p
    public void a(boolean z) {
        if (this.f282c) {
            return;
        }
        if (z) {
            this.f281b.a();
        } else {
            this.f281b.c();
        }
    }

    public void a(int i2) {
        this.f283d = i2;
    }

    @Override // a.b.h.j.j.p
    public int a() {
        return this.f283d;
    }

    @Override // a.b.h.j.j.p
    public void a(Parcelable parcelable) {
        if (parcelable instanceof a) {
            this.f281b.b(((a) parcelable).f284a);
        }
    }
}
