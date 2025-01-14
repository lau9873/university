package p000a.p006b.p030g.p031a;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.p065v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;
import p000a.p006b.p030g.p031a.BackStackRecord;

/* compiled from: BackStackRecord.java */
/* renamed from: a.b.g.a.d */
/* loaded from: classes.dex */
public final class C0142d implements Parcelable {
    public static final Parcelable.Creator<C0142d> CREATOR = new C0143a();

    /* renamed from: a */
    public final int[] f1078a;

    /* renamed from: b */
    public final int f1079b;

    /* renamed from: c */
    public final int f1080c;

    /* renamed from: d */
    public final String f1081d;

    /* renamed from: e */
    public final int f1082e;

    /* renamed from: f */
    public final int f1083f;

    /* renamed from: g */
    public final CharSequence f1084g;

    /* renamed from: h */
    public final int f1085h;

    /* renamed from: i */
    public final CharSequence f1086i;

    /* renamed from: j */
    public final ArrayList<String> f1087j;

    /* renamed from: k */
    public final ArrayList<String> f1088k;

    /* renamed from: m */
    public final boolean f1089m;

    /* compiled from: BackStackRecord.java */
    /* renamed from: a.b.g.a.d$a */
    /* loaded from: classes.dex */
    public static class C0143a implements Parcelable.Creator<C0142d> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public C0142d createFromParcel(Parcel parcel) {
            return new C0142d(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public C0142d[] newArray(int i) {
            return new C0142d[i];
        }
    }

    public C0142d(BackStackRecord backStackRecord) {
        int size = backStackRecord.f1049b.size();
        this.f1078a = new int[size * 6];
        if (backStackRecord.f1056i) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                BackStackRecord.C0141a c0141a = backStackRecord.f1049b.get(i2);
                int[] iArr = this.f1078a;
                int i3 = i + 1;
                iArr[i] = c0141a.f1069a;
                int i4 = i3 + 1;
                Fragment fragment = c0141a.f1070b;
                iArr[i3] = fragment != null ? fragment.f3491e : -1;
                int[] iArr2 = this.f1078a;
                int i5 = i4 + 1;
                iArr2[i4] = c0141a.f1071c;
                int i6 = i5 + 1;
                iArr2[i5] = c0141a.f1072d;
                int i7 = i6 + 1;
                iArr2[i6] = c0141a.f1073e;
                i = i7 + 1;
                iArr2[i7] = c0141a.f1074f;
            }
            this.f1079b = backStackRecord.f1054g;
            this.f1080c = backStackRecord.f1055h;
            this.f1081d = backStackRecord.f1058k;
            this.f1082e = backStackRecord.f1060m;
            this.f1083f = backStackRecord.f1061n;
            this.f1084g = backStackRecord.f1062o;
            this.f1085h = backStackRecord.f1063p;
            this.f1086i = backStackRecord.f1064q;
            this.f1087j = backStackRecord.f1065r;
            this.f1088k = backStackRecord.f1066s;
            this.f1089m = backStackRecord.f1067t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    /* renamed from: a */
    public BackStackRecord m10362a(LayoutInflater$Factory2C0152l layoutInflater$Factory2C0152l) {
        BackStackRecord backStackRecord = new BackStackRecord(layoutInflater$Factory2C0152l);
        int i = 0;
        int i2 = 0;
        while (i < this.f1078a.length) {
            BackStackRecord.C0141a c0141a = new BackStackRecord.C0141a();
            int i3 = i + 1;
            c0141a.f1069a = this.f1078a[i];
            if (LayoutInflater$Factory2C0152l.f1130F) {
                Log.v("FragmentManager", "Instantiate " + backStackRecord + " op #" + i2 + " base fragment #" + this.f1078a[i3]);
            }
            int i4 = i3 + 1;
            int i5 = this.f1078a[i3];
            if (i5 >= 0) {
                c0141a.f1070b = layoutInflater$Factory2C0152l.f1143e.get(i5);
            } else {
                c0141a.f1070b = null;
            }
            int[] iArr = this.f1078a;
            int i6 = i4 + 1;
            c0141a.f1071c = iArr[i4];
            int i7 = i6 + 1;
            c0141a.f1072d = iArr[i6];
            int i8 = i7 + 1;
            c0141a.f1073e = iArr[i7];
            c0141a.f1074f = iArr[i8];
            backStackRecord.f1050c = c0141a.f1071c;
            backStackRecord.f1051d = c0141a.f1072d;
            backStackRecord.f1052e = c0141a.f1073e;
            backStackRecord.f1053f = c0141a.f1074f;
            backStackRecord.m10381a(c0141a);
            i2++;
            i = i8 + 1;
        }
        backStackRecord.f1054g = this.f1079b;
        backStackRecord.f1055h = this.f1080c;
        backStackRecord.f1058k = this.f1081d;
        backStackRecord.f1060m = this.f1082e;
        backStackRecord.f1056i = true;
        backStackRecord.f1061n = this.f1083f;
        backStackRecord.f1062o = this.f1084g;
        backStackRecord.f1063p = this.f1085h;
        backStackRecord.f1064q = this.f1086i;
        backStackRecord.f1065r = this.f1087j;
        backStackRecord.f1066s = this.f1088k;
        backStackRecord.f1067t = this.f1089m;
        backStackRecord.m10374b(1);
        return backStackRecord;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f1078a);
        parcel.writeInt(this.f1079b);
        parcel.writeInt(this.f1080c);
        parcel.writeString(this.f1081d);
        parcel.writeInt(this.f1082e);
        parcel.writeInt(this.f1083f);
        TextUtils.writeToParcel(this.f1084g, parcel, 0);
        parcel.writeInt(this.f1085h);
        TextUtils.writeToParcel(this.f1086i, parcel, 0);
        parcel.writeStringList(this.f1087j);
        parcel.writeStringList(this.f1088k);
        parcel.writeInt(this.f1089m ? 1 : 0);
    }

    public C0142d(Parcel parcel) {
        this.f1078a = parcel.createIntArray();
        this.f1079b = parcel.readInt();
        this.f1080c = parcel.readInt();
        this.f1081d = parcel.readString();
        this.f1082e = parcel.readInt();
        this.f1083f = parcel.readInt();
        this.f1084g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1085h = parcel.readInt();
        this.f1086i = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f1087j = parcel.createStringArrayList();
        this.f1088k = parcel.createStringArrayList();
        this.f1089m = parcel.readInt() != 0;
    }
}
