package android.support.p065v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.p065v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000a.p006b.p030g.p039f.p040j.IMediaSession;
import p000a.p006b.p030g.p039f.p040j.MediaSessionCompatApi21;

/* renamed from: android.support.v4.media.session.MediaSessionCompat */
/* loaded from: classes.dex */
public class MediaSessionCompat {

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper */
    /* loaded from: classes.dex */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new C0620a();

        /* renamed from: a */
        public ResultReceiver f3603a;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$ResultReceiverWrapper$a */
        /* loaded from: classes.dex */
        public static class C0620a implements Parcelable.Creator<ResultReceiverWrapper> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }
        }

        public ResultReceiverWrapper(Parcel parcel) {
            this.f3603a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            this.f3603a.writeToParcel(parcel, i);
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token */
    /* loaded from: classes.dex */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new C0621a();

        /* renamed from: a */
        public final Object f3604a;

        /* renamed from: b */
        public IMediaSession f3605b;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$Token$a */
        /* loaded from: classes.dex */
        public static class C0621a implements Parcelable.Creator<Token> {
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
            public Token[] newArray(int i) {
                return new Token[i];
            }
        }

        public Token(Object obj) {
            this(obj, null, null);
        }

        /* renamed from: a */
        public IMediaSession m7375a() {
            return this.f3605b;
        }

        /* renamed from: a */
        public void m7373a(Bundle bundle) {
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
                Object obj2 = this.f3604a;
                if (obj2 == null) {
                    return token.f3604a == null;
                }
                Object obj3 = token.f3604a;
                if (obj3 == null) {
                    return false;
                }
                return obj2.equals(obj3);
            }
            return false;
        }

        public int hashCode() {
            Object obj = this.f3604a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f3604a, i);
            } else {
                parcel.writeStrongBinder((IBinder) this.f3604a);
            }
        }

        public Token(Object obj, IMediaSession iMediaSession, Bundle bundle) {
            this.f3604a = obj;
            this.f3605b = iMediaSession;
        }

        /* renamed from: a */
        public void m7374a(IMediaSession iMediaSession) {
            this.f3605b = iMediaSession;
        }
    }

    /* renamed from: a */
    public static void m7378a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem */
    /* loaded from: classes.dex */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new C0619a();

        /* renamed from: a */
        public final MediaDescriptionCompat f3601a;

        /* renamed from: b */
        public final long f3602b;

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$QueueItem$a */
        /* loaded from: classes.dex */
        public static class C0619a implements Parcelable.Creator<QueueItem> {
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }
        }

        public QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            }
            if (j != -1) {
                this.f3601a = mediaDescriptionCompat;
                this.f3602b = j;
                return;
            }
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }

        /* renamed from: a */
        public static QueueItem m7377a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new QueueItem(obj, MediaDescriptionCompat.m7396a(MediaSessionCompatApi21.m9767a(obj)), MediaSessionCompatApi21.m9766b(obj));
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.f3601a + ", Id=" + this.f3602b + " }";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            this.f3601a.writeToParcel(parcel, i);
            parcel.writeLong(this.f3602b);
        }

        public QueueItem(Parcel parcel) {
            this.f3601a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f3602b = parcel.readLong();
        }

        /* renamed from: a */
        public static List<QueueItem> m7376a(List<?> list) {
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Iterator<?> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(m7377a(it.next()));
            }
            return arrayList;
        }
    }
}
