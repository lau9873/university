package p000a.p006b.p030g.p041g;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import p000a.p006b.p030g.p041g.IResultReceiver;

/* renamed from: a.b.g.g.g */
/* loaded from: classes.dex */
public class ResultReceiver implements Parcelable {
    public static final Parcelable.Creator<ResultReceiver> CREATOR = new C0243a();

    /* renamed from: a */
    public final Handler f1473a = null;

    /* renamed from: b */
    public IResultReceiver f1474b;

    /* compiled from: ResultReceiver.java */
    /* renamed from: a.b.g.g.g$a */
    /* loaded from: classes.dex */
    public static class C0243a implements Parcelable.Creator<ResultReceiver> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResultReceiver createFromParcel(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ResultReceiver[] newArray(int i) {
            return new ResultReceiver[i];
        }
    }

    /* compiled from: ResultReceiver.java */
    /* renamed from: a.b.g.g.g$b */
    /* loaded from: classes.dex */
    public class BinderC0244b extends IResultReceiver.AbstractBinderC0239a {
        public BinderC0244b() {
        }

        @Override // p000a.p006b.p030g.p041g.IResultReceiver
        /* renamed from: a */
        public void mo9738a(int i, Bundle bundle) {
            ResultReceiver resultReceiver = ResultReceiver.this;
            Handler handler = resultReceiver.f1473a;
            if (handler != null) {
                handler.post(new RunnableC0245c(i, bundle));
            } else {
                resultReceiver.mo7398a(i, bundle);
            }
        }
    }

    /* compiled from: ResultReceiver.java */
    /* renamed from: a.b.g.g.g$c */
    /* loaded from: classes.dex */
    public class RunnableC0245c implements Runnable {

        /* renamed from: a */
        public final int f1476a;

        /* renamed from: b */
        public final Bundle f1477b;

        public RunnableC0245c(int i, Bundle bundle) {
            this.f1476a = i;
            this.f1477b = bundle;
        }

        @Override // java.lang.Runnable
        public void run() {
            ResultReceiver.this.mo7398a(this.f1476a, this.f1477b);
        }
    }

    public ResultReceiver(Parcel parcel) {
        this.f1474b = IResultReceiver.AbstractBinderC0239a.m9750a(parcel.readStrongBinder());
    }

    /* renamed from: a */
    public void mo7398a(int i, Bundle bundle) {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f1474b == null) {
                this.f1474b = new BinderC0244b();
            }
            parcel.writeStrongBinder(this.f1474b.asBinder());
        }
    }
}
