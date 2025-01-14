package android.support.v4.media.session;

import a.b.g.f.j.b;
import a.b.g.f.j.g;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class MediaSessionCompat {

    /* loaded from: classes.dex */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public ResultReceiver f2331a;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<ResultReceiverWrapper> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ResultReceiverWrapper[] newArray(int i2) {
                return new ResultReceiverWrapper[i2];
            }
        }

        public ResultReceiverWrapper(Parcel parcel) {
            this.f2331a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            this.f2331a.writeToParcel(parcel, i2);
        }
    }

    /* loaded from: classes.dex */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public final Object f2332a;

        /* renamed from: b  reason: collision with root package name */
        public b f2333b;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<Token> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Token createFromParcel(Parcel parcel) {
                Object readStrongBinder;
                if (Build.VERSION.SDK_INT >= 21) {
                    readStrongBinder = parcel.readParcelable(null);
                } else {
                    readStrongBinder = parcel.readStrongBinder();
                }
                return new Token(readStrongBinder);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Token[] newArray(int i2) {
                return new Token[i2];
            }
        }

        public Token(Object obj) {
            this(obj, null, null);
        }

        public b a() {
            return this.f2333b;
        }

        public void a(Bundle bundle) {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof Token) {
                Token token = (Token) obj;
                Object obj2 = this.f2332a;
                if (obj2 == null) {
                    return token.f2332a == null;
                }
                Object obj3 = token.f2332a;
                if (obj3 == null) {
                    return false;
                }
                return obj2.equals(obj3);
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.f2332a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f2332a, i2);
            } else {
                parcel.writeStrongBinder((IBinder) this.f2332a);
            }
        }

        public Token(Object obj, b bVar, Bundle bundle) {
            this.f2332a = obj;
            this.f2333b = bVar;
        }

        public void a(b bVar) {
            this.f2333b = bVar;
        }
    }

    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    /* loaded from: classes.dex */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new a();

        /* renamed from: a  reason: collision with root package name */
        public final MediaDescriptionCompat f2329a;

        /* renamed from: b  reason: collision with root package name */
        public final long f2330b;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<QueueItem> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public QueueItem[] newArray(int i2) {
                return new QueueItem[i2];
            }
        }

        public QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            }
            if (j != -1) {
                this.f2329a = mediaDescriptionCompat;
                this.f2330b = j;
                return;
            }
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }

        public static QueueItem a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new QueueItem(obj, MediaDescriptionCompat.a(g.a(obj)), g.b(obj));
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f2329a + ", Id=" + this.f2330b + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            this.f2329a.writeToParcel(parcel, i2);
            parcel.writeLong(this.f2330b);
        }

        public QueueItem(Parcel parcel) {
            this.f2329a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f2330b = parcel.readLong();
        }

        public static List<QueueItem> a(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(a(it.next()));
            }
            return arrayList;
        }
    }
}
