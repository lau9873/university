package android.support.p065v4.media;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: android.support.v4.media.RatingCompat */
/* loaded from: classes.dex */
public final class RatingCompat implements Parcelable {
    public static final Parcelable.Creator<RatingCompat> CREATOR = new C0617a();

    /* renamed from: a */
    public final int f3594a;

    /* renamed from: b */
    public final float f3595b;

    /* renamed from: android.support.v4.media.RatingCompat$a */
    /* loaded from: classes.dex */
    public static class C0617a implements Parcelable.Creator<RatingCompat> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RatingCompat createFromParcel(Parcel parcel) {
            return new RatingCompat(parcel.readInt(), parcel.readFloat());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RatingCompat[] newArray(int i) {
            return new RatingCompat[i];
        }
    }

    public RatingCompat(int i, float f) {
        this.f3594a = i;
        this.f3595b = f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return this.f3594a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rating:style=");
        sb.append(this.f3594a);
        sb.append(" rating=");
        float f = this.f3595b;
        sb.append(f < 0.0f ? "unrated" : String.valueOf(f));
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3594a);
        parcel.writeFloat(this.f3595b);
    }
}
