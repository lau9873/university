package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final int f2322a;

    /* renamed from: b  reason: collision with root package name */
    public final float f2323b;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<RatingCompat> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RatingCompat[] newArray(int i2) {
            return new RatingCompat[i2];
        }
    }

    public RatingCompat(int i2, float f2) {
        this.f2322a = i2;
        this.f2323b = f2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f2322a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f2322a);
        sb.append(" rating=");
        float f2 = this.f2323b;
        sb.append(f2 < 0.0f ? "unrated" : String.valueOf(f2));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f2322a);
        parcel.writeFloat(this.f2323b);
    }
}
