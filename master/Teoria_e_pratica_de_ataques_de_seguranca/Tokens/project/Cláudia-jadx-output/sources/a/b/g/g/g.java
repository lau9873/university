package a.b.g.g;

import a.b.g.g.b;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
/* compiled from: ResultReceiver.java */
/* loaded from: classes.dex */
public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final Handler f963a = null;

    /* renamed from: b  reason: collision with root package name */
    public a.b.g.g.b f964b;

    /* compiled from: ResultReceiver.java */
    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<g> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public g[] newArray(int i2) {
            return new g[i2];
        }
    }

    /* compiled from: ResultReceiver.java */
    /* loaded from: classes.dex */
    public class b extends b.a {
        public b() {
        }

        @Override // a.b.g.g.b
        public void a(int i2, Bundle bundle) {
            g gVar = g.this;
            Handler handler = gVar.f963a;
            if (handler != null) {
                handler.post(new c(i2, bundle));
            } else {
                gVar.a(i2, bundle);
            }
        }
    }

    /* compiled from: ResultReceiver.java */
    /* loaded from: classes.dex */
    public class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final int f966a;

        /* renamed from: b  reason: collision with root package name */
        public final Bundle f967b;

        public c(int i2, Bundle bundle) {
            this.f966a = i2;
            this.f967b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.a(this.f966a, this.f967b);
        }
    }

    public g(Parcel parcel) {
        this.f964b = b.a.a(parcel.readStrongBinder());
    }

    public void a(int i2, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        synchronized (this) {
            if (this.f964b == null) {
                this.f964b = new b();
            }
            parcel.writeStrongBinder(this.f964b.asBinder());
        }
    }
}
