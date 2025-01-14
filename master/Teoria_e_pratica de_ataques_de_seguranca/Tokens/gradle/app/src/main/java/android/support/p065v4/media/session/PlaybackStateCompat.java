package android.support.p065v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;
import p000a.p006b.p030g.p039f.p040j.PlaybackStateCompatApi21;
import p000a.p006b.p030g.p039f.p040j.PlaybackStateCompatApi22;

/* renamed from: android.support.v4.media.session.PlaybackStateCompat */
/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new C0624a();

    /* renamed from: a */
    public final int f3611a;

    /* renamed from: b */
    public final long f3612b;

    /* renamed from: c */
    public final long f3613c;

    /* renamed from: d */
    public final float f3614d;

    /* renamed from: e */
    public final long f3615e;

    /* renamed from: f */
    public final int f3616f;

    /* renamed from: g */
    public final CharSequence f3617g;

    /* renamed from: h */
    public final long f3618h;

    /* renamed from: i */
    public List<CustomAction> f3619i;

    /* renamed from: j */
    public final long f3620j;

    /* renamed from: k */
    public final Bundle f3621k;

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$a */
    /* loaded from: classes.dex */
    public static class C0624a implements Parcelable.Creator<PlaybackStateCompat> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PlaybackStateCompat[] newArray(int i) {
            return new PlaybackStateCompat[i];
        }
    }

    public PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, List<CustomAction> list, long j5, Bundle bundle) {
        this.f3611a = i;
        this.f3612b = j;
        this.f3613c = j2;
        this.f3614d = f;
        this.f3615e = j3;
        this.f3616f = i2;
        this.f3617g = charSequence;
        this.f3618h = j4;
        this.f3619i = new ArrayList(list);
        this.f3620j = j5;
        this.f3621k = bundle;
    }

    /* renamed from: a */
    public static PlaybackStateCompat m7372a(Object obj) {
        ArrayList arrayList;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> m9762d = PlaybackStateCompatApi21.m9762d(obj);
        if (m9762d != null) {
            ArrayList arrayList2 = new ArrayList(m9762d.size());
            for (Object obj2 : m9762d) {
                arrayList2.add(CustomAction.m7371a(obj2));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        return new PlaybackStateCompat(PlaybackStateCompatApi21.m9757i(obj), PlaybackStateCompatApi21.m9758h(obj), PlaybackStateCompatApi21.m9763c(obj), PlaybackStateCompatApi21.m9759g(obj), PlaybackStateCompatApi21.m9765a(obj), 0, PlaybackStateCompatApi21.m9761e(obj), PlaybackStateCompatApi21.m9760f(obj), arrayList, PlaybackStateCompatApi21.m9764b(obj), Build.VERSION.SDK_INT >= 22 ? PlaybackStateCompatApi22.m9752a(obj) : null);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f3611a + ", position=" + this.f3612b + ", buffered position=" + this.f3613c + ", speed=" + this.f3614d + ", updated=" + this.f3618h + ", actions=" + this.f3615e + ", error code=" + this.f3616f + ", error message=" + this.f3617g + ", custom actions=" + this.f3619i + ", active item id=" + this.f3620j + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3611a);
        parcel.writeLong(this.f3612b);
        parcel.writeFloat(this.f3614d);
        parcel.writeLong(this.f3618h);
        parcel.writeLong(this.f3613c);
        parcel.writeLong(this.f3615e);
        TextUtils.writeToParcel(this.f3617g, parcel, i);
        parcel.writeTypedList(this.f3619i);
        parcel.writeLong(this.f3620j);
        parcel.writeBundle(this.f3621k);
        parcel.writeInt(this.f3616f);
    }

    /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction */
    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new C0623a();

        /* renamed from: a */
        public final String f3622a;

        /* renamed from: b */
        public final CharSequence f3623b;

        /* renamed from: c */
        public final int f3624c;

        /* renamed from: d */
        public final Bundle f3625d;

        /* renamed from: android.support.v4.media.session.PlaybackStateCompat$CustomAction$a */
        /* loaded from: classes.dex */
        public static class C0623a implements Parcelable.Creator<CustomAction> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public CustomAction[] newArray(int i) {
                return new CustomAction[i];
            }
        }

        public CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.f3622a = str;
            this.f3623b = charSequence;
            this.f3624c = i;
            this.f3625d = bundle;
        }

        /* renamed from: a */
        public static CustomAction m7371a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new CustomAction(PlaybackStateCompatApi21.C0238a.m9756a(obj), PlaybackStateCompatApi21.C0238a.m9753d(obj), PlaybackStateCompatApi21.C0238a.m9754c(obj), PlaybackStateCompatApi21.C0238a.m9755b(obj));
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f3623b) + ", mIcon=" + this.f3624c + ", mExtras=" + this.f3625d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f3622a);
            TextUtils.writeToParcel(this.f3623b, parcel, i);
            parcel.writeInt(this.f3624c);
            parcel.writeBundle(this.f3625d);
        }

        public CustomAction(Parcel parcel) {
            this.f3622a = parcel.readString();
            this.f3623b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f3624c = parcel.readInt();
            this.f3625d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.f3611a = parcel.readInt();
        this.f3612b = parcel.readLong();
        this.f3614d = parcel.readFloat();
        this.f3618h = parcel.readLong();
        this.f3613c = parcel.readLong();
        this.f3615e = parcel.readLong();
        this.f3617g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f3619i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f3620j = parcel.readLong();
        this.f3621k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f3616f = parcel.readInt();
    }
}
