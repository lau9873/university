package p000a.p006b.p030g.p031a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.p065v4.app.Fragment;
import android.util.Log;
import p000a.p001a.p005b.ViewModelStore;

/* renamed from: a.b.g.a.o */
/* loaded from: classes.dex */
public final class FragmentState implements Parcelable {
    public static final Parcelable.Creator<FragmentState> CREATOR = new C0171a();

    /* renamed from: a */
    public final String f1205a;

    /* renamed from: b */
    public final int f1206b;

    /* renamed from: c */
    public final boolean f1207c;

    /* renamed from: d */
    public final int f1208d;

    /* renamed from: e */
    public final int f1209e;

    /* renamed from: f */
    public final String f1210f;

    /* renamed from: g */
    public final boolean f1211g;

    /* renamed from: h */
    public final boolean f1212h;

    /* renamed from: i */
    public final Bundle f1213i;

    /* renamed from: j */
    public final boolean f1214j;

    /* renamed from: k */
    public Bundle f1215k;

    /* renamed from: m */
    public Fragment f1216m;

    /* compiled from: FragmentState.java */
    /* renamed from: a.b.g.a.o$a */
    /* loaded from: classes.dex */
    public static class C0171a implements Parcelable.Creator<FragmentState> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FragmentState createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FragmentState[] newArray(int i) {
            return new FragmentState[i];
        }
    }

    public FragmentState(Fragment fragment) {
        this.f1205a = fragment.getClass().getName();
        this.f1206b = fragment.f3491e;
        this.f1207c = fragment.f3499n;
        this.f1208d = fragment.f3510y;
        this.f1209e = fragment.f3511z;
        this.f1210f = fragment.f3464A;
        this.f1211g = fragment.f3467D;
        this.f1212h = fragment.f3466C;
        this.f1213i = fragment.f3493g;
        this.f1214j = fragment.f3465B;
    }

    /* renamed from: a */
    public Fragment m10147a(FragmentHostCallback fragmentHostCallback, FragmentContainer fragmentContainer, Fragment fragment, FragmentManagerNonConfig fragmentManagerNonConfig, ViewModelStore viewModelStore) {
        if (this.f1216m == null) {
            Context m10291c = fragmentHostCallback.m10291c();
            Bundle bundle = this.f1213i;
            if (bundle != null) {
                bundle.setClassLoader(m10291c.getClassLoader());
            }
            if (fragmentContainer != null) {
                this.f1216m = fragmentContainer.mo7440a(m10291c, this.f1205a, this.f1213i);
            } else {
                this.f1216m = Fragment.m7519a(m10291c, this.f1205a, this.f1213i);
            }
            Bundle bundle2 = this.f1215k;
            if (bundle2 != null) {
                bundle2.setClassLoader(m10291c.getClassLoader());
                this.f1216m.f3488b = this.f1215k;
            }
            this.f1216m.m7526a(this.f1206b, fragment);
            Fragment fragment2 = this.f1216m;
            fragment2.f3499n = this.f1207c;
            fragment2.f3501p = true;
            fragment2.f3510y = this.f1208d;
            fragment2.f3511z = this.f1209e;
            fragment2.f3464A = this.f1210f;
            fragment2.f3467D = this.f1211g;
            fragment2.f3466C = this.f1212h;
            fragment2.f3465B = this.f1214j;
            fragment2.f3504s = fragmentHostCallback.f1129d;
            if (LayoutInflater$Factory2C0152l.f1130F) {
                Log.v("FragmentManager", "Instantiated fragment " + this.f1216m);
            }
        }
        Fragment fragment3 = this.f1216m;
        fragment3.f3507v = fragmentManagerNonConfig;
        fragment3.f3508w = viewModelStore;
        return fragment3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1205a);
        parcel.writeInt(this.f1206b);
        parcel.writeInt(this.f1207c ? 1 : 0);
        parcel.writeInt(this.f1208d);
        parcel.writeInt(this.f1209e);
        parcel.writeString(this.f1210f);
        parcel.writeInt(this.f1211g ? 1 : 0);
        parcel.writeInt(this.f1212h ? 1 : 0);
        parcel.writeBundle(this.f1213i);
        parcel.writeInt(this.f1214j ? 1 : 0);
        parcel.writeBundle(this.f1215k);
    }

    public FragmentState(Parcel parcel) {
        this.f1205a = parcel.readString();
        this.f1206b = parcel.readInt();
        this.f1207c = parcel.readInt() != 0;
        this.f1208d = parcel.readInt();
        this.f1209e = parcel.readInt();
        this.f1210f = parcel.readString();
        this.f1211g = parcel.readInt() != 0;
        this.f1212h = parcel.readInt() != 0;
        this.f1213i = parcel.readBundle();
        this.f1214j = parcel.readInt() != 0;
        this.f1215k = parcel.readBundle();
    }
}
