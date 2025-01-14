package android.support.v4.media.session;

import a.b.g.f.j.h;
import a.b.g.f.j.i;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    public final int f2339a;

    /* renamed from: b  reason: collision with root package name */
    public final long f2340b;

    /* renamed from: c  reason: collision with root package name */
    public final long f2341c;

    /* renamed from: d  reason: collision with root package name */
    public final float f2342d;

    /* renamed from: e  reason: collision with root package name */
    public final long f2343e;

    /* renamed from: f  reason: collision with root package name */
    public final int f2344f;

    /* renamed from: g  reason: collision with root package name */
    public final CharSequence f2345g;

    /* renamed from: h  reason: collision with root package name */
    public final long f2346h;

    /* renamed from: i  reason: collision with root package name */
    public List<CustomAction> f2347i;
    public final long j;
    public final Bundle k;

    /* loaded from: classes.dex */
    public static class a implements Parcelable.Creator<PlaybackStateCompat> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat[] newArray(int i2) {
            return new PlaybackStateCompat[i2];
        }
    }

    public PlaybackStateCompat(int i2, long j, long j2, float f2, long j3, int i3, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f2339a = i2;
        this.f2340b = j;
        this.f2341c = j2;
        this.f2342d = f2;
        this.f2343e = j3;
        this.f2344f = i3;
        this.f2345g = charSequence;
        this.f2346h = j4;
        this.f2347i = new ArrayList(list);
        this.j = j5;
        this.k = bundle;
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> d2 = h.d(obj);
        if (d2 != null) {
            ArrayList arrayList2 = new ArrayList(d2.size());
            for (Object obj2 : d2) {
                arrayList2.add(CustomAction.a(obj2));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new PlaybackStateCompat(h.i(obj), h.h(obj), h.c(obj), h.g(obj), h.a(obj), 0, h.e(obj), h.f(obj), arrayList, h.b(obj), Build.VERSION.SDK_INT >= 22 ? i.a(obj) : null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f2339a + ", position=" + this.f2340b + ", buffered position=" + this.f2341c + ", speed=" + this.f2342d + ", updated=" + this.f2346h + ", actions=" + this.f2343e + ", error code=" + this.f2344f + ", error message=" + this.f2345g + ", custom actions=" + this.f2347i + ", active item id=" + this.j + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f2339a);
        parcel.writeLong(this.f2340b);
        parcel.writeFloat(this.f2342d);
        parcel.writeLong(this.f2346h);
        parcel.writeLong(this.f2341c);
        parcel.writeLong(this.f2343e);
        TextUtils.writeToParcel(this.f2345g, parcel, i2);
        parcel.writeTypedList(this.f2347i);
        parcel.writeLong(this.j);
        parcel.writeBundle(this.k);
        parcel.writeInt(this.f2344f);
    }

    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public final String f2348a;

        /* renamed from: b  reason: collision with root package name */
        public final CharSequence f2349b;

        /* renamed from: c  reason: collision with root package name */
        public final int f2350c;

        /* renamed from: d  reason: collision with root package name */
        public final Bundle f2351d;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<CustomAction> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CustomAction[] newArray(int i2) {
                return new CustomAction[i2];
            }
        }

        public CustomAction(String str, CharSequence charSequence, int i2, Bundle bundle) {
            this.f2348a = str;
            this.f2349b = charSequence;
            this.f2350c = i2;
            this.f2351d = bundle;
        }

        public static CustomAction a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new CustomAction(h.a.a(obj), h.a.d(obj), h.a.c(obj), h.a.b(obj));
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f2349b) + ", mIcon=" + this.f2350c + ", mExtras=" + this.f2351d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f2348a);
            TextUtils.writeToParcel(this.f2349b, parcel, i2);
            parcel.writeInt(this.f2350c);
            parcel.writeBundle(this.f2351d);
        }

        public CustomAction(Parcel parcel) {
            this.f2348a = parcel.readString();
            this.f2349b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f2350c = parcel.readInt();
            this.f2351d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f2339a = parcel.readInt();
        this.f2340b = parcel.readLong();
        this.f2342d = parcel.readFloat();
        this.f2346h = parcel.readLong();
        this.f2341c = parcel.readLong();
        this.f2343e = parcel.readLong();
        this.f2345g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f2347i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.j = parcel.readLong();
        this.k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f2344f = parcel.readInt();
    }
}
