package p000a.p006b.p030g.p039f.p040j;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.support.p065v4.media.MediaMetadataCompat;
import android.support.p065v4.media.session.MediaSessionCompat;
import android.support.p065v4.media.session.ParcelableVolumeInfo;
import android.support.p065v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import java.util.List;

/* renamed from: a.b.g.f.j.a */
/* loaded from: classes.dex */
public interface IMediaControllerCallback extends IInterface {

    /* compiled from: IMediaControllerCallback.java */
    /* renamed from: a.b.g.f.j.a$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0227a extends Binder implements IMediaControllerCallback {
        public AbstractBinderC0227a() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1598968902) {
                switch (i) {
                    case 1:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo9784a(parcel.readString(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 2:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo7379c();
                        return true;
                    case 3:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo9785a(parcel.readInt() != 0 ? PlaybackStateCompat.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 4:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo7383a(parcel.readInt() != 0 ? MediaMetadataCompat.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 5:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo7380a(parcel.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                        return true;
                    case 6:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo7381a(parcel.readInt() != 0 ? (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 7:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo7384a(parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 8:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo7382a(parcel.readInt() != 0 ? ParcelableVolumeInfo.CREATOR.createFromParcel(parcel) : null);
                        return true;
                    case 9:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo9786a(parcel.readInt());
                        return true;
                    case 10:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo9783a(parcel.readInt() != 0);
                        return true;
                    case 11:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo9781b(parcel.readInt() != 0);
                        return true;
                    case 12:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo9782b(parcel.readInt());
                        return true;
                    case 13:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        mo9780d();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i2);
                }
            }
            parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        }
    }

    /* renamed from: a */
    void mo9786a(int i);

    /* renamed from: a */
    void mo7384a(Bundle bundle);

    /* renamed from: a */
    void mo7383a(MediaMetadataCompat mediaMetadataCompat);

    /* renamed from: a */
    void mo7382a(ParcelableVolumeInfo parcelableVolumeInfo);

    /* renamed from: a */
    void mo9785a(PlaybackStateCompat playbackStateCompat);

    /* renamed from: a */
    void mo7381a(CharSequence charSequence);

    /* renamed from: a */
    void mo9784a(String str, Bundle bundle);

    /* renamed from: a */
    void mo7380a(List<MediaSessionCompat.QueueItem> list);

    /* renamed from: a */
    void mo9783a(boolean z);

    /* renamed from: b */
    void mo9782b(int i);

    /* renamed from: b */
    void mo9781b(boolean z);

    /* renamed from: c */
    void mo7379c();

    /* renamed from: d */
    void mo9780d();
}
